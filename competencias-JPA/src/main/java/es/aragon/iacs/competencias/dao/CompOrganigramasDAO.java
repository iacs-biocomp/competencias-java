package es.aragon.iacs.competencias.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompNiveles;
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
	public CompOrganigramas findByIdOrganigrama(Integer idOrganigrama) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompOrganigramas.findById");
		query.setParameter("id", idOrganigrama);
		@SuppressWarnings("unchecked")
		CompOrganigramas c = (CompOrganigramas)query.getSingleResult();
		return c;
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
	
	@Override
	public void insertOrganigrama(String nombre, String fechaIni, String fechaFin) {
		// TODO Auto-generated method stu
		CompOrganigramas nuevo=new CompOrganigramas();
		nuevo.setNombre(nombre);
		nuevo.setFechaIni(fechaIni);
		nuevo.setFechaFin(fechaFin);
		
		em.persist(nuevo);
		em.flush();
	}
	
	@Override
	public void deleteOrganigrama(Integer idOrganigrama) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompOrganigramas.findById");
		query.setParameter("id", idOrganigrama);
		@SuppressWarnings("unchecked")
		CompOrganigramas c = (CompOrganigramas)query.getSingleResult();
		
		em.remove(c);
		em.flush();
	}
	
	@Override
	public void editOrganigrama(Integer idOrganigrama, String nombre, String fechaIni, String fechaFin) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompOrganigramas.findById");
		query.setParameter("id", idOrganigrama);
		@SuppressWarnings("unchecked")
		CompOrganigramas c = (CompOrganigramas)query.getSingleResult();
		c.setNombre(nombre);
		c.setFechaIni(fechaIni);
		c.setFechaFin(fechaFin);
		
		em.merge(c);
		em.flush();
	}
	
	@Override
	public void insertSuperior(Integer id,String dniTrabajador, String dniSuperior) {
		// TODO Auto-generated method stu
		CompSuperiores nueva=new CompSuperiores();
		nueva.setIdOrganigrama(id);
		nueva.setDniTrabajador(dniTrabajador);
		nueva.setDniSuperior(dniSuperior);
		
		em.persist(nueva);
		em.flush();
	}
	
	@Override
	public void insertPar(Integer id,String dniTrabajador, String dniPar) {
		// TODO Auto-generated method stu
//		Query query = em.createNamedQuery("CompPares.findPar");
//		query.setParameter("id", id).setParameter("dniTrabajador",dniTrabajador).setParameter("dniPar",dniPar);
//		@SuppressWarnings("unchecked")
//		CompPares par = (CompPares)query.getSingleResult();
//		if(par==null) {
			CompPares nueva=new CompPares();
			nueva.setIdOrganigrama(id);
			nueva.setDniTrabajador(dniTrabajador);
			nueva.setDniPar(dniPar);
			
			em.persist(nueva);
			em.flush();
//		}
		
	}
	
	@Override
	public void deleteSuperior(Integer id) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompSuperiores.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompSuperiores n=(CompSuperiores)query.getSingleResult();
		//if cat is not null comprobar
		em.remove(n);
		em.flush();
		
	}
	
	@Override
	public void deletePar(Integer id) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompPares.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompPares n=(CompPares)query.getSingleResult();
		//if cat is not null comprobar
		em.remove(n);
		em.flush();
		
	}
	
	@Override
	public Integer getIdOrganigramaPar(Integer idRelacion) {
		Query query=em.createNamedQuery("CompPares.findById");
		query.setParameter("id", idRelacion);
		@SuppressWarnings("unchecked")
		CompPares n=(CompPares)query.getSingleResult();
		return n.getIdOrganigrama();
		
	}
	
	@Override
	public Integer getIdOrganigramaSuperior(Integer idRelacion) {
		Query query=em.createNamedQuery("CompSuperiores.findById");
		query.setParameter("id", idRelacion);
		@SuppressWarnings("unchecked")
		CompSuperiores n=(CompSuperiores)query.getSingleResult();
		return n.getIdOrganigrama();
		
	}
}
