## 1.Spring简介

### 1.1spring

是一款框架，框架就是一款半成品的软件。

它可以简化开发以快速使用

### 1.1.2 spring 的优势

 **方便解耦，简化开发** 通过 Spring 提供的 IoC 容器，可以将对象间的依赖关系交由 Spring 进行控制，避免硬编码所造 成的过度程序耦合。用户也不必再为单例模式类、属性文件解析等这些很底层的需求编写代码，可 以更专注于上层的应用。

 **AOP 编程的支持** 

通过 Spring 的 AOP 功能，方便进行面向切面的编程，许多不容易用传统 OOP 实现的功能可以 通过 AOP 轻松应付。

 **声明式事务的支持** 

可以将我们从单调烦闷的事务管理代码中解脱出来，通过声明式方式灵活的进行事务的管理， 提高开发效率和质量。

 **方便程序的测试** 

可以用非容器依赖的编程方式进行几乎所有的测试工作，测试不再是昂贵的操作，而是随手可 做的事情。

 **方便集成各种优秀框架** 

Spring 可以降低各种框架的使用难度，提供了对各种优秀框架（Struts、Hibernate、Hessian、Quartz 等）的直接支持。

 **降低 JavaEE API 的使用难度** 

Spring 对 JavaEE API（如 JDBC、JavaMail、远程调用等）进行了薄薄的封装层，使这些 API 的 使用难度大为降低。

 **Java 源码是经典学习范例**

 Spring 的源代码设计精妙、结构清晰、匠心独用，处处体现着大师对 Java 设计模式灵活运用以 及对 Java 技术的高深造诣。它的源代码无意是 Java 技术的最佳实践的范例。 

## 2.IoC的概念和作用

#### 2.1程序间的耦合和解耦

2.1.1程序间的耦合

就是程序间关系密切，牵一发而动全身，不利于后期的维护和修改。

如：

`public static void main(String[] args) throws Exception { //1.注册驱动 //DriverManager.registerDriver(new com.mysql.jdbc.Driver()); Class.forName("com.mysql.jdbc.Driver"); `

`//2.获取连接 //3.获取预处理 sql 语句对象 //4.获取结果集 //5.遍历结果集 } }` 

这上面的new一个驱动

**Class.forName("com.mysql.jdbc.Driver");//此处只是一个字符** 

而这下面的驱动只是代表一个字符串，不会因为输入错误而导致编译期错误。

##### 2.1.2解决程序耦合的思路

  当我们学习jdbc时，是通过反射来注册驱动的，还有就是使用proprity文件来直接修改数据库的连接，而不是直接修改代码。这就是解耦的方式使用配置文件来给文件配置。

##### 2.1.3工厂模式解耦

  在实际开发中我们可以把三层的对象都使用配置文件配置起来，当启动服务器应用加载的时候，让一个类中的 方法通过读取配置文件，把这些对象创建出来**并存起来**。在接下来的使用的时候，直接拿过来用就好了。 那么，这个**读取配置文件，创建和获取三层对象的类就是工厂。** 

2.1.4 控制反转IOC

由于我们是很多对象，把他们存起来肯定是要找集合有**map**和**list**选择

到底选 Map 还是 List 就看我们有没有查找需求。有查找需求，选 Map。 

所以我们的答案就是 在应用加载时，创建一个 Map，用于存放三层对象。 我们把这个 map 称之为**容器**。 

**工厂：**

工厂就是负责给我们从容器中获取指定对象的类。这时候我们获取对象的方式发生了改变。

 原来： 我们在获取对象时，都是采用 new 的方式。是`主动的`。 

现在： 我们获取对象时，同时跟工厂要，有工厂为我们查找或者创建对象。是**被动的** 

要啥别人都给你搞好了，不用new，把创建对象的权利交给框架，

## 3.使用spring的IOC解决程序的耦合

#### 基于XML的配置入门案例

**一：**拷贝必备的Jar包到工程的lib目录中

**二：** 在类的根路径下创建一个任意名称的xml文件（不可含有中文）导入spring官网上的配置

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
  
</beans>
```

```
/**
 * 获取spring的Ioc核心容器，并根据id获取对象
 *
 * ApplicationContext的三个常用实现类：
 *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
 *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
 *
 *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
 *
 * 核心容器的两个接口引发出的问题：
 *  ApplicationContext:     单例对象适用              采用此接口
 *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
 *
 *  BeanFactory:            多例对象使用
 *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
 * @param args
 */
