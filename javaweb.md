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

![image-20200422041606928](D:\JavaKuang\动态资源.png)

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

![image-20200422043904008](D:\JavaKuang\tomcat.png)

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

- ```
  "Cache-Control  缓存控制
  ```

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

3.![image-20200422062630607](D:\JavaKuang\maven.png)

![image-20200422062917838](D:\JavaKuang\maven选项.png)

3.等待初始化



4.观察maven仓库中多了什么

5.IDE中maven设置

注意：IDEA项目创建成功后，看一眼Maven的配置

![image-20200422063808193](D:\JavaKuang\IDEMAVEN设置.png)

6、到这里maven在IDEA中的配置就成功了

### 5.7maven创建一个普通项目

![image-20200422064232003](D:\JavaKuang\MAVEN普通项目.png)

### 5.8、标记文件夹功能



### 5.9在IDEA中配置tomcat

![image-20200422065341421](D:\JavaKuang\tomcatIDEA.png)

![image-20200422065600933](D:\JavaKuang\Tomcat配置.png)

![image-20200422065916739](D:\JavaKuang\解决配置IDEATomcat警告.png)

![image-20200422070625358](D:\JavaKuang\18.png)

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

![image-20200422073036625](D:\JavaKuang\i35.png)

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

![image-20200422161238332](D:\JavaKuang\Javaweb\Servlet2.png)

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

#### 1、简单分类

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



#### 2.常见应用

1.向浏览器输出信息

2.下载文件

- 要下载文件的路径
- 下载的文件名是啥
- 设置想办法让浏览器支持下载我们需要的东西
- 获取下载文件的输入流
- 创建缓冲区
- 获取OutputStream对象
- 将FileOutputStream写入到buffer缓冲区
- 使用OutputStream将缓冲区的数据输出到客户端

```
//-要下载文件的路径
String realPath="D:\\JavaKuang\\javaweb-02-servlet\\response\\target\\response-1.0-SNAPSHOT\\WEB-INF\\classes\\张雪松.png";
System.out.println(realPath);
//下载的文件名是啥
String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);
//设置想办法让浏览器支持下载我们需要的东西                             解决中文问题
resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));
//获取下载文件的输入流
FileInputStream in=new FileInputStream(realPath);
//创建缓冲区
int len=0;
byte[] buffer=new byte[1024];
//获取OutputStream对象
ServletOutputStream out=resp.getOutputStream();
//将FileOutputStream写入到buffer缓冲区,使用OutputStream将缓冲区的数据输出到客户端
while ((len=in.read(buffer))>0){
    out.write(buffer,0,len);
}
in.close();
out.close();
```

#### 3.验证码功能

验证码怎么实现的？

- 前端实现
- 后端实现，需要java的图片类

#### 4.实现重定向

![image-20200423214306015](D:\JavaKuang\Javaweb\重定向.png)

一个web资源收到客户端请求后，他会通知客户端去访问另一个web资源

，这个过程叫重定向

常见场景：

- 用户登录

- ```
  //        resp.setHeader("Location","/img");
  //        resp.setStatus(HttpServletResponse.SC_FOUND);
          resp.sendRedirect("/response_war/img");//重定向
  ```

#### 面试题：请你聊聊重定向和转发的区别？

#### 相同点：

- 页面跳转

#### 不同点：

- 请求转发的时候url不会变化	307
- 重定向地址栏会变化	  302	

### 6.7、HttpServletRequst

HttpServletRequst代表客户端的请求，用户通过http访问服务器，Http请求中的所有信息会被封装到HttpServletRequst，通过HttpServletRequst的方法获得客户端的所有信息

#### 1.获取前端传递参数

![image-20200423221357461](D:\JavaKuang\Javaweb\request.png)

#### 2.请求转发

```
req.setCharacterEncoding("utf-8");
resp.setContentType("text/html");
resp.setCharacterEncoding("utf-8");
String username=req.getParameter("username");
String password=req.getParameter("password");
String[] hobbys=req.getParameterValues("hobbys");
System.out.println("==================");
//请求中文乱码问题  在请求出设置字符编码格式
System.out.println(Arrays.toString(hobbys)+username+password);
System.out.println("==================");
//通过请求转发
//   这里的/代表当前web应用
req.getRequestDispatcher("/success.jsp").forward(req,resp);
```

