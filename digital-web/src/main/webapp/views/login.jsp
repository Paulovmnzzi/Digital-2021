<html>
<head>
<%@include file="/bootstrap/style.jsp"%>


<title>Inicio de sesion</title>
<link class="pe-2" rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/assets/favicon.ico">
</head>
<body>
	<%@include file="/views/navbar.jsp"%>

	<section class="vh-75">
		<div class="container-fluid">
			<div class="row d-flex">

<%
String value = "";
if(request.getAttribute(KeysEnum.ERROR_GENERAL.getViewKey()) != null){
										value = (String) request.getAttribute(KeysEnum.ERROR_GENERAL.getViewKey());}
else {
	value = "";
}
										%>

				<div
					class="col-12 col-lg-6 mt-3 text-black d-flex align-items-center d-flex justify-content-center">



					<div
						class="d-flex align-items-center d-flex justify-content-center h-custom-2 px-5 ms-xl-4 mb-5 pb-3 mt-0 pt-0 pt-xl-0 mt-xl-n0">

						<form style="width: 23rem;"
							action="<%=request.getContextPath()%>/LoginServlet" method="post">

							


							<h3
								class="fw-normal text-white py-1 mb-5 pb-2 border border-2 border border-dark rounded-pill
								 d-flex justify-content-center d-flex align-items-center bg-dark"
								style="letter-spacing: 1px;">Iniciar Sesion</h3>

							<div class="form-outline mb-4">
								<input type="text" required="required" id="form2Example17"
									name="username" class="form-control form-control-lg"
									value="<%=value %>"
									 /> <label
									class="form-label" for="form2Example17">Usuario</label>
							</div>

							<div class="form-outline mb-4">
								<input type="password" id="form2Example27" required="required"
									name="password" class="form-control form-control-lg" value="<%=value %>"/> <label
									class="form-label" for="form2Example27">Password</label>
							</div>

							<div class="pt-0 mb-4 d-flex justify-content-end">
								<button
									class="d-flex justify-content-end btn btn-success btn-lg btn-block"
									type="submit">Login</button>
							</div>

							<p class="small mb-5 pb-lg-2">
								<a class="text-muted" href="#!">Te olvidaste tu contraseña?</a>
							</p>
							<p>
								Todavía no tenes una cuenta? <a
									href="<%=request.getContextPath()%>/views/Registro.jsp"
									class="link-success">Registrate acá</a>
							</p>

						</form>

					</div>


				</div>
				<div class="col-12 col-lg-6 px-0 d-none d-sm-block">
					<img src="../assets/libros.jpg" alt="Login image"
						class="w-100 vh-100"
						style="object-fit: cover; object-position: left;">
				</div>
			</div>
		</div>
	</section>


	<%@include file="/bootstrap/script.jsp"%>
</body>
</html>
