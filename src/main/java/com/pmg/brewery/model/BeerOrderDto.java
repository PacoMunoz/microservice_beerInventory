package com.pmg.brewery.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerOrderDto implements Serializable {

    private static final long serialVersionUID = 1297823668042770811L;

    @Null
    private UUID id = null;

    @Null
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer version = null;

    @Null
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate = null;

    @Null
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate = null;

    @NotBlank
    private UUID customerId;

    private String customerRef;
    private List<BeerOrderLineDto> beerOrderLines;

    @Null
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String orderStatusEnum;
    private String orderStatusCallbackUrl;

}

