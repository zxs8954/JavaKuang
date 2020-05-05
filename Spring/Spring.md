# 1.Spring

## 1.1 简介 

- Spring ： 春天，为软件行业爱来春天
- 2002，首次推出Spring框架雏形  interface21
- Rod Jonson
- 2004年Spring诞生
- Spring 理念：使现有技术更容易实现，本身是一个大杂烩，整合了现有的技术框架
- SSM：mybatis,spring，SpringMVC



<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>

## 1.2 优点

- Spring是一个免费的框架（容器）
- Spring是一个轻量级，非入侵试框架
- **控制反转（IOC），面向切面编程（AOP）**
- 支持事物的处理，对框架的整合支持



总结一句话：Spring就是一个轻量级的控制反转（IOC）和面向切面编程（AOP）的框架



## 1.3组成

![image-20200503160117540](D:\JavaKuang\spring组成.png)



## 1.4 拓展

在Spring官网介绍：现代化JAVA开发

- Spring-boot
  - 一个快速开发的教授叫
  - 基于Spring-boot可以快速开发的单个微服务
  - 约定大于配置
- SpringCloud
  - SpringCloud是基于Spring-boot实现的



现在使用的人多，大多数公司都用Springboot快速开发，学习Springboot的前提，完全掌握SPring和SpringMVC！是一个承上启下的作用！



**弊端：发展了太久，违背了原来的理念，！配置十分繁琐，人称：配置地狱**



# 2 IOC理论推导

1. User Dao接口
2. UserDaoImpl实现类
3. UserService业务接口
4. UserServiceImpl业务实现类



在我们之前的代码，用户的需求会影响原来的代码， 我们需要根据用户的需求去修改源代码

```
//利用set实现动态的注入
public void setUserDao(UserDao userDao){
    this.userDao=userDao;
}
```

- 之前，程序主动创建对象，控制权在程序员手上
- 使用set注入后，程序不再具有主动性，而且变成了程序主动性

这种思想从本质上解决了问题，不用去管理对象的创建。系统的耦合性大大降低这是IOC原型

## 3 IOC本质

控制反转是一种设计思想

控制反转是一种通过描述（XML或者注解）并通过第三方法去生产会获取特定对象的方式。在SPring中实现控制反转的是IOC容器，其实现方法是依赖注入

# 4 IOC创建对象的方式

1.使用无参构造

```
<!--    <bean id="user" class="com.kuang.pojo.User">-->
<!--        <property name="name" value="秦疆"/>-->
<!--    </bean>-->
```

2.假设我们使用有参数构造

- ```
  <!--    下表赋值-->
      <bean id="user" class="com.kuang.pojo.User">
          <constructor-arg index="0" value="狂神说Java"/>
      </bean>
  ```



- 第二种不建议使用

  ```
  <bean id="user" class="com.kuang.pojo.User">
      <constructor-arg type="java.lang.String" value="qinjiang"/>
  </bean>
  ```





- 第三种

  ```
  <bean id="user" class="com.kuang.pojo.User">
      <constructor-arg name="name" value="秦疆"/>
  </bean>
  ```



**总结**：

- 在配置文件加载的时候容器中管理的对象就已经初始化了



## 5 Spring配置

### 5.1别名

```
<alias name="user" alias="asdasdad"/>
```

### 5.2Bean的配置

```
<!--    id：bean的唯一标识符
        就是我们的对象名
        class:bean对象所对应的权限名：包名+类型
        name:也是别名,可以同时取多个别名
-->
    <bean id="userT" class="com.kuang.pojo.UserT" name="user2,u2" >
        <property name="name" value="西部开源"/>
    </bean>
```

# 5.3import

这个import，一般用于团队开发，他可以配置多个文件，导入合并为一个

假设项目中有多个人开发，这三个人复制不同的类开发，不同的类需要注册在不同bean中，我们可以利用import所有人的beans.xml合并为一个总的

- 张三

- 李四

- 王五

- applicationContext.xml

- ```
  <import resource="beans2.xml"/>
  <import resource="beans3.xml"/>
  ```

这个时候使用总的就行

# 6 DI注入

## 6.1 构造器注入

前面说过了

### 6.2 Set方式注入【重点】

- 依赖注入：Set注入
  - 依赖：bean对象的注入依赖于容器
  - 注入：bean对象中的所有属性，有容器来注入

【环境搭建】

1.复杂类型

```
private String name;
private Address address;
private String[] books;
private List<String> hobbys;
private Map<String,String> card;
private Set<String> games;
private Properties info;
private String wife;
```

