**Vue.js是什么？**

Vue.js是一款流行的JavaScript前端框架，一个用于创建用户界面的开源JavaScript框架，旨在更好地组织与简化Web开发。Vue所关注的核心是MVC模式中的视图层，同时，它也能方便地获取数据更新，并通过组件内部特定的方法实现视图与模型的交互。

Vue.js是一套构建用户界面的渐进式框架。与其他重量级框架不同的是，Vue 采用自底向上增量开发的设计。Vue的核心库只关注视图层，并且非常容易学习，非常容易与其它库或已有项目整合。另一方面，Vue完全有能力驱动采用单文件组件和Vue生态系统支持的库开发的复杂单页应用。

Vue.js 的目标是通过尽可能简单的 API 实现响应的数据绑定和组合的视图组件。

Vue.js 自身不是一个全能框架——它只聚焦于视图层。因此它非常容易学习，非常容易与其它库或已有项目整合。另一方面，在与相关工具和支持库一起使用时，Vue.js 也能完美地驱动复杂的单页应用。

**node.js是什么？**

Node.js 是一个基于 Chrome V8 引擎的 JavaScript 运行环境。 Node.js 使用了一个事件驱动、非阻塞式 I/O 的模型。

Node 是一个让 JavaScript 运行在服务端的开发平台，它让 JavaScript 成为与PHP、Python、Perl、Ruby 等服务端语言平起平坐的脚本语言。

Node对一些特殊用例进行优化，提供替代的API，使得V8在非浏览器环境下运行得更好。V8引擎执行Javascript的速度非常快，性能非常好。Node是一个基于Chrome JavaScript运行时建立的平台， 用于方便地搭建响应速度快、易于扩展的网络应用。Node 使用事件驱动， 非阻塞I/O 模型而得以轻量和高效，非常适合在分布式设备上运行数据密集型的实时应用。





# Vue3.0的核心思想

- 你们可以去看看B站的尤一的一手视频，免得被转换。英文不好的我给你们找好了对应翻译的帖子。
   **视频地址** [https://www.bilibili.com/video/av837839066/](https://links.jianshu.com/go?to=https%3A%2F%2Fwww.bilibili.com%2Fvideo%2Fav837839066%2F)
   **视频文字辅助** [https://juejin.cn/post/6844904134303301645](https://links.jianshu.com/go?to=https%3A%2F%2Fjuejin.cn%2Fpost%2F6844904134303301645)

##### 对比vue2.0的区别

- 1、性能更比Vue 2.0强。
- 2、打包更科学不再打包没用到的模块
- 3、Composition API（组合API）
- 4、Fragment, Teleport, Suspense
- 5、更友好的支持兼容TS
- 6、Custom Renderer API（自定义渲染API）

#### Composition API

- 英文好的同学可以去瞅瞅 [composition-api.vuejs.org/#summary](https://links.jianshu.com/go?to=https%3A%2F%2Fcomposition-api.vuejs.org%2F%23summary)

#### Fragment（碎片）

- 你不用再必须用一个template标签包起整个组件，一个文本一个标签，多个tempate都可以。

#### Teleport（传送门）

- 对标的是React的 Portal，有兴趣的可以去了解一下。
   https://www.jianshu.com/p/16d5cf2e48cf
- 但因为Chrome有个提案，会增加一个名为Portal的原生element，为避免命名冲突，改为Teleport
- 想知道什么是teleport的可以查看这个文章，我选出来的比较浅显易懂的。https://www.jianshu.com/p/1ecf5006b1ae

#### Suspense(悬念)

- 可在嵌套层级中等待嵌套的异步依赖项
- 支持`async setup()`
- 支持异步组件

#### Custom Renderer API

- 正在进行`NativeScript Vue`集成
- 用户可以尝试`WebGL`自定义渲染器，与普通Vue应用程序一起使用（`Vugel`）。

意味着以后可以通过 `vue`， `Dom` 编程的方式来进行 `webgl` 编程 。感兴趣可以看这里：[Getting started vugel](https://links.jianshu.com/go?to=https%3A%2F%2Fvugel.planning.nl%2F%23application)

#### Vuex Router Cli

- Vuex: **都别慌，尤一说了，Vuex的下一个版本目前还放不出来，vue3.0以目前的API为主去适配，所以暂时不会改动很大。**
- Router: 适应vue3的已经出来了，后续我也得去跟进学习下，项目里已经用了，但是改版的区别没仔细分析。
- Cli 很超前的做了vue3的工作，目前项目可以直接用cli创建，非常感谢这些团队给我们这些小白减低了很大的学习难度。