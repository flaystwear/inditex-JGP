package com.juangp.inditex.infraestructure.web.controller;


import com.juangp.inditex.application.ports.in.PriceFindUseCase;
import com.juangp.inditex.domain.model.out.PricesResponse;
import com.juangp.inditex.domain.services.ValidateRequestData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor@Slf4j
@Validated
public class PricesController {

    private final PriceFindUseCase priceFindUseCaseImpl;

    private final ValidateRequestData validateRequestData;


    @Operation(summary = "Get the price for a given time using its productId, brandId. " +
            "If there is more than one product in this lapse of time," +
            " it will get the one with the highest priority"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the price",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PricesResponse.class))
                    }
            ),
            @ApiResponse(responseCode = "400", description = "Incomplete request parameters", content = @Content),
            @ApiResponse(responseCode = "404", description = "Price not found", content = @Content)
    })
    @GetMapping(value = "/api/v2/prices/inditex/brand/{brandId}/product/{productId}")
    ResponseEntity<PricesResponse> findPrice(
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

        validateRequestData.checkPricesRequest(date, productId, brandId);
        log.info("Request: brand={}, product={}, date={}", brandId, productId, date);
        PricesResponse response = priceFindUseCaseImpl.findPricesInditex(date, productId, brandId);
        log.info("Petición respondida : {}.", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
