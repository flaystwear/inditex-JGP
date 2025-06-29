package com.juangp.inditex.application.usecase;

import com.juangp.inditex.application.ports.in.PriceFindUseCase;
import com.juangp.inditex.application.ports.out.FindPricesPort;
import com.juangp.inditex.domain.exception.TraductionDtoException;
import com.juangp.inditex.domain.model.dto.FullPrice;
import com.juangp.inditex.domain.model.dto.Prices;
import com.juangp.inditex.domain.model.out.PricesResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceFindUseCaseImpl implements PriceFindUseCase {

    
    private final FindPricesPort findPrices;


    @Override
    public PricesResponse findPricesInditex(final LocalDateTime dateAsOn, final Long idProduct, final Long idList) {

       final Prices prices = findPrices.findByBrandIdAndProductIdAndDate(
               idList,
               idProduct,
               dateAsOn
        );
        try {
            if (null == prices) {
                throw new TraductionDtoException("Translation came null");
            }
            return buildResponse(prices);
        } catch (Exception e) {
            log.error("Error translating to DTO from working object to response. Error: {}", e.getMessage());
            throw new TraductionDtoException(String.format("Error translating data: %s",
                    prices));
        }
    }


    private PricesResponse buildResponse(final Prices prices) {
        final FullPrice fullPrice = new FullPrice(prices.getCurrency(), prices.getPrice());
        return new PricesResponse(
                prices.getProductId(),
                prices.getBrandId(),
                prices.getPriceList(),
                prices.getStartDate(),
                prices.getEndDate(),
                fullPrice
        );
    }
}
