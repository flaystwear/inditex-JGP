package com.juangp.inditex.infraestructure.web.service;

import com.juangp.inditex.domain.model.dto.Prices;
import com.juangp.inditex.domain.model.out.PricesResponse;
import com.juangp.inditex.domain.services.mapper.PricesResponseMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
class PricesResponseMapperTest {
    /**
     * Method under test:
     * {@link PricesResponseMapper#mapPricesToPricesResponse(Prices)}
     */
    @Test
    void testMapPricesToPricesResponse() {
        // Arrange
        PricesResponseMapper mapper = new PricesResponseMapper();
        Prices entity = new Prices(
                123L,
                456L,
                789L,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(1),
                5L,
                BigDecimal.valueOf(100.0),
                "EUR"
        );

        // Act
        PricesResponse response = mapper.mapPricesToPricesResponse(entity);
        // Assert
        assertEquals(entity.getProductId(), response.getProductId());
        assertEquals(entity.getBrandId(), response.getBrandId());
        assertEquals(entity.getPriceList(), response.getPriceList());
        assertEquals(entity.getStartDate(), response.getStartDate());
        assertEquals(entity.getEndDate(), response.getEndDate());
        assertEquals(entity.getCurrency(), response.getPrice().getCurrency());
        assertEquals(entity.getPrice(), response.getPrice().getAmount());
    }
}
