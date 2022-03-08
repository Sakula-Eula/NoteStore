## Mybatis框架

mybatis框架是基于Java的持久层的框架，它内部封装了jdbc，开发者就只用关心sql，而不用去关心加载驱动和连接等内容和过程。

作为持久层的框架，还有一个封装程度更高的框架就是Hibernate，但这个框架因为各种原因目前在国内的 流行程度下降太多，现在公司开发也越来越少使用。目前使用 Spring Data 来实现数据持久化也是一种趋势。 

常用的框架：

**springMVC**

**spring**

mybatis的入门：

第一步：创建maven工程并导入坐标

第二步：创建实体类dao接口

第三步：创建mybatis的主配置文件

​	sqlmapconfig.xml

第四步：创建映射配置文件

​	IuserDao.xml

注意事项：

1. 创建映射配置文件和我主配置文件时名称是为了和我们之前的知识保持一致，在mybatis中把持久层的操作接口名称和映射文件也叫做：mapper

2. 在idea中创建目录和包不一样

   包创建时：com.dao 二级结构

   目录com.dao 是一级结构

3. mybatis的映射配置文件位置和dao接口包的结构一致

4. 映射配置文件发mapper标签namespace属性取值必须是dao接口二点全限定类名

5. 映射配置文件的操作配置，id属性的取值必须是dao接口的方法名

   **要求： 创建位置：必须和持久层接口在相同的包中。**

   ***名称：必须以持久层接口名称命名文件名，扩展名是.xml***

```
<!-- mybatis的主配置文件xml -->
<configuration>
    <!-- 配置环境 -->
    <environments default="mysql">
        <!-- 配置mysql的环境-->
        <environment id="mysql">
            <!-- 配置事务的类型-->
            <transactionManager type="JDBC"></transactionManager>
            <!-- 配置数据源（连接池） -->
            <dataSource type="POOLED">
                <!-- 配置连接数据库的4个基本信息 -->
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/eesy_mybatis"/>
                <property name="username" value="root"/>
                <property name="password" value="1234"/>
            </dataSource>
        </environment>
    </environments>

    <!-- 指定映射配置文件的位置，映射配置文件指的是每个dao独立的配置文件 -->
    <mappers>
        <mapper resource="com/itheima/dao/IUserDao.xml"/>
    </mappers>
</configuration>
```

**mybatis入门：**

​	1.读取配置文件

​	2.创建SqlSessionFactory工厂

​	3.创建SqlSession

​	4.创建Dao接口的代理对象

​	5.执行dao中的方法

​	6.释放资源

注意：不要忘记在映射配置中告知mybatis要封装到哪个实体类中

![1646198749407](C:\Users\熊振宁\AppData\Local\Temp\1646198749407.png)

**使用注解进行运行时**

```
<!-- 指定映射配置文件的位置，映射配置文件指的是每个dao独立的配置文件
    如果是用注解来配置的话，此处应该使用class属性指定被注解的dao全限定类名
-->
```