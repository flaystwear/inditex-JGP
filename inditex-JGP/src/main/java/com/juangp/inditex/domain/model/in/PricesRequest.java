package com.juangp.inditex.domain.model.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PricesRequest {
    Long brand;
    Long product;
    LocalDateTime date;
}
