package com.juangp.inditex.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class FullPrice {
    String currency;
    BigDecimal amount;
}
