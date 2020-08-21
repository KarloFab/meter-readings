package com.kfabija.meterreadings.dto.client;

import com.kfabija.meterreadings.dto.AddressDTO;
import com.kfabija.meterreadings.dto.meter.MeterCreateDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ClientCreateDTO implements Serializable {

    @NotNull
    @Size(max = 50, min = 2, message = "First name should be between 2 and 50 characters")
    private String firstName;

    @NotNull
    @Size(max = 50, min = 2, message = "Last name should be between 2 and 50 characters")
    private String lastName;

    @NotNull
    private AddressDTO address;

    @NotNull
    private MeterCreateDTO meter;

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

