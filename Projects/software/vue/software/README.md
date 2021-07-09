# software
暂时模仿[清华镜像源首页](https://mirrors.tuna.tsinghua.edu.cn/)
> software mirror

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report

# run e2e tests
npm run e2e

# run all tests
npm test
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).

## 环境搭建

https://www.ddpool.cn/article/94628.html
## 开发进度
+ 20210709 目前有三个index.vue，index1.vue使用单独的ant-desginer框架进行布局，尝试失败；index2.vue同时引用了ant-desginer和element-ui框架进行布局，尝试失败效果不理想；**index3.vue**最终使用原生的html进行设计,效果可控制，目前采用index3.vue开发