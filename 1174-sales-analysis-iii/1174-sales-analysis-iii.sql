with cte as
(
select product_id,product_name from Product where product_id not in(
select p.product_id from Product p
join Sales s on p.product_id=s.product_id where s.sale_date<'2019-01-01' or s.sale_date>'2019-03-31')
)
select cte.product_id,cte.product_name from cte  where cte.product_id in (select p.product_id from Product p
join Sales s on p.product_id=s.product_id )