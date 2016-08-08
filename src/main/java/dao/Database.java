package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.Server;

public class Database {

	private static Connection connect;
	final static String driver = "org.h2.Driver";
	//runscript from 'classpath:/jp/seraphyware/sample/h2test/ddl.sql' charset 'UTF-8'
	final static String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=Oracle;INIT=runscript from \'classpath:scripts/jamari.sql\'  charset  \'UTF-8\' ";
	final static String userid = "sa";
	final static String passwd = ""; 
//	final static String driver = "oracle.jdbc.driver.OracleDriver";
//	final static String url = "jdbc:oracle:thin:@192.168.7.34:1521:orcl";
//	final static String userid = "esbappadm";
//	final static String passwd="esbappadm"; 
	private static 	BasicDataSource bds =null;
	static{
		bds = new org.apache.commons.dbcp2.BasicDataSource();
		bds.setDriverClassName(driver);
		bds.setUrl(url);		 
		bds.setUsername(userid);
		bds.setPassword(passwd);
		bds.setInitialSize(3); 
	}
	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		//connect 一次只能開一個
		if(connect != null && !connect.isClosed()){
			System.out.println("連線尚未關閉!");
		} else {
			// jdbc:mysql://主機名稱:連接埠/資料庫名稱xxxxx?參數1=值1&參數2=值2
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//
//			// 嘗試連結資料庫
//			try {
//				// 透過java.lang.Class類別的forName()來載入並向DriverManager註冊JDBC驅動程式
//				// （驅動程式會自動透過DriverManager.registerDriver()方法註冊），
//				// MySQL的驅動程式類別是com.mysql.jdbc.Driver
//				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//			}
//			// 如果找不到com.mysql.jdbc.Driver類別，就會丟出 ClassNotFoundException
//			// 這時請確定您的CLASSPATH中是否包括了mysql-connector-java-*.jar的位置
//			catch (SQLException e) {
//				System.out.println("找不到驅動程式類別");
//			}
//			// 載入url(上方)，並設定資料庫存取的帳號xxxxx密碼xxxxx
//			connect = DriverManager.getConnection(url, "TEAM3", "333");
			connect =bds.getConnection();
		}
		return connect;
	}
	
	public static void main(String[] args){
		Database database = new Database();
		try {
			Connection connection = database.getConnection();
			
			Statement statement = connection.createStatement();
			
			String sql = "select * from MEMBER";
			
			try {
				statement.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}