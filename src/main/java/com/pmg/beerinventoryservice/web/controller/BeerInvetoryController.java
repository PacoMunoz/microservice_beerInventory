package com.pmg.beerinventoryservice.web.controller;

import com.pmg.beerinventoryservice.service.BeerInventoryService;
import com.pmg.brewery.model.BeerInventoryDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class BeerInvetoryController {

    private final BeerInventoryService beerInventoryService;

    /*@GetMapping("/api/v1/inventory")
    public List<BeerInventoryDto> listAll() {
        return beerInventoryService.findAll();
    }*/
    @GetMapping("/api/v1/inventory")
    public ResponseEntity<List<BeerInventoryDto>> listAll() {
        return new ResponseEntity<>(beerInventoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/beer/{beerId}/inventory")
    public BeerInventoryDto listBeerById(@PathVariable UUID beerId) {
        return beerInventoryService.findByBeerId(beerId);
    }

}
