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
	<h1 class="pt-3">Nuevo Producto</h1>
	<br>
	</div>
	<form action="<%=request.getContextPath()%>/controllers/nuevoProducto" method="get">
		<div class="col-9">
			<div class="input-group mb-3 mt-0">
	  			<span class="input-group-text col-2" id="basic-addon1">Titulo</span>
		  		<input type="text" required name="titulo" class="form-control" placeholder="Harry Potter" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
	  			<span class="input-group-text col-2" id="basic-addon1">C?digo</span>
		  		<input type="text" required maxlength="6" name="codigo" class="form-control" placeholder="123564" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
	  			<span class="input-group-text col-2" id="basic-addon1">Precio - $</span>
		  		<input type="number" required min="300" max="7000" name="precio" class="form-control" placeholder="1500" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
	  			<span class="input-group-text col-2" id="basic-addon1">Stock</span>
		  		<input type="number" required name="stock" class="form-control" placeholder="1500" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="form-group">
		              <label for="country" class="form-label">Categoria</label>
		              <select name="categoria" class="form-select" id="country" required>
		                <option value="">Seleccione...</option>
		                <% 
		                	List<Categorias> categoriass = (List<Categorias>)request.getAttribute("categorias"); 
							if(categoriass != null){
		                	for(Categorias categoria : categoriass) {
		                %>
			                <option value="<%=categoria.getId()%>"><%=categoria.getDescripcion() %></option>
						<%
		                	}
						}
						%>
						</select>
						 <label for="country" class="form-label mt-2">Marca</label>
						<select name="marca" class="form-select" id="country" required>
						<option value="">Seleccione una marca</option>
		                <% 
		                	List<Marcas> marcas = (List<Marcas>)request.getAttribute("marcas"); 
							if(marcas != null){
		                	for(Marcas marca : marcas) {
		                %>
			                <option value="<%=marca.getId()%>"><%=marca.getDescripcion() %></option>
						<%
		                	}
						}
						%>
		              </select>
			
			
			<div class="col-12 mt-3">
						<button class="btn btn-primary" type="submit">Agregar</button>
			</div>
		</div>
	</form>
	</div>
</div>


<%@include file="/bootstrap/script.jsp" %>
</body>
</html>

