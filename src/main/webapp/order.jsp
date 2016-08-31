<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.greenpeace.bean.Restaurant"%>
<%@ page import="org.greenpeace.dao.RestaurantDAO"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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



<!-- //FlexSlider -->
</head>

<body onload='showStores("全部")''>
	<%
		HttpSession se = request.getSession();
		if(se.getAttribute("account")==null){
			response.sendRedirect("Index.jsp");
		}
		int count = 0;
		
		RestaurantDAO rDao = new RestaurantDAO();
		List<Restaurant> rBeanList = new ArrayList<Restaurant>();
		rBeanList = rDao.getAllRestaurant();
		
		/*String rtype;
		if(request.getParameter("type")==null){
			rtype = "便當";
		}else{
			rtype = (String)request.getParameter("type");
			rtype = new String(rtype.getBytes("ISO-8859-1"), "UTF-8");
		}*/
		
		
		/*
		RestaurantDAO rDao = new RestaurantDAO();
		List<Restaurant> rList = new ArrayList<Restaurant>();
		String rtype;
		if(request.getParameter("type")==null){
			rtype = "便當";
		}else{
			rtype = (String)request.getParameter("type");
			rtype = new String(rtype.getBytes("ISO-8859-1"), "UTF-8");
		}
		rList = rDao.getRByType(rtype);
		
			*/
	%>

	<script>
		function showStores(str) {
			if (str == "全部") {
				document.getElementById("stores").innerHTML = ""
				<% count = 0;
				for(Restaurant r:rBeanList){	
						if(count%4==0){%>
						+	"<tr>"
						<%}%>
						+"<td><a href=\"order-meal.jsp?rId="
						+<%="\""+r.getId()+"\""%>
						+"\">"
						+<%="\""+r.getName()+"\""%>
						+"</a></td>"
					<%if(count%4==3){%>	
						+ "</tr>"
					<%}
						count++;%>	
				  <%
				}while(count%4!=0){%>
					 +"<td></td>"
				<%count++;}%>;
			}
			if (str == "便當") {
				document.getElementById("stores").innerHTML = ""
				<% count = 0;
				for(Restaurant r:rBeanList){	
					if(r.getRType().equals("便當")){
						if(count%4==0){%>
						+	"<tr>"
						<%}%>
						+ "<td><a href=\"order-meal.jsp?rId="
						+<%="\""+r.getId()+"\""%>
						+"\">"
						+<%="\""+r.getName()+"\""%>
						+"</a></td>"
					<%if(count%4==3){%>	
						+ "</tr>"
					<%}count++;%>
						
				  <%}
				}while(count%4!=0){%>
					 +"<td></td>"
				<%count++;}%>;
			}
			if (str == "速食") {
				document.getElementById("stores").innerHTML = ""
				<% count = 0;
				for(Restaurant r:rBeanList){	
					if(r.getRType().equals("速食")){
						if(count%4==0){%>
						+	"<tr>"
						<%}%>
						+"<td><a href=\"order-meal.jsp?rId="
						+<%="\""+r.getId()+"\""%>
						+"\">"
						+<%="\""+r.getName()+"\""%>
						+"</a></td>"
					<%if(count%4==3){%>	
						+ "</tr>"
					<%}
						count++;%>						
				  <%}
				}while(count%4!=0){%>
					 +"<td></td>"
				<%count++;}%>
				;
			}
			if (str == "日式") {
				document.getElementById("stores").innerHTML = ""
				<% count = 0;
				for(Restaurant r:rBeanList){	
					if(r.getRType().equals("日式")){
						if(count%4==0){%>
						+	"<tr>"
						<%}%>
						+ "<td><a href=\"order-meal.jsp?rId="
						+<%="\""+r.getId()+"\""%>
						+"\">"
						+<%="\""+r.getName()+"\""%>
						+"</a></td>"
					<%if(count%4==3){%>	
						+ "</tr>"
					<%}count++;%>
						
				  <%}
				}while(count%4!=0){%>
					 +"<td></td>"
				<%count++;}%>;
			}
			if (str == "點心") {
				document.getElementById("stores").innerHTML = ""
				<% count = 0;
				for(Restaurant r:rBeanList){	
					if(r.getRType().equals("點心")){
						if(count%4==0){%>
						+	"<tr>"
						<%}%>
						+ "<td><a href=\"order-meal.jsp?rId="
						+<%="\""+r.getId()+"\""%>
						+"\">"
						+<%="\""+r.getName()+"\""%>
						+"</a></td>"
					<%if(count%4==3){%>	
						+ "</tr>"
					<%}count++;%>
						
				  <%}
				}while(count%4!=0){%>
					 +"<td></td>"
				<%count++;}%>;
			}
			
}
	</script>

	<!-- banner -->
	<div class="banner1">
		<div class="container">
			<div class="header-nav">
				<nav class="navbar navbar-default"> <!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
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
				<!-- /.navbar-collapse --> </nav>
			</div>
		</div>
	</div>
	<!-- //banner -->
	<!-- single -->
	<div class="single">
		<div class="container">
			<div class="bs-docs-example">
				<div class="menu-title">
					<h3>發起訂餐</h3>
					<div class="line"></div>
				</div>
				<p class="proident">
					請選擇店家，若無需要的店家，請直接申請一個 <a href="addstores.jsp"><span
						class="label label-success">新增店家</span></a>
				</p>
				<br> <span >店家類型</span>

					<select name="type" value="種類" onchange="showStores(this.value)">
						<option value="全部">全部</option>
						<option value="便當">便當</option>
						<option value="速食">速食</option>
						<option value="日式">日式</option>
						<option value="點心">點心</option>
					</select>

				<table class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody id="stores">
						
				
						
						
						
					</tbody>
				</table>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //single -->
	<!--footer-->
	<div class="footer-bottom">
		<div class="container">
			<div class="container">
				<p>&copy; - Copyright 2016© All rights reserved.</p>
			</div>
		</div>
	</div>
	<!--//footer-->
	<!-- for bootstrap working -->
	<script src="js/bootstrap.js">
		
	</script>
	<!-- //for bootstrap working -->
</body>
</html>