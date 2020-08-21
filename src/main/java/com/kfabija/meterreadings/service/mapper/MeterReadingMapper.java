package com.kfabija.meterreadings.service.mapper;

import com.kfabija.meterreadings.domain.MeterReading;
import com.kfabija.meterreadings.dto.meter.reading.MeterReadingCreateDTO;
import com.kfabija.meterreadings.dto.meter.reading.MeterReadingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface MeterReadingMapper extends EntityMapper<MeterReadingDTO, MeterReading> {

    MeterReadingDTO toDto(MeterReading meterReading);

    MeterReading createDtoToEntity(MeterReadingCreateDTO meterReading);

    @Mapping(source = "meter.id", target = "meterId")
    MeterReadingCreateDTO entityToCreateDto(MeterReading meterReading);
}
