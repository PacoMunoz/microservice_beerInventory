package com.pmg.beerinventoryservice.repository;

import com.pmg.beerinventoryservice.domain.BeerInventory;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BeerRepository extends CrudRepository<BeerInventory, UUID> {
}
