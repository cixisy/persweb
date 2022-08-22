package pers.as.pagedb.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.as.pagedb.sevletset.CookieLogin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("/syslogin")
    @ResponseBody
    public String login(String username , String password){

        return "ok";
    }
    @GetMapping("/syslogin2")
    @ResponseBody
    public  String  setCookies(HttpServletRequest request ,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie :cookies){
            System.out.printf("key:%s value:%s\n", cookie.getName(), cookie.getValue());
        }

        Cookie cookie=new Cookie("cookie","123456");
        cookie.setPath("/");   //
        cookie.setMaxAge(24*60*60);       //存活一天
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addCookie(cookie);
        return "set cookie success";

    }


}
