package pers.as.pagedb.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: LoginController
 * @description: 登录界面操作
 * @author: AS
 * @create: 2022-04-11 16:38
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/login")
public class LoginController {


    @CrossOrigin(origins = "*",maxAge = 3600)
    @GetMapping("/syslogin")
    @ResponseBody
    public String login(String username , String password){

        return "ok";
    }

}
