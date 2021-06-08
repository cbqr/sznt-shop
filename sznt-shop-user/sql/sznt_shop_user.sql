DROP TABLE IF EXISTS address;
CREATE TABLE `address`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`        bigint(20)   DEFAULT NULL COMMENT '用户id',
    `default_status` int(1)       DEFAULT NULL COMMENT '是否默认收货地址：0->否；1->是',
    `receive_name`   varchar(64)  DEFAULT NULL COMMENT '收发货人姓名',
    `phone`          varchar(64)  DEFAULT NULL COMMENT '收货人电话',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省/直辖市',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市',
    `region`         varchar(64)  DEFAULT NULL COMMENT '区',
    `detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
    `create_time`    timestamp    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    timestamp    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='收发货地址表';


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          bigint(11) unsigned NOT NULL AUTO_INCREMENT,
    `name`        varchar(128) DEFAULT NULL COMMENT '昵称',
    `pwd`         varchar(124) DEFAULT NULL COMMENT '密码',
    `head_img`    varchar(524) DEFAULT NULL COMMENT '头像',
    `slogan`      varchar(524) DEFAULT NULL COMMENT '用户签名',
    `sex`         tinyint(2)   DEFAULT '1' COMMENT '0表示女，1表示男',
    `points`      int(10)      DEFAULT '0' COMMENT '积分',
    `mail`        varchar(64)  DEFAULT NULL COMMENT '邮箱',
    `secret`      varchar(12)  DEFAULT NULL COMMENT '盐，用于个人敏感信息处理',
    `create_time` timestamp    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_mail_idx` (`mail`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';