package es.aragon.iacs.competencias.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.iacs.competencias.jpa.CompCompetencias;

@Stateless
public class CompCatCompetencialesDAO implements ICompCatCompetencialesDAO {
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	

	@Override
	public List<CompCatCompetenciales> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCatCompetenciales.findAll");
		@SuppressWarnings("unchecked")
		List<CompCatCompetenciales> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public void delete(String codigo) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCatCompetenciales.findById");
		query.setParameter("codigo", codigo);
		@SuppressWarnings("unchecked")
		CompCatCompetenciales cat=(CompCatCompetenciales)query.getSingleResult();
		//if cat is not null comprobar
		em.remove(cat);
		em.flush();
		
	}
	@Override
	public void insert(String codigo, String nombre, String alta, String baja) {
		// TODO Auto-generated method stu
		CompCatCompetenciales nueva=new CompCatCompetenciales();
		nueva.setCodigo(codigo);
		nueva.setNombre(nombre);
		nueva.setAlta(alta);
		nueva.setBaja(baja);
		
		em.persist(nueva);
		em.flush();
	}
	
	@Override
	public void edit(String codigo, String nombre, String alta, String baja) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCatCompetenciales.findById");
		query.setParameter("codigo", codigo);
		@SuppressWarnings("unchecked")
		CompCatCompetenciales cat=(CompCatCompetenciales)query.getSingleResult();
		cat.setNombre(nombre);
		cat.setAlta(alta);
		cat.setBaja(baja);
		//if cat is not null comprobar
		em.merge(cat);
		em.flush();
	}
}