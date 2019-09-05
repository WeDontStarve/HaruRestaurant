var dish_info=[];
function request(){
  var turl = "/res/AdminServlet";
    $.ajax({
        type: 'POST',
        url: turl, 
        crossDomain: true,
        data: {
            method:"dish",
            action:"display"
        },
        dataType: 'json',
        success: function(responseData, textStatus, jqXHR) { 
            dish_info = responseData;
            console.log(dish_info);
            create_dish_div();
            create_dish_modal();
            add_onclick();
},          
            error: function(responseData, textStatus, errorThrown) {
                 alert('POST failed.');
            }
    });
}

function create_dish_div(){
    for(var i=0,length=dish_info.length;i<length;i++){
        var dish_div=document.createElement("div");
        var dish_img=document.createElement("img");
        dish_div.className="col-md-6 dish";
        dish_img.src=dish_info[i].dishImg;
        dish_img.className="img-rounded";
        dish_img.style.cssText="width: 120px;height: 120px;";
        dish_img.setAttribute("data-toggle","modal");
        var dish_modal_id=dish_info[i].dishId;
        
        dish_img.setAttribute("data-target",'#myModal'+dish_modal_id);
        dish_div.appendChild(dish_img);
        if(dish_info[i].classification=="main"){
            var main_div=document.getElementById("main");
            main_div.appendChild(dish_div);
        }
        else if(dish_info[i].classification=="sushi"){
            var sushi_div=document.getElementById("sushi");
            sushi_div.appendChild(dish_div);
        }
        else if(dish_info[i].classification=="dessert"){
            var dessert_div=document.getElementById("dessert");
            dessert_div.appendChild(dish_div);
        }
    }
}

function create_dish_modal(){
    var all_modal_div=document.getElementById("all_my_modal");
    for(var i=0,length=dish_info.length;i<length;i++){
        var dish_dis=dish_info[i].dishDis;
        var dish_name=dish_info[i].dishName;
        var dish_price=dish_info[i].dishPrice;
        var dish_id=dish_info[i].dishId;
        var dish_img=dish_info[i].dishImg;

        var modal_fade_div=document.createElement("div");
        modal_fade_div.className="modal fade";
        modal_fade_div.setAttribute("id",'myModal'+dish_id);
        modal_fade_div.setAttribute("tabindex","-1");
        modal_fade_div.setAttribute("role","dialog");
        modal_fade_div.setAttribute("aria-labelledby","myModalLabel");
        modal_fade_div.setAttribute("aria-hidden","true");

            var modal_dialog_div=document.createElement("div");
            modal_dialog_div.className="modal-dialog";

                var modal_content_div=document.createElement("div");
                modal_content_div.className="modal-content";

                    var modal_header_div=document.createElement("div");
                    modal_header_div.className="modal-header";

                        var close_btn=document.createElement("button");
                        close_btn.className="close";
                        close_btn.setAttribute("type","button");
                        close_btn.setAttribute("data-dismiss","modal");
                        close_btn.setAttribute("aria-hidden","true");
                        close_btn.innerHTML="&times;";

                        var modal_title_h4=document.createElement("h4");
                        modal_title_h4.className="modal-title";
                        modal_title_h4.setAttribute("id",'myModalLabel'+dish_id);
                        modal_title_h4.style.cssText="color:#D2691E;";
                        modal_title_h4.innerHTML=dish_name;

                    modal_header_div.appendChild(close_btn);
                    modal_header_div.appendChild(modal_title_h4);

                    var modal_body_div=document.createElement("div");
                    modal_body_div.className="modal-body";

                        var img=document.createElement("img");
                        img.src=dish_img;
                        //console.log(dish_img);
                        img.className="img-rounded";
                        img.style.cssText="width:500px;height:400px;";

                    modal_body_div.appendChild(img);

                    var price_p=document.createElement("p");
                    price_p.style.cssText="color:#D2691E;";
                    price_p.innerHTML="单价：";

                        var price_span=document.createElement("span");
                        price_span.style.cssText="color:#D2691E;";
                        price_span.innerHTML=dish_price;
                        price_span.setAttribute("id",'price'+dish_id);

                    price_p.appendChild(price_span);

                    var discription_p=document.createElement("p");
                    discription_p.style.cssText="color:#D2691E;";
                    discription_p.innerHTML="详细描述："+dish_dis;

                    var modal_footer_div=document.createElement("div");
                    modal_footer_div.className="modal-footer";

                        var input=document.createElement("input");
                        input.style.cssText="width: 80px;";
                        input.setAttribute("id",'quantity'+dish_id);
                        input.setAttribute("type","text");

                        var order_btn=document.createElement("button");
                        order_btn.className="btn btn-primary";
                        order_btn.style.cssText="background-color: #F4A460;border: 2px solid #F4A460;";
                        order_btn.setAttribute("type","button");
                        order_btn.setAttribute("data-dismiss","modal");
                        order_btn.setAttribute("id",'order_btn'+dish_id);
                        order_btn.innerHTML="点餐"

                        var close_btn_2=document.createElement("button");
                        close_btn_2.className="btn btn-default";
                        close_btn_2.setAttribute("type","button");
                        close_btn_2.setAttribute("data-dismiss","modal");
                        close_btn_2.innerHTML="关闭"

                    modal_footer_div.appendChild(input);
                    modal_footer_div.appendChild(order_btn);
                    modal_footer_div.appendChild(close_btn_2);

                modal_content_div.appendChild(modal_header_div);
                modal_content_div.appendChild(modal_body_div);
                modal_content_div.appendChild(price_p);
                modal_content_div.appendChild(discription_p);
                modal_content_div.appendChild(modal_footer_div);

            modal_dialog_div.appendChild(modal_content_div);

        modal_fade_div.appendChild(modal_dialog_div);

        all_my_modal.appendChild(modal_fade_div);

      
    }
}

