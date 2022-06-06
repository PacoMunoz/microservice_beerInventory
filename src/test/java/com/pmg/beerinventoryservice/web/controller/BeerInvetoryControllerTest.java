package com.pmg.beerinventoryservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmg.beerinventoryservice.service.BeerInventoryService;
import com.pmg.beerinventoryservice.web.model.BeerInventoryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerInvetoryController.class)
class BeerInvetoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerInventoryService beerInventoryService;

    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final String BEER_1_UPC = "0631234200036";
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final String BEER_2_UPC = "0631234300019";

    BeerInventoryDto beerInventoryMock;
    BeerInventoryDto beerInventoryMock1;

    @BeforeEach
    void setup() {
        beerInventoryMock = BeerInventoryDto
                .builder()
                .beerId(BEER_1_UUID)
                .upc(BEER_1_UPC)
                .quantityOnHand(12)
                .build();
        beerInventoryMock1 = BeerInventoryDto
                .builder()
                .beerId(BEER_2_UUID)
                .upc(BEER_2_UPC)
                .quantityOnHand(10)
                .build();
    }


    @DisplayName("List all beer inventory")
    @Test
    void listAll() throws Exception{
        // given
        List<BeerInventoryDto> beerInventoryList = Arrays.asList(beerInventoryMock, beerInventoryMock1);
        given(beerInventoryService.findAll()).willReturn(beerInventoryList);

        mockMvc.perform(get("/api/v1/inventory")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // como se devuelven 2 elementos, se comprueba que se han devuelto los dos.
                .andExpect(jsonPath("$.*", hasSize(2)));

        then(beerInventoryService).should().findAll();
    }

    @Test
    void listBeerById() throws Exception {
        // given
        BeerInventoryDto beerInventory = beerInventoryMock;

        given(beerInventoryService.findByBeerId(any())).willReturn(beerInventory);

        mockMvc.perform(get("/api/v1/beer/" + beerInventory.getBeerId() + "/inventory")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // como solo devuelve un elemento, se comprueba que esta formado por 6 elementos.
                .andExpect(jsonPath("$.*", hasSize(6)))
                .andExpect(jsonPath("$.upc", is(BEER_1_UPC)));

        then(beerInventoryService).should().findByBeerId(any());

    }
}
