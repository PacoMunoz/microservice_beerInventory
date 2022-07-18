package com.pmg.beerinventoryservice.service;

import com.pmg.beerinventoryservice.repository.BeerInventoryRepository;
import com.pmg.beerinventoryservice.web.mapper.BeerInventoryMapper;
import com.pmg.brewery.model.BeerInventoryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BeerInventoryServiceImpl implements BeerInventoryService {


    private final BeerInventoryMapper beerInventoryMapper;

    private final BeerInventoryRepository beerInventoryRepository;

    public BeerInventoryServiceImpl(BeerInventoryMapper beerInventoryMapper, BeerInventoryRepository beerInventoryRepository) {
        this.beerInventoryMapper = beerInventoryMapper;
        this.beerInventoryRepository = beerInventoryRepository;
    }

    @Override
    public List<BeerInventoryDto> findAll() {
        List<BeerInventoryDto> res = new ArrayList<>();
        beerInventoryRepository.findAll().forEach( x -> {
            res.add(beerInventoryMapper.beerInventoryToBeerInventoryDto(x));
        });
        return res;
    }

    @Override
    public BeerInventoryDto findByBeerId(UUID beerId) {
        return beerInventoryMapper.beerInventoryToBeerInventoryDto(beerInventoryRepository
                .findByBeerId(beerId).orElse(null));
    }

    @Override
    public BeerInventoryDto findByUPC(String upc) {
        return beerInventoryMapper.beerInventoryToBeerInventoryDto(beerInventoryRepository.findByUpc(upc)
                .orElse(null));
    }
}
