<template>
  <div className="body-wrapper ">
    <div className="container-fluid pt-4 pb-0">
    <div className="row">
        <div className="col-lg-12 d-flex align-items-stretch">
        <div className="card w-100">
            <div className="card-body p-3">
              <div className="mt-3 d-flex justify-content-between align-items-baseline ">
                <h5 className="card-title fw-semibold mb-4">Transactions</h5>
                <input
                  type="text"
                  placeholder="Search"
                  className="form-control w-auto"/>
              </div>


            
              <div className="table-responsive">
                <DataTables searchQuery={searchQuery} />
              </div>
            </div>
          </div>
        </div>
      </div>
      
    </div>
  </div>
  <div className="body-wrapper ">
  <div className="container-fluid pt-4 pb-0">
    <div class="row">

                      <!-- Earnings (Monthly) Card Example -->
                      <div class="col-xl-3 col-md-6 mb-4">
                          <div class="card border-left-primary shadow h-100 py-2">
                              <div class="card-body">
                                  <div class="row no-gutters align-items-center">
                                      <div class="col mr-2">
                                          <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                              Earnings (Monthly)</div>
                                          <div class="h5 mb-0 font-weight-bold text-gray-800">$40,000</div>
                                      </div>
                                      <div class="col-auto">
                                          <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <!-- Earnings (Annual) Card Example -->
                      <div class="col-xl-3 col-md-6 mb-4">
                          <div class="card border-left-success shadow h-100 py-2">
                              <div class="card-body">
                                  <div class="row no-gutters align-items-center">
                                      <div class="col mr-2">
                                          <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                              Earnings (Annual)</div>
                                          <div class="h5 mb-0 font-weight-bold text-gray-800">$215,000</div>
                                      </div>
                                      <div class="col-auto">
                                          <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <!-- Tasks Card Example -->
                      <div class="col-xl-3 col-md-6 mb-4">
                          <div class="card border-left-info shadow h-100 py-2">
                              <div class="card-body">
                                  <div class="row no-gutters align-items-center">
                                      <div class="col mr-2">
                                          <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Tasks
                                          </div>
                                          <div class="row no-gutters align-items-center">
                                              <div class="col-auto">
                                                  <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div>
                                              </div>
                                              <div class="col">
                                                  <div class="progress progress-sm mr-2">
                                                      <div class="progress-bar bg-info" role="progressbar"
                                                          style="width: 50%" aria-valuenow="50" aria-valuemin="0"
                                                          aria-valuemax="100"></div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="col-auto">
                                          <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <!-- Pending Requests Card Example -->
                      <div class="col-xl-3 col-md-6 mb-4">
                          <div class="card border-left-warning shadow h-100 py-2">
                              <div class="card-body">
                                  <div class="row no-gutters align-items-center">
                                      <div class="col mr-2">
                                          <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                              Pending Requests</div>
                                          <div class="h5 mb-0 font-weight-bold text-gray-800">18</div>
                                      </div>
                                      <div class="col-auto">
                                          <i class="fas fa-comments fa-2x text-gray-300"></i>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>


                </div>

                <div className="container-fluid pt-4 pb-0">
                <div class="row">
                  <div class="col-12">
            <!-- modal of delivery starts -->
            <div class="modal fade " style="z-index: 99999;" id="modal-leave"
              tabindex="-1" role="dialog" aria-labelledby="modal-form"
              aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered modal-md"
                role="document">
                <div class="modal-content">
                  <div class="modal-body p-0">
                    <div class="card card-plain">
                      <div class="card-header pb-0 text-left">
                        <h4 class="font-weight-bolder  text-primary">Leaves</h4>
                        <p class="mb-0">Enter Relevant Credentials</p>
                      </div>
                      <div class="card-body p-3">
                        <form role="form text-left">
                          <label>Coupon Name</label>
                          <div class="input-group mb-3">
                            <input type="text" class="form-control"
                              placeholder="Email" aria-label="Email"
                              aria-describedby="email-addon" onfocus="focused(this)"
                              onfocusout="defocused(this)">
                          </div>
                          <label>Value</label>
                          <div class="input-group mb-3">
                            <input type="text" class="form-control"
                              placeholder="Password" aria-label="Password"
                              aria-describedby="password-addon"
                              onfocus="focused(this)" onfocusout="defocused(this)">
                          </div>

                          <div class=" row text-center">
                            <div class="col-6">
                              <button type="button" data-bs-dismiss="modal"
                                class="btn  bg-gradient-primary btn-md w-100 mt-2 mb-0">
                                Cancel</button>
                            </div>
                            <div class="col-6">
                              <button type="submit"
                                class="btn  btn-outline-primary btn-md w-100 mt-2 mb-0">Add</button>
                            </div>


                          </div>
                        </form>
                      </div>

                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- modal of delivery  Ends -->
            <div class="card ">
              <div class="card-header pb-0 p-3">
                <div class="row">
                  <div class="col-6 d-flex align-items-center">
                    <h6 class="mb-0">Delievery List</h6>
                  </div>
                </div>
              </div>
              <div class="card-body p-3">
                <div class="d-sm-flex justify-content-between p-0">
                  <!-- <div>
                                          <a href="javascript:;" class="btn btn-icon btn-outline-dark">
                                              New order
                                          </a>
                                      </div> -->
                  <div class="d-flex">
                    <div class="dropdown d-inline">
                      <a href="javascript:;"
                        class="btn btn-outline-dark dropdown-toggle "
                        data-bs-toggle="dropdown" id="navbarDropdownMenuLink2">
                        Filters </a>
                      <ul class="dropdown-menu dropdown-menu-lg-start px-2 py-3"
                        aria-labelledby="navbarDropdownMenuLink2"
                        data-popper-placement="left-start">
                        <li><a class="dropdown-item border-radius-md"
                          href="javascript:;">Status: Paid</a></li>
                        <li><a class="dropdown-item border-radius-md"
                          href="javascript:;">Status: Refunded</a></li>
                        <li><a class="dropdown-item border-radius-md"
                          href="javascript:;">Status: Canceled</a></li>
                        <li>
                          <hr class="horizontal dark my-2">
                        </li>
                        <li><a
                          class="dropdown-item  border-radius-md text-danger"
                          href="javascript:;">Remove Filter</a></li>
                      </ul>
                    </div>
                    <button class="btn btn-icon btn-outline-dark ms-2 export"
                      onclick="ExportToExcel4('xlsx')" type="button">
                      <span class="btn-inner--icon"><i
                        class="ni ni-archive-2"></i></span> <span class="btn-inner--text">Export
                        CSV</span>
                    </button>
                  </div>
                </div>
                <div class="table-responsive" id="tbl_exporttable_to_xls_4">
                  <table class="table table-flush" id="datatable-basic2">
                    <thead class="thead-light">
                      <tr>
                        <th>Id</th>
                        <th>Date</th>
                        <th>Status</th>
                        <th>Customer</th>
                        <th>Product</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>
                          <div class="d-flex align-items-center">

                            <p class="text-xs font-weight-bold ms-2 mb-0">#10421</p>
                          </div>
                        </td>
                        <td class="font-weight-bold"><span
                          class="my-2 text-xs">1 Nov, 10:20 AM</span></td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <button
                              class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-2 btn-sm d-flex align-items-center justify-content-center">
                              <i class="fas fa-check" aria-hidden="true"></i>
                            </button>
                            <span>Paid</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <img src="../assets/img/team-2.jpg"
                              class="avatar avatar-xs me-2" alt="user image"> <span>Orlando
                              Imieto</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold"><span
                          class="my-2 text-xs">Nike Sport V2</span></td>
                        <td class="text-xs font-weight-bold p-0 pt-1">
                          <button class="btn btn-outline-dark btn-xs p-1 mb-0"
                            data-bs-toggle="modal" data-bs-target="#modal-leave">Deliever</button>
                        </td>

                      </tr>
                      <tr>
                        <td>
                          <div class="d-flex align-items-center">

                            <p class="text-xs font-weight-bold ms-2 mb-0">#10422</p>
                          </div>
                        </td>
                        <td class="font-weight-bold"><span
                          class="my-2 text-xs">1 Nov, 10:53 AM</span></td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <button
                              class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-2 btn-sm d-flex align-items-center justify-content-center">
                              <i class="fas fa-check" aria-hidden="true"></i>
                            </button>
                            <span>Paid</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <img src="../assets/img/team-1.jpg"
                              class="avatar avatar-xs me-2" alt="user image"> <span>Alice
                              Murinho</span>
                          </div>
                        </td>
                        <td class="font-weight-bold"><span
                          class="my-2 text-xs">Valvet T-shirt</span></td>
                        <td class="text-xs font-weight-bold p-0 pt-1">
                          <button class="btn btn-outline-dark btn-xs p-1 mb-0"
                            data-bs-toggle="modal" data-bs-target="#modal-leave">Deliever</button>
                        </td>
                      </tr>

                      <tr>
                        <td>
                          <div class="d-flex align-items-center">

                            <p class="text-xs font-weight-bold ms-2 mb-0">#10424</p>
                          </div>
                        </td>
                        <td class="font-weight-bold"><span
                          class="my-2 text-xs">1 Nov, 12:20 PM</span></td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <button
                              class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-2 btn-sm d-flex align-items-center justify-content-center">
                              <i class="fas fa-check" aria-hidden="true"></i>
                            </button>
                            <span>Paid</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <div class="d-flex align-items-center">
                              <img src="../assets/img/team-3.jpg"
                                class="avatar avatar-xs me-2" alt="user image"> <span>Andrew
                                Nichel</span>
                            </div>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold"><span
                          class="my-2 text-xs"> Bracelet Onu-Lino </span></td>
                        <td class="text-xs font-weight-bold p-0 pt-1">
                          <button class="btn btn-outline-dark btn-xs p-1 mb-0"
                            data-bs-toggle="modal" data-bs-target="#modal-leave">Deliever</button>
                        </td>
                      </tr>

                      <tr>
                        <td>
                          <div class="d-flex align-items-center">

                            <p class="text-xs font-weight-bold ms-2 mb-0">#10426</p>
                          </div>
                        </td>
                        <td class="font-weight-bold"><span
                          class="my-2 text-xs">1 Nov, 2:19 AM</span></td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <button
                              class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-2 btn-sm d-flex align-items-center justify-content-center">
                              <i class="fas fa-check" aria-hidden="true"></i>
                            </button>
                            <span>Paid</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <div class="avatar avatar-xs me-2 bg-gradient-primary">
                              <span>L</span>
                            </div>
                            <span>Laur Gilbert</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold"><span
                          class="my-2 text-xs"> Backpack Niver </span></td>
                        <td class="text-xs font-weight-bold p-0 pt-1">
                          <button class="btn btn-outline-dark btn-xs p-1 mb-0"
                            data-bs-toggle="modal" data-bs-target="#modal-leave">Deliever</button>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <div class="d-flex align-items-center">

                            <p class="text-xs font-weight-bold ms-2 mb-0">#10427</p>
                          </div>
                        </td>
                        <td class="font-weight-bold"><span
                          class="my-2 text-xs">1 Nov, 3:42 AM</span></td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <button
                              class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-2 btn-sm d-flex align-items-center justify-content-center">
                              <i class="fas fa-check" aria-hidden="true"></i>
                            </button>
                            <span>Paid</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <div class="avatar avatar-xs me-2 bg-gradient-dark">
                              <span>I</span>
                            </div>
                            <span>Iryna Innda</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold"><span
                          class="my-2 text-xs"> Adidas Vio </span></td>
                        <td class="text-xs font-weight-bold p-0 pt-1">
                          <button class="btn btn-outline-dark btn-xs p-1 mb-0"
                            data-bs-toggle="modal" data-bs-target="#modal-leave">Deliever</button>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <div class="d-flex align-items-center">

                            <p class="text-xs font-weight-bold ms-2 mb-0">#10428</p>
                          </div>
                        </td>
                        <td class="font-weight-bold"><span
                          class="my-2 text-xs">2 Nov, 9:32 AM</span></td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <button
                              class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-2 btn-sm d-flex align-items-center justify-content-center">
                              <i class="fas fa-check" aria-hidden="true"></i>
                            </button>
                            <span>Paid</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <div class="avatar avatar-xs me-2 bg-gradient-dark">
                              <span>A</span>
                            </div>
                            <span>Arrias Liunda</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold"><span
                          class="my-2 text-xs"> Airpods 2 Gen </span></td>
                        <td class="text-xs font-weight-bold p-0 pt-1">
                          <button class="btn btn-outline-dark btn-xs p-1 mb-0"
                            data-bs-toggle="modal" data-bs-target="#modal-leave">Deliever</button>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <div class="d-flex align-items-center">

                            <p class="text-xs font-weight-bold ms-2 mb-0">#10429</p>
                          </div>
                        </td>
                        <td class="font-weight-bold"><span
                          class="my-2 text-xs">2 Nov, 10:14 AM</span></td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <button
                              class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-2 btn-sm d-flex align-items-center justify-content-center">
                              <i class="fas fa-check" aria-hidden="true"></i>
                            </button>
                            <span>Paid</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <div class="d-flex align-items-center">
                              <img src="../assets/img/team-5.jpg"
                                class="avatar avatar-xs me-2" alt="user image"> <span>Rugna
                                Ilpio</span>
                            </div>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold"><span
                          class="my-2 text-xs"> Bracelet Warret </span></td>
                        <td class="text-xs font-weight-bold p-0 pt-1">
                          <button class="btn btn-outline-dark btn-xs p-1 mb-0"
                            data-bs-toggle="modal" data-bs-target="#modal-leave">Deliever</button>
                        </td>
                      </tr>

                      <tr>
                        <td>
                          <div class="d-flex align-items-center">

                            <p class="text-xs font-weight-bold ms-2 mb-0">#10431</p>
                          </div>
                        </td>
                        <td class="font-weight-bold"><span
                          class="my-2 text-xs">2 Nov, 3:12 PM</span></td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <button
                              class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-2 btn-sm d-flex align-items-center justify-content-center">
                              <i class="fas fa-check" aria-hidden="true"></i>
                            </button>
                            <span>Paid</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <div class="avatar avatar-xs me-2 bg-gradient-dark">
                              <span>K</span>
                            </div>
                            <span>Karl Innas</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold"><span
                          class="my-2 text-xs"> Kitchen Gadgets </span></td>
                        <td class="text-xs font-weight-bold p-0 pt-1">
                          <button class="btn btn-outline-dark btn-xs p-1 mb-0"
                            data-bs-toggle="modal" data-bs-target="#modal-leave">Deliever</button>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <div class="d-flex align-items-center">
                            <p class="text-xs font-weight-bold ms-2 mb-0">#10432</p>
                          </div>
                        </td>
                        <td class="font-weight-bold"><span
                          class="my-2 text-xs">2 Nov, 5:12 PM</span></td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <button
                              class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-2 btn-sm d-flex align-items-center justify-content-center">
                              <i class="fas fa-check" aria-hidden="true"></i>
                            </button>
                            <span>Paid</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold">
                          <div class="d-flex align-items-center">
                            <div class="avatar avatar-xs me-2 bg-gradient-info">
                              <span>O</span>
                            </div>
                            <span>Oana Kilas</span>
                          </div>
                        </td>
                        <td class="text-xs font-weight-bold"><span
                          class="my-2 text-xs"> Office Papers </span></td>
                        <td class="text-xs font-weight-bold p-0 pt-1">
                          <button class="btn btn-outline-dark btn-xs p-1 mb-0"
                            data-bs-toggle="modal" data-bs-target="#modal-leave">Deliever</button>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                  <!-- modal of delivery starts -->
                  <div class="modal fade " style="z-index: 99999;"
                    id="modal-delivery" tabindex="-1" role="dialog"
                    aria-labelledby="modal-form" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-md"
                      role="document">
                      <div class="modal-content">
                        <div class="modal-body p-0">
                          <div class="card card-plain">
                            <div class="card-header pb-0 text-left">
                              <h4 class="font-weight-bolder  text-primary">Assign
                                Delivery Person</h4>
                              <p class="mb-0">Enter Relevant Credentials</p>
                            </div>
                            <div class="card-body p-3">
                              <form role="form text-left">
                                <label>Coupon Name</label>
                                <div class="input-group mb-3">
                                  <input type="text" class="form-control"
                                    placeholder="Email" aria-label="Email"
                                    aria-describedby="email-addon"
                                    onfocus="focused(this)" onfocusout="defocused(this)">
                                </div>
                                <label>Value</label>
                                <div class="input-group mb-3">
                                  <input type="text" class="form-control"
                                    placeholder="Password" aria-label="Password"
                                    aria-describedby="password-addon"
                                    onfocus="focused(this)" onfocusout="defocused(this)">
                                </div>

                                <div class=" row text-center">
                                  <div class="col-6">
                                    <button type="button" data-bs-dismiss="modal"
                                      class="btn  bg-gradient-primary btn-md w-100 mt-2 mb-0">
                                      Cancel</button>
                                  </div>
                                  <div class="col-6">
                                    <button type="submit"
                                      class="btn  btn-outline-primary btn-md w-100 mt-2 mb-0">Add</button>
                                  </div>


                                </div>
                              </form>
                            </div>

                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- modal of delivery  Ends -->
                </div>
              </div>
            </div>
          </div>
        </div>


                 </div>
                 </div>






                



</template>