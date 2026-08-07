-- Write your query below
select name from customers c
     LEFT JOIN orders o ON 
        c.id = o.customer_id where o.customer_id is NULL;