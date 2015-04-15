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

INSERT INTO Employee 
    (`Id`, `Name`, `Salary`, `DepartmentId`)
    VALUES
    (1, "Joe", 60000, 1),
    (4, "Max", 60000, 1)
    ; 

INSERT INTO Employee 
    (`Id`, `Name`, `Salary`, `DepartmentId`)
    VALUES
    (2, 'Henry', 80000, 2),
    (3, 'Sam', 60000, 2)
    ; 

CREATE TABLE Department 
    (`Id`int, `Name`varchar(20) )
     ;

CREATE TABLE Department 
    (`Id`int, `Name`varchar(20))
     ;     
INSERT INTO Department 
    (`Id`, `Name`)
    VALUES
    (1, "IT"),
    (2, "HR")
    ; 
INSERT INTO Department 
    (`Id`, `Name`)
    VALUES
    (null, null)
    ; 


{"Employee": [[1, "Joe", 60000, 1], [4, "Max", 60000, 2]], "Department": [[1, "IT"], [2, "HR"]
"""




+------+-------+--------+--------------+------+-------+
| Id   | Name  | Salary | DepartmentId | Id   | Name  |
+------+-------+--------+--------------+------+-------+
|    1 | Joe   |  70000 |            1 |    1 | IT    |
|    4 | Max   |  90000 |            1 |    1 | IT    |
|    2 | Henry |  80000 |            2 |    2 | Sales |
|    3 | Sam   |  60000 |            2 |    2 | Sales |
+------+-------+--------+--------------+------+-------+


DELETE FROM Person WHERE id IN (
    SELECT id FROM (  
        SELECT t1.id  FROM Person t1, (  
            SELECT Email, MIN(id) AS minid FROM Person  
            GROUP BY Email HAVING COUNT(Email) > 1  
            )t2   
        WHERE t1.Email = t2.Email AND t1.id > t2.minid  
    )t3
); 


mysql> SELECT Employee.Id as Id, Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary
    ->         FROM Employee LEFT OUTER JOIN Department
    ->         ON Employee.DepartmentId = Department.Id;
+------+------------+----------+--------+
| Id   | Department | Employee | Salary |
+------+------------+----------+--------+
|    1 | IT         | Joe      |  70000 |
|    4 | IT         | Max      |  90000 |
|    2 | Sales      | Henry    |  80000 |
|    3 | Sales      | Sam      |  60000 |
+------+------------+----------+--------+


mysql>     select t1.Department as Department, MAX(t1.Salary) as Salary from (
    ->         SELECT Employee.Id as Id, Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary
    ->         FROM Employee LEFT OUTER JOIN Department
    ->         ON Employee.DepartmentId = Department.Id
    ->         )t1
    ->     group by t1.Department;
+------------+--------+
| Department | Salary |
+------------+--------+
| IT         |  90000 |
| Sales      |  80000 |
+------------+--------+


如果
    select t1.Department as Department, t1.Employee as Employee, MAX(t1.Salary) as Salary from (
        SELECT Employee.Id as Id, Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary 
        FROM Employee LEFT OUTER JOIN Department 
        ON Employee.DepartmentId = Department.Id
        )t1 
    group by t1.Department

错误 ！
------------+----------+--------+
 Department | Employee | Salary |
------------+----------+--------+
 IT         | Joe      |  90000 |
 Sales      | Henry    |  80000 |
------------+----------+--------+    
"""

select t2.Department, Employee.Name as Employee, Employee.Salary as Salary from Employee LEFT OUTER JOIN (
    select t1.Id as peopleId, t1.Department as Department, MAX(t1.Salary) as Salary from (
        SELECT Employee.Id as Id, Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary 
        FROM Employee LEFT OUTER JOIN Department 
        ON Employee.DepartmentId = Department.Id 
        )t1 
    group by t1.Department
    )t2
ON t2.peopleId =  Employee.Id
;


t2:
+------------+--------+
| Department | Salary |
+------------+--------+
| HR         |  60000 |
| IT         |  60000 |
+------------+--------+

employee:
+------+------+--------+--------------+
| Id   | Name | Salary | DepartmentId |
+------+------+--------+--------------+
|    1 | Joe  |  60000 |            1 |
|    4 | Max  |  60000 |            2 |
+------+------+--------+--------------+

if in table Department Id is null:
        SELECT Employee.Id as Id, Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary 
        FROM Employee LEFT OUTER JOIN Department 
        ON Employee.DepartmentId = Department.Id ;

+------+------------+----------+--------+
| Id   | Department | Employee | Salary |
+------+------------+----------+--------+
|    1 | NULL       | Joe      |  60000 |
|    4 | NULL       | Max      |  60000 |
+------+------------+----------+--------+
        SELECT Employee.Id as Id, Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary 
        FROM Employee INNER JOIN Department 
        ON Employee.DepartmentId = Department.Id ;

"""
用 INNER JOIN 避免 null 影响连接
"""
select t2.Department, Employee.Name as Employee, Employee.Salary as Salary from Employee INNER JOIN (
    select t1.Id as peopleId, t1.Department as Department, MAX(t1.Salary) as Salary from (
        SELECT Employee.Id as Id, Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary 
        FROM Employee INNER JOIN Department 
        ON Employee.DepartmentId = Department.Id 
        )t1 
    group by t1.Department
    )t2
ON t2.peopleId =  Employee.Id

错误，如果 相同工资
    (1, "Joe", 60000, 1),
    (4, "Max", 60000, 1)
以上 只会 生成一个

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Joe      |  60000 |
+------------+----------+--------+


    select *, MAX(t1.Salary) as maxSalary from (
        SELECT Employee.Id as Id, Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary 
        FROM Employee INNER JOIN Department 
        ON Employee.DepartmentId = Department.Id 
        )t1 
    group by t1.Department
"""
DELETE FROM Person WHERE id IN (
    SELECT id 
    FROM 
    (  
        SELECT t1.id  
        FROM 
            Person t1, 
            ( 
              SELECT Email, MIN(id) AS minid   
              FROM 
                   Person  
              GROUP BY Email HAVING COUNT(Email) > 1  
            )t2   
        WHERE t1.Email = t2.Email AND t1.id > t2.minid  
    )t3
"""
select t2.Department, Employee.Name as Employee, Employee.Salary as Salary 
from 
    Employee 
INNER JOIN 
    (
    select t1.DepartmentId, t1.Department, max(t1.salary) as maxSalary
        from (
        SELECT Employee.Id as Id, Department.Id as DepartmentId, Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary 
        FROM 
            Employee INNER JOIN Department 
        ON Employee.DepartmentId = Department.Id 
        )t1 
        group by t1.Department 
    )t2
on Employee.Salary = t2.maxSalary and Employee.DepartmentId = t2.DepartmentId ;

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Joe      |  60000 |
| IT         | Max      |  60000 |
| HR         | Henry    |  80000 |
+------------+----------+--------+