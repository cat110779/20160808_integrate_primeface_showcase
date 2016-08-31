package org.greenpeace.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.greenpeace.service.Email03;

/**
 * Servlet implementation class ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactServlet() {
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
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		HttpSession se = request.getSession();
		String account = (String)se.getAttribute("account");
		String email = request.getParameter("email");
		String Subject = request.getParameter("Subject");
		String x = request.getParameter("x");

		System.out.println(x);
		System.out.println(account);
		System.out.println(email);
		System.out.println(Subject);
		// String acc,String conemail,String Sub,String Sug,String pass
		new Email03(account, email, Subject, x, "");

		if (account != null && email != null && Subject != null && x != null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('我們即將收到你的建議，請您耐心等候回信。');");
			out.println("location='contact.jsp';");
			out.println("</script>");
			return;
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('你輸入的資訊，有誤\n，請您重新填寫建議信。');");
			out.println("location='contact.jsp';");
			out.println("</script>");
			return;
		}
		
		//request.getRequestDispatcher("/contact.jsp").forward(request,response);

	}

}
