package Interfaces;

import java.util.List;
import Entidades.Proveedore;

public interface IProveedor {

	List<Proveedore> listProveedor();
	Proveedore getProveedor(Proveedore proveedor);
	void createProveedor(Proveedore proveedor);
	void updateProveedor(Proveedore proveedor);
	void deleteProveedor(Proveedore proveedor);
}
