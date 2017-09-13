<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>sign in </title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

	  .table{
	  text-align:center
	  }
	  .btn{
	  	btn-color=#000000;
	  }
      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body background = "./RES/timg.jpg" style=" background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">

		<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navber-inner">		
			<div class=“container”>
			<img   class="img-responsive "src="./RES/logo.jpg"style="width:50px;">
			</div>
		</div>
		</div>
		<div class="container" style="padding:10%">
			<form class="form-signin" action="login.spring" method="post">
				<h2 class="form-signin-heading">Please sign in</h2>
				<input type="text" class="input-block-level" placeholder = "Email address">
				<input type="password" class="input-block-level" placeholder = "Password">
				<div class="btn-group btn-block">
					<button type="button" class="btn btn-primary btn-sm btn-block" data-toggle="dropdown">身份选择
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a value="1" href="#">顾客登陆</a></li>
						<li class="divider"></li>
						<li><a href="#">管理员登陆</a></li>
						<li><a href="#">后厨登陆</a></li>
						<li><a href="#">服务员登陆</a></li>
					</ul>
						<button class="btn btn-large btn-primary btn-block"  style="float:top;margin-top:10px;"type="submit">Sign in</button>
				</div>
				
				
			</form>
		</div>
		<div class="navbar navbar-inverse navbar-fixed-bottom">
		<div class="navber-inner">		
			<div class=“container”>
				<a class="brand"style="width:100%; position:fixed;text-align:center; bottom:20px;" href="#">小春日和餐厅到店点餐系统</a>
				<a class="brand"style="width:100%; position:fixed;text-align:center;bottom:0px;" href="#">联系电话：025-1234 5678</a>
			</div>
		</div>
		</div>
  </body>
</html>
