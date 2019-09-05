<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=utf-8" />
<title>顾客反馈</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery.js"></script>

  <style type="text/css">
    body {
				/* These styles have nothing to do with the ribbon */
				background:url(images/dl.jpg) ;
        background-repeat:no-repeat ;
        background-size:100% 100%; 
        background-attachment: fixed;  
				padding:35px 0 0;
				margin:auto;
				text-align:center;
			}
       .row {
  
  margin-top:50px;
}

  </style>

</head>
<body>
<div class="container">
<div class="row">
<div class=" col-md-1">
<img src="images/2.png" class="img-rounded" style="width: 150px;height: 100px;">
</div>
<div class=" col-md-offset-2">
<form role="form" action ="feedback.action" method = "post">
	<div class="form-group">		
		<textarea id="comment" name="comment" class="form-control" rows="3" placeholder="请输入评论" style="width:900px;height:200px;background-color: #F8F8FF;opacity: 0.7;"></textarea>
	</div>
    <div class="form-group">
        <div class="col-sm-4">
        <button type="submit" class="btn btn-default" style="width:100px;height:50px;background-color: #B0C4DE;color: white;">发送</button>
        </div>
         <div class="col-sm-6">
        <button class="btn btn-default" style="width:100px;height:50px;color: #B0C4DE;" onclick="window.location.href='/res/custom_init.jsp'">返回</button>
        </div>
    </div>
</form>
</div>

</div>
<div class="row" id="display"></div>

<script type="text/javascript">
var turl = "/res/CustomServlet";
    $.ajax({
        type: 'POST',
        url: turl, 
        data:{"method":"feedback"},
        crossDomain: true,
        dataType: 'json',
        success: function(responseData, textStatus, jqXHR) { 
            for(var i=0,l=responseData.length;i<l;i++){
              (function(){
              addComment(i);
              $('#'+i).text(responseData[i].comment);
            })();
          }
},          
            error: function(responseData, textStatus, errorThrown) {
                 alert('POST failed.');
            }
    });
  function addComment(i){
    var display_div=document.getElementById("display");
    var row=document.createElement("div");
    row.className="row";
    var div1=document.createElement("div");
    div1.className="col-md-2";
    var img=document.createElement("img");
    img.src="images/3.png";
    img.className="img-rounded";
    img.style.cssText="width: 60px;height: 60px;";
    div1.appendChild(img);
    var div2=document.createElement("div");
    div2.className="col-md-offset-2";
    var p=document.createElement("p");
    p.className="img-rounded";
    p.style.cssText="width: 500px;height: 60px;background-color: #F8F8FF;color: #2F4F4F;opacity: 0.7;";
    p.setAttribute("id",i);
    div2.appendChild(p);
    row.appendChild(div1);
    row.appendChild(div2);
    display_div.appendChild(row);
  }
</script>

</body>
</html>