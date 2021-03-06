SELECT E.LAST_NAME,E.SALARY
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.EMPLOYEE_ID IN (SELECT MANAGER_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'IT');

SELECT E.LAST_NAME,E.SALARY
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.EMPLOYEE_ID IN (SELECT D.MANAGER_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'IT');

SELECT E.LAST_NAME,E.SALARY
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.EMPLOYEE_ID IN (SELECT MANAGER_ID FROM DEPARTMENTS WHERE D.DEPARTMENT_NAME = 'IT');

SELECT E.LAST_NAME,E.SALARY
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.EMPLOYEE_ID IN (SELECT D.MANAGER_ID FROM DEPARTMENTS WHERE D.DEPARTMENT_NAME = 'IT');

------------------------------------------HR연습 정답

SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;
SELECT * FROM COUNTRIES;
SELECT * FROM REGIONS;
SELECT * FROM JOB_HISTORY;
SELECT * FROM JOBS;

--01. 사원의 FULL_NAME(FIRST_NAME + LAST_NAME) 과 이메일을 출력하라.
--(이메일@HR.COM 으로 출력하라.) 

SELECT FIRST_NAME || ' ' || LAST_NAME, EMAIL || '@HR.COM'
FROM EMPLOYEES; 

SELECT CONCAT(CONCAT(FIRST_NAME, ' '), LAST_NAME), CONCAT(EMAIL, '@HR.COM')
FROM EMPLOYEES;

--02. 06년 이후에 입사한 사원의 이름(FIRST_NAME) 과 사원번호 (EMPLOYEE_ID)를 출력하라.

SELECT FIRST_NAME, EMPLOYEE_ID
FROM EMPLOYEES
WHERE HIRE_DATE >= '06/01/01';

--03. 사원의 이름(FIRST), 부서이름(DEPARTMENT_NAME), 부서가 있는 거리(STREET_ADDRESS), 
--부서가 있는 나라(COUNTRY_NAME) 를 출력하라.

SELECT FIRST_NAME, DEPARTMENT_NAME, STREET_ADDRESS, COUNTRY_NAME
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
     JOIN LOCATIONS USING(LOCATION_ID)
     JOIN COUNTRIES USING(COUNTRY_ID);

SELECT E.FIRST_NAME, D.DEPARTMENT_NAME, L.STREET_ADDRESS, C.COUNTRY_NAME
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L, COUNTRIES C
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
AND D.LOCATION_ID = L.LOCATION_ID
AND L.COUNTRY_ID = C.COUNTRY_ID;

--04. '부서번호가 90이고, 전화번호가 515로 시작하면서, 끝자리가 4567인 사원'이 
--관리하는 사원의 사번과 이름을 출력하라.

SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE MANAGER_ID = 
	(SELECT EMPLOYEE_ID
	FROM EMPLOYEES
	WHERE DEPARTMENT_ID = 90
	AND PHONE_NUMBER LIKE '515.%.4567');

SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE MANAGER_ID = 
	(SELECT EMPLOYEE_ID
	FROM EMPLOYEES
	WHERE DEPARTMENT_ID = 90
	AND SUBSTR(PHONE_NUMBER, 1, 3) = 515
	AND SUBSTR(PHONE_NUMBER, -4) = 4567);

--05. 성이 B로 시작하는 사원이 속한 부서의 부서번호와, B로 시작하는 사원의 수를 출력하라.

SELECT DEPARTMENT_ID, COUNT(*)
FROM EMPLOYEES
WHERE LAST_NAME LIKE 'B%'
GROUP BY DEPARTMENT_ID;

--06. (5번 확장) 성이 B로 시작하는 사원이 속한 부서의 부서이름과 사원의 수를 출력하라.

SELECT DEPARTMENT_NAME, COUNT(*)
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
WHERE DEPARTMENT_ID IN
	(SELECT DEPARTMENT_ID
	FROM EMPLOYEES
	WHERE LAST_NAME LIKE 'B%'
	GROUP BY DEPARTMENT_ID)
GROUP BY DEPARTMENT_NAME;

SELECT D.DEPARTMENT_NAME, COUNT(*)
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
AND D.DEPARTMENT_ID IN
	(SELECT DEPARTMENT_ID
	FROM EMPLOYEES
	WHERE LAST_NAME LIKE 'B%'
	GROUP BY DEPARTMENT_ID)
GROUP BY D.DEPARTMENT_NAME;

--07. IT 프로그래머(IT_PROG : JOB_ID)의 평균 월급보다 
--더 많은 평균월급을 받는 부서들의 직업 이름과(JOB_ID) 평균 월급을 출력하라.
--(월급을 내림차순으로 정렬하라.)

SELECT JOB_ID, AVG(SALARY)
FROM EMPLOYEES
HAVING AVG(SALARY) > 
	(SELECT AVG(SALARY)
	FROM EMPLOYEES
	WHERE JOB_ID = 'IT_PROG')
