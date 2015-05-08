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
"""
