package com.kfabija.meterreadings.service.mapper;

import com.kfabija.meterreadings.domain.Address;
import com.kfabija.meterreadings.dto.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address>{
}
