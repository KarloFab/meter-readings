package com.kfabija.meterreadings.service.impl;

import com.kfabija.meterreadings.domain.Address;
import com.kfabija.meterreadings.domain.Client;
import com.kfabija.meterreadings.domain.Meter;
import com.kfabija.meterreadings.dto.client.ClientCreateDTO;
import com.kfabija.meterreadings.dto.client.ClientDTO;
import com.kfabija.meterreadings.repository.AddressRepository;
import com.kfabija.meterreadings.repository.ClientRepository;
import com.kfabija.meterreadings.repository.MeterRepository;
import com.kfabija.meterreadings.service.ClientService;
import com.kfabija.meterreadings.service.mapper.AddressMapper;
import com.kfabija.meterreadings.service.mapper.ClientMapper;
import com.kfabija.meterreadings.service.mapper.MeterMapper;
import com.kfabija.meterreadings.web.rest.errors.EntityExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    private final MeterMapper meterMapper;

    private final MeterRepository meterRepository;

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper, MeterMapper meterMapper,
                             MeterRepository meterRepository, AddressRepository addressRepository, AddressMapper addressMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.meterMapper = meterMapper;
        this.meterRepository = meterRepository;
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public ClientDTO save(ClientCreateDTO clientCreateDTO) {
        checkIfAddressAlreadyExists(clientCreateDTO.getAddress().getStreet());

        Client client = clientMapper.createDtoToEntity(clientCreateDTO);

        Address address = addressMapper.toEntity(clientCreateDTO.getAddress());
        address.setClient(client);

        Meter meter = meterMapper.createDtoToEntity(clientCreateDTO.getMeter());
        meter.setClient(client);

        Client newSavedClient = clientRepository.save(client);

        meterRepository.save(meter);
        addressRepository.save(address);

        newSavedClient.setAddress(address);
        newSavedClient.setMeter(meter);

        return clientMapper.toDto(newSavedClient);
    }

    private void checkIfAddressAlreadyExists(String street) {
        Optional<Address> existingAddress = addressRepository.findByStreet(street);
        if(existingAddress.isPresent()){
            throw new EntityExistsException(String.format("Address by street name: %s already exists!", street));
        }
    }
}
