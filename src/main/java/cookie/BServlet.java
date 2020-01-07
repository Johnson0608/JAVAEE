package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 获取客户端请求中的Cookie
* */
@WebServlet("/CookieBServlet")
public class BServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Cookie[] cs = request.getCookies();//获取请求中的Cookie

        if (cs != null) {//如果请求中存在Cookie
            for (Cookie c : cs) {//遍历所有Cookie
                if (c.getName().equals("id")) {//获取Cookie名字，如果Cookie名字是id
                    response.getWriter().print("您的ID是：" + c.getValue());//打印Cookie值
                }
            }
        }

    }
}
