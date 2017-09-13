<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<span style="font-size:14px;"><link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">  
<link rel="stylesheet" type="text/css" href="css/base.css"></span>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>sign in </title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<style>
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
		<link href="https://v2.bootcss.com/assets/css/bootstrap-respinsive.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	
	<body>
	<body background = "./RES/sig.jpg" style=" background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">
		<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navber-inner">		
			<div class=“container”>
				<img src="./RES/logo.jpg"style="width:50px;">
				<button class="btn btn-large btn-primary"  style="position:absolute;right:10px;"type="submit">Closed</button>
			</div>
		</div>
	</div>
			<div class="list-group"style="margin-top:10%;padding:0%;">
			<a href="#" class="list-group-item active">-</a>
			<a href="#" class="list-group-item">-</a>
			<a href="#" class="list-group-item">-</a>
			<a href="#" class="list-group-item">-</a>
			<a href="#" class="list-group-item">-</a>
			<a href="#" class="list-group-item">-</a>
			<a href="#" class="list-group-item">-</a>
			
			</div>
		</div>
		<form class="form-inline" role="form">
		<input type="text" class="input-block-level" placeholder = "桌号">
		<button type="button" class="btn btn-success">催促</button>
		</form>
	
	</body>


</html>