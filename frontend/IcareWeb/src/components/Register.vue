<template>
  <div
    class="page-wrapper"
    id="main-wrapper"
    data-layout="vertical"
    data-navbarbg="skin6"
    data-sidebartype="full"
    data-sidebar-position="fixed"
    data-header-position="fixed"
  >
    <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center"
    >
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="card mb-0">
              <div class="card-body">
                <a
                  href="./index.html"
                  class="text-nowrap logo-img text-center d-block py-3 w-100"
                >
                  <img
                    src="../assets/images/logos/logo.jpg"
                    width="180"
                    alt=""
                  />
                </a>
                <p class="text-center">Create an Account</p>
                <form @submit.prevent="submitForm">
                  <div class="mb-3">
                    <label for="exampleInputUsername" class="form-label"
                      >Username</label
                    >
                    <input
                      type="text"
                      class="form-control"
                      v-model="admin.uname"
                      id="exampleInputUsername"
                      placeholder="Enter your username"
                    />
                    <p class="text-danger" v-if="!isValidUname">
                      Please enter a valid username.
                    </p>
                  </div>

                  <div class="mb-3">
                    <label for="exampleInputEmail" class="form-label"
                      >Email</label
                    >
                    <input
                      type="email"
                      class="form-control"
                      v-model="admin.email"
                      id="exampleInputEmail"
                      placeholder="Enter your email"
                    />
                    <p class="text-danger" v-if="!isValidEmail">
                      Please enter a valid email address.
                    </p>
                  </div>

                  <div class="mb-4">
                    <label for="exampleInputPassword" class="form-label"
                      >Password</label
                    >
                    <input
                      type="password"
                      class="form-control"
                      v-model="admin.password"
                      id="exampleInputPassword"
                      placeholder="Enter your password"
                    />
                    <p class="text-danger" v-if="!isValidPassword">
                      Please enter a valid password (at least 8 characters).
                    </p>
                  </div>
                  <div class="mb-4">
                    <label for="exampleInputConfirmPassword" class="form-label"
                      >Confirm Password</label
                    >
                    <input
                      type="password"
                      class="form-control"
                      id="exampleInputConfirmPassword"
                      placeholder="Confirm your password"
                    />
                  </div>
                  <button
                    type="submit"
                    class="btn btn-primary w-100 py-3 fs-4 mb-4 rounded-2"
                  >
                    Register
                  </button>
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">Already have an account?</p>
                    <router-link to="/" class="text-primary fw-bold ms-2"
                      >Sign In</router-link
                    >
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      admin: {
        uname: "",
        firstname: "",
        lastname: "",
        role: "",
        password: "",
        email: "",
      },
      isValidUname: true,
      isValidEmail: true,
      isValidPassword: true,
    };
  },
  methods: {
    submitForm() {
      this.validateForm();

      if (this.isFormValid) {
        axios
          .post("http://localhost:8090/admin", this.admin)
          .then((response) => {
            console.log("admin data sent successfully:", response.data);
            this.clearFormFields();
          })
          .catch((error) => {
            console.error("Error sending admin data:", error);
          });

        this.$router.push("/");
      }
    },
    validateForm() {
      this.isValidUname = this.isValidField(this.admin.uname);
      this.isValidEmail = this.isValidEmailField(this.admin.email);
      this.isValidPassword = this.isValidPasswordField(this.admin.password);

      this.isFormValid =
        this.isValidUname && this.isValidEmail && this.isValidPassword;
    },
    isValidField(value) {
      return typeof value === "string" && value.trim() !== "";
    },
    isValidEmailField(email) {
      // You can add more complex email validation logic here
      return /\S+@\S+\.\S+/.test(email);
    },
    isValidPasswordField(password) {
      return password.length >= 8; // Password should be at least 8 characters
    },
    clearFormFields() {
      this.admin.uname = "";
      this.admin.firstname = "";
      this.admin.lastname = "";
      this.admin.role = "";
      this.admin.password = "";
      this.admin.email = "";
    },
  },
};
</script>
