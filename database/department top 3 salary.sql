The Employee table holds all employees. Every employee has an Id, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
| 5  | Janet | 69000  | 1            |
| 6  | Randy | 85000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who earn the top three salaries in each of the department. For the above tables, your SQL query should return the following rows.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Randy    | 85000  |
| IT         | Joe      | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
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
    (4, 'Max', 90000, 1),
    (5, 'Janet', 69000, 1),
    (6, 'Randy', 85000, 1)
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

"""
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
"""

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

extend max to top 3:


  SELECT Salary 
  FROM (      
        SELECT t1.Salary, ( @rownum:=@rownum+1 ) AS Rank 
        FROM (
              select distinct Salary from Employee2
              )t1, 
             (SELECT @rownum:=0) r order by Salary desc
        )t2 
  WHERE t2.Rank <= 3


"""

DROP FUNCTION IF EXISTS allNthHighestSalary;
CREATE FUNCTION allNthHighestSalary(N INT) RETURNS INT
RETURN (
  SELECT Salary 
  FROM (      
        SELECT x1.Salary, ( @rownum:=@rownum+1 ) AS Rank 
        FROM (
              select distinct Salary from Employee
              )x1, 
             (SELECT @rownum:=0) r order by Salary desc
        )x2 
  WHERE x2.Rank <= N
);




select t2.Department, Employee.Name as Employee, Employee.Salary as Salary 
from 
    Employee 
INNER JOIN 
    (
    select t1.DepartmentId, t1.Department, allNthHighestSalary(3) as topThree  " ERROR 1242 (21000):--> Subquery returns more than 1 row "              
    from (
           SELECT Employee.Id as Id, Department.Id as DepartmentId, Department.Name as Department, Employee.Name as Employee, Employee.Salary as Salary 
           FROM 
             Employee INNER JOIN Department 
           ON Employee.DepartmentId = Department.Id 
         )t1 
    group by t1.Department 
    )t2
on Employee.Salary IN t2.topThree and Employee.DepartmentId = t2.DepartmentId ;