package es.aragon.iacs.competencias.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

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
		Query query = em.createNamedQuery("CompOrganigramas.findAll");
		@SuppressWarnings("unchecked")
		List<CompOrganigramas> projects = query.getResultList();
		return projects;
	}
	@Override
	public CompOrganigramas findByIdOrganigrama(Integer idOrganigrama) {
		Query query = em.createNamedQuery("CompOrganigramas.findById");
		query.setParameter("id", idOrganigrama);
		@SuppressWarnings("unchecked")
		CompOrganigramas c = (CompOrganigramas)query.getSingleResult();
		return c;
	}
	
	@Override
	public List<CompPares> findPares(Integer id) {
		Query query = em.createNamedQuery("CompPares.findByOrganigrama");
		query.setParameter("idOrganigrama", id);
		@SuppressWarnings("unchecked")
		List<CompPares> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public List<CompSuperiores> findSuperiores(Integer id) {
		Query query = em.createNamedQuery("CompSuperiores.findByOrganigrama");
		query.setParameter("idOrganigrama", id);
		@SuppressWarnings("unchecked")
		List<CompSuperiores> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public List<CompPares> findParesTrabajador(String dniTrabajador) {
		CompOrganigramas orgActivo=findActivo();
		Integer idOrgActivo=orgActivo.getId();
		Query query = em.createNamedQuery("CompPares.findByTrabajador");
		query.setParameter("idOrganigrama", idOrgActivo).setParameter("dniTrabajador", dniTrabajador);
		@SuppressWarnings("unchecked")
		List<CompPares> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public List<CompSuperiores> findSuperioresTrabajador(String dniTrabajador) {
		CompOrganigramas orgActivo=findActivo();
		Integer idOrganigrama=orgActivo.getId();
		Query query = em.createNamedQuery("CompSuperiores.findByTrabajador");
		query.setParameter("idOrganigrama", idOrganigrama).setParameter("dniTrabajador", dniTrabajador);
		@SuppressWarnings("unchecked")
		List<CompSuperiores> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public List<CompSuperiores> findSuperioresByTrabajador(String dniTrabajador) {
		CompOrganigramas orgActivo=findActivo();
		Integer idOrganigrama=orgActivo.getId();
		Query query = em.createNamedQuery("CompSuperiores.findSuperioresByTrabajador");
		query.setParameter("id", idOrganigrama).setParameter("dniTrabajador", dniTrabajador);
		@SuppressWarnings("unchecked")
		List<CompSuperiores> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public List<CompSuperiores> findSuperioresBySuperior(String dniSuperior) {
		CompOrganigramas orgActivo=findActivo();
		Integer idOrganigrama=orgActivo.getId();
		Query query = em.createNamedQuery("CompSuperiores.findSuperioresBySuperior");
		query.setParameter("id", idOrganigrama).setParameter("dniSuperior", dniSuperior);
		@SuppressWarnings("unchecked")
		List<CompSuperiores> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public CompOrganigramas findActivo() {
		Query query =em.createNamedQuery("CompOrganigramas.findActivo");
		Date fechaActual = new Date();
		try {
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
	        String fechaHoy=formateador.format(fechaActual);
	        fechaActual = formateador.parse(fechaHoy);
			query.setParameter("fechaHoy",fechaActual);
			@SuppressWarnings("unchecked")
			List<CompOrganigramas> busqueda=query.getResultList();
			if(busqueda.size()==1) {
				return busqueda.get(0);
			}
			else {
				return null;
			}
		}
		catch(ParseException e) {
			return null;
		}
        
		
	}
	
	@Override
	public void insertOrganigrama(String nombre, Date fechaIni, Date fechaFin) {
		Query query =em.createNamedQuery("CompOrganigramas.findActivos");
		
		try {
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
	        String fechaSistema=formateador.format(fechaIni);
	        fechaIni = formateador.parse(fechaSistema);
	        query.setParameter("fechaIni", fechaIni);
			@SuppressWarnings("unchecked")
			List<CompOrganigramas> busqueda=query.getResultList();
			if(busqueda.size() == 0) {
				CompOrganigramas nuevo=new CompOrganigramas();
				nuevo.setNombre(nombre);
				nuevo.setFechaIni(fechaIni);
				nuevo.setFechaFin(fechaFin);
				//COGER TODOS LOS ORGANIGRAMAS DE LA BD Y COMPROBAR QUE NINGUNO TIENE FECHA FIN POSTERIOR A FECHA INI DEL NUEVO, O FECHA FIN = NULL O =""
				em.persist(nuevo);
				em.flush();
			}
		}
		catch(ParseException e) {
			CompOrganigramas nuevo=new CompOrganigramas();
			nuevo.setNombre(nombre);
			nuevo.setFechaIni(fechaIni);
			nuevo.setFechaFin(fechaFin);
			//COGER TODOS LOS ORGANIGRAMAS DE LA BD Y COMPROBAR QUE NINGUNO TIENE FECHA FIN POSTERIOR A FECHA INI DEL NUEVO, O FECHA FIN = NULL O =""
			em.persist(nuevo);
			em.flush();
		}
        
	
		
		
		
	}
	
	@Override
	public void deleteOrganigrama(Integer idOrganigrama) {
		Query query = em.createNamedQuery("CompOrganigramas.findById");
		query.setParameter("id", idOrganigrama);
		@SuppressWarnings("unchecked")
		CompOrganigramas c = (CompOrganigramas)query.getSingleResult();
		
		em.remove(c);
		em.flush();
	}
	
	@Override
	public void editOrganigrama(Integer idOrganigrama, String nombre, Date fechaIni, Date fechaFin) {
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
		Query query = em.createNamedQuery("CompSuperiores.findSuperior");
		query.setParameter("id", id).setParameter("dniTrabajador",dniTrabajador).setParameter("dniSuperior",dniSuperior);
		@SuppressWarnings("unchecked")
		List<CompSuperiores> superior = query.getResultList();
		
		if (superior.size() == 0) { //NO EXISTE 
			CompSuperiores nueva=new CompSuperiores();
			nueva.setIdOrganigrama(id);
			nueva.setDniTrabajador(dniTrabajador);
			nueva.setDniSuperior(dniSuperior);
			
			em.persist(nueva);
			em.flush();
		}
		
	}
	
	@Override
	public void insertPar(Integer id,String dniTrabajador, String dniPar) {
		Query query = em.createNamedQuery("CompPares.findPar");
		query.setParameter("id", id).setParameter("dniTrabajador",dniTrabajador).setParameter("dniPar",dniPar);
		@SuppressWarnings("unchecked")
		List<CompPares> par = query.getResultList();
		
		if (par.size() == 0) { //NO EXISTE 
			//Comprueba que no existe la relación al reves
			Query query2 = em.createNamedQuery("CompPares.findPar");
			query.setParameter("id", id).setParameter("dniTrabajador",dniPar).setParameter("dniPar",dniTrabajador);
			@SuppressWarnings("unchecked")
			List<CompPares> par2 = query.getResultList();
			
			if (par2.size() == 0) {
				CompPares nueva=new CompPares();
				nueva.setIdOrganigrama(id);
				nueva.setDniTrabajador(dniTrabajador);
				nueva.setDniPar(dniPar);
				
				em.persist(nueva);
				em.flush();
			}
		}
	}
	
	@Override
	public void deleteSuperior(Integer id) {
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
