-- Write your PostgreSQL query statement below


WITH DailyAmount AS (
    SELECT visited_on, SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
)

SELECT da1.visited_on, SUM(da2.amount) AS amount, ROUND(SUM(da2.amount) / 7.0, 2) AS average_amount
FROM DailyAmount da1
JOIN DailyAmount da2
ON da2.visited_on BETWEEN da1.visited_on - INTERVAL '6 day' AND da1.visited_on
GROUP BY da1.visited_on
HAVING COUNT(*) = 7
ORDER BY da1.visited_on ASC
