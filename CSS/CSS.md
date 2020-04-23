# 1、什么是CSS

如何学习

​	1.CSS是什么

​	2.CSS怎么用

​	3.**CSS选择器（重点+难点）**

​	4.美化网页（文字，阴影，超链接，列表，渐变。。。）

​	5.盒子模型

​	6.浮动

​	7.定位

​	8.网页动画

### 1.1、什么是CSS

Cascading Style Sheet层叠样式表

CSS：表现（美化网页）

字体，颜色，边距，高度，宽度，背景图片，网页定位，网页浮动。。。。

### 1.2、发展史

CSS1.0

CSS2.0	DIV（块）+CSS，HTML与CSS分离的思想，网页变得简单，SEO

CSS2.1	浮动和定位

CSS3.0	圆角，边框，阴影，动画。。   浏览器兼容性~



练习格式:![1587129112173](C:\Users\89546\AppData\Roaming\Typora\typora-user-images\1587129112173.png)

### 1.3、快速入门

style

**基本入门：**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
            <!--规范, <style> 可以编写css的代码，每一个声明，以分号结尾
            语法：
                    选择器{
                声明1;
                声明2;
            }
            -->
        h1{
            color:red;
        }
    </style>
</head>
<body>
<h1>我是标题</h1>
</body>
</html>
```

建议使用这种规范：

![1587129707512](C:\Users\89546\AppData\Roaming\Typora\typora-user-images\1587129707512.png)

指向了html



css优势：

​	1.内容和表现分离

​	2.网页结构表现统一，可以实现复用

​	3.样式十分丰富

​	4.建议使用独立于HTML的CSS文件

​	5.利用SEO，容易被搜索引擎收入

​	

### 1.4、CSS的3中导入方式

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--    外部样式-->
    <link rel="stylesheet" href="css/style.css">
	<!--内部样式-->
    <style>
            h1{
                color: green;
            }
    </style>

</head>
<body>
<!--优先级：就近原则-->
<!--优先级：行内样式》内部样式》外部样式-->
<!--行内样式，在标签元素中，编写style-->
<h1 style="color: red">标题</h1>
</body>
</html>
```

扩展：外部样式的2中写法

- 链接式   

  html标签

  ```
  <!--    外部样式-->    <link rel="stylesheet" href="css/style.css">
  ```

- 导入式

  css2.1

  ```
  <style>    @import url(css/style.css);</style>
  ```

  不常用

# 2、选择器

> 作用：选择页面上的某一个或者某一类



### 2.1、基本选择器

1、标签选择器

2、类选择器 class

3、id选择器    /*id选择器  id必须保证全局唯一！！    #id名{}*/

### 2.2、层次选择器

 	1、后代选择器		在某个元素的后面		爷爷 爸爸 儿子

```
/*
        后代选择器
        */
        body p{
            background: red;
        }

```

​	2、子选择器   一代 

```css
/*子选择器*/
        body>p{
            background: yellow;
        }
```

​	3、相邻兄弟选择器  同辈

```css
/*兄弟选择器,只有一个，相邻，向下*/
        .active+p{
            background: #82ff32;
         }
```

​	4、通用选择器

```css

        /*!*通用选择器*!*/
        .active~p{
            background: brown;
        }
```



### 2.3、结构伪类选择器

伪类：条件





```css
/*ul的第一个子元素*/
        ul li:first-child{
            background: #82ff32;
        }
        /*ul的最后一个选择器*/
        ul li:last-child{
            background: red;
        }
        /**/
```

```css
/*选择父元素下，第二个类型为p的元素*/
        p:nth-of-type(2){
            background: green;
        }
```

```css
/*选中p1 定位到父元素，选择当前第一个元素
            选择当前元素p父级元素，选中父级元素第一次，并且是当前元素才生效
        */
        p:nth-child(1){
            background: #82ff32;
        }
```

