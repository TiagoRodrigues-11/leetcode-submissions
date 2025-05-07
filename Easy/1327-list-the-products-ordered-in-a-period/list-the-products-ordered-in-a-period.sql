-- Write your PostgreSQL query statement below

WITH FebruaryOrders AS (
    SELECT *
    FROM Orders
    WHERE EXTRACT('month' FROM order_date) = 2 AND EXTRACT('year' FROM order_date) = 2020
)


SELECT product_name AS product_name, SUM(fo.unit) as unit
FROM FebruaryOrders fo
JOIN Products p ON fo.product_id = p.product_id
GROUP BY product_name
HAVING  SUM(fo.unit) >= 100

