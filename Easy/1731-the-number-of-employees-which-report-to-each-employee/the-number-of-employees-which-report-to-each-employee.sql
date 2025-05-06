-- Write your PostgreSQL query statement below

SELECT employee_id, name, reports_count, average_age 
FROM (
    SELECT reports_to, ROUND(AVG(age), 0) AS average_age, COUNT(employee_id) AS reports_count 
    FROM Employees
    WHERE reports_to IS NOT NULL
    GROUP BY reports_to
) a
JOIN Employees e ON a.reports_to = e.employee_id 
ORDER BY employee_id