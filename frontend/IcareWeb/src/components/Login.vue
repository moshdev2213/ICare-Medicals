<template>
     <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="card mb-0">
              <div class="card-body">
                <a href="./index.html" class="text-nowrap logo-img text-center d-block py-3 w-100">
                  <img src="../assets/images/logos/logo.jpg" width="180" alt="">
                </a>
                <p class="text-center">Your Social Campaigns</p>
                <form @submit.prevent="loginAdmin">
                  <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">E-mail</label>
                    <input type="email" class="form-control" v-model="admin.email" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="mb-4">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" v-model="admin.password" id="exampleInputPassword1">
                  </div>
                  <div class="d-flex align-items-center justify-content-between mb-4">
                    <a class="text-primary fw-bold text-right" href="./index.html">Forgot Password ?</a>
                  </div>
                  <router-link to="/Overview" type="submit" class="btn btn-primary w-100 py-3 fs-4 mb-4 rounded-2">Register</router-link>
                  <div class="d-flex align-items-center justify-content-center">
    <p class="fs-4 mb-0 fw-bold">New to Modernize?</p>
    <router-link to="/registre" class="text-primary fw-bold ms-2">Create an account</router-link>
  </div>
                </form>
                <p class="text-danger">{{ errorMessage }}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
     admin: {
      email: '',
      password: '',
      }
    };
  },
  methods: {
    loginAdmin() {
      axios
        .post('http://localhost:8083/admin/login/admin', this.admin)
        .then((response) => {
          // Handle successful admin login
          // You can redirect the admin or perform other actions here
          this.$router.push('/Overview');
        })
        .catch((error) => {
          this.errorMessage = 'Email and/or password error';
          console.error(error);
        });
    },
  },
};
</script>