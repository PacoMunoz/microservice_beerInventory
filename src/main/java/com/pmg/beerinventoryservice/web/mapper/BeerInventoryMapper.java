package com.pmg.beerinventoryservice.web.mapper;

import com.pmg.beerinventoryservice.domain.BeerInventory;
import com.pmg.brewery.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDto);

}
