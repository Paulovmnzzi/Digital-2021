<%@page import="com.digital.enums.KeysEnum"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Digitalers</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/index.jsp">Inicio</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/views/login.jsp">Inicio de sesion</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Productos
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/controllers/nuevoProducto">Agregar producto</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/views/listadoGeneral.jsp">Listado General</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Desesperación</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/views/Registro.jsp" tabindex="-1" aria-disabled="false">Registrarse</a>
        </li>
      </ul>
      <form action="<%=request.getContextPath()%>/controllers/buscarProducto" class="d-flex align-items-center mt-2" method="get">
        <input class="form-control me-2" type="search" name="<%=KeysEnum.CLAVE_BUSQUEDA.getViewKey() %>" placeholder="Search" aria-label="Search">
        <button class="btn btn-secondary btn-lg " type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>