

# 1、什么是JavaScript

### 1.1、概述

JavaScript是一门世界上最流行的脚本语言

java、JavaScript

**一个合格的后端人员，必须精通JavaScript**

### 1.2、历史

ECMAScript是JavaScript的一个标准

最新已经到了es6版本~

但是大部分浏览器只停留在支持ES5上





# 2、快速入门

### 2.1引入JavaScript   

1、内部标签

```css
<script>
			alert("123")
</script>
```

2、外部引入    qt.js

test.html

```css
<!--    外部引入-->
<!--    注意script标签必须成对出现-->
<script src="js/qj.js"></script>
```

qt.js

```css
alert("123")
```

### 2.2、基本语法入门

1、浏览器调试须知

![image-20200419120308218](D:\JavaBasic\JavaScript\image-20200419120308218.png)

2、基础

```
<!--    JavaScript严格区分大小写-->
    <script>
        // 1. 定义变量
        var score = 90;
        alert(score)
        // 2. 条件控制
        if(score>60&& score<70){
            alert("60~70")
        }else if(score>=70&&score<80){
            alert("70~80")
        }else {
            alert("other")
        }
        /*
        * 多行注释
        * */
        // console.log(score) 在浏览器的控制台打印变量

    </script>
```

### 2.3数据类型

1、数值，文本，图形，音频，视频。。。。

- 变量

  ```javaSc
  var a=1
  var a_1=2
  var $1=1 
  ```

  

- number:  js不区分小数和整数

```javascript
123 //整数
123.1   //浮点数
1.23e3  //科学计数法
-99 //负数
NaN   //not a number
Infinity //无限大
```

2、字符串： 

'abc'    "abc"

布尔值： true false



3、逻辑运算

```css
&&   2个都为真，结果为真
||   一个为真，结果为真
！  取反
```

4、比较运算符！！！

```javascript
=   赋值
==   等于   类型不一样，值一样也会判断为true
===   绝对等于（类型一样，值一样）
```

这是一个JS的缺陷使用===

- 须知： NaN===NaN  ，  false   这个与所有的数值都不相等，包括自己
- 只能通过isNaN（NaN）来判断这个数是否是NaN

5、浮点数问题

```
console.log( (1/3)===(1-2/3))
```

尽量避免使用浮点数进行运算

6、null和undefined

- null 是空
- undefined未定义



7、数组

一系列相同的对象

数组中类型可以不相同

```
var  arr=[1,2,3,4,5,"hello",null,true]

arr[0]/arr[6]  数组越界会报undefined
```

·```
//保证代码的可读性
    var  arr=[1,2,3,4,5,"hello",null,true]
    console.log(arr[7])
    
    //不建议这种写法
    new Array(1,2,3,5)
</script>
```

取消数组下表：如果越界了就会

​```java
undefined
```

- `对象

对象大括号，数组是在中括号，js对象属性最后一个不需要添加逗号

```
<script>
    //js对象创建
    var  person={
            name: "zxs",
            age: 3,
            tags: ['js','java','...']
    }
</script>
```

- 取对象的值

  ```
  person.age
  person.tags[0]
  ```

### 2.4、严格检查模式

```
<script>
    //  'use strict'   严格检查模式，必须写在第一行
    //  局部变量 let 设置
    'use strict'
    //全局变量
    i=1
    var i=2
    //局部变量
    let a=2
</script>
```

# 3、数据类型

### 3.1、字符串

1、正常字符串，使用'a',"a"  单引号或者双引号 包裹

2、转义字符 \   

```javascript
\'
\n
\t
\r
\u4e2d
\x41	Ascll字符
```

3、多行字符串编写

```
<script>
    'use strict'
    //tab上面的 ``  写多行字符串
    let msg=`
    多行
    字符串
    asd
    `
</script>
```

4、模板字符串

```
<script>
    'use strict'
    let name='zxs';
    let age=28;
    let msg=`你好呀${name}`
