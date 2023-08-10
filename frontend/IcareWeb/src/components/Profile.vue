<template>
    <div className="body-wrapper ">
      <div className="container-fluid pt-4 pb-0">
        <div className="row">
          <div className="col-lg-8 d-flex align-items-stretch">
            <div className="card w-100">
              <div className="card-body">
                <form className="">
                  <div class="row">
                    <h3>My Profile</h3>
                    <div class="form-group col-md-6">
                      <label for="inputEmail4">Email</label>
                      <input
                        type="email"
                        class="form-control"
                        id="inputEmail4"
                        placeholder="Email"
                      />
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputPassword4">Password</label>
                      <input
                        type="password"
                        class="form-control"
                        id="inputPassword4"
                        placeholder="Password"
                      />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputAddress">Address</label>
                    <input
                      type="text"
                      class="form-control"
                      id="inputAddress"
                      placeholder="1234 Main St"
                    />
                  </div>

                  <div class="row">
                    <div className="form-group col-md-6">
                      <label for="inputAddress">District</label>
                      <input
                        type="text"
                        class="form-control"
                        id="inputAddress"
                        placeholder="1234 Main St"
                      />
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputCity">City</label>
                      <input type="text" class="form-control" id="inputCity" />
                    </div>
                  </div>

                  <div className="row">
                    <div class="form-group col-md-4">
                      <label for="inputState">State</label>
                      <select id="inputState" class="form-control">
                        <option selected>Choose...</option>
                        <option>...</option>
                      </select>
                    </div>
                    <div class="form-group col-md-2">
                      <label for="inputZip">Zip</label>
                      <input type="text" class="form-control" id="inputZip" />
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputZip">Telephone</label>
                      <input type="text" class="form-control" id="inputZip" />
                    </div>
                  </div>

                  <button type="submit" class="btn btn-primary">
                    Update Details
                  </button>
                </form>
              </div>
            </div>
          </div>

          <div className="col-lg-4 d-flex align-items-stretch">
            <div className="card w-100">
              <div className="card-body p-4">
                <h5 className="card-title fw-semibold mb-4">List Of Logins</h5>
                <div className="table-responsive">
                  <table className="table text-nowrap mb-0 align-middle">
                    <thead className="text-dark fs-4">
                      <tr>
                        <th className="border-bottom-0">
                          <h6 className="fw-semibold mb-0">Log Of Times</h6>
                        </th>
                        <th className="border-bottom-0">
                          <h6 className="fw-semibold mb-0">Date</h6>
                        </th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td className="border-bottom-0 text-center">
                          <h6 className="fw-semibold mb-0">1</h6>
                        </td>
                        <td className="border-bottom-0">
                          <h6 className="fw-semibold mb-1">Sunil Joshi</h6>
                          <span className="fw-normal">Web Designer</span>
                        </td>
                      </tr>
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