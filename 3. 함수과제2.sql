/* 함수최종연습문제
1. 직원명과 이메일 , 이메일 길이를 출력하시오
		  이름	    이메일		이메일길이
	ex) 	홍길동 , hong@kh.or.kr   	  13
*/
SELECT
    EMP_NAME 이름,
    EMAIL 이메일,
    LENGTH(EMAIL)이메일길이
FROM EMPLOYEE;

--2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
--	ex) 노옹철	no_hc
--	ex) 정중하	jung_jh
SELECT
    EMP_NAME 이름,
--  SUBSTR(컬럼, 시작위치, 자를길이),INSTR(컬럼명, 찾을문자)=>@위치-1 한 만큼 추출!
    SUBSTR(EMAIL, 1 ,INSTR(EMAIL, '@')-1) 아이디
FROM EMPLOYEE;

--3. 60년생의 직원명과 년생, 보너스 값을 출력하시오 
--	그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
--	    직원명    년생      보너스
--	ex) 선동일	62	0.3
--	ex) 송은희	63  	0
SELECT
    EMP_NAME 직원명,
    SUBSTR(EMP_NO, 1, 2) 년생,
    NVL(BONUS, 0) 보너스 --NVL사용 NULL이면 0!
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 1, 1) = 6;
--4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
--	   인원
--	ex) 3명
SELECT
    COUNT(*)||'명' 인원
FROM EMPLOYEE
WHERE SUBSTR(PHONE,3,1) NOT IN 0;
--WHERE PHONE NOT LIKE '010%';

--5. 직원명과 입사년월을 출력하시오 
--	단, 아래와 같이 출력되도록 만들어 보시오
--	    직원명		입사년월
--	ex) 전형돈		2012년12월
--	ex) 전지연		1997년 3월
SELECT
    EMP_NAME 직원명,
    TO_CHAR(HIRE_DATE,'YYYY"년"fmMM"월"') 입사년월
FROM EMPLOYEE;

--6. 직원명과 주민번호를 조회하시오
--	단, 주민번호 9번째 자리부터 끝까지는 '*' 문자로 채워서출력 하시오
--	ex) 홍길동 771120-1******
SELECT
    EMP_NAME 직원명,
    RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') 주민번호
    --SUBSTR(EMP_NO,1,8)||'*******'
FROM EMPLOYEE;

--7. 직원명, 직급코드, 연봉(원) 조회
--  단, 연봉은 ￦57,000,000 으로 표시되게 함
--     연봉은 보너스포인트가 적용된 1년치 급여임
SELECT
    EMP_NAME 직원명,
    JOB_CODE 직급코드,
    TO_CHAR((SALARY + (SALARY * NVL(BONUS,0))) * 12, 'L999,999,999') "연봉(원)"
    
FROM EMPLOYEE;
--
--8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 
--   수 조회함.
--   사번 사원명 부서코드 입사일
SELECT
    EMP_ID,
    EMP_NAME,
    DEPT_CODE,
    HIRE_DATE,
    COUNT(*)||'명' 직원수
FROM EMPLOYEE
WHERE 1=1
AND DEPT_CODE IN('D5', 'D9')
AND SUBSTR(HIRE_DATE, 1, 2) = 04
GROUP BY EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE;
--왜 SELECT에 컬럼들을 넣으면 오류가 나는지 암!!!!!!!
--GROUP BY를 안 썼기 때문!! 그룹함수와 함께 사용
--SELECT 절에 이용할 칼럼은 반드시 GROUP BY에 입력해야함
--GROUP BY : 같은 값을 가진 행끼리 하나의 그룹으로 뭉쳐줌

--9. 직원명, 입사일, 오늘까지의 근무일수 조회 
--	* 주말도 포함 , 소수점 아래는 버림
SELECT
    EMP_NAME,
    HIRE_DATE,
    CEIL(SYSDATE - HIRE_DATE) 근무일수
FROM EMPLOYEE;
--
--10. 직원명, 부서코드, 생년월일, 나이(만) 조회
--   단, 생년월일은 주민번호에서 추출해서, 
--   ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--   나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
--	* 주민번호가 이상한 사람들은 제외시키고 진행 하도록(200,201,214 번 제외)
--	* HINT : NOT IN 사용
SELECT
    EMP_NAME,
    DEPT_CODE,
    TO_CHAR(TO_DATE(SUBSTR(EMP_NO,1,6)),'YY"년 "MM"월 "DD"일"') 생년월일,
    FLOOR((SYSDATE - TO_DATE(SUBSTR(EMP_NO,1,6)))/365) "나이(만)"
FROM EMPLOYEE
WHERE EMP_ID NOT IN ('200', '201', '214');
--
--11. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
--  아래의 년도에 입사한 인원수를 조회하시오. 마지막으로 전체직원수도 구하시오
--  => to_char, decode, sum 사용
--	-------------------------------------------------------------------------
--	 1998년   1999년   2000년   2001년   2002년   2003년   2004년  전체직원수
--	-------------------------------------------------------------------------
SELECT
    COUNT(DECODE(TO_CHAR(HIRE_DATE,'YYYY'),'1998',0))||'명' "1998년",
    SUM(DECODE(TO_CHAR(HIRE_DATE,'YYYY'),'1999',1,0))||'명' "1999년",
    --DECODE로 HIRE_DATE('YYYY')에서 1999찾고 있으면 더하기 1 없으면 0
    SUM(DECODE(TO_CHAR(HIRE_DATE,'YYYY'),'2000',1,0))||'명' "2000년", 
    SUM(DECODE(TO_CHAR(HIRE_DATE,'YYYY'),'2001',1,0))||'명' "2001년",
    SUM(DECODE(TO_CHAR(HIRE_DATE,'YYYY'),'2002',1,0))||'명' "2002년", 
    SUM(DECODE(TO_CHAR(HIRE_DATE,'YYYY'),'2003',1,0))||'명' "2003년",
    SUM(DECODE(TO_CHAR(HIRE_DATE,'YYYY'),'2004',1,0))||'명' "2004년",
    COUNT(*)||'명' "전체직원수" 
FROM EMPLOYEE;

--12.  부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오.
--   단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회함
--  => case 사용
--   부서코드 기준 오름차순 정렬함.
SELECT
    EMP_NAME,
    DEPT_CODE,
    CASE DEPT_CODE WHEN 'D5' THEN '총무부'
                   WHEN 'D6' THEN '기획부'
                   WHEN 'D9' THEN '영업부'
    END 부서코드
    
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5', 'D6', 'D9')
ORDER BY DEPT_CODE;
-------------------------------------------------
SELECT
    EMP_NAME,
    DEPT_CODE,
    DECODE(DEPT_CODE, 'D5', '총무부', 'D6', '기획부', 'D9', '영업부') 부서코드
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5', 'D6', 'D9')
ORDER BY DEPT_CODE;
