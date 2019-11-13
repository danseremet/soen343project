<template>
<nav class="navbar sticky-top navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Salon Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <nuxt-link to="/home" class="nav-link">Home</nuxt-link>
      </li>
       <li class="nav-item">
        <nuxt-link to="/profile" class="nav-link">My Profile</nuxt-link>
      </li>
      <li class="nav-item">
        <nuxt-link to="/salons" class="nav-link">All Salons</nuxt-link>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Account
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <nuxt-link to="/about" class="dropdown-item">About Us</nuxt-link>
          <nuxt-link to="/settings" class="dropdown-item">Settings</nuxt-link>
          <a class="dropdown-item" href="#">Logout</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
</template>
