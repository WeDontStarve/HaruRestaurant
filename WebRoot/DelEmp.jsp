<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>员工详细信息</title>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!-- bootstrap-css -->
<link rel="stylesheet" type="text/css"
	href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
<!-- //bootstrap-css -->


</head>
<body>
	<script type="text/javascript">
	
		$.ajax({
			url : "/res/AdminServlet",
			data : {
				method : "employee",
				action : "delete",
				position : "<%=request.getParameter("position") %>",
				id : "<%=request.getParameter("id") %>"
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				alert("success");
			},
			error : function() {
			},
		});
	</script>
	<div class="container" style="background:#fff; color:#000 ; margin-top:100px; ">

		<form class="form-horizontal">
			<fieldset>
				<div id="legend" class="">
					<legend class="">确认修改页面</legend>
				</div>


				<div>
				    <a class="btn btn-success"  role="button" href="StaffManagement.jsp">确 认 删 除</a>
				</div>

			</fieldset>
		</form>

	</div>
</body>
</html>


