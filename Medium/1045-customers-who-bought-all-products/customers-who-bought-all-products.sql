-- Write your PostgreSQL query statement below

SELECT customer_id
FROM (SELECT customer_id, COUNT(DISTINCT product_key) AS count
FROM Customer
GROUP BY customer_id) c1
JOIN (SELECT COUNT(*) AS count FROM Product) c2 ON c1.count = c2.count
