package com.juangp.inditex.infraestructure.integrationTest;

import com.juangp.inditex.domain.model.dto.FullPrice;
import com.juangp.inditex.domain.model.out.PricesResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class IntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testEndpoint_Case_1() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

        String formattedDate = date.format(DateTimeFormatter.ISO_DATE_TIME);
        String url = String.format(
                "http://localhost:%d/api/v2/prices/inditex/products?date=%s&brand=%d&product=%d",
                port, formattedDate, brandId, productId
        );
        PricesResponse expected=new PricesResponse(
                productId,
                brandId,
                1L,
                startDate,
                endDate,
                new FullPrice(
                        "EUR",
                       new BigDecimal("35.50")
                )
        );

        PricesResponse result = this.restTemplate.getForObject(url, PricesResponse.class);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testEndpoint_Case_2() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 6, 14, 18, 30, 0);

        String formattedDate = date.format(DateTimeFormatter.ISO_DATE_TIME);
        String url = String.format(
                "http://localhost:%d/api/v2/prices/inditex/products?date=%s&brand=%d&product=%d",
                port, formattedDate, brandId, productId
        );
        PricesResponse expected=new PricesResponse(
                productId,
                brandId,
                2L,
                startDate,
                endDate,
                new FullPrice(
                        "EUR",
                        new BigDecimal("25.45")
                )
        );

        PricesResponse result = this.restTemplate.getForObject(url, PricesResponse.class);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testEndpoint_Case_3() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

        String formattedDate = date.format(DateTimeFormatter.ISO_DATE_TIME);
        String url = String.format(
                "http://localhost:%d/api/v2/prices/inditex/products?date=%s&brand=%d&product=%d",
                port, formattedDate, brandId, productId
        );
        PricesResponse expected=new PricesResponse(
                productId,
                brandId,
                1L,
                startDate,
                endDate,
                new FullPrice(
                        "EUR",
                        new BigDecimal("35.50")
                )
        );

        PricesResponse result = this.restTemplate.getForObject(url, PricesResponse.class);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testEndpoint_Case_4() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 15, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 6, 15, 11, 0, 0);

        String formattedDate = date.format(DateTimeFormatter.ISO_DATE_TIME);
        String url = String.format(
                "http://localhost:%d/api/v2/prices/inditex/products?date=%s&brand=%d&product=%d",
                port, formattedDate, brandId, productId
        );
        PricesResponse expected=new PricesResponse(
                productId,
                brandId,
                3L,
                startDate,
                endDate,
                new FullPrice(
                        "EUR",
                        new BigDecimal("30.50")
                )
        );

        PricesResponse result = this.restTemplate.getForObject(url, PricesResponse.class);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testEndpoint_Case_5() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 15, 14, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

        String formattedDate = date.format(DateTimeFormatter.ISO_DATE_TIME);
        String url = String.format(
                "http://localhost:%d/api/v2/prices/inditex/products?date=%s&brand=%d&product=%d",
                port, formattedDate, brandId, productId
        );
        PricesResponse expected=new PricesResponse(
                productId,
                brandId,
                4L,
                startDate,
                endDate,
                new FullPrice(
                        "EUR",
                        new BigDecimal("38.95")
                )
        );

        PricesResponse result = this.restTemplate.getForObject(url, PricesResponse.class);
        assertThat(result).isEqualTo(expected);
    }




}
