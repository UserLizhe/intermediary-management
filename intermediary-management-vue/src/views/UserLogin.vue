<template>
  <div id="login">
    <h1>慧家房屋中介管理系统登录</h1>
    <form @submit.prevent="login">
      <label for="username">用户名:</label>
      <input type="text" id="username" v-model="formData.username" required>
      <br>
      <label for="password">密码:</label>
      <input type="password" id="password" v-model="formData.password" required>
      <br>
      <label for="role">角色:</label>
      <select id="role" v-model="formData.role">
        <option value="1">管理员</option>
        <option value="2">客户</option>
        <option value="3">房东</option>
      </select>
      <br>
      <button type="submit">登录</button>
    </form>
  </div>
</template>

<!-- 在 <script setup> 上方添加独立脚本块 -->
<script>
export default {
  name: 'UserLoginPage' // 符合多单词命名规范
}
</script>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const formData = ref({
  username: '',
  password: '',
  role: '' // 使用语义化更好的字段名
});

const router = useRouter();

// 添加表单验证
const validateForm = () => {
  return (
      formData.value.username.trim() !== '' &&
      formData.value.password.trim() !== '' &&
      formData.value.role !== ''
  );
};

const login = async () => {
  if (!validateForm()) {
    alert('请填写完整登录信息');
    return;
  }

  try {
    const response = await axios.post('http://localhost:8080/login/list', {
      username: formData.value.username,
      password: formData.value.password,
      roleId: parseInt(formData.value.role)
    });

    if (response.data.success) {
      // 使用路由跳转代替 alert
      router.push({ name: 'dashboard' });
    } else {
      alert('登录失败: ' + (response.data.message || '未知错误'));
    }
  } catch (error) {
    console.error('登录请求出错:', error);
    alert(`登录失败: ${error.response?.data?.message || error.message}`);
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
