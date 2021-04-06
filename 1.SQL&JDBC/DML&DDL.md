DML(select, insert, update, delete)
==============
## 데이터 조작어(Data Manipulation Language, DML)
- SELECT - 검색
- INSERT - 등록
- UPDATE - 수정
- DELETE - 삭제
![3](https://user-images.githubusercontent.com/71435571/113752372-d6f84880-9747-11eb-952a-9e889a260f5d.png)

### COLUMN에 Alias 부여
##### 공백으로 as 생략 그 뒤에 또 공백 나오면 안됨, from으로 인식

    mysql> select empno as 사번, name as 이름, job as 직업 from employee;
    mysql> select deptno 부서번호, name 부서명 from department;

### concat 문자열 결합

    mysql> select concat(empno,'-', deptno) as '사번-부서번호' from employee;
  
### distinct 중복행 제거

    mysql> select distinct deptno from employee;

### order by 정렬하기/오름차순

    mysql> select empno, name from employee order by name;
 
-내림차순

    mysql> select empno, name from employee order by name desc;
    
-n번째 column 기준으로 정렬

    mysql> select empno, name from employee order by 1;

## Where 절
![4](https://user-images.githubusercontent.com/71435571/113753305-eaf07a00-9748-11eb-98fd-d6ddbc36ecc8.png)
### where 특정 행 검색/조건부여 가능/논리연산자 가능
    mysql> select * from employee where empno = 7934;
    mysql> select * from employee where deptno in (10,30);
    mysql> select * from employee where deptno =10 or deptno = 30;
    mysql> select * from employee where deptno in (10,20,30) and salary <1500;

### like '%' 0에서부터 여러 개의 문자열 나타냄, '\_' 하나의 문자를 나타내는 와일드 카드)
    mysql> select * from employee where name like 'A%';
    mysql> select * from employee where name like '%A%';
    mysql> select * from employee where name like '_A%';
### select 함수의 사용(ucase, upper/lcase, lower/substring/lpad, rpad)
    mysql> select lower(name) from employee;
    mysql> select substring('Happy Day', 3,2);	:pp
    mysql> select lpad('hi', 5, '?'), lpad('joe', 7, '*');	:???hi     ****joe
    mysql> select lpad(name,10,'+') from employee;
### trim, ltrim, rtrim
    mysql> select ltrim('    hello ');
    mysql> select trim('x' from 'xxxhixxx');
### abs/mod
    mysql> select abs(-2);
    mysql> select mod (234,10);
    mysql> select 253%7;
### Cast 형변환
![4 (1)](https://user-images.githubusercontent.com/71435571/113753882-98638d80-9749-11eb-8895-f0e5663b2254.png)

     mysql> select cast(now() as date);
    
![4 (2)](https://user-images.githubusercontent.com/71435571/113754158-e7a9be00-9749-11eb-8ccf-5e127b8c0d75.png)
### avg, count(\*이 아니면 null 값 제외) 
    mysql> select concat(name, 'aaaa') from employee; -단일 함수
    mysql> select count(*) from employee; -그룹 함수
    mysql> select avg(salary), sum(salary) from employee where deptno = 30;
### group by ~별(부서별 ..)
    mysql> select deptno, avg(salary), sum(salary) from employee group by deptno;
