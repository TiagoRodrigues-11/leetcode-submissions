-- Write your PostgreSQL query statement below

SELECT 
    p.product_id, 
    ROUND(
        COALESCE(
            SUM(p.price * us.units) * 1.0 / NULLIF(SUM(us.units), 0), 0
        ), 2
    ) AS average_price
FROM Prices p
LEFT JOIN UnitsSold us 
    ON us.product_id = p.product_id 
    AND p.start_date <= us.purchase_date 
    AND us.purchase_date <= p.end_date
GROUP BY p.product_id
