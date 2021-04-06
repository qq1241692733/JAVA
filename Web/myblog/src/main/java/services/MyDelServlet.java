package services;

import dao.ArticleInfoDao;
import utils.ResultJSONUtils;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/6
 * Time: 19:23
 */
@WebServlet("/del")
public class MyDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ = -1;
        String msg = "";
        //1.从前端获取参数
        int id = Integer.parseInt(request.getParameter("id"));
        //2.调用数据库执行相应的操作
        ArticleInfoDao articleInfoDao = new ArticleInfoDao();
        // 调用dao操作数据库执行删除
        try {
            succ = articleInfoDao.del(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //3.将上一步操作结果返回给前端
        HashMap<String, Object> result = new HashMap<>();
        result.put("succ", succ);
        result.put("msg", msg);
        ResultJSONUtils.write(response, result);
    }

}
