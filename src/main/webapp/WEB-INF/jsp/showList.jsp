<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
	<meta charset="utf-8">
</head>
<body>
	<h1>Contactos almacenados.</h1>
	
	<form method="POST" action="/show/">
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
		<select name="op">
			<option value="r">Consultar</option>
			<option value="u">Editar</option>
			<option value="d">Borrar</option>
		</select>
		<input id="submit" type="submit" value="Enviar">
	</form>
</body>
</html> 