<template>

<table class="table table-bordered">
  <thead>
    <tr class="bg-primary">
      <th scope="col">Booking #</th>
      <th scope="col">Salon</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>2</td>
      <td>date</td>
    </tr>
  </tbody>
</table>



</template>

<script>
export default {
  name: "AllSalonsTable",
  props:{
      
  },
  methods: {
  },
  data() {
    return {
      
    };
  },

}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column; /* or inline-flex */
}
</style>