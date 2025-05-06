-- Write your PostgreSQL query statement below

SELECT e1.employee_id, e1.department_id
FROM Employee e1
JOIN (
    SELECT employee_id, COUNT(employee_id) AS count
    FROM Employee
    GROUP BY employee_id
) e2 ON e1.employee_id = e2.employee_id
WHERE primary_flag = 'Y' OR count = 1
