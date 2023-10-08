import axios from "axios";
import router from "@/router";
import {ElMessage} from 'element-plus'

//  需要解决跨域问题
//  放在后端解决
// axios.defaults.baseURL = 'http://localhost:8082'

const request = axios.create({
    //  axios 全局配置 拦截
    timeout: 5000,
    headers: {
        'Content-Type': 'application/json; charset=utf-8'
    }
})

request.interceptors.request.use(config => {
    //  设置请求头
    config.headers['Authorization'] = localStorage.getItem('token')
    return config
})

request.interceptors.response.use(response => {
    let res = response.data
    //  判断返回的 响应码
    if (res == 200) {
        return response
    } else {
        //  先判断一下是否有信息
        ElMessage.error(!res.msg ? '系统异常':res.msg)
        //  跳出请求
        return Promise.reject(response.data.msg)
    }
}, error => {

    //  获取其他错误 并在前端页面显示
    if (error.response.data) {
        error.message = error.message.response.data.msg
    }

    //  没有权限 跳到登录页面
    if (error.response.status == 401) {
        router.push('/login')
    }

    ElMessage.error(error.message, {duration: 3000})

    return Promise.reject(error)

})

export default request