<%@page import="com.digital.domain.Categorias"%>
<%@page import="com.digital.service.impl.CategoriasServiceImpl"%>
<%@page import="com.digital.service.CategoriasService"%>
<%@page import="com.digital.domain.Marcas"%>
<%@page import="com.digital.service.impl.MarcasServiceImpl"%>
<%@page import="com.digital.service.MarcasService"%>
<%@page import="com.digital.dao.impl.ColumnEnum"%>
<%@page import="java.util.List"%>
<%@page import="com.digital.domain.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digital.service.ProductoService"%>
<%@page import="com.digital.service.impl.ProductoServiceImpl"%>
<html>
<head>
<% 
MarcasService ms = new MarcasServiceImpl();
CategoriasService cs = new CategoriasServiceImpl();	
ArrayList<Marcas> mark = (ArrayList<Marcas>) ms.findAll();
ArrayList<Categorias> categor = (ArrayList<Categorias>)cs.findAll();

%>
<%@include file="/bootstrap/style.jsp"%>
<title>Inicio de sesion</title>
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/assets/favicon.ico">
</head>
<body>
	<%@include file="/views/navbar.jsp"%>
	<%@include file="/views/mensajeria.jsp"%>
	
	
	<div class="container-fluid">
	<div class="row">
			<div class="col-8">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Titulo</th>
							<th scope="col">Código</th>
							<th scope="col">Precio</th>
							<th scope="col">Stock</th>
							<th scope="col">Categoria</th>
							<th scope="col">Marca</th>
							
						</tr>
					</thead>
					<tbody>
					<%	ArrayList<Producto> productoss = (ArrayList<Producto>)request.getAttribute(KeysEnum.LISTADO.getViewKey());
					if(productoss == null){
						ProductoService ps = new ProductoServiceImpl();
						productoss = (ArrayList)ps.findAll();
					}
					%>
					<%for(Producto product : productoss){
						String marca1 = null;
						String ktegor1 = null;
						for(Marcas marca : mark){
							if(marca.getId() == product.getMarcasId()){
								marca1 = marca.getDescripcion();
							}
						}
						for(Categorias categoria : categor){
							if(categoria.getId() == product.getCategoriasId()){
								ktegor1 = categoria.getDescripcion();
							}
						}
						
						
						%>
						<tr>
							<th scope="row"> <%=product.getId() %> </th>
							<td> <%=product.getTitulo() %> </td>
							<td><%=product.getCodigo() %></td>
							<td><%=product.getPrecio() %></td>
							<td><%=product.getStock() %></td>
							<td><%=ktegor1 %></td>
							<td><%=marca1%></td>
							<td>
							<div class="d-grid gap-2 d-md-flex justify-content-md-end">
										<a class="btn btn-danger me-md-2" href="<%=request.getContextPath()%>/controllers/EliminarProducto?id=<%=product.getId()%>" role="button">Eliminar</a> 
										<a class="btn btn-primary" href="<%=request.getContextPath()%>/controllers/CargarEditarProducto?id=<%=product.getId()%>" role="button">Editar</a> 
									</div>
							</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			<div class="col-1"></div>
			<div class="col-3 align-self-center mt-4">
					<h3 class="align-self-center">Filtrar:</h3>
					<form class="form-inline" action="<%=request.getContextPath()%>/controllers/buscarProducto" method="get">
					<input type="hidden" name="" value="" >
						<div class="form-group">
							<label>Titulo</label>
							<input name="<%=KeysEnum.CLAVE_BUSQUEDA.getViewKey() %>" type="search" class="form-control" id="titulo">
						</div>
						<div class="form-group">
							<label>Precio</label>
							<input name="<%=KeysEnum.CLAVE_BUSQUEDA_PRECIO.getViewKey() %>" type="number" class="form-control" id="precio">
						</div>
						<div class="form-group">
						    <label for="exampleInputPassword1">Ordenar (Precio)</label>
						    <select name="orden" class="form-control">
								<option value="asc">Menor precio</option>
							    <option value="desc">Mayor precio</option>
							</select>
						  </div>
						  <div class="d-flex justify-content-end">
						<button type="submit" class="btn btn-primary mt-1">
							Filtrar
						</button>
						  </div>
					</form>
				</div> 
		</div>
	</div>



	<%@include file="/bootstrap/script.jsp"%>
</body>
</html>
