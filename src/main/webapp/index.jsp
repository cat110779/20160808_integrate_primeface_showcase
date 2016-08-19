<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>餓揪訂餐網站</title>
<f:view>
  <h:form>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="refresh" content="1">
<meta name="keywords"content=""/>

   </h:form>
</f:view>
<script type="application/x-javascript">


addEventListener("load", function() {
    setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
    window.scrollTo(0, 1);
}

</script>
<!-- //for-mobile-apps -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css"media="all" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='https://fonts.googleapis.com/css?family=UnifrakturMaguntia'rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:600,600italic,700,400'rel='stylesheet' type='text/css'>
<!-- FlexSlider -->"src/main/web"src/main/webapp/index.jsp"app/index.jsp"
<p:link rel="stylesheet" href="${pageContext.request.contextPath}/css/flexslider.css" type="text/css"media="screen" />
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
	
	// 限制不可輸入中文字
	function chinese_onkeyup(fmobj,cid,cvalue,msg){
	// fmobj : form object
	// cid : columu name
	// cvalue : columu value
	// msg : alert message
	if(!msg){
	msg = "請勿輸入中文字!!!";
	}
	if(cvalue.match(/[\u4E00-\u9FA5]/g)){
	alert(msg);
	fmobj[cid].value=cvalue.replace(/[\u4E00-\u9FA5]/g,"");
	}
	}
	
	//登入
	function login(){
		document.getElementById("type").value = "login";
		document.getElementById("myForm").submit();
	}
	
	//修改密碼
	function changePassword(){
		document.getElementById("type").value = "changePassword";
		document.getElementById("myForm").submit();
	}
	
    


</script>
<!-- //FlexSlider -->
</head>
<body>
	<%
		HttpSession se = request.getSession();
		se.setAttribute("account", null);
	%>
	<!-- banner -->
	<div class="banner">
		<div class="container">
			<div class="header-nav">
				<nav class="navbar navbar-default"> <!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> 
						<span class="icon-bar"></span> <span class="icon-bar"></span> 
						<span class="icon-bar"></span>
					</button>
					<div class="logo">
						<a class="navbar-brand" href="Index.jsp"><b>餓揪訂餐</b><span>Healthy And Tasty Food</span></a>
					</div>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse nav-wil"id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<%
							if (se.getAttribute("account") != null) {
						%>
						<li class="active"><a href="ServiceServelet">回首頁</a></li>
						<li><a href="menu.jsp">我要訂餐</a></li>
						<li><a href="order.jsp">發起訂餐</a></li>
						<li><a href="contact.jsp">聯絡我們</a></li>
						<%
							}
						%>
					</ul>
				</div>
				<!-- /.navbar-collapse --> </nav>
			</div>
			<div class="banner-info">
				<div class="col-md-6 banner-info-left">
					<h1>使用條例</h1>
					<br>
					<h4 style="color:white;">1.本網站不提供任何保證。任何因本服務所造成的傷害或損失，您願意自行負責。</h4>
					<br>
					<h4 style="color:white;">2.您承諾絕不為任何非法目的、以任何非法方式使用本站，並承諾遵守中華民國相關法規及一切使用網際網路之國際慣例。您同意並保證不得利用本服務從事侵害他人權益或違法之行為。</h4>
					<br>
					<h4 style="color:white;">3.您同意本站得基於維護交易安全之考量，或違反本使用條款的明文規定及精神，終止您的密碼、帳號（或其任何部分）或本服務之使用。</h4>
					<br>
				</div>
				<div class="col-md-6 banner-info-right">
					<div class="sap_tabs">
						<div id="horizontalTab"style="display: block; width: 100%; margin: 0px;">
							<ul class="resp-tabs-list">
								<li class="resp-tab-item grid1" aria-controls="tab_item-0"role="tab"><span>登入</span></li>
								<li class="resp-tab-item grid2" aria-controls="tab_item-1"role="tab"><span>註冊</span></li>
								<div class="clear"></div>
							</ul>
							<div class="resp-tabs-container">
								<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
									<div class="facts">
										<div class="sign-in-form">
											<div class="in-form">
												<form id="myForm" method="POST" action="LoginServlet">
													<input type="hidden" id="type" name="type"/>
													<input type="text" name="account" placeholder="帳號" required=required > 
													<input type="password"name="password" placeholder="密碼" required=required >
													<input type="text" name="check_code" placeholder="驗證碼" required=required > 
													<img src="CheckCodeServlet" />
													<br />
													<!--<img src="/learnJS/servlet/CheckCodeServlet"/>-->
													<div class="ckeck-bg">
														<div class="checkbox-form">
															<!--<div class="check-left">
																<div class="check">
																	<label class="checkbox"><input type="checkbox"name="checkbox01" checked=""><i> </i>保持登入</label>
																</div>
																<div class="check">
																	<label class="checkbox"><input type="checkbox"name="checkbox" checked=""><i> </i>記住我的密碼</label>
																</div>
															</div>-->
															<div class="check-right">
																<button type="button" class="btn btn-info btn-lg"data-toggle="modal" data-target="#myModal">忘記密碼</button>
																<button type="button" class="btn btn-info btn-lg" value="登入" onclick="login()" >登入</button>
															</div>
															<div class="clearfix"></div>
														</div>
														
														<!-- Modal start-->
																<div class="modal fade" id="myModal" role="dialog">
																	<div class="modal-dialog">

																		<!-- Modal content-->
																		<div class="modal-content">
																			<div class="modal-header">
																				<button type="button" class="close"data-dismiss="modal">&times;</button>
																				<h4 class="modal-title">忘記密碼</h4>
																			</div>
																			<div class="modal-body">
																			<p>請輸入你的專屬帳號及信箱，稍後將寄一個屬於您的專屬密碼。</p>
																					<input type="text" name="againaccount" placeholder="帳號" required=required /> 
																					<input type="email"name="againemail" placeholder="信箱" required=required />
																					<div class="modal-footer">
																						<button type="button" class="btn btn-info btn-lg" data-dismiss="modal" onclick="changePassword()">送出</button>
																					</div>
																			</div>
																		</div>

																	</div>
																</div>
																<!-- Modal end-->
													</div>
												</form>
											</div>
										</div>
									</div>       
								</div>
								<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts">
										<div class="sign-in-form">
											<div class="in-form Personal">
												<p>歡迎，請輸入以下詳細信息才能註冊。</p>
												<form method="post" action="RegistrationServlet">
													<input type="text" name="newaccount" placeholder="帳號" onkeyup="chinese_onkeyup" required=required />
													<input type="email" name="email" class="textbox"placeholder="信箱" required=required /> 
													<input type="password"name="newpassword" placeholder="密碼" required=required /> 
													<input type="password" name="again" placeholder="再次輸入密碼" required=required />
													<div class="c
													heck">
														<label class="checkbox">
														<input type="checkbox"name="checkbox" >
														<i> </i>我同意使用左邊條款
														</label>
													</div>
													<input type="submit" value="送出">
												</form>
											</div>
										</div>
									</div>
									<!-- facts 註冊 -->
								</div>
								<!-- tab-1 resp-tab-content 註冊 -->
							</div>
							<!-- resp-tabs-container -->
						</div>
					</div>
					<script src="js/easyResponsiveTabs.js" type="text/javascript">
						
					</script>
					<script type="text/javascript">
						$(document).ready(function() {
							$('#horizontalTab').easyResponsiveTabs({
								type : 'default',
								//Types: default, vertical, accordion           
								width : 'auto',
								//auto or any width like 600px
								fit : true
							// 100% fit in a container
							});
						});
					</script>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //banner -->
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

