package com.juangp.inditex.infraestructure.web.controller;

import com.juangp.inditex.application.ports.in.PriceFindUseCase;
import com.juangp.inditex.domain.model.dto.FullPrice;
import com.juangp.inditex.domain.model.out.PricesResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesControllerTest {


    @Mock
    private PriceFindUseCase priceFindUseCase;

    @InjectMocks
    private PricesController pricesController;


    /**
     * Method under test: {@link PricesController#findPrice(Long brand, Long product, LocalDateTime date)}
     */
    @Test
    void testFindPrice_WithValidRequest_ShouldReturnOKResponse() {
        // Arrange
        LocalDateTime date = LocalDateTime.now();
        Long brand=1L;
        Long product= 1L;
        PricesResponse response = new PricesResponse(1L, 1L, 1L, date, date, new FullPrice("EUR", BigDecimal.valueOf(1)));
        when(priceFindUseCase.findPricesInditex(any(), any(), any())).thenReturn(response);
        // Act
        ResponseEntity<PricesResponse> result = pricesController.findPrice(brand, product,date);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(response, result.getBody());
    }


}
