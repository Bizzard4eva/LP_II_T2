package Tests;

import Dao.ClassUsuarioImpl;
import Entidades.Usuario;

public class TestUsuarios {

	public static void main(String[] args) {
		ClassUsuarioImpl dao = new ClassUsuarioImpl();
		
		Usuario usuario = new Usuario();
		usuario.setUser("Bizzard");
		usuario.setPassword("123456");
		
		dao.createUsuario(usuario);
		
		
	}

}
