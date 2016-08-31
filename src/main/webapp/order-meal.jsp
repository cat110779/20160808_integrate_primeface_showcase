<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.greenpeace.bean.*" %>
<%@ page import="org.greenpeace.dao.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<title>餓揪訂餐網站</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Deliccio Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- FlexSlider -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<script defer src="js/jquery.flexslider.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			start : function(slider) {
				$('body').removeClass('loading');
			}
		});
	});
</script>
<script type="text/javascript">
	function check(){
		alert("請輸入正整數金額與有效時間 !");
	}
	function mCheck(){
		alert("請輸入正整數金額 !");
	}
	function tCheck(){
		alert("請輸入有效時間 !");
	}
</script>
<script type="text/javascript">
	function ValidateNumber(e, pnumber)
	{
	    if (!/^\d{1,5}$/.test(pnumber))
	    {
	        e.value = /^\d{1,5}$/.exec(e.value);
	    }
	    return false;
	}
</script>
<!-- //FlexSlider -->
</head>
<%if(request.getParameter("tCheck")!=null && request.getParameter("mCheck")!=null){%>
	<body onload="check()">
<%}else if(request.getParameter("tCheck")!=null){%>
	<body onload="tCheck()">
<%}else if(request.getParameter("mCheck")!=null){%>
	<body onload="mCheck()">	
<%}else{%>	
	<body>
<%} %>	
	
	
<%
	HttpSession se = request.getSession(true);	
	if(se.getAttribute("account")==null){
		response.sendRedirect("Index.jsp");
	}	

	//取得現在時間
	long h = 3600*1000*1;
	Date date = new Date(System.currentTimeMillis()+h);
	String minDate = "";
	String maxDate = "";
	String timeStr = "";
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	DateFormat tf = new SimpleDateFormat("HH:mm"); 
	
	minDate = df.format(date);
	timeStr = tf.format(date);
	
	String maxStr = "2592000000";
	long max = Long.parseLong(maxStr);
	date = new Date(System.currentTimeMillis()+max);
	maxDate = df.format(date);
	//
	
	Order o = null;
	String oDate = null;
	OrderDAO oDao = new OrderDAO();
	
	Integer rId = 0;
	RestaurantDAO rDao = new RestaurantDAO();
	Restaurant r = null;
	
	ProductDAO pDao = new ProductDAO();
	List<Product> pList = null;
	
	if(request.getParameter("rId")!=null){
		rId = Integer.valueOf(request.getParameter("rId"));
		r = rDao.getRestaurantById(rId);
		se.setAttribute("rBean", r);
	}else{
		r = (Restaurant)se.getAttribute("rBean");
	}
	
	
	if(request.getParameter("oId")!=null || request.getAttribute("oSaved")!=null){
		int oId = 0;
		if(request.getAttribute("check") != null){
			o = (Order)se.getAttribute("oBean");
		}else if(request.getParameter("oId")!=null){
			oId = Integer.valueOf(request.getParameter("oId"));
			o = oDao.getOrderById(oId);
			ItemDAO iDao = new ItemDAO();
			List<Item> iList =  (ArrayList<Item>)iDao.getItemListByOrderId(oId);
			pList = pDao.createListByItem(iList);
		}else{
			o = (Order)request.getAttribute("oSaved");
			oId = o.getId();
			pList = (ArrayList<Product>)request.getAttribute("newPList");
		}
		oDate = df.format(o.getEndTime());
		timeStr = tf.format(o.getEndTime());
		//判斷修改權限
		if(o.getMemberAccount().equals((String)se.getAttribute("account"))){
			se.setAttribute("oBean", o);
		}else{
			se.setAttribute("oBean", null);
			response.sendRedirect("menu.jsp");
		}
	}else{
		pList = pDao.getProductByRestaurantId(rId);
		se.setAttribute("oBean", null);
	}
	
	
	if(request.getAttribute("newPList")!=null){
		pList = (ArrayList<Product>)request.getAttribute("newPList");
	}
	if(request.getParameter("check")!=null){
		pList = (ArrayList<Product>)se.getAttribute("pList");
	}
	
	se.setAttribute("pList", pList);
		
