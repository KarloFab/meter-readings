package com.kfabija.meterreadings.dto.meter.reading;

import com.kfabija.meterreadings.enumeration.Month;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MeterReadingCreateDTO implements Serializable {
    private Integer year;

    private Month month;

    @NotNull
    private Long meterId;

    private Double electricityConsumption;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Double getElectricityConsumption() {
        return electricityConsumption;
    }

    public void setElectricityConsumption(Double electricityConsumption) {
        this.electricityConsumption = electricityConsumption;
    }

    public Long getMeterId() {
        return meterId;
    }

    public void setMeterId(Long meterId) {
        this.meterId = meterId;
    }
}
