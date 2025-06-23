--Primero limpiamos la tabla
DROP TABLE IF EXISTS PRICES;
--Creación de la tabla PRICES si no existe ya. AUTO_INCREMENT para que la clave primaria se genere sola
CREATE TABLE IF NOT EXISTS PRICES (
    id_price BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand_id BIGINT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list BIGINT,
    product_id BIGINT,
    priority BIGINT,
    price DECIMAL,
    currency VARCHAR(255)
);
--Insertado de filas para crear campos del ejemplo
INSERT INTO PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, currency) VALUES (1,'2020-06-14 00:00:00', '2020-12-31 23:59:59',1, 35455, 0, 35.50, 'EUR');
INSERT INTO PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, currency) VALUES (1,'2020-06-14 15:00:00', '2020-06-14 18:30:00',2, 35455, 1, 25.45, 'EUR');
INSERT INTO PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, currency) VALUES (1,'2020-06-15 00:00:00', '2020-06-15 11:00:00',3, 35455, 1, 30.50, 'EUR');
INSERT INTO PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, currency) VALUES (1,'2020-06-15 14:00:00', '2020-12-31 23:59:59',4, 35455, 1, 38.95, 'EUR');
