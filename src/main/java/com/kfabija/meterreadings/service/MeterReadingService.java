package com.kfabija.meterreadings.service;

import com.kfabija.meterreadings.dto.meter.reading.MeterReadingAggregatedDTO;
import com.kfabija.meterreadings.dto.meter.reading.MeterReadingCreateDTO;
import com.kfabija.meterreadings.dto.meter.reading.MeterReadingDTO;
import com.kfabija.meterreadings.enumeration.Month;

public interface MeterReadingService {

    MeterReadingDTO save(MeterReadingCreateDTO meterReadingCreateDTO);

    MeterReadingDTO findByYearOrMonthAndYear(Month month, Integer year);

    MeterReadingAggregatedDTO findAllByYearAggregated(Integer year);

}
