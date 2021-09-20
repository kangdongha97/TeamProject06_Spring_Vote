package Pack01;

import java.sql.*;
import org.springframework.ui.Model;
import Pack01.ConnectionMaker;
import Pack01.UserConnection;

public class Dao {
	Connection conn = null;
	ConnectionMaker c = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	Model model;
	
	public Dao() {
		this.c = new UserConnection();
	}
	
	public String userCheck(String uname, Integer utel) {
		System.out.println(uname);
		String match = "0";
		try {
			conn = c.connect();
			String sql = String.format(
					"select count(*) as cnt from userinfo where uname ='%s' and utel='%d' and vote=false;",
					uname, utel);
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			
			if (result.next()) {
				match = result.getString("cnt");
			}
			close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return match;
	}
	
	public void vote(String uname, Integer utel, Integer num) {
		try {
			conn = c.connect();
			System.out.println(uname);
			String sql = String.format(
					"update userinfo set vote = true where uname ='%s' and utel='%d';",
					uname, utel);
			String sql1 = String.format(
					"insert into election values(%d);",
					num);
			System.out.println(sql);
			System.out.println(sql1);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * void connect() { try { Class.forName("com.mysql.jdbc.Driver"); String url =
	 * "jdbc:mysql://localhost:3306/db01"; conn = DriverManager.getConnection(url,
	 * "root", "1234");
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } catch
	 * (ClassNotFoundException e) { e.printStackTrace(); } }
	 */

	void close() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if (result != null && !result.isClosed()) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}