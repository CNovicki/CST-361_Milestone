CREATE DATABASE `cst_milestones` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `sensor_data` (
  `sensor_data_id` int(11) NOT NULL AUTO_INCREMENT,
  `pressure` double NOT NULL,
  `temperature` double NOT NULL,
  `date` varchar(45) NOT NULL,
  PRIMARY KEY (`sensor_data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
