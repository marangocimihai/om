CREATE TABLE IF NOT EXISTS employee(Id INTEGER AUTO_INCREMENT PRIMARY KEY, Department_id INTEGER, Name VARCHAR(255) NOT NULL, Surname VARCHAR(255) NOT NULL, Wage double, Creation_date VARCHAR(255) NOT NULL, Update_date VARCHAR(255) NOT NULL);
CREATE TABLE IF NOT EXISTS project(Id INTEGER AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(255), Technology VARCHAR(255), Version INTEGER);
CREATE TABLE IF NOT EXISTS department(Id INTEGER AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(255) NOT NULL, Budget double);
CREATE TABLE IF NOT EXISTS employee_projects(Employee_id INTEGER, Project_id INTEGER);
CREATE TABLE IF NOT EXISTS building(Id INTEGER AUTO_INCREMENT PRIMARY KEY, Type VARCHAR(255), Name VARCHAR(255), Owner VARCHAR(255), Manager VARCHAR(255), Principal VARCHAR(255));
CREATE TABLE IF NOT EXISTS shop(Id INTEGER AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(255), Street VARCHAR(255), Nr VARCHAR(255));

INSERT INTO employee(name, surname, wage) VALUES('marangoci', 'mihai', 71);

DELIMITER //
CREATE PROCEDURE getEmployeeByName(IN name VARCHAR(255))
BEGIN
	SELECT emp.* FROM Employee emp WHERE emp.name LIKE name;
END;
//
DELIMITER ;

DELETE FROM employee where 1=1;
DELETE FROM project where 1=1;
DELETE FROM employee_projects where 1=1;
SHOW DABATASES;
SHOW TABLES;
SHOW CREATE PROCEDURE [NAME];
DROP PROCEDURE [NAME];


#database creation
CREATE TABLE IF NOT EXISTS employee(Id INTEGER AUTO_INCREMENT PRIMARY KEY, Department_id INTEGER, Name VARCHAR(255) NOT NULL, Surname VARCHAR(255) NOT NULL, Wage double);
CREATE TABLE IF NOT EXISTS department(Id INTEGER AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(255) NOT NULL, Budget double);
CREATE TABLE IF NOT EXISTS event(id INTEGER AUTO_INCREMENT PRIMARY KEY, Name varchar(255), Visitor varchar(255), Properties json, Browser json);

#database population
INSERT INTO employee(department_id, name, surname, wage) VALUES(1, 'Marangoci', 'Mihai', 50);
INSERT INTO employee(department_id, name, surname, wage) VALUES(1, 'Danila', 'Cristian', 50);
INSERT INTO employee(department_id, name, surname, wage) VALUES(2, 'Ciotau', 'Monica', 50);
INSERT INTO employee(department_id, name, surname, wage) VALUES(2, 'Ajitaritei', 'Ghita', 50);
INSERT INTO employee(department_id, name, surname, wage) VALUES(3, 'Sutea', 'Silviu', 50);
INSERT INTO employee(department_id, name, surname, wage) VALUES(3, 'Tatarcan', 'Andrada', 40);
INSERT INTO employee(department_id, name, surname, wage) VALUES(NULL, 'Iurescu', 'Alex', 30);
INSERT INTO event(name, visitor, properties, browser) VALUES ('purchase', '4', '{ "amount": 500 }', '{ "name": "Chrome", "os": "Windows", "resolution": { "x": 1680, "y": 1050 } }');

INSERT INTO department(name, budget) VALUES("DevOps", 6000);
INSERT INTO department(name, budget) VALUES("Java", 5000);
INSERT INTO department(name, budget) VALUES("Angular", 4000);
INSERT INTO department(name, budget) VALUES("Incident", 3000);

#joins
SELECT * FROM employee e LEFT JOIN department d ON e.department_id = d.id;
SELECT * FROM employee e RIGHT JOIN department d ON e.department_id = d.id;
MySQL does not have FULL JOIN. You can emulate the exact behavior though, by using a UNION between a LEFT JOIN and a RIGHT JOIN
SELECT A.id AS "Emp_ID", A.name AS "Employee" B.id AS "Supervisor_ID", B.name AS "Supervisor" employee A, employee B WHERE A.emp_sup = B.id

#index
CREATE INDEX emp_index ON employee(department_id);
INDEX can be:
	1. unique
	2. non-unique
	3. clustered
	4. non-clustered

#commands
UNION - returns the combined result-set by two or more SELECT statements
MINUS - returns the result-set obtained by the first SELECT removing the result-set returned by the second SELECT
INTERSECT - returns the combined result-set of the two SELECT clauses which perfectly match

#remove commands
DELETE FROM Employee WHERE id < 10; 
	- deletes all rows one by one
TRUNCATE TABLE Employee;
	- drops the table and recreates it again
DROP TABLE Employee 
	- delete all rows and the table structure from the database

#others
UNION - combine result-sets of two or more SELECT statements
GROUP BY - groups rows that have the same values
ORDER BY - order rows by given column
HAVING - basically acts like a WHERE, but can be used with aggregate functions
EXISTS - test existence of any record in a subquery

SELECT * INTO Employee_backup FROM Employee; - copy every record from Employee table into Employee_backup table
SELECT browser->'$.name' FROM event; - select JSON values out of JSON columns

#alter table
ALTER TABLE employee ADD age INTEGER; - add a column
ALTER TABLE Employee MODIFY wage NUMERIC; - modify a column nature
ALTER TABLE Employee CHANGE COLUMN name tempname VARCHAR(255); - change column name
ALTER TABLE Employee DROP COLUMN surname; - delete column
ALTER TABLE Employee RENAME TO TempEmployee; - rename a table
ALTER TABLE Employee ADD COLUMN Fullname VARCHAR(255) GENERATED ALWAYS AS (CONCAT(name, ' ', surname)) VIRTUAL;
ALTER TABLE ADD PRIMARY KEY(id); - add primary key to table
ALTER TABLE ADD UNIQUE INDEX employee(name); - set name column to accept only unique values