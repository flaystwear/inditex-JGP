package com.juangp.inditex.domain.services;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ValidateRequestData {
    void checkPricesRequest(LocalDateTime date, Long productId, Long brandId);
}
