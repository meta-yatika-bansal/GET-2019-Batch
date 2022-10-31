drop database StoreFront;

create database StoreFront;

use StoreFront;

create table category (
category_id  int AUTO_INCREMENT,
category_name varchar(100),
parent_category_id int default -1,
primary key(category_id)
);

create table product(
product_id int AUTO_INCREMENT,
product_name varchar(100),
price decimal(10,2),
quantity int,
primary key(product_id)
);

create table product_category(
category_id int,
product_id int,
foreign key(product_id) references product(product_id),
foreign key(category_id) references category(category_id)
);

create table image(
image_id int AUTO_INCREMENT,
image_name varchar(100),
product_id int,
primary key(image_id),
foreign key(product_id) references product(product_id)
);

create table address(
address_id int AUTO_INCREMENT,
country varchar(20),
state varchar(20),
city varchar(20),
area varchar(50),
zipcode int,
primary key(address_id)
);

create table user(
user_id int AUTO_INCREMENT,
user_name varchar(30),
phone_no bigint,
email_id varchar(20),
primary key(user_id)
);

create table product_order(
order_id int AUTO_INCREMENT,
order_amount decimal(10,2),
order_date date,
user_id int,
primary key(order_id),
foreign key(user_id) references user(user_id)
);

create table order_address(
address_id int,
order_id int,
foreign key(address_id) references address(address_id),
foreign key(order_id) references product_order(order_id)
);

create table order_item(
product_id int,
order_id int,
product_status varchar(10) check(product_status in('Shipped','Cancelled','Returned')),
quantity int,
foreign key(product_id) references product(product_id),
foreign key(order_id) references product_order(order_id)
);

show tables;

drop table product;

create table product(
product_id int AUTO_INCREMENT,
product_name varchar(100),
price decimal(10,2),
quantity int,
primary key(product_id)
);