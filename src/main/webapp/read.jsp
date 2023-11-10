<%@page import="com.spring.StudentEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%StudentEntity s =new StudentEntity(); %>
<p><%s.geteId();%></p>
<p><%s.getsName();%></p>
<p><%s.getePassword();%></p>
</body>
</html>