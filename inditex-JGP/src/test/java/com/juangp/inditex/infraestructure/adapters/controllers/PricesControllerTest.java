package com.juangp.inditex.infraestructure.adapters.controllers;

import com.juangp.inditex.application.ports.in.PriceFinder;
import com.juangp.inditex.domain.model.dto.FullPrice;
import com.juangp.inditex.domain.model.in.PricesRequest;
import com.juangp.inditex.domain.model.out.PricesResponse;
import com.juangp.inditex.domain.services.ValidateRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


class PricesControllerTest {


    @Mock
    private PriceFinder priceFinder;

    @Mock
    private ValidateRequestData validateRequestData;

    @InjectMocks
    private PricesController pricesController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Method under test: {@link PricesController#findPrice(PricesRequest)}
     */
    @Test
    void testFindPrice_WithValidRequest_ShouldReturnOKResponse() {
        // Arrange
        LocalDateTime date = LocalDateTime.now();
        PricesRequest request = new PricesRequest(1L, 1L, date);
        PricesResponse response = new PricesResponse(1L, 1L, 1L, date, date, new FullPrice("EUR", BigDecimal.valueOf(1)));
        when(priceFinder.findPricesInditex(any())).thenReturn(response);
        doNothing().when(validateRequestData).checkPricesRequest(any());
        // Act
        ResponseEntity<PricesResponse> result = pricesController.findPrice(request);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(response, result.getBody());
    }


}
