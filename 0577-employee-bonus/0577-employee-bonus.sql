/* Write your T-SQL query statement below */
select e.name, b.bonus from employee e left join bonus b on e.empid = b.empid where b.bonus < 1000 or b.bonus is null
