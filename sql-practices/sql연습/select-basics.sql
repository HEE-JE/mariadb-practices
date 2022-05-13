-- select 연습
select * from departments order by dept_no limit 3, 3;
select dept_no, dept_name from departments;


-- alias(as 생략가능)
-- 예제1: employees 테이블에서 직원의 이름, 성별, 입사일을 출력
select first_name as 'firstName', gender as '성별', hire_date '입사일' from employees;

-- 예제2: employees 테이블에서 직원의 이름(성 + 이름), 성별, 입사일을 출력
select concat(first_name, last_name) as '이름', gender as '성별', hire_date '입사일' from employees;

-- distinct
-- 예제: titles 테이블에서 모든 직급의 이름을 출력
select distinct(title) from titles;

-- where절 #1
-- 예제:1991년 이전에 입사한 직원의 이름, 성별, 입사일을 출력
select concat(first_name, last_name) as '이름', gender as '성별', hire_date '입사일' from employees where hire_date < '1991-01-01' order by hire_date desc;

-- where절 #2: 논리 연산자
-- 예제:1989년 이전에 입사한 여직원의 이름, 성별, 입사일을 출력
select concat(first_name, last_name) as '이름', gender as '성별', hire_date '입사일' from employees where hire_date < '1989-01-01' and gender = 'F' order by hire_date desc;
