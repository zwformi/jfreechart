用JasperReport+Ireport+JSP开发一个完整的WEB报表应用程序
一个报表应用程序：BOOK  REPORT 

需求分析：
	这个程序按书籍类别汇总一个小型图书室的书籍，以报表的形式列出书籍清单，统计书籍的册数。报表的格式包括HTML和EXCEL，其中WEB方式用于预览，EXCEL方式让用户保存文件以离线浏览。
	Use Case：用户以WEB方式登录报表参数输入页面，输入书籍类型，提交表单后，在浏览器中显示报表结果让用户预览。用户预览后可以点击“生成XLS文件”，就会得到与预览页面数据相同的Excel报表。

流程图：

详细设计：
一、数据源设计
DBMS：  SQL SERVER 2000
数据库名：library，里面有一张表books存放了书籍的所有信息，具体包括编号、名称、类别。
Query	：select * from books where bookType=类别参数
实际应用中的报表程序都要牵涉到多个表的查询，过程一般也要复杂得多，真正较常用的Query是一个能够返回ResultSet的存储过程(即最后一条语句是Select语句)。