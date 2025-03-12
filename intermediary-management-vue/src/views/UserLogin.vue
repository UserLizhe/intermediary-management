<template>
  <div id="login">
    <h1>慧家房屋中介管理系统登录</h1>
    <el-form :model="formData" @submit.prevent="login" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="formData.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" v-model="formData.password" placeholder="请输入密码"></el-input>
      </el-form-item>
<!--      <el-form-item label="角色">-->
<!--        <el-select v-model="formData.role" placeholder="请选择角色">-->
<!--          <el-option label="管理员" value="1"></el-option>-->
<!--          <el-option label="客户" value="2"></el-option>-->
<!--          <el-option label="房东" value="3"></el-option>-->
<!--        </el-select>-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" @click="login">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const formData = ref({
  username: '',
  password: '',
  role: ''
});

const router = useRouter();


// UserLogin.vue
const login = async () => {
  try {
    const response = await axios.post('/api/loginUser/auth', {
      username: formData.value.username,
      password: formData.value.password
    });

    if (response.data.success) {
      localStorage.setItem('token', response.data.data.token);
      const role = response.data.data.role;

      // 根据角色动态跳转
      switch(role) {
        case 'admin':
          router.push('/dashboard');
          break;
        case 'client':
          router.push('/client');
          break;
        case 'landlord':
          router.push('/landlord');
          break;
      }
    }
  } catch (error) {
    alert('登录失败: ' + error.response?.data?.message);
  }
}
</script>

<style scoped>
#login {
  text-align: center;
  margin-top: 100px;
}
</style>
