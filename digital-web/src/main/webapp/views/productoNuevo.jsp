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
	<h1 class="pt-3">Nuevo Producto</h1>
	<br>
	</div>
	<form action="<%=request.getContextPath()%>/nuevoProducto" method="get">
		<div class="col-9">
			<div class="input-group mb-3 mt-0">
	  			<span class="input-group-text" id="basic-addon1">Titulo</span>
		  		<input type="text" name="titulo" class="form-control" placeholder="Harry Potter" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
	  			<span class="input-group-text" id="basic-addon1">Código</span>
		  		<input type="text" name="codigo" class="form-control" placeholder="123564" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
	  			<span class="input-group-text" id="basic-addon1">Precio - $</span>
		  		<input type="text" name="precio" class="form-control" placeholder="1500" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
	  			<span class="input-group-text" id="basic-addon1">Stock</span>
		  		<input type="text" name="stock" class="form-control" placeholder="1500" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
	  			<span class="input-group-text" id="basic-addon1">Marca</span>
		  		<input type="text" name="marca" class="form-control" placeholder="1500" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			
			
			<div class="form-group">
		              <label for="country" class="form-label">Categoria</label>
		              <select name="categoria" class="form-select" id="country" required>
		                <option value="">Seleccione...</option>
		                <% 
		                	List<Categorias> categorias = (List<Categorias>)request.getAttribute("categorias"); 
		               
		                	for(Categorias categoria : categorias) {
		                %>
			                <option value="<%=categoria.getId()%>"><%=categoria.getDescripcion() %></option>
						<%
		                	}
						%>
							                
		              </select>
			
			
			<div class="col-12">
						<button class="btn btn-primary" type="submit">Agregar</button>
			</div>
		</div>
	</form>
	</div>
</div>


<%@include file="/bootstrap/script.jsp" %>
</body>
</html>