GROUP BY JOB_ID
ORDER BY 2 DESC;

--08. 전화번호가 650.121.8009인 사원의 이름과, 사원이 속한 부서가 위치한 도시, 
--주소 를 출력하라.(이름 도시 주소)

SELECT FIRST_NAME, CITY, STREET_ADDRESS
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
     JOIN LOCATIONS USING(LOCATION_ID)
WHERE PHONE_NUMBER = '650.121.8009';

SELECT E.FIRST_NAME, L.CITY, L.STREET_ADDRESS
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
AND D.LOCATION_ID = L.LOCATION_ID
AND E.PHONE_NUMBER = '650.121.8009';

--09. 캐나다에서 일하고 있는 사원의 이름과, 도시, 월급을 출력하라.

SELECT FIRST_NAME, CITY, SALARY
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
     JOIN LOCATIONS USING(LOCATION_ID)
     JOIN COUNTRIES USING(COUNTRY_ID)
WHERE COUNTRY_NAME = 'Canada';

SELECT E.FIRST_NAME, L.CITY, E.SALARY
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L, COUNTRIES C 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
AND D.LOCATION_ID = L.LOCATION_ID
AND L.COUNTRY_ID = C.COUNTRY_ID
AND C.COUNTRY_NAME = 'Canada';

SELECT FIRST_NAME, CITY, SALARY
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
     JOIN LOCATIONS USING(LOCATION_ID)
WHERE COUNTRY_ID = 'CA';

--10. 이름이 Guy 인 사원과 같은 부서에서 일하면서, Guy와 직업(JOB_ID)이 다른 사원의 
--모든 것을 출력하라.

SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID =
	(SELECT DEPARTMENT_ID
	FROM EMPLOYEES
	WHERE FIRST_NAME = 'Guy')
AND JOB_ID !=
	(SELECT JOB_ID
	FROM EMPLOYEES
	WHERE FIRST_NAME = 'Guy');

--10-1. 이름이 Guy 인 사원과 같은 부서에서 일하면서, Guy와 직업(JOB_ID)도 같은 사원의 
--모든 것을 출력하라.

SELECT *
FROM EMPLOYEES
WHERE (DEPARTMENT_ID, JOB_ID) = 
	(SELECT DEPARMTENT_ID, JOB_ID
	FROM EMPLOYEES
	WHERE FIRST_NAME = 'Guy');

--11. 직책이 06년 7월 24일에 변경된 사원의 이름과, 과거 직업, 현재 직업을 출력하라.

SELECT * FROM JOB_HISTORY;

SELECT FIRST_NAME, 과거.JOB_ID, 현재.JOB_ID
FROM EMPLOYEES 현재,
	(SELECT EMPLOYEE_ID, JOB_ID
	FROM JOB_HISTORY
	WHERE END_DATE = '06/07/24') 과거
WHERE 현재.EMPLOYEE_ID = 과거.EMPLOYEE_ID;
	
--12. 관리자가 없는 부서의 이름과 부서번호를 출력하라.

SELECT DEPARTMENT_NAME, DEPARTMENT_ID
FROM DEPARTMENTS
WHERE MANAGER_ID IS NULL;

--13. 조인 키워드를 사용하지 않고, IT 부서 관리자의 성(LAST_NAME)과, 월급을 출력하라.

SELECT LAST_NAME, SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 
	(SELECT MANAGER_ID
	FROM DEPARTMENTS
	WHERE DEPARTMENT_NAME = 'IT');

--14. ROWNUM을 사용하여, 관리자가 존재하는 부서의 장소 중 가장 많은 장소의 도시 이름을 출력하라.

SELECT CITY, CNT, ROWNUM
FROM
	(SELECT CITY, COUNT(*) AS CNT
	FROM DEPARTMENTS JOIN LOCATIONS USING(LOCATION_ID)
	WHERE DEPARTMENT_ID IN
		(SELECT DEPARTMENT_ID
		FROM DEPARTMENTS
		WHERE MANAGER_ID IS NOT NULL)
	GROUP BY CITY
	ORDER BY COUNT(*) DESC) A
WHERE ROWNUM = 1;

--15. 18년도가 근속 10주년인 사원의 이름과 입사일을 출력하라.

SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE SUBSTR(ADD_MONTHS(HIRE_DATE, 120), 1, 2) = 18;

SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE FLOOR(MONTHS_BETWEEN(TO_DATE('2018-12-31','YYYY-MM-DD'),HIRE_DATE)/12) = 10;

SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE MONTHS_BETWEEN('2018-12-31', HIRE_DATE) < 132;

WHERE HIRE_DATE >='08/01/01' AND HIRE_DATE <='08/12/31';

