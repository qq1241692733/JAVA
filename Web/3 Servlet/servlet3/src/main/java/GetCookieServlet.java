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
 * Time: 20:33
 */
public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("utf-8");
        response.setContentType("text/html");

        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();

        for (Cookie cookie : cookies) {
            writer.println(String.format("<h1> Cookie Name:%s, Cookie Value: %s</h1>",
                    cookie.getName(),cookie.getValue()));
        }
    }
}
