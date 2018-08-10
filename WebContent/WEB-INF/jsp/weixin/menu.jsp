<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
  	<title>微信登陆授权</title>
  	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 	
	<script type="text/javascript" src="/Resource/Script/jquery-3.3.1.min.js"></script>
  	<script type="text/javascript" src="/Resource/Script/layui/layui.js"></script>
	<link href="/Resource/Script/layui/css/layui.css" rel="stylesheet" type="text/css" />
</head>
<body>
 	<button type="button" onclick="AddMenu()">新增菜单</button>
    <button type="button" onclick="GetMenu()">查询菜单</button>
    <button type="button" onclick="DeleteMenu()">删除菜单</button>
    
    <script>
    
    var form, layedit, laydate, layer;
    layui.use(['form', 'layedit', 'laydate'], function(){
      	form = layui.form,
        layedit = layui.layedit,
        laydate = layui.laydate;
        layer = layui.layer;
 	});
    
	    function AddMenu(){
	        var data = {
	            "button": [
	                {
	                    "name": "资讯服务",
	                    "sub_button": [
	                        {
	                            "type": "view",
	                            "name": "营业网点查询1",
	                            "url": "http://www.soso.com/"
	                        },
	
	                        {
	                            "type": "view",
	                            "name": "还款计算器",
	                            "url": "http://v.qq.com/"
	                        }
	                    ]
	                },
	                {
	                    "name": "业务中心",
	                    "sub_button": [
	                        {
	                            "type": "view",
	                            "name": "担保业务办理",
	                            "url": "http://www.soso.com/"
	                        },
	                        {
	                            "type": "click",
	                            "name": "公积金担保查询",
	                            "key": "V1001_01"
	                        }
	                    ]
	                },
	                {
	                    "name": "个人中心",
	                    "sub_button": [
	                        {
	                            "type": "view",
	                            "name": "优惠券管理",
	                            "url": "http://www.soso.com/"
	                        },
	                        {
	                            "type": "view",
	                            "name": "房产中心",
	                            "url": "http://v.qq.com/"
	                        }
	                    ]
	                }
	            ]
	        };
	       
	        var menuData = JSON.stringify(data);
	        $.ajax({
	            type: "POST",
	            url: "/weixin/CreateMenu",
	            data: {
	                data: menuData
	            },
	            success: function (data) {
	            	layer.alert(data);
	            }
	        });
	    }
	
	    function GetMenu() {
	        $.ajax({
	            type: "POST",
	            url: "/weixin/GetMenu",
	            data: {},
	            success: function (data) {
	            	layer.alert(data);
	            }
	        });
	    }
	
	    function DeleteMenu() {
	        $.ajax({
	            type: "POST",
	            url: "/weixin/DeleteMenu",
	            data: {},
	            success: function (data) {
	            	layer.alert(data);
	            }
	        });
	    }
    </script>
</body>
</html>

 
 