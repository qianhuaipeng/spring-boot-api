DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id`      BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name`    VARCHAR(64) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET =utf8 COMMENT ='用户表';

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN');
INSERT INTO `role` VALUES (2,'ROLE_USER');
INSERT INTO `role` VALUES (3,'ROLE_TEST');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;