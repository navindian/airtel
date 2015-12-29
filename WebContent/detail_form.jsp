<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details Form</title>
</head>
<body>
<form action="rest/transaction" method="post">
<table>
<tr><td><label>Enter mobile number</label></td>
<td><input type="text" id="mobileNumber" name="mobileNumber"/></td>
</tr>
<tr>
<td><label>Select the region</label></td>
<td><select name="region">
	 <option selected="selected">-select-</option>
     <option>Chandigarh</option>
     <option>Punjab</option>
     <option>Haryana</option>
     <option>AP</option>
</select></td>
</tr>
<tr>
<td><label>Enter Amount</label></td>
<td><input type="text" id="amount" name="amount"/></td>
</tr>
<tr>
<td><label>Enter e-mail address</label></td>
<td><input type="text" id="email" name="email"/></td>
</tr>
<tr>
<td align="center" colspan="2"><input type="submit" value="Proceed to recharge"></td>
</tr>
</table>
</form>
</body>
</html>