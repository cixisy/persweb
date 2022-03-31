<template>

  <div>
    <div style="width: 30%;border:10px;padding: 20px;background-color: #859091" >
      <div v-for="(item,index) in linklist" :class="{active: index ===  currentIndex}" @click='itemClick(index)'>
        <span @dblclick="hrefClick(item.linkurl)" style="">{{ item.linkname }}</span>
        <br>
      </div>
    </div>



    <div style="position:fixed;right:0;">
      <div style="position:fixed;right:0;top: 300px">
        <button v-on:click="backhome"
                style="width: 50px; height: 50px; border-radius: 50%;border: none ;background-color: rgba(131,236,141,0.65);">
          首页
        </button>
      </div>
    </div>

  </div>


</template>

<script>
export default {
  name: "Java",
  data() {
    return {
      value: 0,
      linklist: [
        {
          linkname: "Java架构技术栈",
          linkurl: "https://blog.csdn.net/tony286186/article/details/79488939"
        },
        {
          linkname: "微服务架构推荐博客",
          linkurl: "https://www.cnblogs.com/kenshinobiy/p/11113124.html"
        },
        {
          linkname: "分布式文档跳转",
          linkurl: "http://guanzhou.pub/2018/06/04/Distributed/"
        },
        {
          linkname: "java技术栈",
          linkurl: "https://www.cnblogs.com/shenhaha520/p/9273188.html"
        },
        {
          linkname: "正则表达式",
          linkurl: "https://www.cnblogs.com/yw0219/p/8047938.html"
        },
        {
          linkname: "Git使用",
          linkurl: "https://www.jianshu.com/p/e57a4a2cf077"
        }
      ],
      currentIndex: 0
    }
  },
  methods: {
    backhome() {
      this.$router.push({path: "/"})

    },
    hrefClick(linkurl) {
      window.location.href = linkurl;//当前标签页
      window.open(linkurl);//打开一个新的标签页
    },
    itemClick(index){
      this.currentIndex = index;
      this.$emit('tabClick', index)
    }
  }
}
</script>

<style scoped>
.active{
  color: rgba(131, 236, 141, 0.65)
}

.active span{
  border-bottom: 3px solid rgba(131, 236, 141, 0.65);
}
.tab-control-item span{
  padding: 5px;
}

</style>
