package com.juangp.inditex.application.services;


import com.juangp.inditex.application.service.ValidateRequestDataImpl;
import com.juangp.inditex.domain.exception.RequestNotAcceptableException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidateRequestDataImplTest {
    /**
     * Method under test:
     * {@link ValidateRequestDataImpl#checkPricesRequest(LocalDateTime date, Long product, Long brand)}
     */
    private final ValidateRequestDataImpl validator = new ValidateRequestDataImpl();

    @Test
    void testCheckPricesRequest_WithMissingBrand_ShouldThrowRequestNotAcceptableException() {
        // Arrange
        LocalDateTime date=LocalDateTime.now();
        Long product=1L;

        // Act & Assert
        assertThrows(RequestNotAcceptableException.class, () -> validator.checkPricesRequest(date,product, null));
    }

    @Test
    void testCheckPricesRequest_WithMissingDate_ShouldThrowRequestNotAcceptableException() {
        // Arrange
        Long brand=1L;
        Long product=1L;

        // Act & Assert
        assertThrows(RequestNotAcceptableException.class, () -> validator.checkPricesRequest(null, product, brand));
    }

    @Test
    void testCheckPricesRequest_WithMissingProduct_ShouldThrowRequestNotAcceptableException() {
        // Arrange
        Long brand=1L;
        LocalDateTime date= LocalDateTime.now();

        // Act & Assert
        assertThrows(RequestNotAcceptableException.class, () -> validator.checkPricesRequest(date, null, brand));
    }

    @Test
    void testCheckPricesRequest_WithValidRequest_ShouldNotThrowException() {
        // Arrange
        Long brand=1L;
        Long product=1L;
        LocalDateTime date= LocalDateTime.now();

        // Act & Assert
        validator.checkPricesRequest(date,product,brand); // No debería lanzar ninguna excepción
    }
}
