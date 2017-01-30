<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>

	<h1>Contactos almacenados.</h1>
	
	<c:forEach items="${contactList}" var="contact">
		<p>
			${contact.name}: $${contact.mail}
		</p>
	</c:forEach>

</body>
</html>