</script>
```

5、字符串长度

```
<script>
    'use strict'
    let name='zxs';
    console.log(name.length)
</script>

console.log(name[0])
z
```

6、字符串的可变性和不可变性

![image-20200419130813741](D:\JavaBasic\JavaScript\1.png)

7、大小写转换

```
name.toUpperCase();
name.toLowerCase();
```

8、字符串索引

console.log(name.indexOf('z'))

9、截取字符串

```javascript
console.log(name.substr(0,1))   //包含前面不包含后面  [)
```

### 3.2、数组

Array可以包含任意的数据类型

```
let arr=[1,2,3,'a',123]
arr[0]  //取值
arr[0]=2  //赋值

```

1、长度 

```
arr.length
arr.length=10
```

注意：加入给arr.length赋值，数组大小就会发生变化，赋值过小，元素就会丢失

2、indexOf    返回元素的索引

```
let arr=[1,2,3,'a',123]
arr.length
arr.length=10
let num=arr.indexOf(2);
alert(num)
```

```
<script>
    'use strict'
    let arr=[1,2,3,4,'1']
    alert(arr.indexOf(1))    // 0
    alert(arr.indexOf('1'))  // 4
</script>
```

1和'1'的索引不同

3、slice ()  截取数组的一部分返回新数组

```
let newArr=arr.slice(1,3)   //包含头，不包含尾
alert(newArr)
```

4、push   pop  

```
//  push 压入尾部
//  pop 弹出尾部一个元素

'use strict'
let arr=[1,2,3,4,'1']
arr.push('a','b')  //在最后面依次添加
arr.pop()   //删除最后面一个元素
```

5、unshift,shift

```
<script>
    'use strict'
    let arr=[1,2,3,4,'1']
    arr.unshift('a','b')  //头部添加  'a'  'b'
    arr.shift()  //删除头部第一个元素
</script>
```

6、排序

```javascript
arr.sort()
```

7、元素反转

```javascript
arr.reverse()
```

8、concat()

```javascript
let arr=[1,2,3]
arr.concat([4,5,6])
[1,2,3,4,5,6]
```

注意concat并没有改变数组，会返回一个新数组

9、连接符 join

打印拼接数组，使用特定的符号拼接

```javascript
<script>
        'use strict'
        let arr=[1,2,3,4,'1']

        alert(arr.join('-'))
</script>
1-2-3-4-1
```

10、多维数组

```
<script>
    'use strict'
    let arr=[[1,2],[3,4],[5,6]]
</script>

alert(arr[1][1])   //取值，输出 4
```

### 3.3、对象

```
var 对象名字={
    key: value,
    key1: value
    ...
}
//定义person对象，2个属性
 var person={
            name: 'zxs',
            age: 28
            
        }
```

JavaScript中所有的key都是字符串，值是任意对象

1、对象赋值

```
person.age=29
29
```

2、使用一个对象不存在属性，会undefined

```
person.asda
undefined
```

3、动态删减属性

```
delete  person.age
true
```

4、动态添加,直接添加属性和值就可以

```
person
{name: "zxs", age: 28}
person.email='1231.qq.com'
{name: "zxs", age: 28, email: "1231.qq.com"}
```

5、判断属性值是否在这个对象中国 xxx in xxxx

```
'age' in person
true
//继承
'toString' in person
true
```

6、判断一个属性，是否是这个对象自身所有

```javascript
person.hasOwnProperty('age')
true
```

### 3.4、流程控制

```
<script>
    'use strict'
    var age=3;
    if(age>3){
        alert('hah')
    }else{
        alert('13')
    }
</script>
```

循环  避免死循环

```
'use strict'
 var age=3;
while (age<100){
    age+=1;
    console.log(age);
}

do{
    age+=1;
    console.log(age);
}while(age<30)
```

foreach

```
<script>
    'use strict'
    var age=[1,2,3,4,5,6,7];
   age.forEach(function (value) {
        console.log(value)
   })
