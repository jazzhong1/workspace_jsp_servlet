<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	Date today=new Date();
	String day=String.format("%tY년 %tm월 %td일 %tA,", today, today, today, today);
%>
<%=day %>