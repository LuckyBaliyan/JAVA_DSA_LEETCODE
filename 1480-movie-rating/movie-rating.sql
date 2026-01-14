# Write your MySQL query statement below
(
    select u.name as results
    from Users u 
    join MovieRating m 
    on u.user_id = m.user_id 
    group by u.user_id 
    order by count(*) Desc,u.name Asc limit 1
)
union ALL
(
    select mv.title as results 
    from Movies mv
    join MovieRating m
    on mv.movie_id = m.movie_id
    where m.created_at between '2020-02-01' and '2020-02-29'
    group by mv.movie_id 
    order by avg(m.rating) DESC,mv.title ASC limit 1
)