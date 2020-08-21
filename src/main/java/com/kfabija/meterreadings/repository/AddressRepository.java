package com.kfabija.meterreadings.repository;

import com.kfabija.meterreadings.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByStreet(String street);
}
