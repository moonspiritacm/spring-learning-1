# 一、前言

记录 Spring 框架学习过程中的点点滴滴，主要参考汪云飞编著的[《JavaEE 开发的颠覆者：Spring Boot 实战》][1]。

# 二、基础知识

## 1. Spring 框架四大基本原则

### 1.1 使用 POJO 进行轻量级和最小侵入式开发

1. 什么是 POJO

    按照 Martin Fowler 的解释，POJO 是 Plain Old Java Object 的缩写，从字面上翻译为“纯洁老式的 java 对象”，但大家都习惯使用**“简单 java 对象”**称呼它。POJO 的内在含义是指那些没有从任何类继承，也没有实现任何接口，更没有被其它框架侵入的 java 对象。

    Spring 设计的初衷就是为了简化 Java EE 开发，以 EJB 为代表的重量级开发框架过于繁重，业务相关的 Java 对象需要频繁继承框架的类或实现其接口，导致侵入式开发和紧耦合。在 Spring 中，回归简单的 Java Beans，即有无参构造函数，每个字段都有 getter 和 setter 方法的 Java 类。

    POJO 让开发者可专注于业务逻辑和脱离框架的单元测试。由于 POJO 并不需要继承框架的类或实现其接口，开发者能够极其灵活地搭建继承结构和构建应用。POJO 的意义在于它的简单和灵活，由此，POJO 能够任意扩展，从而胜任多个场合，也就让一个模型贯穿多个层成为现实。先写一个核心 POJO，然后实现业务逻辑接口和持久化接口，就成了 Domain Model；UI 需要使用时，就实现数据绑定接口，变成 VO (View Object)。

2. MVC 设计模式

    MVC 设计模式将软件功能划分为三个角色：

    - 模型 (Model) 封装应用数据、应用流程和业务逻辑。Model 中没有任何与表现层相关的特性，也与 HTTP 请求处理职责完全无关。

    - 视图 (View) 从 Model 中获取数据并格式化以进行显示。

    - 控制器 (Controller) 实现 Model 和 View 分离：接收输入（请求），定义和调用 Model；控制输出（响应），决定负责显示数据的 View。

3. 三层体系架构

    三层体系架构将软件划分为表现层、业务逻辑层和数据访问层。

4. ORM

    PO (persistant object) 持久化对象，ORM 中的概念，与数据库紧密相关。PO 实际上对应数据库中的实体，可以看成与数据库中的表相对应的 Java 对象。POJO 是由 new 创建，由 GC 回收。PO 是数据库 insert 创建，由数据库 delete 删除的，一般其生命周期和数据库密切相关。此外，PO 往往只能存在于一个数据库连接中，连接关闭以后，持久对象就不存在了，而 POJO 只要不被 GC 回收，总是存在的。

    VO (value object) 值对象，通常用于业务层之间的数据传递。

5. POJO 扩展

    POJO 仅包含最简单的字段属性，本质上就是一个普通的 JavaBean。在 POJO 的基础上，能够扩展出不同的对象：

    - 为 POJO 增加持久化的方法（Insert、Update、Delete）后，POJO 就变成了 PO。

    - 为 POJO 增加数据绑定功能后，POJO 就变成了 View Object，即UI Model。

    - 为 POJO 增加业务逻辑的方法后，POJO 就变成了 Domain Model。

    - POJO 还可以当作 DTO 使用。

6. 侵入式开发与非侵入式开发的区别

    假设大家都想要把用户代码塞到一个框架里。侵入式的做法就是要求用户代码了解框架的代码，表现为用户代码需要继承框架提供的类。非侵入式则不需要用户代码引入框架代码的信息，从类的编写者角度来看，察觉不到框架的存在。

    例如：使用 struts 的时候，我需要继承一些 struts 的类，这时 struts 侵入到了我的代码里。使用 spring，编写一些业务类的时候不需要继承 spring 特定的类，通过配置完成依赖注入后就可以使用，此时，spring 就没有侵入到我业务类的代码里。

    侵入式让用户代码产生对框架的依赖，这些代码不能在框架外使用，不利于代码的复用。但侵入式可以使用户跟框架更好的结合，更容易更充分的利用框架提供的功能。非侵入式的代码则没有过多的依赖，可以很方便的迁移到其他地方。但是与用户代码互动的方式可能就比较复杂。

### 1.2 通过依赖注入和基于接口编程实现松耦合

    IoC (Inversion of Control) 控制反转，IoC 容器负责创建对象和维护对象间的依赖关系，而不是对象内部通过代码创建依赖对象。

    DI (Dependency Injection) 依赖注入，组件间的依赖关系由容器在运行期决定，动态地将依赖关系注入到组件中。

    Spring 中，控制反转是通过依赖注入实现的，目的是解耦。

### 1.3 通过 AOP 和默认习惯进行声明式编程

### 1.4 使用 AOP 和模板减少模式化代码

## 2. Spring 配置方式

xml 配置、注解配置和 Java 配置都被称为配置元数据，即描述数据的数据。Spring 容器解析这些配置元数据进行 Bean 初始化、配置和管理依赖。

### 2.1 xml 配置

### 2.2 注解配置

### 2.3 Java 配置

    注解配置和 Java 配置都使用注解，二者的区别在于使用注解的方式。注解配置直接在 POJO 类上注解，而 Java 配置主要由 @Confirguration 注解的配置类实现，在普通 POJO 类内只添加少量注解。

    涉及全局配置的，如数据库相关配置、MVC相关配置等，采用 xml 配置或 Java 配置；涉及业务配置的，采用注解配置 (@Service @Component @Repository @Controller)。

## 3. GAV 坐标

groupID、artifactID 和 version 三者唯一确定项目依赖：

- groupID：组织的唯一标识

- artifactID：项目的唯一标识

- version：项目的版本

# 三、开发笔记

## 1. Spring 依赖注入

### 1.1 [基于注解配置的依赖注入](ioc/src/main/java/com/moonspirit/springlearning/ioc/annotationconfig/)

声明 Bean 的注解：

- @Component 组件，没有明确的角色

- @Servie 业务逻辑层组件

- @Respository 数据访问层组件

- @Controller 表现层组件

注入 Bean 的注解：

- @Autowired 自动装载

- @Inject 注入

- @Resource 资源

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

## 3. Spring 常用配置

### 3.1 [profile](setting/src/main/java/com/moonspirit/springlearning/setting/profile/)

profile 为不同环境下应用不同配置提供支持，使用注解 @Profile("") 配置 bean 加载环境，只有当选择对应的环境时，才会产生对应的 bean。

设置运行环境有以下几种方法：

- 通过应用上下文设置 `context.getEnvironment().setActiveProfiles("dev")`

- 通过 JVM 配置 `-Dspring.profiles.active="production"`

- Web 应用在 web.xml 中配置

```xml
        <init-param>
            <param-name>spring.profiles.default</param-name>
            <param-value>development</param-value>
        </init-param>
```

### 3.2 [event](setting/src/main/java/com/moonspirit/springlearning/setting/event/)

Spring 事件实现实体类

[1]: https://www.cnblogs.com/yabin/p/6366151.html
