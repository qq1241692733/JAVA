package services;

import com.sun.org.apache.regexp.internal.RE;
import dao.UserInfoDao;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/4
 * Time: 15:09
 */
public class LoginRegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ = -1;
        String msg = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username != null && !username.equals("")&&
            password != null && !password.equals("")) {
            //参数正确,执行数据库查询
            UserInfoDao userInfoDao = new UserInfoDao();
            try {
                //查询结果
                UserInfo userInfo = userInfoDao.getUser(username, password);
                if (userInfo.getId() > 0) {
                    succ = 1;
                }else {
                    succ = 0;
                    msg = "用户名或密码输出错误";
                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {

        }
        //3.返回结果
        HashMap<String,Object> result = new HashMap<>();
        result.put("succ",succ);
        result.put("msg",msg);
        ResultJSONUtils.write(response,result);
    }


}
