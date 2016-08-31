package org.greenpeace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class MemberOrderDAO extends Database {
	
	public void insert(String account, int oId, Timestamp ts){
		Connection conn = null;	
		PreparedStatement ps = null; 
		String sql = "";
		try {
			conn = getConnection();
			sql = "insert into m_order values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setInt(2, oId);
			ps.setTimestamp(3, ts);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
