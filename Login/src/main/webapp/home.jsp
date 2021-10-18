<%@page import="java.util.ArrayList"%>
<%@page import="model.Numeri" %>
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
<title>home</title>
</head>
<body>
 <h1> benvenuto ${utente.user}! </h1>
 <br>
 <h2> inserisci numeri nella tua rubrica </h2>

	<form action="inserimento" method="post">

		<label for="Cognome"> cognome: </label> <br> <input id="Cognome"
			type="text" name="cognome"> <br> <label for="Numero">
			numero: </label> <br> <input id="numero" type="text" name="numero">
		<br> <input type="submit" style="vertical-align: middle"
			value="INSERISCI">
			<input type="hidden" name="utente" value="${utente.id}" >
	</form>

	

	<br>
 <br>
 <h1> RUBRICA </h1>	
	<% 
	ArrayList<Numeri> contatti = (ArrayList<Numeri>) request.getAttribute("contatti");
	if(contatti!=null){
	for (int i=0; i<contatti.size(); i++) {	%>
	<p> | <%= contatti.get(i).getCognome() %> || <%= contatti.get(i).getNumero() %> | </p>
	<p> 
	<%} } %>

</body>
</html>