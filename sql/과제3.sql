-- 문제 1
-- 현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력 하시오.

select e.emp_no, e.last_name, s.salary
from salaries as s, employees as e
where s.to_date='9999-01-01'
and s.emp_no = e.emp_no
order by s.salary;

-- 문제 2
-- 전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력하세요.
select e.emp_no,concat(e.first_name,' ',e.last_name) as name, t.title
from employees as e, titles as t
where t.to_date = '9999-01-01'
and e.emp_no = t.emp_no
order by name;

-- 문제 3
-- 전체 사원의 사번, 이름, 현재 부서를 이름 순서로 출력하세요

select e.emp_no,concat(e.first_name,' ',e.last_name) as name, d2.dept_name
from employees as e,dept_emp as d, departments as d2
where d.to_date='9999-01-01'
and e.emp_no = d.emp_no
and d.dept_no = d2.dept_no
order by name;


-- 문제 4
-- 전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력합니다.

select e.emp_no,concat(e.first_name,' ',e.last_name) as name,s.salary, t.title,d2.dept_name
from employees as e,dept_emp as d, departments as d2, salaries as s, titles as t
where d.to_date='9999-01-01'
and s.to_date = '9999-01-01'
and t.to_date = '9999-01-01'
and e.emp_no = t.emp_no
and e.emp_no = s.emp_no
and e.emp_no = d.emp_no
and d.dept_no = d2.dept_no
order by name;

-- 문제 5
-- ‘Technique Leader’의 직책으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하세요. (현재 ‘Technique Leader’의 직책(으로 근무하는 사원은 고려하지 않습니다.) 이름은 first_name과 last_name을 합쳐 출력 합니다.


select e.emp_no,concat(e.first_name,' ',e.last_name) as name
from employees as e,titles as t
where t.to_date != '9999-01-01'
and t.emp_no = e.emp_no;

-- 문제 6
-- 직원 이름(last_name) 중에서 S(대문자)로 시작하는 직원들의 이름, 부서명, 직책을 조회하세요.
select concat(e.first_name,' ',e.last_name) as name,d2.dept_name, t.title
from employees as e,dept_emp as d, departments as d2, titles as t
where d.to_date='9999-01-01'
and t.to_date = '9999-01-01'
and e.emp_no = t.emp_no
and e.emp_no = d.emp_no
and d.dept_no = d2.dept_no
and e.last_name !='S%';


-- 문제 7
-- 현재, 직책이 Engineer인 사원 중에서 현재 급여가 40000 이상인 사원을 급여가 큰 순서대로 출력하세요.
select e.emp_no,concat(e.first_name,' ',e.last_name) as name,s.salary, t.title
from employees as e, salaries as s, titles as t
where s.to_date = '9999-01-01'
and t.to_date = '9999-01-01'
and e.emp_no = t.emp_no
and e.emp_no = s.emp_no
and s.salary >=40000
and t.title = 'Engineer'
order by s.salary desc;


-- 문제 8
-- 현재 급여가 50000이 넘는 직책을 직책, 급여로 급여가 큰 순서대로 출력하시오
-- 잘못된 문제(건너뜀)

-- 문제 9
-- 현재, 부서별 평균 연봉을 연봉이 큰 부서 순서대로 출력하세요
select d2.dept_name, avg(s.salary)
from employees as e,dept_emp as d, departments as d2, salaries as s, titles as t
where d.to_date='9999-01-01'
and s.to_date = '9999-01-01'
and t.to_date = '9999-01-01'
and e.emp_no = t.emp_no
and e.emp_no = s.emp_no
and e.emp_no = d.emp_no
and d.dept_no = d2.dept_no
group by d2.dept_name;

-- 문제 10
-- 현재, 직책별 평균 연봉을 연봉이 큰 직책 순서대로 출력하세요.

select t.title, avg(s.salary) as avg_sal
from employees as e, titles as t, salaries as s
where t.to_date = '9999-01-01'
and s.to_date = '9999-01-01'
and s.emp_no = e.emp_no
and e.emp_no = t.emp_no
group by t.title
order by avg_sal desc;