package com.kfabija.meterreadings.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "meter")
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "model")
    private String model;

    @OneToOne
    @JoinColumn(unique = true)
    private Client client;

    @OneToMany(mappedBy = "meter")
    private List<MeterReading> meterReadings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<MeterReading> getMeterReadings() {
        return meterReadings;
    }

    public void setMeterReadings(List<MeterReading> meterReadings) {
        this.meterReadings = meterReadings;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
