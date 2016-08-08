package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;

import model.Order;
import model.OrderSuper;

public class OrderDAO extends Database{
	Connection conn = null;	
	Statement stmt = null;
	PreparedStatement ps = null; 
	ResultSet rs = null;
	String sql = "";
	
	public void insertOrder(Order o){
		try {
			conn = getConnection();
			sql = "insert into orders values(null,?,?,?,?,?,'進行中',?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,o.getRestaurantId());
			ps.setTimestamp(2, o.getBeginTime());
			ps.setTimestamp(3, o.getEndTime());
			ps.setInt(4,o.getEndMoney());
			ps.setString(5,o.getMemberAccount());
			ps.setString(6,o.getInfo());
			ps.setString(7,o.getRestaurantName());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot Insert Order");
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public int getMaxId(){
		int result = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			sql = "select max(id) from orders";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		return result;
	}
	
	public List<Order> getOrderByAccount(String account){
		    List<Order>oList = null;
		try {
			oList = new ArrayList<Order>();
			Order o = null;
			sql = "select * from orders where member_account = ? order by begin_time desc";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();
			while(rs.next()){
				o = new Order();
				o.setMemberAccount(rs.getString("member_account"));
				o.setId(rs.getInt("id"));
				o.setEndMoney(rs.getInt("end_money"));
				o.setEndTime(rs.getTimestamp("end_time"));
				o.setInfo(rs.getString("info"));
				//o.setMoney(rs.getInt("money"));
				o.setRestaurantId(rs.getInt("restaurant_id"));
				o.setRestaurantName(rs.getString("restaurant_Name"));
				o.setStatus(rs.getString("status"));
				o.setBeginTime(rs.getTimestamp("begin_time"));
				oList.add(o);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception getOrderByAccount");
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			return oList;
	}
	
	public List<Order> getAllOrder(){
	    List<Order>oList = null;
		try {
			oList = new ArrayList<Order>();
			Order o = null;
			//sql = "select * from orders order by END_TIME,MEMBER_ACCOUNT";
			sql = "select (select sum(money) from customer where order_id = o.id) as money,o.id, o.status as o_status, o.info, o.restaurant_id, o.restaurant_name, o.end_time,o.end_money,o.MEMBER_ACCOUNT,o.STATUS,r.PHONE from orders o, restaurant r where o.RESTAURANT_ID = r.id";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				o = new Order();
				o.setId(rs.getInt("id"));
				o.setMemberAccount(rs.getString("member_account"));
				o.setStatus(rs.getString("o_status"));
				o.setEndMoney(rs.getInt("end_money"));
				o.setEndTime(rs.getTimestamp("end_time"));
				o.setInfo(rs.getString("info"));
				o.setMoney(rs.getInt("money"));
				o.setRestaurantId(rs.getInt("restaurant_id"));
				o.setRestaurantName(rs.getString("restaurant_Name"));
				o.setRestaurantPhone(rs.getString("phone"));
				oList.add(o);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception getAllOrder()");
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			return oList;
	}
	
	public List<Order> getAllOrderByStatus(){
	    List<Order>oList = null;
		try {
			oList = new ArrayList<Order>();
			Order o = null;
			//sql = "select * from orders order by END_TIME,MEMBER_ACCOUNT";
			sql = "select (select sum(money) from customer where order_id = o.id) as money,o.id, o.status as o_status, o.info, o.restaurant_id, o.restaurant_name, o.end_time,o.end_money,o.MEMBER_ACCOUNT,o.STATUS,r.PHONE from orders o, restaurant r where o.RESTAURANT_ID = r.id and o.status not in ('已截止','已結單') order by o.status, o.begin_time";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				o = new Order();
				o.setId(rs.getInt("id"));
				o.setMemberAccount(rs.getString("member_account"));
				o.setStatus(rs.getString("o_status"));
				o.setEndMoney(rs.getInt("end_money"));
				o.setEndTime(rs.getTimestamp("end_time"));
				o.setInfo(rs.getString("info"));
				o.setMoney(rs.getInt("money"));
				o.setRestaurantId(rs.getInt("restaurant_id"));
				o.setRestaurantName(rs.getString("restaurant_Name"));
				o.setRestaurantPhone(rs.getString("phone"));
				oList.add(o);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception getAllOrder()");
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			return oList;
	}
	
	public List<Order> getOnGoingOrder(){
	    List<Order>oList = null;
		try {
			oList = new ArrayList<Order>();
			Order o = null;
			//sql = "select * from orders order by END_TIME,MEMBER_ACCOUNT";
			sql = "select (select sum(money) from customer where order_id = o.id) as money, r.r_type, o.id, o.info, o.restaurant_id, o.restaurant_name, o.end_time,o.end_money,o.MEMBER_ACCOUNT,o.STATUS,r.PHONE from orders o, restaurant r where o.RESTAURANT_ID = r.id and o.status ='進行中' ";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				o = new Order();
				o.setId(rs.getInt("id"));
				o.setRtype(rs.getString("r_type"));
				o.setMemberAccount(rs.getString("member_account"));
				o.setEndMoney(rs.getInt("end_money"));
				o.setEndTime(rs.getTimestamp("end_time"));
				o.setInfo(rs.getString("info"));
				o.setMoney(rs.getInt("money"));
				o.setRestaurantId(rs.getInt("restaurant_id"));
				o.setRestaurantName(rs.getString("restaurant_Name"));
				o.setRestaurantPhone(rs.getString("phone"));
				oList.add(o);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception getAllOrder()");
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			return oList;
	}
	
	
	public Order getOrderById(int id){
	    Order o = null;
		try {
			o = new Order();
			sql = "select (select sum(money) from customer where order_id = o.id) as money, member_account, id, end_money, end_time, info, restaurant_id, restaurant_Name from orders o where id = ?";
			conn =getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				o = new Order();
				o.setMemberAccount(rs.getString("member_account"));
				o.setId(rs.getInt("id"));
				o.setEndMoney(rs.getInt("end_money"));
				o.setEndTime(rs.getTimestamp("end_time"));
				o.setInfo(rs.getString("info"));
				o.setMoney(rs.getInt("money"));
				o.setRestaurantId(rs.getInt("restaurant_id"));
				o.setRestaurantName(rs.getString("restaurant_Name"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception getOrderByAccount");
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			return o;
	}
	
	public void updateOrder(Order o){
		try {
			conn =getConnection();
			sql = "update orders "
					+ "set end_time = ?,"
					+"end_money = ?,"
					+"info = ?"
					+ "where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, o.getEndTime());
			ps.setInt(2,o.getEndMoney());
			ps.setString(3,o.getInfo());
			ps.setInt(4,o.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot Update Order");
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public List<OrderSuper> queryOrderList(String ac) {

		List<OrderSuper> list = new ArrayList<OrderSuper>();
		Connection connection = null;
		try {
		connection = getConnection();
		String sql = "select o.id id ,o.member_account account,m.join_date begin_time,o.restaurant_name name,o.status status from m_order m, orders o  where m.MEMBER_ACCOUNT=? and m.ORDER_ID = o.id order by m.join_date desc";
			/*
		String sql = " select o.id id ,"
				    + "o.MEMBER_ACCOUNT account,"
				    + "(select max(c_date) from CUSTOMER where member_id = (select id from member where account = ?)) as begin_time,"
					+ "o.restaurant_name name,"
					+ "o.status status"
					+"from m_order m, orders o" 
					+"where m.MEMBER_ACCOUNT=? and m.ORDER_ID = o.id";
			*/
			System.out.println("=========== SQL log =============");
			System.out.println("Class : OrderDAO");
			System.out.println("Method : queryOrderList");
			System.out.println("SQL : " + sql);
			System.out.println("=================================");
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, ac);
			rs = ps.executeQuery();
			while (rs.next()) {

				int order_id = rs.getInt("id"); //訂單編號
				String account = rs.getString("account"); //發起人
				Date c_date = rs.getTimestamp("begin_time"); //下定日期
				String restaurant_name = rs.getString("name"); //下定店家
				String status = rs.getString("status"); //訂單狀態
				
				OrderSuper order = new OrderSuper();
				order.setId(order_id);
				order.setOrder_member(account);

				if(c_date != null){
					order.setOrder_date(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(c_date));
					//System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm").format(c_date)));
				}
				
				order.setRestaurant_name(restaurant_name);
				order.setStatus(status);
				
				list.add(order);
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
	
	public void updateStatusByOrderId(String status ,int oId){
		sql = "update orders set status = ? where id = ?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,status);
			ps.setInt(2, oId);
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
/*	
	public void updateStatusByTime(String status ,int oId){
		sql = "update orders set status = ? where id = ?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,status);
			ps.setInt(2, oId);
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
	}*/

}
