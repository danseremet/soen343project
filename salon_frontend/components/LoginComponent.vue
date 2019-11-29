<template>
  <div class="form-container">
    <div class="header">LOGIN</div>
    <div class="errors">
      <div v-for="error in errors" v-bind:key="error.id">{{error}}</div>
    </div>
    <div class="username">
      Username
      <input type="text" v-model="username" />
    </div>
    <div class="password">
      Password
      <input type="text" v-model="password" />
    </div>
    <div class="login-button">
      <button @click="real_login">Login</button>
      <!-- <button @click="fake_login"> Fake Login </button> -->
    </div>
  </div>
</template>

<script>
//import axios from "axios";

export default {
  name: "LoginComponent",
  methods: {
    async login() {
      try {
        let login_validation = await axios
          .post("/login", {
            username: this.username,
            password: this.password
          })
          .then(
            response => {
              console.log(response);
            },
            error => {
              console.log(error);
            }
          );
      } catch (e) {
        // do something on failure
        console.log(e);
      }
    },
    fake_login() {
      this.$router.push("/");
    },
    async real_login() {
      this.errors = [];
      try {
        let login_data = {
          username: this.username,
          password: this.password
        };

        // let username_data = {
        //   this.username,
        // };

        let login_validation = await this.$axios.post(
          "/api/v1/customer/login",
          login_data
        );

        if (login_validation.status == 200 && login_validation.data) {
          var uname = this.username;
          console.log(uname);
          var store_obj = await this.$axios.post(
            "/api/v1/customer/getByUsername",
            uname,
            {
              headers: { "Content-Type": "application/json" }
            }
          );

          console.log(store_obj.data);
          this.$store.commit('user/add', store_obj.data);
     

          this.$router.push("/");
        } else {
          this.errors.push("Wrong Credentials.");
        }
      } catch (e) {
        console.log(e);
      }
    }
  },
  data() {
    return {
      username: "danseremet",
      password: "123456",
      errors: []
    };
  }
};
</script>
    
<style>
.form-container {
  display: flex;
  flex-direction: column;
  background-color: lightblue;
}

.username {
  padding: 15px;
  justify-content: left;
  text-align: left;
}

.password {
  padding: 15px;
  justify-content: left;
  text-align: left;
}

.login-button {
  padding: 15px;
}

.header {
  padding: 15px;
  text-align: center;
  font-weight: bold;
}

.errors {
  min-height: 1em;
  color: red;
}
</style>