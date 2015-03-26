Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the second highest salary is 200. If there is no second highest salary, then the query should return null.

SELECT column_name,column_name
FROM table_name
ORDER BY column_name,column_name ASC|DESC;


Solution 1:
用 多种嵌套 实现 Nth select 大小排序:

e.g. 第三大

(
SELECT MAX(Salary) from Employee 
WHERE Salary <  
      (  
         SELECT MAX(Salary) FROM Employee
         WHERE Salary < 
             ( 
               SELECT MAX(Salary) FROM Employee
             )  # 1st 第一大
      )# 2nd 第二大
);  # 3rd 第三大

Solution 2:
SELECT (SELECT Salary AS SecondHighestSalary FROM Employee ORDER BY Salary DESC LIMIT 1,1);
# 从1+1=2 个开始取，取1个  [LIMIT {[offset,] row_count | row_count OFFSET offset}]

SELECT
    [ALL | DISTINCT | DISTINCTROW ]
      [HIGH_PRIORITY]
      [STRAIGHT_JOIN]
      [SQL_SMALL_RESULT] [SQL_BIG_RESULT] [SQL_BUFFER_RESULT]
      [SQL_CACHE | SQL_NO_CACHE] [SQL_CALC_FOUND_ROWS]
    select_expr [, select_expr ...]
    [FROM table_references
    [WHERE where_condition]
    [GROUP BY {col_name | expr | position}
      [ASC | DESC], ... [WITH ROLLUP]]
    [HAVING where_condition]
    [ORDER BY {col_name | expr | position}
      [ASC | DESC], ...]
    [LIMIT {[offset,] row_count | row_count OFFSET offset}]
    [PROCEDURE procedure_name(argument_list)]
    [INTO OUTFILE 'file_name' export_options
      | INTO DUMPFILE 'file_name'
      | INTO var_name [, var_name]]
    [FOR UPDATE | LOCK IN SHARE MODE]]