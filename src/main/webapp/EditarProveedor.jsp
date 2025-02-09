<%@page import="Entidades.Proveedore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ACTUALIZAR PROVEEDOR</title>
</head>
<body>
	<%
		Proveedore proveedor = (Proveedore) request.getAttribute("proveedor2");
	%>
	<h2 align="center">EDITAR PROVEEDOR</h2>
	
	<form action="ProveedorServlet" method="post">
	<input type="hidden" name="action" value="Editar">
	<table>
		<tr>
			 <td align="center">Nombre:</td>
			 <td align="center"><input type="text" name="nombre" value="<%=proveedor.getNombre()%>"></td>
		</tr>
		<tr>
			<td align="center">Razon Social:</td>
			<td align="center"><input type="text" name="razonSocial" value="<%=proveedor.getRazonSocial()%>"></td>
		</tr>
		<tr>
			<td align="center">RUC:</td>
			<td align="center"><input type="text" name="ruc" value="<%=proveedor.getRuc()%>"></td>
		</tr>
		<tr>
			<td align="center">Email:</td>
			<td align="center"><input type="text" name="email" value="<%=proveedor.getEmail()%>"></td>
		</tr>
		<tr>
			<td align="center">Fecha Ingreso:</td>
			<td align="center"><input type="text" name="fechaIngreso" value="<%=proveedor.getFechaIngreso()%>"></td>
		</tr>				
		<tr>
			<td colspan="2" align="center"><input type="submit" value="ACTUALIZAR"></td>
		</tr>
	</table>
	</form>

</body>
</html>