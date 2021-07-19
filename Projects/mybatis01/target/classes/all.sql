CREATE DATABASE mybatis DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use mybatis;

CREATE TABLE `country`(
    `id` int not null auto_increment,
    `countryname` varchar(255) null,
    `countrycode` varchar(255) null,
    primary key (`id`)
);

insert into country(`countryname`, `countrycode`)
values ("中国", "CN"),
       ("美国", "US"),
       ("俄罗斯", "RU"),
       ("英国", "GB"),
       ("法国", "FR");
