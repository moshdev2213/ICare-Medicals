<script>
import ChartCompo from "./ChartCompo.vue";
import GraphCompo from "./GraphCompo.vue";
export default {
  components: {
    ChartCompo,
    GraphCompo,
  },
};
</script>
<template>
  <div className="body-wrapper ">
    <div className="container-fluid pt-4 pb-0">
      <div className="row">
        <div className="col-lg-8 d-flex align-items-strech">
          <div className="card w-100">
            <div className="card-body">
              <div
                className="d-sm-flex d-block align-items-center justify-content-between mb-9"
              >
                <div className="mb-3 mb-sm-0">
                  <h5 className="card-title fw-semibold">Sales Overview</h5>
                </div>
                <div>
                  <select className="form-select">
                    <option value="1">March 2023</option>
                    <option value="2">April 2023</option>
                    <option value="3">May 2023</option>
                    <option value="4">June 2023</option>
                  </select>
                </div>
              </div>
              <ChartCompo />
            </div>
          </div>
        </div>
        <div className="col-lg-4">
          <div className="row">
            <div className="col-lg-12">
              <div className="card overflow-hidden">
                <div className="card-body p-4">
                  <h5 className="card-title mb-9 fw-semibold">
                    Yearly Breakup
                  </h5>
                  <div className="row align-items-start">
                    <div className="col-8">
                      <h4 className="fw-semibold mb-3">$36,358</h4>
                      <div className="d-flex align-items-center mb-3">
                        <span
                          className="me-1 rounded-circle bg-light-success round-20 d-flex align-items-center justify-content-center"
                        >
                          <i className=" text-success"></i>
                        </span>
                        <p className="text-dark me-1 fs-3 mb-0">+9%</p>
                        <p className="fs-3 mb-0">last year</p>
                      </div>
                      <div className="d-flex align-items-center">
                        <div className="me-4">
                          <span
                            className="round-8 bg-primary rounded-circle me-2 d-inline-block"
                          ></span>
                          <span className="fs-2">2023</span>
                        </div>
                        <div>
                          <span
                            className="round-8 bg-light-primary rounded-circle me-2 d-inline-block"
                          ></span>
                          <span className="fs-2">2023</span>
                        </div>
                      </div>
                    </div>
                    <div className="col-4">
                      <div className="d-flex justify-content-end">
                        <div
                          className="text-white bg-secondary rounded-circle p-6 d-flex align-items-center justify-content-center"
                        >
                          <i className="ti ti-currency-dollar fs-6"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="col-lg-12">
              <div className="card">
                <div className="card-body">
                  <div className="row align-items-start">
                    <div className="col-8">
                      <h5 className="card-title mb-9 fw-semibold">
                        Monthly Earnings
                      </h5>
                      <h4 className="fw-semibold mb-3">$6,820</h4>
                      <div className="d-flex align-items-center pb-1">
                        <span
                          className="me-2 rounded-circle bg-light-danger round-20 d-flex align-items-center justify-content-center"
                        >
                          <i className="ti ti-arrow-down-right text-danger"></i>
                        </span>
                        <p className="text-dark me-1 fs-3 mb-0">+9%</p>
                        <p className="fs-3 mb-0">last year</p>
                      </div>
                    </div>
                    <div className="col-4">
                      <div className="d-flex justify-content-end">
                        <div
                          className="text-white bg-secondary rounded-circle p-6 d-flex align-items-center justify-content-center"
                        >
                          <i className="ti ti-currency-dollar fs-6"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <GraphCompo />
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12 d-flex align-items-stretch">
          <div class="card w-100">
            <div class="card-body p-4">
              <h5 class="card-title fw-semibold mb-4">Recent Transactions</h5>
              <div class="table-responsive">
                <table class="table text-nowrap mb-0 align-middle">
                  <thead class="text-dark fs-4">
                    <tr>
                      <th class="border-bottom-0">
                        <h6 class="fw-semibold mb-0">Id</h6>
                      </th>
                      <th class="border-bottom-0">
                        <h6 class="fw-semibold mb-0">Assigned</h6>
                      </th>
                      <th class="border-bottom-0">
                        <h6 class="fw-semibold mb-0">Name</h6>
                      </th>
                      <th class="border-bottom-0">
                        <h6 class="fw-semibold mb-0">Priority</h6>
                      </th>
                      <th class="border-bottom-0">
                        <h6 class="fw-semibold mb-0">Budget</h6>
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-0">1</h6>
                      </td>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-1">Sunil Joshi</h6>
                        <span class="fw-normal">Web Designer</span>
                      </td>
                      <td class="border-bottom-0">
                        <p class="mb-0 fw-normal">Elite Admin</p>
                      </td>
                      <td class="border-bottom-0">
                        <div class="d-flex align-items-center gap-2">
                          <span class="badge bg-primary rounded-3 fw-semibold"
                            >Low</span
                          >
                        </div>
                      </td>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-0 fs-4">$3.9</h6>
                      </td>
                    </tr>
                    <tr>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-0">2</h6>
                      </td>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-1">Andrew McDownland</h6>
                        <span class="fw-normal">Project Manager</span>
                      </td>
                      <td class="border-bottom-0">
                        <p class="mb-0 fw-normal">Real Homes WP Theme</p>
                      </td>
                      <td class="border-bottom-0">
                        <div class="d-flex align-items-center gap-2">
                          <span class="badge bg-secondary rounded-3 fw-semibold"
                            >Medium</span
                          >
                        </div>
                      </td>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-0 fs-4">$24.5k</h6>
                      </td>
                    </tr>
                    <tr>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-0">3</h6>
                      </td>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-1">Christopher Jamil</h6>
                        <span class="fw-normal">Project Manager</span>
                      </td>
                      <td class="border-bottom-0">
                        <p class="mb-0 fw-normal">MedicalPro WP Theme</p>
                      </td>
                      <td class="border-bottom-0">
                        <div class="d-flex align-items-center gap-2">
                          <span class="badge bg-danger rounded-3 fw-semibold"
                            >High</span
                          >
                        </div>
                      </td>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-0 fs-4">$12.8k</h6>
                      </td>
                    </tr>
                    <tr>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-0">4</h6>
                      </td>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-1">Nirav Joshi</h6>
                        <span class="fw-normal">Frontend Engineer</span>
                      </td>
                      <td class="border-bottom-0">
                        <p class="mb-0 fw-normal">Hosting Press HTML</p>
                      </td>
                      <td class="border-bottom-0">
                        <div class="d-flex align-items-center gap-2">
                          <span class="badge bg-success rounded-3 fw-semibold"
                            >Critical</span
                          >
                        </div>
                      </td>
                      <td class="border-bottom-0">
                        <h6 class="fw-semibold mb-0 fs-4">$2.4k</h6>
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
