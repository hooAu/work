<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="top.jsp" %>

<style>
		.join{
			width:200px;
		}
		.joinFont{
			text-align:left;
			
		}
</style>


		<div style="width:200px; margin-top:70px" >
				<h4>친구목록 (${fn:length(flist) })</h4>
					<c:forEach var="i" items="${flist }">
						<div>${i.ONE }</div>
					</c:forEach>
				
			
			</div>
		</div>
	</div>		
			
</body>
</html>