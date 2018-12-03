package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBHelper {
    private static Connection connection = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单条语句的增删改   说明:在执行成功后函数返回的结果为非零整数
     * @param sql    需要执行的sql语句
     * @param params 执行sql语句的参数
     * @return
     */
    public int doUpdate(String sql, List<Object> params) {
        int result = 0;
        Connection connection = getConnection();
        try {
            ps = connection.prepareStatement(sql);
            this.setParams(ps, params);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭所有对象
            this.closeAll(connection, ps, rs);
        }

        return result;
    }

    /**
     * 多条语句的增删改     说明:执行事务
     * @param sqls   多条sql语句
     * @param params 执行参数
     * @return
     */
    public int doUpdate(List<String> sqls, List<Object> params) {
        int result = 0; //获取连接
        connection = getConnection();
        try {
            //多条语句的执行涉及到事务    设置事务提交方式为手动
            connection.setAutoCommit(false);
            //判断sql语句集合
            if (sqls != null && sqls.size() > 0) {
                //循环每一条语句执行
                for (int i = 0; i < sqls.size(); i++) {
                    ps = connection.prepareStatement(sqls.get(i));
                    //设置参数
                    ps.setObject(i + 1, params.get(i));
                    //执行并反馈
                    result = ps.executeUpdate();
                }
            } //手动提交数据
            connection.commit();
        } catch (SQLException e) { //出现错误则回滚数据
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //回复事务自动提交
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //关闭所有对象
            this.closeAll(connection, ps, rs);
        }
        return result;
    }

    /**
     * 查询sql语句单条结果
     *
     * @param sql             查询的sql语句
     * @param  params 执行sql所需参数
     * @return
     */
    public static Map<String, Object> findSingleObject(String sql, List<Object> params) {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取连接
        connection = getConnection();
        //预处理
        try {
            ps = connection.prepareStatement(sql);
            //设置参数
            setParams(ps, params);
            //执行查询得到结果集
            rs = ps.executeQuery();
            //获取数据库该表所有字段名
            List<String> names = getAllColumnName(rs);
            if (rs.next()) {
                //循环 names
                for (String name : names) {
                    map.put(name, rs.getObject(name));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭对象
            closeAll(connection, ps, rs);
        }
        return map;
    }


    //获取连接对象
    public static Connection getConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/dang?userUnicode=true&characterEncoding=utf8";

        try {
            con = DriverManager.getConnection(url, "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭所有对象  连接  预处理  结果集
    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 设置预处理的参数
     *
     * @param ps     预处理
     * @param params 参数集合
     * @throws SQLException
     */
    public static void setParams(PreparedStatement ps, List<Object> params) throws SQLException {
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
        }
    }

    /**
     * 根据结果集获取数据库中的所有列表名
     *
     * @param rs
     * @return
     */
    private static List<String> getAllColumnName(ResultSet rs) {
        List<String> names = new ArrayList<String>();
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                names.add(rsmd.getColumnName(i + 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }


}
