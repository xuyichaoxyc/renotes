DROP TABLE if exists `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL,
  `passWord` varchar(50) NOT NULL,
  `realName` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `user` values
(1, "xyc", "123456", "xuyichao"),
(2, "xyb", "234567", "xuyibin"),
(3, "bxy", "783733", "baixuynva");
