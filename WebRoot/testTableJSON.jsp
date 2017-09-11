<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">

	function getData(){
		$.ajax({
			url:"/HaruRestaurant/TableJSONServlet",
			data:{method:"seat"},
			method:"post",
			dataType:"json",
			success:function(result){
				//alert(result.city);
				console.log(result)
			}
		});
	}

</script>
</head>
<body>

	<!-- ajax -->
	<div id="city"></div>
	<input type="button" onclick="getData()" value="ajax">
</body>
</html>