DROP TABLE IF EXISTS `fetch_record`;
CREATE TABLE `fetch_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `shop_id` varchar(20) DEFAULT '' COMMENT '门店编码',
  `code` varchar(40) DEFAULT '' COMMENT '接口状态码',
  `message` varchar(200) DEFAULT '' COMMENT '接口返回信息',
  `last_Serial_id` varchar(20) DEFAULT '0',
  `full_flag` tinyint(1) DEFAULT '0' COMMENT '全量更新完毕判断',
  `random` int(11) DEFAULT NULL COMMENT '全量更新至第几页',
  `status` int(4) DEFAULT '1',
  `created_date` int(8) unsigned zerofill DEFAULT '00000000' COMMENT '查询专用(yyyyMMdd)',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000000 DEFAULT CHARSET=utf8

DROP TABLE IF EXISTS `log_task_error`;
CREATE TABLE `log_task_error` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `task_code` varchar(32) NOT NULL DEFAULT '' COMMENT '任务编码',
  `data_code` varchar(32) NOT NULL COMMENT '数据编码',
  `consuming` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '执行耗时ms',
  `error_msg` varchar(255) NOT NULL DEFAULT '' COMMENT '错误消息',
  `remarks` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(30) NOT NULL DEFAULT 'sys' COMMENT '创建者',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` varchar(30) NOT NULL DEFAULT 'sys' COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000000 DEFAULT CHARSET=utf8 COMMENT='定时任务日志表'


DROP TABLE IF EXISTS `shop_product_promo_info`;
CREATE TABLE `shop_product_promo_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `shop_code` varchar(4) NOT NULL DEFAULT '' COMMENT '门店编码',
  `product_code` varchar(18) NOT NULL DEFAULT '' COMMENT '商品编码',
  `price` decimal(13,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `promo_price` decimal(13,2) NOT NULL DEFAULT '0.00' COMMENT '促销价格',
  `promo_no` varchar(60) NOT NULL DEFAULT '' COMMENT '促销档期号',
  `start_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '促销开始时间',
  `end_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '促销结束时间',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(30) NOT NULL DEFAULT 'sys' COMMENT '创建者',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` varchar(30) NOT NULL DEFAULT 'sys' COMMENT '更新者',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_shop_code_prod_code` (`shop_code`,`product_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000000 DEFAULT CHARSET=utf8 COMMENT='促销信息简表'