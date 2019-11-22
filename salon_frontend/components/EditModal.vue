<template>
  <div
    class="modal fade"
    tabindex="-1"
    role="dialog"
    aria-labelledby="exampleModalScrollableTitle"
    aria-hidden="true"
    v-bind:id="id"
  >
    <div class="modal-dialog modal-dialog-scrollable" role="document">
      <div class="modal-content" v-if="id === 'editEmail'">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalScrollableTitle">Modal title {{test}}</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form>
            <div class="form-group">
              <label for="formGroupExampleInput">Old Email</label>
              <input
                type="text"
                class="form-control"
                id="formGroupExampleInput"
                v-bind:value="test"
              />
            </div>
            <div class="form-group">
              <label for="formGroupExampleInput2">New Email</label>
              <input type="text" class="form-control" id="formGroupExampleInput2" placeholder />
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Save changes</button>
        </div>
      </div>

      <div class="modal-content" v-if="id === 'editName'">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalScrollableTitle">Modal title {{test}}</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form>
            <div class="form-group">
              <label for="formGroupExampleInput">Old Full Name</label>
              <input
                type="text"
                class="form-control"
                id="formGroupExampleInput"
                v-bind:value="test"
              />
            </div>
            <div class="form-group">
              <label for="formGroupExampleInput2">New First Name</label>
              <input type="text" class="form-control" id="formGroupExampleInput2" placeholder />
            </div>
            <div class="form-group">
              <label for="formGroupExampleInput2">New Last Name</label>
              <input type="text" class="form-control" id="formGroupExampleInput2" placeholder />
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Save changes</button>
        </div>
      </div>

      <div class="modal-content" v-if="id === 'editUsername'">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalScrollableTitle">Modal title</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form>
            <div class="form-group">
              <label for="formGroupExampleInput">Old Username</label>
              <input
                type="text"
                class="form-control"
                id="formGroupExampleInput"
                v-bind:value="test"
              />
            </div>
            <div class="form-group">
              <label for="formGroupExampleInput2">New Username</label>
              <input
                type="text"
                class="form-control"
                id="formGroupExampleInput2"
                placeholder=""
              />
            </div>
          </form>
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
  props: {
    id: String,
    test: String,
    test2: String
  },
  methods: {},
  data() {
    return {};
  }
};
</script>

<style scoped>
</style>