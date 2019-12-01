<template>
  <div class>
    <h1 class="salon-name">{{saloninfo.name}}</h1>
  </div>
</template>

<script>
export default {
  name: "SalonInformation",
  props: {
    saloninfo: Array
  },
  methods: {
    mapServices(saloninfo) {
      let salonServices = ["haircut", "Nails", "Shave", "Eyebrows", "Waxing"];
      let servicesString = "";
      for (i = 0; i < saloninfo.availableServicesIds.length; i++) {
        servicesString += salonServices[i];
      }
      console.log(servicesString);
      return servicesString;
    }
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
.salon-name {
  padding: 15px;
  text-align: center;
  font-weight: bold;
}

.header {
  padding: 15px;
  text-align: center;
  font-weight: bold;
}
</style>