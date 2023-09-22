import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import 'element-plus/dist/index.css'
import element from 'element-plus'
import axios from 'axios'

require('./mock.js')

const app = createApp(App)

app.use(store).use(router).use(element).mount('#app')

//  全局挂载
app.config.globalProperties.$axios = axios
