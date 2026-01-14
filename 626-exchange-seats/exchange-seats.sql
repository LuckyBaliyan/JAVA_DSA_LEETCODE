# Write your MySQL query statement below
select 
    case 
      when id % 2 = 1 AND id = (select max(id) from Seat) then id
      when id % 2 = 1 then id+1
      else id - 1
    END as id,
    student 
from Seat order by id;