### 2.4、属性选择器（常用）

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .demo a{
            float: left;
            display: block;
            height: 50px;
            width: 50px;
            border-radius: 10px;
            background: blue;
            text-align: center;
            color: gainsboro;
            text-decoration: none;
            margin-right: 5px;
            font:bold 20px/50px Arial;
        }
        /*存在id的元素
            a[]{}
        */
        /*a[id]{*/
        /*    background: yellow;*/
        /*}*/
        /*
            属性名, 属性名=属性值（正则）
            =绝对等于
            *=包含这个元素
            ^=以这个开头
            $=以这个结尾
        */
        a[id=first]{
            background: #82ff32;
        }
        a[class*="links"]{
            background: fuchsia;
        }
        /*选中以href中以http开头的元素*/
        a[href^=http]{
            background: red;
        }
        a[href$=pdf]{
            background: black;
        }
    </style>
</head>
<body>
<p class="demo">
    <a href="http://www.baidu.com" class="links item first" id="first">1</a>
    <a href="" class="links item active" target="_blank" title="test">2</a>
    <a href="images/123.html" class="links item active">3</a>
    <a href="images/345.html" class="links item">4</a>
    <a href="images/66.jpg">5</a>
    <a href="abc">6</a>
    <a href="/a.pdf">7</a>
    <a href="/abc.pdf">8</a>
    <a href="abc.doc">9</a>
    <a href="abcd.doc" class="links item last">10</a>
</p>
</body>
</html>
```

```css
=绝对等于
*=包含等于
^=第一个
$=最后一个
```



# 3、美化网页元素

### 3.1、为什么美化网页

1、有效传递网页信息

2、美化网页

3、凸显页面主题

4、提高用户体验

span标签：重点突出的字，使用这个标签套起来

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        #title1{
            font-size: 50px;
        }
    </style>
</head>
<body>
java
<br>
欢迎使用<span id="title1">java</span>
</body>
</html>
```

### 3.2、字体样式

```css
<!--  font-family：字体
        font-size：大小
        font-weight:字体粗细
        color:字体颜色
  -->
    <style>
        body{
            font-family:楷体;
        }
        h1{
            font-size: 50px;
            font-weight: lighter;
        }
        .p1{
            font-weight: bold;
            color: #82ff32;
            font-size: 60px;
        }
    </style>
```

### 3.3、文本样式

1、颜色   color    rgb

2、文本对齐方式		text-aligin=center

3、首行缩进		text-indent: 2em

4、行高		line-height

5、装饰		text-decoration: underline

6、文本图片水平对齐：vertical-align: middle;

```css
<style>
        /*水平对齐   参照物  a,b*/
        img,span{
                vertical-align: middle;
        }
    </style>
```





```css
<!--
        颜色：
            单词
            RGB 0~F
            RGBA A:0~1
            text-align  排版居中
            text-indent: 2em段落首行缩进2个字母
            line-height: 50px;  行高
-->
    <style>
        h1{
            color: rgba(0,255,255,0.9);
            text-align: center;
        }
        .p1{
            background: #82ff32;
            text-indent: 2em;
            line-height: 50px;
            height: 400px;
        }
        .l1{
            text-decoration: underline;
        }
        .l2{
            text-decoration: overline;
        }
        /*a标签去下划线*/
        a{
            text-decoration: none;
        }

    </style>
```

### 3.4、阴影

```css
/*text-shadow 阴影颜色  水平偏移  垂直便宜  阴影半径*/
        #price{
            text-shadow: black 10px 10px 0px;
            color: black;
        }
```

### 3.5、超链接伪类

```css
 /*鼠标悬浮的颜色*/
        a:hover{
            color: fuchsia;
        }
        /*鼠标按住未释放的状态*/
        a:active{
            color: red;
            font-size: 100px;
        }
        /*点完之后的颜色*/
        a:visited{
            color: orange;
        }
```

### 3.6、列表

