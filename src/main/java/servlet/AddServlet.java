package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RestaurantDAO;
import model.Product;
import model.Restaurant;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		
		
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String Name = request.getParameter("Name");
		String Brief = request.getParameter("Brief");
		String Addr = request.getParameter("Addr");
		String Phone = request.getParameter("Phone");
		String RType = request.getParameter("Rtype");
		
		RestaurantDAO dao = new RestaurantDAO();
		
		if(dao.checkR(Phone)){
			String[] productNames = request.getParameterValues("productName");
			String[] prices = request.getParameterValues("price");
			
			List<Product> productList = new ArrayList<Product>();
			for(int i = 0 ; i < productNames.length ; i++){
				
				String productName = productNames[i];
				String price = prices[i];
				
				Product product = new Product();
				
				if(productName == null || "".equals(productName.trim())){
					continue;
				}
				
				if(price == null || "".equals(price.trim())){
					continue;
				}
				
				product.setName(productName);
				product.setPrice(Integer.parseInt(price));
				productList.add(product);
			}
			
			
			Restaurant r = new Restaurant();
			r.setName(Name);
			r.setBrief(Brief);
			r.setAddr(Addr);
			r.setPhone(Phone);
			r.setRType(RType);
			r.setProducts(productList);
			
			dao.addStore(r);
			response.sendRedirect("order.jsp");
		
		}else{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('店家已在清單中！');");
			out.println("location='addstores.jsp';");
			out.println("</script>");
			return;
		}
		
	
	
	}
		


}
