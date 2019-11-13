<template>
  
<div id="main" class="container">
        
      
      <h1 class="title">
        salon_frontend
      </h1>
        <!-- Button trigger modal -->
          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalScrollable">
          Launch demo modal
          </button>

          <!-- Modal -->
          <div class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
          <div class="modal-dialog modal-dialog-scrollable" role="document">
              <div class="modal-content">
              <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalScrollableTitle">Modal title</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                  </button>
              </div>
              <div class="modal-body">
                  ...
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary">Save changes</button>
              </div>
              </div>
          </div>
          </div>


        <div class="container">
            <h1 v-show="showme">Hello!</h1>
            <button v-on:click="showme = false">
                {{showme}}
            </button>
        </div>


</div>




</template>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/1.0.18/vue.min.js"></script>

<script>
import navbar from '~/components/navbar.vue'

export default {
    data () {
    return { showme: true }
  },
  components: {
    navbar
  }
}
</script>

<style>

</style>
