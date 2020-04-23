# 1、JavaWeb

java web

### 1、基本概念

web开发

- web，网页开发，我们打开www.baidu.com,可以打开页面
- 静态web
  - html,css
  - 提供给所有人看的数据始终不会发生变化
- 动态web
  - 提供给所有人看的数据始终会发生变化,每个人在不同的时间，不同的地点看到的信息不相同
  - 几乎所有的网站都是动态的
  - 技术栈
    - Servlet、JSP，ASP，PHP

在java中，动态web资源开发的技术被称为javaweb

### 1.2、web应用程序

web应用程序：可以提供浏览器访问的程序；

- a.html,b.html......多个web资源，这些web资源可以被外界访问，对外界提供服务
- 你们能访问的任何一个页面或者资源，都存在于这个世界的某一个角落的计算机上
- URL
- 这个统一的web资源会被放在同一个文件下，web应用程序，Tomcat：服务器
- 一个web应用由多个部分组成（静态web,动态web）
  - html,css,ks
  - jsp,servlet
  - java程序
  - jar包
  - 配置文件（Properties）
- web应用程序编写完毕后，弱项提供给外界访问：需要一个服务器来统一管理

### 1.3、静态web

- *.html这些都是网页的后缀，如果服务器一直存在这些东西，我们就可以直接进行读取

![image-20200422040831573](D:\JavaBasic\Javaweb\javaweb原理.png)

- 静态web的缺点
  - web页面无法动态更新，所有用户看到的都是同一个页面
    - 轮播图，点击特效：伪动态
    - JavaScript
  - 他无法和数据库交互（数据无法持久化，用户无法交互）

### 1.4、动态web

页面会动态展示：web页面的展示效果因人而异；

![image-20200422041606928](D:\JavaBasic\Javaweb\动态资源.png)

缺点

- 加入服务器的动态web资源出现错误，我们需要重新编写我们的后台程序，重新发布
  - 停机维护

优点

- Web页面动态更新，所有用户看到的都不是同一个页面
- 他可以与数据库交互（数据持久化）

# 2、web服务器

2.1、技术

ASP：

- 微软
- 国内最早流行
- 早HTML中嵌入了VB脚本
- 在ASP开发中，基本一个页面，都有几千航业务代码，页面季度混乱

JSP/Servelet：

- sun公司主推的B/S架构
- 基于java语言的（所有大公司，或者一些开源组件，都是用java写的）
- 可以承载三问题带来的影响
- 语法非常想ASP

PHP：

- PHP开发速度快，功能强大，跨平台，代码很简单
- 无法承载大访问量（局限性）

### 2.2、web服务器

服务器是一种被动的操作，用来处理用户的一些请求和给用户一些响应信息

IIS

tomcat：apache,对于初学者来说，最佳选择

**工作3-5年，可以尝试手写tomcat服务器**

下载tomcat

1、安装或者解压

2、了解配置文件和目录结构

3、这个东西的作用

# 3、tomcat

### 3.1、安装tomcat

tomcat官网

.zipwindows

.gz linux

### 3.2、解压和安装

文件夹和作用

![image-20200422043904008](D:\JavaBasic\Javaweb\tomcat.png)

启动tomcat   startup.bat

关闭tomcat shutdown

访问  localhost:8080

可能遇到的问题：

1.java环境变量没有配置

2.闪退问题：需要配置兼容性

3.乱码问题：配置文件中的设置

### 3.3、配置

配置tomcat启动地址为http://www.zxs.com

1.修改serverport   8081

<Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />

2.修改server  host  www.zxs.com   confi  下server。xml

 <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">

3。修改  C:\Windows\System32\drivers\etc   hosts   127.0.0.1 www.zxs.com



可配置的端口号：

- tomcat  8080
- mysql 3306
- http 80
- https 443



### 高难度面试题

请你谈谈网站是如何访问的？

1.输入域名；回车

2.检查本地的C:\Windows\System32\drivers\etc配置文件下有没有这个域名映射；

​	1.有，直接返回对应的IP，这个地址中有我们需要访问的web程序，直接访问

​	2.没有去DNS服务器找，找到就返回，找不到就找不到

