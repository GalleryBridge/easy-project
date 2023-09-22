<template>
  <el-row type="flex" class="row-bg" justify="center">

    <el-col :xl="6" :lg="7">
      <div>欢迎来到后台管理系统界面</div>
    </el-col>

    <el-col :span="1">
      <el-divider direction="vertical" class="line" />
    </el-col>

    <el-col :xl="6" :lg="7">
      <el-form
          :model="loginForm"
          :rules="rules"
          ref="loginForm"
          label-width="120px"
          class="demo-ruleForm"
          :size="formSize"
          status-icon
      >
        <el-form-item label="用户名" prop="account" style="width: 380px;">
          <el-input v-model="loginForm.account" />
        </el-form-item>
        <el-form-item label="密码" prop="password" style="width: 380px;">
          <el-input type="password" v-model="loginForm.password" />
        </el-form-item>
        <el-form-item label="验证码" prop="code" style="width: 380px;">
          <el-input v-model="loginForm.code" style="width: 170px; float: left;"/>
          <el-image :src="captchaImg" class="captchaImg"></el-image>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('loginForm')">登录</el-button>
          <el-button @click="resetForm('loginForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>

<script>
  let  _this = this;
  export default {
    name: 'login',
    data() {
      return {
        loginForm: {
          account: '',
          password: '',
          code: '',
          token: ''
        },
        rules: {
          account: [
            { required: true, message: '请输入账号', trigger: 'blur' },
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
          ],
          code: [
            { required: true, message: '请输入验证码', trigger: 'blur' },
            { min: 5, max: 5, message: '请输入五位验证码', trigger: 'blur' }
          ],
        },
        captchaImg: null
      }
    },
    methods:{
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios.post('/login',this.loginForm).then(res =>{
              const jwt = res.headers['authorization']

              this.$store.commit('SET_TOKEN', jwt)

              this.$router.push('/index')
            })
          } else {
            console.log('提交失败 !!!');
            return false
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      getCaptcha(){
        this.$axios.get('/captcha').then(res => {
            console.log(res)
            this.loginForm.token = res.data.data.token
            this.captchaImg = res.data.data.captchaImg
        })
      }
    },
    created() {
      this.getCaptcha();
    }
    /*
    *   ref没有填写成功 导致方法验证失败 找不到需要验证的表单信息
    */
  }
</script>

<style>
  .row-bg{
    background-color: #FAFAFA;
    height: 800px;
    display: flex;
    align-items: center;
    text-align: center;
  }
  .line{
    height: 200px;
  }
  .captchaImg{
    float: left;
    margin-left: 8px;
    border-radius: 4px;
  }
</style>