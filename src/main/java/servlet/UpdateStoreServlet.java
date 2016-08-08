package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Order;
import model.Product;
import model.Restaurant;

/**
 * Servlet implementation class UpdateStoreServlet
 */
public class UpdateStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStoreServlet() {
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
		
		ProductDAO pDao = new ProductDAO();
		HttpSession se = request.getSession();
		Restaurant r = (Restaurant)se.getAttribute("rBean");
		
		List<Product> alterPList = new ArrayList<Product>();
		List<Product> newList = new ArrayList<Product>();
		List<Product> oldList = pDao.getProductByRestaurantId(r.getId());
		//List<Product> pList = (ArrayList<Product>)se.getAttribute("pList");

		String[] name = request.getParameterValues("name[]");
		String[] priceStr = request.getParameterValues("price[]");
		Product p = null;
		int count = 0;
		for(int i=0;i<name.length;i++){
			int f = 1;
			p = new Product();
			name[i] = new String(name[i].getBytes("ISO-8859-1"), "UTF-8");
			p.setName(name[i]);
			int price = Integer.parseInt(priceStr[i]);
			p.setPrice(price);
			p.setrId(r.getId());		
			for(Product rp:oldList){
				if(p.getName().equals(rp.getName())){
					p.setId(rp.getId());
					oldList.remove(rp);
					f = 0;
					break;
				}
			}
			if(f==1){
				p.setId(pDao.getMaxIdPlus()+count);
				System.out.println(p.getId());
				newList.add(p);
				count++;
			}
			alterPList.add(p);
		}
		
		if(se.getAttribute("oBean")!=null){
			Order o = (Order)se.getAttribute("oBean");
			request.setAttribute("oSaved", o);
		}
		pDao.insertProduct(newList);
		request.setAttribute("newPList", alterPList);
		request.getRequestDispatcher("order-meal.jsp").forward(request, response);
		
	}

}
