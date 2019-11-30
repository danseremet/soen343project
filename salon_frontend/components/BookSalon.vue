<template>
  <div class="form-container">
    <div class="username">
      StartTime
      <input type="datetime-local" v-model="startTime" />
    </div>
    <div class="password">
      Endtime
      <input type="datetime-local" v-model="endTime" />
    </div>
    <div class="login-button">
      <button @click="book_salon">Submit Booking</button>
      <!-- <button @click="fake_login"> Fake Login </button> -->
    </div>
  </div>
</template>

<script>
//import axios from "axios";

export default {
  name: "BookSalon",
  methods: {
    async book_salon() {
      let route_arr = this.$route.path.split("/");
      let salon_Id = route_arr[2];
      console.log(salon_Id);
      this.errors = [];
      try {
        let book_salon_data = {
          startTime: "2019-11-30T22:11:22.513Z",
          endTime: "2019-11-30T22:11:22.513Z",
          salonId: salon_Id,
          customerId: this.$store.state.user.user.id
        };
        let booking_validation = await this.$axios.post(
          "/api/v1/bookings",
          book_salon_data
        );

        if (booking_validation.status == 200 && booking_validation.data) {
          console.log("booking successful");
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
      username: "",
      password: "",
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