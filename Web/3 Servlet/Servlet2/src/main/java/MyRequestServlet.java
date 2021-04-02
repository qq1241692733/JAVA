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
 * Date: 2021-04-2021/4/2
 * Time: 15:11
 */
public class MyRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String method = request.getMethod();
        String uri = request.getRequestURI();

        String contentType =  request.getContentType();

        PrintWriter writer = response.getWriter();
        writer.println(String.format("<h1> method:%s </h1><p></p>",
                method));
        writer.println(String.format("<h1> uri:%s </h1><p></p>",
                uri));
        writer.println(String.format("<h1> contentType:%s </h1><p></p>",
                contentType));
    }
}
