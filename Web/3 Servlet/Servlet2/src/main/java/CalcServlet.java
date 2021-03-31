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
 * Time: 21:36
 */
public class CalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码和返回的类型
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //response: 前端的所有信息
        //2.获取前端传递的参数
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        int total = Integer.parseInt(num1) + Integer.parseInt(num2);
        PrintWriter writer = response.getWriter();
        writer.println(String.format("<h1>计算的结果为： %d</h1>",total));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
