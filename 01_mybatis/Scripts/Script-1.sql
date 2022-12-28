--1. 사용자계정명에 ##을 붙이지 않게 설정
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
--2. 사용자 계정생성
CREATE USER mybatis IDENTIFIED BY mybatis DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
--3. 생성된 계정 확인하기->DBA(SYSTEM)이 확인
SELECT * FROM DBA_USERS;
--4. 생성된 계정에 접속권한, 저장공간활용할 수 있는 권한 부여
GRANT CONNECT , RESOURCE TO mybatis;