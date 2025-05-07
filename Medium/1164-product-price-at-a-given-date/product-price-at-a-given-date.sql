-- Write your PostgreSQL query statement below


SELECT p.product_id, (CASE WHEN p1.new_price IS NULL THEN 10 ELSE p1.new_price END) AS price
FROM (
    SELECT product_id, MAX(change_date) AS last_date
    FROM Products
    WHERE change_date <= DATE '2019-08-16'
    GROUP BY product_id
) l 
RIGHT JOIN (
    SELECT product_id
    FROM Products 
    GROUP BY product_id
) p ON l.product_id = p.product_id
LEFT JOIN Products p1 ON p.product_id = p1.product_id AND l.last_date = p1.change_date 
