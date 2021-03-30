package org.example;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
    //1.获取DataSource
        MysqlDataSource dataSource = new MysqlDataSource();
        //.url,user,password
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/maven?charactionEncoding=utf8");
        dataSource.setUser("root");
        dataSource.setPassword("jhy1241692733");
    //2.获取connection
        Connection connection = dataSource.getConnection();
    //3.拼接SQL
        String sql = "select * from student where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,2);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
            System.out.println("查询数据name:" + resultSet.getString("name"));
        }
    }
}
