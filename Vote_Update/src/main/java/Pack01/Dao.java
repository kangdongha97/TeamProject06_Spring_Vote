package Pack01;

import java.sql.*;
import java.util.LinkedList;

import org.springframework.ui.Model;


public class Dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	public ResultSet rs = null;
	
	public void userCheck(String uname, String utel) {
		try {
			connect();
			String sql = String.format(
					"select count(*) from userinfo where uname ='%s', utel='%s', vote=false;",
					uname, utel);

			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void vote(User user) {
		try {
			System.out.println("찍은사람");
			String candi = user.getCandi();
			System.out.println(candi);
			
			connect();
//			String sql = String.format(
//					"update userinfo set check = true where uname ='%s', utel='%s';",
//					user.uname, user.utel);
			
			//String sql1 = String.format("insert into election %s;",	user.num);
			String sql2 = String.format("select vote from election where candi = '%s';", user.getCandi());
			System.out.println(sql2);
			
			
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			rs.next();
			int ss = Integer.parseInt(rs.getString(1));
			System.out.println(ss);
			
			
			String sql3 = String.format("update election set vote = '%d' where candi = '%s';", ++ss, user.getCandi());
			System.out.println(sql3);
			pstmt = conn.prepareStatement(sql3);
			pstmt.executeUpdate();
			
			
			//pstmt = conn.prepareStatement(sql1);
			//pstmt.executeUpdate();
			
			
			close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LinkedList<String> result() {
		LinkedList<String> mm = new LinkedList<String>();
		try {
			
			connect();
			String sql4 = "select * from election;";
			
			pstmt = conn.prepareStatement(sql4);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String candi = rs.getString(1);
				String vote = rs.getString(2);
				
				System.out.println(candi);
				System.out.println(vote);
				
				mm.add(candi + " : " + vote);
				
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mm;
	}
	
	
	void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//String url = "jdbc:mysql://118.38.27.198:7777/db01";
			String url = "jdbc:mysql://localhost:3306/db02";
			//conn = DriverManager.getConnection(url, "gang", "1234");
			conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("연결 성공");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

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