```

**三：**让spring管理资源，在配置文件中配置service和Dao

bean标签：用于配置让spring创建对象，并且存如ioc容器中

​	id属性：对象的唯一标识

​	class属性：指定要创建的全限定类名

**作用：** 用于配置对象让 spring 来创建的。 默认情况下它调用的是类中的无参构造函数。如果没有无参构造函数则不能创建成功。

 **属性**： scope：指定对象的作用范围。 

​		singleton :默认值，单例的. 

​		prototype :多例的. 

* request :WEB 项目中,Spring 创建一个 Bean 的对象,将对象存入到 request 域中. 
* session :WEB 项目中,Spring 创建一个 Bean 的对象,将对象存入到 session 域中.
* global session :WEB 项目中,应用在 Portlet 环境.如果没有 Portlet 环境那么 globalSession 相当于 session.
*  init-method：指定类中的初始化方法名称。
*  destroy-method：指定类中销毁方法名称。 

bean的作用范围和生命周期

**单例对象：scope="singleton" 一个应用只有一个对象的实例。它的作用范围就是整个引用。** 

生命周期： 对象出生：当应用加载，创建容器时，对象就被创建了。 

对象活着：只要容器在，对象一直活着。

 对象死亡：当应用卸载，销毁容器时，对象就被销毁了。 

**多例对象：scope="prototype" 每次访问对象时，都会重新创建对象实例。 生命周期：**

 对象出生：当使用对象时，创建新的对象实例。

 对象活着：只要对象在使用中，就一直活着。 

对象死亡：当对象长时间不用时，被 java 的垃圾回收器回收了。 

####  实例化 Bean 的三种方式  



```java
<!-- 第一种方式：使用默认构造函数创建。
        在spring的配置文件中使用bean标签，配以id和class属性之后，且没有其他属性和标签时。
        采用的就是默认构造函数创建bean对象，此时如果类中没有默认构造函数，则对象无法创建。

<bean id="accountService" class="com.service.impl.accountServiceImpl"></bean>
-->
要求accountServiceImpl类中有无参构造方法
```

```java
<!-- 第二种方式： 使用普通工厂中的方法创建对象（使用某个类中的方法创建对象，并存入spring容器）
<bean id="instanceFactory" class="factory.InstanceFactory"></bean>
<bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"></bean>
-->

<!-- 第三种方式：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器)
<bean id="accountService" class="factory.StaticFactory" factory-method="getAccountService"></bean>
-->

```

通过上面三种实例化bean，就可通过getbean来得到对象而不通过使用new的方式

## 4.DI依赖注入

它是spring的框架核心ioc的具体实现

我们使用框架时，通过ioc，把对象交给spring，但是代码中不可能出现没有依赖的的情况，ioc可以降低耦合度，service层还是会调用dao层

那这种业务层和持久层的依赖关系，在使用 spring 之后，就让 spring 来维护了。 简单的说，就是坐等框架把持久层对象传入业务层，而不用我们自己去获取。 

```java
<!--构造函数注入：
    使用的标签:constructor-arg
    标签出现的位置：bean标签的内部
    标签中的属性
        type：用于指定要注入的数据的数据类型，该数据类型也是构造函数中某个或某些参数的类型
        index：用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置是从0开始
        name：用于指定给构造函数中指定名称的参数赋值                                        常用的
        =============以上三个用于指定给构造函数中哪个参数赋值===============================
        value：用于提供基本类型和String类型的数据
        ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象

    优势：
        在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。
    弊端：
        改变了bean对象的实例化方式，使我们在创建对象时，如果用不到这些数据，也必须提供。
-->
```

```java
<!-- set方法注入                更常用的方式
    涉及的标签：property
    出现的位置：bean标签的内部
    标签的属性
        name：用于指定注入时所调用的set方法名称
        value：用于提供基本类型和String类型的数据
        ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象
    优势：
        创建对象时没有明确的限制，可以直接使用默认构造函数
    弊端：
        如果有某个成员必须有值，则获取对象是有可能set方法没有执行。
-->
配置文件代码：
<beans xmlns="http://www.springframework.org/schema/beans"
 xmlns:p="http://www.springframework.org/schema/p"
     
```

```
<!-- 复杂类型的注入/集合类型的注入
    用于给List结构集合注入的标签：
        list array set
    用于个Map结构集合注入的标签:
        map  props
    结构相同，标签可以互换
-->
```