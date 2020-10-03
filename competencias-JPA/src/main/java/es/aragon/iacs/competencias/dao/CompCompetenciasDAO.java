package es.aragon.iacs.competencias.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;

import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompObjetivos;
import es.aragon.iacs.competencias.jpa.CompObjetivosCompCatcomp;
import es.aragon.iacs.competencias.jpa.CompRelCompCompleto;
import es.aragon.iacs.competencias.jpa.CompRelacionesComportamientos;

@Stateless
public class CompCompetenciasDAO implements ICompCompetenciasDAO {
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	
	
	@Override
	public List<CompCompetencias> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCompetencias.findAll");
		@SuppressWarnings("unchecked")
		List<CompCompetencias> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public List<CompObjetivosCompCatcomp> compPorCatComp(String codCatCompetencial) {
		// TODO Auto-generated method stu
		
		String query="Select obj.id id, "
					+ "		 obj.codcompetencia, "
					+ "      comp.descripcion,"
					+ "		 n.nombre as objetivo,"
					+ "      catcomp.codigo codcatcomp, "
					+ "      catcomp.nombre as nombrecatcomp "
					+ "from comp_objetivos obj, "
					+ "     comp_competencias comp, "
					+ "     comp_niveles n, "
					+ "     comp_cat_competenciales catcomp "
					+ "where comp.codigo=obj.codcompetencia "
					+ "  and obj.idnivel=n.id "
					+ "  and obj.codcatcomp='"+codCatCompetencial+"' "
					+ "  and catcomp.codigo='"+ codCatCompetencial+ "';";
		@SuppressWarnings("unchecked")
		List<CompObjetivosCompCatcomp> resultado=em.createNativeQuery(query,CompObjetivosCompCatcomp.class).getResultList();
		return resultado;
	}
	
	@Override
	public List<CompRelCompCompleto> relacionesPorCatComp(String codCatCompetencial) {
		// TODO Auto-generated method stu

		String query= "Select rel.id idRel, rel.codcatcomp, rel.idnivel,rel.codcomp codcomp, rel.idcomportamiento, comp.descripcion from comp_relaciones_comportamientos rel, comp_comportamientos comp where comp.id=rel.idcomportamiento and rel.codcatcomp='"+codCatCompetencial+"';";

		@SuppressWarnings("unchecked")

		List<CompRelCompCompleto> resultado=em.createNativeQuery(query,CompRelCompCompleto.class).getResultList();

		return resultado;
	}
	
	@Override
	public void delete(String codigo) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCompetencias.findById");
		query.setParameter("codigo", codigo);
		@SuppressWarnings("unchecked")
		CompCompetencias cat=(CompCompetencias)query.getSingleResult();
		//if cat is not null comprobar
		em.remove(cat);
		em.flush();
	}
	
	@Override
	public void insert(String codigo, String descripcion, String alta, String baja) {
		// TODO Auto-generated method stu
		CompCompetencias nueva=new CompCompetencias();
		nueva.setCodigo(codigo);
		nueva.setDescripcion(descripcion);
		nueva.setAlta(alta);
		nueva.setBaja(baja);
		em.persist(nueva);
		em.flush();
	}
	
	@Override
	public void edit(String codigo, String descripcion, String alta, String baja) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCompetencias.findById");
		query.setParameter("codigo", codigo);
		@SuppressWarnings("unchecked")
		CompCompetencias comp=(CompCompetencias)query.getSingleResult();
		comp.setDescripcion(descripcion);
		comp.setAlta(alta);
		comp.setBaja(baja);
		//if cat is not null comprobar
		em.merge(comp);
		em.flush();
	}
	
	@Override
	public void deleteRelacion(Integer idRelacion) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompObjetivos.findById");
		query.setParameter("id", idRelacion);
		@SuppressWarnings("unchecked")
		CompObjetivos o=(CompObjetivos)query.getSingleResult();
		//if cat is not null comprobar
		em.remove(o);
		em.flush();
	}
	
	@Override
	public void insertRelacion(String codCompetencia, String codCatComp, Integer idNivel) {
		CompObjetivos o=new CompObjetivos();
		o.setCodcompetencia(codCompetencia);
		o.setCodcatcomp(codCatComp);
		o.setIdnivel(idNivel);
		//if cat is not null comprobar
		em.persist(o);
		em.flush();
	}
	
	@Override
	public void insertRelacionComportamientos(String codCompetencia, String codCatComp, Integer idNivel, Integer idComportamiento) {
		CompRelacionesComportamientos r=new CompRelacionesComportamientos();
		r.setCodcomp(codCompetencia);
		r.setCodcatcomp(codCatComp);
		r.setIdnivel(idNivel);
		r.setIdcomportamiento(idComportamiento);
		//if cat is not null comprobar
		em.persist(r);
		em.flush();
	}
	
	@Override
	public void deleteRelacionComportamientos(String catCompetencial, String codCompetencia)  {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompRelacionesComportamientos.findByCatCompCompetencia");
		query.setParameter("codcompetencia", codCompetencia).setParameter("codcatcomp", catCompetencial);
//		@SuppressWarnings("unchecked")
//		
		//Lista de relaciones devueltas por la query hacer remove
		List<CompRelacionesComportamientos> resultado=query.getResultList();
		//COMPROBAR QE NO ES NUL Y HACER BUCLE ELIMINANDO TODOS LOS ELEMENTOS
		
		for (int i = 0; i < resultado.size(); ++i) {
		    em.remove(resultado.get(i));
		}
		em.flush();
	}
	
	@Override
	public void deleteRelacionComportamientos(Integer idRelacion)  {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompRelacionesComportamientos.findById");
		query.setParameter("id", idRelacion);

		CompRelacionesComportamientos resultado=(CompRelacionesComportamientos)query.getSingleResult();
		
		em.remove(resultado);
		em.flush();
	}
}