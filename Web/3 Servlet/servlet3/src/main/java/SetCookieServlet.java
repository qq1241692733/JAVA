import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/2
 * Time: 20:13
 */
public class SetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //创建Cookie
        Cookie usernameCookie = new Cookie("username","java");
        //设置Cookie最大时间
        usernameCookie.setMaxAge(60);   //60s  -1:"永"不过期,浏览器没有关闭
        //用来高数客户端
        response.addCookie(usernameCookie);

        Cookie pwdcookie = new Cookie("pwd","pwd");
        pwdcookie.setMaxAge(-1);
        response.addCookie(pwdcookie);

        PrintWriter writer = response.getWriter();
        writer.println("<h1> Cookie 储存成功 </h1>");



    }
}
