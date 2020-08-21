package com.kfabija.meterreadings.web.rest;

import com.kfabija.meterreadings.MeterReadingsApplication;
import com.kfabija.meterreadings.domain.Meter;
import com.kfabija.meterreadings.domain.MeterReading;
import com.kfabija.meterreadings.dto.meter.reading.MeterReadingCreateDTO;
import com.kfabija.meterreadings.enumeration.Month;
import com.kfabija.meterreadings.repository.MeterReadingRepository;
import com.kfabija.meterreadings.repository.MeterRepository;
import com.kfabija.meterreadings.service.MeterReadingService;
import com.kfabija.meterreadings.service.mapper.MeterReadingMapper;
import com.kfabija.meterreadings.web.rest.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static com.kfabija.meterreadings.web.rest.util.TestUtil.APPLICATION_JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = MeterReadingsApplication.class)
public class MeterReadingTests {

    public static final double ELECTRICITY_CONSUMPTION = 20.2;
    public static final Month MONTH = Month.OCTOBER;
    public static final Month EXISTING_MONTH = Month.JANUARY;
    public static final Integer YEAR = 2020;


    @Autowired
    private MeterReadingRepository meterReadingRepository;

    @Autowired
    private MeterReadingMapper meterReadingMapper;

    @Autowired
    private MeterReadingService meterReadingService;

    @Autowired
    private MeterRepository meterRepository;

    @Autowired
    private EntityManager em;

    private MockMvc restMockMvc;

    private MeterReading meterReading;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MeterReadingResource meterReadingResource = new MeterReadingResource(meterReadingService);
        this.restMockMvc = MockMvcBuilders.standaloneSetup(meterReadingResource).build();
    }

    public static MeterReading createMeterReadingEntity() {
        MeterReading meterReading = new MeterReading();
        meterReading.setElectricityConsumption(ELECTRICITY_CONSUMPTION);
        meterReading.setMonth(MONTH);
        meterReading.setYear(YEAR);

        return meterReading;
    }

    public static Meter createMeterEntity() {
        Meter meter = new Meter();
        meter.setModel("TCZ-45A");

        return meter;
    }

    @BeforeEach
    public void initTest() {
        meterReading = createMeterReadingEntity();
        Meter meter = createMeterEntity();

        meter = meterRepository.save(meter);
        meterReading.setMeter(meter);
    }

    @Test
    @Transactional
    public void createMeterReading() throws Exception {
        int databaseSizeBeforeCreate = meterReadingRepository.findAll().size();

        // Create the Meter Reading
        MeterReadingCreateDTO meterReadingDTO = meterReadingMapper.entityToCreateDto(meterReading);

        restMockMvc.perform(post("/api/meter-readings")
                .contentType(APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(meterReadingDTO)))
                .andExpect(status().isCreated());

        // Validate the MeterReading in the database
        List<MeterReading> meterReadings = meterReadingRepository.findAll();
        assertThat(meterReadings).hasSize(databaseSizeBeforeCreate + 1);
        MeterReading testMeterReading = meterReadings.get(meterReadings.size() - 1);
        assertThat(testMeterReading.getElectricityConsumption()).isEqualTo(ELECTRICITY_CONSUMPTION);
        assertThat(testMeterReading.getMonth()).isEqualTo(MONTH);
        assertThat(testMeterReading.getYear()).isEqualTo(YEAR);

    }

    @Test
    @Transactional
    public void getAllMeterReadings() throws Exception {
        // Initialize the database
        meterReadingRepository.saveAndFlush(meterReading);

        // Get all the meter readings
       restMockMvc.perform(get("/api/meter-readings?year=2020"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.year").value(YEAR))
                .andExpect(jsonPath("$.meterReadings").exists());
    }

    @Test
    @Transactional
    public void createExistingMeterReadingShouldThrowError() throws Exception {

        // Create the Meter Reading
        meterReading.setMonth(EXISTING_MONTH);

        MeterReadingCreateDTO meterReadingDTO = meterReadingMapper.entityToCreateDto(meterReading);

        restMockMvc.perform(post("/api/meter-readings")
                .contentType(APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(meterReadingDTO)))
                .andExpect(status().is5xxServerError());
    }

}
