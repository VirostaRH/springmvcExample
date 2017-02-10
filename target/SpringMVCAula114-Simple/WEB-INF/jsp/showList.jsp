<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
	<meta charset="utf-8">
	<script type="text/javascript" src="/resources/events.js"></script>

</head>
<body>
	<h1>Contactos almacenados.</h1>
	
	<form method="POST" id="formu1" action="/show/">
		<table>
			<tr>
				<td style="border: solid 1px">${c.id}</td>
				<td style="border: solid 1px">Nombre</td>
				<td style="border: solid 1px">Dirección</td>
				<td style="border: solid 1px">Email</td>
				<td style="border: solid 1px">Tlf</td>
			</tr>
			<c:forEach var="c" items="${list}">
			<tr>
				<td style="border: solid 1px">${c.id}</td>
				<td style="border: solid 1px">${c.name}</td>
				<td style="border: solid 1px">${c.address}</td>
				<td style="border: solid 1px">${c.email}</td>
				<td style="border: solid 1px">${c.telephone}</td>
			</tr>
			</c:forEach>
		</table>
		<select name="clave">
			<c:forEach var="c" items="${list}">
				<option value="${c.id}">${c.name}</option>
			</c:forEach>
		</select>
		<input type="submit" id="consult" value="Consultar">
		<input type="submit" id="update" value="Modificar">
		<input type="submit" id="delete" value="Borrar">
	</form>
</body>
</html> 