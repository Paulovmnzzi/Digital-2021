<html>
<head>
<%@include file="/bootstrap/style.jsp"%>
<title>Inicio</title>
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/assets/favicon.png">


</head>
<body>
	<%@include file="/views/navbar.jsp"%>
	<div class="container mw-100 h-auto d-inline-block">
	<div class="row h-25 d-flex justify-content-center">
	<%@include file="/views/mensajeria.jsp"%>
	<div class="container-fluid mh-100">
	<div class="row d-flex justify-content-center mh-100">
	<div class="col-12 col-lg-12 col-xl-10 col-xxl-9  d-flex justify-content-center mh-100 ">
		<img alt="Welcome" src="<%=request.getContextPath() %>/assets/weolcome3.svg" class="img-fluid h-100 d-inline-block w-50 p-3 d-flex justify-content-center d-flex align-items-stretch pt-3 mt-3"  >
	</div>
	</div>
	</div>
	</div>
		<div class="row d-flex justify-content-center pt-5">
			<div class="col-11 col-lg-9 col-xl-8 col-xxl-5 card text-center p-3">
				<div class="card-header bg-primary p-2 text-white ">Bienvenido</div>
				<div class="card-body">
					<h5 class="card-title">Librería central</h5>
					<p class="card-text">Bienvenido/a al sistema administrativo</p>
					<a href="<%=request.getContextPath()%>/views/login.jsp"
						class="btn btn-primary bg-opacity-75">Inicio de sesión</a> 
						<a href="<%=request.getContextPath() %>/views/Registro.jsp"
						class="btn btn-primary bg-opacity-75">Registrarse</a>
				</div>
			</div>
		</div>
	</div>


	<%@include file="/bootstrap/script.jsp"%>
</body>
</html>
