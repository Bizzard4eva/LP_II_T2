<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#cEdec9">

	<h2 align="center">ERP-SOLUTIONPERU S.A.C</h2>
	<h2 align="center">Login</h2>
	
	<form action="ControladorLogin" method="post">
	<table>
		<tr>
			 <td>Usuario</td>
			 <td><input type="text" name="usuario"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Ingresar al Sistema"></td>
		</tr>
	</table>
	</form>

</body>
</html>