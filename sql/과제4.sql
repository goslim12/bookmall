-- 문제 1
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select  count(*)
	from salaries as s, employees as e
	where s.to_date = '9999-01-01'
	and s.emp_no = e.emp_no
    and s.salary>(select avg(s.salary)
		from salaries as s, employees as e
		where s.to_date = '9999-01-01'
		and s.emp_no = e.emp_no);


-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서, 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
       select d2.dept_no,max(s.salary) as max_sal
		from departments as d2, dept_emp as d, employees as e, salaries as s
		where s.to_date like '9999%'
        and d.to_date like '9999%'
        and d2.dept_no = d.dept_no
		and d.emp_no = e.emp_no
		and e.emp_no = s.emp_no
		group by d2.dept_no; 
        
        
select s.emp_no, concat(e.first_name,' ',e.last_name), d2.dept_name, s.salary
from(
		select d2.dept_no,max(s.salary) as max_sal
		from departments as d2, dept_emp as d, employees as e, salaries as s
		where s.to_date like '9999%'
        and d.to_date like '9999%'
        and d2.dept_no = d.dept_no
		and d.emp_no = e.emp_no
		and e.emp_no = s.emp_no
		group by d2.dept_no) a, salaries as s, employees as e, dept_emp as d, departments as d2
where s.to_date like '9999%'
and d.to_date like '9999%'
and d.emp_no = e.emp_no
and a.max_sal = s.salary
and e.emp_no = s.emp_no
and a.dept_no = d.dept_no
and d2.dept_no = d.dept_no;



-- 문제 3
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
      
select s.emp_no, concat(e.first_name,' ',e.last_name), s.salary
from (select dept_name as avg_dept,avg(s.salary) as avg_sal
	  from departments as d2, dept_emp as d, employees as e, salaries as s
	  where s.to_date = '9999-01-01'
	  and d.to_date = '9999-01-01'
      and d2.dept_no = d.dept_no
	  and d.emp_no = e.emp_no
	  and e.emp_no = s.emp_no
	  group by d2.dept_name) a, departments as d2, dept_emp as d, employees as e, salaries as s
where s.to_date = '9999-01-01'
and d.to_date = '9999-01-01'
and d2.dept_no = d.dept_no
and d.emp_no = e.emp_no
and e.emp_no = s.emp_no
and a.avg_dept = d2.dept_name
and s.salary > a.avg_sal
;

-- 문제 4
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.        
 
select e.emp_no,e.last_name,a.manager_name, a.dept_name
from (      select d3.dept_no, d2.dept_name,e.last_name as manager_name
		from dept_manager as d3, departments as d2, employees as e
		where d3. to_date = '9999-01-01'
		and d3.dept_no = d2.dept_no
        and d3.emp_no = e.emp_no) a, employees as e, dept_emp as d
where d.to_date = '9999-01-01'
and e.emp_no = d.emp_no
and a.dept_no = d.dept_no;


-- 문제 5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
            
select e.emp_no,e.last_name, t.title,s.salary
from (select d.dept_no, d2.dept_name, avg(s.salary) as avg_sal
			from employees as e, salaries as s, dept_emp as d, departments as d2
			where s.to_date = '9999-01-01'
			and d.to_date = '9999-01-01'
			and s.emp_no = e.emp_no
			and d.emp_no = e.emp_no
			and d2.dept_no=d.dept_no
			group by d.dept_no
having round(avg(s.salary))>= round((select max(a.avg_sal)
		from
			(select d.dept_no, d2.dept_name, avg(s.salary) as avg_sal
			from employees as e, salaries as s, dept_emp as d, departments as d2
			where s.to_date = '9999-01-01'
			and d.to_date = '9999-01-01'
			and s.emp_no = e.emp_no
			and d.emp_no = e.emp_no
			and d2.dept_no=d.dept_no
			group by d.dept_no) a)))a,dept_emp as d, employees as e, salaries as s, titles as t
where d.to_date='9999-01-01'
and s.to_date='9999-01-01'
and t.to_date='9999-01-01'
and d.emp_no=e.emp_no
and e.emp_no=t.emp_no
and s.emp_no=e.emp_no
and a.dept_no = d.dept_no;
        
-- 문제 6
-- 평균 연봉이 가장 높은 부서는? 
select d2.dept_name
			from employees as e, salaries as s, dept_emp as d, departments as d2
			where s.to_date = '9999-01-01'
			and d.to_date = '9999-01-01'
			and s.emp_no = e.emp_no
			and d.emp_no = e.emp_no
			and d2.dept_no=d.dept_no
			group by d.dept_no
having round(avg(s.salary))>= round((select max(a.avg_sal)
		from
			(select d.dept_no, d2.dept_name, avg(s.salary) as avg_sal
			from employees as e, salaries as s, dept_emp as d, departments as d2
			where s.to_date = '9999-01-01'
			and d.to_date = '9999-01-01'
			and s.emp_no = e.emp_no
			and d.emp_no = e.emp_no
			and d2.dept_no=d.dept_no
			group by d.dept_no) a));
            
-- 문제 7
-- 평균 연봉이 가장 높은 직책?

select t.title
from titles as t, employees as e, salaries as s
where s.to_date = '9999-01-01'
and t.to_date = '9999-01-01' 
and e.emp_no = t.emp_no
and e.emp_no = s.emp_no
group by t.title
having round(avg(s.salary)) >=(
	select max(a.avg_sal)
	from (select t.title, round(avg(s.salary)) as avg_sal
	from titles as t, employees as e, salaries as s
	where s.to_date = '9999-01-01'
	and t.to_date = '9999-01-01' 
	and e.emp_no = t.emp_no
	and e.emp_no = s.emp_no
	group by t.title) as a);


-- 8번
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.

select a.dept_name, e.last_name, s.salary,a.mana_name,a.mana_sal
from (
  select d3.dept_no, e.emp_no as mana_no, d2.dept_name, s.salary as mana_sal,e.last_name as mana_name
		from dept_manager as d3, departments as d2, employees as e, salaries as s
		where d3. to_date = '9999-01-01'
        and s.to_date = '9999-01-01'
		and d3.dept_no = d2.dept_no
        and d3.emp_no = e.emp_no
        and s.emp_no = e.emp_no)a, dept_emp as d, employees as e, salaries as s
where d.to_date ='9999-01-01'
and s.to_date = '9999-01-01' 
and e.emp_no = s.emp_no
and e.emp_no = d.emp_no
and a.dept_no = d.dept_no
and s.salary>a.mana_sal
;

select d3.dept_no, e.emp_no as mana_no, d2.dept_name, s.salary as mana_sal ,e.last_name as mana_name
		from dept_manager as d3, departments as d2, employees as e, salaries as s
		where d3. to_date = '9999-01-01'
        and s.to_date = '9999-01-01'
		and d3.dept_no = d2.dept_no
        and d3.emp_no = e.emp_no
        and s.emp_no = e.emp_no;
