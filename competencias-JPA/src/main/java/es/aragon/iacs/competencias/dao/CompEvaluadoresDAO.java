package es.aragon.iacs.competencias.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompEvaluadorInterno;
import es.aragon.iacs.competencias.jpa.CompEvaluadorExterno;

@Stateless
public class CompEvaluadoresDAO implements ICompEvaluadoresDAO{
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	
	
	@Override
	public List<CompEvaluadorExterno> findAllExternos(String dni){
		Query query = em.createNamedQuery("CompEvaluadorExterno.findByDniTrabajador");
		query.setParameter("dnitrabajador", dni);
		@SuppressWarnings("unchecked")
		List<CompEvaluadorExterno> resultado=query.getResultList();
		return resultado;
		
	}
	
	@Override
	public List<CompEvaluadorInterno> findAllInternos(String dni){
		Query query = em.createNamedQuery("CompEvaluadorInterno.findByDniTrabajador");
		query.setParameter("dnitrabajador", dni);
		@SuppressWarnings("unchecked")
		List<CompEvaluadorInterno> resultado=query.getResultList();
		return resultado;
		
	}
	
	
	@Override
	public void insertInterno(Integer idEvaluacion,String dniTrabajador,String dniEvaluador,Integer grupo,String comp0,String comp1,String comp2,String comp3,String comp4,String comp5,String comp6,String comp7,String comp8,String comp9,String justificacion) {
		CompEvaluadorInterno nuevo=new CompEvaluadorInterno();
		nuevo.setIdevaluacion(idEvaluacion);
		nuevo.setDnitrabajador(dniTrabajador);
		nuevo.setDnievaluador(dniEvaluador);
		nuevo.setGrupo(grupo);
		nuevo.setJustificacion(justificacion);
		
		nuevo.setComp1(comp0);
		nuevo.setComp2(comp1);
		nuevo.setComp3(comp2);
		nuevo.setComp4(comp3);
		nuevo.setComp5(comp4);
		nuevo.setComp6(comp5);
		nuevo.setComp7(comp6);
		nuevo.setComp8(comp7);
		nuevo.setComp9(comp8);
		nuevo.setComp10(comp9);
		nuevo.setValidado(false);
		em.persist(nuevo);
		em.flush();
		
	}
	
	@Override
	public void insertExterno(Integer idEvaluacion,String dniTrabajador,Integer idEvaluador,Integer grupo,String comp0,String comp1,String comp2,String comp3,String comp4,String comp5,String comp6,String comp7,String comp8,String comp9,String justificacion) {
		CompEvaluadorExterno nuevo=new CompEvaluadorExterno();
		nuevo.setIdevaluacion(idEvaluacion);
		nuevo.setDnitrabajador(dniTrabajador);
		nuevo.setIdevaluador(idEvaluador);
		nuevo.setGrupo(grupo);
		nuevo.setJustificacion(justificacion);
		
		nuevo.setComp1(comp0);
		nuevo.setComp2(comp1);
		nuevo.setComp3(comp2);
		nuevo.setComp4(comp3);
		nuevo.setComp5(comp4);
		nuevo.setComp6(comp5);
		nuevo.setComp7(comp6);
		nuevo.setComp8(comp7);
		nuevo.setComp9(comp8);
		nuevo.setComp10(comp9);
		nuevo.setValidado(false);
		em.persist(nuevo);
		em.flush();
		
	}
	
	
	
}


	