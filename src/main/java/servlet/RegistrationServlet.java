package servlet;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.Member;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Email;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserDAO dao = new UserDAOImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String account = request.getParameter("newaccount");
		String email = request.getParameter("email");
		String newpassword = request.getParameter("newpassword");
		String again = request.getParameter("again");
		String checkbox = request.getParameter("checkbox");


		Member member = new Member();

		System.out.println("checkbox is " + checkbox);
		System.out.println("newpassword is " + newpassword);
		System.out.println("again is " + again);

		if (account.length() >= 16 ){
			System.out.println("錯誤瞜");                                                                                                                     
			out.println("<script type=\"text/javascript\">");
			out.println("alert('帳號過長，請勿超過16字元');");
			out.println("location='Index.jsp';");
			out.println("</script>");			                                                                                                                                                
			return;
		}
		if (newpassword.length() >= 16){
			System.out.println("錯誤瞜");                                                                                                                     
			out.println("<script type=\"text/javascript\">");
			out.println("alert('密碼過長，請勿超過16字元');");
			out.println("location='Index.jsp';");
			out.println("</script>");			                                                                                                                                                
			return;
		}
		
		if (dao.getAllUser(account) != null) {
			System.out.println("錯誤瞜");                                                                                                                     
			out.println("<script type=\"text/javascript\">");
			out.println("alert('帳號已經重複使用過，請使用新的帳號。');");
			out.println("location='Index.jsp';");
			out.println("</script>");			                                                                                                                                                
			return;
		}
		
		if (!newpassword.equals(again)) {
			System.out.println("密碼，輸入錯誤");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('密碼以及再次輸入密碼輸入錯誤，請再輸入一次。');");
			out.println("location='Index.jsp';");
			out.println("</script>");
			return;
		} else if (checkbox == null) {
			System.out.println("不同意使用左邊條款，無法成為會員唷!!!!");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('左邊條款尚未勾選，請再輸入一次資料以及確認條款內容。');");
			out.println("location='Index.jsp';");
			out.println("</script>");
			return;
		} else {

			System.out.println("歡迎你成為會員。");
			
			
			
			member.setAccount(account);
			member.setPassword(newpassword);
			member.setEmail(email);
			member.setMType("一般會員");

			int user = dao.createOrUpdateUser(member);

			if (user != 0) {
				new Email("", email, account, newpassword);
			}
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('註冊成功，請馬上登入使用您的權益唷!!!!!我們有寄信給你，請您收一下e-mail喔。')");
			out.println("location='Index.jsp';");
			out.println("</script>");
			return;
			
			//request.getRequestDispatcher("/Index.jsp").forward(request,response);
		}

	}
}