WHERE '18' - substr(hire_date,1,2) = 10

-------------------------------------------내가 만든 문제

SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;
SELECT * FROM COUNTRIES;
SELECT * FROM REGIONS;
SELECT * FROM JOB_HISTORY;
SELECT * FROM JOBS;

--1
SELECT AVG(SALARY)
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
WHERE DEPARTMENT_NAME = 'Marketing';

--2
SELECT COUNTRY_NAME
FROM COUNTRIES JOIN REGIONS USING(REGION_ID)
WHERE REGION_NAME = 'Asia';

--3
SELECT MAX(SALARY)
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%A%';

--4
SELECT DEPARTMENT_NAME
FROM DEPARTMENTS
WHERE MANAGER_ID IS NULL;

--5
SELECT MAX_SALARY, FIRST_NAME
FROM JOBS JOIN EMPLOYEES USING(JOB_ID)
WHERE JOB_TITLE = 'Purchasing Manager';

--6
SELECT DEPARTMENT_NAME, FIRST_NAME
FROM JOB_HISTORY JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN EMPLOYEES USING(DEPARTMENT_ID)
WHERE START_DATE = '1995/09/17';


-------------------------------------------------HR연습2
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;
SELECT * FROM COUNTRIES;
SELECT * FROM REGIONS;
SELECT * FROM JOB_HISTORY;
SELECT * FROM JOBS;


--01. 유럽에서 근무하는 사람들의 직업 이름(JOB_TITLE)과 직업별 평균 월급을 구하시오.
SELECT JOB_TITLE, AVG(SALARY)
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
	 JOIN LOCATIONS USING(LOCATION_ID)
	 JOIN COUNTRIES USING(COUNTRY_ID)
	 JOIN REGIONS USING(REGION_ID)
	 JOIN JOBS USING(JOB_ID)
WHERE REGION_NAME = 'Europe'
GROUP BY JOB_TITLE;

--02. 과거 Accounting 부서에서 4년 이상 근무했던 사원의 이름과 전화번호를 출력하시오.
SELECT FIRST_NAME,PHONE_NUMBER
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN JOB_HISTORY USING(DEPARTMENT_ID)
WHERE DEPARTMENT_NAME = 'Accounting'
AND END_DATE - START_DATE >= 48;

--03. 평균연봉이 제일 높은 부서의 부서이름과, 평균연봉을 출력하시오.
SELECT DEPARTMENT_NAME, AVG(SALARY)
FROM DEPARTMENTS JOIN EMPLOYEES USING(DEPARTMENT_ID)

--04. 부하직원이 제일 많은 매니저의 이름, 이메일을 뽑으시오.

--05. 부서명, 부서별 직원수를 직원수가 많은 부서부터 출력하시오.

--06. 직원이 가장 많이 분포해 있는 도시 이름을 출력하시오.
SELECT CITY
FROM

--07. 근속연수 별 평균월급을 소수점 첫번째 자리에서 반올림하여 구하고, 근속연수 기준 오름차순 정렬하시오.

--08. 국가별 평균 월급을 소수점 두번째 자리에서 반올림하여, "국가이름" "평균월급" 으로 구하고, 평균월급 기준 내림차순 으로 출력하시오. 

--09. 연도별 입사자수를 출력하시오.

--10. 직업 이름 별 평균 연봉을 출력하시오.
SELECT JOB_TITLE, AVG(SALARY)
FROM EMPLOYEES JOIN JOBS USING(JOB_ID)
GROUP BY JOB_TITLE;

--11. 나라별로 연봉이 가장 높은 사람을 연봉 기준 내림차순하여 '나라이름','직원이름','연봉'으로 출력하시오.



-------------------------------------------------------------------------------------------------------HR 4조
--1. 근속 년수가 15년 이상인 사원의 이름(FIRST_NAME)과 입사일을 출력 

--2. ROWNUM을 사용하여, 관리자가 존재하는 부서중 평균 월급이 가장높은 부서를 출력
SELECT AVG(SALARY)
FROM 
(SELECT AVG(SALARY), COUNT(*) AS CNT
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
WHERE DEPARTMENT_ID IN
(SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE MANAGER_ID IS NOT NULL)
GROUP BY DEPARTMENT_ID) A
WHERE ROWNUM = 1;


--3. 아시아에서 일하는 사원의 이름(FIRST_NAME)과 국가(COUNTRY_NAME), 월급을 출력

--4. 08년 이후에 입사한 사원의 FULL NAME(FIRST_NAME+LAST_NAME)과 
   월급, 직업(JOB_TITLE)을 출력 

--5. 전화번호가 515.127.4562사원의 이름(FIRST)과 직업, 주소(STREET_ADDRESS)를 출력

--6. 직업이 'Accountant'이면서 가장 많은 월급을 받는 사원의 이름과 월급을 출력




