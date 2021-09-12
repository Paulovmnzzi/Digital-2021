<html>
<head>
<%@include file="/bootstrap/style.jsp"%>
<title>Inicio</title>
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/assets/favicon.png">


</head>
<body>
	<%@include file="/views/navbar.jsp"%>
	<%@include file="/views/mensajeria.jsp"%>
	<div class="container mw-100 h-auto d-inline-block">
	<div class="row h-25 d-flex justify-content-center">
		<img alt="Welcome" src="<%=request.getContextPath() %>/assets/weolcome3.svg" class=" d-flex justify-content-center w-25 p-3 "  >
	</div>
		<div class="row d-flex justify-content-center">
			<div class="card text-center w-50 p-3">
				<div class="card-header bg-primary p-2 text-white ">Bienvenido</div>
				<div class="card-body">
					<h5 class="card-title">Librería central</h5>
					<p class="card-text">Bienvenido/a al sistema administrativo</p>
					<a href="<%=request.getContextPath()%>/views/login.jsp"
						class="btn btn-primary bg-opacity-75">Inicio de sesión</a> <a href="#"
						class="btn btn-primary bg-opacity-75">Registrarse</a>
				</div>
			</div>
		</div>
	</div>


	<%@include file="/bootstrap/script.jsp"%>
</body>
</html>
