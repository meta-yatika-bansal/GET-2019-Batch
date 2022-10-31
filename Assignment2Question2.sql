select p.product_id,p.product_name,p.price,c.category_name
from product as p inner join product_category as pc on p.product_id = pc.product_id
inner join category as c on pc.category_id = c.category_id
where p.quantity > 0
order by p.product_id desc;

select p.product_name
from product as p left outer join image as i on p.product_id = i.product_id
where image_id is null;

select c.category_id,c.category_name,ifnull(d.category_name,'Top Category') as parent
from category c left outer join category d on c.parent_category_id = d.category_id
order by d.category_name,c.category_name;

select c.category_id,c.category_name,d.category_name as parent
from category c right outer join category d on c.parent_category_id = d.category_id
where c.category_name is not null;

select p.product_name,p.price
from product as p inner join product_category as pc on p.product_id = pc.product_id
inner join category as c on pc.category_id = c.category_id
where c.category_name = 'men';

select product_name
from product
where quantity < 50;