%>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		});

		function hide_tr() {
			alert("hide");
			var result_style = document.getElementById('dyn_tr').style;
			result_style.display = 'none';
		}
		//顯示TR
		function show_tr() {
			alert("show");
			var result_style = document.getElementById('dyn_tr').style;
			result_style.display = 'table-row';
		}
	</script>

	<!-- banner -->
	<div class="banner1">
		<div class="container">
			<div class="header-nav">
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<div class="logo">
							<a class="navbar-brand" href="Index.jsp"><b>餓揪訂餐 </b> <span>Healthy
									And Tasty Food</span></a>
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="ServiceServelet">回首頁</a></li>
							<li><a href="menu.jsp">我要訂餐</a></li>
							<li class="active"><a href="order.jsp">發起訂餐</a></li>
							<li><a href="contact.jsp">聯絡我們</a></li>
							<li><a href="Index.jsp">登出</a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</nav>
			</div>
		</div>
	</div>
	<!-- //banner -->
	<!-- services -->
	<div class="services">
		<div class="container">
			<h3>發起訂餐</h3>
			<div class="line"></div>
			<a href="updatestores.jsp?rId=<%=rId%>">修改店家菜單...</a>
			<div class="bs-docs-example">
				<table class="table table-bordered01">
					<thead>
						<tr>
							<th></th>
							<th>店家資訊</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>店名</td>
							<td><%=r.getName() %></td>
						</tr>
						<tr>
							<td>電話</td>
							<td><%=r.getPhone()%></td>
						</tr>
						<tr>
							<td>地址</td>
							<td><%=r.getAddr()%></td>
						</tr>
						<tr>
							<td>店家服務類型</td>
							<td><%=r.getRType()%></td>
						</tr>
						<tr>
							<td>備註</td>
							<td><%=r.getBrief()%></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="">
				<table class="table table-bordered01">
					<thead>
						<tr>
							<th>產品清單</th>
							<th>細項價格</th>
						</tr>
					</thead>
					<tbody>
						<%
							for(Product p:pList){					
						%>
						<tr>
							<td><%=p.getName() %></td>
							<td><%=p.getPrice() %></td>
						</tr>
						<%}%>
					</tbody>
				</table>
			</div>
			<%if(request.getParameter("check")!=null){//格式有誤%>
			<div class="">
				<form method="post" action="OrderServlet">
					<%if(request.getParameter("tCheck")==null){ %>
						<input type="date" name="endDate" value="<%=(String)se.getAttribute("endDateRemain")%>" min="<%=minDate%>" max="<%=maxDate%>" style="outline: none;
																																			    	width:45%;
																																			   		height:46px;
																																			    	outline: none;
																																			   		border: 1px solid #E3E2E2;
																																			    	background: none;
																																			  		 text-align: center;
																																		   			color: #000" required="">&nbsp&nbsp&nbsp
						<input type="time" name="endTime" value="<%=(String)se.getAttribute("endTimeRemain")%>" style="outline: none;
																											   width:40%;
																											   height:46px;
																											   outline: none;
																												border: 1px solid #E3E2E2;
																												background: none;
																												text-align:center;
																												font-size: 15px;
																												color: #000" required="">
					<%}else{ %>
						<input type="date" name="endDate" value="<%=(String)se.getAttribute("endDateRemain")%>" min="<%=minDate%>" max="<%=maxDate%>" required="" style="outline: none;
																																										    	width:45%;
																																										   		height:46px;
																																										    	outline: none;
																																										   		border: 1px solid #E3E2E2;
																																										    	background: none;
																																										  		 text-align: center;
																																									   			color: #000" >&nbsp&nbsp&nbsp
						<input type="time" name="endTime" value="<%=(String)se.getAttribute("endTimeRemain")%>" onfocus="this.style.color='black'" required=""  style="outline: none;
																																										   width:35%;
																																										   height:46px;
																																										   outline: none;
																																											border: 1px solid #E3E2E2;
																																											background: none;
																																											text-align:center;
																																											font-size: 15px;
																																											color: red" >
					<%} %>	
					<input type="text" name="endMoney" value="<%=(Integer)se.getAttribute("endMoneyRemain")%>" style="color:black" placeholder="截止金額" onkeyup="return ValidateNumber(this,value)" required="">
					<div class="clearfix"></div>
					<textarea type="text" name="info" placeholder="說明" style="color:black" ><%=(String)se.getAttribute("infoRemain") %></textarea>
					<input type="submit" value="送出">
				</form>
			</div>
			<%}else if(o==null){//發起訂單%>
			<div class="contact-center">
				<form method="post" action="OrderServlet">
					<input type="date" name="endDate" value="<%=minDate %>" min="<%=minDate%>" max="<%=maxDate%>" style="outline: none;
																										    	width:45%;
																										   		height:46px;
																										    	outline: none;
																										   		border: 1px solid #E3E2E2;
																										    	background: none;
																										  		 text-align: center;
																										   		color: #000" required="">&nbsp&nbsp&nbsp
					<input type="time" name="endTime" value="<%=timeStr%>" required=""  style="outline: none;
																							   width:40%;
																							   height:46px;
																							   outline: none;
																								border: 1px solid #E3E2E2;
																								background: none;
																								text-align:center;
																								font-size: 15px;
																								color: #000">
					<input type="text" name="endMoney" value=""  style="color:black" placeholder="截止金額" onkeyup="return ValidateNumber(this,value)" required="">
					<div class="clearfix"></div>
					<textarea type="text" name="info" placeholder="說明" style="color:black" ></textarea>
					<input type="submit" value="送出">
				</form>
			</div>
			<%}else{//修改訂單
			%>
			<div class="contact-center">
				<form method="post" action="OrderServlet">
					<input type="date" name="endDate" value="<%=oDate%>" min="<%=minDate%>" max="<%=maxDate%>"  style="outline: none;
																										    	width:45%;
																										   		height:46px;
																										    	outline: none;
																										   		border: 1px solid #E3E2E2;
																										    	background: none;
																										  		 text-align: center;
																										   		color: #000" required="">&nbsp&nbsp&nbsp
					<input type="time" name="endTime" value="<%=timeStr%>" style="outline: none;
																							   width:40%;
																							   height:46px;
																							   outline: none;
																								border: 1px solid #E3E2E2;
																								background: none;
																								text-align:center;
																								font-size: 15px;
																								color: #000" required="">
					<input type="text" name="endMoney" style="color:black" value="<%=o.getEndMoney()%>" placeholder="截止金額" onkeyup="return ValidateNumber(this,value)" required="">
					<div class="clearfix"></div>
					<textarea type="text" name="info" style="color:black" placeholder="說明"><%=o.getInfo()%></textarea>
					<input type="submit" value="送出">
				</form>
			</div>
			<%}%>
		</div>
	</div>
	<!-- //services -->

	<div class="footer-bottom">
		<div class="container">
			<p>&copy; - Copyright 2016© All rights reserved.</p>
		</div>
	</div>
	<!--//footer-->
	<!-- for bootstrap working -->
	<script src="js/bootstrap.js">
		
	</script>
	<!-- //for bootstrap working -->
</body>
</html>