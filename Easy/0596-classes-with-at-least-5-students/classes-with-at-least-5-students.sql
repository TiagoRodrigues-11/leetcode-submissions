-- Write your PostgreSQL query statement below

SELECT class
FROM (
    SELECT class, COUNT(student) AS count
    FROM Courses
    GROUP BY class
)
WHERE count >= 5
