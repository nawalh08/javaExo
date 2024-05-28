import { createRouter, createWebHistory } from 'vue-router'

import CharactersList from '../views/CharactersList.vue';
import LogInView from '../views/LogInView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Login',
      component: LogInView
    },
    {
      path: '/perso',
      name: 'character',
      component: () => import('../views/CharactersList.vue')
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    }
  ]
})

export default router
