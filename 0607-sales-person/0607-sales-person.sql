# Write your MySQL query statement below
select name from SalesPerson where name not in(select s.name nn
from SalesPerson s
left join Orders o on o.sales_id=s.sales_id 
left join Company c on o.com_id=c.com_id where c.name="RED") ;