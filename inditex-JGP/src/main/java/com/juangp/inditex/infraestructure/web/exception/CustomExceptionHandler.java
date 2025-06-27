package com.juangp.inditex.infraestructure.web.exception;

import com.juangp.inditex.domain.exception.PriceNotFoundException;
import com.juangp.inditex.domain.exception.RequestNotAcceptableException;
import com.juangp.inditex.domain.exception.TraductionDtoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * Con este controlador de excepciones no hace falta
 * controlar de forma individual en cada implementación
 * las excepciones devueltas, al lanzar las excepciones en el código:
 * PriceNotFoundException
 * TraductionDtoException
 * RequestNotAcceptableException
 * se manda automáticamente el ResponseEntity con el código de error correspondiente
 * */
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(PriceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TraductionDtoException.class)
    public ResponseEntity<Object> handleTraductionDtoErrorException(TraductionDtoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RequestNotAcceptableException.class)
    public ResponseEntity<Object> handleRequestNotAcceptableErrorException(RequestNotAcceptableException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}