# 7.cookie session

## 1.会话

**会话**：用户打开浏览器，点击链接，访问web资源，关闭浏览器

**有状态会话**：一个同学来过教室，下次再来教室，我们会知道这个同学，曾经来过，我们称为有状态会话

你    西开

- 发票    西开给你发票
- 学校登记      西开标记你来过

**一个网站，怎么证明你来过？**

客户端     服务端

1.服务端给客户端一个新建，客户端下次访问服务端带上信件就可以了；  cookie

2.服务器登记你来过，下次你来了，下次你来的时候我来匹配你；

## 2.保存会话的2种技术

**cookie**

- 客户端技术（响应，请求）

**session**

- 服务器技术，利用这个技术，可以保存用户的会话信息。可以把信息或者session放在session中

常见场景：网站登录下次不用在登录，第二次访问直接上去了

## 3cookie

![image-20200425184222478](D:\JavaKuang\Javaweb\cookie.png)

1.从请求中拿到cookie信息

2.服务器响应给客户端cookie

获得cookie

```
Cookie[] cookies=req.getCookies();//返回数组，cookie存在多个
```

获取cookie的key

```
cookie.getName().equals("lastLoginTime")
```

获取cookie的值

```
long lastLoginTime=Long.parseLong(cookie.getValue());
```

新建cookie

```
Cookie cookie=new Cookie("lastLoginTime",System.currentTimeMillis()+"");
```

设置 cookie有效期

```
cookie.setMaxAge(24*60*60);
```

响应cookie

```
resp.addCookie(cookie);
```

cookie：一般会保存在用户本地目录下



**一个网站cookie是否存在上限！**

- 一个cookie只能保存一个信息
- 一个web站点可以给浏览器多个cookie，最多存放20个
- 300个cookie浏览器上限
- cookie大小限制4KB 



删除cookie：

- 不设置有效期，关闭浏览器，自动失效
- 设置有效期时间为0

## 4Session（重点）

![image-20200425184424929](D:\JavaKuang\Javaweb\session.png)

什么是session：

- 服务器会给每一个浏览器创建一个session（每个浏览器的session不同）
- 一个Session独占一个浏览器，只要浏览器不关闭，session就存在
- 用户登录之后，整个网站都可以访问   保存用户的信息（Session）

**session和cookie的区别**

- cookie是把用户的数据写给用户的浏览器保存
- Session用户的数据写到用户独占的session中，服务器端保存（保存重要信息，减少服务器资源浪费）
- Session服务器对象由服务器创建





session使用场景：

- 保存一个登陆用户信息
- 购物车信息
- 在整个网站中，经常会使用的数据，保存在Session中



使用Session：

```
   //解决乱码问题
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;Charset=utf-8");
        //得到session
        HttpSession session=req.getSession();
        //给session中存东西
//        session.setAttribute("name","张雪松");
        session.setAttribute("name",new Person("张雪松",1));
        //获取sessionID
        String sessionId=session.getId();
        //判断session是不是新创建的
       if(session.isNew()){
           resp.getWriter().write("session创建成功，ID为:"+sessionId);
       }else {
           resp.getWriter().write("session已存在，ID为:"+sessionId);
       }
       //session创建的时候作了什么事情
//        Cookie cookie=new Cookie("JSESSIONID",sessionId);
//       resp.addCookie(cookie);
```



```
//得到session
HttpSession session=req.getSession();
Person person= (Person) session.getAttribute("name");
System.out.println(person.toString());
```



```
HttpSession session=req.getSession();
session.removeAttribute("name");
//手动注销session
session.invalidate();
```

会话自动过期

```
<!--设置session的失效时间-->
    <session-config>
<!--1分钟后session自动失效，分钟单位-->
        <session-timeout>1</session-timeout>
    </session-config>
```





![image-20200425184605222](D:\JavaKuang\Javaweb\后面进阶.png)

# 8JSP

## 1.什么是jsp