2.真实测试对象

```
public class Student {

    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbys;
    private Map<String,String> card;
    private Set<String> games;
    private Properties info;
    private String wife;
```



3.beans.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="student" class="com.kuang.pojo.Student">
<!--        第一种普通值-->
        <property name="name" value="秦疆"/>
    </bean>
```





4.测试类

```
ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
Student student= (Student) context.getBean("student");
System.out.println(student.getName());
```

5.完善注入

```
<bean id="address" class="com.kuang.pojo.Address">
    <property name="address" value="杭州"/>
</bean>

<bean id="student" class="com.kuang.pojo.Student">
    <!--        第一种普通值-->
    <property name="name">
        <value>张雪松</value>
    </property>
    <!--        第二种注入 bean注入-->
    <property name="address" ref="address"/>
    <!--        第三种，数组注入-->
    <property name="books">
        <array>
            <value>红楼梦</value>
            <value>西游记</value>
        </array>
    </property>
    <!--        List-->
    <property name="hobbys">
        <list>
            <value>听歌</value>
            <value>敲代码</value>
            <value>看电影</value>
        </list>
    </property>
    <!--        Map-->
    <property name="card">
        <map>
            <entry key="身份证" value="123"></entry>
            <entry key="银行卡" value="5667"></entry>
        </map>
    </property>
    <!--        Set-->
    <property name="games">
        <set>
            <value>LOL</value>
            <value>CF</value>
        </set>
    </property>
    <!--        null-->
    <property name="wife" value="null"/>
    <!--        properties-->
    <property name="info">
        <props>
            <prop key="学号">201210536</prop>
            <prop key="班级">125</prop>
            <prop key="性别">男</prop>
        </props>
    </property>
```





### 6.3 扩展注入

我 可以使用p和c命名空间注入

测试

```
   xmlns:p="http://www.springframework.org/schema/p"
   xmlns:c="http://www.springframework.org/schema/c"
   xsi:schemaLocation="http://www.springframework.org/schema/beans
                    http://www.springframework.org/schema/beans/spring-beans.xsd">

<!--p命名空间注入，直接注入属性值-->
<bean id="user" class="com.kuang.pojo.User" p:name="张雪松" p:age="28"/>

<!--c,通过有参构造器注入    -->
<bean id="user22" class="com.kuang.pojo.User" c:name="未来的你" c:age="28" />
```

```
ApplicationContext context = new ClassPathXmlApplicationContext("UserBeans.xml");
User user = context.getBean("user22", User.class);
System.out.println(user);
```

注意点：

- p命名和C不不能直接使用，要导入约束

  xmlns:p="http://www.springframework.org/schema/p"

  xmlns:c="http://www.springframework.org/schema/c"



###  6.4 bean的作用域

1.单例模式（Spring默认机制）

```
<bean id="user22" class="com.kuang.pojo.User" c:name="未来的你" c:age="28" scope="singleton"/>
```



2. 原型模式（每次从容器中get的时候，都会产生一个新的对象）

   ```
   <bean id="user22" class="com.kuang.pojo.User" c:name="未来的你" c:age="28" scope="prototype"/>
   ```



3.其余的request,session,application.这些只能在web 开发中使用到





# 7 Bean的自动装配



- 自动装配 是Spring满足bean依赖的一种方式
- Spring会在上下文中自动寻找，并且给Bean装配属性



在Spring中有三种装配的方式

1. 在xml中显示的配置
2. 在java中显示配置
3. 饮食的自动装配bean【重要】



## 7.1测试

1 环境搭建

- ​	一个人有2个宠物



## 7.2 byName自动装配

```
 <bean id="cat" class="com.kuang.pojo.Cat"/>
    <bean id="dog" class="com.kuang.pojo.Dog"/>
    <!--
            byName: 会自动在容器上下文中查找，和自己对象set方法后面的值对应的beanid
            byType:会自动在容器上下文中查找,和自己属性类型相同的bean
     -->
    <bean id="person" class="com.kuang.pojo.Person" autowire="byName">
        <property name="name" value="张雪松"/>
        <!--        <property name="dog" ref="dog"/>-->
        <!--        <property name="cat" ref="cat"/>-->
    </bean>
```



### 7.3 byType自动装配

```
<bean id="cat" class="com.kuang.pojo.Cat"/>
<bean id="dog" class="com.kuang.pojo.Dog"/>
<!--
        byName: 会自动在容器上下文中查找，和自己对象set方法后面的值对应的beanid
        byType:会自动在容器上下文中查找,和自己属性类型相同的bean
 -->
