<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slanje cestitki</title>
</head>
<body>
	<h1>Slanje cestitki (RZK domaci 3)</h1>
	<c:if test="${!empty message}">
		<h2>${message}</h2>
	</c:if>
	<form action="/CestitkeWEB/CardsServlet" method="post">
		<table>
			<tr>
				<td>Tip cestitke</td>
				<td>
					<select name="type">
						<option value="rodjendan">RODJENDAN</option>
						<option value="nova godina">NOVA GODINA</option>
						<option value="diplomiranje">DIPLOMIRANJE</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Od koga</td>
				<td><input type="text" name="from"></td>
			</tr>
			<tr>
				<td>Kome</td>
				<td><input type="text" name="to"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Posalji"></td>
			</tr>
		</table>
	</form>
</body>
</html>