4.配置环境变量（可选项）

### 3.4发布一个web网站

这个文件夹下放在文件夹中的html文件D:\apache-tomcat-9.0.34-windows-x64\apache-tomcat-9.0.34\webapps  

- 将自己写的网站，放到服务器（Tomcat）指定的web应用文件夹下webapps就可以访问了

网站应该有个结构

```html
--webapps:tomcat服务器的web目录
	--ROOT
	--kuangStudy:网站目录名
		-web-INF
			-classes:java程序
			-lib web应用所依赖的jar包
			-web.xml  网站配置文件
		-index.html  默认的首页
		-static
			-css
				-style.css
			-js
			-img
			.....
```

# 4、http详解

### 4.1什么是http 

###http(超文本传输协议)是一个简单的请求-响应协议，他通常运行在TCP上

- 文本：html,字符串
- 超文本：图片，音乐，定位，视频，地图
- 80

https安全

- 443

### 4.2、2个时代

- http1.0
  - http/1.0:客户端可以与web服务器连接后，只能获得一个web资源，断开连接
- http2.0
  - http/1.1客户端可以与web服务器连接后，只能获得多个web资源，不断开连接

### 4.3、http请求

- 客户端--发请求--服务器
- 请求url
- 请求方法
- 状态码
- 远程地址

### 1.请求行

- 请求行中的请求方式GET
- 请求方式GET/POST head,delete,put 
  - get 请求携带的参数比较少，大小有限制，请求参数会在浏览器的url地址栏中显示，不安全，但是高效
  - post请求携带的参数比较多，大小没有限制，请求参数不会在浏览器的url地址栏中显示，安全，但是不高效

2.消息头

- Accep:告诉浏览器所支持的数据类型
- Encoding:BGK UTF-8 GB2112
- language   告诉浏览器他的语言环境
- cache-control:缓存控制
- connection 告诉浏览器，请求完成是断开还是保持连接
- host主机

### 4.4、http响应

服务器--响应--客户端

#### 1.响应体

- refrush刷新  告诉客户端，多久刷新一次
- location 让网页重新定位

#### 2.响应状态码

200 请求响应成功

404 找不到资源

3** 请求重定向

- 重定向  重新到新位置去

500 服务器代码错误

502	网关错误

##### 常见面试题：

当浏览器中输入地址，并回车的一瞬间到页面能够展示回来，经历了什么

# 5、Maven

*我为什么要学习这个*？

1、在javaweb开发中，需要使用大量的jar包，我们手动导入

2、如何能够让一个东西帮我自动导入和配置这个jar包

由此maven诞生了



### 5.1Maven项目架构管理工具

Maven核心思想：约定大于配置

- 有约束，不要去违反

Maven会规定好，该如何去编写我们的java代码，必须要按照这个规范来



### 5.2下载Maven

https://maven.apache.org/download.cgi

下载后解压

小狂神友情建议：电脑上的所有环境都放在一个文件夹下

<mirrors> 镜像方便下载，Maven国外的，国内有墙，我们访问外网会非常的慢  翻墙VPN





### 5.3配置环境变量

在我们的系统环境变量中

配置如下配置：

- M2_HOME        maven 目录下的bin目录
- MAVEN_HOME  maven的目录
- 在系统的path中配置MAVEN_HOME	%MAVEN_HOME%\bin

测试maven安装成功   mvn -version

### 5.4配置阿里云镜像

- 镜像mirrors
  - 作用：加速我们的下载
- 国内建议使用阿里云
- <mirror>
            <id>alimaven</id>
            <mirrorOf>central</mirrorOf>
            <name>aliyun maven</name>
            <url>http://maven.aliyun.com/nexus/content/groups/public</url> 
        </mirror>

### 5.5、本地仓库

建立一个本地仓库：   confi /settings.xml文件

settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <!-- localRepository
   | The path to the local repository maven will use to store artifacts.
   |
   | Default: ${user.home}/.m2/repository
  <localRepository>/path/to/local/repo</localRepository>
  -->
	<localRepository>D:\Environment\apache-maven-3.6.3\maven-repo</localRepository>



这是配置的路径