java Server oages:java服务器端页面，也和Servlet一样用于动态web技术

最大特点

- 写jsp 就像在Html
- 区别：
  - HTML只给用户提供静态数据
  - JSP页面可以嵌入JAVA代码，为用户提供动态数据

## 2.JSP原理

思路：JSP怎么执行的

- 代码层面没有任何问题

- 服务器内部

  tomcat中有一个work目录

  IDEA中使用Tomcat会在IDEA中产生一个Work目录

  ![image-20200425185820280](D:\JavaKuang\Javaweb\IDEA0.png)

我电脑的地址

C:\Users\89546\.IntelliJIdea2019.3\system\tomcat\Unnamed_javaweb-session-cookie\work\Catalina\localhost\javaweb_session_cookie_war\org\apache\jsp

发现页面变成了java程序

![image-20200425185959568](D:\JavaKuang\Javaweb\java程序.png)

浏览器向服务器发送请求，不管访问什么资源，其实都是在访问servlet

JSP最终也会被转换为Java类

**JSP本质上就是一个Servlet**

```
//初始化
public void _jspInit() {
}
//销毁
public void _jspDestroy() {
}
//JSPServer
public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
```

1.判断请求

2.内置一些对象

```
final javax.servlet.jsp.PageContext pageContext; //页面上下文
javax.servlet.http.HttpSession session = null; //session
final javax.servlet.ServletContext application;//applicationContext
final javax.servlet.ServletConfig config;//config
javax.servlet.jsp.JspWriter out = null;//out
final java.lang.Object page = this;//page
HttpServletRequest			//请求
HttpServletResponse 		//响应
```

3.输出页面前增加的代码

```
response.setContentType("text/html");			//设置响应页面类型
pageContext = _jspxFactory.getPageContext(this, request, response,
         null, true, 8192, true);				
_jspx_page_context = pageContext;
application = pageContext.getServletContext();
config = pageContext.getServletConfig();
session = pageContext.getSession();
out = pageContext.getOut();
_jspx_out = out;
```



4.以上这些个对象我们可以在JSP页面中使用（JSp流程）

![image-20200425192424344](D:\JavaKuang\Javaweb\JSP流程.png)

在JSP页面中：

只要是java代码就会原封不动的输出

如果是HTML代码，就会被转换为

out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("hello\r\n");
      out.write("\r\n");

    String name="zxs";
    
      out.write("\r\n");
      out.write("name");
      out.print(name);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
这样的格式输出到前端

## 3。JSP基础语法

任何语言都有自己的语法JSP作为java技术的一种应用，它拥有一些自己扩充的语法java语法都支持

JSP表达式

```
<%-- JSP表达式
 作用：用来将程序的输出，输出到客户端
 <%= %>
 --%>
  <%= new Date()
```

**JSP脚本片段**

```
<%
    int sum = 0;
    for (int i = 0; i <= 100; i++) {
    sum+=i;
    }
    out.println("<h1>Sum="+sum+"</h1>");

%>
```

**JSP脚本片段的在实现**

```
<%
    int x = 10;
    out.println(x);
%>
<p>这是一个脚本片段</p>
<%
    int y = 20;
    out.println(y);
%>

<%--在代码中嵌入HTML元素--%>
<%
    for (int i = 0; i < 5; i++) {
%>
<h1>Hello Zxs <%=i%></h1>
<%
    }
%>
```

**JSP声明**

```
<%!
  static {
      System.out.println("Loading Servlet!");
  }
    private int globaVar=0;
  public void kuang(){
      System.out.println("进入了方法");
  }
%>
```

JSP声明：会被编译到JSP生成的JAVA类中，其他的，就会被生成到_jspService方法中~

在JSP，嵌入Java代码即可

```java
<%%>
    <%=%>
    <%!%>
    
```

JSP 的注释，不会在客户端显示HTML就会

## 4.JSP的指令

```
<%@ page isErrorPage="true" %>
```



```
<error-page>
    <error-code>404</error-code>
    <location>/error/404.jsp</location>
</error-page>
<error-page>
    <error-code>500</error-code>
    <location>/error/500.jsp</location>
</error-page>
```