<bean id="person" class="com.kuang.pojo.Person" autowire="byType">
    <property name="name" value="张雪松"/>
    <!--        <property name="dog" ref="dog"/>-->
    <!--        <property name="cat" ref="cat"/>-->
</bean>
```



小结：

- byName需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致
- byType需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的类型一致



### 7.4 注解自动装配



JDK1.5支持注解，Spring2.5支持注解开发

要是用注解须知：

1. 导入约束

2. ```
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xmlns:aop="http://www.springframework.org/schema/aop"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
          https://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/context
          https://www.springframework.org/schema/context/spring-context.xsd
          http://www.springframework.org/schema/aop
          https://www.springframework.org/schema/aop/spring-aop.xsd">
   ```

3. 配置注解的支持

```
@Autowired
private Cat cat;
@Autowired
private Dog dog;
```

4. @Autowired

直接在属性上使用即可！也可以在Set方法上使用

使用@Autowired我们可以不用编写Set方法了，前提是你这个自动装配的属性在IOC（Spring)容器中存在且符合名字byName



5. 科普

```jvaa
@Nullable  字段標記了这个注解，说明子可以为空


```



测试代码

```
@Autowired(required = false)
private Cat cat;
@Autowired
private Dog dog;
private String name;
```





# 8、 使用注解开发

使用注解需要导入context约束，增加注解的支持！！！

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       https://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd">
    <!--    开启注解支持-->
    <context:annotation-config/>
```

1、bean

2、 属性如何注入

```
//等价于 <bean id=user class="com.kaung.pojo.User"/>
//@Component组件
@Component
public class User {
    //等价于    <property name="name" value="张雪松"/>
    @Value("张雪松")
    public String name;
}
```

3、衍生的注解

@Component 有几个衍生注解，我们在web开发中，会按照mvc三层架构分层！

- dao:@Repository
- service:@Service
- controller:@Controller

这4个注解功能都是一样的，都是代表将某个类注册到Spring中，装配bean



4、自动装配

@Autowired :自动装配通过类型。名字

@Nullable：字段标记了这个注解，说明字段可以为null

@Resource:自动装配通过名字。类型



5、作用域

6、小结

xml与注解

- xml更加万能，适用于任何场合！维护简单方便
- 注解不是自己的类使用，维护相对复杂

xml与注解最佳实战

- xml用来管理bean
- 注解负责完成属性的注入
- 我们在使用过程中，只需要注意：必须让注解生效，就需要开启注解支持

```
<!--    指明要扫描哪个包，这个包下的注解就会生效-->
<context:component-scan base-package="com.kuang.pojo"/>
<!--    开启注解支持-->
<context:annotation-config/>
```



# 9 javaConfig        使用java的配置方式配置Spring

现在完全不使用Spring的xml配置了，全权交给java去做



JavaConfig是Spring的一个子项目，在SPring4之后，他成为了一个核心功能

配置类

```
//这个也会Spring容器托管，注册到容器中，因为他本来就是一个Comonent
// @Configuration代表一个配置类，就和我们之前看的beans.xml
@Configuration
@ComponentScan("com.kuang.pojo")
public class KuangConfig {
    //注册一个beans,就相当于我们之前写的一个bean标签
    @Bean
    public User getUser() {
         return new User();
    }

}
```





测试类

```
    ApplicationContext context=new AnnotationConfigApplicationContext(KuangConfig.class);
    User user=context.getBean("getUser",User.class);
    System.out.println(user.getName());
}
```



# 10 AOP



## 代理模式

##### 为什么要学习代理模式？因为这是SpringAOP的底层【SpringAOP和SpringMVC】

代理模式的分类

- 静态代理
- 动态代理

### 10.1 静态代理

角色分析：

- 抽象角色：一般会使用接口或者抽象类来解决
- 真实角色：被代理的角色
- 代理角色：代理真实角色，代理真实角色后，我们一般会做一些附属操作
- 客户：访问代理对象的人



代理模式的好处：

- 可以使真实角色的操作更加纯粹不用关注一些公共业务
- 公共业务就交给代理角色！实现业务的分工
- 公共业务发生扩展的时候，方便集中管理





缺点：

- 一个真实角色，就有一个代理角色；代码会翻倍~开发效率会降低

### 10.2 加深认识

dao-->service-->controller-->前端



### 10.3 动态代理

