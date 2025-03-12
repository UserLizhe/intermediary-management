import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    {
        path: '/dashboard',
        name: 'dashboard',
        component: () => import('@/views/DashboardPage.vue'),
        meta: { requiresAuth: true, allowedRoles: ['admin'] }
    },
    {
        path: '/client',
        name: 'client',
        component: () => import('@/views/ClientPage.vue'),
        meta: { requiresAuth: true, allowedRoles: ['client'] }
    }
];
// router/index.js
// router/index.js
import jwtDecode from 'jwt-decode';

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

router.beforeEach(async (to, from, next) => {
    const token = localStorage.getItem('token');

    // 需要认证的路由
    if (to.meta.requiresAuth) {
        if (!token) return next('/loginUser');

        try {
            const decoded = jwtDecode(token);
            // 验证角色是否匹配路由权限
            if (!to.meta.allowedRoles.includes(decoded.role)) {
                return next('/unauthorized'); // 跳转无权限页面
            }
            next();
        } catch (error) {
            localStorage.removeItem('token');
            next('/loginUser');
        }
    } else {
        next();
    }
});



// 路由守卫示例
router.beforeEach((to, from, next) => {
    const token = localStorage.getItem('token');
    // 合并两个守卫为一个
    if (to.meta.requiresAuth) {
        if (!token) return next('/login');
        try {
            const decoded = jwtDecode(token);
            if (!to.meta.allowedRoles.includes(decoded.role)) {
                return next('/unauthorized');
            }
        } catch (error) {
            localStorage.removeItem('token');
            return next('/login');
        }
    }
    next();
});

export default router;
