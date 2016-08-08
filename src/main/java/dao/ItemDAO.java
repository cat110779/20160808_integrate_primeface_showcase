package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;

import model.Item;

public class ItemDAO extends Database{
	Connection conn = null;	
	Statement stmt = null;
	PreparedStatement ps = null; 
	ResultSet rs = null;
	String sql = "";
	
	public void insertItemList(List<Item> iList){
		try {
			conn = getConnection();
			sql = "insert into item values (null,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			for(Item item:iList){
				
				ps.setInt(1,item.getProductId());
				ps.setInt(2,item.getOrderId());
				ps.setString(3, item.getProductName());
				ps.addBatch();
			}
			ps.executeBatch();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			System.out.println("insertItemList Error");
		}
	}

	

	
	
	//unfinished
	public void updateItemByOrderId(List<Item> iList,int oId){
		try {
			conn = getConnection();
			sql = "delete item where order_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, oId);
			ps.execute();
			sql = "insert into item values (null,?,?,?)";
			ps = conn.prepareStatement(sql);
			for(Item item:iList){
				ps.setInt(1,item.getProductId());
				ps.setInt(2,item.getOrderId());
				ps.setString(3, item.getProductName());
				ps.addBatch();
			}
			ps.executeBatch();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			System.out.println("updateItemByOrderId Error");
		}
	}
	
	
	public List<Item> getItemListByOrderId(int oId){
		List<Item> iList = new ArrayList<Item>();
		try {
			conn = getConnection();
			Item i = null;
			
			sql = "select i.id,order_id,name,price,p.id as p_id from item i,product p where order_id = ? and i.product_id = p.id";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,oId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				i = new Item();
				i.setId(rs.getInt("id"));
				i.setOrderId(rs.getInt("order_id"));
				i.setProduct(rs.getString("name"),rs.getInt("price"));
				i.setProductId(rs.getInt("p_id"));
				iList.add(i);
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertItemList Error");
		}
		return iList;
	}

	
}
