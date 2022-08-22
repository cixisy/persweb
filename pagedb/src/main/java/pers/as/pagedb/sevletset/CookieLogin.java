package pers.as.pagedb.sevletset;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @ClassName: CookieLogin
 * @description: 登录cookie信息
 * @author: AS
 * @create: 2022-04-14 15:21
 */
public class CookieLogin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //从客户端获取cookie
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            out.write("上一次访问的时间是：");
            for (int i =0;i<=cookies.length;i++){
                Cookie cookie = cookies[i];
                if("lastTime".equals(cookie.getName())){
                    long lastTime = Long.parseLong(cookie.getValue());
                    Date date = new Date();
                    out.write(date.toLocaleString());
                }
            }
        }else{
            out.write("这是第一次访问！");
        }
        //服务器给客户端响应一个cookie
        Cookie cookie = new Cookie("lastTime",System.currentTimeMillis()+"");
        cookie.setMaxAge(60*10);
        resp.addCookie(cookie);
    }
}
