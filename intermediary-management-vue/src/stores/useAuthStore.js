import { defineStore } from 'pinia';
import authService from '@/services/authService';

export const useAuthStore = defineStore('auth', {
    state: () => ({
        user: null,
        token: localStorage.getItem('token') || null
    }),

    actions: {
        async login(credentials) {
            const response = await authService.login(credentials);
            this.user = response.user;
            this.token = response.token;
            localStorage.setItem('token', response.token);
        },

        logout() {
            this.user = null;
            this.token = null;
            localStorage.removeItem('token');
        }
    },

    getters: {
        isAuthenticated: (state) => !!state.token
    }
});
