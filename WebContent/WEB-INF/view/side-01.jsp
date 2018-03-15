<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4>John's Blog</h4>
<ul class="nav nav-pills nav-stacked">
	<li class="active"><a href="${pageContext.request.contextPath }/index">Home</a></li>
	<li><a href="${pageContext.request.contextPath }/join">JOIN</a></li>
	<li><a href="#section3">Family</a></li>
	<li><a href="#section3">Photos</a></li>
</ul>
<br>
<div class="input-group">
	<input type="text" class="form-control" placeholder="Search Blog..">
	<span class="input-group-btn">
		<button class="btn btn-default" type="button">
			<span class="glyphicon glyphicon-search"></span>
		</button>
	</span>
</div>