**提取公共页面**

```
<%@ include file=""%>
```



```
<%--@include会将2个页面合二为一--%>
<%@include file="common/header.jsp" %>
<h1>网页主体</h1>
<%@include file="common/footer.jsp" %>
<hr>
<%--        jsp标签--%>
<jsp:include page="common/header.jsp">
```

## 5 9大内置对象

- PageContext   存东西

- Request   存东西

- Response

- Session   存东西

- Application   【ServletConfig】   存东西

- config 【ServletConfig】

- out

- page

- exception

  

```
pageContext.setAttribute("name1","zxs1");//保存的数据只在一个页面有效
request.setAttribute("name2","zxs2");//保存的数据只在一次请求中有效，请求转发会携带这个数据
session.setAttribute("name3","zxs3");//保存的数据只在一次会话中有效
application.setAttribute("name4","zxs4");//保存的数据只在服务器中有效，从打开服务器到关闭服务器
```



request:客户端向服务器发送气你跪求，产生的数据，用户看完就没用了，比如新闻用户看完了就没用了

session：客户端发送请求，产生的数据，用户用完一会还用，比如购物车

application：客户端发送请求，产生的数据，一个用户用完了，其他用户还可能用，比如聊天QQ

## 6.JSP标签，JST标签，EL表达式

```
<!--            JSTL表达式-->
            <dependency>
                <groupId>javax.servlet.jsp.jstl</groupId>
                <artifactId>jstl-api</artifactId>
                <version>1.2</version>
            </dependency>
<!--        标签库    -->
            <dependency>
                <groupId>taglibs</groupId>
                <artifactId>standard</artifactId>
                <version>1.1.2</version>
            </dependency>
```

EL表达式：${}

- 获取数据
- 执行运算
- 获取web开发常用对象

JSP 标签

```
<jsp:forward page="/jsp2.jsp">
    <jsp:param name="name" value="zxs"></jsp:param>
    <jsp:param name="age" value="28"></jsp:param>
</jsp:forward>


<%--取出参数--%>
名字：<%=request.getParameter("name")%>
年龄：<%=request.getParameter("age")%>
```

**JSTL表达式**

JSTL标签库的使用就是弥补HTML标签的不足；他的自定义许多标签，可以供我们使用标签的功能和Java代码功能一样

**核心标签**（掌握部分）



```
<%--引入JSTL核心标签库我们才能使用--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

**JSTL核心标签库使用步骤**

- 引入对应的taglib
- 在TOmcat中引入jstl包，包复制到tomcat  lib目录下，否则会报错

```
<h4>if测试</h4>
<form action="coreif.jsp" method="get">
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="登录">
</form>



    <c:if test="${param.username=='admin'}" var="isAdmin">
        <c:out value="管理员欢迎你"/>
    </c:if>

    <c:out value="${isAdmin}"/>
```

```
<c:set var="score" value="85"/>
<c:choose>
    <c:when test="${score>=90}">
        优秀1
    </c:when>
    <c:when test="${score>=85}">
        优秀2
    </c:when>
    <c:when test="${score>=60}">
        优秀24
    </c:when>
    <c:when test="${score==90}">
        优秀3
    </c:when>
</c:choose>
```

```
<%

    ArrayList<String> people=new ArrayList<String>();
    people.add(0,"zxs");
    people.add(1,"lisi");
    request.setAttribute("list",people);
%>

<c:forEach var="people" items="${list}">
    <c:out value="${people}"/>
</c:forEach>
```

# 9 javabean

实体类

Javabean有特定的写法

- 必须有一个无参构造
- 属性私有化
- 必须有对应的get/set
- 一般用来做数据库驱动ORM
- ORM：对象关系映射
  - 表  --类
  - 字段--属性
  - 行记录是对象

| id   | name | age  | address |
| ---- | ---- | ---- | ------- |
| 1    | zxs1 | 22   | 杭州    |
| 2    | zxs2 | 23   | 杭州    |
| 3    | zxs3 | 24   | 杭州    |

```java
class People{
    private int id;      //字段对应属性
    private String name;
    private String age;
    private String address;  
}


