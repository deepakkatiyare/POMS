DROP DATABASE IF EXISTS POMS;

CREATE DATABASE POMS;

USE POMS;

DROP TABLE IF EXISTS `ORDER`;
CREATE TABLE `ORDER` (
   `order_id` int NOT NULL AUTO_INCREMENT,
   `customer_name` varchar(20) NOT NULL,
   `customer_contact` varchar(10) DEFAULT NULL,
   `delivery_address` varchar(255) NOT NULL,
   `delivery_status` varchar(15) NOT NULL,
   `price` int NOT NULL,
   PRIMARY KEY (`order_id`)
 );
 
DROP TABLE IF EXISTS ORDERED_ITEM;
CREATE TABLE ORDERED_ITEM (
   order_id int NOT NULL,
   item_name varchar(255) DEFAULT NULL,
   price smallint unsigned NOT NULL,
   FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
 );

DROP TABLE IF EXISTS CANCEL_ORDER;
CREATE TABLE CANCEL_ORDER(
cancel_id int primary key auto_increment,
cancel_reason varchar(255) not null,
cancel_date_time timestamp,
order_id int not null
);
