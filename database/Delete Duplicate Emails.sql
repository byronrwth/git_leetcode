Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id is the primary key column for this table.
For example, after running your query, the above Person table should have the following rows:

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+

'''
mysql> CREATE TABLE Person
    ->  (`id` int, `Email` varchar(20))
    -> ;
Query OK, 0 rows affected (0.11 sec)

mysql> INSERT INTO Person
    ->  (`id`, `Email`)
    -> VALUES
    ->  (1, 'john@example.com'),
    ->  (2, 'bob@example.com'),
    ->  (3, 'john@example.com')
    -> ;
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

'''
# delete from 后的表格 和 select 中的表格必须区别开！

DELETE FROM Person WHERE id IN (
	SELECT id FROM (  
  		SELECT t1.id  FROM Person t1, (  
  			SELECT Email, MIN(id) AS minid FROM Person  
	   		GROUP BY Email HAVING COUNT(Email) > 1  
			)t2   
		WHERE t1.Email = t2.Email AND t1.id > t2.minid  
    )t3
);