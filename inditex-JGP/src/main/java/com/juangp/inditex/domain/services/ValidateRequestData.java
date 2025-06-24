package com.juangp.inditex.domain.services;

import com.juangp.inditex.domain.model.in.PricesRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ValidateRequestData {
    void checkPricesRequest(PricesRequest pricesRequest);

    void checkPricesRequest(LocalDateTime date, Long productId, Long brandId);
}
