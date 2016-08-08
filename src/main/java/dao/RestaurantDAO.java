package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Restaurant;

public class RestaurantDAO extends Database {
		Connection conn = null;	
		Statement stmt = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		String sql = "";
		
		public List<Restaurant> getAllRestaurant(){
			Restaurant r = null;
			List<Restaurant> rList = new ArrayList<Restaurant>(); 
			try {
				
				conn = getConnection();
				ps = conn.prepareStatement("select * from restaurant order by id");
				rs = ps.executeQuery();
				while(rs.next()){
					r = new Restaurant();
					r.setId(rs.getInt("id"));
					r.setAddr(rs.getString("addr"));
					r.setName(rs.getString("name"));
					r.setBrief(rs.getString("brief"));
					r.setPhone(rs.getString("phone"));
					r.setRType(rs.getString("r_type"));
					rList.add(r);
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
			
			return rList;
	}
		
		public Restaurant getRestaurantById(int id){
				Restaurant r = null;
				try {
					r = new Restaurant();
					conn = getConnection();
					ps = conn.prepareStatement("select * from restaurant where id = ?");
					ps.setInt(1, id);
					rs = ps.executeQuery();
					while(rs.next()){
						r.setId(rs.getInt("id"));
						r.setAddr(rs.getString("addr"));
						r.setName(rs.getString("name"));
						r.setBrief(rs.getString("brief"));
						r.setPhone(rs.getString("phone"));
						r.setRType(rs.getString("r_type"));
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
				
				return r;
		}
		
		
		public List<Restaurant> getRByType(String type){
			List<Restaurant> rList = new ArrayList<Restaurant>();
			Restaurant r;
			try {
				r = new Restaurant();
				conn = getConnection();
				sql = "select id, name from restaurant where r_type = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, type);
				rs = ps.executeQuery();
				while(rs.next()){
					r = new Restaurant();
					r.setId(rs.getInt(1));
					r.setName(rs.getString(2));
					rList.add(r);
				}
				
				return rList;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("rDAO getRByType");
			}finally{
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return null;
	}
		
		public  void addStore(Restaurant r){
			try {
				
				int serialNo = getSerialNo();
				
				conn = getConnection();
				ps = conn.prepareStatement("insert into restaurant values (?,?,?,?,?,?,null)");
				ps.setInt(1, serialNo);
				ps.setString(2, r.getName());
				ps.setString(3, r.getBrief());
				ps.setString(4, r.getAddr());
				ps.setString(5, r.getPhone());
				ps.setString(6, r.getRType());
				ps.execute();

				System.out.println(r.getName()+" "+r.getBrief());
				
				List<Product> list = r.getProducts();
				
				if(list != null && list.size() > 0){
					ProductDAO productDAO = new ProductDAO();
					productDAO.insertProductList(list, serialNo);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
		
		private int getSerialNo() throws Exception{
			int serialNo = 1;
			conn = getConnection();
			ps = conn.prepareStatement("select max(id) from restaurant ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				serialNo = rs.getInt(1) + 1;
			}
			return serialNo;
		}
		
		
		public boolean checkR(String phone){
			boolean f = true;
			try {
				conn = getConnection();
				sql = "select id, name from restaurant where phone = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, phone);
				rs = ps.executeQuery();
				
				if(rs.next()){
					f = false;  
				}
			} catch (Exception e) {
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
			return f;
		}
		
}
