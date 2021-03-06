	<div class="container-fluid">
 		<div class="row vh-75">
 		<div class="col-12 col-xxl-6 d-flex align-items-center">
 		<br>
		<img alt="" src="../assets/login.svg" class="ms-5 mt-4 ps-5 d-flex align-items-center">
 		</div>
 			<div class="col-12 col-xxl-6 d-flex justify-content-center d-flex align-items-center">
 			<br>
				<form class="row g-3 needs-validation d-flex align-items-center" novalidate action="<%=request.getContextPath()%>/LoginServlet" method="post">
					<div class="col-md-5">
						<label for="validationCustom01" class="form-label">Username</label>
						<input name="username" placeholder="Usuario" type="text" class="form-control" id="validationCustom01"
							value="" required>
						<div class="valid-feedback">Looks good!</div>
					</div>
					<div class="col-md-5">
						<label for="validationCustom02" class="form-label">Password</label>
						<input type="password" placeholder="Password" name="password" class="form-control" id="validationCustom02"
							value="" required>
						<div class="valid-feedback">Looks good!</div>
					</div>
					<div class="col-md-6">
						<button class="btn btn-primary col-md-6" type="submit">Iniciar</button>
					</div>
			</form>
 			</div>
 		</div>
	</div>
