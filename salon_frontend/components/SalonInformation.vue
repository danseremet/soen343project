<template>
  <div class="form-container">
    <p>Salon Name: {{saloninfo.name}}</p>
    <p>SalonID: {{saloninfo.id}}</p>
    <p>OwnerID{{saloninfo.ownerId}}</p>
    <p>Available Services: {{saloninfo.availableServicesIds}}</p>
  </div>
</template>

<script>
export default {
  name: "SalonInformation",
  props: {
    saloninfo: Array
  },
  data() {
    return {};
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