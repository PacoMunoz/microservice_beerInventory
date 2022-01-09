package com.pmg.beerinventoryservice.web.controller;

import com.pmg.beerinventoryservice.web.model.BeerInventoryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class BeerInvetoryController {

    @GetMapping("/api/v1/beer/{beerId}/inventory")
    public List<BeerInventoryDto> listBeerById(@PathVariable UUID beerId) {

        List<BeerInventoryDto> result = Arrays.asList(BeerInventoryDto.builder()
                .beerId(UUID.randomUUID())
                .createDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .quantityOnHand(12)
                .upc("hola")
                .build());

        return result;
    }
}
