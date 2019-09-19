# 导入数据库，数据名称：test  用户名：root  密码：root
CREATE DATABASE db0 DEFAULT CHARACTER SET utf8;

use db0;

DROP TABLE city;
CREATE TABLE city(
  id INT AUTO_INCREMENT PRIMARY KEY,
  province_id INT NOT NULL COMMENT '省份ID',
  city_name VARCHAR (20) NOT NULL COMMENT '城市名称',
  description VARCHAR(100) COMMENT '城市描述'
);

INSERT INTO `city` (`id`, `province_id`, `city_name`, `description`) VALUES (1, 110, '北京', '没有北漂的人生是不完美的'), (2, 120, '上海', '大魔都'), (3, 130, '重庆', '雾都');
