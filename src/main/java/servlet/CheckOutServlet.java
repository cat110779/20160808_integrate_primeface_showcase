package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.MemberOrderDAO;
import dao.OrderDAO;
import dao.StartDAO;
import model.Customer;
import model.Item;
import model.Member;
import model.Order;

/**
 * Servlet implementation class CheckOutServlet
 */
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustomerDAO dao = new CustomerDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckOutServlet() {
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

		String[] order_ids = request.getParameterValues("order_id"); //why?
		String[] item_ids = request.getParameterValues("item_id");
		String[] productNames = request.getParameterValues("productName");
		String[] prices = request.getParameterValues("price");
		String[] counts = request.getParameterValues("counts");

		String account = (String) request.getSession().getAttribute("account");
		Member member = new Member();
		member.setAccount(account);

		System.out.println("開始結帳");
		System.out.println("你結帳的產品 : ");
		
		int f = 1;
		
		BigDecimal total = new BigDecimal(0);
		int total1 = 0;
		for (int i = 0; i < prices.length; i++) {
			int price = Integer.parseInt(prices[i]);
			int count = Integer.parseInt(counts[i]);
			total1 += price * count;
		}
		total = new BigDecimal(total1);
		
		//BigDecimal cash = (BigDecimal) request.getSession()
		//		.getAttribute("cash");
		
		BigDecimal cash = new BigDecimal( String.valueOf(request.getSession().getAttribute("cash")));
		// 結帳日期
		Timestamp c_date = new Timestamp(new Date().getTime());

		int res;
		res = cash.compareTo(total);
		//System.out.println(cash+" 購買前 total:"+total);
		//System.out.println(" 購買前 res:"+res);
		if (res > 0) {

			System.out.println("餘額結帳成功");
			for (int i = 0; i < productNames.length; i++) {
				
				if(Integer.parseInt(counts[i])!=0){	
					String productName = productNames[i];
					int price = Integer.parseInt(prices[i]);
					int count = Integer.parseInt(counts[i]);
					int order_id = Integer.parseInt(order_ids[i]); //??
					int item_id = Integer.parseInt(item_ids[i]);
					int money = price * count;
	
					//total = total.add(new BigDecimal(money));//WTF
	
					System.out.println("產品名稱 : " + productName);
					System.out.println("金額 : " + price);
					System.out.println("數量 : " + count);
					System.out.println("總金額 : " + money);
	
					Item item = new Item();
					item.setId(item_id);
	
					Customer customer = new Customer();
					customer.setItem(item);
					customer.setMember(member);
					customer.setCounts(count);
					customer.setMoney(money);
					customer.setStatus("未取餐");
					customer.setCDate(c_date);
					customer.setOrder_id(order_id);
	
					dao.createCustomer(customer);
					
					if(f==1){
						MemberOrderDAO moDao = new MemberOrderDAO();
						moDao.insert(account, order_id, c_date);
						f = 0;
					}
					
				}
			}
			
			//System.out.println(cash+" 相減前total "+total);
			cash = cash.subtract(total);
			
			//修改訂單狀態
			OrderDAO oDao = new OrderDAO();
			Order o = oDao.getOrderById(Integer.parseInt(order_ids[0]));
			if(o.getMoney()>=o.getEndMoney()){
				oDao.updateStatusByOrderId("已成立", Integer.parseInt(order_ids[0]));
			}
			
			//會員cash更新
			StartDAO sDao = new StartDAO();
			sDao.updateCash(cash, account);
						
			request.getSession().setAttribute("cash", cash);	
			
			/*
			request.getRequestDispatcher("/menu.jsp")
					.forward(request, response);  
			*/
			out.println("<script type=\"text/javascript\">");
			out.println("alert('結帳成功！本次消費金額："+total+"元');");
			out.println("location='menu.jsp';");
			out.println("</script>");
			return;
			
			
		} else{
			/*
			request.getRequestDispatcher("/menu.jsp")
					.forward(request, response);
			*/
			System.out.println("餘額不足");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('餘額不足！！');");
			out.println("location='menu.jsp';");
			out.println("</script>");
			return;
			
		}
	}
}
