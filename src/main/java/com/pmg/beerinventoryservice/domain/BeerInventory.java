package com.pmg.beerinventoryservice.domain;

import lombok.*;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BeerInventory extends BaseEntity{

    private UUID beerId;
    private String upc;
    private Integer quantityOnHand = 0;

}
