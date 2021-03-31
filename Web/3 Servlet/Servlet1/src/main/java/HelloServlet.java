import javax.servlet.ServletException;
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
 * Date: 2021-03-2021/3/31
 * Time: 15:29
 */
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        //设置属性，编码和数据类型
        //设置编码
        response.setCharacterEncoding("UTF-8");
        //设置返回给客户端的数据类型
        response.setContentType("text/html");

        writer.println("<h1>你好，Servlet!</h1>");
    }
}
