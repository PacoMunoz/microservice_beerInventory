package com.pmg.beerinventoryservice.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "beer_inventory")
public class BeerInventory extends BaseEntity{

    // es imprescindible indicar el tipo de dato para que la tabla creada automaticamente
    // para h2, ni no se indica el tipo, lo creara como tipo binario y por tanto cualquier
    // inserción inicial, por ejemplo usando un data.sql en resources fallara si se utiliza
    // un uuid. Ej: INSERT INTO Beer_Inventory (id, beer_Id, upc, quantity_On_Hand)
    //              values ('bf21a7e2-d747-47b9-8be2-88f093365a70' ...
    // entendera que le estas pasando un tipo String a un tipo binario y por tanto falla.
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false )
    private UUID beerId;
    private String upc;
    private Integer quantityOnHand = 0;

}
