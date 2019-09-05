
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8;">
<!--meta http-equiv="refresh" content="10"-->
<title>顾客初始</title>
<script src="js/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script>

var inform = "";
var total = 0;
var num = 0;
$(function() {
	getData3();
});
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
							if (inform[total - 1].position == "custom") {
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
            .row {
  
  margin-top:100px;
}

</style>

</head>


<body>        
<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navber-inner">
			<div class=“container row”>
			
				<div id="test3" class="list-group"
					style="width:60%;padding-left:0%;padding-top:0%;"></div>
					<input type="text" id="id" class="form-control" value="${userid1 }" style="width:100px;position:absolute;top:10px;right:100px;" placeholder="id">
				    <a class="btn btn-large btn-primary" href="custom_exit.jsp" style="position:absolute;top:10px;right:10px;">返回</a>
			</div>
		</div>
	</div>
<div class="container">
<div class="row">
                     <div class=" col-md-2">
					 <button type="button" id="order" class="btn btn-default btn-lg " style="width:120px;height:120px;border-radius:60px ;background:#F4A460;color: white;font-size:30px;border: 2px solid white;outline: none; " >点 餐</button>
                     </div>		
		<script type="text/javascript">
		var btn=document.getElementById("order");
		var id=document.getElementById("id").value;
		btn.setAttribute("onclick","window.location.href='/res/custom.jsp?id="+id+"'");
		</script>

                     <form action="needservice.action" method="post">
                     <div class=" col-md-offset-10">
                     
					 <button type="submit" class="btn btn-default btn-lg" style="top:150px;width:120px;height:120px;border-radius:60px ;background:#F4A460;color: white;font-size:30px;border: 2px solid white;outline: none;">服 务</button>
					 <input type="hidden" value="${userid1 }" name=id>
					 </div>	
					 </form>	
</div>
<div class="row">			
 					<form action="paybill.action" method="post">
					 <div class=" col-md-2">
					 <input type="hidden" value="${userid1 }" name=id>
					 <button type="submit" class="btn btn-default btn-lg" style="width:120px;height:120px;border-radius:60px ;background:#F4A460;color: white;font-size:30px;border: 2px solid white; outline: none;">买 单</button>
				    </div>
				    </form>
				    <div> 
				    <div class="col-md-offset-10">
					 <button type="button" class="btn btn-default btn-lg" style="width:120px;height:120px;border-radius:60px ;background:#F4A460;color: white;font-size:30px;border: 2px solid white; outline: none;" onclick="window.location.href='/res/custom_feedback.jsp'">反 馈</button>
					</div>

</div>
</div>				
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%String message=(String)session.getAttribute("cusmsg");
		if("".equals(message)){
			
		}
		else if(message==null)
		{
			
		}
		else{%>
    <script type="text/javascript">
        alert("<%=message%>");
    </script>
    <%session.setAttribute("cusmsg",null);}%>


</body>
</html>