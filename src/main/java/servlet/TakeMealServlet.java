package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.OrderDAO;

/**
 * Servlet implementation class TakeMealSevlet
 */
public class TakeMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakeMealServlet() {
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
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(request.getParameterValues("meal")==null){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('請勾選已取餐的會員！');");
			out.println("location='take-meal.jsp';");
			out.println("</script>");
			return;
		}
		
		String[] orderAndId = request.getParameterValues("meal");
		String[] splitStr = new String[2];
		splitStr = orderAndId[0].split("_");
		
		CustomerDAO cDao = new CustomerDAO();
		int orderCompleteFlag = cDao.updateStatus(orderAndId);
		if(orderCompleteFlag==1){
			OrderDAO oDao = new OrderDAO();
			oDao.updateStatusByOrderId("已結單",Integer.parseInt(splitStr[0]));
			out.println("<script type=\"text/javascript\">");
			out.println("alert('會員皆已取餐，此訂單已完成！');");
			out.println("location='take-meal.jsp';");
			out.println("</script>");
			return;
		}
		

		//System.out.println(splitStr[0]);
		response.sendRedirect("take-meal.jsp?oId="+splitStr[0]);
	}

}
