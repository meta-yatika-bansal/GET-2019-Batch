select o.order_id,o.order_date,i.quantity*p.price as order_Total
from product_order as o inner join order_item as i on o.order_id=i.order_id
inner join product p on p.product_id = i.product_id
group by order_id
order by order_date desc
limit 50;

create view update_amount as
select o.order_id, i.quantity*p.price as order_Total
from product_order as o inner join order_item as i on o.order_id=i.order_id
inner join product p on p.product_id = i.product_id
group by o.order_id;

update product_order ,update_amount
set order_amount = update_amount.order_Total
where product_order.order_id = update_amount.order_id;

select order_id
from product_order
order by order_amount desc
limit 10;

select o.order_id
from product_order as o inner join order_item as i on o.order_id=i.order_id
where datediff(curdate(),o.order_date) > 10
and i.product_status in('Cancelled','Returned')
group by order_id;

select user_name
from user as u inner join product_order as p on u.user_id = p.user_id
where datediff(curdate(),p.order_date)/30 >= 1;

select u.user_name, p.order_id
from user as u inner join product_order as p on u.user_id = p.user_id
where datediff(curdate(),p.order_date) < 15;

select product_id
from order_item
where product_status = 'Shipped'
and order_id = 1;

select i.product_id,o.order_date
from product_order as o inner join order_item as i on o.order_id=i.order_id
inner join product p on p.product_id = i.product_id
where p.price between 20 and 50;





