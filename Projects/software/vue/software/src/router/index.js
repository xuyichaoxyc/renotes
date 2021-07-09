import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Hello from '@/components/Hello'
//引入首页
import Index from '@/components/Index'
import Index2 from '@/components/Index2'
import Index3 from '@/components/Index3'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/hello',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/index',
      name: 'Index',
      component: Index
    },
    {
      path: '/index2',
      name: 'Index2',
      component: Index2
    },
    {
      path: '/index3',
      name: 'Index3',
      component: Index3
    }
  ]
})
