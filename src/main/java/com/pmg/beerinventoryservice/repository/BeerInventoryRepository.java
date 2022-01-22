package com.pmg.beerinventoryservice.repository;

import com.pmg.beerinventoryservice.domain.BeerInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {

    Optional<BeerInventory> findByBeerId(UUID beerId);
    Optional<BeerInventory> findByUpc(String upc);
}
