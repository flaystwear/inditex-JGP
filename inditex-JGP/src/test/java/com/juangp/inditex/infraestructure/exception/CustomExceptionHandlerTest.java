package com.juangp.inditex.infraestructure.exception;


import com.juangp.inditex.domain.exception.PriceNotFoundException;
import com.juangp.inditex.domain.exception.RequestNotAcceptableException;
import com.juangp.inditex.domain.exception.TraductionDtoException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomExceptionHandlerTest {

    private final CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();

    /**
     * Method under test: {@link PriceNotFoundException}
     */
    @Test
    void testHandlePriceNotFoundException() {
        // Arrange
        PriceNotFoundException exception = new PriceNotFoundException("Price not found");

        // Act
        ResponseEntity<Object> responseEntity = customExceptionHandler.handlePriceNotFoundException(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Price not found", responseEntity.getBody());
    }

    /**
     * Method under test: {@link TraductionDtoException}
     */
    @Test
    void testHandleTraductionDtoErrorException() {
        // Arrange
        TraductionDtoException exception = new TraductionDtoException("Translation error");

        // Act
        ResponseEntity<Object> responseEntity = customExceptionHandler.handleTraductionDtoErrorException(exception);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Translation error", responseEntity.getBody());
    }


    /**
     * Method under test: {@link RequestNotAcceptableException}
     */
    @Test
    void testHandleRequestNotAcceptableErrorException() {
        // Arrange
        RequestNotAcceptableException exception = new RequestNotAcceptableException("Request not acceptable");

        // Act
        ResponseEntity<Object> responseEntity = customExceptionHandler.handleRequestNotAcceptableErrorException(exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Request not acceptable", responseEntity.getBody());
    }
}

