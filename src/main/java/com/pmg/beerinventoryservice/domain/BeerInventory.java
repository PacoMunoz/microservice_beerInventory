package com.pmg.beerinventoryservice.domain;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BeerInventory {

    private UUID beerId;

    private String upc;
    private Integer quantityOnHand = 0;

}
