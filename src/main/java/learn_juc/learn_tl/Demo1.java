package learn_juc.learn_tl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ThreadLocal思想：线程隔离
 * 解决的问题：
 * 主要的原理：
 * 内存泄露原因，如何解决
 * 应用场景：session管理，事务管理，数据库连接管理
 */
public class Demo1 {
}

class ConnectionManager1{
    //多个线程共享一个connection（类变量），存在线程安全问题
    private static Connection connection = null;

    public static Connection openConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("url");
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        if(connection != null){
            connection.close();
        }
    }
}

class ConnectionManager2{
    //各个线程独享一个connection（实例变量），不存在线程安全问题
    //存在问题：每个线程都会创建一个connection，频繁创建和销毁connection，浪费资源
    private Connection connection = null;

    public Connection openConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("url");
        }
        return connection;
    }
    public void closeConnection() throws SQLException {
        if(connection != null){
            connection.close();
        }
    }
}

class ConnectionManager3{
    //一次初始化
    static String url;
    public ConnectionManager3(String url){
        this.url = url;
    }
    private static final ThreadLocal<Connection> dbConnectionThreadLocal = new ThreadLocal<Connection>(){
        @Override
        protected Connection initialValue() {
            try {
                //设置threadlocal里面包的初值
                return DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public static Connection openConnection(){
        return dbConnectionThreadLocal.get();
    }
}
