package com.kfabija.meterreadings.dto.meter.reading;

public class MeterReadingAggregatedDTO {
    private Integer year;
    private Double electricityConsumptionAggregated;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getElectricityConsumptionAggregated() {
        return electricityConsumptionAggregated;
    }

    public void setElectricityConsumptionAggregated(Double electricityConsumptionAggregated) {
        this.electricityConsumptionAggregated = electricityConsumptionAggregated;
    }
}
