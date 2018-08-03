<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="Resource/Script/layui/css/layui.css" rel="stylesheet" type="text/css" />
 
<script type="text/javascript" src="Resource/Script/layui/layui.js"></script>
<script type="text/javascript" src="Resource/Script/jquery-3.3.1.min.js"></script>

<div class="layui-form">
  <table class="layui-table">
    <colgroup>
      <col width="150">
      <col width="150">
      <col width="150">
      <col width="150">
      <col width="150">
      <col width="150">
      <col>
    </colgroup>
    <thead>
		<tr>
			<th>id</th>
       		<th>name</th>
         	<th>id</th>
        	<th>name</th>
         	<th>id</th>
        	<th>name</th>
        	<th>name</th>
      	</tr> 
    </thead>
    <c:forEach items="${cs}" var="c" varStatus="st">
    	<tbody>
	      	<tr>
            	<td>${c.id}</td>
            	<td>${c.name}</td>
            	<td>${c.id}</td>
            	<td>${c.name}</td>
            	<td>${c.id}</td>
            	<td>${c.name}</td>
            	<td>${c.name}</td>
        	</tr>
	    </tbody>
    </c:forEach>
  </table>
</div>
