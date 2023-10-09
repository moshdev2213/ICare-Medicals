import { createRouter, createWebHistory } from 'vue-router'

import Pman from '../components/PatientManagement.vue'
import Dman from '../components/DoctorManagement.vue'
import Overview from '../components/OverView.vue'
import Profile from '../components/Profile.vue'
import login from '../components/Login.vue'
import registre from '../components/Register.vue'
import Pprofile from '../components/PatientProfile.vue'
import viewPro from '../components/ViewPatientPro.vue'



const routes = [
  {path: '/',component: Overview, },
  { path: '/PatientManagement',name:'Pman', component: Pman },
  { path: '/DoctorManagement', component: Dman },
  { path: '/Profile', component: Profile },
  { path: '/registre', component: registre },
  { path: '/login', component: login },
  { path: '/Pprofile', component: Pprofile },
  { path: '/viewPro/:patientId', name:'viewPro', component: viewPro },
  
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router