function addTableById(btn_id){
    var tab=document.getElementById("viewTabs"); //获得表格
    var colsNum=tab.rows.item(0).cells.length; //表格的列数
    //表格当前的行数 
    
    var id=btn_id.replace("order_btn","");
   
    //if(isOrder==0){
        var num=tab.rows.length;
        var rownum=num;
        tab.insertRow(rownum);
        for(var i=0;i<3; i++)
        {
            tab.rows[rownum].insertCell(i);//插入列
            if(i==0){
            	var name_span=document.createElement("span");
            	name_span.setAttribute("name",'dish_name'+id);
                var name=document.getElementById('myModalLabel'+id).innerHTML;
                name_span.innerHTML=name;
                tab.rows[rownum].cells[i].appendChild(name_span);
            }else if(i==1){
                var input=document.createElement("input");
                input.setAttribute("type","text");
                input.setAttribute("name",id);
                input.style.cssText=style="width: 80px;";
                var input_id='dish_num'+id;
                input.setAttribute("id",input_id);
                tab.rows[rownum].cells[i].appendChild(input);
                
            }else if(i==2){
                var price=document.getElementById('price'+id).innerHTML;
                tab.rows[rownum].cells[i].innerHTML=price;
            }
        }
        tab.rows[rownum].insertCell(i);
        tab.rows[rownum].cells[i].innerHTML='<a href="#" onclick="delRow(this)">删除</a>';
        var quantity_input=document.getElementById('quantity'+id);
        var quantity=quantity_input.value;
        document.getElementById('dish_num'+id).value=quantity;
     //   isOrder=1;
    // }
    // else if(isOrder==1){
    //     var quantity=document.getElementById('quantity'+id).value;
    //     document.getElementById('dish_num'+id).value=quantity;
    // }
}

function add_onclick(){
    for(var i=0,length=dish_info.length;i<length;i++){
        (function(){
            var id=dish_info[i].dishId;
            var btn=document.getElementById('order_btn'+id);
            btn.onclick=function(){addTableById(btn.getAttribute("id"));}
        })();
    }
}