package es.aragon.iacs.competencias.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompOrganigramas;
import es.aragon.iacs.competencias.jpa.CompPares;
import es.aragon.iacs.competencias.jpa.CompSuperiores;

@Stateless
public class CompOrganigramasDAO implements ICompOrganigramasDAO{
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	

	@Override
	public List<CompOrganigramas> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompOrganigramas.findAll");
		@SuppressWarnings("unchecked")
		List<CompOrganigramas> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public List<CompPares> findPares(Integer id) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompPares.findByOrganigrama");
		query.setParameter("idOrganigrama", id);
		@SuppressWarnings("unchecked")
		List<CompPares> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public List<CompSuperiores> findSuperiores(Integer id) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompSuperiores.findByOrganigrama");
		query.setParameter("idOrganigrama", id);
		@SuppressWarnings("unchecked")
		List<CompSuperiores> projects = query.getResultList();
		return projects;
	}
}
