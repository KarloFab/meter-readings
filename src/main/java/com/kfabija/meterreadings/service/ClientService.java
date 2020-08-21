package com.kfabija.meterreadings.service;

import com.kfabija.meterreadings.dto.client.ClientCreateDTO;
import com.kfabija.meterreadings.dto.client.ClientDTO;

public interface ClientService {

    ClientDTO save(ClientCreateDTO clientCreateDTO);
}
