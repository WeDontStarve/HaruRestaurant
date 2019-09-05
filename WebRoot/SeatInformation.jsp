<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>座位信息</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet" />

<link rel="stylesheet" href="css/lightbox.css">
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
<!-- //font-awesome icons -->
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<script type="text/javascript">
	var menu = "";
	var tablemess = "";
	var fir = -1;
	$(function() {
		getData3();
	});
	
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
							if (inform[key].position == "manager")
								num++;
						}
						var list_str = "";

						if (num >= 1) {
							for (var i = 0; i < 1; total--) {//因为菜单数不足，所以此段大于十还没有测试
								if (inform[total - 1].position == "manager") {
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
						document.getElementById("top_menu").innerHTML = list_str;
					},
					error : function() {
						alert("服务器没有返回数据，可能服务器忙，请重试");
					},
				});
	}
</script>
	


<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	font: 14px/1.8 arial;
}

html, body, .wrap {
	height: 100%;
}

.wrap {
	height: auto;
	min-height: 100%;
	_height: 100%;
	background: #333;
	color: #333;
	font-size: 18px;
	text-align: center;
}

.main {
	padding-bottom: 80px;
}

.footer {
	position: relative;
	height: 60px;
	margin-top: -60px;
	background: #FF6A6A;
	color: #fff;
	font-size: 16px;
	text-align: :center;
}
</style>

<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-4"
	data-genuitec-path="/web/WebRoot/SeatInformation.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-6" data-genuitec-path="/res/WebRoot/SeatInformation.jsp">
	<script type="text/javascript">
		$.ajax({
			url : "/res/AdminServlet",
			data : {
				method : "seat",
				action : "display"
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				var json = eval(data);
				var data = "";
				var table = "";
				for (var i = 0, l = json.length; i < l; i++) {
					for (var key in json[i]) {
					    var ID = "tableId";
					    if(key == ID){
					        var id=json[i][key]; 					        			        
					    }
					    var Seat = "tableSeat";
					    if(key == Seat){
					        //alert(json[i][key]);
					        //$('#'+id).append(json[i][key]);
					        var number=json[i][key];
					    }
						var Status = "tableStatus";
						if(key == Status){
						    if(json[i][key]==1){
						        $('#'+id).html('<img src="images/deskdis.png" />');
						        $('#'+id).append(id + '号桌');
						        if(number <= 8){
						            $('#'+id).append('<br>' + '可坐' + number + '人');
						        }else{
						            $('#'+id).append('<br>' + '8人以上');    
						        }
						    }else{
						        $('#'+id).html('<img src="images/deskav.png" />');
						        $('#'+id).append(id + '号桌');
						        if(number <= 8){
						            $('#'+id).append('<br>' + '可坐' + number + '人');
						        }else{
						            $('#'+id).append('<br>' + '8人以上');    
						        }
						    }
						    var last = id+1;
						    $('#'+last).html('<a class="btn btn-default" style="width:80px;height:80px;" href="AddTable.jsp">添加<br>桌子</a>');
						    //alert(json[i][key]);
						}
					}
				}
			},
			error : function() {
				alert(arguments[1]);
			},
		});
	
</script>
	
	<section id="container" class="wrap" data-genuitec-lp-enabled="false"
		data-genuitec-file-id="wc2-4"
		data-genuitec-path="/web/WebRoot/SeatInformation.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-6" data-genuitec-path="/res/WebRoot/SeatInformation.jsp"> <!--header start-->
	<header class="header fixed-top clearfix"> <!--logo start-->
	<div class="brand">
		<a href="Announce.jsp" class="logo"> 小春日和 </a>

		<div class="sidebar-toggle-box">
			<div class="fa fa-bars"></div>
		</div>
	</div>
<div class="nav notify-row" id="top_menu">
   <input type="text" class="form-control" style="width:500px">
