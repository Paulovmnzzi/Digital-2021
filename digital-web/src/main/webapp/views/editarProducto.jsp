<%@page import="com.digital.domain.Producto"%>
<%@page import="com.digital.domain.Marcas"%>
<%@page import="com.digital.domain.Categorias"%>
<%@page import="java.util.List"%>
<html>
<head>
<%
Producto edit = (Producto) request.getAttribute(KeysEnum.PRODUCTO_EDITAR.getViewKey());
%>
<%@include file="/bootstrap/style.jsp"%>
<title>Inicio</title>
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/assets/favicon.png">


</head>
<body>
	<%@include file="/views/navbar.jsp"%>
	<%@include file="/views/mensajeria.jsp"%>

	<div class="container">
		<div class="row">
			<div>
				<h1 class="pt-3">Editar Producto</h1>
				<br>
			</div>
			<form
				action="<%=request.getContextPath()%>/controllers/editarProducto"
				method="get">
				<div class="col-9">
					<div class="input-group mb-3 mt-0">
						<span class="input-group-text col-2" id="basic-addon1">ID</span> <input
							type="text" name="id" class="form-control" aria-label="Username"
							value="<%=edit.getId()%>" aria-describedby="basic-addon1">
					</div>
					<div class="input-group mb-3 mt-0">
						<span class="input-group-text col-2" id="basic-addon1">Titulo</span>
						<input type="text" name="titulo" class="form-control"
							aria-label="Username" value="<%=edit.getTitulo()%>"
							aria-describedby="basic-addon1" required="required">
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text col-2" id="basic-addon1">Código</span>
						<input type="text" name="codigo" class="form-control"
							aria-label="Username" value="<%=edit.getCodigo()%>"
							aria-describedby="basic-addon1" maxlength="6" required="required">
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text col-2" id="basic-addon1">Precio
							- $</span> <input type="number" name="precio" class="form-control"
							aria-label="Username" value="<%=edit.getPrecio()%>"
							aria-describedby="basic-addon1" max="7000" min="300" required="required" >
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text col-2" id="basic-addon1">Stock</span>
						<input type="number" name="stock" class="form-control"
							value="<%=edit.getStock()%>" aria-label="Username"
							aria-describedby="basic-addon1" required="required" maxlength="8">
					</div>
					<div class="form-group">
						<label for="country" class="form-label col-2">Categoria</label> <select
							name="categoria" class="form-select" id="country" required>
							<option value="">Seleccione...</option>
							<%
							List<Categorias> categoriass = (List<Categorias>) request.getAttribute("categorias");
							if (categoriass != null) {
								for (Categorias categoria : categoriass) {
									String selected = categoria.getId().equals(edit.getCategoriasId()) ? "selected" : "";
							%>
							<option <%=selected%> value="<%=categoria.getId()%>"><%=categoria.getDescripcion()%></option>
							<%
							}
							}
							%>
						</select> <label for="country" class="form-label mt-2 col-2">Marca</label>
						<select name="marca" class="form-select" id="country" required>
							<option value="">Seleccione una marca</option>
							<%
							List<Marcas> marcas = (List<Marcas>) request.getAttribute("marcas");
							if (marcas != null) {
								for (Marcas marca : marcas) {
									String selected = marca.getId().equals(edit.getMarcasId()) ? "selected" : "";
							%>
							<option <%=selected%> value="<%=marca.getId()%>"><%=marca.getDescripcion()%></option>
							<%
							}
							}
							%>
						</select>


						<div class="col-12 mt-3">
							<button class="btn btn-primary" type="submit">Editar</button>
						</div>
					</div>
			</form>
		</div>
	</div>


	<%@include file="/bootstrap/script.jsp"%>
</body>
</html>

