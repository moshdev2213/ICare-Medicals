<script setup>
import { RouterLink, RouterView } from 'vue-router'
import OverView from './components/OverView.vue';
import SideBar from './components/SideBar.vue'
import Headers from './components/Headers.vue'
import Profile from './components/Profile.vue'
import StaffManagement from './components/StaffManagement.vue'
import DoctorManagement from './components/DoctorManagement.vue'
import PatientManagement from './components/PatientManagement.vue'
import Login from './components/Login.vue'

</script>

<template>
  <Headers/>
  <SideBar/>
  <OverView/>
  <!-- <Profile/> -->
  <!-- <StaffManagement/> -->
  <!-- <PatientManagement/> -->
  <!-- <DoctorManagement/> -->
  <!-- <Login/> -->
  <RouterView />
</template>

<style scoped>

</style>
