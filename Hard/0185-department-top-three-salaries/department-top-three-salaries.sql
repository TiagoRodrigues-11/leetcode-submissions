-- Write your PostgreSQL query statement below

WITH SalaryRank AS (
    SELECT *, DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS salary_rank
    FROM Employee
)

SELECT d.name AS Department, sr.name AS Employee, sr.salary AS Salary
FROM SalaryRank sr
JOIN Department d ON d.id = sr.departmentId
WHERE sr.salary_rank <= 3