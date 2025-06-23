package com.juangp.inditex.application.ports.out;

import com.juangp.inditex.domain.model.dto.Prices;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface FindPricesPort {
    Prices findByBrandIdAndProductIdAndDate(Long productId, Long brandId, LocalDateTime date);
}
