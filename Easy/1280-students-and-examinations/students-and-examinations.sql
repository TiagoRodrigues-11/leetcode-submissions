-- Write your PostgreSQL query statement below

SELECT s.student_id, s.student_name, su.subject_name, COUNT(e.student_id) AS attended_exams 
FROM Students s
CROSS JOIN Subjects su
FULL JOIN Examinations e ON s.student_id = e.student_id AND e.subject_name = su.subject_name
WHERE s.student_id IS NOT NULL AND su.subject_name IS NOT NULL
GROUP BY s.student_id, s.student_name, su.subject_name
ORDER BY s.student_id, su.subject_name
