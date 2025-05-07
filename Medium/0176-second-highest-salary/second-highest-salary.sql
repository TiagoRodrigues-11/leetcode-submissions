SELECT MAX(salary) AS SecondHighestSalary 
FROM Employee e
WHERE e.salary NOT IN (
    SELECT MAX(salary) AS salary
    FROM Employee
)