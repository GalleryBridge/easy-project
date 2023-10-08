<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <header-menu/>
      </el-header>

      <el-container>
        <el-aside width="200px">
          <side-menu/>
        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  import SideMenu from "@/views/inc/SideMenu";
  import HeaderMenu from "@/views/inc/HeaderMenu";

  export default {
    name: 'Home',
    components: {
      SideMenu,
      HeaderMenu
    }
  }
</script>

<style>
.el-container {
  height: 100vh;
}

.el-header {
  background-color: #aaa;
  justify-content: center;
  line-height: 58px;
}


.el-aside {
  background-color: #ccc;
}

.el-main {
  background-color: #eee;
}
</style>