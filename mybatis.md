# 2.第一个程序

思路：搭建环境--》导入mybatis--》编写代码--》测试

## 1.搭建环境

CREATE DATABASE `mybatis`;
use `mybatis`;

CREATE TABLE `user`(
`id`  int(20)  PRIMARY KEY not NULL,
`name` VARCHAR(30) DEFAULT null,
`pwd` VARCHAR(30) DEFAULT null

);

**1.新建项目**

**2.删除src目录**

**3.导入依赖**

```
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.47</version>
</dependency>
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.2</version>
</dependency>
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
```

## 2.创建一个model

- 编写核心配置文件

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--核心配置文件-->
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://127.0.0.1:3306/mybatis?useSSL=true&amp;userUnicode=true&amp;characterEncoding=utf-8"/>
                <property name="username" value="root"/>
                <property name="password" value="123"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="mapper/Sql.xml"/>
    </mappers>
</configuration>
```

- 编写工具类

- ```
  private static SqlSessionFactory sqlSessionFactory;
  
      static {
          try {
              //获取SQLsession对象
              String resource = "mybatis-config.xml";
              InputStream inputStream = Resources.getResourceAsStream(resource);
              SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  
      public static SqlSession getSqlSession() {
          return sqlSessionFactory.openSession();
      }
  ```

  ## 3.编写代码

  - 实体类

  - ```
    private int id;
    private String name;
    private String pwd;
    ```

  - Dao接口

  - ```
    public interface UserDao {
        List<User> getUserList();
    }
    ```

  - 接口实现类

  - ```
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
            "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    
    <mapper namespace="com.kuang.dao.UserDao">
        <select id="getUserList" resultType="com.kuang.pojo.User">
            select  * from mybatis.user;
        </select>
    </mapper>
    ```

## 4.测试

```
//第一步：获得sqlSession
SqlSession sqlSession = MybatisUtils.getSqlSession();
//第二步：
UserDao userDao = sqlSession.getMapper(UserDao.class);
List<User> userList = userDao.getUserList();
for (User user : userList) {
    System.out.println(user);
}
sqlSession.close();
```



```
//第一步：获得sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        //第二步：
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> userList = userDao.getUserList();
        //方式二：
        List<User> userList=sqlSession.selectList("com.kuang.dao.UserDao.getUserList");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
```

## 5.CRUD

### 1namespace

namespce中的包名要和Dao/mapper接口包名一致

### 2select

选择查询语句

- id就是对应的命名的namespace中的方法名
- resultType:SQL语句执行的返回值
- paramtype：参数类型

1.编写接口

```
public interface UserMapper {
    //获取全部用户
    List<User> getUserList();
    //根据ID查询用户
    User getUserById(int id);
    //删除用户
    boolean deleteUser(int id);
    //添加用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
}
```

2.编写对应mapper中的SQL

```
<select id="getUserList" resultType="com.kuang.pojo.User">
    select  * from mybatis.user
</select>
<select id="getUserById" resultType="com.kuang.pojo.User">
    select * from mybatis.user where id=#{id}
</select>
<delete id="deleteUser" parameterType="int">
    delete from mybatis.user where id=#{id}
</delete>
<insert id="addUser" parameterType="com.kuang.pojo.User">
    insert into user (id,name,pwd)values (#{id},#{name},#{pwd})
</insert>
<update id="updateUser" parameterType="com.kuang.pojo.User">
    update user set name=#{name},pwd=#{pwd} where id=#{id}
</update>
```

3.测试

### 3 insert

```
@Test
public void add(){
    SqlSession sqlSession=MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    int i=mapper.addUser(new User(6,"zxs","666"));
    System.out.println(i);
    //提交事务
    sqlSession.commit();
    sqlSession.close();
}
```

### 4 delete

```
@Test
public void delete(){
    SqlSession sqlSession=MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    boolean b=mapper.deleteUser(1);
    System.out.println(b);
    sqlSession.commit();
    sqlSession.close();
}
```

### 5update

```
@Test
public void update(){
    SqlSession sqlSession=MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    int i=mapper.updateUser(new User(1,"aa","aa"));
    System.out.println(i);
    sqlSession.commit();
    sqlSession.close();
}
```

### 6select

```
@Test
public void test() {
    //第一步：获得sqlSession
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    List<User> userList=mapper.getUserList();
    for(User u:userList){
        System.out.println(u);
        System.out.println("==================");
    }
    sqlSession.close();
}
@Test
public void getId(){
    SqlSession sqlSession=MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    User user=mapper.getUserById(1);
    System.out.println(user);
    sqlSession.close();
}
```

### 7 万能的Map

假设，我们的实体类，或者数据库中的表字段或者参数过多，我们考虑map!

```
//万能map  不需要知道数据库中有什么
int addUser2(Map<String,Object> map);
```

```
<insert id="addUser2" parameterType="map">
    insert into user (id,name,pwd) values (#{userID},#{userName},#{userPwd})
</insert>
```

```
@Test
public void addUser2(){
    SqlSession sqlSession=MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    Map<String,Object> map=new HashMap<String, Object>();
    map.put("userID",101);
    map.put("userName","hello");
    map.put("userPwd","1231312");
    mapper.addUser2(map);
    sqlSession.commit();
    sqlSession.close();

}
```

### 8 思考题

模糊查询怎么写

1.java代码执行的时候，传递通配符

```
select * from user where  name like "%"#{value}"%"
```



```
SqlSession sqlSession = MybatisUtils.getSqlSession();
UserMapper mapper = sqlSession.getMapper(UserMapper.class);
List<User> userList = mapper.getUserLike("%王%");
for (User u : userList) {
    System.out.println(u);
}
```

## 6 配置解析

### 1.核心配置文件



## 2.环境变量

Mybatis可可以配置多种环境

不过要记住：尽管可以配置多个环境，但是每个sqlSessionFactory实例只能选择一种环境



Mybatis默认的事物管理器就是JDBC，连接池POOLED

## 3.Properties

通过properties属性来实现引用配置文件【db.properties 】

编写配置文件

```
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/mybatis?useSSL=true&amp;userUnicode=true&amp;characterEncoding=UTF-8
username=root
password=123
```

在核心配置文件中引入

```
<properties resource="db.properties"/>
<environments default="development">
    <environment id="development">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="${driver}"/>
            <property name="url" value="${url}"/>
            <property name="username" value="${username}"/>
            <property name="password" value="${password}"/>
        </dataSource>
    </environment>
```

```
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/mybatis?useSSL=true&userUnicode=true&characterEncoding=UTF-8
username=root
password=123
```

## 4 别名

### 1 类别名

- 为java类设置一个短的名字
- 存在的意义进在用于来减少类完全限定名字的冗余

- ```
  <typeAliases>
      <typeAlias type="com.kuang.pojo.User" alias="User"/>   User就是别名
  </typeAliases>
  ```



```
resultType="User"
```

不要加注释，否则会配置失败

### 2 包别名

```
<typeAliases>
    <package name="com.kuang.pojo"/>
</typeAliases>

 <select id="getUserList" resultType="user">
        select  * from user
    </select>
```

会扫描这个包下的所有javabean，默认别名是这个类的首字母小写的类名



**什么时候使用**

- 实体类少的时候用第一种取别名
- 实体类多的时候用第二种取别名

### 3 注解

```
@Alias("user")
public class User {
    private int id;
    private String name;
    private String pwd;
    public User(){}
    
    
   //一定要扫描包 
<properties resource="db.properties"/>
    <typeAliases>
        <package name="com.kuang.pojo"/>
    </typeAliases>
    
    
    <select id="getUserList" resultType="user">
        select  * from user
    </select>
```

### 4 设置

不用记，只有2个设置

日志，缓存需要设置，后续会学

### 5 映射器

MapperRegistry:注册绑定我们的配置文件

方式一：

```
<mappers>
    <mapper resource="mapper/UserMapper.xml"/>
</mappers>
```

方式二：

```
<mapper class="com.kuang.dao.UserMapper"/>
```

注意点：

- 接口和Mapper配置文件必须同名
- 接口和他的Mapper配置文件必须在同一个包下

方式三：包



推荐使用第一种



练习时间：

- 将数据库配置文件外部引入
- 实体类别名

### 6 生命周期和作用域

生命周期是至关重要的，因为错误的使用会导致非常严重的问题**并发问题。**

**SqlSessionFactory:**

- 一旦创建，就不在需要
- 局部变量

![image-20200501151913309](D:\JavaKuang\sqlsessionFactory.png)



**SqlSessionFactory:**

- 就是数据库连接池
- SqlSessionFactory:一旦被创建就应该在应用运行期间一直存在， 没有任何理由丢弃或者从新创建另一个实例

**sqlseesion:**

- 连接到连接池的一个请求
- 关闭
- 非线程安全，不能共享，作家作用域是请求或者方法作用域
- 用完之后关闭

![image-20200501152436621](D:\JavaKuang\sqlsession.png)



这里的每一个mapper，就代表一个具体的业务



## 5.ResultMap解决属性名和字段名不一致的问题

### 1 新建一个项目，拷贝之前，测试实体类不一致

```
private int id;
private String name;
private String password;
```

User{id=2, name='', password='null'}

- 解决办法 起别名

```
 select id,name,pwd as password from user where id=#{id}
```

2 resultMap结果集映射

```java
id name pwd 
id name passwrod
```

```
<!--    结果集映射-->
    <resultMap id="UserMap" type="User">
<!--        column数据库中字段，property实体类属性-->
        <result column="id" property="id"/>
        <result column="name" property="name"/>
        <result column="pwd" property="password"/>
    </resultMap>
    <select id="getUserById" resultMap="UserMap">
        select  * from user where id=#{id}
    </select>
```

# 6 日志

1. ### 日志工厂

   - ```
     <properties resource="db.properties"/>
     <settings>
         <setting name="logImpl" value="STDOUT_LOGGING"/>
     </settings>
     <typeAliases>
         <package name="com.kuang.pojo"/>
     </typeAliases>
     ```

### 2 log4j

1.导入log4j

```
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

2. log4j.properties

   ```
   log4j.rootLogger=info,CONSOLE,A1,file
   
   
   #CONSOLE
   log4j.appender.CONSOLE = org.apache.log4j.ConsoleAppender
   log4j.appender.CONSOLE.target = System.out
   log4j.appender.CONSOLE.threshold = info
   log4j.appender.CONSOLE.layout = org.apache.log4j.PatternLayout
   log4j.appender.CONSOLE.layout.ConversionPattern = [%p]%d{HH:mm:ss,SSS},[Thread]%t,[Class]%c{1},[Method]%M,[Line]%L,%m%n
   
   #A1
   log4j.appender.A1 = org.apache.log4j.DailyRollingFileAppender 
   log4j.appender.A1.file = ./src/log/log.txt
   log4j.appender.A1.DatePattern = '--'yyyy-MM-dd
   log4j.appender.A1.layout = org.apache.log4j.PatternLayout
   log4j.appender.A1.layout.ConversionPattern = [%p]%d{HH:mm:ss,SSS},[Thread]%t,[Class]%c{1},[Method]%M,[Line]%L,%m%n
   ```

# 7 分页

思考为什么分页

减少数据的处理量

使用limit分页

```sql
select * from user limit startIndex endIndex

select * from user limit 3  前3条
select * from user limit 3  ，5 从3开始查，后面的5个
```

# 8 注解开发

### 1. 面向接口编程：解耦

### 2.使用注解开发

```
@Select("select * from user")
    public List<User> getUser();
}
```



```
<mappers>
    <mapper class="com.kuang.dao.Mapper"/>
</mappers>
```



### 3 CRUD开发可以在工具类中设置自动提交事务

```
return sqlSessionFactory.openSession(true);
```

查询

```
@Select("select * from user where id=#{id}")
User getUserById(@Param("id")int id);
```

添加

```
@Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd})")
int addUser(User user);
```

```
@Test
public void test() {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    Mapper mappers = sqlSession.getMapper(Mapper.class);
    int i = mappers.addUser(new User(8,"徐良","888"));
    System.out.println(i);
}
```

更新

```
@Update("update user set name =#{name} where id=#{id}")
int updateUser(User user);
```

删除

```
@Delete("delete from user where id =#{id}")
int deleteUser(int id);
```



通配符包名

```
<mappers>
    <mapper resource="mapper/*.xml"/>
</mappers>
```

# 9 lombok

1. 使用：IDE中安装lombok

2. 添加依赖

3. @Data  get set hashcode tostring  有参数无参数

```
@Data
@AllArgsConstructor
@NoArgsConstructor
```

```
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.10</version>
</dependency>
```

# 10 多对一处理

多个学生对应一个老师

- 学生而言，**关联**。多个学生关联一个老师
- 对于老师而言，一对多。**结合**

## 测试环境搭建

1.导入lombok

2.建立实体类Teacher Student

3.建立Mapper接口

。。。。配置文件中SQL目录和文件名要写全





### 4查询嵌套处理（查询老师和学生tid相等的）

```
//查询所有学生信息，和对应老师的信息
List<Student> getStudent();
```



```
<select id="getStudent" resultMap="StudentTeacher">
select * from student
</select>
<select id="getTeacher" resultType="com.kuang.pojo.Teacher">
    select  * from teacher where id=#{id}
</select>
<resultMap id="StudentTeacher" type="com.kuang.pojo.Student">
    <result property="id" column="id"/>
    <result property="name" column="name"/>
    <association property="teacher" column="tid" javaType="com.kuang.pojo.Teacher" select="getTeacher"/>
</resultMap>
```



```
@Test
public void test() {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
    List<Student> studentList=mapper.getStudent();
   for(Student s:studentList){
       System.out.println(s);
   }
    sqlSession.close();
```



```
<!--        对象association
            集合collection
            -->
```





### 按照结果嵌套处理（建议用这种处理方式）

```
<select id="getStudent2" resultMap="StudentTeacher2">
   select s.id sid,s.name sname,t.name tname
   from student s,teacher t
   where s.tid=t.id
</select>
<resultMap id="StudentTeacher2" type="com.kuang.pojo.Student">
    <result property="id" column="sid"/>
    <result property="name" column="sname"/>
    <association property="teacher" javaType="com.kuang.pojo.Teacher">
        <result property="name" column="tname"/>
    </association>
</resultMap>
```

# 11 一对多

比如一个老师拥有多个学生，对于老师而言，就是一对多



1.环境搭建

```
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int id;
    private  String name;
    //一个老师对应多个学生
    private List<Student> students;
}
```



```
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int tid;
}
```

### 小结

- 关联 association  【多对一】
- 集合 collection【一对多】

javaType&&ofType

- javaType用来指定实体类的属性类型
- ofType指定映射到List或者集合中pojo类型，泛型中的约束类型

注意点：

- 保证SQL的可读性，通俗易懂
- 注意一对多和多对一种属性名和字段的问题
- 如果不好排查问题，可以使用日志，建议用log4j

面试高频

- mysql引擎
- InnovationDB底层原理
- 索引
- 索引优化

# 12 动态SQL

**什么是动态SQL：根据不同的条件生成不同的SQL**

### 搭建环境

```sql

CREATE TABLE `blog`(

`id` VARCHAR(50) not null COMMENT '博客ID',
`title` varchar(100) not null COMMENT '博客标题',
`author` VARCHAR(30) not null COMMENT '博客作者',
`create_time` datetime not null COMMENT '创建时间',
`view` int(30) not null COMMENT '浏览量'
)ENGINE=INNODB DEFAULT charset=utf8
```



```
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}

```



### IF

```
<select id="queryBlogIF" parameterType="map" resultType="com.kuang.pojo.Blog">
    select * from blog where 1=1
    <if test="id!=null">
        and id=#{id}
    </if>
    <if test="title!=null">
        and title=#{title}
    </if>
    <if test="author!=null">
        and author=#{author}
    </if>
    <if test="create_time!=null">
        and create_time=#{create_time}
    </if>
    <if test="view!=null">
        and view=#{view}
    </if>
</select>
```



```
Map map=new HashMap();
    map.put("title","aa");
    List<Blog> blogList=mapper.queryBlogIF(map);
    for(Blog b:blogList){
        System.out.println(b);
    }
    sqlSession.close();
}
```



```
//查询博客
List<Blog> queryBlogIF(Map map);
```



### 13 choose(when,otherwise)





```
select * from blog
<where>
    <choose>
        <when test="title !=null">
            title =#{title}
        </when>
        <when test="author!=null">
            and author=#{author}
        </when>
        <otherwise>
            and view =#{view}
        </otherwise>
    </choose>
</where>
```





### 14 trim(where ,set)



```
select * from blog
<where>
    <if test="id!=null">
        id=#{id}
    </if>
    <if test="title!=null">
        and title=#{title}
    </if>
    <if test="author!=null">
        and author=#{author}
    </if>
    <if test="create_time!=null">
        and create_time=#{create_time}
    </if>
    <if test="view!=null">
        and view=#{view}
    </if>
</where>
```

```
<where>
    <if test="id!=null">
        id=#{id}
    </if>
    <if test="name!=null">
        and name=#{name}
    </if>
</where>
```





```
<update id="updateBlog" parameterType="map">
    update blog
    <set>
        <if test="title!=null">
            title=#{title},
        </if>
        <if test="author !=null">
            author=#{author}
        </if>
    </set>
    where id= #{id}
</update>
```



所谓动态SQL，本质还是SQL语句，只是我们可以在SQL层面，去执行一个逻辑代码

### sql片段：

1.使用SQL片段抽取公共部分

2.在使用的地方引用即可

注意事项

- 最好基于单表定义SQL片段
- 不要存在where标签

```
<sql id="if-title-author-create_time-view">
    <if test="id!=null">
        id=#{id}
    </if>
    <if test="title!=null">
        and title=#{title}
    </if>
    <if test="author!=null">
        and author=#{author}
    </if>
    <if test="create_time!=null">
        and create_time=#{create_time}
    </if>
    <if test="view!=null">
        and view=#{view}
    </if>
</sql>
```

```
<where>
    <include refid="if-title-author-create_time-view"></include>
</where>
```

# 13 Foreach



![image-20200503125839245](D:\JavaKuang\foreach.png)



```
<select id="queryBlogForeach" parameterType="map" resultType="com.kuang.pojo.Blog">
    select  * from blog
    <where>
        <foreach collection="ids" item="id" open="(" close=")" separator="or">
            id=#{id}
        </foreach>
    </where>
</select>
```





```
  Map map=new HashMap();
        ArrayList<String> ids=new ArrayList<String>();
//        ids.add("1");
//        ids.add("3");
        map.put("ids",ids);
        List<Blog> blogList=mapper.queryBlogForeach(map);
        for(Blog b:blogList){
            System.out.println(b);
        }
```



# 14 缓存（了解）



查询要连接数据库要好资源！

一次查询的结果，暂存在一个可以直接取到的地方

我们再次查询的时候，直接走缓存，就不用走数据库了



1. ## 什么样的数据使用缓存

   - 经常查询并且不经常改变的数据【可以使用缓存】



2. ## 一级缓存

3. 测试步骤：

   - 开启日志
   - 测试一个Session中查询2次记录
   - 查看日志输出

   

4. 缓存失效
   - 如果2次查询一样，name不会刷新缓存
   - 增删改操作，会更改原来的数据，所以缓存会刷新
   - 手动清理缓存  sqlSession.clearCache();

小结：一级缓存默认开启，只在一次sqlSession中有效，也就是在拿到连接到关闭这个连接区间段



### 3 二级缓存(全局缓存)

<cache/> mapper文件中加入默认开启二级缓存

```
<cache eviction="FIFO"
flushInterval="60000"
size="512"
readOnly="true"/>
```

步骤

- 开启全局缓存<setting name="cacheEnabled" value="true"/>  核心配置文件中setting



小结：

- 只要开启了2级缓存，在同一个mapper下就有效
- 所有数据会放在以及缓存中
- 只有当会话提交关闭的时候，才会提交到二级缓存中

4. ### 自定义缓存

```
<dependency>
    <groupId>org.mybatis.caches</groupId>
    <artifactId>mybatis-ehcache</artifactId>
    <version>1.1.0</version>
</dependency>
```

```
<cache eviction="FIFO"
flushInterval="60000"
size="512"
readOnly="true"
type="org.mybatis.caches.ehcache.EhcacheCache"/>
```