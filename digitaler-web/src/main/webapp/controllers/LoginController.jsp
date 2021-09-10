<%@page import="com.digitalers.domain.User"%>
<%@page import="com.digitalers.service.impl.LoginServiceImp"%>
<%@page import="com.digitalers.service.LoginService"%>
<%
	//obtener los parametros enviados por login.jsp 
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	LoginService loginService = new LoginServiceImp();
	User user = loginService.getUserByUserName(username);
	
	if(user.getPassword().equals(password)) {
		out.print("exito");
	}else {
		out.print("fail");
	}
%>