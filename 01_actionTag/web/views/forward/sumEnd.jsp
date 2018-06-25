<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int su1=Integer.parseInt(request.getParameter("su1"));
	int su2=Integer.parseInt(request.getParameter("su2"));
	int total=0;
	for(int i=su1;i<su2;i++)
	{
		total+=i;
	}
	request.setAttribute("total",total);
	//request.getReqeustDispather("sumView.jsp").forward(request,response);
%>
<jsp:forward page="sumView.jsp"/>
	<%-- <jsp:param value="<%=total %>" name="total"/> --%>
<%-- </jsp:forward> --%>






