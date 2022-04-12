import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import HomePage from '../mainpage/HomePage'
import Novel from '../views/love/Novel'
import login from '../views/login/login'
import Java from "../views/learning/Java";
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/HomePage',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/Novel',
      name: 'Novel',
      component: Novel
    },
    {
      path: '/Java',
      name: 'Java',
      component: Java
    }
  ]
})
