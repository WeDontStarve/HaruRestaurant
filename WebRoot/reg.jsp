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
<title>register</title>
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
  </head>
  
  <body background = "./RES/4.jpg" style=" background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">
		<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navber-inner">		
			<div class=“container”>${msg}
			<img   class="img-responsive "src="./RES/logo.jpg"style="width:50px;">
			</div>
		</div>
		</div>
		
		<div class="container">
			<form class="form-signin" action="register.action" method="post">
				<h2 class="form-signin-heading">请注册</h2>
				<input type="text" name="regusername" class="input-block-level" placeholder = "用户名">
				<input type="password" name="regpassword" class="input-block-level" placeholder = "密码">
				<input type="password" name="confirm" class="input-block-level" placeholder = "重复输入密码">
				<input type="text" name="ID" class="input-block-level" placeholder = "身份证号码">
				<input type="text" name="phone" class="input-block-level" placeholder = "电话号码">
				<input type="text" name="resName" class="input-block-level" placeholder = "餐厅名称">
				<input type="text" name="resAdd" class="input-block-level" placeholder = "餐厅地址">
				<!-- <input type="text" name="yanzheng" class="input-block-level" placeholder = "yanzhengma">-->
				<button class="btn btn-large btn-primary btn-block"  style="float:top;margin-top:10px;"type="submit">Sign up</button>
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
		
		<%String message=(String)session.getAttribute("msg");%>
		<% if("".equals(message)){
			
		}
		else if(message==null)
		{
			
		}
		else{%>
    <script type="text/javascript">
        alert("<%=message%>");
    </script>
    <%session.setAttribute("msg",null);}%>
		
  </body>
</html>