</script>
```

for

```
for (let i=0;i<100;i++){
    console.log(i)
}
```

for(xx in 对象)

```
//遍历索引，通过索引拿到值
<script>
    'use strict'
    var age=[1,2,3,4,5,6,7];
   for(var num in age){
      console.log(age[num])
   }
</script>
 
//遍历
<script>
       let arr=[1,2,3,4]
        for(let a of arr){
            console.log(a)
        }
</script>


```

)

### 3.5map和set

map

```
<script>
        'use strict'
        //学生的成绩，学生的名字
        let map=new Map(
            [['tom',100],
            ['jack',20]]
        );
        map.set('tom',1000)
        console.log(map.get("tom"))
    </script>
```

set:

```
<script>
    'use strict'
    //学生的成绩，学生的名字
    let set1=new Set([1123,2,213,123,11,11,111]);
    console.log(set1.add(6))//添加
    set1.delete(213) //删除
    set1.has(2)  //判断包含
</script>
```

### 3.6、iterator

遍历map

```
<script>
   let map=new Map([['tom',1],['jack',2]]);
   for(let a of map){
       console.log(a)
   }
</script>
```

遍历set

```
<script>
   let set=new Set([1,2,3,4]);
   for(let s of set){
       console.log(s)
   }
</script>
```

# 4、函数

方法：对象（属性，方法）

函数：

### 4.1、定义一个函数

- 定义方式一

绝对值函数

```javascript
 function abs(x) {
            if(typeof x !== 'number'){
                throw "not a num"
            }
            if(x>=0){
                return x;
            }else {
                return -x;
            }
        }
```

一旦执行到return代表函数结束，返回结果

如果没有执行return，函数执行完也会返回结果，结果就是undefined

- 定义方式二

```javascript
 var abs=function(x) {
            if(typeof x !== 'number'){
                throw "not a num"
            }
            if(x>=0){
                return x;
            }else {
                return -x;
            }
        }
```

- 调用函数

  ```javascript
  abs(10)//10
  abs(-10)//10
  ```

  参数问题：javaScript可以传递人一个参数，也可以不传递参数

  参数传进来是否存在问题？

  假设参数不粗在，如何规避？

  - arguments：是一个赠送关键字

    代表所有传递进来的参数是一个数组（例如：目前只有一个参数x,但是传递进来的可能是多个参数，那么arguments可以认为包括了所有传递进来的参数的数组）

```
function abs(x) {
        console.log("x=>"+x);
        for(let i=0;i<arguments.length;i++){
            console.log(arguments[i])
        }
        if(x>=0){
            return x;
        }else {
            return -x;
    }
}
```

- rest

ES6引入的新特性，获取除了已经定义的参数之外的所有参数

```
function aaa(a,b,...rest) {
    console.log("a=>"+a);
    console.log("a=>"+b);
    console.log(rest);
}


```

rest参数只能最后面，必须用...表示

### 4.2、变量作用域

var定义的变量有实际作用域的。



```
<script>
    'use strict'
    function f() {
        var x=1;
        x=x+1;
    }
    x=x+2;//undefined
</script>
```

如果2个函数使用相同的变量名，只要在函数内部就不冲突

```
'use strict'
function f() {
    var x=1;
    x=x+1;
}
function f1() {
    var x='a';
    x=x+1; 
}
```

函数里面定义函数，变量作用域问题

```
'use strict'
function f() {
    var x=1;
    //内部函数可以访问外部函数的变量
    function f1() {
        var y=x+1;   //2
    }
    //反之不可以
    var z=x+y;   //undefined
}
```

内外函数变量重名(就近原则)由内向外查找

```
<script>
    'use strict'
    function f() {
        var x=1;
        function f1() {
                var x='a';
                console.log("in"+x) //in a
        }
        console.log("out"+x);  //out 1
        f1();
    }
    f()
