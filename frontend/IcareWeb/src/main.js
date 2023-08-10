import './assets/css/styles.css'
import './assets/libs/apexcharts/dist/apexcharts.min.js'
import './assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js'

import VueApexCharts from 'vue3-apexcharts'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

const app = createApp(App)
app.use(VueApexCharts)
app.use(router)

app.mount('#app')
