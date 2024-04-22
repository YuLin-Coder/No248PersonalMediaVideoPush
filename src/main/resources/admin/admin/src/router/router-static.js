import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import wenzhangleixing from '@/views/modules/wenzhangleixing/list'
    import tupianleixing from '@/views/modules/tupianleixing/list'
    import yonghu from '@/views/modules/yonghu/list'
    import shipinxinxi from '@/views/modules/shipinxinxi/list'
    import shipinleixing from '@/views/modules/shipinleixing/list'
    import discussshipinxinxi from '@/views/modules/discussshipinxinxi/list'
    import discusstupianxinxi from '@/views/modules/discusstupianxinxi/list'
    import tupianxinxi from '@/views/modules/tupianxinxi/list'
    import discusswenzhangxinxi from '@/views/modules/discusswenzhangxinxi/list'
    import wenzhangxinxi from '@/views/modules/wenzhangxinxi/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/wenzhangleixing',
        name: '文章类型',
        component: wenzhangleixing
      }
      ,{
	path: '/tupianleixing',
        name: '图片类型',
        component: tupianleixing
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/shipinxinxi',
        name: '视频信息',
        component: shipinxinxi
      }
      ,{
	path: '/shipinleixing',
        name: '视频类型',
        component: shipinleixing
      }
      ,{
	path: '/discussshipinxinxi',
        name: '视频信息评论',
        component: discussshipinxinxi
      }
      ,{
	path: '/discusstupianxinxi',
        name: '图片信息评论',
        component: discusstupianxinxi
      }
      ,{
	path: '/tupianxinxi',
        name: '图片信息',
        component: tupianxinxi
      }
      ,{
	path: '/discusswenzhangxinxi',
        name: '文章信息评论',
        component: discusswenzhangxinxi
      }
      ,{
	path: '/wenzhangxinxi',
        name: '文章信息',
        component: wenzhangxinxi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