```html
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<div id="nav">
    <h2 class="title">全部商品列表</h2>
    <ul>
        <li><a href="#">图书</a>&nbsp;&nbsp;<a href="#">音像</a>&nbsp;&nbsp;<a href="#">数字商品</a></li>
        <li><a href="#">家用电器</a>&nbsp;&nbsp;<a href="#">手机</a>&nbsp;&nbsp;<a href="#">数码</a></li>
        <li><a href="#">电脑</a>&nbsp;&nbsp;<a href="#">办公</a>
        <li><a href="#">家居</a>&nbsp;&nbsp;<a href="#">家装</a>&nbsp;&nbsp;<a href="#">厨具</a></li>
        <li><a href="#">服饰鞋帽</a>&nbsp;&nbsp;<a href="#">个护化妆</a>
        <li><a href="#">礼品箱包</a>&nbsp;&nbsp;<a href="#">钟表</a>&nbsp;&nbsp;<a href="#">珠宝</a></li>
        <li><a href="#">食品饮料</a>&nbsp;&nbsp;<a href="#">保健食品</a>
        <li><a href="#">彩票</a>&nbsp;&nbsp;<a href="#">旅行</a>&nbsp;&nbsp;<a href="#">充值</a>&nbsp;&nbsp;<a href="#">票务</a></li>
    </ul>
</div>
```

```css
a{
    text-decoration: none;
}
.title{
    font-size: 18px;
    font-weight: bold;
    text-indent: 4em;
    line-height: 30px;
    background: red;
}
/*ul li
list-style
        none 无圆
        circle 空心圆
        decimal 数字
        square 正方形

*/
/*ul{*/
/*    background: rgba(14, 4, 10, 0.66);*/
/*}*/
ul li{
    height: 30px;
    list-style: none;
    text-indent: 1em;
}
a{
    text-decoration: none;
    font-size: 14px;
    color: #000;
}
a:hover{
    color: orange;
    text-decoration: underline;
}
#nav{
    width: 300px;
    height: 300px;
    background: #a0a0a0;
}
```

### 3.7、背景

背景图片

```css
a{
    text-decoration: none;
}
.title{
    font-size: 18px;
    font-weight: bold;
    text-indent: 4em;
    line-height: 100px;
    /*颜色  图片   图片位置  平铺方式*/
    background: red url("../images/1.png") 217px 5px no-repeat;
}
/*ul li
list-style
        none 无圆
        circle 空心圆
        decimal 数字
        square 正方形

*/
/*ul{*/
/*    background: rgba(14, 4, 10, 0.66);*/
/*}*/
ul li{
    height: 30px;
    list-style: none;
    text-indent: 1em;
    background-image: url("../images/2.png");
    background-repeat: no-repeat;
    background-position: 186px -18px;
}
a{
    text-decoration: none;
    font-size: 14px;
    color: #000;
}
a:hover{
    color: orange;
    text-decoration: underline;
}
#nav{
    width: 300px;
    height: 354px;
    background: #a0a0a0;
}
```

### 3.8、渐变（没什么用）

https://www.grabient.com/

```css
<style>
        body{
            background-image: linear-gradient(19deg,#21D4FD 0%,#B721FF 100%);
        }
</style>
```



# 4、盒子模型

### 4.1什么是盒子模型

![](D:\JavaBasic\CSS\image-20200418115652179.png)



margin:外边距

padding：内边距

border:边框



### 4.2、边框

1、边框 的粗细

2、边框的样式

3、边框的颜色

```css
<style>
        /*这些元素总有一个外边框margin:0;  常见操作*/
        h1,ul,a,body{
            margin: 0;
            padding: 0;
            text-decoration: none;
        }
        /*border：粗细，样式，颜色*/
        #box{
            width: 300px;
            border: 1px solid red;
        }
        form{
            background: green;
        }
        div:nth-of-type(1)>input{
            border: 3px solid black;
        }
        div:nth-of-type(2)>input{
            border: 3px solid powderblue;
        }
        div:nth-of-type(3)>input{
            border: 3px dashed yellow;
        }
        h2{
            font-size: 16px;
            background-color: #3cbda6;
            line-height: 30px;
            color: white;
        }
    </style>
```



