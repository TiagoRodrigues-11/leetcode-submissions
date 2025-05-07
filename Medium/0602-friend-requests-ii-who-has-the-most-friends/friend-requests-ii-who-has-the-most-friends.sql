-- Write your PostgreSQL query statement below

WITH NumRequester AS (
    SELECT requester_id, COUNT(requester_id) AS num_requester
    FROM RequestAccepted
    GROUP BY requester_id
), NumAccepter AS (
    SELECT accepter_id, COUNT(accepter_id) AS num_accepter
    FROM RequestAccepted
    GROUP BY accepter_id
)


SELECT 
    COALESCE(requester_id, accepter_id) AS id, 
    COALESCE(num_requester, 0)+COALESCE(num_accepter, 0) AS num
FROM NumRequester
FULL JOIN NumAccepter ON requester_id = accepter_id
ORDER BY num DESC
LIMIT 1