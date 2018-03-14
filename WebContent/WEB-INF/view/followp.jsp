<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ include file="top.jsp" %>


				<div style="width:300px; margin-top:70px" >
					<c:choose>
						<c:when test="${followRst == true }">
							<h4>${target }님에게 친구신청을 하였습니다. </h4>
							<small>수락을 기다려주세요!</small>
						</c:when>
						<c:otherwise>
							<h3>친구신청 과정에서 오류가 발생했습니다.</h3>
						</c:otherwise>
					</c:choose>
					
					
					
				
				</div>
			</div>
		</div>
	</body>
	</html>