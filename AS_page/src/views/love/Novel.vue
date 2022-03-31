<template>
  <div>
    <!--    走马灯-->
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="item in rolllist" >
        <img :src="item" style="height: 100%;width:100%" alt="">
      </el-carousel-item>
    </el-carousel>


    <div style="position:fixed;right:0;">
      <div>
        <select name="选择" id="selectType" v-model:value ="lovevalue" style="height: 30px">
          <option :value="item2" v-for="item2 in kind">{{ item2 }}</option>
        </select>
        <input name="搜索" id="song" v-model:value="value1" style="height: 30px;width:300px; margin-top:10px">
        </input>
        <button v-on:click="searchByName()" style="height: 30px">搜索</button>
      </div>
      <div style="position:fixed;right:0;">
        <button v-on:click="backhome" style="width: 50px; height: 50px; border-radius: 50%;border: none ;background-color: rgba(131,236,141,0.65);">首页</button>
      </div>
    </div>
    <div>
      <div class="cardplace" v-for="item in novellist">
        <el-card class="cardStyle" :body-style="{ padding: '0px' }">
          <div class="cardimgshow"><img :src="item.img" height="300px" width="240px"></div>
          <div style="padding: 14px;">
            <span>书名：{{ item.novelname }}</span><br>
            <span>作者：{{ item.author }}</span><br>
            <div
              style="width: 280px;  display: -webkit-box;   -webkit-box-orient: vertical;  -webkit-line-clamp: 5;  overflow: hidden;">
              <span>介绍：{{ item.description }}</span><br>
            </div>

            <!--            <textarea disabled="true">{{item.description}}</textarea>-->
          </div>
        </el-card>
      </div>
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
          img: "https://img1.baidu.com/it/u=3963506861,1599585645&fm=26&fmt=auto",
          novelname: "完美世界",
          description: "一粒尘可填海，一根草斩尽日月星辰，弹指间天翻地覆。群雄并起，万族林立，诸圣争霸，乱天动地；问苍茫大地，谁主沉浮？一个少年从大荒中走出，一切从这里开始。",
          author: '晨东',
          comments: "漫天红叶，不会忘记那火桑树下的女孩。"
        },
        {
          img: "https://img1.baidu.com/it/u=3963506861,1599585645&fm=26&fmt=auto",
          novelname: "完美世界",
          description: "一粒尘可填海，一根草斩尽日月星辰，弹指间天翻地覆。群雄并起，万族林立，诸圣争霸，乱天动地；问苍茫大地，谁主沉浮？一个少年从大荒中走出，一切从这里开始。",
          author: '晨东',
          comments: "漫天红叶，不会忘记那火桑树下的女孩啊。"
        },
      ],
      kind: ["已读", "推荐", "喜欢"],
      newnovel: {},
      value1: '请输入书名',
      rolllist: ["https://img2.baidu.com/it/u=3013709318,2052434354&fm=26&fmt=auto",
        require("../../assets/asuo6.jpeg"),
        "https://img2.baidu.com/it/u=3013709318,2052434354&fm=26&fmt=auto"
      ],
      lovevalue: "已读"
    }
  },

  methods: {
    getlist() {
      console.log(this.value1);
      this.axios.get('http://localhost:8088/novel/getlist').then((response) => {
        this.novellist = response.data;
        console.log(this.novellist)
      }).catch((response) => {
        console.log(response);
      })
    },
    backhome() {
      this.$router.push({path: "/"})

    },
    searchByName(){
      console.log(this.value1);
      console.log(this.lovevalue);
      this.axios.get('http://localhost:8088/novel/getlistbyname',{params: {nname : this.value1} }).then((response) => {
        this.novellist = response.data;
        console.log(this.novellist)
      }).catch((response) => {
        console.log(response);
      })
    }
  },
  mounted(){
  this.getlist()
  },
}
</script>

<style scoped>
.cardStyle {
  height: 500px;
  width: 300px;
  margin: 20px;
  box-shadow: 10px 10px 5px #888888;
}

.cardimgshow {
  text-align: center;
  margin: 10px;

}

.cardplace {
  display: inline-block;
  font-family: 华文行楷;
  font-size: 18px;
  /*font-weight:bold;*/
}
</style>
