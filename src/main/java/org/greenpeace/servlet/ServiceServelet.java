package org.greenpeace.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.greenpeace.bean.CustomerSuper;
import org.greenpeace.bean.Deposit;
import org.greenpeace.bean.Member;
import org.greenpeace.bean.Order;
import org.greenpeace.bean.OrderSuper;
import org.greenpeace.bean.User;
import org.greenpeace.dao.CustomerDAO;
import org.greenpeace.dao.DepositDAO;
import org.greenpeace.dao.OrderDAO;
import org.greenpeace.dao.UserDAO;
import org.greenpeace.dao.UserDAOImpl;

/**
 * Servlet implementation class DepositServelet
 */
public class ServiceServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DepositDAO depositDAO = new DepositDAO();
	private CustomerDAO customerDAO = new CustomerDAO();
	private OrderDAO orderDAO = new OrderDAO();
	private UserDAOImpl uDao = new UserDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceServelet() {
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
		
//		HttpSession session = request.getSession();
//		Object obj = session.getAttribute("是否登入");
//		
//		if("Y".equals(obj.toString())){
//			int memberId = (Integer) session.getAttribute("帳號");
//		}
		
		//江江
		HttpSession session = request.getSession();
		String account = (String)session.getAttribute("account");
				
		Member m = uDao.getUser(account);
		session.setAttribute("cash",m.getCash());
		
		List<Deposit> depositlist = depositDAO.queryByMemberAccount(account);
		request.setAttribute("depositlist", depositlist);
		
		//新翔
		List<CustomerSuper> customerList = customerDAO.queryCustomerList(account);
		request.setAttribute("customerList", customerList);
		
		List<OrderSuper> orderList = orderDAO.queryOrderList(account);
		request.setAttribute("orderList", orderList);
		
		//發起訂單查詢
		List<Order> myOrderList = orderDAO.getOrderByAccount(account);
		request.setAttribute("myOrderList", myOrderList);
	
		
		if ("一般會員".equals((String)session.getAttribute("mtype")))
			request.getRequestDispatcher("/services.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/admin-services.jsp").forward(request, response);
	}

}
