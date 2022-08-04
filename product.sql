/* I lost the query for product and category, so I retyped all again.
There might be a chance of error. But I got o/p before. */ 


create database ecommerce ;
use ecommerce ;

create table productcategory(categoryid BIGINT PRIMARY KEY,categoryname  VARCHAR(255));
insert into productcategory values(
235,"MobilePhones"),(628,'Laptops'),(712,"Headsets");

CREATE TABLE product(id BIGINT PRIMARY KEY AUTO_INCREMENT,sku VARCHAR(255),
name VARCHAR(255),description VARCHAR(255),unitprice DECIMAL(13,2),imageurl VARCHAR(255),
active bit(2),
unitstock INT,datecreated DATETIME(6),lastupdated DATETIME(6), categoryid BIGINT,
FOREIGN KEY (categoryid) REFERENCES category(categoryid));

insert into product value(
'23502', '1234', 'Redmi Note11', 'redmi smartphone 6GB RAM,128GB storage', '1000.00', 'https://m.media-amazon.com/images/I/71yTvU9VgdL._SL1500_.jpg', '1', '0', '2022-08-01 00:00:00.000000', '2022-08-01 00:00:00.000000', '235'),
('23528', '1234', 'iphone13pro', 'Apple iPhone 13 Pro (128GB) - Sierra Blue', '110900.00', 'https://m.media-amazon.com/images/I/61jLiCovxVL._SL1500_.jpg', '1', '40', '2022-07-01 00:00:00.000000', '2022-06-15 00:00:00.000000', '235');