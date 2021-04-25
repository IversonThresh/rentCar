-- CREATE DATABASE CAR_RENT_DB;

DROP TABLE IF EXISTS `tbl_customer`;
CREATE TABLE `tbl_customer`  (
             `customer_id` int(255) NOT NULL AUTO_INCREMENT NOT NULL COMMENT '�û�id',
             `customer_name` varchar(255) default NULL COMMENT '����',
             `sex` int(255) default NULL COMMENT '�Ա�',
             `address` varchar(255) default NULL COMMENT '��ַ',
             `phone` varchar(255) default NULL COMMENT '�绰',
             `create_time` datetime default NULL COMMENT '����ʱ��',
             PRIMARY KEY  (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tbl_customer VALUES ('1', 'ҶϦˮ', '0', '�Ϻ�', '15278450366', '2021-04-24 08:27:57');
INSERT INTO tbl_customer VALUES ('2', '����ʯ', '1', '����', '15279364588', '2021-04-24 08:30:12');

DROP TABLE IF EXISTS `tbl_car`;
CREATE TABLE `tbl_car` (
           `car_id` int(255) AUTO_INCREMENT NOT NULL COMMENT '����id',
           `car_model` varchar(255) default NULL COMMENT '��������',
           `car_type` int(255) default NULL COMMENT '��������',
           `price` double(10,2) default NULL COMMENT '�����۸�',
           `rent_price` double(10,2) default NULL COMMENT '���޼۸�',
           `is_renting` int(11) default NULL COMMENT '�Ƿ�������',
           `description` varchar(255) default NULL COMMENT '��������',
           `car_img` varchar(255) default NULL COMMENT '����ͼƬuri',
           `create_time` datetime default NULL COMMENT '����ʱ��',
           PRIMARY KEY  (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tbl_car VALUES ('1', 'Toyota Camry', '1', '250000.00', '250.00', '0', 'ʡ��', '20210424/202104240931596284786.jpg', '2021-04-24 09:33:08');
INSERT INTO tbl_car VALUES ('2', 'Toyota Camry', '1', '250000.00', '250.00', '0', 'ʡ��', '20210424/202104240931596284786.jpg', '2021-04-24 09:33:08');
INSERT INTO tbl_car VALUES ('3', 'BMW 650', '2', '600000.00', '600.00', '0', '�߶��ϵ���', '20210424/202104240930535788138.jpg', '2021-04-24 09:31:50');
INSERT INTO tbl_car VALUES ('4', 'BMW 650', '2', '600000.00', '600.00', '0', '�߶��ϵ���', '20210424/202104240930535788138.jpg', '2021-04-24 09:31:50');

DROP TABLE IF EXISTS `tbl_car_rent`;
CREATE TABLE `tbl_car_rent` (
            `order_id` int(255) AUTO_INCREMENT NOT NULL COMMENT '����id',
            `price` double(10,2) default NULL COMMENT '�۸�',
            `begin_date` datetime default NULL COMMENT '��ʼ����',
            `return_date` datetime default NULL COMMENT '�黹����',
            `rent_flag` int(11) default NULL COMMENT '�Ƿ�黹',
            `customer_id` int(255) NOT NULL COMMENT '�û�id',
            `car_id` int(255) NOT NULL COMMENT '����id',
            `create_time` datetime default NULL COMMENT '����ʱ��',
            PRIMARY KEY  (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tbl_car_rent VALUES ('1', '1600.00', '2017-01-01 00:00:00', '2017-06-18 00:00:00', '1', '1', '2', '2017-01-01 00:00:00');
INSERT INTO tbl_car_rent VALUES ('2', '500.00', '2018-01-13 00:00:00', '2018-06-23 00:00:00', '1', '1', '1', '2018-01-13 00:00:00');
