insert into category(category_name,parent_category_id)
values('clothing',default),
('men',1),
('women',1),
('kids',1),
('electronics',default),
('home appliances',5),
('gadgets',5);

insert into product(product_name,price,quantity)
values('cooker',400,3),
('mobile',6000,6),
('pant',2000,5),
('jean',2500,4),
('kurta',600,2),
('saree',8000,5);

insert into product_category(category_id,product_id)
values(2,3),
(3,4),
(3,5),
(3,6),
(4,4),
(6,1),
(7,2),
(1,3),
(1,4),
(1,5),
(1,6),
(5,1),
(5,2);

insert into image(product_id,image_name)
values(1,'cooker image'),
(4,'jean image'),
(4,'jean image 2');

Insert into address(country, state, city, area, zipcode) 
values ('India', 'Rajasthan', 'Jaipur', 'Jagatpura', 302014),
('India', 'Jharkhand', 'Ranchi', 'palsana', 332402);

insert into user(user_name,phone_no,email_id)
values('yatika',9829287632,'yatika@gmail.com'),
('khushi',9836579231,'khushi@yahoo.com'),
('yash',8754639021,'yash@metacube.com');

insert into product_order(order_date,user_id)
values('2017-04-26',1),
('2018-07-03',2);

insert into order_item(order_id,product_id,quantity,product_status)
values(1,1,2,'Shipped'),
(1,4,1,'Shipped'),
(2,3,3,'Cancelled'),
(2,4,1,'Shipped'),
(2,5,1,'Returned');

insert into order_address(address_id,order_id)
values(1,1),
(2,2);
