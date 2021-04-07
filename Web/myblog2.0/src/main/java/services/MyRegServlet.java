package services;

import dao.UserInfoDao;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
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
 * Date: 2021-04-2021/4/7
 * Time: 16:56
 */
public class MyRegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // response.setCharacterEncoding("utf-8");
       // response.setContentType("application/json");
       // PrintWriter writer = response.getWriter();
        int succ = 0;
        String msg = "";
        //1.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //todo:非空校验

        //2.操作数据库
        if (username != null && !username.equals("") &&
                password != null && !password.equals("")) {
            UserInfoDao userInfoDao = new UserInfoDao();
            try {
                succ = userInfoDao.add(username,password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            succ = 0;
        }
        //3.返回结果
        HashMap<String, Object> result = new HashMap<>();
        result.put("succ",succ);
        result.put("msg",msg);
        ResultJSONUtils.write(response,result);
        //{"succ":d%,"msg":"%s"}
        //writer.println(String.format("{\"succ\":%d,\"msg\":\"%s\"}",succ,msg));
    }
}
