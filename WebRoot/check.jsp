<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>check</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap.min.css">
	</head>
	<body background = "./RES/4.jpg" style=" background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">
<%
session.invalidate();//销毁session
%>
		<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navber-inner">		
			<div class=“container”>
				<img   class="img-responsive "src="./RES/logo.jpg"style="width:50px;">
			</div>
		</div>
		</div>
	
	    <form class="form-inline" role="form"  name="form1" action="login.do" method="post"style="padding:10%;wight:100%;text-align:center;">
	    <div class="row" style="padding-bottom:100px;">
			<a href="login.jsp"><img class="img-responsive img-circle" src="./RES/1.jpg" style="float:right;margin-right:30px;height:250px;weight:250px;"></a>
			</div>
			<div class="row">
			<a href="gukechushi.jsp"><img class="img-responsive img-circle" src="./RES/2.jpg" style="float:right;margin-right:30px;height:250px;weight:250px;"></a>
			</div>
		</form>

		<div class="navbar navbar-inverse navbar-fixed-bottom">
			<div class="navber-inner">	
				<div class=“container”>
				<a class="brand"style="position:fixed; bottom:0px;z-index:2" href="reg.jsp">还没注册？我要注册</a>
				
				<a class="brand"style="width:100%; position:fixed;text-align:center; bottom:20px;" href="#">小春日和餐厅到店点餐系统</a>
				<a class="brand"style="width:100%; position:fixed;text-align:center;bottom:0px;" href="#">联系电话：025-1234 5678</a>
				</div>
			</div>
		</div>
	</body>


</html>