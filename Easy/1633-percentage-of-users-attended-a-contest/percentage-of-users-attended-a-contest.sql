-- Write your PostgreSQL query statement below

SELECT 
    r.contest_id, 
    ROUND(COUNT(r.user_id) * 100.0 / tu.total_users, 2) AS percentage
FROM Register r
LEFT JOIN Users u ON r.user_id = u.user_id
CROSS JOIN (SELECT COUNT(*) AS total_users FROM Users) tu
GROUP BY r.contest_id, tu.total_users
ORDER BY percentage DESC, contest_id ASC;