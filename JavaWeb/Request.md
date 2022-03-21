# Request

### 1.request对象和response对象的原理

1.request和response对象是由服务器创建的。我们来使用它们

2.request对象是来获取请求消息，response对象是来设置响应消息

### 2.request对象继承体系结构：	

ServletRequest		--	接口
	|	继承
HttpServletRequest	-- 接口
	|	实现
org.apache.catalina.connector.RequestFacade 类(tomcat来实现request)

### 3.request功能

​	1.获取请求消息数据

​		1.获取请求行数据

​		2.获取请求头数据

​		3.获取请求体数据