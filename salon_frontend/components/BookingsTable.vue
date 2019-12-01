<template>
  <table class="table table-bordered">
    <thead>
      <tr class="bg-primary">
        <th scope="col">Booking #</th>
        <th scope="col">Salon</th>
        <th scope="col">Start Date</th>
        <th scope="col">End Date</th>
        <th scope="col">Paid</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="booking in bookingstable" v-bind:key="booking.id">
        <th scope="row">{{booking.id}}</th>
        <td>{{booking.salonId}}</td>
        <td>{{booking.startTime}}</td>
        <td>{{booking.endTime}}</td>
        <td>{{booking.paid}}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "BookingsTable",
  props: {
    bookingstable: Array,
    title: String
  },
  data() {
    return {};
  }
};
</script>

<style scoped>
</style>