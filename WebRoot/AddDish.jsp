<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>用户登录</title>
        <!-- Bootstrap 核心 CSS 文件 -->
        <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <style>
            /*web background*/
            .container{
                display:table;
                height:100%;
            }

            .row{
                display: table-cell;
                vertical-align: middle;
            }
            /* centered columns styles */
            .row-centered {
                text-align:center;
            }
            .col-centered {
                display:inline-block;
                float:none;
                text-align:left;
                margin-right:-4px;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="row row-centered">
                <div class="well col-md-6 col-centered">
                    <h2>添加菜品</h2>
                    <!--  <form commandName="image" action="image_save.action" method="post" enctype="multipart/form-data">-->
                    <form action="upload.action" method="post" enctype="multipart/form-data">
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入菜品名称"/>
                        </div>
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" id="dis" name="dis"  placeholder="请输入菜品描述"/>
                        </div>
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" id="price" name="price" placeholder="请输入菜品单价"/>
                        </div>
                        
                        <div class="input-group input-group-md">
                            <label for="exampleInputFile">上传照片</label>
                            <input type="file" id="img" name="file">
                        </div>
                        
                        <div class="input-group input-group-md">
                        
                                    <select class="form-control m-bot5" name="kind">
                                        <option>主食套餐</option>
                                        <option>寿司刺身</option>
                                        <option>甜品饮料</option>
                                    </select>
                                </div>
                        <br/>
                        <button type="submit" class="btn btn-success btn-block">确认添加</button>
                    </form>
                </div>
            </div>
        </div>


        <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
        <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

        <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
        <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </body>

</html>