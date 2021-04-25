-- CREATE DATABASE CAR_RENT_DB;

DROP TABLE IF EXISTS `tbl_customer`;
CREATE TABLE `tbl_customer`  (
             `customer_id` int(255) NOT NULL AUTO_INCREMENT NOT NULL COMMENT '用户id',
             `customer_name` varchar(255) default NULL COMMENT '姓名',
             `sex` int(255) default NULL COMMENT '性别',
             `address` varchar(255) default NULL COMMENT '地址',
             `phone` varchar(255) default NULL COMMENT '电话',
             `create_time` datetime default NULL COMMENT '创建时间',
             PRIMARY KEY  (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tbl_customer VALUES ('1', '叶夕水', '0', '上海', '15278450366', '2021-04-24 08:27:57');
INSERT INTO tbl_customer VALUES ('2', '徐三石', '1', '深圳', '15279364588', '2021-04-24 08:30:12');

DROP TABLE IF EXISTS `tbl_car`;
CREATE TABLE `tbl_car` (
           `car_id` int(255) AUTO_INCREMENT NOT NULL COMMENT '汽车id',
           `car_model` varchar(255) default NULL COMMENT '汽车牌子',
           `car_type` int(255) default NULL COMMENT '汽车类型',
           `price` double(10,2) default NULL COMMENT '汽车价格',
           `rent_price` double(10,2) default NULL COMMENT '租赁价格',
           `is_renting` int(11) default NULL COMMENT '是否租赁中',
           `description` varchar(255) default NULL COMMENT '汽车描述',
           `car_img` varchar(255) default NULL COMMENT '汽车图片uri',
           `create_time` datetime default NULL COMMENT '创建时间',
           PRIMARY KEY  (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tbl_car VALUES ('1', 'Toyota Camry', '1', '250000.00', '250.00', '0', '省油', '20210424/202104240931596284786.jpg', '2021-04-24 09:33:08');
INSERT INTO tbl_car VALUES ('2', 'Toyota Camry', '1', '250000.00', '250.00', '0', '省油', '20210424/202104240931596284786.jpg', '2021-04-24 09:33:08');
INSERT INTO tbl_car VALUES ('3', 'BMW 650', '2', '600000.00', '600.00', '0', '高端上档次', '20210424/202104240930535788138.jpg', '2021-04-24 09:31:50');
INSERT INTO tbl_car VALUES ('4', 'BMW 650', '2', '600000.00', '600.00', '0', '高端上档次', '20210424/202104240930535788138.jpg', '2021-04-24 09:31:50');

DROP TABLE IF EXISTS `tbl_car_rent`;
CREATE TABLE `tbl_car_rent` (
            `order_id` int(255) AUTO_INCREMENT NOT NULL COMMENT '订单id',
            `price` double(10,2) default NULL COMMENT '价格',
            `begin_date` datetime default NULL COMMENT '开始日期',
            `return_date` datetime default NULL COMMENT '归还日期',
            `rent_flag` int(11) default NULL COMMENT '是否归还',
            `customer_id` int(255) NOT NULL COMMENT '用户id',
            `car_id` int(255) NOT NULL COMMENT '汽车id',
            `create_time` datetime default NULL COMMENT '创建时间',
            PRIMARY KEY  (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tbl_car_rent VALUES ('1', '1600.00', '2017-01-01 00:00:00', '2017-06-18 00:00:00', '1', '1', '2', '2017-01-01 00:00:00');
INSERT INTO tbl_car_rent VALUES ('2', '500.00', '2018-01-13 00:00:00', '2018-06-23 00:00:00', '1', '1', '1', '2018-01-13 00:00:00');
