Spring的概念：Spring是一个java的开源框架，Spring核心是ioc和aop;	
	spring 是一个容器，管理java对象，对象的依赖关系；
	spring的主要作用是解耦
	
	
IOC：控制翻转，吧java对象的创建权限转移给了容器Spring，ioc是一个想法，概念
	依赖注入（DI）是实现的技术方式，实际上是反射机制。
	Spring的实现原理是反射机制。
	
知识点：
	1、编写spring的配置文件，引入约束文件
	2、在无网络的情况下如何使用约束文件，配置eclipse使用约束文件
	3、如何定义bean对象
	4、Spring容器对象的创建和使用
	接口ApplicationContext
	实现类：ClassPathXmlApplicationContext
				  FileSystemXmlApplicationContext
				  
开发步骤：
1、导入Spring的jar
	1）Spring的核心jar
	spring-beans.jar,	spring-core.jar 	spring-context.jar 		spring-expression.jar
	这四个jar都位于spring的核心文件夹/libs/目录下
	
	2) 日志jar
	commons.logging.jar
	位于spring依赖库
	
	3）其他jar
	单元测试 junit.jar   记录日志 log4j.jar
2.定义java类‘
3、定义spring的配置文件，告诉哪些对象要交给spring容器去创建
	1）xml文件
	2）加入约束文件，第一个约束文件是spring-beans.xsd
	3)使用<bean>标签定义java对象
4、定义测试类
创建spring的容器对象，从容器中获取对象