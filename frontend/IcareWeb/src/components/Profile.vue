<template>
  <div class="body-wrapper">
    <div class="container-fluid pt-4 pb-4">
      <div class="row">
        <div class="col-lg-8">
          <div class="card">
            <div class="card-body">
              <form>
                <h3>My Profile</h3>
                <div class="mb-3">
                  <label for="inputEmail4" class="form-label">Email</label>
                  <input type="email" class="form-control" id="inputEmail4" placeholder="Email" />
                </div>
                <div class="mb-3">
                  <label for="inputPassword4" class="form-label">Password</label>
                  <input type="password" class="form-control" id="inputPassword4" placeholder="Password" />
                </div>
                <div class="mb-3">
                  <label for="inputAddress" class="form-label">Address</label>
                  <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" />
                </div>

                <div class="row">
                  <div class="col-md-6 mb-3">
                    <label for="inputDistrict" class="form-label">District</label>
                    <input type="text" class="form-control" id="inputDistrict" placeholder="District" />
                  </div>
                  <div class="col-md-6 mb-3">
                    <label for="inputCity" class="form-label">City</label>
                    <input type="text" class="form-control" id="inputCity" placeholder="City" />
                  </div>
                </div>

                <div class="row">
                  <div class="col-md-4 mb-3">
                    <label for="inputState" class="form-label">State</label>
                    <select id="inputState" class="form-select">
                      <option selected>Choose...</option>
                      <option>...</option>
                    </select>
                  </div>
                  <div class="col-md-2 mb-3">
                    <label for="inputZip" class="form-label">Zip</label>
                    <input type="text" class="form-control" id="inputZip" />
                  </div>
                  <div class="col-md-6 mb-3">
                    <label for="inputTelephone" class="form-label">Telephone</label>
                    <input type="text" class="form-control" id="inputTelephone" />
                  </div>
                </div>

                <button type="submit" class="btn btn-primary">Update Details</button>
              </form>
            </div>
          </div>
        </div>

        <div class="col-lg-4">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title fw-semibold mb-4">List Of Logins</h5>
              <div class="table-responsive">
                <table class="table text-nowrap mb-0 align-middle">
                  <thead class="text-dark fs-4">
                    <tr>
                      <th>
                        <h6 class="fw-semibold mb-0">Log Of Times</h6>
                      </th>
                      <th>
                        <h6 class="fw-semibold mb-0">Date</h6>
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td class="text-center">
                        <h6 class="fw-semibold mb-0">1</h6>
                      </td>
                      <td>
                        <h6 class="fw-semibold mb-1">Sunil Joshi</h6>
                        <span class="fw-normal">Web Designer</span>
                      </td>
                    </tr>
                    <!-- Add more table rows as needed -->
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
