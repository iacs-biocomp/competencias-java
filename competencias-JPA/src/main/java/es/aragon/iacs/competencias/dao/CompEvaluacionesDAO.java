package es.aragon.iacs.competencias.dao;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompEvaluaciones;
import es.aragon.iacs.competencias.jpa.CompValoraciones;

@Stateless
public class CompEvaluacionesDAO implements ICompEvaluacionesDAO{
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	
	
	@Override
	public List<CompEvaluaciones> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompEvaluaciones.findAll");
		@SuppressWarnings("unchecked")
		List<CompEvaluaciones> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public CompEvaluaciones findById(Integer id) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompEvaluaciones.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompEvaluaciones e=(CompEvaluaciones)query.getSingleResult();
		
		return e;
	}
	@Override
	public String getCatcompetencial(Integer id) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompEvaluaciones.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompEvaluaciones e=(CompEvaluaciones)query.getSingleResult();
		
		return e.getCatcompetencial();
	}
	
	@Override
	public void insertInfo(Integer id, String comp1,String comp2,String comp3,String comp4,String comp5,String comp6,String comp7,String comp8,String comp9,String comp10) {
		Query query = em.createNamedQuery("CompEvaluaciones.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompEvaluaciones e=(CompEvaluaciones)query.getSingleResult();
		e.setComp1(comp1);
		e.setComp2(comp2);
		e.setComp3(comp3);
		e.setComp4(comp4);
		e.setComp5(comp5);
		e.setComp6(comp6);
		e.setComp7(comp7);
		e.setComp8(comp8);
		e.setComp9(comp9);
		e.setComp10(comp10);
		
		em.merge(e);
		em.flush();
		
	}

	@Override
	public List<CompEvaluaciones> findActiva(String catCompetencial) {
		Query query = em.createNamedQuery("CompEvaluaciones.findActivos");
		Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fechaHoy=formateador.format(fechaActual);
		query.setParameter("fechaHoy", fechaHoy).setParameter("catcomp", catCompetencial);
		@SuppressWarnings("unchecked")
		List<CompEvaluaciones> activas = query.getResultList();
		return activas;
	}
	
	@Override
	public List<CompEvaluaciones> findActivoEvaluadores(String catCompetencial) {
		Query query = em.createNamedQuery("CompEvaluaciones.findActivoEvaluadores");
		Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fechaHoy=formateador.format(fechaActual);
		query.setParameter("fechaHoy", fechaHoy).setParameter("catcomp", catCompetencial);
		@SuppressWarnings("unchecked")
		List<CompEvaluaciones> activas = query.getResultList();
		return activas;
	}
	
	@Override
	public Integer insert(String nombre, String iniaportacion, String finaportacion, String inivalidacion, String finvalidacion, 
			String iniperiodo, String finperiodo, String inievaluacion, String finevaluacion, String catcompetencial) {
		// TODO Auto-generated method stu
		//COMPROBAR QUE NO HYA NINGUNA ACTIVA PARA ESA CATCOMP
		
		Query query = em.createNamedQuery("CompEvaluaciones.findActivos");
		Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fechaHoy=formateador.format(fechaActual);
		query.setParameter("fechaHoy", fechaHoy).setParameter("catcomp", catcompetencial);
		@SuppressWarnings("unchecked")
		List<CompEvaluaciones> activas = query.getResultList();
		if (activas.size()==0) {
		
			CompEvaluaciones nueva=new CompEvaluaciones();
			nueva.setNombre(nombre);
			nueva.setIniaportacion(iniaportacion);
			nueva.setFinaportacion(finaportacion);
			nueva.setInivalidacion(inivalidacion);
			nueva.setFinvalidacion(finvalidacion);
			nueva.setIniperiodo(iniperiodo);
			nueva.setFinperiodo(finperiodo);
			nueva.setInievaluacion(inievaluacion);
			nueva.setFinevaluacion(finevaluacion);
			nueva.setCatcompetencial(catcompetencial);
		
			
			em.persist(nueva);
			
			em.flush();
			return nueva.getId();
		}
		else { 
			return -1;
		}
	}
	
	@Override
	public void guardar(Integer id, String nombre, String iniaportacion, String finaportacion, String inivalidacion, String finvalidacion, 
			String iniperiodo, String finperiodo, String inievaluacion, String finevaluacion, String catcompetencial, 
			String comp1, String comp2, String comp3, String comp4, String comp5, String comp6, String comp7, String comp8, String comp9, String comp10) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompEvaluaciones.findById");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		CompEvaluaciones e=(CompEvaluaciones)query.getSingleResult();
			
			e.setNombre(nombre);
			e.setIniaportacion(iniaportacion);
			e.setFinaportacion(finaportacion);
			e.setInivalidacion(inivalidacion);
			e.setFinvalidacion(finvalidacion);
			e.setIniperiodo(iniperiodo);
			e.setFinperiodo(finperiodo);
			e.setInievaluacion(inievaluacion);
			e.setFinevaluacion(finevaluacion);
			e.setCatcompetencial(catcompetencial);
//			nueva.setTrabajador(trabajador);
			e.setComp1(comp1);
			e.setComp2(comp2);
			e.setComp3(comp3);
			e.setComp4(comp4);
			e.setComp5(comp5);
			e.setComp6(comp6);
			e.setComp7(comp7);
			e.setComp8(comp8);
			e.setComp9(comp9);
			e.setComp10(comp10);
			
			em.merge(e);
			em.flush();
	}
	
	@Override
	public void insertValoracion(Integer idevaluacion, String dnievaluador, String dnievaluado, Integer idrelacion, Integer valoracion ) {
		//DEBERIA COMPROBAR SI YA EXISTE ESA VALORACIÓN, Y ENTONCES HACER MERGE EN VEZ DE INSERTAR NUEVA
		
		Query query = em.createNamedQuery("CompValoraciones.findValoracion");
		
		query.setParameter("idevaluacion", idevaluacion).setParameter("dnievaluador", dnievaluador).setParameter("dnievaluado", dnievaluado).setParameter("idrelacion", idrelacion);
		@SuppressWarnings("unchecked")
		List<CompValoraciones> encontrada = query.getResultList();
		if(encontrada.size()==0) {

			CompValoraciones nueva=new CompValoraciones();
			nueva.setIdevaluacion(idevaluacion);
			nueva.setDnievaluador(dnievaluador);
			nueva.setDnievaluado(dnievaluado);
			nueva.setIdrelacion(idrelacion);
			nueva.setValoracion(valoracion);
			
			em.persist(nueva);
			
			em.flush();
		}
		else {
			encontrada.get(0).setValoracion(valoracion);
			
			em.merge(encontrada.get(0));
			
			em.flush();
		}
		
	}
	
	@Override
	public List<CompValoraciones> valoracionesPorIdEvaluacion (Integer idEvaluacion) {
		Query query = em.createNamedQuery("CompValoraciones.findByIdEvaluacion");
		
		query.setParameter("idevaluacion", idEvaluacion);
		@SuppressWarnings("unchecked")
		List<CompValoraciones> encontrada = query.getResultList();
		return encontrada;
		
	}
}