</script>
```

所有变量定义在函数之前，程序由上至下执行

- 只有一个全局作用域，任何变量（函数也可以认为是 变量）
- 规范
  - 所有的全部变量会绑定到windows。如果不同的js文件使用了相同的全局变领，就会冲突

```
<script>
    //唯一变量
    var zxs={};
    //全局变量
    zxs.name="zxs";
    zxs.add=function (a,b) {
        return a+b;
    }
</script>
```

把自己的代码全部放入自己定义的唯一空间名字中，降低全局变量命名冲突

- 局部作用域let

```
<script>
    function f() {
            for(var i=0;i<100;i++){
                console.log(i)
            }
            console.log(i+1);   // 101  var定义的是全局定义
    }
</script>
```



```
<script>
    function f() {
            for(let i=0;i<100;i++){
                console.log(i)
            }
            console.log(i+1);  //i未定义
    }
</script>
```

- 常量const   不能改

  在ES6之前，怎么定义常量？  用全部大写字母命名常量

  在ES6之后引入常量关键字const

  ```
  <script>
      const PI=6;
      console.log(PI);
  </script>
  ```

### 4.3、方法

- 方法就是把函数放在对象里面，对象里面只有属性和方法

```
<script>
    var zxs={
        name: "zxs",
        birth: 1993,
        //方法
        age: function () {
            //今年-畜生
            var now=new Date().getFullYear();
            return now-this.birth;
        }

    }
</script>


zxs.age()  //27
```

```
function getAge() {
    var now=new Date().getFullYear();
    return now-this.birth;
}
var zxs={
    name: "zxs",
    birth: 1993,
    //方法
    age: getAge
}

zxs.age()  //27
```

- apply 

  可以控制this的指向   

  ```javascript
  getAge.apply(zxs,[])  //27
  ```

  

# 5、内部对象

- 标准对象

  ```javascript
  typeof 123
  "number"
  typeof "123"
  "string"
  typeof []
  "object"
  typeof {}
  "object"
  typeof Object
  "function"
  typeof Object
  "function"
  ```

  

### 5.1、Date

```
<script>

    var date=new Date();  //当前时间
    date.getFullYear();
    date.getMonth();
    date.getHours();
    date.getDate();//日
    date.getDay();//星期几
    date.getTime();//时间戳
</script>
```

### 5.2、json

- json是什么

在javaScript中一切接对象任何js支持的类型，都有可以用JSON来表示

- 对象{}
- 数组[]
- 键值对都是key  value

JSON和js转换格式

```
<script>

   var user={
   "name":"zxs",
   "age":3
   }
   //对象转换json
    var jsonUser=JSON.stringify(user)
    //json字符串转换 对象
    var jsonStr=JSON.parse(jsonUser)

</script>
```

### 5.3、Ajax

- 原生js写法 xhr异步请求
- jQuey封装好 $("#name").ajax(" ")
- axios请求

# 6、面向对象编程

### 6.1、面向对象

js,java c#.....面向对象

类：模板

对象：类的具体表现

js换一下思维：自身对象指向其他对象，就可以调用被指向对象的方法

```
<script>
        var student={
            name:'zxs',
            age:3,
            run:function () {
                console.log(this.name+"run.....")
            }
        }
        var xiaoming={
            name:"xiaoming"
        }
        xiaoming.__proto__=student;   //指向了student
</script>
```

- calss 继承

- ```
  function student(name) {
      this.name = name
  }
  
  //给student新增方法
  student.prototype.hello = function () {
      alert("hello")
  }
  ```

class关键字，是在ES6 引入的 

1、定义一个类，方法，属性

```
//ES6之后
class student{
    constructor(name) {
        this.name=name;//属性
    }
    hello(){   //方法
        alert("hello")
    }
}
```

2、继承

```
<script>

    //ES6之后
    class student1{
        constructor(name) {
            this.name=name;
        }
        hello(){
            alert("hello")
        }
    }
    var  xiaoming=new student1("小明")
    class xiaoxuesheng extends student1{
        constructor(name,grade) {
           super(name);
           this.grade=grade;
        }
        myGrade(){
            alert('我是小学生')
        }
    }
    var xiaoxue=new xiaoxuesheng("zxs",123)
