package utils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
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
 * Time: 17:50
 */
public class DBUtils {
    private static MysqlDataSource dataSource = null;

    /**得到 Connection 的通用方法
     */
    public static Connection getConnection () throws SQLException {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            //本地:
            //dataSource.setURL("jdbc:mysql://127.0.0.1:3306/myblog?characterEncoding=utf-8&useSSL=true");
            //服务器:没有&useSSL=true
            dataSource.setURL("jdbc:mysql://127.0.0.1:3306/myblog?characterEncoding=utf-8");
            dataSource.setUser("root");
            dataSource.setPassword("jhy1241692733");
        }
        return dataSource.getConnection();
    }

    /**
     * 通用的关闭方法
     */
    public static void close(Connection connection, PreparedStatement statement,ResultSet resultSet) throws SQLException {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
}
