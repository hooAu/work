<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="top.jsp" %>    

<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<style>
		.join{
			width:230px;
		}
		.joinFont{
			text-align:left;
			
		}
	</style>
			<div style="width:230px; margin-top:70px" >
				
				<h4>- 회원가입 -</h4>
				<small>아래 항목을 작성해주세요.</small> 
				<br/>
				<small style="color:red">${error.id }</small><br/>
				<small style="color:red">${error.mail }</small>
				
				<form action="${pageContext.request.contextPath }/join" method="post">
					<div  class="joinFont" id="i" ><small><b>ID</b></small></div>
					<div>
						<input type="text" name="id"  id="id"  class="join"/>
					</div><br/>
					<c:if test="${id != null }">
						<div  class="joinFont"><small><b>ID</b></small></div>
						<div>
							<input type="text" name="id" class="join"/>
						</div><br/>
					</c:if>
					
					
					
					<div class="joinFont" id="m"><small><b>E-MAIL</b></small></div> 
					<div>
						<input type="text" name="mail" class="join" id="mail"/>
					</div><br/>
					
					<div class="joinFont"><small><b>PASS</b></small></div>
					<div>
						<input type="password" name="pass" class="join"/>
					</div><br/>
					<button type="submit" class="join">회원가입</button>
				
				</form>
			</div>
		</div>
	</div>
	
	<script>
		$("#mail").change(function(){
			$.get("${pageContext.request.contextPath}/mailChk",{
				"mail":$("#mail").val()
			},function(rst){
				if(rst.chk == false) {
					$("#m").css("color","red");
					$("#m").html("<small>사용할 수 없는 e-mail입니다.</small>");
				} else {
					if(rst.pattern == false) {
						$("#m").css("color","red");
						$("#m").html("<small>올바른 e-mail형식을 사용해주세요.</small>");
					} else {
						$("#m").html("<small>사용가능한 e-mail입니다.</small>");
					}
				}
			})
		})
			
		
		$("#id").change(function(){
			$.get("${pageContext.request.contextPath}/idChk",{
				"id":$("#id").val()
			},function(rst){
				if(rst.chk == false) {
					$("#i").css("color","red");
					$("#i").html("<small>사용할 수 없는 ID입니다.</small>");
				} else {
					if(rst.p == false) {
						$("#i").css("color","red");
						$("#i").html("<small>알파벳만 사용해주세요.</small>");
					} else {
						$("#i").html("<small>사용가능 합니다.</small>");
					}
				}
			})
		})
					
		
		$("#mail").keyup(function(){
			$("#m").css("color","black");
			$("#m").html("<small><b>E-MAIL</b></small>");
		})
		
		$("#id").keyup(function(){
			$("#i").css("color","black");
			$("#i").html("<small><b>ID</b></small>");
		})
		
		
		
		
		
	</script>
</body>
</html>


