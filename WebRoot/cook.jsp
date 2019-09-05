<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>cook</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.table {
	text-align: center
}

.btn {btn-color =#000000;
	
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
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<script src="js/jquery.min.js"></script>
<link rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script type="text/javascript">
	var menu = "";
	var tablemess = "";
	var fir = -1;
	$(function() {
		getData3();
	});

	function getData1(i) {
		$
				.ajax({
					url : "/res/CheifServlet",
					data : {
						method : "display_order",
						order_id : i
					},
					type : 'post',
					dataType : 'json',
					success : function(data) {
						console.log(data);
						menu = data;

						var table_str = "<table class = \"table\"><tr><td><input type=\"hidden\"></td><td>菜名</td><td>份数</td><td>上菜</td></tr>";
						//var table_str = "<div class='row'><></div>"
						for ( var key in menu) {
						
							
							if (menu[key].state == 0) {
								table_str = table_str
										+ "<tr><td><input type=\"hidden\" value=i></td><td>"
										+ menu[key].dish_name
										+ "</td><td>"
										+ menu[key].num
										+ "</td><td><form action=\"Chef.action\" method=\"post\"><input name =\"order_id\" type=\"hidden\" value="+i+"><input name =\"dish_name\" type=\"hidden\" value="+menu[key].dish_name+"><input  name=\"dish_num\" type=\"hidden\" value="+menu[key].num+"><button type=\"submit\" class=\"btn btn-success\">上菜</button></form></td></tr>";							
							
							}
						}
						table_str = table_str + "</table>";
						document.getElementById("test1").innerHTML = table_str;
					
					},
					error : function() {
						alert("服务器没有返回数据，可能服务器忙，请重试");
					},
				});

	}

	function clickaction(td) {
		var str = td.innerText;
		//var arr =str.match((.*)(<br/>)(.*)); a<br/>b 可能用正则表达式可以提取出a吧
		var arr = str.split("桌")
		getData1(arr[0]);
	}

	function getData2() {

		$
				.ajax({
					url : "/res/CheifServlet",
					data : {
						method : "display_all"
					},
					type : 'post',
					dataType : 'json',
					async : false,
					success : function(data) {
						tablemess = data;
						var table_str = " <table class = \"table table-bordered\" style=\"height:100%;\">";
						var k = 0;
						for ( var key in tablemess)
							k++;
						for (var i = 0; i < 2; i++) {
							table_str = table_str + "<tr class = \"success\">";
							for (var j = 0; j < 8; j++) {
								if (k > i * 8 + j) {
									if(fir<0){
									
										fir=tablemess[i * 8 + j].order_id;
										
									}table_str = table_str
											+ "<td onclick=clickaction(this)>"
											+ tablemess[i * 8 + j].order_id
											+ "桌号"
											+ tablemess[i * 8 + j].table_id
											+ "</td>";
								} else {
									table_str = table_str + "<td></td>";
								}
							}
							table_str = table_str + "</tr>"
						}

						table_str = table_str + "</table>";
						document.getElementById("test20").innerHTML = table_str;
					},
					error : function() {
						alert("服务器没有返回数据，可能服务器忙，请重试");
					},
				});

	}
	function aaa() {
		getData2();
	}

	var inform = "";
	var total = 0;
	var num = 0;
	function getData3() {
		$
				.ajax({
					url : "/res/AnnounceServlet",
					type : 'post',
					dataType : 'json',
					success : function(data) {
						num = 0;
						total = 0;
						console.log(data);
						inform = data;
						for ( var key in inform) {
							total++;
							if (inform[key].position == "chef")
								num++;
						}
						var list_str = "";

						if (num >= 1) {
							for (var i = 0; i < 1; total--) {//因为菜单数不足，所以此段大于十还没有测试
								if (inform[total - 1].position == "chef") {
									list_str = list_str
											+ "<a href=\"#\" class=\"list-group-item\">"
											+ inform[total - 1].announce
											+ "</a>";
									i++;
								}
							}
						} else {
							list_str = list_str
									+ "<a href=\"#\" class=\"list-group-item\">-</a>";
							total--;
						}
						document.getElementById("test3").innerHTML = list_str;
					},
					error : function() {
						alert("服务器没有返回数据，可能服务器忙，请重试");
					},
				});
	}
</script>

</head>

<body>
<body background="./RES/sig.jpg"
	style=" background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navber-inner">
			<div class=“container”>
			    <input type="text" class="form-control" value="${userid3 }" style="width:100px;position:absolute;top:10px;right:100px;" placeholder="id">
			    <a class="btn btn-large btn-primary" href="login.jsp" style="position:absolute;top:10px;right:10px;">返回</a>
				<img src="./RES/logo.jpg" style="width:50px;">
				<div id="test3" class="list-group"
					style="width:80%;padding-left:10%;padding-top:0%;"></div>
				<button class="btn btn-large btn-primary"
					style="position:absolute;right:10px;" onclick="aaa()">Show</button>
			</div>
		</div>
	</div>

	<form class="form-inline" role="form" style="height:80%;padding:5%;">
		<div class="row">
		<div class="col-lg-8">
			
				<!-- table class = "table table-bordered" style="height:100%;">
						<tr class = "success"><td onclick=clickaction(this)></td><td onclick=clickaction(this)></td>
						<td onclick=clickaction(this)></td><td onclick=clickaction(this)></td>
						<td onclick=clickaction(this)></td><td onclick=clickaction(this)></td>
						<td onclick=clickaction(this)></td><td onclick=clickaction(this)></td></tr>
						<tr class = "success"><td onclick=clickaction(this)>202</td><td onclick=clickaction(this)></td>
						<td onclick=clickaction(this)></td><td onclick=clickaction(this)></td>
						<td onclick=clickaction(this)></td><td onclick=clickaction(this)></td>
						<td onclick=clickaction(this)></td><td onclick=clickaction(this)></td></tr>
						</table-->

				<div id="test20"><script>aaa();</script></div>

			</div>
			<div class="col-lg-4">
				<div class="panel panel-default" placeholder="col-xs-4">
					<div class="panel-heading">菜单内容</div>


					<div id="test1"><script>getData1(fir);</script></div>


				</div>
			</div>

			
	</form>

	<div class="navbar navbar-inverse navbar-fixed-bottom">

		<div class="navber-inner">
			<div class=“container”>
				<a class="brand"
					style="width:100%; position:fixed;text-align:center; bottom:20px;"
					href="#">小春日和餐厅到店点餐系统</a> <a class="brand"
					style="width:100%; position:fixed;text-align:center;bottom:0px;"
					href="#">联系电话：025-1234 5678</a>
			</div>
		</div>
	</div>
</html>