package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Restaurant;
import model.Start;

import dao.RestaurantDAO;
import dao.StartDAO;

/**
 * Servlet implementation class Startservlet
 */
public class Startservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StartDAO startDAO = new StartDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Startservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		int restaurantId = Integer.parseInt(request.getParameter("restaurantID"));
		
		RestaurantDAO restaurantDAO = new RestaurantDAO();
		Restaurant restaurant = restaurantDAO.getRestaurantById(restaurantId);
		
		String restaurantName = restaurant.getName();
		
		System.out.println("訂單ID : " + order_id);
		System.out.println("餐廳名: " + restaurantName);
		
		List<Start> list =startDAO.getOrderDatalist(order_id);
		for(Start po:list){
			System.out.println(po.getItem_id());
			System.out.println(po.getOrder_id());
			System.out.println(po.getProduct_name());
			System.out.println(po.getPrice());
			System.out.println("--------------------------");
		}
		
		//將查詢出來的資料丟到前端
		request.setAttribute("startList", list);
		request.setAttribute("order_id", order_id);
		request.setAttribute("restaurantName", restaurantName);
		//導頁
		request.getRequestDispatcher("/addmenu.jsp").forward(request, response);
	}

}
