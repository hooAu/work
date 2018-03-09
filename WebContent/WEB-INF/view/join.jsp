<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="top.jsp" %>    

<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
				<br/>
				<small style="color:red">${error.id }</small><br/>
				<small style="color:red">${error.mail }</small>
				
				<form action="${pageContext.request.contextPath }/join" method="post">
					<div  class="joinFont">ID</div>
					<div>
						<input type="text" name="id" class="join"/>
					</div><br/>
					<c:if test="${id != null }">
						<div  class="joinFont">ID</div>
						<div>
							<input type="text" name="id" class="join"/>
						</div><br/>
					</c:if>
					
					
					
					<div class="joinFont">PASS</div>
					<div>
						<input type="password" name="pass" class="join"/>
					</div><br/>
					
					<div class="joinFont">E-MAIL</div> 
					<div>
						<input type="text" name="mail" class="join" id="mail"/>
					</div><br/>
					<button type="submit" class="join">회원가입</button>
				
				</form>
			</div>
		</div>
	</div>
	
	<script>
		$("#mail").change(function(){
			$.get("/ajax/mailChk.jsp",{
				"mail":$("#mail").val();
			},function(rst){
				
			}))
			
		})
		
	</script>
</body>
</html>


