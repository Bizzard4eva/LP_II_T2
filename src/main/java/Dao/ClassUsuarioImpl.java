package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import Entidades.Usuario;
import Interfaces.IUsuario;

public class ClassUsuarioImpl implements IUsuario {

	public List<Usuario> listUsuario() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectCl2");
		EntityManager manager = factory.createEntityManager();
		
		List<Usuario> listUsuario = null;
		
		try
		{
			manager.getTransaction().begin();
			listUsuario = manager.createQuery("Select x from Usuarios x", Usuario.class).getResultList();
			manager.getTransaction().commit();
		} catch(Exception e) {
			if(manager.getTransaction().isActive()) manager.getTransaction().rollback();
			e.getMessage();
		} finally {
			manager.close();
		}
		return listUsuario;
	}

	public Usuario getUsuario(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectCl2");
		EntityManager manager = factory.createEntityManager();
		
		Usuario usuar = null;
		
		try
		{
			manager.getTransaction().begin();
			usuar = manager.find(Usuario.class, usuario.getIdUsuario());
			manager.getTransaction().commit();

		} catch (Exception e) {
			if(manager.getTransaction().isActive()) manager.getTransaction().rollback();
			e.getMessage();
		} finally {
			manager.close();
		}
		return usuar;
	}

	public void createUsuario(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectCl2");
		EntityManager manager = factory.createEntityManager();
		
		try
		{
			manager.getTransaction().begin();
			manager.persist(usuario);
			System.out.println("Usuario correctamente registrado en la BD");
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			manager.close();
		}
	}

	public void updateUsuario(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectCl2");
		EntityManager manager = factory.createEntityManager();
		
		try
		{
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			manager.close();
		}

	}

	public void deleteUsuario(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectCl2");
		EntityManager manager = factory.createEntityManager();

		try
		{
			manager.getTransaction().begin();
			Usuario paraEliminar = manager.find(Usuario.class, usuario.getIdUsuario());
			if(usuario != null) {
				manager.remove(paraEliminar);
				manager.getTransaction().commit();
			}
		} catch (Exception e) {
			if(manager.getTransaction().isActive()) manager.getTransaction().rollback();
			e.getMessage();
		} finally {
			manager.close();
		} 
	}

}
