package services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/4
 * Time: 17:58
 */
public class MyArtListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int state = -1;
        String mag = "";

        // 1.权限验证 -> uid
        HttpSession session = request.getSession(false);
        if (session == null ||
            session.getAttribute("userinfo") == null) {
            //用户登录
            state = 100;
            mag = "当前用户未登录";
        }else {
            //查询个人文章列表

        }



        // 2.去数据库查询列表信息


        // 3.返回信息

    }
}
