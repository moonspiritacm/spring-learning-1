# 一、前言

记录 Spring 学习过程中的点点滴滴，这里，完全弃用 xml 配置文件，改用 Java 配置和注解实现功能。

# 二、学习笔记

## 1. Spring 依赖注入

### 1.1 [基于 Java 注解的依赖注入](ioc/src/main/java/com/moonspirit/springlearning/ioc/annotationconfig/)

使用 Spring 注解声明实体类，相关注解包括 @controller 、@servies、@respository、@Component。

实体类中使用注解进行依赖注入，例如 @Autowired 自动装载。

配置类不添加内容，自动扫描包内各处注解。

### 1.2 [基于 Java 配置的依赖注入](ioc/src/main/java/com/moonspirit/springlearning/ioc/javaconfig/)

实体类中不使用任何 Spring 注解，转而在配置类中对各实体类及其依赖关系进行集中配置，作用相当于 xml 配置文件。

# 三、参考书籍

- Java EE 开发的颠覆者：Spring Boot 实战 /汪云飞编著
