package com.juangp.inditex.application.ports.in;

import com.juangp.inditex.domain.model.out.PricesResponse;

import java.time.LocalDateTime;


public interface PriceFindUseCase {


    PricesResponse findPricesInditex(LocalDateTime dateAsOn, Long idProduct, Long idList);

}
