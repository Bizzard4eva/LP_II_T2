package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProveedorImpl;
import Entidades.Proveedore;

public class ControladorProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControladorProveedor() {
        super();
        // TODO
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClassProveedorImpl dao = new ClassProveedorImpl();
		List<Proveedore> listProveedor = dao.listProveedor();
		request.setAttribute("listProveedores", listProveedor);
		
		
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "Listar":
				request.getRequestDispatcher("RegistrarProveedor.jsp").forward(request, response);
				break;
			case "Registrar":
				
				break;
			case "Actualizar":
				
				break;
			case "Eliminar":
				
				break;
			default:
				break;
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO
		doGet(request, response);
	}

}
