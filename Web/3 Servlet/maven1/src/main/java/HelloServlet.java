import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获得写入流
        PrintWriter writer = resp.getWriter();
        writer.println("<h1 style='color:red'>Hello,Servlet~</h1>");
        writer.println("name= <input type = 'text'");
        writer.println("<input type='submit' value ='提交'><br>");
    }
}