<jsp:useBean id="People" class="com.kuang.pojo.People" scope="page"/>
<jsp:setProperty name="People" property="address" value="杭州"/>
<jsp:setProperty name="People" property="name" value="张雪松"/>
<jsp:setProperty name="People" property="id" value="1"/>
<jsp:setProperty name="People" property="age" value="28"/>
姓名：<jsp:getProperty name="People" property="name"/>
年龄：<jsp:getProperty name="People" property="age"/>
地址：<jsp:getProperty name="People" property="address"/>
ID：<jsp:getProperty name="People" property="id"/>
```

# 10 MVC三层架构

什么是MVC   model，view,Controler  模型，视图，控制器

老架构

![image-20200427213408276](D:\JavaKuang\Javaweb\早些年架构.png)



用户直接访问控制层，控制层就可以直接操作数据库

CRUD数据库增删改查

```java
servlet--CRUD-->数据库
    弊端：程序十分臃肿，不利于维护  servlet的代码中：处理响应，请求，视图，处理业务代码，处理逻辑代码
架构：没有什么是不能加一层处理的 
```



MVC

![image-20200427214520202](D:\JavaKuang\Javaweb\MVC2.png)

model

- 业务处理：业务逻辑（Service）
- 数据持久层CRUD（DAO）

view

- 展示数据
- 提供链接发起Servlet请求（a ,form img）

Controller

- 接收用户请求：（req:请求参数Session信息）
- 交给业务层处理代码
- 控制视图跳转

```java
登录--》接受用户登录请求--》处理用户的请求（获取用户登录参数）--》交给业务层处理登录业务（判断用户名密码是否正确：事物）--》DAO层查询用户名密码是否正确
```

# 11、Filter（重点）

Filter：过滤器，用来过滤网站的数据；

- 处理中文乱码
- 处理登录验证

![image-20200427215605239](D:\JavaKuang\Javaweb\过滤器.png)

Filter开发步骤

- 导包

实现接口

```
//初始化
public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("CharacterEncoding");
}
//chain  ：链
/*
* 1.过滤器中的所有代码，在过滤特定请求的时候都会执行
* 2.必须让过滤器继续同型
* */
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    servletRequest.setCharacterEncoding("utf-8");
    servletResponse.setCharacterEncoding("utf-8");
    servletResponse.setContentType("text/html;charset=UTF-8");
    System.out.println("CharacterEncodingFilter执行前。。。");
    filterChain.doFilter(servletRequest,servletResponse);//让我们的请求继续走，如果不写，程序到这里就会拦截
    System.out.println("CharacterEncodingFilter执行后。。。");
}

//销毁 web服务器关闭的时候，过滤器会销毁
public void destroy() {
    System.gc();
    System.out.println("CharacterEncodingFilter销毁");
}
```



配置xml

```
<servlet>
        <servlet-name>servlet</servlet-name>
        <servlet-class>com.kuang.servlet.ShowServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>servlet</servlet-name>
        <url-pattern>/servlet/show</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>servlet</servlet-name>
<!--        这个就不会被过滤-->
        <url-pattern>/show</url-pattern>
    </servlet-mapping>
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>com.kuang.filter.CharacterEncodingFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
<!--        只要是/servlet下的任何请求都会经过这个过滤器-->
        <url-pattern>/servlet/*</url-pattern>
    </filter-mapping>
```

# 12 监听器

实现一个监听器接口；（有N种）

实现监听器接口

```
//在线人数监听：统计session
public class OnlineCountListener implements HttpSessionListener {
    //创建session监听，看你的一举一动
    //一旦创建一个session就会触发一个事件
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx=se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        Integer onlineCount= (Integer) ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(1);
        }else {
            int count =onlineCount.intValue();
            onlineCount=new Integer(count+1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }
    //销毁session监听
    //一旦销毁session就会触发一次这个事件
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx=se.getSession().getServletContext();
        Integer onlineCount= (Integer) ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(1);
        }else {
            int count =onlineCount.intValue();
            onlineCount=new Integer(count-1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }
    /*
    * session销毁
    * 1.手动销毁
    * 2.自动销毁
    * */
