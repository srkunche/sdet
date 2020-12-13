REM   Script: Activity4_5
REM   Script to complete activities - Activity4 and Activity5 

CREATE TABLE salesman (   
    salesman_id int,   
    salesman_name varchar2(20),   
    salesman_city varchar2(20),   
    commission int   
);

DESCRIBE salesman


INSERT INTO salesman VALUES(5001, 'James Hoog', 'New York', 15);

INSERT ALL   
    INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13)  
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)   
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)   
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)   
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)   
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

ALTER TABLE salesman ADD  grade int;

SELECT * FROM salesman;

UPDATE salesman grade SET grade=100;

SELECT * FROM salesman;

UPDATE salesman set grade=200 WHERE salesman_city='Rome';

UPDATE salesman set grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name = 'Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;
