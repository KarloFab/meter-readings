package com.kfabija.meterreadings.service.mapper;

import com.kfabija.meterreadings.domain.Meter;
import com.kfabija.meterreadings.dto.meter.MeterCreateDTO;
import com.kfabija.meterreadings.dto.meter.MeterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeterMapper extends EntityMapper<MeterDTO, Meter>  {

    @Mapping(source = "client.id", target = "clientId")
    MeterDTO toDto(Meter meter);

    Meter createDtoToEntity(MeterCreateDTO meterCreateDTO);
}