### 4.3、内外边距

1、盒子的计算的方式：你这个元素到底多大？

​	margin+border+padding+内容宽度

```css
<style>
        /*border：粗细，样式，颜色*/
        #box{
            width: 300px;
            border: 1px solid red;
            padding: 0 0 0 0;
            margin: 0 auto;
        }
        /*
            margin 0
            margin 0 1px
            margin 0 auto
        */
        h2{
            font-size: 16px;
            background-color: #3cbda6;
            line-height: 30px;
            color: white;
            margin: 0;
        }
        form{
            background: green;
        }
        input{
            border: 1px solid black;
        }
        div:nth-of-type(1){
            padding: 10px;
        }
    </style>
```

### 4.4、圆角边框

```css
<style>
        /*
        圆形  ：宽高相等，圆角度为100
        */
        div{
            width: 100px;
            height: 100px;
            border-radius: 100px;
            border: 10px solid red;
        }
        /*
        半圆   高度是宽度的一把
        */
        div{
           width: 100px;
            height: 50px;
            border: 1px solid red;
            border-radius: 100px 100px 0px 0;
        }
        /*竖半圆*/
        div{
            height: 100px;
            width: 50px;
            border-radius: 100px 0 0 100px;
            border: 1px solid red;
        }
    </style>
```



### 4.5、盒子阴影

```css
<style>
        div{
            width: 100px;
            height: 100px;
            border: 1px solid red;
            box-shadow: 10px 10px 10px yellow;


        }

    </style>
```

# 5、浮动（难点）

### 5.1、标准文档流

![image-20200418134236827](D:\JavaBasic\CSS\image-20200418134236827.png)

块级元素：独占一行

```css
h1~h6  p  div
```

行内元素：不独占一行

````html
span a img strong
````

行内元素可以被包含在块级元素中，反之不可以

### 5.2、display

```css
 <style>
        /*
        block 块元素
        inline 行内元素
        inline-block  是块元素，但是可以内联，在一行
        */
        div{
            width: 100px;
            height: 100px;
            border:  1px solid red;
            display: inline;
        }
        span{
            width: 100px;
            height: 100px;
            border:  1px solid red;
            display: inline-block;
        }
```

1、这个也是一种实现行内元素排列的方式，但是我们很多情况都是用float

### 5.3、float

1、左右浮动 float 

```csss
.layer01{
    border: 1px #F00 dashed;
    display: inline-block;
    float: left;
    clear: both;
}
.layer02{
    border: 1px #00F dashed;
    display: inline-block;
    float: right;
    clear: both;
}
```

### 5.4、父级边框塌陷问题

1、clear

```css
/*
clear:right右侧不允许有浮动元素
clear:right左侧不允许有浮动元素
clear:both2侧不允许有浮动元素
*/
```

解决方案：

​	1、增加父级高度

```
#father{
    border: 1px #000 solid;
    height: 800px;
}
```

​	2、增加空的div标签，然后清除浮动

```
<div class="layer01">
    <img src="images/1.png" alt="123">
</div>
<div class="layer02">
    <img src="images/2.png" alt="123">
</div>
<div class="layer03">
    <img src="images/3.png" alt="">
</div>
<div class="layer04">
    浮动的盒子可以向左浮动，也可以向右浮动，直到它的边缘碰到包含边框或另一个浮动盒子为止
</div>
<div class="clear"></div>


.clear{
    clear: both;
    margin: 0;
    border: 0;
}
```

3、overflow

在父级元素增加一个 overflow

```
/* overflow: scroll;   滚动条*/
#content{
    width: 200px;
    height: 250px;
    overflow: scroll;
}
```

4、在父类添加一个伪类： after

```
#father:after{
    content: '';
    display: block;
    clear: both;
}
```

小结：

1、浮动元素后面增加空的div

​		简单，代码中避免空div

2、设置父元素高度

​		简单，元素假设有了固定的高度，就会被限制

