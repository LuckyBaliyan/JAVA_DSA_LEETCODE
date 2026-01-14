# Write your MySQL query statement below

# Select first 7 chars from date as moth

select LEFT(trans_date,7) as month,
country, 
count(*) as trans_count,
SUM(CASE WHEN state = "approved" THEN 1 ELSE 0 END) as approved_count,
SUM(amount) as trans_total_amount,
SUM(CASE WHEN state = "approved" THEN amount ELSE 0 END) as approved_total_amount

from Transactions
group by month,country;