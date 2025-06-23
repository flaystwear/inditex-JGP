package com.juangp.inditex.application.ports.in;

import com.juangp.inditex.domain.model.dto.Prices;
import com.juangp.inditex.domain.model.in.PricesRequest;
import com.juangp.inditex.domain.model.out.PricesResponse;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceFinder {
    PricesResponse findPricesInditex(PricesRequest pricesRequest);

    PricesResponse findPricesInditex(LocalDateTime dateAsOn, Long idProduct, Long idList);

    PricesResponse buildResponse(Prices prices);
}
