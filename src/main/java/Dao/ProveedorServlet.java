package Dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Proveedore;

/**
 * Servlet implementation class ProveedorServlet
 */
public class ProveedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "loadRegistro": 
			loadRegistro(request, response);
			break;
		case "loadEditar": 
			loadEditar(request, response);
			break;
		case "Registrar": 
			registrar(request, response);
			break;
		case "Editar": 
			editar(request, response);
			break;
		case "Eliminar": 
			eliminar(request, response);
			break;

		default:
			request.setAttribute("mensaje", "Ocurrio un error");
			request.getRequestDispatcher("MenuPrincipal.jsp").forward(request, response);
		}
	}


	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ClassProveedorImpl dao = new ClassProveedorImpl();
		
		Proveedore proveedor = new Proveedore();
		Integer id = Integer.parseInt(request.getParameter("id"));
		proveedor.setIdProveedor(id);
		dao.deleteProveedor(proveedor);
		response.sendRedirect("ProveedorServlet?action=loadRegistro");
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassProveedorImpl dao = new ClassProveedorImpl();
		
		Proveedore proveedor = new Proveedore();
		proveedor.setNombre(request.getParameter("nombre"));
		proveedor.setRazonSocial(request.getParameter("razonSocial"));
		proveedor.setRuc(request.getParameter("ruc"));
		proveedor.setEmail(request.getParameter("email"));
		proveedor.setFechaIngreso(new Date(new Date().getTime()));
		
		dao.updateProveedor(proveedor);
		response.sendRedirect("ProveedorServlet?action=loadRegistro");
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassProveedorImpl dao = new ClassProveedorImpl();
		
		Proveedore proveedor = new Proveedore();
		proveedor.setNombre(request.getParameter("nombre"));
		proveedor.setRazonSocial(request.getParameter("razonSocial"));
		proveedor.setRuc(request.getParameter("ruc"));
		proveedor.setEmail(request.getParameter("email"));
		proveedor.setFechaIngreso(new Date(new Date().getTime()));
		
		dao.createProveedor(proveedor);
		response.sendRedirect("ProveedorServlet?action=loadRegistro");
	}

	private void loadRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassProveedorImpl dao = new ClassProveedorImpl();
		List<Proveedore> listProveedor = dao.listProveedor();
		System.out.println(listProveedor);
		request.setAttribute("listProveedores", listProveedor);
		request.getRequestDispatcher("RegistrarProveedor.jsp").forward(request, response);
	}
	
	private void loadEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassProveedorImpl dao = new ClassProveedorImpl();
		Proveedore proveedor = new Proveedore();
		Integer id = Integer.parseInt(request.getParameter("id"));
		proveedor.setIdProveedor(id);
		Proveedore proveedor2 = dao.getProveedor(proveedor);
		
		request.setAttribute("proveedor2", proveedor2);
		request.getRequestDispatcher("EditarProveedor.jsp").forward(request, response);
		
	}

}
