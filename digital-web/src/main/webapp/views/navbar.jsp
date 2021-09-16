<%@page import="com.digital.domain.User"%>
<%@page import="com.digital.enums.KeysEnum"%>
<%
User usuario = (User) request.getSession().getAttribute(KeysEnum.USUARIO.getViewKey());
String userName = "Usuario";
%>
<nav
	class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand d-flex align-items-center" href="<%=request.getContextPath()%>/index.jsp">Librería
			Central</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div
			class="collapse navbar-collapse d-flex justify-content-start me-2"
			id="navbarSupportedContent">
			<ul class="navbar-nav me-0 mb-2 mb-lg-0">
				<li class="nav-item d-flex align-items-center"><a class="nav-link active d-flex align-items-center"
					aria-current="page" href="<%=request.getContextPath()%>/index.jsp">Inicio</a>
				</li>
				<li class="nav-item dropdown d-flex align-items-center"><a
					class="nav-link dropdown-toggle " href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Productos </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item"
							href="<%=request.getContextPath()%>/controllers/nuevoProducto">Agregar
								producto</a></li>
						<li><a class="dropdown-item"
							href="<%=request.getContextPath()%>/views/listadoGeneral.jsp">Listado
								General</a></li>
					</ul>
				<li class="nav-item dropdown ms-0 ps-1 d-flex align-items-center "><a
					class="nav-link dropdown-toggle d-flex align-items-center" href="#" tabindex="-1"
					id="navbarDropdown2" role="button" data-bs-toggle="dropdown"
					aria-expanded="false" aria-disabled="false"><img class="mx-1" alt=''
						src="../assets/user.png"> <%
 if (usuario != null) {
 	userName = usuario.getUsuario();
 	out.print(userName);
 } else {
 	out.print(userName);
 }
 %> </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
						<li><a class="dropdown-item"
							href="<%=request.getContextPath()%>/views/login.jsp">Inicio
								de sesion</a></li>
						<li><a class="dropdown-item"
							href="<%=request.getContextPath()%>/views/Registro.jsp"
							tabindex="-1" aria-disabled="false">Registrarse</a></li>
							<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="<%=request.getContextPath() %>/Logout">Logout</a></li>
					</ul>
			</ul>
		</div>
		<%-- 	<ul class="navbar-nav me-auto ps-5 ms-5 mb-2 mb-lg-0">
				<li class="nav-item ps-5 ms-4"><a
					class="nav-link ps-5 ms-5" href="#" tabindex="-1" aria-disabled="false">
						<%
						User usuario = (User)session.getAttribute(KeysEnum.USUARIO.getViewKey());
						if(usuario != null){
							out.print("Welcome: " + usuario.getUsuario());
						}
						%>
				</a></li>
			</ul>  --%>
		<div>
			<form
				action="<%=request.getContextPath()%>/controllers/buscarProducto"
				class="d-flex align-items-center mt-2 d-flex justify-content-end"
				method="get">
				<input class="form-control me-2" type="search"
					name="<%=KeysEnum.CLAVE_BUSQUEDA.getViewKey()%>"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-secondary btn-md " type="submit">Buscar</button>
			</form>
		</div>
	</div>
</nav>