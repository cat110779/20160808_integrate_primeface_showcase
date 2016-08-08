package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Item;
import model.Product;

public class ProductDAO extends Database{
	Connection conn = null;	
	Statement stmt = null;
	PreparedStatement ps = null; 
	ResultSet rs = null;
	String sql = "";
	
	public List<Product> getProductByRestaurantId(int id){
		Product p = null;
		List<Product> list = new ArrayList<Product>();
		sql = "select * from product where restaurant_id = ? order by id";
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setPrice(rs.getInt("price"));
				p.setName(rs.getString("name"));
				p.setrId(rs.getInt("restaurant_id"));
				//p.setRestaurant(new RestaurantDAO().getRestaurantById(id));
				list.add(p);
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
		return list;
		
	}
	
	public List<Product> insertProduct(List<Product> pList){
		List<Product> list = new ArrayList<Product>();
		sql = "insert into product values(null,?,?,?)";
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			for(Product p :pList){
				ps.setString(1,p.getName());
				ps.setInt(2, p.getPrice());
				ps.setInt(3, p.getrId());
				ps.addBatch();
			}
			ps.executeBatch();
			
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
		return list;
		
	}
	
	//unfinished
	public List<Product> createListByItem(List<Item> iList){
		List<Product> pList = new ArrayList<Product>();
		Product p = null;
		for(Item i:iList){
			p = new Product();
			p = i.getProduct();
			pList.add(p);
		}
		
		return pList;
	}
	
	public int getMaxIdPlus(){
		int id = 0;
		try {
			sql = "select  Last_Number from USER_SEQUENCES where sequence_name = 'PRODUCT_ID_SEQ'";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt(1);
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
		return id;
	}
	
	public void insertProductList(List<Product> list, int restaurant_id) {

		try {

			conn = getConnection();

			for (Product p : list) {

				ps = conn.prepareStatement("insert into product values (null, ?, ?, ?)");
				ps.setString(1, p.getName());
				ps.setInt(2, p.getPrice());
				ps.setInt(3, restaurant_id);
				ps.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
