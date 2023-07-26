# Problem Name : 1280. Students and Examinations

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
select
	students.student_id,
	students.student_name,
	subjects.subject_name,
	count(examinations.subject_name) as attended_exams
from
	students
cross join
	subjects
left join
	examinations
on
	students.student_id = examinations.student_id
	and subjects.subject_name = examinations.subject_name
group by
	students.student_id,
	students.student_name,
	subjects.subject_name
order by
	students.student_id,
	subjects.subject_name;
```