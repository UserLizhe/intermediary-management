// server/server.js
const express = require('express');
const cors = require('cors');
const app = express();

// 允许跨域请求
app.use(cors({
    origin: 'http://localhost:8081' // 替换为你的前端地址
}));

// 解析 JSON 请求体
app.use(express.json());

// 模拟用户数据（实际应连接数据库）
const users = [
    { id: 1, username: 'admin', password: 'admin123', roleId: 1 },
    { id: 2, username: 'user', password: 'user123', roleId: 2 },
];

// 登录接口
app.post('/loginUser/auth', (req, res) => {
    const { username, password, roleId } = req.body;
    const user = users.find(u =>
        u.username === username &&
        u.password === password &&
        u.roleId === roleId
    );

    if (user) {
        res.json({ success: true, message: '登录成功', token: 'fake-jwt-token' });
    } else {
        res.status(401).json({ success: false, message: '用户名或密码错误' });
    }
});

// 启动服务
const PORT = 8080;
app.listen(PORT, () => {
    console.log(`Node.js 后端运行在 http://localhost:${PORT}`);
});
