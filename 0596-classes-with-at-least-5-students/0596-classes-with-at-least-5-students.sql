# Write your MySQL query statement below
select c class from(select class c,count(*) cnt from
Courses group by class) as cc where cnt>=5;