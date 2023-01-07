DROP DATABASE IF EXISTS POMS;
CREATE DATABASE POMS;
use POMS;

/*DDL COMMANDS*/
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`(
   order_id int NOT NULL AUTO_INCREMENT,
   customer_name varchar(20) DEFAULT NULL,
   customer_contact varchar(10) DEFAULT NULL,
   delivery_address varchar(50) DEFAULT NULL,
   delivery_status BOOLEAN DEFAULT NULL,
   PRIMARY KEY (order_id),
   CONSTRAINT order_chk_1 CHECK ((char_length(customer_name) > 2)),
   CONSTRAINT order_chk_2 CHECK ((char_length(customer_contact) = 10))
 );
 
 /*DDL COMMANDS*/
 DROP TABLE IF EXISTS ordered_item;
 CREATE TABLE ordered_item (
   order_id int NOT NULL,
   item_name varchar(20) NOT NULL,
   cost smallint unsigned NOT NULL,
   Foreign KEY (order_id) References `order`(order_id),
   FOREIGN KEY (order_id) REFERENCES `order` (order_id)
 );