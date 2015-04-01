Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.

+---------+------------+------------------+
| Id(INT) | Date(DATE) | Temperature(INT) |
+---------+------------+------------------+
|       1 | 2015-01-01 |               10 |
|       2 | 2015-01-02 |               25 |
|       3 | 2015-01-03 |               20 |
|       4 | 2015-01-04 |               30 |
+---------+------------+------------------+
For example, return the following Ids for the above Weather table:
+----+
| Id |
+----+
|  2 |
|  4 |
+----+

CREATE TABLE Weather
  (`id` int, 
   `Date` DATE,
   `Temperature` int)
;

INSERT INTO Weather
    (`id`, `Date`, `Temperature`)
VALUES
    (1, '2015-01-01', 10),
    (2, '2015-01-02', 25),
    (3, '2015-01-03', 20),
    (4, '2015-01-04', 30)
;


# 学习 natural join 用法， 相同名称 的 column 自动覆盖，这样 t1 表中算出的 昨天subdate 重命名为date后 与 原表 t2 natural join，自动索引出了 昨天的温度 subtemp
'''
mysql> select * from weather t2
    -> natural join (
    ->   SELECT date as primarydate, temperature as primarytemp, date_sub(date, interval 1 day) AS date FROM weather
    -> )t1
    -> ;

+------------+------+-------------+-------------+-------------+
| date       | id   | temperature | primarydate | primarytemp |
+------------+------+-------------+-------------+-------------+
| 2015-01-01 |    1 |          10 | 2015-01-02  |          25 |
| 2015-01-02 |    2 |          25 | 2015-01-03  |          20 |
| 2015-01-03 |    3 |          20 | 2015-01-04  |          30 |
+------------+------+-------------+-------------+-------------+
'''
select primaryid as id from Weather t2 
natural join (
  SELECT id as primaryid, date as primarydate, temperature as primarytemp, date_sub(date, interval 1 day) AS date FROM Weather
)t1
where primarytemp > temperature
;



