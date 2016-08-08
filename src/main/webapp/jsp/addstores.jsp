<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>餓揪訂餐網站</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Deliccio Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/global.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- FlexSlider -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script defer src="js/jquery.flexslider.js"></script>
<script type="text/javascript">
						$(window).load(function(){
						  $('.flexslider').flexslider({
							animation: "slide",
							start: function(slider){
							  $('body').removeClass('loading');
							}
						  });
						});
					  </script>
<!-- //FlexSlider -->
</head>
<body>
<!-- banner -->
<div class="banner1">
  <div class="container">
    <div class="header-nav">
      <nav class="navbar navbar-default"> 
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <div class="logo"> <a class="navbar-brand" href="index.html">餓揪訂餐 <span>Healthy And Tasty Food</span></a> </div>
        </div>
        
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li class="active"><a href="services.html">回首頁</a></li>
            <li><a href="menu.html">我要訂餐</a></li>
            <li><a href="order.html">發起訂餐</a></li>
            <li><a href="contact.html">聯絡我們</a></li>
            <li><a href="index.html">登出</a> </li>
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
    <div class="line"> </div>
  </div>
</div>
<div id="header01">
  <form action="" id="form01" method="post">
    <div style="display:none">
      <input type="hidden" name="form:hf:0" id="form:hf:0" />
    </div>
     <table class="bigForm" >
       
       <tr class="title">
         <th colspan="2">基本資料</th>
       </tr>
       <tr>
         <td class="label01"><span class="required">*</span>名稱:</td>
         <td><input name="updateShopPanel:name" style="width: 30em;" type="text" maxlength="20" value=""/>
         </td>
       </tr>
       <tr>
         <td class="label01">簡介:</td>
         <td><input name="updateShopPanel:description" style="width: 30em;" type="text" maxlength="40" value=""/></td>
       </tr>
	   <tr>
         <td class="label01">電話:</td>
         <td><input name="updateShopPanel:telNo" style="width: 30em;" type="text" maxlength="40" value=""/></td>
       </tr>
	   <tr>
         <td class="label01">地址:</td>
         <td><input name="updateShopPanel:telNo" style="width: 30em;" type="text" maxlength="40" value=""/></td>
       </tr>
       <tr class="title">
         <th colspan="2">產品設定</th>
       </tr>
	   <tr>
         <td class="label01"><span class="required">*</span>產品:</td>
         <td>
	<div style="float: left;" >
		<textarea name="updateShopPanel:editProductDetailField:editProductDetail" style="line-height: 1.4em;" id="editProductDetail" rows="17" cols="50"></textarea>
	</div>&nbsp;
	<textarea cols="30" id="productDemo" name="demo" rows="17" disabled="disabled" style="line-height: 1.4em; color: #666; background-color: #FAFAFA; border: 1px solid #A6A6A6;" >
魯肉飯, 40
叉燒飯, 60
雞排飯, 70
{麵食}
牛肉麵, 意麵 80, 手工麵 90
陽春麵, 普通 40, 加蛋 50
{飲料冰品}
奶茶, S 20, M 30, L 40
冰咖啡, 中杯 40, 大杯 50
{下午茶系列}
香辣雞排, 40, img:1
甜甜圈, 大 40, 小 30, img:13</textarea>
</td>
       </tr>
       <tr class="title">
         <th colspan="2">其他資料</th>
       </tr>
	   	 <td class="label01">店家服務類型:</td>
	   	 <td>
	   		<div>
      	
		 <table id="checkBoxTable" class="standard" >
          <tr>
            <td>
               <input name="updateShopPanel:serviceType:selectedServiceTypes" id="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_0_serviceType" type="checkbox" value="check9"/> 
               <label01 for="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_0_serviceType" style="cursor: pointer;">便當</label01>
            </td><td>
               <input name="updateShopPanel:serviceType:selectedServiceTypes" id="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_1_serviceType" type="checkbox" value="check10"/> 
               <label01 for="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_1_serviceType" style="cursor: pointer;">素食</label01>
            </td><td>
               <input name="updateShopPanel:serviceType:selectedServiceTypes" id="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_2_serviceType" type="checkbox" value="check11"/> 
               <label01 for="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_2_serviceType" style="cursor: pointer;">日式</label01>
            </td><td>
               <input name="updateShopPanel:serviceType:selectedServiceTypes" id="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_3_serviceType" type="checkbox" value="check12"/> 
               <label01 for="form_updateShopPanel_serviceType_selectedServiceTypes_rows_0_cols_3_serviceType" style="cursor: pointer;">點心</label01>
            </td>
          </tr>
         </table>
        
	</div>

       <tr class="title">
         <th colspan="2">儲存</th>
       </tr>
       <tr >
         <td ></td>
         <td style="padding-top: 1em;">
         	<input name="complete" type="button" value="儲存" onclick="location.href='menu.html'"/>
		</td>
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
      <p>&copy;  - Copyright 2016© All rights reserved.</p>
    </div>
  </div>
</div>
<!--//footer--> 
<!-- for bootstrap working --> 
<script src="js/bootstrap.js"> </script> 
<!-- //for bootstrap working -->
</body>
</html>