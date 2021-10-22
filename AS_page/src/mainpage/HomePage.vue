<template>
  <div class="allpage">
    <!--背景图片-->
    <div class=stylesuo>
      <!--    <img src="../assets/asuo5.jpeg">-->
    </div>
    <!--前置页面内容-->
    <div class=front>
      <div class=firstlinebox>
        <!--        页面介绍-->
        <div class=pageintroduce style="text-align: center;font-family:'Segoe Script';
        font-size: 25px;height: 100%; line-height: 50px;">
          <!--          <img src="../assets/label1.png" alt="标签" style="height: 100%">-->

          Learning never stops

        </div>
        <div style="flex: 0 1 17.5%;"></div>

        <!--        页面描述-->
        <div class="pagedescripe" style="text-align: center">
          首页
        </div>
        <div style="flex: 0 1 7.5%;"></div>
        <!--        导航栏-->
        <div class=mainnavbar>

          <el-menu
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#7ba185"
            text-color="#fff"
            active-text-color="#ffd04b"
          >

            <el-submenu index="1">
              <template slot="title">love</template>
              <el-menu-item index="1-1" @click="toNovel()">Novel</el-menu-item>
              <el-menu-item index="1-2">Basketball</el-menu-item>
              <el-menu-item index="1-3">Guitar</el-menu-item>
              <el-menu-item index="1-4">Games</el-menu-item>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">learn</template>
              <el-menu-item index="2-1">Web前端</el-menu-item>
              <el-menu-item index="2-2">Java</el-menu-item>
              <el-menu-item index="2-3">服务器部署</el-menu-item>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">Personal</template>
              <el-menu-item index="3-1">Resume</el-menu-item>
              <el-menu-item index="3-2">Memory</el-menu-item>
              <el-menu-item index="3-3">Dream</el-menu-item>
            </el-submenu>
            <el-menu-item index="1">Home</el-menu-item>


          </el-menu>
        </div>
      </div>


    </div>
    <!--      内容展示-->
    <div class="secondbox">
      <!--      内容-->
      <div class=pagecontent>
        <p style="font-size: 2.3em">大悲咒</p>
        {{contentdabei}}
        <p style="font-size: 2.3em">清心咒</p>
        {{contentdao}}
      </div>
    </div>
    <!--      目录-->
    <div class="catalogue">
      <p v-for="item in cataloguetext">
        {{item}}
      </p>

    </div>

  </div>
</template>

