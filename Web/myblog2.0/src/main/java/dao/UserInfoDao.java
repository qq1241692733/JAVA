package dao;

import models.UserInfo;
import utils.DBUtils;
import utils.ResultJSONUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/7
 * Time: 17:49
 */
public class UserInfoDao {
    //1.注册
    public int add(String username, String password) throws SQLException {
        int result = 0;
        Connection connection = DBUtils.getConnection();
        String sql = "insert into userinfo(username,password) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        result = statement.executeUpdate();
        return result;
    }

    /**
     * 使用JDBC连接数据库需要4步：
     1、加载驱动程序；
     2、连接数据库；
     3、访问数据库；
     4、执行查询；要用statement类的executeQuery()方法来下达select指令以查询数据库，
     executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用。
     即语句：ResultSet rs=s.executeQuery(sql);
     */
    //2.登录
    public UserInfo getUser(String username, String password) throws SQLException {
        Connection connection = DBUtils.getConnection();
        String sql = "select * from userinfo where username = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        UserInfo userInfo = new UserInfo();
        while (resultSet.next()) {
            userInfo.setId(resultSet.getInt("id"));
            userInfo.setUsername(resultSet.getString("username"));
            userInfo.setPassword(resultSet.getString("password"));
        }
        DBUtils.close(connection,statement,resultSet);
        return userInfo;
    }
}
