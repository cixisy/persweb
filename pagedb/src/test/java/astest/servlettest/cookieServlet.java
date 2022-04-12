package astest.servlettest;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: cookieServlet
 * @description:
 * @author: AS
 * @create: 2022-04-07 15:43
 */

public class cookieServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String name = (String) request.getSession().getAttribute("userName");
        if(name!=null&&!name.trim().equals("")){
            out.print("欢迎你"+name);
        }else{
            out.print("请登陆");
        }
        System.out.println(request.getSession().getId()+"------get请求");

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String checked = request.getParameter("me");
        if(checked!=null){
            Cookie ck = new Cookie("JSESSIONID",request.getSession().getId());
            ck.setMaxAge(60*30);
            ck.setPath("/");
            response.addCookie(ck);
        }
        String userName = request.getParameter("userName");
        if(userName!=null&&!userName.trim().equals("")){
            request.getSession().setAttribute("userName", userName);
        }
        //doGet(request, response);
        //禁用cookie url重写
        //form 请求  但一共是两次请求  dopost中的session和doget中的session不是同                 一个了已经
        //response.sendRedirect(request.getContextPath()+"/cookieServlet");
        System.out.println(request.getSession().getId()+"------post请求");
        //url 重写
        String url = response.encodeRedirectURL(request.getContextPath()+"/cookie                Servlet");
        response.sendRedirect(url);
    }

}
