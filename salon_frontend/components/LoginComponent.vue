<template>
  <div class="form-container">
      username
    <input type="text" v-model="username" />
    pass
    <input type="text" v-model="password" />
    <button @click="login"> Login </button>
     <button @click="fake_login"> Fake Login </button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginComponent",
  methods: {
     async login() {
      try {
        let login_validation = await axios.post('/login', {
            username: this.username,
            password: this.password
        }).then((response) => {
        console.log(response);
        }, (error) => {
        console.log(error);
        });
      } catch (e) {
        // do something on failure
        console.log(e);
      }
    },
    fake_login(){
        this.$router.push('/');
    }

  },
  data() {
    return {
      username: "",
      password: ""
    };
  }
};
</script>
    
<style scoped lang="scss">
</style>