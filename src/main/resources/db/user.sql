DROP TABLE IF EXISTS `user`;
CREATE TABLE `USER`(
  id          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID' PRIMARY KEY ,
  username    VARCHAR(64) CHARACTER SET utf8 NOT NULL COMMENT '用户名' UNIQUE ,
  password    VARCHAR(1024) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  email       VARCHAR(64) CHARACTER SET utf8 NOT NULL COMMENT '邮箱地址' UNIQUE ,
  avatar      VARCHAR(1024) COMMENT '头像地址',
  resume      VARCHAR(512) CHARACTER SET utf8 DEFAULT NULL COMMENT '简介',
  register_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  login_time  DATETIME DEFAULT NULL COMMENT '上一次登录时间'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET =utf8 COMMENT ='用户表';

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$ItmuMLR4wUb5jjkBzg/CwuQADK7d9qbU725e.KyT/lLJEZeykDL62','admin@qq.com','https://www.tupianku.com/view/large/13862/640.jpeg','IT','2018-02-01 00:00:00','2018-02-01 00:00:00');
INSERT INTO `user` VALUES (2,'user','$2a$10$WbjpHk2CQTgKhmuyWUhfVuwI.s1cdECCTsfen8KHIyFbYDnZy2DUm','user@qq.com','https://www.tupianku.com/view/large/13862/640.jpeg','A normal user','2018-02-02 00:00:00','2018-02-02 00:00:00');
INSERT INTO `user` VALUES (3,'test','$2a$10$.0gBYBHAtdkxUUQNg3kII.fqGOngF4BLe8JavthZFalt2QIXHlrhm','test@qq.com','https://www.tupianku.com/view/large/13862/640.jpeg','To Test','2018-02-03 00:00:00','2018-02-03 00:00:00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;