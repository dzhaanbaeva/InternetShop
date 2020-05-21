use `parfums`;

-- CREATE TABLE `carts_data` (
--      `id` int auto_increment,
--      `product_id` int NOT NULL,
--     `carts_id` int NOT NULL,
--     `qty` int NOT NULL DEFAULT '1', PRIMARY KEY (`id`),
--     CONSTRAINT `fk_product_cart` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
--     CONSTRAINT `fk_cart_cart` FOREIGN KEY (`carts_id`) REFERENCES `carts` (`id`)
-- );

CREATE TABLE `carts_data` (
              `id` INT  AUTO_INCREMENT,
              `qty` INT NOT NULL DEFAULT '1',
                 `carts_id` INT NOT NULL,
                 `product_id` INT NOT NULL,
                 PRIMARY KEY (`id`,`carts_id`, `product_id`),
                 INDEX `fk_carts_has_products_products1_idx` (`product_id` ASC) VISIBLE,
                 INDEX `fk_carts_has_products_carts1_idx` (`carts_id` ASC) VISIBLE,
                 CONSTRAINT `fk_carts_has_products_carts1`
                     FOREIGN KEY (`carts_id`)
                         REFERENCES `parfums`.`carts` (`id`)
                         ON DELETE NO ACTION
                         ON UPDATE NO ACTION,
                 CONSTRAINT `fk_carts_has_products_products1`
                     FOREIGN KEY (`product_id`)
                         REFERENCES `parfums`.`products` (`id`)
                         ON DELETE NO ACTION
                         ON UPDATE NO ACTION);


