package Tests;

import java.util.Date;

import Dao.ClassProveedorImpl;
import Entidades.Proveedore;

public class TestProveedor {

	public static void main(String[] args) {
		ClassProveedorImpl dao = new ClassProveedorImpl();
		
		Proveedore proveedor = new Proveedore();
		proveedor.setNombre("Marcos Sifuentes");
		proveedor.setRazonSocial("SOLUTIONPERU");
		proveedor.setEmail("marco.sifuentes@email.com");
		proveedor.setRuc("10854138021");
//		proveedor.setFechaIngreso();
		
		dao.createProveedor(proveedor);

	}

}
