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

## 2. Spring 面向切面编程

### 2.1 [基于注解拦截的 AOP](aop/src/main/java/com/moonspirit/springlearning/aop/annotationaop/)

#### 2.1.1 [Action.java](aop/src/main/java/com/moonspirit/springlearning/aop/annotationaop/Action.java) 根据拦截规则自定义注解

- @Retention 定义注解的保留策略

  @Retention(RetentionPolicy.SOURCE)  注解仅存在于源码中，不包含在 class 字节码中
  @Retention(RetentionPolicy.CLASS)   默认的保留策略，注解在 class 字节码中存在，但运行时无法获得
  @Retention(RetentionPolicy.RUNTIME) 注解存在于 class 字节码中，运行时可以通过反射获取到
　
注解生命周期 SOURCE < CLASS < RUNTIME。如果需要在运行时去动态获取注解信息，只能用 RUNTIME 注解；如果要在编译时进行一些预处理操作，就用 CLASS 注解；如果只是做一些检查性操作，比如 @Override 和 @SuppressWarnings，则选用  SOURCE 注解。

- @Target 定义注解的作用目标

  @Target(ElementType.TYPE)             接口、类、枚举、注解
  @Target(ElementType.FIELD)            字段、枚举的常量
  @Target(ElementType.METHOD)           方法
  @Target(ElementType.PARAMETER)        方法参数
  @Target(ElementType.CONSTRUCTOR)      构造函数
  @Target(ElementType.LOCAL_VARIABLE)   局部变量
  @Target(ElementType.ANNOTATION_TYPE)  注解
  @Target(ElementType.PACKAGE)          包

- @Document 该注解被包含在 javadoc 中

#### 2.1.2 [AnnotationService.java](aop/src/main/java/com/moonspirit/springlearning/aop/annotationaop/AnnotationService.java) 基于注解的被拦截类

使用自定义注解 @Action 标注连接点，当程序运行到 @Action 标注的位置时触发拦截。

#### 2.1.3 [AnnotationAspect.java](aop/src/main/java/com/moonspirit/springlearning/aop/annotationaop/AnnotationAspect.java) 基于注解拦截的切面类

由于使用了自定义注解，基于注解拦截的切面类编写较简单：通过 @Action 自定义注解声明切点，`@Pointcut("@annotation(Action)")`；通过切点声明建言，`@Before("annotationPointCut()")`。

### 2.2 [基于方法规则拦截的 AOP](aop/src/main/java/com/moonspirit/springlearning/aop/methodaop/)

方法规则拦截对代码没有侵入性，不需要在被拦截方法上添加注解，仅根据包名、类名或方法名以及参数类型进行拦截，在切面类中需要编写 AOP 表达式声明切点，`@Pointcut("execution(* MethodService.*(..))")`。

# 三、参考书籍

- Java EE 开发的颠覆者：Spring Boot 实战 /汪云飞编著
