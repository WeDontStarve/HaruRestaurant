<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>员工管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>

<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
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
*{ margin:0; padding:0;}
body { font:14px/1.8 arial;}
html, body, .wrap{ height:100%; }
.wrap {
	height:auto;
	min-height:100%;
	_height:100%;
	background: #333;
	color: #fff;
	font-size: 18px;
	text-align: center;
}
.main { padding-bottom:80px; }
.footer {
	position:relative;
	height: 60px;
	margin-top: -60px;
	background: #FF6A6A;
	color: #fff;
	font-size: 16px;
	text-align: :center;
}
</style>

<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-5" data-genuitec-path="/web/WebRoot/StaffManagement.jsp">

<script type="text/javascript">
		$.ajax({
			url : "/res/AdminServlet",
			data : {
				method : "employee",
				action : "display"
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				var json = eval(data);
				var data = "";
				var table = "";
				for (var i = 0, l = json.waiter.length; i < l; i++) {
					table += '<tr>' + '<td>' + '服务员' + '</td>';
					
				        table += '<td>' + json.waiter[i].phone + '</td>';
				        table += '<td>' + json.waiter[i].name + '</td>';
                        table += '<td>' + json.waiter[i].id + '</td>';

                      
				        var a = json.waiter[i].id;
				        //alert(a);
				        table += '<td>' + '<a class="btn btn-default btn-xs" href="DetailInformation_staff.jsp?position=waiter&id='+a+'" role="button">编 辑</a>' 
					        + '<a class="btn btn-default btn-xs" href="DelEmp.jsp?position=waiter&id='+a+'">删 除</a> ' + '</td>';
				        
					
				    
			    }
			    for (var i = 0, l = json.chef.length; i < l; i++) {
					table += '<tr>' + '<td>' + '厨师' + '</td>';
					 table += '<td>' + json.chef[i].phone + '</td>';
                        table += '<td>' + json.chef[i].name + '</td>';
                        table += '<td>' + json.chef[i].id + '</td>';

                      
                        var a = json.chef[i].id;
                        //alert(a);
                        table += '<td>' + '<a class="btn btn-default btn-xs" href="DetailInformation_staff.jsp?position=chef&id='+a+'" role="button">编 辑</a>' 
                            + '<a class="btn btn-default btn-xs" href="DelEmp.jsp?position=chef&id='+a+'">删 除</a> ' + '</td>';
			
			    }
			    table += '<tr>' + '<td>' + '<a class="btn btn-default btn-lg" href="AddEmployee.jsp">添加员工</a>' + '</td>' + '</tr>';
			   //alert(table);
			    $('#StaffTable').append(table);
					
				},
				
			error : function() {
				alert(arguments[1]);
			},
		});
	
</script>


<section id="container" class="wrap" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-5" data-genuitec-path="/web/WebRoot/StaffManagement.jsp">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="Announce.jsp" class="logo">
        小春日和
    </a>
    
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
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <img alt="" src="images/gly.jpg">
                <span class="username">管理员</span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="login.jsp"><i class="fa fa-key"></i>退出登录</a></li>
            </ul>
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="SeatInformation.jsp">
                        <i class="fa fa-dashboard"></i>
                        <span>座位信息</span>
                    </a>
                </li>
                
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>餐厅管理</span>
                    </a>
                    <ul class="sub">
                        <li><a href="StaffManagement.jsp">员工管理</a></li>
                        <li><a href="DishesManagement.jsp">菜品管理</a></li>
                        <li><a href="OrderManagement.jsp">订单管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="Announce.jsp">
                        <i class="fa fa-bullhorn"></i>
                        <span>公告发布</span>
                    </a>
                </li>
               
                <li>
                    <a href="InformationFeedback.jsp">
                        <i class="fa fa-envelope"></i>
                        <span>信息反馈</span>
                    </a>
                </li>
                
            </ul>            
        </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
<div class="wrap">
	<section class="wrapper">
		<div class="table-agile-info">
 <div class="panel panel-default">
    <div class="panel-heading">
     员工信息
    </div>
    <div>
      <table class="table" ui-jq="footable" ui-options='{
        "paging": {
          "enabled": true
        },
        "filtering": {
          "enabled": true
        },
        "sorting": {
          "enabled": true
        }}'>
        <thead>
          <tr>
            <th style="text-align:center;">职位</th>          
            <th style="text-align:center;">电话</th>
            <th style="text-align:center;">姓名</th>
            <th style="text-align:center;">id</th>
            <th style="text-align:center;">操作</th>
          </tr>
        </thead>
        <tbody id="StaffTable">
          
        </tbody>
      </table>
    </div>
  </div>
</div>
</div>
 

<!--main content end-->
</section>


<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</section>
<!-- footer -->
		  <div class="footer">
			<div class="wthree-copyright">
			  <p align="center">Copyright &copy; 2017</p>
			</div>
		  </div>
  <!-- / footer -->
</body>
</html>
