<template>
  <div id="main" class="container">
    <SalonInformation v-bind:saloninfo="results" />
    <BookSalon />
  </div>
</template>

<script>
import BookSalon from "~/components/BookSalon.vue";
import SalonInformation from "~/components/SalonInformation.vue";

export default {
  data() {
    return {
      startTime: "",
      endTime: "",
      salonId: "",
      customerId: "",
      results: []
    };
  },
  mounted() {
    this.$axios
      .get("/api/v1/salons/" + this.$route.path.split("/")[2])
      .then(response => {
        this.results = response.data;
        console.log("/api/v1/salons/" + this.$route.path.split("/")[2]);
      });
  },
  components: {
    BookSalon,
    SalonInformation
  },
  layout: ""
};
</script>

<style>
</style>