```

注册监听器

```
<!--    session过期时间配置  1分钟过期-->
    <session-config>
        <session-timeout>1</session-timeout>
    </session-config>
```

设置监听器过期时间

```
<h1>当前有<span style="color: red"><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span>人在线</h1>
```

# 13.过滤器和监听器的常见应用

监听器GUI编程经常使用

```
//窗口
Frame frame=new Frame("中秋节快乐");
//面板
Panel panel=new Panel(null);
frame.setLayout(null);//设置窗体的布局
frame.setBounds(300,500,500,500);
frame.setBackground(new Color(0,0,255));
panel.setBounds(50,50,300,300);
panel.setBackground(new Color(0,255,255));
frame.add(panel);
frame.setVisible(true);
//监听事件，关闭事件
frame.addWindowListener(new WindowListener() {
    public void windowOpened(WindowEvent e) {
        System.out.println("打开ing");
    }

    public void windowClosing(WindowEvent e) {
        System.out.println("关闭ing");
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
        System.out.println("关闭ed");
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("打开");
    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {

    }
});
```





用户登录后才能进入主页~用户注销就不能进入主页







# 14JDBC

什么 JDBC：java database connection

需要jar包的支持实验环境搭建

```sql
CREATE TABLE users(
  `id` int PRIMARY KEY not NULL,
	`name` VARCHAR(20),
	`password` VARCHAR(20),
	`email` VARCHAR(20),
	`birthday` date


);
INSERT into users VALUES (1,"zxs","123456","895462507","1993-6-6")
```



INSERT into users VALUES (1,"zxs","123456","895462507","1993-6-6")



导入依赖

```
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.47</version>
</dependency>
```

JDBC固定步骤

```
String url="jdbc:mysql://localhost:3306/jdbc?userUnicode=true&characterEncoding=utf-8";

String username="root";
String password="123";
//1.加载驱动
Class.forName("com.mysql.jdbc.Driver");
//2.获取数据库连接
Connection connection=DriverManager.getConnection(url,username,password);
//3.向数据库发送SQL的对象
Statement statement=connection.createStatement();
//4.编写SQL
String sql="select * from users";
//5.执行SQL
ResultSet resultSet=statement.executeQuery(sql);
while (resultSet.next()){
    System.out.println(resultSet.getObject("id"));
    System.out.println(resultSet.getObject("name"));
    System.out.println(resultSet.getObject("password"));
    System.out.println(resultSet.getObject("email"));
    System.out.println(resultSet.getObject("birthday"));
}
//6.关闭连接释放资源(先开的后关)
resultSet.close();
statement.close();
connection.setAutoCommit(true);
```

**预编译SQL**

```
 String url="jdbc:mysql://localhost:3306/jdbc?userUnicode=true&characterEncoding=utf-8";
 String username="root";
 String password="123";
 //1.加载驱动
 Class.forName("com.mysql.jdbc.Driver");
 //2.获取数据库连接
 Connection connection= DriverManager.getConnection(url,username,password);
 //3.编写SQL
 String sql="insert into users (id, name, password, email, birthday) values (?,?,?,?,?);";
 //4.预编译
 PreparedStatement preparedStatement=connection.prepareStatement(sql);
 preparedStatement.setInt(1,9);
 preparedStatement.setString(2,"张雪松");
 preparedStatement.setString(3,"123456");
 preparedStatement.setString(4,"99999qq.com");
 preparedStatement.setDate(5,new Date(new java.util.Date().getTime()));


 //5.执行SQL
int i=preparedStatement.executeUpdate();
 if(i>0){
     System.out.println("插入成功");
 }
 //6.关闭连接释放资源(先开的后关)
preparedStatement.close();
 connection.close();
```

## 事物

要么都成功，要么都失败

ACID原则，保证数据安全

```sql
开启事物

事务提交

事物回滚

事物关闭
A:1000
B:1000

转账
A(900)  -- 100》 B(1100)


```

## junit单元测试

简单使用

@Test只在方法上有效，只要加了这个注解的方法，就可以直接运行

**搭建环境测试事物**