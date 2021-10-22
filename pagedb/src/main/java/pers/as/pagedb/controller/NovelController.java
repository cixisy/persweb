package pers.as.pagedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.as.pagedb.entity.Novel;
import pers.as.pagedb.service.NovelService;

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
        Novel novel1 = new Novel(1, "eq","ew","ew","wew","we");
        return novel;
    }

}
