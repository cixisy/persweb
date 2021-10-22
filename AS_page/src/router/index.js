import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import HomePage from '../mainpage/HomePage'
import Novel from '../views/love/Novel'
Vue.use(Router)

export default new Router({
  routes: [

    {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/Novel',
      name: 'Novel',
      component: Novel
    }
  ]
})
