package com.juangp.inditex.domain.model.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.juangp.inditex.domain.model.dto.FullPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PricesResponse {
    Long productId;
    Long brandId;
    Long priceList;
    LocalDateTime startDate;
    LocalDateTime endDate;
    FullPrice price;
}
