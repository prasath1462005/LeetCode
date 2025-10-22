# Write your MySQL query statement below
select s.student_id,s.student_name,sub.subject_name,COALESCE(cc.tot, 0) attended_exams
from Students s cross join Subjects sub 
left join (select student_id,subject_name,count(*) tot from Examinations group by student_id,subject_name ) as cc
on s.student_id=cc.student_id and sub.subject_name = cc.subject_name order by s.student_id,sub.subject_name; 