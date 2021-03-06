package com.pmg.beerinventoryservice.service;

import com.pmg.brewery.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

public interface BeerInventoryService {

    List<BeerInventoryDto> findAll();

    BeerInventoryDto findByBeerId(UUID beerId);

    BeerInventoryDto findByUPC(String upc);

}
