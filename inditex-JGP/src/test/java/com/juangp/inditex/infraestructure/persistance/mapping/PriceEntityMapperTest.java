package com.juangp.inditex.infraestructure.ports.database.mapping;


import com.juangp.inditex.domain.model.dto.Prices;
import com.juangp.inditex.infraestructure.ports.database.entity.PricesEntity;
import com.juangp.inditex.infraestructure.ports.database.mapping.PriceEntityMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
class PriceEntityMapperTest {
    /**
     * Method under test:
     * {@link PriceEntityMapper#mapPricesEntityToPrices(PricesEntity)}
     */
    @Test
    void testMapPricesEntityToPrices() {
        // Arrange
        PriceEntityMapper mapper = new PriceEntityMapper();
        PricesEntity entity = new PricesEntity();
        entity.setIdPrice(1L);
        entity.setProductId(123L);
        entity.setBrandId(456L);
        entity.setPriceList(789L);
        entity.setStartDate(LocalDateTime.now());
        entity.setEndDate(LocalDateTime.now().plusDays(1));
        entity.setPriority(1L);
        entity.setPrice(BigDecimal.valueOf(100.0));
        entity.setCurrency("EUR");

        // Act
        Prices prices = mapper.mapPricesEntityToPrices(entity);

        // Assert
        assertEquals(entity.getProductId(), prices.getProductId());
        assertEquals(entity.getBrandId(), prices.getBrandId());
        assertEquals(entity.getPriceList(), prices.getPriceList());
        assertEquals(entity.getStartDate(), prices.getStartDate());
        assertEquals(entity.getEndDate(), prices.getEndDate());
        assertEquals(entity.getPriority(), prices.getPriority());
        assertEquals(entity.getPrice(), prices.getPrice());
        assertEquals(entity.getCurrency(), prices.getCurrency());
    }

}
