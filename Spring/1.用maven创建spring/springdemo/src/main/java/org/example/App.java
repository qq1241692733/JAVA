package org.example;

import org.example.controller.LoginController;
import org.example.controller.URLController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-06-2021/6/9
 * Time: 22:21
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        LoginController loginController = (LoginController) context.getBean("loginController");
        System.out.println(loginController);

        // 首字母小写，第二个字母也大写的时候不用
        URLController urlController =
                (URLController) context.getBean("URLController");
        System.out.println(urlController);

        LoginController loginController1 =
                context.getBean(LoginController.class);
        System.out.println(loginController1.getClass() == loginController.getClass());
        
        // 关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }
}
