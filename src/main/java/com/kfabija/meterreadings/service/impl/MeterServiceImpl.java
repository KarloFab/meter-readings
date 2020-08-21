package com.kfabija.meterreadings.service.impl;

import com.kfabija.meterreadings.domain.Meter;
import com.kfabija.meterreadings.dto.meter.MeterDTO;
import com.kfabija.meterreadings.repository.MeterRepository;
import com.kfabija.meterreadings.service.MeterService;
import com.kfabija.meterreadings.service.mapper.MeterMapper;
import com.kfabija.meterreadings.web.rest.errors.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeterServiceImpl implements MeterService {

    private final MeterRepository meterRepository;

    private final MeterMapper meterMapper;

    public MeterServiceImpl(MeterRepository meterRepository, MeterMapper meterMapper) {
        this.meterRepository = meterRepository;
        this.meterMapper = meterMapper;
    }

    @Override
    public List<MeterDTO> findAll() {
        return meterRepository.findAll().stream().map(meterMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public MeterDTO findById(Long id) {
        Optional<Meter> meter = meterRepository.findById(id);
        if(!meter.isPresent()) {
            throw new EntityNotFoundException("Meter doesn't exist for id: " + id);
        }

        return meterMapper.toDto(meter.get());
    }
}
