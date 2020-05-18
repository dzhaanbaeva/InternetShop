use `parfums`;

create table `products` (
    `id` INT auto_increment NOT NULL,
    `name` varchar(128) NOT NULL,
    `image` varchar(128) NOT NULL,
    `quantity`  int NOT NULL,
    `description` varchar(128) NOT NULL,
    `price` float not null,
     `category_id` int not null,
    `brand_id` int not null,
     PRIMARY KEY (`id`),
    CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
    CONSTRAINT `fk_product_brand` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`id`)
);

insert into `categories`  values ('1', 'eau de Toilette'), ('2', 'eau de Parfum'),('3', 'Perfume');
insert into `brands`  values ('1', 'Channel'), ('2', 'Dior'),('3','Hugo Boss');

insert into `products` values
('1','Chance eau Tender','tender.png','5','original fragrance','120','1', '1'),
('2','Addict','addict.png','5','original fragrance','100','1', '2'),
('3','Savage','savage.png','5','original fragrance','90','2', '2'),
('4','Mavie','maVie.png','5','original fragrance','80','2', '3'),
('5','Mademouiselle','coco.png','5','original fragrance','150','3', '1'),
('6','The Scent','scent.png','5','original fragrance','110','2', '3'),
('7','Allure','allure.png','5','original fragrance','140','3', '1'),
('8','Gabrielle','gabrielle.png','5','original fragrance','130','3', '1');

-- alter table products add foreign key (cartId) references carts(id);
