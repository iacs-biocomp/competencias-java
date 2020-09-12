package es.aragon.iacs.competencias.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompComportamientos;
import es.aragon.iacs.competencias.jpa.CompNiveles;

@Stateless
public class CompNivelesDAO implements ICompNivelesDAO {
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	

	@Override
	public List<CompNiveles> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompNiveles.findAll");
		@SuppressWarnings("unchecked")
		List<CompNiveles> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompNiveles.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompNiveles n=(CompNiveles)query.getSingleResult();
		//if cat is not null comprobar
		em.remove(n);
		em.flush();
		
	}
	
	@Override
	public void insert(String nombre, float valorporcentual, String alta, String baja) {
		// TODO Auto-generated method stu
		CompNiveles nueva=new CompNiveles();
		nueva.setNombre(nombre);
		nueva.setValorporcentual(valorporcentual);
		nueva.setAlta(alta);
		nueva.setBaja(baja);
		
		em.persist(nueva);
		em.flush();
	}
	
	
	@Override
	public void edit(Integer id, String nombre, float valorporcentual, String alta, String baja) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompNiveles.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompNiveles n=(CompNiveles)query.getSingleResult();
		n.setNombre(nombre);
		n.setValorporcentual(valorporcentual);
		n.setAlta(alta);
		n.setBaja(baja);
		//if cat is not null comprobar
		em.merge(n);
		em.flush();
	}
}