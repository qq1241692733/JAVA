import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/2
 * Time: 21:59
 */
//表示当前是类为多媒体请求的类
@MultipartConfig
public class MyUpload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //保存图片
//        Part part = request.getPart("myfile");
//        part.write("D:\\a.jpg");
//        PrintWriter writer = response.getWriter();
//        writer.println("<h1> 图片上传成功 </h1>");

        UUID uuid = UUID.randomUUID();
        Part part = request.getPart("myfile");
        part.write(String.format("D:\\%s%s",
                uuid,part.getSubmittedFileName()));
        PrintWriter writer = response.getWriter();
        writer.println("<h1> 图片上传成功 </h1>");
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
