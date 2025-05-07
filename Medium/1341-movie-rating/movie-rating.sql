-- Write your PostgreSQL query statement below

WITH MaxRatingMovie AS (
    SELECT title
    FROM (
        SELECT title, AVG(rating) AS avg_rating
        FROM MovieRating mr
        JOIN Movies m ON mr.movie_id = m.movie_id
        WHERE EXTRACT(MONTH FROM created_at) = 2 AND EXTRACT(YEAR FROM created_at) = 2020
        GROUP BY title
    )
    ORDER BY avg_rating DESC, title ASC
    LIMIT 1
), MaxNumRatingUser AS (
    SELECT name
    FROM (
        SELECT name, COUNT(rating) AS num_rating
        FROM MovieRating mr
        JOIN Users u ON mr.user_id = u.user_id
        GROUP BY name
    )
    ORDER BY num_rating DESC, name ASC
    LIMIT 1
)

SELECT name AS results FROM MaxNumRatingUser
UNION ALL 
SELECT title FROM MaxRatingMovie
