JavaScript（简称“JS”） 是一种具有函数优先的轻量级，解释型或即时编译型的[编程语言](https://baike.baidu.com/item/编程语言/9845131)。虽然它是作为开发[Web](https://baike.baidu.com/item/Web/150564)页面的[脚本语言](https://baike.baidu.com/item/脚本语言/1379708)而出名，但是它也被用到了很多非[浏览器](https://baike.baidu.com/item/浏览器/213911)环境中，JavaScript 基于原型编程、多范式的动态脚本语言，并且支持面向对象、命令式和声明式（如[函数](https://baike.baidu.com/item/函数/301912)式编程）风格。

jQuery 是一个 JavaScript 库。

jQuery 极大地简化了 JavaScript 编程。



在没有任何前端框架之前，我们写代码，只能用原生的JS，进行数据的处理，DOM的操作，譬如对一个id 为txtName 的文本框进行赋值，我们是这样的 document.getElementById('txtName').value = '张三'。当然这还仅仅是针对通过id获取DOM ，现实开发中还有其它的各种操作，当然如果熟悉JS的话，其实写的代码性能也还不错。只不过用原生实现的代码比较多，开发起来慢啊，在这个时间就是金钱的年代，显然不是很好的方式。

  基于原生实现不是很方便，就出来个Jquery框架了，他让我们少写很多代码，对很多操作都进行了封装简化，使我们开发起来快多了，譬如同样针对上面那个文本框赋值的功能，$('#txtName’).val('张三')。如果需要针对这个元素进行样式等改变，直接往后接着写就行了，不像原来用原生JS那样麻烦了。当然框架内部实现还是基于原生JS 这个是没办法改变的。

​    用Jquery开发了还多年，自己一直觉得已经挺快了，没有更好的方式了。但是总有一些牛逼的人物想更快，更好的方式，JQUERY操作DOM还是太慢了，还是得必须针对一个个DOM去操作，有没有那种数据变了，DOM也跟着变的。譬如还是上面的例子，张三 我现在又变成了李四了，我不需要找到DOM再赋值，直接文本框值就变成了李四呢。于是乎VUE框架诞生了。



Ajax即**A**synchronous **J**avascript **A**nd **X**ML（异步JavaScript和[XML](https://baike.baidu.com/item/XML/86251)）在 2005年被Jesse James Garrett提出的新术语，用来描述一种使用现有技术集合的‘新’方法，包括: [HTML](https://baike.baidu.com/item/HTML/97049) 或 [XHTML](https://baike.baidu.com/item/XHTML/316621), CSS, [JavaScript](https://baike.baidu.com/item/JavaScript/321142), [DOM](https://baike.baidu.com/item/DOM/50288), XML, [XSLT](https://baike.baidu.com/item/XSLT/1330564), 以及最重要的[XMLHttpRequest](https://baike.baidu.com/item/XMLHttpRequest/6788735)。 [3] 使用Ajax技术网页应用能够快速地将增量更新呈现在[用户界面](https://baike.baidu.com/item/用户界面/6582461)上，而不需要重载（刷新）整个页面，这使得程序能够更快地回应用户的操作。 [3]



使用 JavaScript 向服务器提出请求并处理响应而不阻塞用户核心对象[XMLHttpRequest](https://baike.baidu.com/item/XMLHttpRequest)。通过这个对象，您的 JavaScript 可在不重载页面的情况与 Web 服务器交换数据，即在不需要刷新页面的情况下，就可以产生局部刷新的效果。

Ajax 在浏览器与 Web 服务器之间使用异步数据传输（HTTP 请求），这样就可使网页从服务器请求少量的信息，而不是整个页面。