import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import User from "@/views/sys/User.vue"
import Role from "@/views/sys/Role.vue"
import Menu from "@/views/sys/Menu.vue"

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home,
    children: [
      {
        path: '/index',
        name: 'Index',
        component: () => import('@/views/Index.vue')
      },
      {
        path: '/user',
        name: 'User',
        component: User
      },
      {
        path: '/role',
        name: 'Role',
        component: Role
      },
      {
        path: '/menu',
        name: 'Menu',
        component: Menu
      },
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/Login.vue')
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