</script>
```

- 原型链

__ proto __

# 7、操作DOM对象（重点）

> 浏览器介绍
>

js和浏览器的关系

为了js能在浏览器中运行

BOM：浏览器对象模型

- IE6~11
- Chrome
- Safari
- FireFox

> window

浏览器窗口

```javascript
window.alert(1)
undefined
window.innerHeight
447
window.innerWidth
1920
window.outerHeight
1040
window.outerWidth
1920
```

> navigator

navigator,封装了浏览器信息

```javascript
Navigator.appName
undefined
navigator.appName
"Netscape"
navigator.appVersion
"5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36"
navigator.userAgent
"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36"
navigator.platform
"Win32"
```

大多数时候不会使用navigator,因为会被人修改

不建议使用这些属性来判断和编写代码

> screen

代表屏幕尺寸

```javascript
screen.height
1080
screen.width
1920
```

> location(重要)  location.reload()刷新页面

location.assign('http://www.baidu.com')    在一个网站跳转到百度

location代表当前页面的URL信息

```javascript
host: "www.bilibili.com"   //主机
href: "https://www.bilibili.com/video/BV1JJ41177di?p=19"
reload: ƒ reload()//刷新网页
location.reload()
//设置新地址
location.assign(http://www.baidu.com)
```

> document

document代表当前的页面，HTML DOM文档树

```javascript
document.title
"【狂神说Java】JavaScript最新教程通俗易懂_哔哩哔哩 (゜-゜)つロ 干杯~-bilibili"
document.title="zxs"
"zxs"
```

获取具体的文档树节点

```
<dl id="app">
    <dt>Java</dt>
    <dd>JavaSe</dd>
    <dd>JavaEE</dd>
</dl>
<script>
    var dl=document.getElementById("app")
    alert(dl)
</script>
```

获取cookie

```javascript
document.cookie
"_uuid=52F4AD9B-DD6C-93A9-85C0-602CBCA1C18470148infoc; buvid3=E147DE37-6612-45C8-95FA-B60EED226540190979infoc; 
```

劫持cookie原理:

www.taobao.com

服务器端可以设置cookie:httpOnly

> history  浏览器的历史记录

history.back()   前进

history.forward()  后退

# 8、操作DOM对象（重点）

> 核心

浏览器网页就是一个DOM树形结构！

- 更新：更新DOM节点
- 遍历dom节点：得到DOM节点
- 删除：删除一个DOM节点
- 添加：添加一个新的节点

要操作一个DOM节点，就必须先获得这个节点

> ### 1、获得DOM节点

```
        <div id="father">
            <h1>标题1</h1>
            <p id="p1">p1</p>
            <p class="p2">p2</p>
        </div>

<script>
     var h1  =document.getElementsByTagName('h1');
    var h2=document.getElementById('p1');
    var h3=document.getElementsByClassName('p2');
    var father1=document.getElementById("father");
    var children=father.children;
</script>
```

> ### 2、更新节点

- id1.innerText='123'  修改文本的值

- ```
  id1.innerHTML=('<strong>123</strong>');  加粗
  id1.style.color=red;
  ```

> ### 3、删除节点

删除节点的步骤，先获取父节点，然后通过父节点删除自己

```css
<div id="father">
    <h1>标题11</h1>
    <p id="p1">p11</p>
    <p class="p2">p22</p>
</div>
//获取节点
<script>
    let h1 = document.getElementsByTagName('h1');
    let p1 = document.getElementById('p1');
    let p2 = document.getElementsByClassName('p2');
    let father1 = document.getElementById("father");
    let children = father.children;
</script>

//获取父节点  删除节点h1	
father.removeChild(h1)  
//删除是一个动态的过程，这种方式
father.removeChild(father.children[0])

```

注意：删除多个节点的时候，children是在时刻变化的，删除节点的时候一定要注意

> ### 4、插入节点（重点）

​			我获得了某个Dom节点，假设这个dom节点是空的，我们通过innerHTML可以增加一个元素

但是这个DOM节点已经存在元素了，就会覆盖



```
<body>
<p id="js">JavaScript</p>
<div id="list">
    <p id="me">javaME</p>
    <p id="ee">javaEE</p>
    <p id="se">javaSE</p>
</div>


<script>
    var
        js=document.getElementById('js');
        list=document.getElementById('list');
        list.appendChild(js);//追加到后面
</script>
```

效果：追加

- ![image-20200419205323191](D:\JavaBasic\JavaScript\append.png)

> 创建一个新的标签，实现插入
>
> ```html
> <body>
> <p id="js">JavaScript</p>
> <div id="list">
>     <p id="me">javaME</p>
>     <p id="ee">javaEE</p>
>     <p id="se">javaSE</p>
> </div>
> 
> 
> <script>
>     var
>         js=document.getElementById('js');
>         list=document.getElementById('list');
>         list.appendChild(js);//追加到后面
>         var newP=document.createElement('p');//创建一个p标签
>         newP.id='newP';
>         newP.innerHTML='Hello'
>         list.appendChild(newP);//   
> </script>
> </body>
> ```

```
//创建一个节点
var myScript=document.createElement("script");
myScript.setAttribute('type','text/javascript')
```

# 9、操作表单（验证）



- 表单是什么？  
- 文本框
- 下拉框 select
- 单选框 radio
- 多选框 checkbox
- 隐藏域 hidden
- 密码框

获得表单提交的信息

```
<form action="#">
    <p>
    <span>姓名：</span><input type="text" id="user">
    </p>
    <p>
        <span>性别：</span>
        <input type="radio" name="sex" id="boy">男
        <input type="radio" name="sex" id="girl">女
    </p>
</form>


<script>
    var input_text=document.getElementById('user')
    //得到输入框的值
    input_text.value
    //修改输入框的值
    input_text.value='123'
    var boy_radio=document.getElementById("boy")
    var girl_radio=document.getElementById('girl')
    boy_radio.checked //检查是否被选中
</script>
```

# 10、jQuery

jQuery库：存在大量javaScript函数

> 获取jQuery本地下载或者CDN
>
> ```
> <script src="lib/jquery-3.4.1.js"></script>
> ```

```
<!--
    公式： $(selector).action()
-->

<a href="" id="text-jquery">点我</a>
<script>
    //选择器就是CSS选择器
    $('#text-jquery').click(
        function () {
alert('123');
        }
    )
</script>
```

> 选择器

```
<script>
    $('p').click();//标签选择器
    $('#id').click();//id选择器
    $('.class').click()//类选择器
</script>
```

### 10.1时间

鼠标时间，键盘时间

```
   <style>
        #divMove{
            width: 500px;
            height: 500px;
            border: 1px solid red;
        }
    </style>
</head>
<body>
<!--要求：获取鼠标当前的一个坐标-->
mouse: <span id="mouseMove"></span>
<div id="divMove">
    在这里移动鼠标试试
</div>

<script>
    //当网页元素加载完毕之后，响应时间
    $(function () {
        $('#divMove').mousemove(function (e) {
            $('#mouseMove').text('x:'+e.pageX+'y:'+e.pageY)
        })
    })
</script>
```

> 操作DOM

```
<script src="lib/jquery-3.4.1.js">
    $('ul').text("asdad")  //设置值
    $('.java').text() //获得值
    $('ui').html()  //获得值
    $('ui').html('设置值')
```