--7. 사원테이블에서 부서별 평균 월급을 출력하되, 평균 월급이 2000보다 큰 부서의 부서번호와 평균 월급을 출력하자.

--8. 사원테이블에서 CUBE를 사용하여  각 직업별 평균월급을 출력하되, 월급이 높은 순으로 출력하자.(내림차순)

--9. 로마에서 일하고 있는 사람의 이름, 월급을 출력하자

--10. 직업이 SH_CLERK이면서, 입사일이 08년도 이후이고, 최소월급보다 많이 받는 사람들의 이름과 월급, 최소월급을 출력해라.

--11. 사원테이블에서 부서번호와 부서별 총 월급을 출력하되, 40번 부서와 60번 부서를 제외하고, 총 월급이 8000 이상인 부서를 총 월급이 낮은 순으로 출력하자.

--12. 전화번호가 011이 들어가는 사원들의 이름과 전화번호, 주소를 출력해라.



--13. 사원의 이름(FIRST_NAME)과 근무하는 도시명(CITY)을 출력하라.
SELECT FIRST_NAME, CITY
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN LOCATIONS USING(LOCATION_ID);

--14. 나라 아이디가UK인 곳에서 근무하는 사원은 몇명인지 출력
SELECT COUNT(*)
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN LOCATIONS USING(LOCATION_ID)
WHERE COUNTRY_ID = 'UK';
   
--15. IT부서와 같은 나라에서 근무하는 부서의 평균 급여 출력.
SELECT AVG(SALARY)
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN LOCATIONS USING(LOCATION_ID)
WHERE COUNTRY_ID IN (SELECT COUNTRY_ID FROM LOCATIONS JOIN DEPARTMENTS USING(LOCATION_ID) WHERE DEPARTMENT_NAME = 'IT');
   
--16.(03확장)IT부서와 같은 나라에서 근무하는 부서의 평균 급여 보다 많은 급여를 받는 사원의 이름, 부서명 출력.

--17. 근무하는 도시(CITY)가 Roma인 직원의 이름을 출력하고 이메일의 맨 앞글자만 출력하자.

--18. COUNTRY_ID가 CA인 나라에서 근무하는 사람의 JOB_TITLE을 출력하자



--19. 'FIRST_NAME', SALARY, JOB_TITLE,MIN_SALARY,MAXSALARY 컬럼을 가진 EMP_JOB라는 명칭의 테이블을 생성하시오. 

--20. 'EMP_JOB'에 EMAIL과 POHNE_NUMBER 컬럼을 추가하시오(값이 없어도 된다)

--21. 'EMP_JOB'에 직업별 평균 월급 값을 가진 컬럼을 'AVG_SAL'이라는 명칭으로 추가하고, 
--직업 평균값보다 월급이 많은 사원을 출력하시오
--그 후 AVG_SAL 테이블을 삭제하시오.

--22. 사원들의 월급 평균값이 가장 높은 지역 이름(REGION_NAME)을 출력하시오

--23. EMPLOYEE 테이블에서, 사원의 월급이 현재 월급 기준으로 동결되었다고 가정했을 때
--서울에 집을 사려면 돈을 한푼도 안쓰고 몇년을 모아야 하는지  각 사원별로 출력하시오
--(서울의 집값은 10억 7824만원이며, 테이블의 SALARY는 달러 이다. )

--24. 10년 안에 내집 마련이 가능한 사람을 오름차순으로 정렬하고, 해당 사원의 직업(JOB_TITLE), 이름, 국가(COUNTRY_NAME), 월급를 출력하시오


--25. 08년 이후에 입사한 사원의 이름(FIRST_NAME)과 전화번호(PHONE_NUMBER)를 출력

--26. 성이 K로 시작하는 사원이 속한 부서의 부서번화와, K로 시작하는 사원의 수를 출력

--27. 2015년도가 근속 10주년인 사원의 이름과 입사일을 출력

--28. 캐나다에서 일하고 있는 사원의 이름과, 도시, 월급, 직업을 출력

--29. (JOB_ID : SA_MAN)의 평균 월급보다 더 적은 평균월급을 받는 부서들의 직업 이름과(JOB_ID) 평균 월급을 출력
--(월급을 내림차순으로 정렬)
SELECT JOB_ID, AVG(SALARY)
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
HAVING AVG(SALARY) < (SELECT AVG(SALARY) FROM EMPLOYEES WHERE JOB_ID = 'SA_MAN')
GROUP BY DEPARTMENT_ID
ORDER BY AVG(SALARY) DESC;


--30. 관리자가 있는 부서의 이름과 부서번호를 출력하라.
SELECT DEPARTMENT_NAME, DEPARTMENT_ID
FROM EMPLOYEES JOIN DEPARTMENTS USING(MANAGER_ID)
WHERE MANAGER_ID IS NOT NULL;


