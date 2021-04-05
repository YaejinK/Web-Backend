SQL이란?-1
=============

### SQL(Structured Query Language)
- DBMS에게 내리는 명령
- 데이터를 보다 쉽게 검색, 추가, 삭제, 수정 같은 조작할 수 있도록 고안된 컴퓨터 언어
- 관계형 데이터베이스에서 데이터를 조작하고 쿼리하는 표준수단
- DML(Manipulation): INSERT, UPDATE, DELETE, SELECT
- DDL(Definition): CREATE, DROP, ALTER
- DCL(Control): GRANT, REVOKE

### Database 생성
cmd에서 MySQL 관리자 계정인 root로 DBMS 시스템에 접속

  mysql -uroot -p
  
 database 생성

  mysql> create database DB이름;
  
 ### Database 사용자 생성과 권한 주기
 * 모든 권한, @'%' 어떤 클라이언트에서든 접근 가능, @'localhost' 해당 컴퓨터에서만 접근 가능
 
  grant all privileges on db이름.*to 계정이름@'%'identified by '암호';
  grant all privileges on db이름.*to 계정이름@'localhost'identified by '암호';

flush privileges - DBMS에게 적용하라는 명령

  flush privileges;

