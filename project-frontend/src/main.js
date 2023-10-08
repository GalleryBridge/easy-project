import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import element from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import axios from './axios'

require('./mock.js')

const app = createApp(App)

app.use(store).use(router).use(element).mount('#app')
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

//  全局挂载
app.config.globalProperties.$axios = axios
