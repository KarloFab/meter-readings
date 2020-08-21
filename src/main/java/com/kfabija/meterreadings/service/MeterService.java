package com.kfabija.meterreadings.service;

import com.kfabija.meterreadings.dto.meter.MeterDTO;

import java.util.List;

public interface MeterService {

    List<MeterDTO> findAll();

    MeterDTO findById(Long id);
}
