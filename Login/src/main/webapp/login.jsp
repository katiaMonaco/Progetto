<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<form action="login" method="post">
		
		<label for="User"> USER: </label> <br> <input id="user" type="text" name="user"> <br> 
		<label for="Password"> PASSWORD: </label> <br> <input id="password" type="password" name="password"> <br>
		<input type="submit" class="accedi" style="vertical-align: middle" value="ACCEDI">
	</form>
</body>
</html>