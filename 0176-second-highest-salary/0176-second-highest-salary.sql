SELECT max(salary) as SecondHighestSalary
FROM Employee
where salary < (SELECT max(salary) from Employee);