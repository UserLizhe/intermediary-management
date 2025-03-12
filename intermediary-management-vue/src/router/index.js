import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    {
        path: '/login',
        name: 'login',
        component: () => import('@/views/UserLogin.vue'),
        meta: { requiresAuth: false }
    },
    {
        path: '/dashboard',
        name: 'dashboard',
        // 修改引用路径
        component: () => import('@/views/DashboardPage.vue'),
        meta: { requiresAuth: true }
    },
    {
        path: '/:pathMatch(.*)*',
        redirect: '/login'
    }
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

// 路由守卫示例
router.beforeEach((to, from, next) => {
    const isAuthenticated = localStorage.getItem('authToken');

    if (to.meta.requiresAuth && !isAuthenticated) {
        next({ name: 'login' });
    } else {
        next();
    }
});

export default router;
