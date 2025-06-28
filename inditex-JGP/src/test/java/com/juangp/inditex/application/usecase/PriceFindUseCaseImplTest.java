package com.juangp.inditex.application.usecase;


import com.juangp.inditex.application.ports.out.FindPricesPort;
import com.juangp.inditex.domain.exception.TraductionDtoException;
import com.juangp.inditex.domain.model.dto.Prices;
import com.juangp.inditex.domain.model.out.PricesResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceFindUseCaseImplTest {

    @Mock
    private FindPricesPort findPricesPort;

    @InjectMocks
    private PriceFindUseCaseImpl priceFinder;


    /**
     * Method under test: {@link PriceFindUseCaseImpl#findPricesInditex(LocalDateTime, Long, Long)}
     */
    @Test
    void testFindPricesInditexAlternative_WithValidRequest_ShouldReturnPricesResponse() {
        // Arrange
        LocalDateTime date = LocalDateTime.now();
        Prices prices = new Prices(1L,1L,1L,date,date,1L, BigDecimal.valueOf(100.0), "EUR");
        when(findPricesPort.findByBrandIdAndProductIdAndDate(anyLong(), anyLong(), any(LocalDateTime.class)))
                .thenReturn(prices);
        PricesResponse actualResponse = priceFinder.findPricesInditex(date,1L,1L);

        // Assert
        assertNotNull(actualResponse);

    }

    /**
     * Method under test: {@link PriceFindUseCaseImpl#findPricesInditex(LocalDateTime, Long, Long)}
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
