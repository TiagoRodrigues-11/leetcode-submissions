-- Write your PostgreSQL query statement below

WITH SameTiv2015 AS (
    SELECT DISTINCT i1.pid AS pid1, i1.tiv_2016, i1.lat AS lat, i1.lon AS lon
    FROM Insurance i1
    JOIN Insurance i2 ON i1.tiv_2015 = i2.tiv_2015 AND i1.pid <> i2.pid
), UniqueLoc AS (
    SELECT lat, lon
    FROM Insurance i
    GROUP BY lat, lon
    HAVING COUNT(*) = 1
)

SELECT ROUND(SUM(tiv_2016)::numeric, 2) AS tiv_2016
FROM UniqueLoc ul
JOIN SameTiv2015 st ON ul.lat = st.lat AND ul.lon = st.lon