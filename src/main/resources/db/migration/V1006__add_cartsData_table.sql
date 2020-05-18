use `parfums`;

CREATE TABLE `carts_data` (
     `id` int auto_increment,
     `product_id` int NOT NULL,
    `carts_id` int NOT NULL,
    `qty` int NOT NULL DEFAULT '1', PRIMARY KEY (`id`),
    CONSTRAINT `fk_product_cart` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
    CONSTRAINT `fk_cart_cart` FOREIGN KEY (`carts_id`) REFERENCES `carts` (`id`)


);


