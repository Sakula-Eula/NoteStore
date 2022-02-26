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

