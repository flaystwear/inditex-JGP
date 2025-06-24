package com.juangp.inditex.infraestructure.ports.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PricesEntity implements Serializable {
    @Id
    @Column(name = "id_price")
    Long idPrice;

    @Column(name = "brand_id")
    Long brandId;

    @Column(name = "start_date")
    LocalDateTime startDate;

    @Column(name = "end_date")
    LocalDateTime endDate;

    @Column(name = "price_list")
    Long priceList;

    @Column(name = "product_id")
    Long productId;

    @Column(name = "priority")
    Long priority;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "currency")
    String currency;
}
