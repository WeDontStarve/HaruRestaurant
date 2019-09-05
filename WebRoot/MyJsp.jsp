<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">    
function getData(){
		$.ajax({ 
                url: "/res/AdminServlet",  
                data: {method:"dish",action:"display"},  
                type: 'post',  
                dataType: 'json',  
                success: function(data) { 
                console.log(data); 
                    $.each(data, function(index,values){
                        $.each(values,function(index2,value){
                            alert(value.name + " " + value.value);
                        });
                    });
                },
                error: function(){
                    alert("服务器没有返回数据，可能服务器忙，请重试");
                },
            }); 
        }
   
</script>
  </head>
  
  
  <body>
    This is my JSP page. <br>
    <div id="city"></div>
	<input type="button" onclick="getData()" value="ajax">
  </body>
</html>
