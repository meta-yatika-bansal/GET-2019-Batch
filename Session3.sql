/*Assignment2 Question1*/
select p.product_id,p.product_name,count(category_id)
from product as p inner join product_category as pc on p.product_id = pc.product_id
group by product_id
having count(category_id) > 1;

/*Assignment2 Question2*/
select count(product_id) as CountOfProducts,
case when price between 0 and 100 then '0-100'
when price between 101 and 500 then '101-500'
else '>500'
end as RangeInRs
from product
group by RangeInRs;

/*Assignment2 Question3*/
select c.category_name,count(pc.product_id) as NumberOfProducts
from category as c inner join product_category as pc on c.category_id=pc.category_id
group by pc.category_id;

/*Assignment3 Question1*/
select u.user_name,count(uo.order_id) as NumberOfOrders
from user as u inner join user_order as uo on u.user_id=uo.user_id
inner join product_order as p on p.order_id = uo.order_id
where datediff(curdate(),p.order_date) <= 30
group by u.user_id;

/*Assignment3 Question2*/
select u.user_name
from user as u inner join user_order as uo on u.user_id=uo.user_id
inner join product_order as p on p.order_id = uo.order_id
where datediff(curdate(),p.order_date) <= 30
group by u.user_id
order by p.order_amount desc
limit 10;

/*Assignment3 Question3*/
select p.product_name,count(o.product_id)*o.quantity as number
from product_order as po inner join order_item as o on po.order_id=o.order_id
inner join product as p on p.product_id=o.product_id
where datediff(curdate(),po.order_date) <= 60
group by o.product_id
order by count(o.product_id)*o.quantity desc
limit 20;

/*Assignment3 Question4*/
select extract(month from order_date) as month,sum(order_amount) as total
from product_order
where datediff(curdate(),order_date)/365 <= 1
group by month;

/*Assignment3 Question5*/
alter table product
add active boolean default 1;

update product as p left outer join order_item as o on p.product_id=o.product_id 
left outer join product_order as po on po.order_id=o.order_id
set p.active = 0
where datediff(curdate(),po.order_date) > 90
or o.order_id is null;

/*Assignment3 Question6*/
select p.product_name
from product as p inner join product_category as pc on p.product_id = pc.product_id
inner join category as c on c.category_id=pc.category_id
where c.category_name = 'women';

/*Assignment3 Question7*/
select p.product_name
from product as p inner join order_item as o on p.product_id=o.product_id
where o.product_status = 'Cancelled'
group by o.product_id
order by count(product_status) desc
limit 10;

/*Assignment4*/
create table auto_zipcode_map(
zipcode int,
state varchar(20),
city varchar(20),
primary key(zipcode)
);

insert into auto_zipcode_map(zipcode,state,city)
values(332402,'Jharkhand', 'Ranchi'),
(302014,'Rajasthan', 'Jaipur');

select zipcode,city,state
from auto_zipcode_map
order by state,city;

/*Assignment5*/
create view orderInformation as
select po.order_id,po.order_date,u.user_name,u.email_id,po.order_amount,p.product_name,o.product_status,o.product_id,o.quantity
from user as u inner join user_order as uo on u.user_id=uo.user_id
left outer join product_order as po on po.order_id=uo.order_id
left outer join order_item as o on o.order_id=po.order_id
left outer join product as p on p.product_id=o.product_id
where datediff(curdate(),po.order_date) <= 60;

select product_name
from orderInformation
where product_status = 'Shipped'
group by product_id;

select product_name
from orderInformation
group by product_id
order by sum(quantity) desc
limit 5;






































