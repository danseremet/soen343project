<template>
  <div class="booking-form-container">
    <div class="username">
      Appointment Start time
      <input type="datetime-local" v-model="startTime" />
    </div>
    <div class="password">
      Appointment End Time
      <input type="datetime-local" v-model="endTime" />
    </div>
    <div class>
      <button class="button--grey" @click="book_salon">Book Appointment</button>
    </div>
    <div class="success">
      <div v-for="s in success" v-bind:key="s.id">{{s}}</div>
    </div>
    <div class="errors">
      <div v-for="error in errors" v-bind:key="error.id">{{error}}</div>
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
      console.log(this.startTime);
      try {
        let book_salon_data = {
          startTime: this.startTime,
          endTime: this.endTime,
          salonId: salon_Id,
          customerId: this.$store.state.user.user.id
        };
        let booking_validation = await this.$axios.post(
          "/api/v1/bookings",
          book_salon_data
        );

        if (booking_validation.status == 200 && booking_validation.data) {
          console.log("Booking Completed");
          this.success.push("Booking has been completed");
        } else {
          this.errors.push("Booking cannot be completed");
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
      errors: [],
      success: [],
      startTime: "",
      endTime: ""

    };
  }
};
</script>
<style>
.booking-form-container {
  display: flex;
  flex-direction: column;
  background-color: white;
  border-color: #35495e;
  border-style: solid;
  border-width: 5px;
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
.header {
  padding: 15px;
  text-align: center;
  font-weight: bold;
  color: #35495e;
}

.errors {
  padding: 15px;
  min-height: 2em;
  color: red;
}
.success {
  padding: 15px;
  min-height: 2em;
  color: green;
}
.button--grey {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #35495e;
  color: #35495e;
  text-decoration: none;
  padding: 10px 30px;
}

.button--grey:hover {
  color: #fff;
  background-color: #35495e;
}
</style>