package dao;



import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.Order;
import model.Start;

public class StartDAO extends Database {

    public List<Start> getOrderDatalist(int order_id){
    	
    	List<Start> list = new ArrayList<Start>();
    	Connection connection = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
		try {
			//where member_id = ?
			String sql = "select i.id as item_id, i.order_id, i.product_name,p.price from item i ,product p where i.order_id=? and i.product_id=p.id";//sql語法抓出member_id 
			
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1,order_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Start start = new Start();
				start.setItem_id(rs.getInt("item_id"));
				start.setOrder_id(rs.getInt("order_id"));
				start.setProduct_name(rs.getString("product_name"));
				start.setPrice(rs.getInt("price"));
			
				list.add(start);
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
    Connection conn = null;	
	Statement stmt = null;
	PreparedStatement ps = null; 
	ResultSet rs = null;
	String sql = "";




    public void updateCash(BigDecimal cash,String account){
		try {
			conn =getConnection();
			sql = "update member set cash=? where account=?";
			
			ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1,cash);
			ps.setString(2,account);	
		    ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新成功");
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
    }}
	