</div>


	<div class="top-nav clearfix">
		<!--search & user info start-->
		<ul class="nav pull-right top-menu">
			<li>
            <p>id为</p>
        </li>
        <li>
            <input type="text" class="form-control" style="width:50px" value="${userid }">
        </li>
			<!-- user login dropdown start-->
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#"> <img alt=""
					src="images/gly.jpg"> <span class="username">管理员</span> <b
					class="caret"></b>
			</a>
				<ul class="dropdown-menu extended logout">
					<li><a href="login.jsp"><i class="fa fa-key"></i>退出登录</a></li>
				</ul></li>
			<!-- user login dropdown end -->

		</ul>
		<!--search & user info end-->
	</div>
	</header> <!--header end--> <!--sidebar start--> <aside>
	<div id="sidebar" class="nav-collapse">
		<!-- sidebar menu start-->
		<div class="leftside-navigation">
			<ul class="sidebar-menu" id="nav-accordion">
				<li><a class="active" href="SeatInformation.jsp"> <i
						class="fa fa-dashboard"></i> <span>座位信息</span>
				</a></li>

				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-book"></i> <span>餐厅管理</span>
				</a>
					<ul class="sub">
						<li><a href="StaffManagement.jsp">员工管理</a></li>
						<li><a href="DishesManagement.jsp">菜品管理</a></li>
						<li><a href="OrderManagement.jsp">订单管理</a></li>
					</ul></li>
				<li><a href="Announce.jsp"> <i class="fa fa-bullhorn"></i>
						<span>公告发布</span>
				</a></li>

				<li><a href="InformationFeedback.jsp"> <i
						class="fa fa-envelope"></i> <span>信息反馈</span>
				</a></li>

			</ul>
		</div>
		<!-- sidebar menu end-->
	</div>
	</aside> <!--sidebar end--> <!--main content start--> <section
		id="main-content"> <section class="wrapper"> <!-- gallery -->
	<!-- gallery -->
	<div class="gallery">
		<h2 class="w3ls_head">座位信息</h2>
		<div class="gallery-grids">
			<div class="gallery-top-grids">
				<div id="1" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 1 -->
					</div>
				</div>
				<div id="2" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 2 -->
					</div>
				</div>
				<div id="3" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 3 -->
					</div>
				</div>
				<div id="4" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 4 -->
					</div>
				</div>
				<div id="5" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 5 -->
					</div>
				</div>
				<div id="6" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 6 -->
					</div>
				</div>
				<div id="7" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 7 -->
					</div>
				</div>
				<div id="8" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 8 -->
					</div>
				</div>
				<div id="9" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 9 -->
					</div>
				</div>
				<div id="10" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 10 -->
					</div>
				</div>
				<div id="11" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 11 -->
					</div>
				</div>
				<div id="12" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 12 -->
					</div>
				</div>

				<div class="clearfix"></div>
			</div>

			<div class="gallery-top-grids">
				<div id="13" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 1 -->
					</div>
				</div>
				<div class="col-sm-1 gallery-grids-left">
					<div id="14" class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 2 -->
					</div>
				</div>
				<div id="15" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 3 -->
					</div>
				</div>
				<div id="16" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 4 -->
					</div>
				</div>
				<div id="17" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 5 -->
					</div>
				</div>
				<div id="18" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 6 -->
					</div>
				</div>
				<div id="19" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 7 -->
					</div>
				</div>
				<div id="20" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 8 -->
					</div>
				</div>
				<div id="21" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 9 -->
					</div>
				</div>
				<div id="22" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 10 -->
					</div>
				</div>
				<div id="23" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 11 -->
					</div>
				</div>
				<div id="24" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 12 -->
					</div>
				</div>

				<div class="clearfix"></div>
			</div>

			<div class="gallery-top-grids">
				<div id="25" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 1 -->
					</div>
				</div>
				<div id="26" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 2 -->
					</div>
				</div>
				<div id="27" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 3 -->
					</div>
				</div>
				<div id="28" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 4 -->
					</div>
				</div>
				<div id="29" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 5 -->
					</div>
				</div>
				<div id="30" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 6 -->
					</div>
				</div>
				<div id="31" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 7 -->
					</div>
				</div>
				<div id="32" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 8 -->
					</div>
				</div>
				<div id="33" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 9 -->
					</div>
				</div>
				<div id="34" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 10 -->
					</div>
				</div>
				<div id="35" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 11 -->
					</div>
				</div>
				<div id="36" class="col-sm-1 gallery-grids-left">
					<div class="gallery-grid">
						<img src="images/background.png" alt="" />
						<!-- 12 -->
					</div>
				</div>

				<div class="clearfix"></div>
			</div>

			<script src="js/lightbox-plus-jquery.min.js"> </script>

		</div>
	</div>
	

	</section>

	</section> <!--main content end--> <script src="js/bootstrap.js"></script> <script
		src="js/jquery.dcjqaccordion.2.7.js"></script> <script
		src="js/scripts.js"></script> <script src="js/jquery.slimscroll.js"></script>
	<script src="js/jquery.nicescroll.js"></script> <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="js/jquery.scrollTo.js"></script> </section>
	<!-- footer -->
	<div class="footer">
		<div class="wthree-copyright">
			<p align="center">Copyright &copy; 2017</p>
		</div>
	</div>
	<!-- / footer -->


</body>
</html>
