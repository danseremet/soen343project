<template>

  <div id="main" class="container">

  </div>




</template>

<script>
    import AllSalonsTable from '~/components/AllSalonsTable.vue'

    export default {
        data () {

            return {
           }
        },
        components: {
            AllSalonsTable
        }
    }
</script>

<style>
  .container {
    display: flex;
    flex-direction: column; /* or inline-flex */
  }
</style>
