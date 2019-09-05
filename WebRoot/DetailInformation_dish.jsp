<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>菜品详细信息</title>
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

<style type="text/css">
*{ margin:0; padding:0;}
body { font:14px/1.8 arial;}
html, body, .wrap{ height:100%; }
.wrap {
	height:auto;
	min-height:100%;
	_height:100%;
	background: #333;
	color: #333;
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

<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script><script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
</head>


<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-1" data-genuitec-path="/web/WebRoot/Announce.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-4" data-genuitec-path="/res/WebRoot/Announce.jsp">
	<script type="text/javascript">
	
		
		$.ajax({
			url : "/res/AdminServlet",
			data : {
				method : "dish",
				action : "change",
				id : "<%=request.getParameter("id") %>"
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				$("#name").val(data.dishName);
			    //$("#ID").val(data.dishId);
				$("#img").val(data.dishImg);
				$("#price").val(data.dishPrice);
				$("#class").val(data.classification);
				$("#dis").val(data.dishDis);
				$("#rec").val(data.recommend);
				<%
				    String id = request.getParameter("id");
				    System.out.print(id);
				%>;
				//alert(<%=request.getParameter("id") %>);
			},
			error : function() {
				alert("error");
			},
		});
	</script>
	<section id="container" class="wrap" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-1" data-genuitec-path="/web/WebRoot/Announce.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-4" data-genuitec-path="/res/WebRoot/Announce.jsp">
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
<!--logo end-->
<div class="nav notify-row" id="top_menu">
  
</div>
<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
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
	<section class="wrapper">
	<div class="form-w3layouts">
        <!-- page start-->
        <!-- page start-->
        <div class="row">
            <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            菜品信息修改
                        </header>
                        <div class="panel-body">
                            <div class="position-center">
                                <form role="form" action="uploadImage.action" method="post">
                                <div class="form-group">
                                    <label for="exampleInputFile">上传照片</label>
                                    <input type="file" id="img">
                                    <p class="help-block">请选择文件上传照片</p>
                                    <button type="submit" class="btn btn-info">Submit</button>
                                </div>
                                </form>
                                <form role="form" action="modifyDish.action" method="post">
                                <div class="form-group">
                                    <label>菜品价格</label>
                                    <input type="text" class="form-control" id="price" name="price" placeholder="">
                                </div>
                                <div class="form-group">
                                    <label>菜品名称</label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="">
                                </div>
                                <div class="form-group">
                                    <label>菜品描述</label>
                                    <input type="text" class="form-control" id="dis" name="dis" placeholder="">
                                </div>
                              
                                <div>
                                	<label>菜品种类</label>
                                    <select class="form-control m-bot15" name="kind" disabled>
                                        <option>主食套餐</option>
                                        <option>寿司刺身</option>
                                        <option>甜品饮料</option>
                                    </select>
                                </div>
                                <div>
                                    <br />
                                	<button type="submit" btn btn-success">确认修改</button>
                                </div>
                            </form>
                            </div>

                        </div>
                    </section>

            </div>
       
</section>
 
	
</body>
</html>