<script>

  export default {
    name: "HomePage",
    data() {
      return {
        contentdabei: "　南无、喝啰怛那、哆啰夜耶，南无、阿唎耶，婆卢羯帝、烁钵啰耶，菩提萨埵婆耶，摩诃萨埵婆耶，摩诃、迦卢尼迦耶，唵，萨皤啰罚曳，数怛那怛写，南无、悉吉栗埵、伊蒙阿唎耶，婆卢吉帝、室佛啰楞驮婆，南无、那啰谨墀，醯利摩诃、皤哆沙咩，萨婆阿他、豆输朋，阿逝孕，萨婆萨哆、那摩婆萨哆，那摩婆伽，摩罚特豆.怛侄他.唵，阿婆卢醯.卢迦帝.迦罗帝.夷醯唎.摩诃菩提萨埵，萨婆萨婆.摩啰摩啰，摩醯摩醯、唎驮孕.俱卢俱卢、羯蒙.度卢度卢、罚阇耶帝.摩诃罚阇耶帝.陀啰陀啰.地唎尼.室佛啰耶.遮啰遮啰.摩么罚摩啰.穆帝隶.伊醯伊醯.室那室那.阿啰参、佛啰舍利.罚沙罚参.佛啰舍耶.呼嚧呼嚧摩啰.呼嚧呼嚧醯利.娑啰娑啰，悉唎悉唎.苏嚧苏嚧.菩提夜、菩提夜.菩驮夜、菩驮夜.弥帝唎夜.那啰谨墀.地利瑟尼那.婆夜摩那.娑婆诃.悉陀夜.娑婆诃.摩诃悉陀夜.娑婆诃.悉陀喻艺.室皤啰耶.娑婆诃.那啰谨墀.娑婆诃.摩啰那啰.娑婆诃.悉啰僧、阿穆佉耶，娑婆诃.娑婆摩诃、阿悉陀夜.娑婆诃.者吉啰、阿悉陀夜.娑婆诃.波陀摩、羯悉陀夜.娑婆诃.那啰谨墀、皤伽啰耶.娑婆诃.摩婆利、胜羯啰夜.娑婆诃.南无、喝啰怛那、哆啰夜耶，南无、阿唎耶.婆嚧吉帝.烁皤啰夜.娑婆诃.唵，悉殿都.漫多啰.跋陀耶，娑婆诃.",
        contentdao: "大道无形，生育天地；大道无情，运行日月；大道无名，长养万物；吾不知其名，强名曰道。夫道者：有清有浊，有动有静；天清地浊，天动地静。男清女浊，男动女静。降本流末，而生万物。清者浊之源，动者静之基。人能常清静，天地悉皆归。夫人神好清，而心扰之；人心好静，而欲牵之。常能遣其欲，而心自静，澄其心而神自清。自然六欲不生，三毒消灭。所以不能者，为心未澄，欲未遣也。能遣之者，内观其心，心无其心；外观其形，形无其形；远观其物，物无其物。\n" +
          "三者既悟，唯见於空；观空亦空，空无所空；所空既无，无无亦无；无无既无，湛然常寂；寂无所寂，欲岂能生？欲既不生，即是真静。真常应物，真常得性；常应常静，常清静矣。如此清静，渐入真道；既入真道，名为得道，虽名得道，实无所得；为化众生，名为得道；能悟之者，可传圣道。\n" +
          "老君曰：上士无争，下士好争；上德不德，下德执德。执著之者，不名道德。众生所以不得真道者，为有妄心。既有妄心，即惊其神；既惊其神，即著万物；既著万物，即生贪求；即生贪求，即是烦恼。烦恼妄想，忧苦身心。但遭浊辱。流浪生死，常沉苦海，永失真道。真常之道，悟者自得，得悟道者，常清静矣。",
        cataloguetext: ["大悲咒", "清心咒"],
        activeIndex: '1',
        activeIndex2: '1'
      }
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      toNovel() {
        this.$router.push({path: "/Novel"})
      }
    }
  }
</script>

<style scoped>
  .stylesuo {
    top: 0;
    left: 0;
    width: 100%;
    height: 100%; /**宽高100%是为了图片铺满屏幕 */

    z-index: -1;
    position: fixed;
    background-image: url(../assets/asuo5.jpeg);
    background-attachment: fixed;
    background-size: cover;


  }

  .front {
    z-index: 1;
    position: absolute;
    width: 100%;
    height: 100%;
    opacity: 0.9;
    top: 0;
    left: 0;
  }

  .firstlinebox {
    width: 100%;
    height: 50px;
    padding: 0;
    display: flex;
    position: fixed;
    justify-content: center;
  }

  .pageintroduce {
    margin-left: 0px;
    padding: 0px;
    flex: 0 1 25%;

    background-image: url(../assets/label1.png);
    background-repeat: no-repeat;
    background-size: 100% 100%;
  }

  .pagedescripe {
    height: 80%;
    flex: 0 1 15%;
    background-image: url(../assets/label3.png);
    background-repeat: no-repeat;
    background-size: 100% 100%;
  }

  .mainnavbar {
    margin-left: 0px;
    padding: 0px;
    /*height: 100%;*/
    background-color: #5cc6d2;
    flex: 0 1 35%;
    text-align: center;
  }

  .secondbox {
    width: 100%;
    height: 100%;
    padding-top: 50px;
    display: flex;
    position: absolute;
    justify-content: space-between;

  }

  .pagecontent {
    padding: 20px;
    margin-top: 70px;
    margin-right: 200px;
    margin-left: 20px;
    height: 100%;
    width: 65%;

    border-width: 2px;
    border-style: solid;
    border-color: #bec2c0;

    text-align: center;
    line-height: 2em;

  }

  .catalogue {
    padding-top: 100px;
    position: fixed;
    top: 100px;
    right: 0;
    height: 50%;
    width: 18%;

    background-color: #bec2c0;
    opacity: 0.5;
    index: 2;


  }
</style>
