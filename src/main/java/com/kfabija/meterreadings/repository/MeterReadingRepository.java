package com.kfabija.meterreadings.repository;

import com.kfabija.meterreadings.domain.MeterReading;
import com.kfabija.meterreadings.enumeration.Month;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {

    MeterReading findByMonthAndYear(Month month, Integer year);

    List<MeterReading> findAllByYear(Integer year);
}
