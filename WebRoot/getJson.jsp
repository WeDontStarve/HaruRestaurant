<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	function getData(){
		$.ajax({
			url:"/day03_2/itemList7/getJson.action",
			data:{},
			method:"post",
			dataType:"json",
			success:function(result){
				alert(result);
				//$("#city").text(result.city);
			}
		});
	}
</script>
<title>Insert title here</title>
</head>
<body>
   ${items.createtime }
	<input type="button" onclick="getData()" value="ajax">
	
	<form action="/day03_2/itemList5/getData.action">
		<input type="text" name="username" value="${username }">
		<input type="text" name="name" value="${items.name }">
		<input type="text" name="pic" value="${items.pic }">
		<input type="submit">
	</form>
</select>
</body>
</html>