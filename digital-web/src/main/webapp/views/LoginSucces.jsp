<%@page import="com.digital.enums.KeysEnum"%>
<%@page import="com.digital.domain.User"%>
<html>
<head>
<%@include file="/bootstrap/style.jsp" %>

<title>Sistema de productos</title>
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/assets/favicon.ico">
</head>
<body>
<%@include file="/views/navbar.jsp" %>
<br>
<div class="container-fluid">
	<div class="row">
	
	<% User user = (User) request.getAttribute(KeysEnum.USUARIO.getViewKey()); %>
	<main>
		  <div class="container py-4">
		    <header class="pb-3 mb-4 border-bottom">
		      <a href="<% request.getContextPath();%>" class="d-flex align-items-center text-dark text-decoration-none">
		        <span class="fs-4">Bienvenido: <%=user.getUsuario() %></span>
		      </a>
		    </header>
		    <div class="p-5 mb-4 bg-light rounded-3">
		      <div class="container-fluid py-5">
		        <h1 class="display-5 fw-bold">Bienvenido</h1>
		        <p class="col-md-8 fs-4">Sistema de administración de productos</p>
     			<a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>/views/listadoGeneral.jsp" role="button">
     				Ver Listado
     			</a> 
		      </div>
		    </div>
		    <footer class="pt-3 mt-4 text-muted border-top">
		      Bootcamp java - EducacionIt - 2021
		    </footer>
		  </div>
		</main>
	</div>
</div>

<%@include file="/bootstrap/script.jsp" %>
</body>
</html>
