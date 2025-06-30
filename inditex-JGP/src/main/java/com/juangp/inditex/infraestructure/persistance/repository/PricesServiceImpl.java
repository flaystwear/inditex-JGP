package com.juangp.inditex.infraestructure.persistance.repository;


import com.juangp.inditex.application.ports.out.FindPricesPort;
import com.juangp.inditex.domain.exception.PriceNotFoundException;
import com.juangp.inditex.domain.exception.TraductionDtoException;
import com.juangp.inditex.domain.model.dto.Prices;
import com.juangp.inditex.infraestructure.persistance.entity.PricesEntity;
import com.juangp.inditex.infraestructure.persistance.mapping.PriceEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PricesServiceImpl implements FindPricesPort {

    private final PricesRepository pricesRepository;

    private final PriceEntityMapper priceEntityMapper;


    @Override
    public Prices findByBrandIdAndProductIdAndDate( final Long brandId,final Long productId,final LocalDateTime date) {

        final PricesEntity pricesEntity = pricesRepository.findByBrandIdAndProductIdAndDate(brandId, productId, date);
        if (null != pricesEntity) {
            try {
                return priceEntityMapper.mapPricesEntityToPrices(pricesEntity);
            } catch (Exception e) {
                log.error("Error translating to DTO from database");
                throw new TraductionDtoException(String.format("Error translating to DTO from database: %s",
                        e.getMessage()));
            }
        } else {
            log.error("Could not find prices for product: {}, brand: {}, date: {}",
                    productId, brandId, date);
            throw new PriceNotFoundException(String.format("Could not find prices for product: %d, brand: %d, date: %s",
                    productId, brandId, date));
        }
    }
}
