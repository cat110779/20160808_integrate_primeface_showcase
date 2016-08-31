package org.greenpeace.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.greenpeace.bean.Deposit;

public class DepositDAO extends Database {

    public List<Deposit> queryByMemberAccount(String account){
    	
    	List<Deposit> list = new ArrayList<Deposit>();
    	Connection connection = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
		try {
			//where member_id = ?
			String sql = "select * from deposit where member_account = ? order by deposit_time desc";//sql語法抓出member_id 
			
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();
			while (rs.next()) {
				Deposit deposit = new Deposit();
				deposit.setId(rs.getInt("id"));
				deposit.setDepositCash(rs.getInt("deposit_cash"));
				deposit.setDepositTime(rs.getTimestamp("deposit_time"));
				deposit.setMemberAccount(rs.getString("member_account"));
				list.add(deposit);
			}

		} catch (Exception e) {
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
		return list;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for(int i = 0 ; i < list.size() ; i++){
			String str = list.get(i);
			System.out.println(str);
		}
	}

}
