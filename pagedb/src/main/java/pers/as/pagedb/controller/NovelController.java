package pers.as.pagedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.as.pagedb.entity.novel.Novel;
import pers.as.pagedb.service.NovelService;

import java.util.List;
@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/novel")
public class NovelController {

    @Autowired
    private NovelService novelService;

    @CrossOrigin(origins = "*",maxAge = 3600)
    @GetMapping("/getbyid")
    @ResponseBody
    public Novel getById( Integer id){
        System.out.println(id);
        Novel novel = this.novelService.getById(id);
//        Novel novel1 = new Novel(1, "eq","ew","ew","wew","we");
        return novel;
    }
    @CrossOrigin(origins = "*",maxAge = 3600)
    @GetMapping("/getlist")
    @ResponseBody
    public List<Novel> getList(){


        return this.novelService.getList();
    }
    @CrossOrigin(origins = "*",maxAge = 3600)
    @GetMapping("/getlistbyname")
    @ResponseBody
    public List<Novel> getListByName(String nname){

        System.out.println(nname);
        List<Novel> novels = this.novelService.getListByname(nname);
        return novels;
    }
    @PostMapping("/updatecomment")
    @ResponseBody
    public void updateComment(int id,String comments ){
        this.novelService.updateComment(id,comments);
    }



}
