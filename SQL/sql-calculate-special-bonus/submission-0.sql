-- Write your query below

select employee_id, 

       CASE  
           WHEN employee_id % 2 != 0 AND name NOT like 'M%' THEN salary 
           else 0
      END as bonus 

    from employees order by employee_id;
