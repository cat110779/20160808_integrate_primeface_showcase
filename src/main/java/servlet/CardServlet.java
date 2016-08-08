package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Database;
import dao.UserDAOImpl;


/**
 * Servlet implementation class CardServlet
 */
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;	
		Statement stmt = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		String sql = "";
		HttpSession se = request.getSession();
		
		
		response.setContentType("text/html;charset=utf-8");
		UserDAOImpl uDao = new UserDAOImpl();
		int addCash = Integer.parseInt(request.getParameter("cash"));
		int oldCash = 0;
		String account = request.getParameter("account");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		PrintWriter out = response.getWriter();
		
		if(uDao.checkUser(account)){
			try {
			  Database db = new Database();
			  conn = db.getConnection();	
				
			  ps = conn.prepareStatement("select cash from member where account = ?");
			  ps.setString(1, account);
			  rs = ps.executeQuery();
			  rs.next();
			  oldCash = rs.getInt(1);	
				
			  ps = conn.prepareStatement("insert into deposit values(null,?,?,?)");
			  ps.setInt(1, addCash);
			  ps.setTimestamp(2,now);
			  ps.setString(3,account);
			  ps.execute();
			 
			  ps = conn.prepareStatement("update member set cash = ? where account = ?");
			  ps.setInt(1, oldCash + addCash);
			  ps.setString(2,account);
			  ps.execute();
			    
			}catch (Exception e){
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
			
			se.setAttribute("cash", addCash+oldCash);
			System.out.println("儲值成功");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('儲值成功！會員"+account+"已儲值"+addCash+"元。');");
			out.println("location='card.jsp';");
			out.println("</script>");
			return;
			//response.sendRedirect("card.jsp");
		}else{
			System.out.println("查無此帳號");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('查無此帳號');");
			out.println("location='card.jsp';");
			out.println("</script>");
			return;
		}
				
	}
}