<localRepository>D:\Environment\apache-maven-3.6.3\maven-repo</localRepository>

远程仓库：

### 5.6在IDE中使用maven

1.启动IDE

2.创建maven项目web

3.![image-20200422062630607](D:\JavaBasic\Javaweb\maven.png)

![image-20200422062917838](D:\JavaBasic\Javaweb\maven选项.png)

3.等待初始化



4.观察maven仓库中多了什么

5.IDE中maven设置

注意：IDEA项目创建成功后，看一眼Maven的配置

![image-20200422063808193](D:\JavaBasic\Javaweb\IDEMAVEN设置.png)

6、到这里maven在IDEA中的配置就成功了

### 5.7maven创建一个普通项目

![image-20200422064232003](D:\JavaBasic\Javaweb\MAVEN普通项目.png)

### 5.8、标记文件夹功能



### 5.9在IDEA中配置tomcat

![image-20200422065341421](D:\JavaBasic\Javaweb\tomcatIDEA.png)

![image-20200422065600933](D:\JavaBasic\Javaweb\Tomcat配置.png)

![image-20200422065916739](D:\JavaBasic\Javaweb\解决配置IDEATomcat警告.png)

![image-20200422070625358](D:\JavaBasic\Javaweb\18.png)

5.10POM 文件

POM .xml核心配置文件

maven由于约定大于配置，我们之后可能遇到我们的配置文件，无法被导出或者生效的问题解决方案

```xml

<!--   在build中配置resources，来防止我们资源导出失败的问题 -->
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
```

![image-20200422073036625](D:\JavaBasic\Javaweb\i35.png)

mavenjar关系图

### 5.13解决遇到的问题

1.maven3.6.2 依赖无法导入   改为3.6.1

2.Tomcat闪退     		环境变量问题

3.IDE中每次要重读配置Maven      	

4.maven中Tomcat无法配置

### 7.maven仓库的使用

# 6、servlet

### 6.1Servlet简介

- Servlet就是sun公司开发动态web的一门技术
- sun在这些API中提供了一个接口叫做：Servlet，如果你想开发一个Servlet程序，只需完成2个小步骤
  - 编写一个类，实现Servlet接扣
  - 把开发好的就AVA类部署到web服务器中

把实现了Servlet接口的程序，叫做Servlet

### 6.2Hello Servlet

​	Servlet接口Sun公司有2个默认实现类：HttpServlet,GenericServlet



1.构建一个普通的maven项目，删掉里面的src目录，以后就在这个项目里面建立Moudel；这个空的工程就是Maven的主工程

2.关于Maven父子工程的理解

- 父项目中会有

```
<modules>
    <module>servlet-01</module>
</modules>
```

- 子项目

```
<parent>
    <artifactId>javaweb-02-servlet</artifactId>
    <groupId>com.kuang</groupId>
    <version>1.0-SNAPSHOT</version>
</parent>
```

父项目的jar子项目可以直接使用



3.Maven环境优化

​	1.修改web.xml为最新的

​	2.将maven结构搭建

4.编写一个Servlet

​	1.编写一个普通类

​	2.实现Servlet接口   这里我们直接继承HttpServlet

```
//由于get或者post只是请求的方式不同，可以相互调用，业务逻辑都一样
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter writer=resp.getWriter();//响应流
    writer.println("Hello,Servlet");
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
}
```

5.编写Servle的映射

为什么需要映射，我们写的是JAVA程序，但是要通过浏览器访问，而浏览器需要连接web服务器，所以我们需要在web服务器中注册我们所写的Servlet，还需要给浏览器一个能够访问的地址

6.配置tomcat

7.启动测试

### 6.3servlet原理	

Servlet是由web服务器调用，web服务器在收到浏览器请求之后，会：

![image-20200422161238332](D:\JavaBasic\Javaweb\Servlet2.png)

### 6.4Mapping问题

1.一个Servlet可以指定一个映射路径

