package com.juangp.inditex.infraestructure.adapters.service;


import com.juangp.inditex.application.ports.out.FindPricesPort;
import com.juangp.inditex.domain.exception.TraductionDtoException;
import com.juangp.inditex.domain.model.dto.FullPrice;
import com.juangp.inditex.domain.model.dto.Prices;
import com.juangp.inditex.domain.model.in.PricesRequest;
import com.juangp.inditex.domain.model.out.PricesResponse;
import com.juangp.inditex.domain.services.mapper.PricesResponseMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PriceFinderImplTest {

    @Mock
    private PricesResponseMapper pricesResponseMapper;

    @Mock
    private FindPricesPort findPricesPort;

    @InjectMocks
    private PriceFinderImpl priceFinder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    /**
     * Method under test: {@link PriceFinderImpl#findPricesInditex(PricesRequest)}
     */
    @Test
    void testFindPricesInditex_WithValidRequest_ShouldReturnPricesResponse() {
        // Arrange
        LocalDateTime date = LocalDateTime.now();
        PricesRequest request = new PricesRequest(1L,1L,date);
        Prices prices = new Prices(1L,1L,1L,date,date,1L, BigDecimal.valueOf(100.0), "EUR");
        when(findPricesPort.findByBrandIdAndProductIdAndDate(anyLong(), anyLong(), any(LocalDateTime.class)))
                .thenReturn(prices);
        PricesResponse expectedResponse = new PricesResponse(1L,1L,1L,date, date, new FullPrice("EUR", BigDecimal.valueOf(1)));
        when(pricesResponseMapper.mapPricesToPricesResponse(prices)).thenReturn(expectedResponse);
        // Act
        PricesResponse actualResponse = priceFinder.findPricesInditex(request);

        // Assert
        assertNotNull(actualResponse);
        // Add assertions for expected response data
    }


    /**
     * Method under test: {@link PriceFinderImpl#findPricesInditex(PricesRequest)}
     */
    @Test
    void testFindPricesInditex_WithValidRequest_ShouldReturnTranslatingError() {
        // Arrange
        LocalDateTime date = LocalDateTime.now();
        PricesRequest request = new PricesRequest(1L,1L,date);
        when(findPricesPort.findByBrandIdAndProductIdAndDate(anyLong(), anyLong(), any(LocalDateTime.class)))
                .thenReturn(null);
        // Act & Assert
        try{
            priceFinder.findPricesInditex(request);
            assertThrows(TraductionDtoException.class, () -> priceFinder.findPricesInditex(request));
        }catch (TraductionDtoException traductionDtoException){
            assertThrows(TraductionDtoException.class, () -> priceFinder.findPricesInditex(request));
        }
    }
    /**
     * Method under test: {@link PriceFinderImpl#buildResponse(Prices)}
     */
    @Test
    void testBuildResponse() {
        // Arrange
        LocalDateTime date = LocalDateTime.now();
        Prices prices = new Prices(1L,1L,1L,date,date,1L, BigDecimal.valueOf(100.0), "EUR");
        PricesResponse expectedResponse = new PricesResponse(1L,1L,1L,date, date, new
                FullPrice("EUR", BigDecimal.valueOf(1)));

        // Configuramos el comportamiento del pricesResponseMapper
        when(pricesResponseMapper.mapPricesToPricesResponse(prices)).thenReturn(expectedResponse);

        // Act
        PricesResponse actualResponse = priceFinder.buildResponse(prices);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    /**
     * Method under test: {@link PriceFinderImpl#findPricesInditex(LocalDateTime, Long, Long)}
     */
    @Test
    void testFindPricesInditexAlternative_WithValidRequest_ShouldReturnPricesResponse() {
        // Arrange
        LocalDateTime date = LocalDateTime.now();
        Prices prices = new Prices(1L,1L,1L,date,date,1L, BigDecimal.valueOf(100.0), "EUR");
        when(findPricesPort.findByBrandIdAndProductIdAndDate(anyLong(), anyLong(), any(LocalDateTime.class)))
                .thenReturn(prices);
        PricesResponse expectedResponse = new PricesResponse(1L,1L,1L,date, date, new FullPrice("EUR", BigDecimal.valueOf(1)));
        when(pricesResponseMapper.mapPricesToPricesResponse(prices)).thenReturn(expectedResponse);
        // Act
        PricesResponse actualResponse = priceFinder.findPricesInditex(date,1L,1L);

        // Assert
        assertNotNull(actualResponse);
        // Add assertions for expected response data
    }

    /**
     * Method under test: {@link PriceFinderImpl#findPricesInditex(LocalDateTime, Long, Long)}
     */
    @Test
    void testFindPricesInditexAlternative_WithValidRequest_ShouldReturnTranslatingError() {
        // Arrange
        LocalDateTime date = LocalDateTime.now();
        when(findPricesPort.findByBrandIdAndProductIdAndDate(anyLong(), anyLong(), any(LocalDateTime.class)))
                .thenReturn(null);
        try{
            priceFinder.findPricesInditex(date,1L,1L);
            assertThrows(TraductionDtoException.class, () -> priceFinder.findPricesInditex(date,1L,1L));
        }catch (TraductionDtoException traductionDtoException){
            assertThrows(TraductionDtoException.class, () -> priceFinder.findPricesInditex(date,1L,1L));
        }
    }

}
