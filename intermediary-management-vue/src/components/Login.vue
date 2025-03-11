<template>
  <div id="login">
    <h1>慧家房屋中介管理系统登录</h1>
    <form @submit.prevent="login">
      <label for="username">用户名:</label>
      <input type="text" id="username" v-model="username" required>
      <br>
      <label for="password">密码:</label>
      <input type="password" id="password" v-model="password" required>
      <br>
      <label for="role">角色:</label>
      <select id="role" v-model="selectedRole">
        <option value="1">管理员</option>
        <option value="2">客户</option>
        <option value="3">房东</option>
      </select>
      <br>
      <button type="submit">登录</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';

// 定义表单数据
const username = ref('');
const password = ref('');
const selectedRole = ref('');

// 登录方法
const login = async () => {
  try {
    const response = await axios.post('http://localhost:8080/api/login', {
      username: username.value,
      password: password.value,
      roleId: parseInt(selectedRole.value)
    });
    if (response.data.success) {
      alert('登录成功');
      // 这里可以添加跳转到相应页面的逻辑
    } else {
      alert('登录失败，请检查用户名、密码和角色');
    }
  } catch (error) {
    console.error('登录请求出错:', error);
    alert('登录请求出错，请稍后重试');
  }
};
</script>

<style scoped>
#login {
  text-align: center;
  margin-top: 100px;
}

form {
  display: inline-block;
  text-align: left;
}

label {
  display: block;
  margin-bottom: 5px;
}

input, select {
  width: 100%;
  padding: 8px;
  margin-bottom: 15px;
}

button {
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
