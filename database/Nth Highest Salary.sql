Write a SQL query to get the nth highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the nth highest salary where n = 2 is 200. If there is no nth highest salary, then the query should return null.

CREATE TABLE Employee 
    (`Id` int, `Salary` int)
     ;
     
INSERT INTO Employee2 
    (`Id`, `Salary`)
    VALUES
    (1, 100),
    (2, 200),
    (3, 300)
    ; 


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      
  );


CREATE FUNCTION getNthHighestSalary(ID INT) RETURNS INT
BEGIN
  DECLARE SALARY INT DEFAULT null;

    SELECT Salary FROM Employee2 WHERE ID = Id;
  RETURN Salary;
END

"""
 [LIMIT {[offset,] row_count | row_count OFFSET offset}]
 """
DROP FUNCTION IF EXISTS getNthHighestSalary;
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
  RETURN (
    SELECT MIN(Salary) from ( 
      SELECT Salary AS nthSalary FROM Employee2 ORDER BY Salary DESC LIMIT N,1
    )t
  );


mysql> select getNthHighestSalary(2) from Employee2;
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
|                    100 |
|                    100 |
|                    100 |
+------------------------+
3 rows in set (0.00 sec)

mysql> select getNthHighestSalary(1) from Employee2;
+------------------------+
| getNthHighestSalary(1) |
+------------------------+
|                    200 |
|                    200 |
|                    200 |
+------------------------+
3 rows in set (0.00 sec)

mysql> select getNthHighestSalary(0) from Employee2;
+------------------------+
| getNthHighestSalary(0) |
+------------------------+
|                    300 |
|                    300 |
|                    300 |
+------------------------+
3 rows in set (0.00 sec)

DROP FUNCTION IF EXISTS getNthHighestSalary;
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
  RETURN (
    SELECT MAX(Salary) AS Salary FROM Employee2 ORDER BY Salary DESC
  );



DROP FUNCTION IF EXISTS getNthHighestSalary;
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
  RETURN (
    SELECT MAX(Salary) AS Salary FROM Employee2 WHERE Salary < (
      SELECT getNthHighestSalary(N-1) from Employee2
      )
  );


Solution 1:
(
SELECT MAX(Salary) from Employee2 
WHERE Salary <  
      (  
         SELECT MAX(Salary) FROM Employee2
         WHERE Salary < 
             ( 
               SELECT MAX(Salary) FROM Employee2
             )
      )
);  

Solution 2:
SELECT (SELECT Salary AS SecondHighestSalary FROM Employee ORDER BY Salary DESC LIMIT 1,1);
# 从1+1=2 个开始取，取1个  [LIMIT {[offset,] row_count | row_count OFFSET offset}]


DROP FUNCTION IF EXISTS getNthHighestSalary;
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
  RETURN (
    SELECT Id,Salary AS nthSalary FROM Employee2 ORDER BY Salary DESC LIMIT N,1
  );
mysql> select getNthHighestSalary(2) from Employee2;

DROP FUNCTION IF EXISTS getNthHighestSalary;
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
    RETURN (
      SELECT * from Employee2 CROSS JOIN (
        SELECT Employee2.Salary AS nthSalary FROM Employee2 ORDER BY Employee2.Salary DESC LIMIT N,1
      )t WHERE t.nthSalary = Employee2.Salary
);

     select Min(Salary) as Salary from Employee2 where Salary > (
        SELECT Employee2.Salary AS nthSalary FROM Employee2 
   ORDER BY Employee2.Salary DESC LIMIT 4,1)

     SELECT Employee2.Salary, ( @rownum:=@rownum+1 ) AS Rank FROM (select distinct Salary from Employee2)t1, (SELECT @rownum:=0) r order by Salary desc)


SELECT t1.Salary, ( @rownum:=@rownum+1 ) AS Rank 
FROM 
  (select Salary from Employee2)t1, (SELECT @rownum:=0) r order by Salary desc

"""
Salary  Rank
500      1
400      2
300      3
200      4
100      5
"""

DROP FUNCTION IF EXISTS getNthHighestSalary;
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
    RETURN (
SELECT Salary FROM (      
SELECT t1.Salary, ( @rownum:=@rownum+1 ) AS Rank 
FROM 
  (select Salary from Employee2)t1, (SELECT @rownum:=0) r order by Salary desc
)t2 WHERE N = t2.Rank
);

    """
    must consider extreme case :
    {"Employee": [[1, 100], [2, 100]]}

    if values same, then rank should be same
    
    Solution:
    DROP FUNCTION IF EXISTS getNthHighestSalary;
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
    RETURN (
SELECT Salary FROM (      
SELECT t1.Salary, ( @rownum:=@rownum+1 ) AS Rank 
FROM 
  (select distinct Salary from Employee2)t1, (SELECT @rownum:=0) r order by Salary desc
)t2 WHERE N = t2.Rank
);
    """
