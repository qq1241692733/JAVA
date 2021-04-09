package services;

import com.sun.org.apache.bcel.internal.generic.NEW;
import models.UserInfo;
import dao.UserInfoDao;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/8
 * Time: 21:13
 */
public class MyLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ = -1;
        String msg = "";
        //1.获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //操作数据库
        if (username != null && !username.equals("")&&
                password != null && !password.equals("")) {
            // 查询数据库
            UserInfoDao userInfoDao = new UserInfoDao();

            try {
                UserInfo userInfo = userInfoDao.getUser(username,password);
                if (userInfo.getId() > 0) {
                    succ = 1;
                    HttpSession session = request.getSession();//创建会话
                    //将用户信息放到当前session
                    session.setAttribute("userinfo",userInfo);
                }else {
                    succ = 0;
                    msg = "用户名或密码输出错误!";
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            msg="非法请求,参数不完整";
        }
        //3.返回结果
        HashMap<String,Object> result = new HashMap<>();
        result.put("succ",succ);
        result.put("msg",msg);
        ResultJSONUtils.write(response,result);
    }
}
