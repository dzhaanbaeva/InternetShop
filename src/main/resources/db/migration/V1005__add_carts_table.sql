use `parfums`;

CREATE TABLE `carts` (
     `id` INT auto_increment NOT NULL,
     `session` VARCHAR(128) NOT NULL,
      `customer_id`int NOT NULL, PRIMARY KEY (`id`),
       CONSTRAINT `fk_cart_customer` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)

    );


