package com.kfabija.meterreadings.web.rest;

import com.kfabija.meterreadings.dto.meter.MeterDTO;
import com.kfabija.meterreadings.service.MeterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MeterResource {

    private final Logger log = LoggerFactory.getLogger(MeterResource.class);

    private final MeterService meterService;

    public MeterResource(MeterService meterService) {
        this.meterService = meterService;
    }

    @GetMapping("/meters")
    public List<MeterDTO> getMeters() {
        log.debug("REST request to get all Meters");
        return meterService.findAll();
    }


    @GetMapping("/meters/{id}")
    public MeterDTO getMeterReadings(@PathVariable Long id) {
        log.debug("REST request to get Meter by id: " + id);
        return meterService.findById(id);
    }
}
