package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import model.Member;

public class UserDAOImpl extends Database implements UserDAO{
 
	@Override
	public Member getUserByAccount(String account, String password) {
		Member member = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sql = "SELECT * FROM MEMBER WHERE account = ? AND password = ?";
			
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setAccount(rs.getString("account"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setCash(rs.getBigDecimal("cash"));
				member.setMType(rs.getString("m_type"));
			}

		} catch (Exception e) {
			System.out.println(e);;
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println(e2);;
			}
		}
		return member;
	}
	
	public Member getUser(String account) {
		Member member = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sql = "SELECT * FROM MEMBER WHERE account = ?";
			
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setAccount(rs.getString("account"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setCash(rs.getBigDecimal("cash"));
				member.setMType(rs.getString("m_type"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return member;
	}
	
	@Override
	public int createOrUpdateUser(Member member) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			connection = getConnection();

			int id = getMaxId();

			StringBuffer sql = new StringBuffer();
			sql.append(" INSERT ");
			sql.append(" INTO MEMBER ");
			sql.append("   ( ");
			sql.append("     id, ");
			sql.append("     account, ");
			sql.append("     password, ");
			sql.append("     email, ");
			sql.append("     cash, ");
			sql.append("     create_date, ");
			sql.append("     m_type ");
			sql.append("   ) ");
			sql.append("   VALUES ");
			sql.append("   ( ");
			sql.append("     ?, ");
			sql.append("     ?, ");
			sql.append("     ?, ");
			sql.append("     ?, ");
			sql.append("     ?, ");
			sql.append("     ?, ");
			sql.append("     ? ");
			sql.append("   ) ");

			ps = connection.prepareStatement(sql.toString());
			ps.setInt(1, id);
			ps.setString(2, member.getAccount());
			ps.setString(3, member.getPassword());
			ps.setString(4, member.getEmail());
			ps.setInt(5, 0);
			ps.setTimestamp(6, new Timestamp(new Date().getTime()));
			ps.setString(7, member.getMType());

			result = ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	

	public int getMaxId(){
		int id = 1;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select max(id) from MEMBER";
			
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()){
				id = rs.getInt(1) + 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}

	public Member getAllUser(String account) {
		Member member = null;
		Connection connection = null ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String sql = "SELECT * FROM member where account = ?";

			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setAccount(rs.getString("account"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setCash(rs.getBigDecimal("cash"));
				member.setMType(rs.getString("m_type"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return member;

	}

	public int updatePassword(String account,String password,String email) {
		int isSuccess = 0;
		System.out.println("開始修改密碼");
		Connection connection = null ;
		PreparedStatement ps = null;
		try {
			String sql = "update member set password =?where account =? and email =?";
			
			System.out.println("update member set password =?where account =? and email =?" );
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, account);
			ps.setString(3, email);
			
			isSuccess = ps.executeUpdate();
			
			System.out.println("密碼變更完成 : " + isSuccess);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return isSuccess;
	}
	
	
	public boolean checkUser(String account) {
		boolean check = false;
		Connection connection = null ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String sql = "SELECT * FROM member where account = ?";
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				check = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
}