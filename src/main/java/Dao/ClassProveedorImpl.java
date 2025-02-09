package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Proveedore;
import Interfaces.IProveedor;

public class ClassProveedorImpl implements IProveedor {

	public List<Proveedore> listProveedor() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectCl2");
		EntityManager manager = factory.createEntityManager();
		
		List<Proveedore> listProveedor = null;
		
		try
		{
			manager.getTransaction().begin();
			listProveedor = manager.createQuery("Select x from Proveedore x", Proveedore.class).getResultList();
			manager.getTransaction().commit();
		} catch(Exception e) {
			if(manager.getTransaction().isActive()) manager.getTransaction().rollback();
			e.getMessage();
		} finally {
			manager.close();
		}
		return listProveedor;
	}

	public Proveedore getProveedor(Proveedore proveedor) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectCl2");
		EntityManager manager = factory.createEntityManager();
		
		Proveedore proveedo = null;
		
		try
		{
			manager.getTransaction().begin();
			proveedo = manager.find(Proveedore.class, proveedor.getIdProveedor());
			manager.getTransaction().commit();

		} catch (Exception e) {
			if(manager.getTransaction().isActive()) manager.getTransaction().rollback();
			e.getMessage();
		} finally {
			manager.close();
		}
		return proveedo;
	}

	public void createProveedor(Proveedore proveedor) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectCl2");
		EntityManager manager = factory.createEntityManager();
		
		try
		{
			manager.getTransaction().begin();
			manager.persist(proveedor);
			System.out.println("Proveedor correctamente registrado en la BD");
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			manager.close();
		}

	}

	public void updateProveedor(Proveedore proveedor) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectCl2");
		EntityManager manager = factory.createEntityManager();
		
		try
		{
			manager.getTransaction().begin();
			manager.merge(proveedor);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			manager.close();
		}
	}

	public void deleteProveedor(Proveedore proveedor) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectCl2");
		EntityManager manager = factory.createEntityManager();

		try
		{
			manager.getTransaction().begin();
			Proveedore paraEliminar = manager.find(Proveedore.class, proveedor.getIdProveedor());
			if(proveedor != null) {
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
