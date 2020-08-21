package com.kfabija.meterreadings.dto.meter.reading;

import com.kfabija.meterreadings.enumeration.Month;

import java.io.Serializable;
import java.util.Map;

public class MeterReadingDTO implements Serializable {
    private Integer year;
    private Map<Month, Double> meterReadings;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Map<Month, Double> getMeterReadings() {
        return meterReadings;
    }

    public void setMeterReadings(Map<Month, Double> meterReadings) {
        this.meterReadings = meterReadings;
    }
}
