package cc.procon;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

/**
 * jdbc工具类
 *
 * @author procon
 * @since 2022-12-15
 */
@Slf4j
public class DbUtils {
    private static String url ;
    private static String password;
    private static String user;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Properties properties = new Properties();
            //getResourceAsStream：读取文件，在JavaSE和javaWeb中都可以用，注意路径问题
            final InputStream is = DbUtils.class.getResourceAsStream("/mysql.properties");
            properties.load(is);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            if(Objects.nonNull(is)){
                is.close();
            }
        } catch (Exception e) {
            log.error("获取jdbc配置异常",e);
        }
    }


    /**
     * 获取连接
     *
     * @return 连接信息
     * @throws SQLException sqlException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     *
     * @param rs 结果集合
     * @param stmt 执行语句
     * @param conn 连接信息
     */
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            log.error(e.getMessage(),e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                log.error(e.getMessage(),e);
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    log.error(e.getMessage(),e);
                }
            }
        }
    }


    public static void main(String[] args) throws SQLException {
        final Connection conn = getConnection();
        log.error("连接信息--{}",conn);
    }
}
