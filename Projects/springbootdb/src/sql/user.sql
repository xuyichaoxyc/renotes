drop table if exists user;
create table `user`(
    `id` int(11) not null auto_increment,
    `name` varchar(45) collate utf8_bin default null comment '名称',
    `department_id` int(11) default null ,
    `create_time` date default null comment '创建时间',
    primary key (`id`)
) ENGINE=InnoDB default charset=utf8 collate=utf8_bin;