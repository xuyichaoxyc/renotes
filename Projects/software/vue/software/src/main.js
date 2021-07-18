// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

//引入ant-design
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

//测试启动动画使用
import loadingDirective from './components/loading/loading'

//引入axios

import axios from 'axios'

Vue.use(Antd);
Vue.use(ElementUI)
Vue.config.productionTip = false

//测试启动动画
Vue.directive('loading',loadingDirective)
//引入axios
Vue.prototype.$axios = axios

//加上api前缀
axios.defaults.baseURL = '/api'

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
