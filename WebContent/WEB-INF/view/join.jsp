<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="top.jsp" %>    
<html>
<head>
<title></title>
</head>
	<style>
		.join{
			width:200px;
		}
		.joinFont{
			text-align:left;
			
		}
	</style>

			<div style="width:200px; margin-top:70px" >
				
				<h4>- 회원가입 -</h4>
				<small>아래 항목을 작성해주세요.</small> 
				
				<form>
					<div  class="joinFont">ID</div>
					<div>
						<input type="text" name="id" class="join"/>
					</div><br/>
					
					<div class="joinFont">PASS</div>
					<div>
						<input type="password" name="pass" class="join"/>
					</div><br/>
					
					<div class="joinFont">E-MAIL</div> 
					<div>
						<input type="text" name="mail" class="join"/>
					</div><br/>
					<button type="submit" class="join">회원가입</button>
				
				</form>
			</div>
		</div>
	</div>
</body>
</html>