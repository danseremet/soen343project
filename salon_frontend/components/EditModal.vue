<template>

<div class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true" v-bind:id="id">
<div class="modal-dialog modal-dialog-scrollable" role="document">
    <div class="modal-content">
    <div class="modal-header">
        <h5 class="modal-title" id="exampleModalScrollableTitle">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <div class="modal-body">
        {{id}}
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
    </div>
    </div>
</div>
</div>

</template>

<script>
export default {
  name: "EditModal",
  props:{
    id: String,
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