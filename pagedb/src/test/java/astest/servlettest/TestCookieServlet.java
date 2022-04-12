package astest.servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @ClassName: TestCookieServlet
 * @description:
 * @author: AS
 * @create: 2022-04-07 15:46
 */


public class TestCookieServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = (String) request.getSession().getAttribute("userName");
        if(name!=null&&!name.trim().equals("")){
            out.print("你是"+name+"-----TestCookieServlet");
        }else{
            out.print("你是没有名字-----TestCookieServlet");
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

    }

}
