# Write your MySQL query statement below
select pid project_id,round(avg(ey),2) average_years from (select p.project_id pid,p.employee_id eid,e.experience_years ey from Project p
join Employee e on p.employee_id=e.employee_id) cc group by pid;