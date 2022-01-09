package com.pmg.beerinventoryservice.bootstrap;

import com.pmg.beerinventoryservice.domain.BeerInventory;
import com.pmg.beerinventoryservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (beerRepository.count() == 0) {
            loadBeerRepositoryObjects();
        }
    }

    private void loadBeerRepositoryObjects() {
        beerRepository.save(BeerInventory.builder()
                .beerId(UUID.randomUUID())
                .quantityOnHand(12)
                .upc("BEER1_UPC")
                .build());
        beerRepository.save(BeerInventory.builder()
                .beerId(UUID.randomUUID())
                .quantityOnHand(10)
                .upc("BEER2_UPC")
                .build());
        beerRepository.save(BeerInventory.builder()
                .beerId(UUID.randomUUID())
                .quantityOnHand(20)
                .upc("BEER3_UPC")
                .build());

        beerRepository.findAll().forEach( beerInventory ->
                System.out.println(beerInventory.getBeerId() + " " +  beerInventory.getQuantityOnHand())
        );

    }
}
