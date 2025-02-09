package Interfaces;

import java.util.List;
import Entidades.Usuario;


public interface IUsuario {

	List<Usuario> listUsuario();
	Usuario getUsuario(Usuario usuario);
	void createUsuario(Usuario usuario);
	void updateUsuario(Usuario usuario);
	void deleteUsuario(Usuario usuario);
}
