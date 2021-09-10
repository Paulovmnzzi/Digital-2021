<html>
	<head>
		<!-- CSS only -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	</head>
	<body>
	<!-- ESTATICO -->
		1
		2
		3
		4
		5
		6
		7
		8
		9
		10	
	<!-- DINAMICO -->
		<%
			for(int i=0; i <= 10; i++) {
				out.print(" soy el numero"+ i); //objeto implicito		
			}
		%>	
		<%
			out.print("soy un bloque nuevo");
		%>
		<br>
		<div id="divSaludar"></div>
		
		<button id="btnSaludar">Saludar</button>
		
		<script
			  src="https://code.jquery.com/jquery-3.6.0.js"
			  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
			  crossorigin="anonymous">
		</script>		
		<script type="text/javascript" src="js/index.js"></script>
	</body>
</html>
