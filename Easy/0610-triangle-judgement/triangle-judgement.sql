-- Write your PostgreSQL query statement below


SELECT *, (CASE WHEN x+y <= z OR y+z <= x OR z+x <= Y THEN 'No' ELSE 'Yes' END) AS triangle 
FROM Triangle