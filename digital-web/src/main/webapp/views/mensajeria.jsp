<%@page import="com.digital.enums.KeysEnum"%>
<%@page import="java.util.Collection"%>

<%
	if(request.getAttribute(KeysEnum.ERROR_GENERAL.name()) != null) {
%>		
	<div class="row mt-1">
		<div class="col-12">
			<div class="alert alert-danger" role="alert">
				<%=request.getAttribute(KeysEnum.ERROR_GENERAL.name()) %>
			</div>
		</div>
	</div>
<%
	}
%>	

<%
	if(request.getAttribute(KeysEnum.WARNING_GENERAL.name()) != null) {
%>		
	<div class="row mt-1">
		<div class="col-12">
			<div class="alert alert-warning" role="alert">
				<%=request.getAttribute(KeysEnum.WARNING_GENERAL.name()) %>
			</div>
		</div>
	</div>
<%
	}
%>

<%
	if(request.getAttribute(KeysEnum.EXITO.name()) != null) {
%>		
	<div class="row mt-1">
		<div class="col-12">
			<div class="alert alert-success" role="alert">
				<%=request.getAttribute(KeysEnum.EXITO.name()) %>
			</div>
		</div>
	</div>
<%
	}
%>	
