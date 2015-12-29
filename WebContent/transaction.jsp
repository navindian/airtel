<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <form action="rest/transaction/getTransactions" method="get"> -->
<h4>Transaction successfull!!!</h4>
<!-- <input type="submit" value="Click here to view transactions"> -->
<form id="myForm" action="rest/transaction/getTransactions" method="get">
   <!--   <input type="hidden" name="someName" value="helloworld" />-->
    <a href="#" onclick="document.getElementById('myForm').submit();">Click here to view transactions.</a>
</form>
</body>
</html>