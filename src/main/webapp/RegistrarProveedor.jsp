<%@page import="Entidades.Proveedore"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRAR PROVEEDOR</title>
</head>
<body>
	<h2 align="center">REGISTRAR PROVEEDOR</h2>
	
	<form action="ProveedorServlet" method="post">
	<input type="hidden" name="action" value="Registrar">
	<table>
		<tr>
			 <td align="center">Nombre:</td>
			 <td align="center"><input type="text" name="nombre"></td>
		</tr>
		<tr>
			<td align="center">Razon Social:</td>
			<td align="center"><input type="text" name="razonSocial"></td>
		</tr>
		<tr>
			<td align="center">RUC:</td>
			<td align="center"><input type="text" name="ruc"></td>
		</tr>
		<tr>
			<td align="center">Email:</td>
			<td align="center"><input type="text" name="email"></td>
		</tr>
		<tr>
			<td align="center">Fecha Ingreso:</td>
			<td align="center"><input type="text" name="fechaIngreso"></td>
		</tr>				
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Registrar"></td>
		</tr>
	</table>
	</form>
	
	<h2 align="center">DATOS REGISTRADOS EN LA BD</h2>
	<h3 align="center">Login</h3>
	
	<table align="center" border="2">
		<tr>
			<td>Codigo</td><td>Nombre</td><td>R.Social</td>
			<td>Ruc</td><td>Email</td><td>Fecha Ing.</td>
			<td colspan="2" align="center">Acciones</td>
		</tr>
		<%
		List<Proveedore> listProvedor = (List<Proveedore>) request.getAttribute("listProveedores");
		if(listProvedor != null) {
			for(Proveedore proveedor : listProvedor)  {
		%>
			<tr>
				<td><%=proveedor.getIdProveedor()%></td>
				<td><%=proveedor.getNombre()%></td>
				<td><%=proveedor.getRazonSocial()%></td>
				<td><%=proveedor.getRuc()%></td>
				<td><%=proveedor.getEmail()%></td>
				<td><%=proveedor.getFechaIngreso()%></td>
				<td><a href="ProveedorServlet?action=loadEditar&id=<%=proveedor.getIdProveedor()%>">Actualizar</a></td>
				<td><a href="ProveedorServlet?action=Eliminar&id=<%=proveedor.getIdProveedor()%>">Eliminar</a></td>
			</tr>
		<%
			}
		}
		%>
	</table>
	
</body>
</html>