<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import='java.util.*'%>
<%
	Date now=new Date();
	String today=String.format("%tY년%tm월%td일", now,now,now);
%>
copyright 이페이지의 저작권은 유병승에게 있습니다<br/>
<span style='color:navy;font-weight:bold'><%=today%></span>