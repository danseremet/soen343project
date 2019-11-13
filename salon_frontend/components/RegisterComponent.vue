// what i need: fonts color scheme gradients cash svg gems svg
<template>
  <div class="form-container">
      username
    <input type="text" v-model="username" />
    pass
    <input type="text" v-model="password" />
    <button @click="validateUsername"> click me </button>
  </div>
</template>

<script>
// import axios from "axios";

export default {
  name: "RegisterComponent",
  methods: {
    
  },
  data() {
    return {
      username: "",
      password: ""
    };
  }
};
</script>
    
<style scoped>
</style>