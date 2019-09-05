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
		<mata http-equiv="refresh" content="5">
		<link rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<script src="js/jquery.min.js"></script>
		<script type="text/javascript">
		var inform =""; 
		var num =0;
		var total=0;
		function getData1(){
					$.ajax({ 
            	    url: "/res/AnnounceServlet",  
             	  	type: 'post',  
             	 	dataType: 'json',  
             	 	success: function(data) { 
            	 	console.log(data);
            	 	inform=data;
         	   		for(var key in inform){
         	   		total++;         	   		
         	   		if(inform[key].position=="waiter")
         	   		num++;        	
         	   		}
         	   		var list_str="";
         	   if(num>=10){
         	   for(var i=0;i<10;total--){//因为菜单数不足，所以此段大于十还没有测试
         	   	if(inform[total-1].position=="waiter"){
         	   		list_str=list_str+"<a href=\"#\" class=\"list-group-item\">"+inform[total-1].announce+"</a>";
         	   		i++;
         	   		}       	   
         	   	}
         	   }else{
         	   		for(var i=0;i<num;){
         	   			if(inform[total-1].position=="waiter"){         
         	   			list_str=list_str+"<a href=\"#\" class=\"list-group-item\">"+inform[total-1].announce+"</a>";
         	   			i++;
         	   		}
         	   		total--; 	   
         	   	}
         	   	for(var i=num;i<10;i++)
         	   		    list_str=list_str+"<a href=\"#\" class=\"list-group-item\">-</a>"; 
         	   }
         	   document.getElementById("test1").innerHTML=list_str;
         	   },
            	 	   error: function(){
            	 	   alert("服务器没有返回数据，可能服务器忙，请重试");
           	     },
         	   }); 
     	   }  							  							
		</script>
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
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	
	<body>
	<a class="btn btn-large btn-primary" href="login.jsp" style="position:absolute;top:10px;right:10px;">退 出</a>
	<body background = "./RES/sig.jpg" style=" background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">
		<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navber-inner">		
			<div class=“container”>
				<img src="./RES/logo.jpg"style="width:50px;">
				<input type="text" class="form-control" value="${userid2 }" style="width:100px;position:absolute;top:10px;right:100px;" placeholder="id">
				<a class="btn btn-large btn-primary" href="login.jsp" style="position:absolute;top:10px;right:10px;">返回</a>
			</div>
		</div>
	</div>
			<div class="list-group" id="test1"style="margin-top:10%;padding:0%;">
			<script>getData1();</script>
			</div>
		<form class="form-inline" role="form" action ="urge.action" method="post" >
		<input type="text" name="urgemessage" class="input-block-level" placeholder = "桌号">
		<button type="submit" class="btn btn-success">催促</button>
		</form>
	
	</body>


</html>