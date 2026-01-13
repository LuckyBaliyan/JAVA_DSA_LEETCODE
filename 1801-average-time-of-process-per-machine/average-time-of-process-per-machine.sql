# Write your MySQL query statement below
select a1.machine_id,
ROUND(AVG(a2.timestamp - a1.timestamp),3) as 
processing_time
from 
Activity as a1,
Activity as a2

where a1.activity_type = "start" AND
a2.activity_type = "end" AND

a1.machine_id =  a2.machine_id and
a1.process_id = a2.process_id

group by machine_id;