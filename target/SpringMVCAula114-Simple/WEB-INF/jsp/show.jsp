<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>
	<h1>Contactos almacenados.</h1>
	<p>Name: ${contact.name}</p>
	<p>Mail: ${contact.email}</p>
	<p>Address: ${contact.address}</p>
	<p>Phone: ${contact.telephone}</p>

	<form method="POST" id="formu1" action="/employee">
		<input type="submit" id="send" value="Aceptar">
	</form>
</body>
</html> 