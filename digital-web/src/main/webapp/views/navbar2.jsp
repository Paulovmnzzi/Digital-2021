<%@page import="com.digital.domain.User"%>
<%@page import="com.digital.enums.KeysEnum"%>
<%
User usuario = (User) request.getSession().getAttribute(KeysEnum.USUARIO.getViewKey());
String userName = "Usuario";
%>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">Librer?a
			Central</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item d-flex align-items-center"><a
					class="nav-link active d-flex align-items-center"
					aria-current="page" href="<%=request.getContextPath()%>/index.jsp">Inicio</a>
				</li>
				<li class="nav-item dropdown d-flex align-items-center"><a
					class="nav-link dropdown-toggle d-flex align-items-center" href="#"
					id="navbarDropdown" role="button" data-bs-toggle="dropdown"
					aria-expanded="false"> Productos </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item"
							href="<%=request.getContextPath()%>/controllers/nuevoProducto">Agregar
								producto</a></li>
						<li><a class="dropdown-item"
							href="<%=request.getContextPath()%>/views/listadoGeneral.jsp">Listado
								General</a></li>
						<li><hr class="dropdown-divider"></li>
					</ul></li>
				<li class="nav-item dropdown d-flex align-items-center"><a
					class="nav-link dropdown-toggle d-flex align-items-center" href="#"
					id="navbarDropdown" role="button" data-bs-toggle="dropdown"
					aria-expanded="false"> <img
						class="mx-1 d-flex align-items-center" alt=''
						src="../assets/user.png"> <%
 if (usuario != null) {
 	userName = usuario.getUsuario();
 	out.print(userName);
 } else {
 	out.print(userName);
 }
 %>
				</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#"></a></li>
						<li><a class="dropdown-item"
							href="<%=request.getContextPath()%>/views/login.jsp">Inicio
								de sesion</a></li>
						<li><a class="dropdown-item"
							href="<%=request.getContextPath()%>/views/Registro.jsp">Registrarse</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Logout</a></li>
					</ul></li>
			</ul>
			<form class="d-flex mt-3">
				<input class="form-control me-2 " type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn btn-secondary" type="submit">Search</button>
			</form>
		</div>
	</div>
</nav>