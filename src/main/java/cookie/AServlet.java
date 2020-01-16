package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/*
* 给客户端发送cookie
* */
@WebServlet("/CookieAServlet")
public class AServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        String id = UUID.randomUUID().toString();//生成一个随机字符串
        Cookie cookie = new Cookie("id", id);//创建Cookie对象，指定名字和值
        response.addCookie(cookie);//在响应中添加Cookie对象
        response.getWriter().print("已经给你发送了ID");
    }

}
