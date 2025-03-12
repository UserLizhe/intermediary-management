import axios from 'axios';

const API_BASE = 'http://localhost:8080/loginUser';

export default {
    login: async (credentials) => {
        try {
            const response = await axios.post(`${API_BASE}/auth`, credentials);
            return response.data;
        } catch (error) {
            throw new Error(error.response?.data?.message || '登录失败');
        }
    },

    logout: async () => {
        // 登出逻辑...
    }
};
