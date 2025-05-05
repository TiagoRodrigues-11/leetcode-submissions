-- Write your PostgreSQL query statement below

SELECT start_table.machine_id, ROUND(AVG(end_time - start_time)::numeric, 3) AS processing_time
FROM (
    SELECT machine_id, process_id, timestamp AS start_time
    FROM Activity
    WHERE activity_type = 'start'
) start_table FULL JOIN (
    SELECT machine_id, process_id, timestamp AS end_time
    FROM Activity
    WHERE activity_type = 'end'
) end_table ON start_table.machine_id = end_table.machine_id
GROUP BY start_table.machine_id;
