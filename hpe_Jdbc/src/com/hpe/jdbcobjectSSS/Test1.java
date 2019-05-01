package com.hpe.jdbcobjectSSS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * 	批量操作数据
 */
public class Test1 {
	public static void main(String[] args) {
		int pid = 5;
		String pname = "华为";
		double pprice = 2500;
		String pdesc = "666";
		int pcount = 100;
		myAdd(pid,pname,pprice,pdesc,pcount);
	}

	public static void myAdd(int pid,String pname,double pprice,String pdesc,int pcount) {
		//加载mysql的驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//连接数据库
		String url = "jdbc:mysql://127.0.0.1:3306/productorder";//资源路径
		String user = "root";//连接数据库账号
		String password = "123456";//连接数据密码
		try {
			Connection conn = DriverManager.getConnection(url, user, password);//获得连接
			
			//插入数据
			String sql = "insert into product_copy(pid,pname,pprice,pdesc,pcount) values(?,?,?,?,?)";
			
			//预处理对象
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < 3; i++) {
				ps.setInt(1, i);
				ps.setString(2, pname);
				ps.setDouble(3, pprice);
				ps.setString(4, pdesc);
				ps.setInt(5, pcount);
				ps.addBatch();
			}
			int[] result = ps.executeBatch();
			System.out.println(result);
		
			//修改数据
				//同上
			
			//删除数据
				//同上
			
			//关闭资源
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
