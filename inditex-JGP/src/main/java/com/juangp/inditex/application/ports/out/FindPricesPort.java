package com.juangp.inditex.application.ports.out;

import com.juangp.inditex.domain.model.dto.Prices;

import java.time.LocalDateTime;


public interface FindPricesPort {
    Prices findByBrandIdAndProductIdAndDate(Long productId, Long brandId, LocalDateTime date);
}