```
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

2.一个Servlet可以指定多个映射路径

```
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello1</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello2</url-pattern>
</servlet-mapping>
```

3.一个Servlet可以指定通用映射路径

```
<!--    通配符-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/hello/*</url-pattern>
    </servlet-mapping>
```

4、指定一些后缀或者前缀。。。。

```
<!--    自定义后缀，*前面不能加映射的路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>*.zxs</url-pattern>
    </servlet-mapping>
```

6.优先级问题

指定了固有的映射路径优先级最高，如果找不到，就会指定通配符的请求路径

### 6.5ServletContext

web容器在启动的时候，它会为每个web程序都创建一个ServletContext对象，他代表了当前的web应用

#### 1、共享数据

我在这个Servlet中保存的数据，可以在另一个Servlet中拿到

```
ServletContext i=this.getServletContext();
String username="张雪松";//数据
i.setAttribute("username",username);//讲一个数据保存在ServletContext中
```

```
ServletContext context=this.getServletContext();
String s= (String) context.getAttribute("username");
resp.setContentType("text/html");
resp.setCharacterEncoding("utf-8");
resp.getWriter().println("名字"+s);
```

```
<servlet>
    <servlet-name>getc</servlet-name>
    <servlet-class>com.kuang.servlet.GetServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>getc</servlet-name>
    <url-pattern>/getc</url-pattern>
</servlet-mapping>
```

测试访问结果

2.获取初始化参数

```
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext context=this.getServletContext();
    String url=context.getInitParameter("url");
    resp.getWriter().print(url);
}
```

```
<!--    配置一些web应用初始化参数-->
    <context-param>
        <param-name>url</param-name>
        <param-value>jdbc:mysql://localhost:3306/mybatis</param-value>
    </context-param>
```

```
<servlet>
       <servlet-name>gp</servlet-name>
       <servlet-class>com.kuang.servlet.ServletDemo03</servlet-class>
   </servlet>
    <servlet-mapping>
        <servlet-name>gp</servlet-name>
        <url-pattern>/gp</url-pattern>
    </servlet-mapping>
```

3.请求转发getRequestDispatcher

```
ServletContext context=this.getServletContext();

context.getRequestDispatcher("/gp").forward(req,resp);//转发请求的路径      forward实现请求
resp.setCharacterEncoding("utf-8");
resp.setContentType("text/html");
System.out.println("进入了这个方法");
```

```
<servlet>
    <servlet-name>sd4</servlet-name>
    <servlet-class>com.kuang.servlet.ServletDemo04</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>sd4</servlet-name>
    <url-pattern>/sd4</url-pattern>
</servlet-mapping>
```

4.读取资源文件

Properties

- 在java目录下新建properties
- 在resources目录下新建properties

发现：都打包到同一个路径下classes路径,我们俗称为类路径

如果java目录下的properties文件导出失败，要加上maven的配置resources和java目录下可以导出不同类型的文件

```
<!--   在build中配置resources，来防止我们资源导出失败的问题 -->
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```

需要一个文件流

```
InputStream is=this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
Properties pro=new Properties();
pro.load(is);
String uesr=pro.getProperty("username");
String pwd=pro.getProperty("password");
resp.getWriter().print(uesr+pwd);
```

```
<servlet>
    <servlet-name>properties</servlet-name>
    <servlet-class>com.kuang.servlet.ServletDemo05</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>properties</servlet-name>
    <url-pattern>/pro</url-pattern>
</servlet-mapping>
```

### 6.6HttpServletResponse

web服务器接收到客户端的http请求，针对这个请求，分别创建一个代表请求的HttpServletRequest对象，代表响应的一个HttpServletResponse

- 获取客户端参数HttpServletRequest
- 给用户信息HttpServletResponse

1、简单分类

负责向浏览器发送数据的方法

- ```
  ServletOutputStream getOutputStream() throws IOException;
  
  PrintWriter getWriter() throws IOException;
  ```

 负责向浏览器发送响应头的方法

```
void setCharacterEncoding(String var1);

void setContentLength(int var1);

void setContentLengthLong(long var1);

void setContentType(String var1);
void setDateHeader(String var1, long var2);

    void addDateHeader(String var1, long var2);

    void setHeader(String var1, String var2);

    void addHeader(String var1, String var2);

    void setIntHeader(String var1, int var2);

    void addIntHeader(String var1, int var2);
```