- 动态代理和静态代理角色一样
- 动态代理的类是动态生成的，不是我们直接写好的
- 动态代理分为2大类：
  - 基于接口：JDK
  - 基于类：cglib
  - java字节码



需要了解2个类：Proxy,InvocationHandler:调用处理程序

**InvocationHandler：接口**处理代理实例并返回结果

Proxy:生成代理类





固定的

```
private Object target;
public void setTarget(Object target){
    this.target=target;
}
//生成得到代理类
public Object getProxy() {
    return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
}

//处理代理实例，并返回结果
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    log(method.getName());
    //动态代理的本质，就是使用反射
    return method.invoke(target, args);
}
public void log(String msg){
    System.out.println("执行了"+msg+"方法");
}
```





测试

```
UserServiceImpl userService=new UserServiceImpl();
//代理角色
ProxyInvocationHandler pih=new ProxyInvocationHandler();
pih.setTarget(userService);
UserService proxy= (UserService) pih.getProxy();
proxy.add();
```



动态代理的好处：

- 可以使真实角色的操作更加纯粹不用关注一些公共业务
- 公共业务就交给代理角色！实现业务的分工
- 公共业务发生扩展的时候，方便集中管理
- 一个动态代理类，代理的是接口，一般对应的就是一类接口
- 一个动态代理类，可以代理多个类，只要实现接口就行



AOP方式一：使用SpringAPI

```
<!--    使用方式一-->
<!--    配置AOP-->
<aop:config>
    <!--        切入点  execution(要执行的位置！ )-->
    <aop:pointcut id="pointcut" expression="execution(* com.kuang.service.UserServiceImpl.*(..))"/>
    <!--        执行环绕-->
    <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
    <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>
</aop:config>
```



```
public class AfterLog implements AfterReturningAdvice {
    //returnValue返回值
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object object) throws Throwable {
        System.out.println("执行了"+method.getName()+"返回结果为"+returnValue);
    }
}
```

```
public class Log implements MethodBeforeAdvice {
    //method要执行的方法
    //object:参数

    public void before(Method method, Object[] objects, Object object) throws Throwable {
        System.out.println(object.getClass().getName()+"的"+method.getName()+"被执行了");
    }
```

AOP方式二：使用自定义类

```
public class DiyPointCut {
    public void before(){
        System.out.println("=====方法执行前=======");
    }
    public void after(){
        System.out.println("======方法执行后======");
    }
}
```

```
<!--    方式二：自定义类-->
<bean id="diy" class="com.kuang.diy.DiyPointCut"/>
    <aop:config>
        <!--      自定义切面，ref要引用的类      -->
        <aop:aspect ref="diy">
            <!--                切入点-->
            <aop:pointcut id="point" expression="execution(* com.kuang.service.UserServiceImpl.*(..))"/>
            <!--                通知-->
            <aop:before method="before" pointcut-ref="point"/>
            <aop:after method="after" pointcut-ref="point"/>
        </aop:aspect>
    </aop:config>
```

方式三：注解实现

```
//使用注解的方式实现AOP
@Aspect     //标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("=====方法执行前=======");
    }
    @After("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("======方法执行后======");
    }
    //在环绕增强中，我们可以给定一个参数，代表我们要处理的点
    @Around("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        Object proceed=joinPoint.proceed();
        System.out.println("环绕后")
```



```
<bean id="annotationPointCut" class="com.kuang.diy.AnnotationPointCut"/>
<aop:aspectj-autoproxy/>
```





# 12 整合mybatis

步骤：

1.导入jar包

- junit
- mybatis
- mysql
- spring

2.编写配置文件

3.测试



## 12.1、 回忆mybatis

1.编写实体类

2.编写配置文件

3.编写接口

4.编写mapper

5.测试



## 12.2、mybatis-spring



# 13、声明式事物



## 1. 事物回顾

- 要么成功，要么失败
- 事物在项目开发中，十分重要，涉及到数据的一致性，不能马虎
- 确保完整性和一致性



**事物的ACID原则**

- 原子性
- 一致性
- 隔离性
  - 多个业务操作同一个资源，防止数据损坏
- 持久性
  - 事物提交，无论系统发生什么问题，结果都不会被影响，被持久化写到数据库中



2. spring中的事务管理
   - 声明式事务：AOP
   - 编程式事务：需要在代码中，进行事物的管理





思考：

为什么需要事务？

- 如果不配置事务，可能存在事务提交不一致的情况
- 如果我们不在spring中配置声明事务，我们就需要在代码中手动配置事务
- 