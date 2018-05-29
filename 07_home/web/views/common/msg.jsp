<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String msg=(String)request.getAttribute("msg");
	String loc=request.getContextPath()+(String)request.getAttribute("loc");
	String script=(String)request.getAttribute("script");
%>
<script>
alert("<%=msg%>");
location.href="<%=loc%>";
				//여기서 index.jsp로 이동하라는 뜻. 
				// '/'는 최상위루트를 의미하는것
				
if(<%=script%>!=null){
	<%=script%>
}				

</script>