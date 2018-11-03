DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`(
  `id`        BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `resource`  VARCHAR(256) NOT NULL COMMENT '权限对应的资源',
  `code`      VARCHAR(256) NOT NULL COMMENT '权限的代码/通配符，对应代码中@hasAuthority(xx)',
  `handle`    VARCHAR(256) not NULL COMMENT '对应的资源操作',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='权限表';

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'user','user:list','list');
INSERT INTO `permission` VALUES (2,'user','user:add','add');
INSERT INTO `permission` VALUES (3,'user','user:update','update');
INSERT INTO `permission` VALUES (4,'user','user:delete','delete');
INSERT INTO `permission` VALUES (5,'role','role:list','list');
INSERT INTO `permission` VALUES (6,'role','role:add','add');
INSERT INTO `permission` VALUES (7,'role','role:update','update');
INSERT INTO `permission` VALUES (8,'role','role:delete','delete');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;