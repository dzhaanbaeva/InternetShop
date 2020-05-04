use `parfums`;

create table `customers` (
    `id` INT auto_increment NOT NULL,
    `email` varchar(128) NOT NULL,
    `password` varchar(128) NOT NULL,
    `fullname`  int NOT NULL,
     PRIMARY KEY (`id`)

);



