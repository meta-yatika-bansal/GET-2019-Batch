create database parking;

use parking;

create table employee(
employee_id int auto_increment,
full_name varchar(50),
gender varchar(10) check (gender in('male','female','other')),
email varchar(100),
password varchar(50),
contact_number bigint,
org varchar(50),
primary key(employee_id)
);

create table vehicle(
vehicle_id int auto_increment,
name varchar(50),
type varchar(50) check (type in('cycle','motorcycle','fourwheeler')),
vehicle_number int,
employee_id int,
identification varchar(200),
primary key(vehicle_id),
foreign key(employee_id) references employee(employee_id)
);

alter table vehicle
add index type_index(type);

create table pass(
type varchar(50),
daily decimal(10,2),
monthly decimal(10,2),
yearly decimal(10,2),
foreign key(type) references vehicle(type)
);