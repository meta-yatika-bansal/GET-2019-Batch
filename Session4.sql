/*Assignment 1 Question 1*/
delimiter $$ 

create function numberOfOrders(month int , year int) 
returns int
begin
declare number int;
select count(order_id) into number
from product_order
where extract(month from order_date) = month
and extract(year from order_date) = year;
return number;
end $$

delimiter ;


/*Assignment 1 Question 2*/
 delimiter $$
 
 create function monthHavingMaxOrder(year int)
 returns int
 begin
 declare mon int;
 select extract(month from order_date) into mon
 from product_order
 where extract(year from order_date) = year
 group by mon
 order by count(order_id) desc
 limit 1;
 return mon;
 end $$
 
 delimiter ;
 
 
/*Assignment 2 Question 1*/
 delimiter $$

create procedure avgSale(in month int,in year int)
begin
select o.product_id,sum(o.quantity)
from product_order as po inner join order_item as o on po.order_id = o.order_id
where extract(month from order_date) = month
and extract(year from order_date) = year
group by product_id;
end $$

delimiter ;


/*Assignment 2 Question 2*/
delimiter $$

create procedure orderDetailForPeriod(in startDate date, in endDate date)
begin
declare start date;

if(startDate > endDate) then 
select date_sub(endDate,interval day(endDate)+1 day) into start;
else 
select startDate into start;
end if;

select po.order_id,po.order_date,po.order_amount,o.product_id,o.product_status
from product_order as po inner join order_item as o on po.order_id = o.order_id
where po.order_date >= start
and po.order_date <= endDate;
end $$

delimiter ;


/*Assignment 3*/
explain select category_id
from category
where category_name = 'men';

alter table category
add index name_index(category_name);

explain select product_name
from product
where product_name = 'mobile';

alter table product
add index name_index(product_name);

explain select product_name
from product
where price between 1000 and 6000;

alter table product
add index price_index(price);

explain select user_id,order_id,order_amount
from product_order
where order_date = '2017-04-26';

alter table product_order
add index date_index(order_date);