3、overflow

​		简单，下拉的一些场景避免使用

4、父类添加伪类（推荐使用）

写法复杂一些，父元素增加伪类after,增加空文本块，最后清除浮动就行了

### 5.5、对比

- display

  方向不可控制

- float

  浮动起来的话会脱离标准文档流，所以要解决父级边框的塌陷问题

# 6、定位

### 6.1、相对定位

```css
 /*
        solid实线
        dashed虚线
        */
	#first{
            border: 1px dashed #12661c;
            background-color: #12661c;
            position: relative;  /*相对定位：上下左右*/
            top: -20px;
            left: 30px;/*向右移动30*/
        }
        #second{
            border: 1px dashed #06f819;
            background-color: #a0a0a0;
            position: relative;
        }
        #third{
            border: 1px dashed #FF0000;
            background-color: #0000FF;
            position: relative;
            right: 100px;
            bottom: -20px;/*向下*/
        }
```

相对定位：position:relative

相对于原来的位置进行偏移，进行指定偏移，相对定位的话，它依然在标准文档流中，源来的位置会被保留

作业：![image-20200418165631764](D:\JavaBasic\CSS\image-20200418165631764.png)

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        #box{
            margin: 100px auto;
            border: 1px solid red;
            width: 300px;
            height: 300px;
            padding: 10px;
        }
        a{
            width: 100px;
            height: 100px;
            text-decoration: none;
            background-color: #ff24fc;
            line-height: 100px;
            text-align: center;
            color: white;
            display: block;
        }
        a:hover{
            background-color: blue;
        }
        .a2{
            position: relative;
            left: 200px;
            bottom: 100px;
        }
        .a4{
            position: relative;
            left: 200px;
            bottom: 100px;
        }
        .a5{
            position: relative;
            bottom: 300px;
            left: 100px;
        }


    </style>
</head>
<body>

<div id="box">
    <a class="a1" href="#">链接1</a>
    <a class="a2" href="#">链接2</a>
    <a href="#"class="a3">链接3</a>
    <a href="#"class="a4">链接4</a>
    <a href="#"class="a5">链接5</a>

</div>



</body>
</html>
```



### 6.2、绝对定位

定位：基于XXXX定位，上下左右

1、没有父级元素的定位的前提下，相对浏览器定位

2、有父级元素的定位前提下，相对父级元素定位

3、在父级元素范围内移动

相对于父级或者浏览器的位置，进行指定的偏移，绝对定位的话，它不在标准文档流中，原来的位置不会被保留

```css
 #father{
            border: 1px solid #666;
            padding: 20px;
            position: relative;
        }
        #first{
            border: 1px dashed #12661c;
            background-color: #12661c;
        }
        #second{
            border: 1px dashed #06f819;
            background-color: #a0a0a0;
            position: absolute;/*绝对定位*/
            right: 300px;
            top: 20px;
        }
```



### 6.3、固定定位

```css
 div:nth-of-type(2){/*固定定位*/
            width: 50px;
            height: 50px;
            background-color: yellow;
            position: fixed;
            right: 0;
            right: 0;
            bottom: 0;
        }
```

### 6.4、z-index

![image-20200418171653863](D:\JavaBasic\CSS\image-20200418171653863.png)

图层

opacity:透明度

```css
#content {
    width: 259px;
    padding: 0;
    margin: 0px;
    overflow: hidden;
    font-size: 12px;
    line-height: 25px;
    border: 1px #000 solid;
}

ul, li {
    padding: 0;
    margin: 0;
    list-style: none; /*去掉点*/
}

/*父级元素相对定位*/
#content ul {
    position: relative;
}

.tipTest, .tipBj {
    position: absolute;
    width: 259px;
    height: 25px;
    top: 138px;
}
.tipTest{
    /*z-index: 99;*/
    color: white;
}
.tipBj{
    background: black;
    opacity: 0.3;  /*背景透明度*/
}
```

# 7、动画（了解）

# 8、总结

