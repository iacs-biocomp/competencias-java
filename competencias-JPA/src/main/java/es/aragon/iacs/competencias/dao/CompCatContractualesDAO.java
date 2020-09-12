package es.aragon.iacs.competencias.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jfree.util.Log;

import es.aragon.iacs.competencias.jpa.CompCatContract;
import es.aragon.iacs.competencias.jpa.CompCatContractualesV;

@Stateless
public class CompCatContractualesDAO implements ICompCatContractualesDAO {
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	

	@Override
	public List<CompCatContractualesV> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCatContractualesV.findAll");
		@SuppressWarnings("unchecked")
		List<CompCatContractualesV> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public void editId(int id, String catComp) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCatContract.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompCatContract result = (CompCatContract)query.getSingleResult();
		//Cambiarle la catCompetencial por la nueva
		result.setCodCatComp(catComp);
		em.merge(result);
		em.flush();
	}
	
}