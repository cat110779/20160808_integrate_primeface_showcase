<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<link href="css/global.css" rel="stylesheet" type="text/css" media="all" />
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
<body>
<%
	HttpSession se = request.getSession();
	if(se.getAttribute("account")==null){
		response.sendRedirect("Index.jsp");
	}
%>
<script type="text/javascript">
	function ValidateNumber(e, pnumber)
	{
	    if (!/^\d{1,6}$/.test(pnumber))
	    {
	        e.value = /^\d{1,6}$/.exec(e.value);
	    }
	    return false;
	}
</script>
	<script>
		function add_new_data() {

			var num = document.getElementById("mytable").rows.length;

			var Tr = document.getElementById("mytable").insertRow(num);

			Td = Tr.insertCell(Tr.cells.length);

			Td.innerHTML = '<input name="productName" type="text" size="16">';

			Td = Tr.insertCell(Tr.cells.length);
			Td.innerHTML = '<input name="price" type="text" size="16" onkeyup="return ValidateNumber(this,value)">';
			Td = Tr.insertCell(Tr.cells.length);
			Td.innerHTML = '<input type="button" class="btn btn-default" value="刪除" required="" onclick="deleteRow(this)">';

		}

		function remove_data() {

			var num = document.getElementById("mytable").rows.length;

			if (num > 2) {

				document.getElementById("mytable").deleteRow(-1);
			}

		}
		function deleteRow(r) {
			var i = r.parentNode.parentNode.rowIndex;
			var num = document.getElementById("mytable").rows.length;
			if(num>2)
				document.getElementById("mytable").deleteRow(i);
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
							<a class="navbar-brand" href="Index.jsp"><b>餓揪訂餐 </b><span>Healthy
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
	<!-- single -->
	<div class="services">
		<div class="container">
			<h3>新增店家</h3>
			<div class="line"></div>
		</div>
	</div>
	<div id="header01">
		<form action="AddServlet" id="form01" method="post">
			<div style="display: none">
				<input type="hidden" name="form:hf:0" id="form:hf:0" />
			</div>
			<table class="bigForm">

				<tr class="title">
					<th colspan="2">基本資料</th>
				</tr>
				<tr>

					<td class="label01"><span class="required">*</span>名稱:</td>
					<td><input name="Name" style="width: 30em;" type="text"
						maxlength="40" value="" required=""/></td>
				</tr>
				<tr>
					<td class="label01">簡介:</td>
					<td><input name="Brief" style="width: 30em;" type="text"
						maxlength="40" value="" /></td>
				</tr>
				<tr>
					<td class="label01">電話:</td>
					<td><input name="Phone" style="width: 30em;" type="text"
						maxlength="40" value="" required=""/></td>
				</tr>
				<tr>
					<td class="label01">地址:</td>

					<td><input name="Addr" style="width: 30em;" type="text"
						maxlength="40" value="" required=""/></td>
<!-- 
				</tr>

				<tr class="title">
					<th colspan="2">圖片上傳與設定</th>
				</tr>
				<tr>
					<td class="label01"></td>
					<td>



						<form name="form1" method="post" action="UploadServlet"
							enctype="multipart/form-data">
							<table width="274" border="1">
								<tr>
									<td width="210" height="62">上傳圖片：<input type="file"
										name="Submit" value="瀏覽.."></td>
									<td width="48"></td>
								</tr>
								<tr>
									<td height="49">圖片檔案格式:</td>
									<td><input type="submit" name="Submit2" value="上傳"></td>
								</tr>
							</table>
						</form>


					</td>
				</tr>

-->



				<tr class="title">
					<th colspan="2">產品設定</th>
				</tr>
				<tr>
					<td class="label01"><span class="required">*</span>產品:</td>
					<td>


						<div style="float: left; width:40em;" >
							<table id="mytable" class="table-bordered"  border="1">
								<tbody>
									<tr>
										<td style=" width:150; text-align:center;" class="td01">名稱</td>
										<td style=" width:150; text-align:center;" class="td01">價格</td>
										
									</tr>

									<tr>
										<td><input name="productName" type="text" size="16"
											value="" required=""></td>
										<td><input name="price" type="text" size="16" value=""
											required="" onkeyup="return ValidateNumber(this,value)"></td>
										<td><input type="button" value="刪除"
											onclick="deleteRow(this)"></td>
									</tr>


									<tr>
										<td><input name="productName" type="text" size="16" required=""></td>
										<td><input name="price" type="text" size="16" onkeyup="return ValidateNumber(this,value)" required=""></td>
										<td><input type="button" value="刪除"
											onclick="deleteRow(this)"></td>
									</tr>
									<tr>
										<td><input name="productName" type="text" size="16" required=""></td>
										<td><input name="price" type="text" size="16" onkeyup="return ValidateNumber(this,value)" required=""></td>
										<td><input type="button" value="刪除"
											onclick="deleteRow(this)"></td>
									</tr>

								</tbody>
							</table>
							<input type="button" value="增加"  class="btn btn-default"onclick="add_new_data()">
							<input type="button" value="減少" class="btn btn-default" onclick="remove_data()"><br>

						</div>&nbsp;

					</td>
				</tr>
				<tr class="title">
					<th colspan="2">其他資料</th>
				</tr>
				<td class="label01">店家服務類型:</td>
				<td>
					<div>

						<table id="checkBoxTable" class="standard">
							<tr>
								<td><input name="Rtype"
									id="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_0_serviceType"
									type="radio" value="便當" CHECKED/> <label01
										for="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_0_serviceType"
										style="cursor: pointer;">便當</label01></td>
								<td><input name="Rtype"
									id="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_1_serviceType"
									type="radio" value="速食" /> <label01
										for="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_1_serviceType"
										style="cursor: pointer;">速食</label01></td>
								<td><input name="Rtype"
									id="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_2_serviceType"
									type="radio" value="日式" /> <label01
										for="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_2_serviceType"
										style="cursor: pointer;">日式</label01></td>
								<td><input name="Rtype"
									id="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_3_serviceType"
									type="radio" value="點心" /> <label01
										for="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_3_serviceType"
										style="cursor: pointer;">點心</label01></td>
							</tr>
						</table>

					</div>
				<tr class="title">
					<th colspan="2">儲存</th>
				</tr>
				<tr>
					<td></td>
					<td style="padding-top: 1em;">
					<input class="btn btn-default"type="submit" value="儲存" /></td>
				</tr>
				<tr>
			</table>
		</form>
	</div>
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