package com.juangp.inditex.application.utils;

import com.juangp.inditex.domain.exception.RequestNotAcceptableException;
import com.juangp.inditex.domain.model.in.PricesRequest;
import com.juangp.inditex.domain.services.ValidateRequestData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ValidateRequestDataImpl implements ValidateRequestData {


    @Override
    public void checkPricesRequest(PricesRequest pricesRequest) {
        if (null == pricesRequest
                || null == pricesRequest.getBrand()
                || null == pricesRequest.getDate()
                || null == pricesRequest.getProduct()) {
            log.error("Request body missing some element");
            throw new RequestNotAcceptableException("Missing key elements on the Request Body");
        }
    }
}
