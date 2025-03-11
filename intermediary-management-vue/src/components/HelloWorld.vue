<template>
  <div>
    <h1>{{ message }}</h1>
    <button @click="fetchData">Fetch Data</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: 'Welcome to Vue.js!',
      apiData: ''
    };
  },
  methods: {
    async fetchData() {
      try {
        const response = await fetch('http://localhost:8080/hello');
        this.apiData = await response.text();
        alert(this.apiData);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }
  }
};
</script>

<style scoped>
h1 {
  color: #333;
}
</style>
