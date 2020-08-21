package com.kfabija.meterreadings.dto.client;

import com.kfabija.meterreadings.dto.AddressDTO;
import com.kfabija.meterreadings.dto.meter.MeterCreateDTO;

public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private AddressDTO address;
    private MeterCreateDTO meter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public MeterCreateDTO getMeter() {
        return meter;
    }

    public void setMeter(MeterCreateDTO meter) {
        this.meter = meter;
    }
}
