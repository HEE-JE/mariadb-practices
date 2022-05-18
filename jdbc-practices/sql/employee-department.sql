-- DepartmentDao.findAll
select no, name from department order by no desc;

-- EmployeeDao.findAll
select no, name, department_no from employee order by no desc;

-- EmployeeDao.delete
delete from employee;

insert into department values(null, '솔루션');
delete from department where no = 8;

-- DepartmentDao.update
update department set name = '솔루션개발' where no = 3;