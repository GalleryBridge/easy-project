<template>
      <el-menu
          default-active="1"
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

</template>

<script>
export default {
  name: "SideMenu"
}
</script>

<style scoped>

</style>