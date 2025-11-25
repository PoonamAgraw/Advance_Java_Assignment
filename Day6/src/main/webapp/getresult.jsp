<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! public int factorial(int n1){
	int f = 1;
	for(int i=1;i<=n1;i++){
		 f=f*i;
	}
	return f;
}%>
<%@include file="MyHeader.html" %>
<%
   String btn=request.getParameter("btn");
   int n1=Integer.parseInt(request.getParameter("num1"));
   if(btn.equals("add")){
   int n2=Integer.parseInt(request.getParameter("num2"));
   int ans=n1+n2;
  
%>
<h2>Addition : <%=ans %></h2>
<%}else{
	int fact=factorial(n1);
%>
<h2>Factorial : <%=fact %></h2>
<%} %>
</body>
</html>