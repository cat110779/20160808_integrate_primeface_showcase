<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.OrderDAO" %>
<%@ page import="dao.CustomerDAO" %>
<%@ page import="model.Order" %>
<%@ page import="model.Customer" %>

<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>餓揪訂餐網站</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Deliccio Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js">
</script>
<!-- //js -->
<!-- FlexSlider -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script defer src="js/jquery.flexslider.js">
</script>
<script defer src="js/color.js">
</script>
<!-- //FlexSlider -->
</head>	


<body onload="showCustomer(<%=request.getParameter("oId")%>)">
<% 

	HttpSession se = request.getSession();
	if(se.getAttribute("account")==null){
		response.sendRedirect("Index.jsp");
	}else if(!((String)se.getAttribute("mtype")).equals("高級會員")){
		response.sendRedirect("ServiceServelet");
	}

	OrderDAO oDao = new OrderDAO();
	List<Order> oList = null;
	oList = oDao.getAllOrderByStatus();
	
	CustomerDAO cDao = new CustomerDAO();
	List<Customer> cList = cDao.queryAllCustomer();
	
	
	
%>

<script>
	function showCustomer(oId){
	
	<%for(Order o:oList){%>
		if(oId==<%=o.getId()%>){
			document.getElementById("take").innerHTML = ""
				<%for(Customer c:cList){
					if(c.getOrderId()==o.getId()){%>
					+"<tr>"
					+<%="\"<td>"+c.getItemName()+"</td>\""%>
					+<%="\"<td>"+c.getCounts()+"</td>\""%>
					+<%="\"<td>"+c.getItemPrice()+"</td>\""%>
					+<%="\"<td>"+c.getMoney()+"</td>\""%>
					+<%="\"<td id='tbl1'>"+c.getMemberAccount()+"</td>\""%>
				<%if(o.getStatus().equals("進行中")){%>
					+"<td>訂單尚未成立</td>"
				<%}else if(c.getStatus().equals("未取餐")){%>	
					+"<td><input type='checkbox' name='meal' "
					+<%="\"value='"+c.getOrderId()+"_"+c.getId()+"'\""%>
					+"></td>"
				<%}else{%>	
					+"<td>已取餐</td>"
				<%}%>	
					+"</tr>"
				<%}}%>
			;
		}
	<%}%>
	
	
	}
</script>

<!-- banner -->
	<div class="banner1">
		<div class="container">
			<div class="header-nav">
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
					  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					  </button>
						<div class="logo">
							<a class="navbar-brand" href="Index.jsp"><b>餓揪訂餐 </b> <span>Healthy And Tasty Food</span></a>
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
					  <ul class="nav navbar-nav">
						<li class="active"><a href="ServiceServelet">回首頁</a></li>
						<li><a href="menu.jsp">我要訂餐</a></li>
						<li><a href="order.jsp">發起訂餐</a></li>
						<li><a href="contact.jsp">聯絡我們</a></li> 
                        <li><a href="Index.jsp">登出</a>  </li> 
					  </ul>
					</div><!-- /.navbar-collapse -->
				</nav>
			</div>
		</div>
	</div>
<!-- //banner -->
<!-- menu -->
	<div class="menu-page">
		<div class="container">
		
			<div class="menu-title">
				<h3>確認取餐</h3>
                <div class="line">
				</div>
                <div class="well">
					訂單速覽 - 
					
						<select id="orders" name="訂單"  onchange="showCustomer(this.value)">
							<option value="">訂單</option>
							<%for(Order o:oList){%>
　								<option value="<%=o.getId()%>"><%=o.getMemberAccount()%> - <%=o.getRestaurantName()%> - <%=o.getRestaurantPhone()%> - <%=o.getStatus() %></option>
							<%}%>
						</select>
					
				</div>			
			</div>      
			<form method="post" action="TakeMealServlet">
            <div class="bs-docs-example">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>產品</th>
							<th>數量</th>
							<th>單價</th>
							<th>小計</th>
							<th>訂購人</th>
							<th>取餐</th>
						</tr>
					</thead>
					<tbody id="take">
					<!-- 
						<tr>
							<td>排骨便當</td>
							<td>2</td>
							<td>60</td>
							<td>120</td>
                            <td id='tbl1'>江明錡</td>
                            <td><input type="checkbox"></td>
						</tr>
					 -->
					</tbody>
				</table>
			</div>
	<h4 style="color:#999999">說明：若會員已取餐，請於取餐欄位處打勾，並點選下方確認取餐按鈕。  </h4>
			<br>
			
			
			
			
      <h4 align="center"><input class="btn btn-default" type="submit" value="確認取餐" ></h4>
			
            </form>   
          <div style="margin-top:1em;">
	<!--<h4 >圖示說明：</h4>
	<table class="mergeView " style="color:#888;">
	  <tr><td class="cell done"><img src="images/k4.png" width="77" height="25" alt=""/></td>
	    <td> - 綠底的項目表示<b style="color:black;">已經取餐</b></td>
	    </tr>
	  </table> -->
      
      
          </div>
          
	  </div>
			
		</div>
	</div>
<!-- //menu -->
<!--footer-->
	<div class="footer-bottom">
		<div class="container">		
			<p>&copy;  - Copyright 2016© All rights reserved.</p>					
		</div>
	</div>
<!--//footer-->	
<!-- for bootstrap working -->
		<script src="js/bootstrap.js">
</script>
<!-- //for bootstrap working -->
</body>
</html>

