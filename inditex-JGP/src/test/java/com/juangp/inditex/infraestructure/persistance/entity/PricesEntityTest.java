package com.juangp.inditex.infraestructure.persistance.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class PricesEntityTest {
    /**
     * Method under test: {@link PricesEntity#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new PricesEntity()).canEqual("Other"));
    }

    /**
     * Method under test: {@link PricesEntity#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertTrue(pricesEntity.canEqual(pricesEntity2));
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(null, pricesEntity);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals3() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(2L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals4() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(null);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals5() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("USD");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals6() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency(null);
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals7() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.now().atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals8() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(2L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals9() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(null);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals10() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("4.5"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals11() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(null);
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals12() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(3L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals13() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(null);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals14() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(3L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals15() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(null);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals16() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(2L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals17() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(null);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Method under test: {@link PricesEntity#equals(Object)}
     */
    @Test
    void testEquals18() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.now().atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertNotEquals(pricesEntity, pricesEntity2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PricesEntity#equals(Object)}
     *   <li>{@link PricesEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertEquals(pricesEntity, pricesEntity);
        int expectedHashCodeResult = pricesEntity.hashCode();
        assertEquals(expectedHashCodeResult, pricesEntity.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PricesEntity#equals(Object)}
     *   <li>{@link PricesEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode2() {
        // Arrange
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setCurrency("GBP");
        pricesEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity.setIdPrice(1L);
        pricesEntity.setPrice(new BigDecimal("2.3"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setPriority(1L);
        pricesEntity.setProductId(1L);
        pricesEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setBrandId(1L);
        pricesEntity2.setCurrency("GBP");
        pricesEntity2.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        pricesEntity2.setIdPrice(1L);
        pricesEntity2.setPrice(new BigDecimal("2.3"));
        pricesEntity2.setPriceList(1L);
        pricesEntity2.setPriority(1L);
        pricesEntity2.setProductId(1L);
        pricesEntity2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        // Act and Assert
        assertEquals(pricesEntity, pricesEntity2);
        int expectedHashCodeResult = pricesEntity.hashCode();
        assertEquals(expectedHashCodeResult, pricesEntity2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PricesEntity#PricesEntity()}
     *   <li>{@link PricesEntity#setBrandId(Long)}
     *   <li>{@link PricesEntity#setCurrency(String)}
     *   <li>{@link PricesEntity#setEndDate(LocalDateTime)}
     *   <li>{@link PricesEntity#setIdPrice(Long)}
     *   <li>{@link PricesEntity#setPrice(BigDecimal)}
     *   <li>{@link PricesEntity#setPriceList(Long)}
     *   <li>{@link PricesEntity#setPriority(Long)}
     *   <li>{@link PricesEntity#setProductId(Long)}
     *   <li>{@link PricesEntity#setStartDate(LocalDateTime)}
     *   <li>{@link PricesEntity#toString()}
     *   <li>{@link PricesEntity#getBrandId()}
     *   <li>{@link PricesEntity#getCurrency()}
     *   <li>{@link PricesEntity#getEndDate()}
     *   <li>{@link PricesEntity#getIdPrice()}
     *   <li>{@link PricesEntity#getPrice()}
     *   <li>{@link PricesEntity#getPriceList()}
     *   <li>{@link PricesEntity#getPriority()}
     *   <li>{@link PricesEntity#getProductId()}
     *   <li>{@link PricesEntity#getStartDate()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        PricesEntity actualPricesEntity = new PricesEntity();
        actualPricesEntity.setBrandId(1L);
        actualPricesEntity.setCurrency("GBP");
        LocalDateTime endDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualPricesEntity.setEndDate(endDate);
        actualPricesEntity.setIdPrice(1L);
        BigDecimal price = new BigDecimal("2.3");
        actualPricesEntity.setPrice(price);
        actualPricesEntity.setPriceList(1L);
        actualPricesEntity.setPriority(1L);
        actualPricesEntity.setProductId(1L);
        LocalDateTime startDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualPricesEntity.setStartDate(startDate);
        String actualToStringResult = actualPricesEntity.toString();
        Long actualBrandId = actualPricesEntity.getBrandId();
        String actualCurrency = actualPricesEntity.getCurrency();
        LocalDateTime actualEndDate = actualPricesEntity.getEndDate();
        Long actualIdPrice = actualPricesEntity.getIdPrice();
        BigDecimal actualPrice = actualPricesEntity.getPrice();
        Long actualPriceList = actualPricesEntity.getPriceList();
        Long actualPriority = actualPricesEntity.getPriority();
        Long actualProductId = actualPricesEntity.getProductId();
        LocalDateTime actualStartDate = actualPricesEntity.getStartDate();

        // Assert that nothing has changed
        assertEquals("GBP", actualCurrency);
        assertEquals("PricesEntity(idPrice=1, brandId=1, startDate=1970-01-01T00:00, endDate=1970-01-01T00:00, priceList=1,"
                + " productId=1, priority=1, price=2.3, currency=GBP)", actualToStringResult);
        assertEquals(1L, actualBrandId.longValue());
        assertEquals(1L, actualIdPrice.longValue());
        assertEquals(1L, actualPriceList.longValue());
        assertEquals(1L, actualPriority.longValue());
        assertEquals(1L, actualProductId.longValue());
        assertEquals(new BigDecimal("2.3"), actualPrice);
        assertSame(price, actualPrice);
        assertSame(endDate, actualEndDate);
        assertSame(startDate, actualStartDate);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link PricesEntity#PricesEntity(Long, Long, LocalDateTime, LocalDateTime, Long, Long, Long, BigDecimal, String)}
     *   <li>{@link PricesEntity#setBrandId(Long)}
     *   <li>{@link PricesEntity#setCurrency(String)}
     *   <li>{@link PricesEntity#setEndDate(LocalDateTime)}
     *   <li>{@link PricesEntity#setIdPrice(Long)}
     *   <li>{@link PricesEntity#setPrice(BigDecimal)}
     *   <li>{@link PricesEntity#setPriceList(Long)}
     *   <li>{@link PricesEntity#setPriority(Long)}
     *   <li>{@link PricesEntity#setProductId(Long)}
     *   <li>{@link PricesEntity#setStartDate(LocalDateTime)}
     *   <li>{@link PricesEntity#toString()}
     *   <li>{@link PricesEntity#getBrandId()}
     *   <li>{@link PricesEntity#getCurrency()}
     *   <li>{@link PricesEntity#getEndDate()}
     *   <li>{@link PricesEntity#getIdPrice()}
     *   <li>{@link PricesEntity#getPrice()}
     *   <li>{@link PricesEntity#getPriceList()}
     *   <li>{@link PricesEntity#getPriority()}
     *   <li>{@link PricesEntity#getProductId()}
     *   <li>{@link PricesEntity#getStartDate()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        LocalDateTime startDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        LocalDateTime endDate = LocalDate.of(1970, 1, 1).atStartOfDay();

        // Act
        PricesEntity actualPricesEntity = new PricesEntity(1L, 1L, startDate, endDate, 1L, 1L, 1L, new BigDecimal("2.3"),
                "GBP");
        actualPricesEntity.setBrandId(1L);
        actualPricesEntity.setCurrency("GBP");
        LocalDateTime endDate2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualPricesEntity.setEndDate(endDate2);
        actualPricesEntity.setIdPrice(1L);
        BigDecimal price = new BigDecimal("2.3");
        actualPricesEntity.setPrice(price);
        actualPricesEntity.setPriceList(1L);
        actualPricesEntity.setPriority(1L);
        actualPricesEntity.setProductId(1L);
        LocalDateTime startDate2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualPricesEntity.setStartDate(startDate2);
        String actualToStringResult = actualPricesEntity.toString();
        Long actualBrandId = actualPricesEntity.getBrandId();
        String actualCurrency = actualPricesEntity.getCurrency();
        LocalDateTime actualEndDate = actualPricesEntity.getEndDate();
        Long actualIdPrice = actualPricesEntity.getIdPrice();
        BigDecimal actualPrice = actualPricesEntity.getPrice();
        Long actualPriceList = actualPricesEntity.getPriceList();
        Long actualPriority = actualPricesEntity.getPriority();
        Long actualProductId = actualPricesEntity.getProductId();
        LocalDateTime actualStartDate = actualPricesEntity.getStartDate();

        // Assert that nothing has changed
        assertEquals("GBP", actualCurrency);
        assertEquals("PricesEntity(idPrice=1, brandId=1, startDate=1970-01-01T00:00, endDate=1970-01-01T00:00, priceList=1,"
                + " productId=1, priority=1, price=2.3, currency=GBP)", actualToStringResult);
        assertEquals(1L, actualBrandId.longValue());
        assertEquals(1L, actualIdPrice.longValue());
        assertEquals(1L, actualPriceList.longValue());
        assertEquals(1L, actualPriority.longValue());
        assertEquals(1L, actualProductId.longValue());
        assertEquals(new BigDecimal("2.3"), actualPrice);
        assertSame(price, actualPrice);
        assertSame(endDate2, actualEndDate);
        assertSame(startDate2, actualStartDate);
    }
}
