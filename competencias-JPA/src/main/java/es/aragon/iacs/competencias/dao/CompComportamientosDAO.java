package es.aragon.iacs.competencias.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompComportamientos;

@Stateless
public class CompComportamientosDAO implements ICompComportamientosDAO {
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	

	@Override
	public List<CompComportamientos> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompComportamientos.findAll");
		@SuppressWarnings("unchecked")
		List<CompComportamientos> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompComportamientos.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompComportamientos comp=(CompComportamientos)query.getSingleResult();
		//if cat is not null comprobar
		em.remove(comp);
		em.flush();
		
	}
	
	@Override
	public void insert(String descripcion, String alta, String baja) {
		// TODO Auto-generated method stu
		CompComportamientos nueva=new CompComportamientos();
		nueva.setDescripcion(descripcion);
		nueva.setAlta(alta);
		nueva.setBaja(baja);
		
		em.persist(nueva);
		em.flush();
	}
	
	@Override
	public void edit(Integer id, String descripcion, String alta, String baja) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompComportamientos.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompComportamientos comp=(CompComportamientos)query.getSingleResult();
		comp.setDescripcion(descripcion);
		comp.setAlta(alta);
		comp.setBaja(baja);
		//if cat is not null comprobar
		em.merge(comp);
		em.flush();
	}
	
}
