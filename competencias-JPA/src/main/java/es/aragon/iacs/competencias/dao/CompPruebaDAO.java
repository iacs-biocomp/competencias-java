package es.aragon.iacs.competencias.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompPrueba;

@Stateless
public class CompPruebaDAO implements ICompPruebaDAO {

	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	

	
	
	/**
	 * 
	 */
	@Override
	public List<CompPrueba> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompPrueba.findAll");
		@SuppressWarnings("unchecked")
		List<CompPrueba> projects = query.getResultList();
		return projects;
	}
}
