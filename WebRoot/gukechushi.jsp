<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8;" />
<title>顾客初始</title>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<style>
			body{
				
				background-image:url(images/3.jpg);
				
				background-repeat:no-repeat ;
                background-size:100% 100%; 
                background-attachment: fixed;               
			}
			.btn:active {
                background: #D2691E;
                box-shadow: 0 5px #666;
                transform: translateY(4px);
            }

		</style>

</head>
<body>        


					 <button type="button" class="btn btn-default btn-lg " style="position:absolute;left:250px;top:150px;width:120px;height:120px;border-radius:60px ;background:#F4A460;color: white;font-size:30px;border: 2px solid white;outline: none; " onclick="window.open('./gukediancan.html')">点 餐</button>
				
					 <button type="button" class="btn btn-default btn-lg" style="position:absolute;left:1000px;top:150px;width:120px;height:120px;border-radius:60px ;background:#F4A460;color: white;font-size:30px;border: 2px solid white;outline: none;">服 务</button>
				
					 <button type="button" class="btn btn-default btn-lg" style="position:absolute;left:250px;top:350px;width:120px;height:120px;border-radius:60px ;background:#F4A460;color: white;font-size:30px;border: 2px solid white; outline: none;">买 单</button>
				
					 <button type="button" class="btn btn-default btn-lg" style="position:absolute;left:1000px;top:350px;width:120px;height:120px;border-radius:60px ;background:#F4A460;color: white;font-size:30px;border: 2px solid white; outline: none;" onclick="window.open('./gukefankui.html')">反 馈</button>
					


				
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>