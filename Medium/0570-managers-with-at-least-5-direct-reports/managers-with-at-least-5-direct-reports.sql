-- Write your PostgreSQL query statement below

SELECT e.name
FROM (
    SELECT managerId, COUNT(managerId) AS count_man
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
) AS m 
JOIN Employee e on m.managerId = e.id
WHERE count_man >= 5;