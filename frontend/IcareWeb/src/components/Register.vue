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
                  <p class="text-center">Create an Account</p>
                  <form>
                    <div class="mb-3">
                      <label for="exampleInputUsername" class="form-label">Username</label>
                      <input type="text" class="form-control" id="exampleInputUsername" placeholder="Enter your username">
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputEmail" class="form-label">Email</label>
                      <input type="email" class="form-control" id="exampleInputEmail" placeholder="Enter your email">
                    </div>
                    <div class="mb-4">
                      <label for="exampleInputPassword" class="form-label">Password</label>
                      <input type="password" class="form-control" id="exampleInputPassword"
                        placeholder="Enter your password">
                    </div>
                    <div class="mb-4">
                      <label for="exampleInputConfirmPassword" class="form-label">Confirm Password</label>
                      <input type="password" class="form-control" id="exampleInputConfirmPassword"
                        placeholder="Confirm your password">
                    </div>
                    <a href="./index.html" class="btn btn-primary w-100 py-3 fs-4 mb-4 rounded-2">Register</a>
                    <div class="d-flex align-items-center justify-content-center">
                      <p class="fs-4 mb-0 fw-bold">Already have an account?</p>
                      <a class="text-primary fw-bold ms-2" href="./authentication-login.html">Sign In</a>
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
  