package com.kfabija.meterreadings.web.rest;

import com.kfabija.meterreadings.dto.client.ClientCreateDTO;
import com.kfabija.meterreadings.dto.client.ClientDTO;
import com.kfabija.meterreadings.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ClientResource {

    private final ClientService clientService;

    private final Logger log = LoggerFactory.getLogger(MeterResource.class);

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public ResponseEntity<ClientDTO> saveClient(@Valid @RequestBody ClientCreateDTO clientCreateDTO) {
        log.debug("REST request to save client");

        ClientDTO result = clientService.save(clientCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
