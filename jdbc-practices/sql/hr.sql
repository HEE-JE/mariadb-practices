desc employees;

-- findByNameFirstNameOrLastName
select emp_no, first_name, last_name, date_format(hire_date, '%Y-%m-%d') 
	from employees
	where first_name like '%ken%'
    or first_name like '%ken%'
    order by hire_date;
    
-- 	findBysalary
select a.emp_no, a.first_name, a.last_name, b.salary
	from employees a, salaries b
    where a.emp_no = b.emp_no
    and b.to_date = '9999-01-01'
    and 10000 <= b.salary
    and b.salary <= 50000
    order by b.salary desc;