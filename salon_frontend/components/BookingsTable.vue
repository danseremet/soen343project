<template>

<table class="table table-striped">
  <thead class="thead-dark">
    <tr >
      <th scope="col">Booking #</th>
      <th scope="col">Salon</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="(value, name) in bookingstable[0]" v-bind:key="value" >
      <th scope="row">{{name}}</th>
      <td>{{value}}</td>
      <td>date</td>
    </tr>
  </tbody>
</table>



</template>

<script>
export default {
  name: "BookingsTable",
  props:{
      bookingstable: Array,
      title: String,
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

</style>