Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
For example, given the above Scores table, your query should generate the following report (order by highest score):

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+

CREATE TABLE Scores
    (`id` int, `Score` float)
     ;
     
INSERT INTO Scores
    (`id`, `Score`)
    VALUES
    (1, 3.50),
    (2, 3.65),
    (3, 4.00),
    (4, 3.85),
    (5, 4.00),
    (6, 3.65)
    ;   
    
"""
select Score, rank auto from Scores order by Score desc;

set @rank := 0; select @rank := @rank + 1 as `order`, Scores.score from Score order by Score desc;

SELECT @rownum:=@rownum+1 AS rownum, Scores.score FROM (SELECT @rownum:=0) r, Scores ;

SELECT * FROM (SELECT score, (@rn:=@rn+1) rn FROM emp,(SELECT (@rn:=0)) scores t1 ) scores t2;

SELECT ( @rownum:=@rownum+1 or @rownum:=@rownum where t1.score = t2.score) AS rank, Scores.score FROM (SELECT @rownum:=0) r, Scores order by score desc;

SELECT Scores.score, ( @rownum:=@rownum+1 ) AS rank FROM Scores, (SELECT @rownum:=0) r order by score desc;
+-------+------+
| score | rank |
+-------+------+
|     4 |    1 |
|     4 |    2 |
|  3.85 |    3 |
|  3.65 |    4 |
|  3.65 |    5 |
|   3.5 |    6 |
+-------+------+

SELECT t1.score, ( @rownum:=@rownum+1 ) AS rank FROM Scores t1, Scores t2, (SELECT @rownum:=0) r where t1.score < t2.score order by score desc;

+-------+------+
| score | rank |
+-------+------+
|  3.85 |   11 |
|  3.85 |    4 |
|  3.65 |   10 |
|  3.65 |   12 |
|  3.65 |    3 |
|  3.65 |    5 |
|  3.65 |    7 |
|  3.65 |    8 |
|   3.5 |    9 |
|   3.5 |   13 |
|   3.5 |    1 |
|   3.5 |    2 |
|   3.5 |    6 |
+-------+------+

SELECT t1.score, ( @rownum:=@rownum+1 ) AS rank FROM (select distinct score from scores)t1, (SELECT @rownum:=0) r order by score desc;
+-------+------+
| score | rank |
+-------+------+
|     4 |    1 |
|  3.85 |    2 |
|  3.65 |    3 |
|   3.5 |    4 |
+-------+------+

Scores
+----+-------+                 
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |    join ? 
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+   

+-------+------+
| score | rank |
+-------+------+
|     4 |    1 |
|  3.85 |    2 |
|  3.65 |    3 |
|   3.5 |    4 |
+-------+------+

# 左外连接 = 左连接，全部表person   
(t3.Score, t2.Rank)
SELECT *
FROM Scores t3 LEFT OUTER JOIN (SELECT t1.Score, ( @rownum:=@rownum+1 ) AS Rank FROM (select distinct Score from Scores)t1, (SELECT @rownum:=0) r order by Score desc)t2 
On t3.Score = t2.Score
order by t2.Score desc;       

<-------- LEFT JOIN = LEFT OUTER JOIN
+------+-------+-------+------+
| id   | Score | Score | Rank |
+------+-------+-------+------+
|    3 |     4 |     4 |    1 |
|    5 |     4 |     4 |    1 |
|    4 |  3.85 |  3.85 |    2 |
|    2 |  3.65 |  3.65 |    3 |
|    6 |  3.65 |  3.65 |    3 |
|    1 |   3.5 |   3.5 |    4 |
+------+-------+-------+------+

SELECT t3.Score, t2.Rank
FROM Scores t3 INNER JOIN (SELECT t1.Score, ( @rownum:=@rownum+1 ) AS Rank FROM (select distinct Score from Scores)t1, (SELECT @rownum:=0) r order by Score desc)t2                       
On t3.Score = t2.Score                      
order by Score desc;               <------------- INNER JOIN
+-------+------+
| Score | Rank |
+-------+------+
|     4 |    1 |
|     4 |    1 |
|  3.85 |    2 |
|  3.65 |    3 |
|  3.65 |    3 |
|   3.5 |    4 |
+-------+------+

(need to select t3.Score, t2.Rank)
SELECT *
FROM Scores t3 INNER JOIN (SELECT t1.Score, ( @rownum:=@rownum+1 ) AS Rank FROM (select distinct Score from Scores)t1, (SELECT @rownum:=0) r order by Score desc)t2 
USING(Score)                       
order by Score desc;
<---------------------- USING()
<----------------------- INNER JOIN
+-------+------+------+
| Score | id   | Rank |
+-------+------+------+
|     4 |    3 |    1 |
|     4 |    5 |    1 |
|  3.85 |    4 |    2 |
|  3.65 |    2 |    3 |
|  3.65 |    6 |    3 |
|   3.5 |    1 |    4 |
+-------+------+------+

SELECT *
FROM Scores t3 NATURAL JOIN (SELECT t1.Score, ( @rownum:=@rownum+1 ) AS Rank FROM (select distinct Score from Scores)t1, (SELECT @rownum:=0) r order by Score desc)t2 
ON t3.Score = t2.Score                       
order by t3.Score desc;
>ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use n
ear 'ON t3.Score = t2.Score
order by t3.Score desc' at line 3


SELECT *                           
FROM Scores t3 RIGHT OUTER JOIN (SELECT t1.Score, ( @rownum:=@rownum+1 ) AS Rank FROM (select distinct Score from Scores)t1, (SELECT @rownum:=0) r order by Score desc)t2 
USING(Score)                       
order by Score desc;            

<--------- RIGHT OUTER JOIN = RIGHT JOIN     need to select t3.Score, t2.Rank
+-------+------+------+
| Score | Rank | id   |
+-------+------+------+
|     4 |    1 |    3 |
|     4 |    1 |    5 |
|  3.85 |    2 |    4 |
|  3.65 |    3 |    2 |
|  3.65 |    3 |    6 |
|   3.5 |    4 |    1 |
+-------+------+------+

SELECT *
FROM Scores t3 FULL OUTER JOIN (SELECT t1.Score, ( @rownum:=@rownum+1 ) AS Rank FROM (select distinct Score from Scores)t1, (SELECT @rownum:=0) r order by Score desc)t2 
USING(Score)                       
order by Score desc;



SELECT *
FROM Scores t3 CROSS JOIN (SELECT t1.Score, ( @rownum:=@rownum+1 ) AS Rank FROM (select distinct Score from Scores)t1, (SELECT @rownum:=0) r order by Score desc)t2 USING(Score) order by Score desc;

+-------+------+------+
| Score | id   | Rank |
+-------+------+------+
|     4 |    3 |    1 |
|     4 |    5 |    1 |
|  3.85 |    4 |    2 |
|  3.65 |    2 |    3 |
|  3.65 |    6 |    3 |
|   3.5 |    1 |    4 |
+-------+------+------+

SELECT *
FROM Scores t3 CROSS JOIN (SELECT t1.Score, ( @rownum:=@rownum+1 ) AS Rank FROM (select distinct Score from Scores)t1, (SELECT @rownum:=0) r order by Score desc)t2 ON t3.Score = t2.Score order by t3.Score desc;

+------+-------+-------+------+
| id   | Score | Score | Rank |
+------+-------+-------+------+
|    3 |     4 |     4 |    1 |
|    5 |     4 |     4 |    1 |
|    4 |  3.85 |  3.85 |    2 |
|    2 |  3.65 |  3.65 |    3 |
|    6 |  3.65 |  3.65 |    3 |
|    1 |   3.5 |   3.5 |    4 |
+------+-------+-------+------+


leetcode table 和 列名 区别 大小写！！！

"""

SELECT t3.Score, t2.Rank
FROM Scores t3 LEFT OUTER JOIN (SELECT t1.Score, ( @rownum:=@rownum+1 ) AS Rank FROM (select distinct Score from Scores)t1, (SELECT @rownum:=0) r order by Score desc)t2 
On t3.Score = t2.Score
order by Score desc;