CREATE TABLE IF NOT EXISTS employee(Id INT AUTO_INCREMENT PRIMARY KEY, Department_id INT, Name VARCHAR(255) NOT NULL, Surname VARCHAR(255) NOT NULL, Wage double, Creation_date VARCHAR(255) NOT NULL, Update_date VARCHAR(255));
CREATE TABLE IF NOT EXISTS project(Id INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(255), Technology VARCHAR(255), Version INT);
CREATE TABLE IF NOT EXISTS department(Id INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(255) NOT NULL, Budget double);
CREATE TABLE IF NOT EXISTS employee_projects(Employee_id INT, Project_id INT);
CREATE TABLE IF NOT EXISTS building(Id INT AUTO_INCREMENT PRIMARY KEY, Type VARCHAR(255), Name VARCHAR(255), Owner VARCHAR(255), Manager VARCHAR(255), Principal VARCHAR(255));
CREATE TABLE IF NOT EXISTS shop(Id INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(255), Street VARCHAR(255), Nr VARCHAR(255));

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