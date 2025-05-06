-- Write your PostgreSQL query statement below


SELECT ROUND(COUNT(DISTINCT a.player_id) * 1.0/ COUNT(DISTINCT b.player_id), 2) AS fraction
FROM Activity a 
RIGHT JOIN (
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) b ON a.player_id = b.player_id AND a.event_date = b.first_login + INTERVAL '1 DAY'