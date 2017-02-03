<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>
	<h1>Contactos almacenados.</h1>
	
	<form method="POST" action="/show/">
		<select name="clave">
			<c:forEach var="c" items="${list}">
				<option value="${c}">${c}</option>
			</c:forEach>
		</select>
		<input id="submit" type="submit" value="Enviar">
	</form>
</body>
</html> 