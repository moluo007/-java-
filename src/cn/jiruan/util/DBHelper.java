package cn.jiruan.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//数据库处理工具类
public class DBHelper {
    @SuppressWarnings("all")
    //建立连接
    public static Connection getConnection() {
        Connection con = null;
        try{
            //1.手动添加数据库驱动类：
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获得数据库连接对象：
            String url = "jdbc:mysql://127.0.0.1:3306/warhousesystem?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "123456";
//            System.out.println("正在连接数据库: " + url);
            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
//                System.out.println("数据库连接成功！");
            }
        }catch(Exception e){
            System.err.println("数据库连接失败！错误信息：");
            e.printStackTrace();
            System.err.println("请检查：");
            System.err.println("1. MySQL服务是否启动");
            System.err.println("2. 数据库jiruan是否存在");
            System.err.println("3. 用户名密码是否正确");
            System.err.println("4. 端口3306是否开放");
        }
        return con;
    }

    //测试数据库连接和查询
    public static void testDatabaseConnection() {
        System.out.println("=== 数据库连接测试 ===");
        Connection con = getConnection();
        if (con != null) {
            try {
                // 测试查询warehouse表
                String sql = "SELECT COUNT(*) FROM warehouse";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int count = rs.getInt(1);
                    System.out.println("warehouse表中共有 " + count + " 条记录");
                }
                
                // 测试查询warehouse表结构
                sql = "DESCRIBE warehouse";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                System.out.println("warehouse表结构：");
                while (rs.next()) {
                    String field = rs.getString("Field");
                    String type = rs.getString("Type");
                    String key = rs.getString("Key");
                    System.out.println("  " + field + " (" + type + ") " + key);
                }
                
                rs.close();
                ps.close();
            } catch (Exception e) {
                System.err.println("查询测试失败：" + e.getMessage());
                e.printStackTrace();
            } finally {
                closeAll(con, null, null);
            }
        }
        System.out.println("=== 测试完成 ===");
    }

    //通用 增 - 删 - 改
    @SuppressWarnings("all")
    public static int   currencySqlUpdate(String sql,Object... objs){
        Connection con = getConnection();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            for(int i = 1; i <= objs.length; i++){
                ps.setObject(i,objs[i-1]);
            }
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeAll(con,ps,null);
        }
        return 0;
    }

    //通用返回集合的查询
    public static ArrayList<Object> currencySqlQuery(Class cla, String sql, Object... objs){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Object> backList = new ArrayList<>();
        try{
            con = getConnection();
            ps = con.prepareStatement(sql);
            for(int i = 1; i <= objs.length; i++){
                ps.setObject(i,objs[i-1]);
            }
            rs = ps.executeQuery();
            Field[] fields = cla.getDeclaredFields();
            while(rs.next()){
                Object o = cla.newInstance();
                for(Field field : fields){
                    field.setAccessible(true);
                    field.set(o,rs.getObject(field.getName()));  //把对应索引的对应属性的值
                }
                backList.add(o);  //对应数组获得class的一系列对象，对象中有对应属性
            }
            return backList;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeAll(con,ps,rs);
        }
        return null;
    }
    //通用返回数量的查询
    public static Integer currencySqlQuery(String sql, Object... objs){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer backInteger = null;
        try{
            con =  getConnection();
            ps = con.prepareStatement(sql);
            for(int i = 1; i <= objs.length; i++){
                ps.setObject(i,objs[i-1]);
            }
            rs = ps.executeQuery();
            return  rs.next() ? rs.getInt(1) : 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll(con,ps,rs);
        }
        return 0;
    }


    //资源关闭
    @SuppressWarnings("all")
    public static void closeAll(Connection con,PreparedStatement ps,ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
