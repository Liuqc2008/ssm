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
  
  	<script type="text/javascript" src="Resource/Script/layui/layui.js"></script>
	<link href="Resource/Script/layui/css/layui.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<img src="${headimgurl}"><img><br/>
  	<span>${nickname}</span><br/>
  	<span>${sex==1?"男" :"女"}</span><br/>
  	<span>${country}</span><br/>
  	<span>${province}</span><br/>
  	<span>${city}</span><br/>
  	<span>${openid}</span><br/>
  	<span>${language}</span><br/>
</body>
</html>

 
 