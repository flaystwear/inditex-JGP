package com.juangp.inditex.infraestructure.adapters.controllers;


import com.juangp.inditex.application.ports.in.PriceFinder;
import com.juangp.inditex.domain.model.in.PricesRequest;
import com.juangp.inditex.domain.model.out.PricesResponse;
import com.juangp.inditex.domain.services.ValidateRequestData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor@Slf4j
public class PricesController {


    @Autowired
    private final PriceFinder priceFinderImpl;

    private final ValidateRequestData validateRequestData;

    @PostMapping("/api/v1/prices")
    ResponseEntity<PricesResponse> findPrice(@RequestBody PricesRequest pricesRequest) {
        /*
         *Se coge el momento en el que se recibe la petición y lo convertimos en string
         * para mostrarlo en el log junto a la petición
         */
        LocalDateTime localDateTime1 = LocalDateTime.now();
        String formattedDateTime1 = localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("Petición recibida a  {}.", formattedDateTime1);
        //Se procede a comprobar que los parámetros estén correctos y a buscar el precio y generar la respuesta.
        validateRequestData.checkPricesRequest(pricesRequest);
        log.info("Request: {}", pricesRequest);
        PricesResponse response = priceFinderImpl.findPricesInditex(pricesRequest);
        log.info("Petición respondida : {}.", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Endpoint de tipo get con variables recogidas de la url y por parámetro en vez de con un body: solución alternativa
    @GetMapping(value = "/api/v1/prices/inditex/brand/{brandId}/product/{productId}")
    ResponseEntity<PricesResponse> findPriceAlternative(
            @PathVariable Long brandId,
            @PathVariable Long productId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        /*
         *Se coge el momento en el que se recibe la petición y lo convertimos en string
         * para mostrarlo en el log junto a la petición
         */
        LocalDateTime localDateTime1 = LocalDateTime.now();
        String formattedDateTime1 = localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("Petición recibida a  {}.", formattedDateTime1);
        //Se procede a comprobar que los parámetros estén correctos y a buscar el precio y generar la respuesta
        validateRequestData.checkPricesRequest(date, productId, brandId);
        log.info("Request: brand={}, product={}, date={}", brandId, productId, date);
        PricesResponse response = priceFinderImpl.findPricesInditex(date, productId, brandId);
        log.info("Petición respondida : {}.", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
