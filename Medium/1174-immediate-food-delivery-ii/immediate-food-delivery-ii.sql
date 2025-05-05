-- Write your PostgreSQL query statement below


SELECT 
    ROUND( SUM(CASE WHEN first_order = customer_pref_delivery_date THEN 1 ELSE 0 END) * 100.0 / COUNT(DISTINCT d.customer_id), 2) AS immediate_percentage 
FROM Delivery d
JOIN (
    SELECT customer_id, MIN(order_date) AS first_order
    FROM Delivery
    GROUP BY customer_id
) fo ON d.customer_id = fo.customer_id;