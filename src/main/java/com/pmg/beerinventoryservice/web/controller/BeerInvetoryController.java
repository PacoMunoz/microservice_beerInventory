package com.pmg.beerinventoryservice.web.controller;

import com.pmg.beerinventoryservice.domain.BeerInventory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class BeerInvetoryController {

    @GetMapping("/api/v1/beer/{beerId}/inventory")
    public List<BeerInventory> listBeerById(@PathVariable UUID beerId) {

        List<BeerInventory> result = Arrays.asList(
                BeerInventory.builder()
                .beerId(UUID.randomUUID())
                .quantityOnHand(12)
                .upc("Antonia")
                .build());

        return result;
    }
}
