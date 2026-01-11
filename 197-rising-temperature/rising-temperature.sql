# Write your MySQL query statement below
/* select today.id from Weather as today
where exists
(
    select 1 from Weather as yesterday
    where yesterday.temperature < today.temperature
    and
    today.recordDate - yesterday.recordDate = 1
);
*/

SELECT w1.id
FROM Weather w1
JOIN Weather w2
  ON w1.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY)
WHERE w1.temperature > w2.temperature;
