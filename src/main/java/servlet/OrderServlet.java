package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Item;
import model.Order;
import model.Product;
import model.Restaurant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.annotation.WebServlet;

import dao.ItemDAO;
import dao.OrderDAO;

/**
 * Servlet implementation class OrderServlet
 */

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		Order o = null;
		OrderDAO oDao = new OrderDAO();
		if(se.getAttribute("oBean")!=null)
			o =(Order)se.getAttribute("oBean");
		else
			o = new Order();
		
		Item item = null;
		ItemDAO iDao = new ItemDAO();
		List<Item> iList = new ArrayList<Item>();
		
		String info = request.getParameter("info");	
		String endTime = request.getParameter("endTime");
		String endDate = request.getParameter("endDate");
		Restaurant r = (Restaurant)se.getAttribute("rBean"); 
		int endMoney = 0;
		
		//判斷格式是否正確
		String url = "order-meal.jsp?";
		boolean mCheck = false;
		se.setAttribute("rRemain", r.getId());
		se.setAttribute("infoRemain", info);
		try{
			endMoney = Integer.parseInt(request.getParameter("endMoney"));
			if(endMoney<=0)throw new Exception();
		}catch(Exception e){
			mCheck = true;
			se.setAttribute("endMoneyCheck",request.getParameter("endMoney") );
			url = url + "mCheck=1&";
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String dateAndTime = endDate+" "+endTime+":00";
		Date date = null;
		try {
			date = df.parse(dateAndTime);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Time parsed Error");
		}
		
		long endTimeLong = date.getTime();
		boolean tCheck = false;
		if((endTimeLong-System.currentTimeMillis())<0){
			tCheck = true;
			url = url + "tCheck=1&";
		}
		if(tCheck || mCheck){
				se.setAttribute("endTimeRemain",endTime);
				se.setAttribute("endDateRemain", endDate);
				se.setAttribute("endMoneyRemain", endMoney);
			if(se.getAttribute("oBean")!=null)
				response.sendRedirect(url+"check=1&oId="+String.valueOf(o.getId()));
			else
				response.sendRedirect(url+"check=1");
		}else{
			se.setAttribute("rRemain",null);
			//int rId = (int)se.getAttribute("rId"); 
			o.setEndTime(Timestamp.valueOf(dateAndTime));
			o.setEndMoney(endMoney);
			o.setMemberAccount((String)se.getAttribute("account"));
			o.setInfo(info);
			o.setRestaurant(r);	
		
			//o.setRestaurantId(rId);
			
			if(se.getAttribute("oBean")!=null){
				oDao.updateOrder(o);
				List<Product> pList = (ArrayList<Product>)se.getAttribute("pList");
				for(Product p:pList){
					item = new Item();
					item.setProduct(p);
					item.setOrderId(o.getId());
					iList.add(item);
				}
				iDao.updateItemByOrderId(iList, o.getId());
				se.setAttribute("oBean", null);
				se.setAttribute("rBean", null);
			    se.setAttribute("pList",null);
			    System.out.println("已修改訂單");
				response.sendRedirect("menu.jsp");
			}else{
				o.setBeginTime();
				oDao.insertOrder(o);
				List<Product> pList = (ArrayList<Product>)se.getAttribute("pList");
				for(Product p:pList){
					item = new Item();
					item.setProduct(p);
					item.setOrderId(oDao.getMaxId());
					iList.add(item);
				}
				iDao.insertItemList(iList);	
				se.setAttribute("oBean", null);
				se.setAttribute("rBean", null);
			    se.setAttribute("pList",null);
			    System.out.println("已發起訂單");
		
				response.sendRedirect("order.jsp");
			}
			
		}
		
		
	}
}
