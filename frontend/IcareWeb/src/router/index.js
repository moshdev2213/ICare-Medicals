import { createRouter, createWebHistory } from 'vue-router'

import Pman from '../components/PatientManagement.vue'
import Dman from '../components/DoctorManagement.vue'
import Overview from '../components/OverView.vue'
import Profile from '../components/Profile.vue'
import login from '../components/Login.vue'
import registre from '../components/Register.vue'
import Pprofile from '../components/PatientProfile.vue'
import Dprofile from '../components/DoctorProfile.vue'
import viewPro from '../components/ViewPatientPro.vue'
import docPro from '../components/ViewDoctorPro.vue';
import log from '../components/Login.vue';



const routes = [
  
  {path: '/',component: log },
  { path: '/Overview',name:'Overview', component: Overview },
  { path: '/PatientManagement',name:'Pman', component: Pman },
  { path: '/DoctorManagement', component: Dman },
  { path: '/Profile', component: Profile },
  { path: '/registre', component: registre },
  { path: '/login', component: login },
  { path: '/Pprofile', component: Pprofile },
  { path: '/Dprofile', component: Dprofile },
  { path: '/viewPro/:patientId', name:'viewPro', component: viewPro },
   { path: '/docPro/:doctorid', name:'docPro', component: docPro},
  
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router
