-- Write your PostgreSQL query statement below


SELECT 
    s.user_id, 
    ROUND (
        COALESCE (
            COUNT(CASE WHEN conf.action = 'confirmed' THEN 1 END) * 1.0/ 
            NULLIF(COUNT(CASE WHEN conf.user_id IS NOT NULL THEN 1 END), 0), 0
        ), 2
    ) AS confirmation_rate
FROM Signups s
LEFT JOIN Confirmations conf ON s.user_id = conf.user_id
GROUP BY s.user_id

/*
SELECT conf_all.user_id, ROUND(COUNT(CASE WHEN conf.action = 'confirmed' THEN 1 END) / count_all, 2) AS confirmation_rate
FROM Signups s
LEFT JOIN Confirmations conf ON s.user_id = conf.user_id
GROUP BY s.user_id;
*/