package com.kfabija.meterreadings.dto.meter;

import java.io.Serializable;

public class MeterCreateDTO implements Serializable {
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
