package servlet;

import dao.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Email;
import service.Email02;
import model.CustomerSuper;
import model.Deposit;
import model.Member;
import model.Order;
import model.OrderSuper;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO dao = new UserDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String againaccount = request.getParameter("againaccount");
		String againemail = request.getParameter("againemail");

		String actionType = request.getParameter("type");
		System.out.println("type : " + actionType);

		// 亂數產生
		int z;
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < 5; i++) {
			z = (int) ((Math.random() * 7) % 3);

			if (z == 1) { // 放數字
				sb.append((int) ((Math.random() * 10) + 48));
			} else if (z == 2) { // 放大寫英文
				sb.append((char) (((Math.random() * 26) + 65)));
			} else {// 放小寫英文
				sb.append(((char) ((Math.random() * 26) + 97)));
			}
		}

		System.out.println("sb = " + sb);

		System.out.println("againaccount" + againaccount);
		System.out.println("sb.toString()" + sb.toString());
		System.out.println("againemail" + againemail);

		// 修改密碼
		if ("changePassword".equals(actionType)) {

			System.out.println(againaccount);
			System.out.println(againemail);

			response.setContentType("text/html;charset=utf-8");

			PrintWriter out = response.getWriter();

			int User = dao.updatePassword(againaccount, sb.toString(),
					againemail);

			if (User != 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('密碼修改完成，請至您的信箱收一下更改的密碼。');");
				out.println("location='Index.jsp';");
				out.println("</script>");

				new Email02(againemail, againaccount, sb.toString());

				System.out.println(againaccount);
				System.out.println(againemail);
				System.out.println(sb.toString());

				return;
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('很抱歉，帳號及信箱輸入錯誤。密碼無法修改唷。');");
				out.println("location='Index.jsp';");
				out.println("</script>");
				return;
			}
		}

		// 登入
		Member member = dao.getUserByAccount(account, password);

		System.out.println(account);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (member == null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('帳號密碼輸入錯誤');");
			out.println("location='Index.jsp';");
			out.println("</script>");
			return;
		}

		HttpSession session = request.getSession(false);
		if (session == null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('驗證碼輸入錯誤');");
			out.println("location='Index.jsp';");
			out.println("</script>");
			return;
		}

		String saveCode = (String) session.getAttribute("check_code");
		if (saveCode == null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('驗證碼輸入錯誤');");
			out.println("location='Index.jsp';");
			out.println("</script>");
			return;
		}

		String checkCode = request.getParameter("check_code");
		if (!saveCode.equals(checkCode)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('驗證碼輸入錯誤');");
			out.println("location='Index.jsp';");
			out.println("</script>");
			return;
		} else {

			System.out.println("登入成功");

			// TODO 紀錄是否登入
			// HttpSession session = request.getSession();
			// session.setAttribute("是否登入", "Y");
			// session.setAttribute("帳號", Integer.parseInt(member.getId() +
			// ""));

			String type = member.getMType();
			session.setAttribute("account", member.getAccount());
			session.setAttribute("cash", member.getCash());
			session.setAttribute("mtype", type);


			// 江江
			DepositDAO depositDAO = new DepositDAO();
			List<Deposit> depositlist = depositDAO
					.queryByMemberAccount(account);
			request.setAttribute("depositlist", depositlist);

			// 新翔
			CustomerDAO customerDAO = new CustomerDAO();
			List<CustomerSuper> customerList = customerDAO
					.queryCustomerList(account);
			request.setAttribute("customerList", customerList);

			OrderDAO orderDAO = new OrderDAO();
			List<OrderSuper> orderList = orderDAO.queryOrderList(account);
			request.setAttribute("orderList", orderList);

			// 發起訂單查詢
			List<Order> myOrderList = orderDAO.getOrderByAccount(account);
			request.setAttribute("myOrderList", myOrderList);
			
			
			if ("一般會員".equals(type)) {
				request.getRequestDispatcher("/services.jsp").forward(request,
						response);
			} else if ("高級會員".equals(type)) {
				request.getRequestDispatcher("/admin-services.jsp").forward(
						request, response);
			}

			System.out.println(member.getAccount());
			System.out.println(member.getEmail());
			System.out.println(member.getCash());
			request.setAttribute("account", member.getAccount());
			// request.getRequestDispatcher("/jsp/service.jsp").forward(request,
			// response);
		}

	}

}
