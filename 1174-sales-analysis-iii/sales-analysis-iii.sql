# Write your MySQL query statement below
select p.product_id, p.product_name
from Product p
inner join Sales s
on p.product_id = s.product_id
where sale_date between '2019-01-01' and '2019-03-31'
EXCEPT
select p.product_id, p.product_name
from Product p
inner join Sales s
on p.product_id = s.product_id
where sale_date not between '2019-01-01' and '2019-03-31'