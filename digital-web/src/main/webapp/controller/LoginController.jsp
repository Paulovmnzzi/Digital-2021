<%@page import="com.digital.domain.User"%>
<%@page import="com.digital.service.impl.LoginServiceImpl"%>
<%@page import="com.digital.service.LoginService"%>
<%

	String username = request.getParameter("username");
	String password = request.getParameter("password");

	LoginService login = new LoginServiceImpl();
	User user = login.getUserByUserName(username);
	if(user.getContraseña().equals(password)){
		out.print("exito");
	}




%>