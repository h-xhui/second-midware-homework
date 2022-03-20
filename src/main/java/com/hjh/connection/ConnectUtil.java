package com.hjh.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {

    private static String url = "jdbc:mysql://localhost:3306/stu_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";

    private static String username = "root";

    private static String password = "root166";

    private static String driver = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
