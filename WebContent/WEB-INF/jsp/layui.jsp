<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" import="java.util.*"%>
 
<!DOCTYPE html>
<html>
<head>
  	<meta charset="utf-8">
  	<title>form</title>
  	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  
  	<script type="text/javascript" src="Resource/Script/layui/layui.js"></script>
	<link href="Resource/Script/layui/css/layui.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table class="layui-hide" id="test"></table>
                   
	<script>
	layui.use('table', function(){
	  	var table = layui.table;
	  
  		table.render({
	    	elem: '#test',
	    	url:'/ssm/Common/CategoryList',
	    	cols: [[
	      		{field:'id', width:80, title: 'ID', sort: true},
	      		{field:'name', width:130, title: '用户名'}

	    	]],
	    	page: true,
	    	height: 'full-200',
	   //limit:2,
	  	});
	});
	</script>

</body>
</html>


 
 