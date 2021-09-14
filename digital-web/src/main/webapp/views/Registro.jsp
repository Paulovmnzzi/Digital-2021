<%@page import="com.digital.domain.Marcas"%>
<%@page import="com.digital.domain.Categorias"%>
<%@page import="java.util.List"%>
<html>
<head>
<%@include file="/bootstrap/style.jsp" %>
<title>Inicio</title>
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/assets/favicon.png">


</head>
<body>
<%@include file="/views/navbar.jsp" %>
<%@include file="/views/mensajeria.jsp" %>

<div class="container">
	<div class="row">
	<div> 
	<h1 class="pt-3">Registro</h1>
	<br>
	</div>
	<form action="<%=request.getContextPath()%>/Register/nuevoUsuario" method="post">
		<div class="col-9">
			<div class="input-group mb-3 mt-0">
	  			<span class="input-group-text col-2"  id="basic-addon1">Usuario   </span>
		  		<input type="text" required="required" name="newUsuario" class="form-control" placeholder="" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
	  			<span class="input-group-text col-2" id="basic-addon1">Contraseña</span>
		  		<input type="password" required="required" name="newPassword" class="form-control" placeholder="" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
	  			<span class="input-group-text col-2" id="basic-addon1">Repita contraseña</span>
		  		<input type="password" required="required" name="newPassword2" class="form-control" placeholder="" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
	  			<span class="input-group-text col-2" id="basic-addon1">email@mail.com</span>
		  		<input type="mail" required="required" name="mail" class="form-control" placeholder="" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="col-12 mt-3">
						<button class="btn btn-primary" type="submit">Registrarse</button>
			</div>
		</div>
	</form>
	</div>
</div>


<%@include file="/bootstrap/script.jsp" %>
</body>
</html>

