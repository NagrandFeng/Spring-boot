# Spring-boot
学习spring-boot写的demo


##maven依赖
1、spring-boot-starter-web   
包含spring-web,spring-webmvc
tomcat-emed-* 内嵌tomcat容器
jackson 处理json数据
spring-*spring框架
spring-boot-autoconfigure spring-boot提供的自动配置功能

2、spring-boot-starter-actuator
应用启动后会创建一些基于web的Endpoint
/autoconfig 用来查看spring boot 的框架自动配置信息，哪些被自动配置，哪些没有，原因是什么
/beans，显示应用上下文的Bean列表
/dump,显示线程dump的信息
/health 应用健康状况调查
/metrics
/shutdown
/trace

##各maven包
spring-boot-starter:核心spring boot starter 提供大部分基础功能，其他starter都依赖于他，因此没有必要显示定义

spring-boot-starter-actuator：主要提供监控、管理和审查应用程序的功能。

spring-boot-starter-jdbc：该starter提供对JDBC操作的支持，包括连接数据库、操作数据库，以及管理数据库连接等等。

spring-boot-starter-data-jpa：JPA starter提供使用Java Persistence API(例如Hibernate等)的依赖库。

spring-boot-starter-data-*：提供对MongoDB、Data-Rest或者Solr的支持。

spring-boot-starter-security：提供所有Spring-security的依赖库。

spring-boot-starter-test：这个starter包括了spring-test依赖以及其他测试框架，例如JUnit和Mockito等等。

spring-boot-starter-web：该starter包括web应用程序的依赖库。




##特点：Java代码中没有任何配置，多了两个符号
EnableAutoConfiguration
SpringApplication

##springboot的注解

@ComponentScan路径被默认设置为SampleController的同名package，也就是该package下的所有@Controller,@Service,@Component,@Repository都会被实例化后并加入spring context中

@EnableAutoConfiguration
引入@Enabe...注解对@Configuration类进行修饰以达到和XML配置相同的效果。

@EnableAutoConfiguration :Spring Boot自动配置（auto-configuration）：尝试根据你添加的jar依赖自动配置你的Spring应用

@ComponentScan
表示将该类自动发现（扫描）并注册为Bean，可以自动收集所有的Spring组件，包括@Configuration类。我们经常使用@ComponentScan注解搜索beans，并结合@Autowired注解导入。

@Configuration
相当于传统的xml配置文件，如果有些第三方库需要用到xml文件，建议仍然通过@Configuration类作为项目的配置主类——可以使用@ImportResource注解加载xml配置文件。

@SpringBootApplication
相当于@EnableAutoConfiguration、@ComponentScan和@Configuration的合集。

@Import
用来导入其他配置类。

@ImportResource
用来加载xml配置文件
@Autowired
自动导入依赖的bean
@Service
一般用于修饰service层的组件
@Repository
使用@Repository注解可以确保DAO或者repositories提供异常转译，这个注解修饰的DAO或者repositories类会被ComponetScan发现并配置，同时也不需要为它们提供XML配置项。


##spring boot 的安全控制
启用安全控制需要做到两步
1、在pom中添加spring-boot-starter-security 包
2、在application.properties中添加
     

	1. #用户名 密码配置  
	2. security.user.name=admin  
	3. security.user.password=test  

如果不添加，系统会自动分配一个默认的password，用户名为user



##spring boot 的日志使用
需要依赖commons logging,java util Logging,log4j或slf4j
日志选择logback作为日志记录的载体



##spring boot 修改contextPath的路径
默认路径为/，即直接访问localhost:8080/即可
在application.properties里添加配置
server.context-path=/spring-boot
之后变为localhost:8080/spring-boot


##spring boot 静态资源映射
其中默认配置的 /** 映射到 /static （或/public、/resources、/META-INF/resources）




##error : mvn spring-boot run启动控制台出现中文乱码的情况
解决方法
在配置spring-boot-maven-plugin中添加
```xml
<configuration>
       <jvmArguments>-Dfile.encoding=UTF-8</jvmArguments>
</configuration>
```


