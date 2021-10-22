<template>
  <div>
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="item in 6" :key="item">
        <img src="../../assets/asuo6.jpeg" style="height: 100%;width:100%" alt="">

      </el-carousel-item>
    </el-carousel>
    <div style="position:fixed;right:0;" >
      <select name="选择" id="">
        <option value="item2" v-for="item2 in kind">{{item2}}</option>
      </select>
      <textarea name="搜索" id="song" style="height: 20px;width:300px">
      </textarea>
      <button>搜索</button>
    </div>
    <div v-for="item in novellist">
      {{item.novelname}}<br>
      {{item.author}}<br>
      {{item.description}}
    </div>

  </div>
</template>

<script>
  export default {
    name: "Novel",
    data() {
      return {
        novellist: [
          {
            img: "",
            novelname: "完美世界",
            description: "一粒尘可填海，一根草斩尽日月星辰，弹指间天翻地覆。群雄并起，万族林立，诸圣争霸，乱天动地；问苍茫大地，谁主沉浮？一个少年从大荒中走出，一切从这里开始。",
            author: '晨东',
            comments: "漫天红叶，不会忘记那火桑树下的女孩。"
          },
          {
            img: "",
            novelname: "完美世界",
            description: "一粒尘可填海，一根草斩尽日月星辰，弹指间天翻地覆。群雄并起，万族林立，诸圣争霸，乱天动地；问苍茫大地，谁主沉浮？一个少年从大荒中走出，一切从这里开始。",
            author: '晨东',
            comments: "漫天红叶，不会忘记那火桑树下的女孩。"
          },
        ],
        kind: ["已读", "推荐", "喜欢"]

      }
    },
    methods: {}
  }
</script>

<style scoped>

</style>
