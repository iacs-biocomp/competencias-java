package es.aragon.iacs.competencias.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompEvaluaciones;

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
	public Integer insert(String nombre, String iniaportacion, String finaportacion, String inivalidacion, String finvalidacion, 
			String iniperiodo, String finperiodo, String inievaluacion, String finevaluacion, String catcompetencial) {
		// TODO Auto-generated method stu
		
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
//			nueva.setTrabajador(trabajador);
//			nueva.setComp1(comp1);
//			nueva.setComp1(comp2);
//			nueva.setComp1(comp3);
//			nueva.setComp1(comp4);
//			nueva.setComp1(comp5);
//			nueva.setComp1(comp6);
//			nueva.setComp1(comp7);
//			nueva.setComp1(comp8);
//			nueva.setComp1(comp9);
//			nueva.setComp1(comp10);
			
			em.persist(nueva);
			
			em.flush();
			return nueva.getId();
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
}
