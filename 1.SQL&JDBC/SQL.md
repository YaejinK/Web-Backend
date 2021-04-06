SQL이란?-1
=============
## SQL(Structured Query Language)
- DBMS에게 내리는 명령
- 데이터를 보다 쉽게 검색, 추가, 삭제, 수정 같은 조작할 수 있도록 고안된 컴퓨터 언어
- 관계형 데이터베이스에서 데이터를 조작하고 쿼리하는 표준수단
- DML(Data Manipulation Language): INSERT, UPDATE, DELETE, SELECT
- DDL(Definition): CREATE, DROP, ALTER
- DCL(Control): GRANT, REVOKE
### Database 생성
##### cmd에서 MySQL 관리자 계정인 root로 DBMS 시스템에 접속

    mysql -uroot -p
  
##### database 생성

    mysql> create database DB이름;
  
### Database 사용자 생성과 권한 주기
 - Database를 생성하고 해당 데이터베이스를 사용하는 계정 생성 & 데이터베이스를 이용할 수 있는 권한 부여 
 - \*모든 권한, @'%' 어떤 클라이언트에서든 접근 가능, @'localhost' 해당 컴퓨터에서만 접근 가능
##### 사용자의 생성과 권한주기
 
    grant all privileges on db이름.*to 계정이름@'%'identified by '암호';
    grant all privileges on db이름.*to 계정이름@'localhost'identified by '암호';
    
##### 실제 적용: 사용자 계정이름 connectuser, 암호 connect123!@#

    CREATE USER 'connectuser'@'%' IDENTIFIED BY 'connect123!@#';
    grant all privileges on connectdb.* to connectuser@'%';

##### flush privileges - DBMS에게 적용하라는 명령

    flush privileges;

### 생성한 Database에 접속하기
    mysql -h호스트명 -uDB계정명 -p 데이터베이스 이름
    mysql -h127.0.0.1 -uconnectuser -p connectdb
    
### MySQL 연결끊기
    mysql> quit
    mysql> exit
    
#### 키워드는 대소문자를 구별하지 않는다.
#### SQL 입력 도중 취소하기 '\c'붙이기

### DBMS에 존재하는 database 확인
    mysql> show databases;
    
### 사용중인 데이터베이스 전환하기
    mysql> use mydb;

* * *
SQL이란?-2
===========
## Table
- data를 저장하는 공간
- 엑셀의 표와 유사한 테이블
- 엑셀은 실행하면 표가 나오는 것과 달리 데이터베이스를 생성해도 테이블은 존재하지 않음
- 테이블을 생성하고 값을 저장하기 위한 SQL 사용해야함
![2](https://user-images.githubusercontent.com/71435571/113750985-60a71680-9746-11eb-8069-0d45427a94c0.png)
### 테이블의 구성요소
- 테이블: 한 개 이상의 column과 0개 이상의 row로 구성
- 열(Column): 테이블 상에서의 단일 종류의 데이터, 특정 데이터 타입 및 크기 가짐
- 행(Row): Column들의 값의 조합. = record. 기본키(Primary key)에 의해 구분
- Filed: Row와 Column 사이의 교차점. 데이터 포함할 수 있고 없을땐 NULL값 가짐
### 현재 데이터베이스에 존재하는 테이블 목록 확인
    mysql> show tables;
    
### .sql 파일을 이용한 테이블 생성과 저장
##### 터미널에서 테이블 생성문과 해당 테이블에 값을 저장하는 examples.sql을 이용해 connectdb에 접속
    mysql   -uconnectuser  -p  connectdb   <  examples.sql
    mysql –uconnectuser -p  connectdb
 
### 테이블 구조를 확인하기 위한 DESCRIBE
    mysql> desc employee;
    
