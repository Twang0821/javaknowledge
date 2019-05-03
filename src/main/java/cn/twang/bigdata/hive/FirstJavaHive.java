package cn.twang.bigdata.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 第一个用java客户端操作Hive的展示
 * @author 70973
 * @date 2018年3月25日下午11:49:12
 */
public class FirstJavaHive 
{
	//
	private static String driverName = "org.apache.hive.jdbc.HiveDriver"; 
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        try {  
            Class.forName(driverName);  
            Connection con = null;  
            con = DriverManager.getConnection("jdbc:hive2://192.168.184.81:10000/comm_data", "hive", "");  
            Statement stmt = con.createStatement();  
            ResultSet res = null;  
            String sql = "select * from student";  
            System.out.println("Running: " + sql);  
            res = stmt.executeQuery(sql);  
            System.out.println("ok");  
            while (res.next()) {  
                System.out.println(res.getString(1) + "\t" + res.getString(2) + "\t" +  res.getString(3) + "\t" +  res.getString(4));  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println("error");  
        }  
        
    }
}
