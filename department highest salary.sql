The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+

CREATE TABLE Employee 
    (`Id` int, `Name` varchar(20), `Salary` int, `DepartmentId` int)
     ;
     
INSERT INTO Employee 
    (`Id`, `Name`, `Salary`, `DepartmentId`)
    VALUES
    (1, 'Joe', 70000, 1),
    (2, 'Henry', 80000, 2),
    (3, 'Sam', 60000, 2),
    (4, 'Max', 90000, 1)
    ;  


CREATE TABLE Department 
    (`Id`int, `Name`varchar(20), FOREIGN KEY (Id) REFERENCES Employee(DepartmentId) )
     ;

CREATE TABLE Department 
    (`Id`int, `Name`varchar(20))
     ;     
INSERT INTO Department 
    (`Id`, `Name`)
    VALUES
    (1, "IT"),
    (2, "Sales")
    ; 

 select * from Employee, Department;
 +------+-------+--------+--------------+------+-------+
| Id   | Name  | Salary | DepartmentId | Id   | Name  |
+------+-------+--------+--------------+------+-------+
|    1 | Joe   |  70000 |            1 |    1 | IT    |
|    1 | Joe   |  70000 |            1 |    2 | Sales |
|    2 | Henry |  80000 |            2 |    1 | IT    |
|    2 | Henry |  80000 |            2 |    2 | Sales |
|    3 | Sam   |  60000 |            2 |    1 | IT    |
|    3 | Sam   |  60000 |            2 |    2 | Sales |
|    4 | Max   |  90000 |            1 |    1 | IT    |
|    4 | Max   |  90000 |            1 |    2 | Sales |
+------+-------+--------+--------------+------+-------+

select t.Department, t.Employee, t.Salary  from (
SELECT Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary FROM Employee LEFT OUTER JOIN Department ON Employee.DepartmentId = Department.Id)t group by t.Department 
having t.Salary = MAX(t.Salary) ;

DELETE FROM Person WHERE id IN (
    SELECT id FROM (  
        SELECT t1.id  FROM Person t1, (  
            SELECT Email, MIN(id) AS minid FROM Person  
            GROUP BY Email HAVING COUNT(Email) > 1  
            )t2   
        WHERE t1.Email = t2.Email AND t1.id > t2.minid  
    )t3
); 


+------+-------+--------+--------------+------+-------+
| Id   | Name  | Salary | DepartmentId | Id   | Name  |
+------+-------+--------+--------------+------+-------+
|    1 | Joe   |  70000 |            1 |    1 | IT    |
|    4 | Max   |  90000 |            1 |    1 | IT    |
|    2 | Henry |  80000 |            2 |    2 | Sales |
|    3 | Sam   |  60000 |            2 |    2 | Sales |
+------+-------+--------+--------------+------+-------+


select Name as Department FROM Department, Name as Employee, Salary FROM Employee ;
