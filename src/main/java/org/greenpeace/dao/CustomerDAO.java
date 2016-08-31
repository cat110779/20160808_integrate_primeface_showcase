package org.greenpeace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.greenpeace.bean.Customer;
import org.greenpeace.bean.CustomerSuper;

public class CustomerDAO extends Database {

	
/*
	public List<CustomerSuper> queryCustomerList(int memberId) {

			List<CustomerSuper> list = new ArrayList<CustomerSuper>();
			Connection connection = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
//				String sql = "select * from CUSTOMER where member_id = ?";
				
				String sql = " select ";
				sql += " 	c.counts, c.c_date, p.name, p.price ";
				sql += " from ";
				sql += " 	customer c ";
				sql += " join ";
				sql += " 	item i ";
				sql += " on  ";
				sql += " 	c.item_id = i.id ";
				sql += " join ";
				sql += " 	product p ";
				sql += " on  ";
				sql += " 	i.product_id = p.id ";
				sql += " where ";
				sql += " 	c.member_id = ? ";

				System.out.println("=========== SQL log =============");
				System.out.println("Class : CustomerDAO");
				System.out.println("Method : queryCustomerList");
				System.out.println("SQL : " + sql);
				System.out.println("=================================");
				
				connection = getConnection();
				ps = connection.prepareStatement(sql);
				ps.setInt(1, memberId);
				rs = ps.executeQuery();
				while (rs.next()) {

					String product_name = rs.getString("name"); //產品名稱
					int counts = rs.getInt("counts"); //購買數量
					int price = rs.getInt("price"); //餐點金額
					Date c_date = rs.getTimestamp("c_date"); //消費日期
					System.out.println(c_date);
					System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(c_date));
					CustomerSuper customer = new CustomerSuper();
					customer.setProduct_name(product_name);
					customer.setCounts(counts);
					customer.setMoney(counts * price);
					if(c_date != null){
						customer.setConsume_date(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(c_date));	
					}
					list.add(customer);
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
*/
	public List<CustomerSuper> queryCustomerList(String account) {

		List<CustomerSuper> list = new ArrayList<CustomerSuper>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
//			String sql = "select * from CUSTOMER where member_id = ?";
			
			String sql = " select ";
			sql += " 	c.counts, c.c_date, p.name, p.price ";
			sql += " from ";
			sql += " 	customer c ";
			sql += " join ";
			sql += " 	item i ";
			sql += " on  ";
			sql += " 	c.item_id = i.id ";
			sql += " join ";
			sql += " 	product p ";
			sql += " on  ";
			sql += " 	i.product_id = p.id ";
			sql += " where ";
			sql += " 	c.member_account = ?  order by c.c_date desc";

			System.out.println("=========== SQL log =============");
			System.out.println("Class : CustomerDAO");
			System.out.println("Method : queryCustomerList");
			System.out.println("SQL : " + sql);
			System.out.println("=================================");
			
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();
			while (rs.next()) {
				String product_name = rs.getString("name"); //產品名稱
				int counts = rs.getInt("counts"); //購買數量
				int price = rs.getInt("price"); //餐點金額
				Date c_date = rs.getTimestamp("c_date"); //消費日期
				CustomerSuper customer = new CustomerSuper();
				customer.setProduct_name(product_name);
				customer.setCounts(counts);
				customer.setMoney(counts * price);
				if(c_date != null){
					customer.setConsume_date(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(c_date));	
				}
				list.add(customer);
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
	
	public List<Customer> queryAllCustomer() {
		
		List<Customer> cList = new ArrayList<Customer>();
		Connection conn = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select c.id c_id , o.id order_id,i.PRODUCT_NAME , p.PRICE , c.COUNTS,  c.counts*p.price as money, c.MEMBER_ACCOUNT, c.status"
					 +" from orders o,item i,customer c, product p" 
					 +" where o.id = i.ORDER_ID and" 
					 +" i.id = c.ITEM_ID and" 
					 +" i.product_id = p.ID"
					 +" order by o.id ,c.member_account";
		Customer c = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				c = new Customer();
				//c.setId(rs.getInt("id"));
				//c.setCDate(rs.getTimestamp("c_date"));
				c.setCounts(rs.getInt("counts"));
				c.setMemberAccount(rs.getString("member_account"));
				c.setMoney(rs.getInt("money"));
				c.setOrderId(rs.getInt("order_id"));
				c.setItemName(rs.getString("product_name"));
				c.setItemPrice(rs.getInt("price"));
				c.setStatus(rs.getString("status"));
				c.setId(rs.getInt("c_id"));
				cList.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cList;
	}
	
	public int updateStatus(String[] orderAndId) {
	    int flag = 1;	
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update customer set status='已取餐' where order_id=? and id=?";
		String[] splitStr = new String[2];
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<orderAndId.length;i++){
				splitStr = orderAndId[i].split("_");
				ps.setInt(1,Integer.parseInt(splitStr[0]));
				ps.setString(2,splitStr[1]);
				ps.addBatch();
			}
			ps.executeBatch();

			
			sql = "select distinct c.status ,(select status from orders where id = c.order_id) as o_status"
				+ " from customer c" 
				+ " where order_id = ?"
				+ " and c.status='未取餐'"
				+ " or  (select status from orders where id = c.order_id) ='進行中'";
			
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(splitStr[0]));
			rs = ps.executeQuery();
			while(rs.next()){
				flag = 0;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

	public void createCustomer(Customer model){
		
		int results = 0;
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			
			//int id = getMaxId();
			//7
			StringBuffer sql = new StringBuffer();
			sql.append(" INSERT ");
			sql.append(" INTO CUSTOMER ");
			sql.append("   ( ");
			sql.append("     id, ");
			sql.append("     item_id, ");
			sql.append("     member_account, ");
			sql.append("     counts, ");
			sql.append("    money, ");
			sql.append("    c_date, ");
			sql.append("     status, ");
			sql.append("     order_id ");
			sql.append("   ) ");
			sql.append("   VALUES ");
			sql.append("   ( ");
			sql.append("     null, ");
			sql.append("     ?, ");
			sql.append("     ?, ");
			sql.append("     ?, ");
			sql.append("     ?, ");
			sql.append("     ?, ");
			sql.append("     ?, ");
			sql.append("     ? ");
			sql.append("   ) ");
			
			System.out.println("sql :" + sql.toString());
			
			ps = connection.prepareStatement(sql.toString());
			//ps.setInt(1, id);
			ps.setInt(1,(int)model.getItem().getId());
			ps.setString(2,model.getMember().getAccount());
			ps.setInt(3, model.getCounts());
			ps.setInt(4, model.getMoney());
			ps.setTimestamp(5, model.getCDate());
			ps.setString(6, model.getStatus());
			ps.setInt(7, model.getOrderId());
			results = ps.executeUpdate();
			System.out.println("訂單OK");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
	}
	
}
