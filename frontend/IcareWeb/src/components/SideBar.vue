<template>
    <aside className="left-sidebar shadow-sm">
        <div>
          <div className="brand-logo d-flex align-items-center justify-content-between">
            <h3 className='fw-bolder'>GAMELK</h3> 
           <img src={logo} alt="" width={150} />
          </div>
          <nav className="sidebar-nav scroll-sidebar mt-3" data-simplebar="">
            <ul id="sidebarnav">
              <li className="nav-small-cap mt-2">
                <i className="ti ti-dots nav-small-cap-icon fs-4"></i>
                <span className="hide-menu">Home</span>
              </li>
              <li className="sidebar-item">
                <a className="sidebar-link" href="./index.html" aria-expanded="false">
                  <span>
                    <i className="ti ti-layout-dashboard"></i>
                  </span>
                  <span className="hide-menu">Dashboard</span>
                </a>
              </li>
              <li className="nav-small-cap">
                <i className="ti ti-dots nav-small-cap-icon fs-4"></i>
                <span className="hide-menu">Managements</span>
              </li>
              <li className="sidebar-item">
                <a className="sidebar-link" href="./ui-buttons.html" aria-expanded="false">
                  <span>
                    <i className="ti ti-article"></i>
                  </span>
                  <span className="hide-menu">Patient Management</span>
                </a>
              </li>
              <li className="sidebar-item">
                <a className="sidebar-link" href="./ui-alerts.html" aria-expanded="false">
                  <span>
                    <i className="ti ti-alert-circle"></i>
                  </span>
                  <span className="hide-menu">Doctor Management</span>
                </a>
              </li>
              <li className="sidebar-item">
                <a className="sidebar-link" href="./ui-card.html" aria-expanded="false">
                  <span>
                    <i className="ti ti-cards"></i>
                  </span>
                  <span className="hide-menu">Staff Management</span>
                </a>
              </li>
              <li className="nav-small-cap">
                <i className="ti ti-dots nav-small-cap-icon fs-4"></i>
                <span className="hide-menu">AUTH</span>
              </li>
                      <li className="sidebar-item">
                      <a className="sidebar-link" href="./authentication-login.html" aria-expanded="false">
                  <span>
                    <i className="ti ti-user"></i>
                  </span>
                  <span className="hide-menu">My Profile</span>
                </a>
                <a className="sidebar-link" href="./authentication-login.html" aria-expanded="false">
                  <span>
                    <i className="ti ti-login"></i>
                  </span>
                  <span className="hide-menu">Logout</span>
                </a>
              </li>
            </ul>
          </nav>
        </div>
      </aside>
</template>
<style>
.simplebar-placeholder{
    display: none  !important;;
}
</style>