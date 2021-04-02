import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/2
 * Time: 21:09
 */
public class MySessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        //1.验权
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        if (name !=null && pwd !=null &&
        name.equals("root") && pwd.equals("root")) {
            //2.用户名验证成功,创建会话信息
            HttpSession session = request.getSession();
            // true:  尝试重客户端创建Session,如果获取失败,则会创建一个会话信息  默认true
            // false: 尝试重客户端创建Session,如果获取失败,则不会创建一个会话信息
            String sessionId = session.getId();
            writer.println("<h1> 欢迎访问~ </h1>");
            writer.println(String.format("<h3> SessionId: %s </h3>",
                    sessionId));
            //Session 存储访问数量 Key
            String countKey = "countKey";
            if (session.isNew() ||
                    session.getAttribute((countKey)) == null) {
                //存储当前用户访问数据
                session.setAttribute(countKey,1);
                writer.println("<h1> 欢迎第一次访问 </h4>");
            }else {
                //拿到当前用户访问数据
                int count = (int)session.getAttribute(countKey);
                count ++;
                //重新将访问数据变更到 Session
                session.setAttribute(countKey,count);
                writer.println(String.format("<h4> 访问次数: %d </h4>",
                        count));

            }
        }else {
            writer.println("<h1> 用户名或密码错误 </h1>");
        }

    }
}
