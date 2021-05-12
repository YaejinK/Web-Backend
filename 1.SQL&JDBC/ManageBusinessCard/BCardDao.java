package kr.or.connect.jdbcbusiness.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import kr.or.connect.jdbcbusiness.dto.BCard;

public class BCardDao {
  private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
  private static String dbUser = "connectuser";
  private static String dbpasswd = "connect123!@#";
  
  public List<BCard> getBCards(String name){
	List<BCard> list = new ArrayList<>();

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	}

	String sql = "SELECT name, pnum, company FROM bcard WHERE name like '%?%'";
	try (Connection conn = DriverManager.getConnection(dburl, dbUser,dbpasswd);
			PreparedStatement ps = conn.prepareStatement(sql)){
		try (ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				String fname = rs.getString(1); //find name
				String pnum = rs.getString(2);
				String company = rs.getString(3);
				BCard bcard = new BCard(fname, pnum, company);
				list.add(bcard);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return list;
}

public void addBCard(BCard bcard) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

	String sql = "INSERT INTO bcard (name, pnum, company) VALUES (?,?,?)";

	try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			PreparedStatement ps = conn.prepareStatement(sql)) {
		ps.setString(1, bcard.getName());
		ps.setString(2, bcard.getPnum());
		ps.setString(3, bcard.getCompany());
	}catch(Exception ex) {
		ex.printStackTrace();
	}
}

public BCard getBCard(String name) {
	BCard bcard = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try { //예외처리
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		String sql = "SELECT name, pnum, company FROM bcard WHERE name like '%?%'";
		ps = conn.prepareStatement(sql);
		ps.setString(1,name);
		rs = ps.executeQuery();

		if (rs.next()) {
			String fname = rs.getString(1); //description
			String fpnum = rs.getString(2); //2
			String fcompany = rs.getString(3);
			bcard = new BCard(fname,fpnum, fcompany);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally { //반드시 수행됨
		if (rs != null) {
			try {
				rs.close();
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
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	return bcard;
}
