## 前端

### 安装vue环境

```sh
# 安装淘宝镜像
npm install -g cnpm --registry=https://registry.npm.taobao.org

# vue-cli 安装
npm install --g vue-cli

# 打开vue的可视化管理工具
vue ui

# 使用命令创建
vue create 项目名
npm init vue@lastest	
@后面跟版本号 lastest是最晚
```

### 安装 Element

按需引入

> ```sh
> npm install -D unplugin-vue-components unplugin-auto-import
> ```

```js
// vite.config.ts
import { defineConfig } from 'vite'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'

export default defineConfig({
  // ...
  plugins: [
    // ...
    AutoImport({
      resolvers: [ElementPlusResolver()],
    }),
    Components({
      resolvers: [ElementPlusResolver()],
    }),
  ],
})
```

完整引入

```ts
// main.ts
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'

const app = createApp(App)

app.use(ElementPlus)
app.mount('#app')
```

> 小问题  Vue 3不支持Element-UI 要使用Element-Plus

### 安装Axios、qs、mockjs

- axios: 一个基于promise的HTML库 类似Ajax
- qs: 查询参数序列化和解析库
- mockjs: 为我们生成随机数据的工具库

axios安装命令

```sh
npm install axios --save
```

全局引入axios

```js
import axios from 'axios'
vue.prototype.$axios = axios
```

之后就可以使用this.$axios.get()来发送请求了

[中文文档](https://www.axios-http.cn/)

### qs安装

> npm install qs --save

详细教程 看[使用指南](https://juejin.cn/post/6973835825368793125)

### mockjs安装

```sh
npm install mockjs --save
```

[官网](http://mockjs.com/)









## 后端