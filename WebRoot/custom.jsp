<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8;" />
<title>顾客点餐</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- 增减按钮 -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">
<!-- <link href="bootstrap/bootstrap-spinner.css" rel="stylesheet"> -->

<script src="./js/custom.js"></script>

<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- 增减按钮 -->
<style type="text/css">
.demo{width:150px; margin:20px auto 0 auto; }
@media screen and (max-width: 360px) {.demo {width:340px}}

.btn:active {
        background: #D2691E;
        box-shadow: 0 5px #666;
        transform: translateY(4px);
    }
	* { 
		/* Basic CSS reset */
		margin:0; 
		padding:0;
	}
body {
		/* These styles have nothing to do with the ribbon */
		background:url(images/dark_wood.png) 0 0 repeat;
		padding:35px 0 0;
		margin:auto;
		text-align:center;
	}

	 .row {
		margin-top:20px;
	}
     .dish{
     	margin-top:20px;
     	padding-left:5px;
     }
	
</style>

</head>
<body>
	<div >
		<span class="label label-default"
			style="background: #D2691E;color:white;width: 50px;height:18px;position:absolute;top:15px;right:210px;">
			<font size="3">桌号:</font>
		</span>
	</div>
	
<input type="text" id="table_id" class="form-control" value="<%=request.getParameter("id") %>" style="width:100px;position:absolute;top:10px;right:100px;" placeholder="id" disabled>
<div class="container">
	<div class="row">
		<div class=" col-md-1">
		    <button type="button" class="btn btn-default btn-lg " data-toggle="modal" data-target="#myModalz" style="width:100px;height:100px;border-radius:50px ;background:#FFF8DC;color:	#D2691E;font-size:23px;border: 4px solid #D2691E;outline: none;" onclick="calculate();">购物车</button>
		</div>
		<div class=" col-md-3">
		     <button type="button" class="btn btn-default btn-lg " style="width:100px;height:100px;border-radius:50px ;background: #FFF8DC;color:#D2691E;font-size:23px;border: 4px solid#D2691E;outline: none;" onclick="window.location.href='/res/custom_init.jsp'">返回</button>
		</div>
		
	</div>
	<div class="row">
	    
	     <div class=" col-md-3">
		     <span class="label label-default" style="background: #D2691E;color:white;width: 80px;height: 100px;" >
		     	<font size="4">主食套餐</font>
		     </span>
	     </div>
	     <div class=" col-md-5">
		     <span class="label label-default" style="background: #D2691E;color:white;width: 80px;height: 100px;" >
		     	<font size="4">寿司刺身</font>
		     </span>
	     </div>
	     <div class=" col-md-3">
		      <span class="label label-default" style="background: #D2691E;color:white;width: 80px;height: 100px;" >
		      	<font size="4">甜品饮料</font>
		      </span>
	     </div>
	</div>
	<div class="row">
		<div id="main" class=" col-md-4 img-rounded " style=" background: #FFF8DC;border: 4px solid #D2691E;width: 300px;padding-bottom: 20px;">
		</div>
		  
		<div id="sushi" class="col-md-4 img-rounded col-md-offset-1" style=" background: #FFF8DC;border: 4px solid #D2691E;width: 300px;padding-bottom: 20px;">
		</div>
		  
		<div id="dessert" class=" col-md-4 img-rounded col-md-offset-1" style=" background:#FFF8DC;border: 4px solid #D2691E;width: 300px;padding-bottom: 20px;">
		</div> 
	</div>
	<script type="text/javascript">
		request();
	</script>


<div id="all_my_modal"></div>		

<div class="modal fade" id="myModalz" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
			&times;
		</button>
		<h4 class="modal-title" id="myModalLabel" style="color:#D2691E; ">
			购物车
		</h4>
	</div>
	<div class="modal-body">
		<form id="shop">
		<table class="table table-striped" id="viewTabs">	        
         <thead>
          <tr>
	      <th>名称</th>			   
	      <th>数量(份)</th>
	      <th>价格(元)</th>
	      <th>操作</th>
          </tr>
         </thead>
          <tbody>
           <tr> 
          </tr>
          </tbody>
        </table>
        </form>
	</div>
	<div class="modal-footer">
	<p style="float: left;color: #F4A460; width: 100px;"  ><font size="5">总价:</p>
    <input type="text" id="sum" style="float: left;  border:none;background-color:white;color:#F4A460;width: 100px;height: 35px;" />		
	<button type="button" class="btn btn-default" data-dismiss="modal" style="background-color: white; color:#F4A460;">
		关闭
	</button>
	<button type="button" class="btn btn-primary" style="background-color: #F4A460; color:white;border: solid white;" onclick=shopjson()>
		下单
	</button>
	</div>
</div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>

</div>


</body>

<script type="text/javascript"> 

//删除行
function delRow(obj)
{
	var Row=obj.parentNode;
	var Row=obj.parentNode; //tr
	while(Row.tagName.toLowerCase()!="tr")
	{
	Row=Row.parentNode;
	}
	Row.parentNode.removeChild(Row); //删除行
	calculate();
}

function calculate(){
	var num=document.getElementById("viewTabs").rows.length-2;
	var tab=document.getElementById("viewTabs"); 
	var sum=0;
	var tbody = viewTabs.tBodies[0];
	var texts = tbody.getElementsByTagName("input");
	for (i=0;i < num ;i++){
		var ti = texts[i];
		var docN=ti.value;
		var price=tab.rows[i+2].cells[2].innerHTML;

		sum+=parseInt(docN)*parseFloat(price);
	}

	document.getElementById("sum").value=sum;
}
</script>
<script type="text/javascript">
function shopjson(){
	var msg=$("#shop").serialize();
	var json="[{";
	var msg2=msg.split("&");
	
	for(var i=0;i<msg2.length;i++){
		var msg3=msg2[i].split("=");
		console.log(msg3);
		json+="dishId:";
		json+=msg3[0];
		json+=",num:";
		json+=msg3[1];
		if(i<msg2.length-1)
			json+="},{";
		else if(i==msg2.length-1)
			json+="}]";
	}
	//console.log(json);
	var table=document.getElementById("table_id").value;
	$.ajax({  
            cache : true,  
            type : "post",  
            url : "/res/CustomServlet",  
            data : {  
            	method:"shop",
                myorder:JSON.stringify(json),
                table_id:table
            },
            async: false,  
            dataType:"json",
            error : function(response) {  
                alert("点餐失败");  
            },  
            success : function(data) {  
                alert("点餐成功");  
            } 
        });
}
</script>
</html>