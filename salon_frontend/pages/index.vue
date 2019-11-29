<template>
  <div id="main" class="background--homepage">
    <div class="container">
      <h1 class="title-inverse">Find the salon that is right for you.</h1>
      <h3 class="subtitle-inverse">Get Started now!</h3>
      <div class="row">
        <nuxt-link to="/salons">
          <button class="button--grey">View All Salons</button>
        </nuxt-link>
        <nuxt-link to="/profile">
          <button class="button--grey">Account Dashboard</button>
        </nuxt-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  }
};
</script>

<style>
</style>
