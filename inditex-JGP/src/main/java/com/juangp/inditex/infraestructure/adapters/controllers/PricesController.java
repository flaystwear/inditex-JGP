package com.juangp.inditex.infraestructure.adapters.controllers;


import com.juangp.inditex.application.ports.in.PriceFinder;
import com.juangp.inditex.domain.model.in.PricesRequest;
import com.juangp.inditex.domain.model.out.PricesResponse;
import com.juangp.inditex.domain.services.ValidateRequestData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor@Slf4j
@Validated
public class PricesController {

    private final PriceFinder priceFinderImpl;

    private final ValidateRequestData validateRequestData;


    @Operation(summary = "Get the price for a given time using its productId, brandId. " +
            "If there is more than one product in this lapse of time," +
            " it will get the one with the highest priority"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the book",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PricesResponse.class))
                    }
            ),
            @ApiResponse(responseCode = "400", description = "Incomplete request parameters", content = @Content),
            @ApiResponse(responseCode = "404", description = "Price not found", content = @Content)
    })
    @GetMapping("/api/v1/prices")
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
}
