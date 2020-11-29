package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exaeption.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/servlet_blog?user=root&password=&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static final DataSource DS = new MysqlDataSource();

    static {
        ((MysqlDataSource)DS).setUrl(URL);
    }
    public static Connection getConnection() {
        try {
             return DS.getConnection();
        } catch (SQLException e) {
            throw new AppException("获取数据库连接失败",e);
        }
    }
}
