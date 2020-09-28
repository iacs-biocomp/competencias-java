<%@page import="es.aragon.midas.config.Menu"%>
<%@page import="es.aragon.midas.util.ConnectionFactory"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="es.aragon.midas.config.AppProperties" %>
<%@page import="es.aragon.midas.rules.DroolsManager" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Probe</title>
</head>
<body>
	<%
		String status = "";
		Connection conn = null;
		Statement stmt = null;
		
		status += "<app>OK</app>";
		
		try {
			conn = ConnectionFactory.getConnection();
			status += "<jndi>OK</jndi>";
		} catch (Exception e) {
			status += "<jndi>ERROR</jndi>";
		}

		try {
			stmt = conn.createStatement();
			stmt.executeQuery("Select sysdate from dual");
			status += "<database>OK</database>";
		} catch (Exception e) {
			status += "<database>ERROR</database>";
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	%>

	<%=status%>

	<%
		if (request.getParameter("reload") != null
				&& request.getParameter("reload").equals("true")) {		
			// Recarga las propiedades de la aplicación
			AppProperties.reload();
			
			// Recarga el menú de la aplicación
			Menu.reload();
			
			// Recarga las reglas de drools
			DroolsManager.loadRules();
		}
	%>

</body>
</html>
