select name Customers from Customers where id not in (select c.id from Customers c join Orders o on o.customerId=c.id);
