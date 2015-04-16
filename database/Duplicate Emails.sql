Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.


select distinct Email from Person   
where Email in (select  Email  from  Person  group  by  Email  having  count(Email) > 1)

或者

select  Email  from  Person  group  by  Email  having  count(Email) > 1


group by 让有重复的 element 叠加，count这样的重复 element 会>1;
group by 还要有条件限制不能where 只能having


那我們如何對函數產生的值來設定條件呢？舉例來說，我們可能只需要知道哪些店的營業額有超過 $1,500。在這個情況下，我們不能使用 WHERE 的指令。那要怎麼辦呢？很幸運地，SQL 有提供一個 HAVING 的指令，而我們就可以用這個指令來達到這個目標。 HAVING 子句通常是在一個 SQL 句子的最後。一個含有 HAVING 子句的 SQL 並不一定要包含 GROUP BY 子句。HAVING 的語法如下：

SELECT "欄位1", SUM("欄位2") 
FROM "表格名" 
GROUP BY "欄位1" 
HAVING (函數條件);
請讀者注意： 如果被 SELECT 的只有函數欄， 那就不需要 GROUP BY 子句。

在我們 Store_Information 表格這個例子中,

Store_Information 表格
Store_Name	Sales	Txn_Date
Los Angeles	1500	05-Jan-1999
San Diego	250	07-Jan-1999
Los Angeles	300	08-Jan-1999
Boston	700	08-Jan-1999
若我們要找出 Sales 大於 1,500 的 Store_Name，我們就鍵入，
SELECT Store_Name, SUM(Sales) 
FROM Store_Information 
GROUP BY Store_Name
HAVING SUM(Sales) > 1500;
結果:

Store_Name	SUM(Sales)
Los Angeles	
1800
