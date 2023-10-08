<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <strong>后台管理</strong>
        <div class="header-avatar">
          <el-avatar
              src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
          />
          <el-dropdown>
            <span class="el-dropdown-link">
              admin
              <el-icon class="el-icon--right">
                <arrow-down/>
              </el-icon>
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>个人中心</el-dropdown-item>
                <el-dropdown-item>eee</el-dropdown-item>
                <el-dropdown-item>退出</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </el-header>

      <el-container>
        <el-aside width="200px">
          <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
          >
            <el-menu-item index="1">
              <el-icon><House /></el-icon>
              <span>首页</span>
            </el-menu-item>
            <el-sub-menu index="2">
              <template #title>
                <el-icon><Notification /></el-icon>
                <span>系统管理</span>
              </template>
                <el-menu-item index="2-1">
                  <el-icon><User /></el-icon>
                  <span>用户管理</span>
                </el-menu-item>
                <el-menu-item index="2-2">
                  <el-icon><Operation /></el-icon>
                  <span>角色管理</span>
                </el-menu-item>
                <el-menu-item index="2-3">
                  <el-icon><Menu /></el-icon>
                  <span>菜单管理</span>
                </el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="3">
              <template #title>
                <el-icon><Setting /></el-icon>
                <span>系统管理</span>
              </template>
              <el-menu-item index="3-1">
                <el-icon><Crop /></el-icon>
                <span>数字</span>
              </el-menu-item>
            </el-sub-menu>

          </el-menu>
        </el-aside>
        <el-main>Main</el-main>
      </el-container>
    </el-container>
  </div>
</template>


<script>

export default {
  name: "Index"
}
</script>

<style scoped>
.el-container {
  height: 100vh;
}

.header-avatar{
  float: right;
  width: 210px;
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.el-header {
  background-color: #aaa;
  justify-content: center;
  line-height: 58px;
}
.el-dropdown-link{
  cursor: pointer;
}

.el-aside {
  background-color: #ccc;
}
.el-menu-vertical-demo{

}
.el-main {
  background-color: #eee;
}
</style>