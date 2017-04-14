##课程实验原因，初步学习hibernate框架

### 1. mysql 数据库登录问题
 1. 打开命令窗口或者是ide集成的terminal窗口

        mysql -u root -p
   
 2. 输入密码。
    
 3. 显示当前数据库中的数据
       
        show databases
    
 4. 选择进入哪一个数据库 
    
        use databasename
  

### 2. 中间碰到的问题
1. **[问题描述]** java.lang.ClassNotFoundException: javax.transaction.SystemException  
   出错在Configuration cfg = new Configuration().configure();

    **[解决措施]**将下载的hibernate中的文件jta.jar放到自己的lib目录下面就好了。
	
2. **[问题描述]**Exception in thread “main” java.lang.NoClassDefFoundError:javax/ persistence/Cacheable

    **[解决措施]** 将hibernate包文件下的 hibernate-jpa-2.0-api-1.0.0.Final放到自己的项目目录下。
	
3. **[问题描述]**com.mysql.cj.core.exceptions.InvalidConnectionAttributeException: The server time zone value '�й���׼ʱ��' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
 
    **[解决措施]** 修改hibernate.hb.xml文件，增加serverTimezone=UTC 解决完成之后如下
	<property name="connection.url">jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC</property>

4. **[问题描述]**java.sql.SQLSyntaxErrorException: Unknown table 'sequences' in information_schema
 
    **[解决措施]**  在hibernate.hbm.xml中的dialect出现了问题。改成自己对应的dialect就可以了。
      本机mysql用的方言是<property name="dialect">org.hibernate.dialect.MySQLDialect</property>
	  
5. **[问题描述]** java.lang.ClassNotFoundException: org.apache.lucene.analysis.standard.StandardAnalyzer

    **[解决措施]** 将download jar(lucene-1.2.jar)放到自己的lib目录下面
