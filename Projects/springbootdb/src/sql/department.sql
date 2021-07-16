drop table if exists department;
create table `department`(
    `id` int(11) not null auto_increment,
    `name` varchar(45) collate utf8_bin default null comment '名称',
    primary key (`id`)
) ENGINE=InnoDB default charset=utf8 collate=utf8_bin;