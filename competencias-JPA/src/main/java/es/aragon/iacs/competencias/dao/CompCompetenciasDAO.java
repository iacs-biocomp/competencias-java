package es.aragon.iacs.competencias.dao;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import javax.ejb.EJB;

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
import es.aragon.iacs.competencias.jpa.CompValoraciones;
import es.aragon.iacs.competencias.jpa.CompEvaluaciones;

@Stateless
public class CompCompetenciasDAO implements ICompCompetenciasDAO {
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	
	
	@EJB(name="CompEvaluacionesDAO")
    private ICompEvaluacionesDAO evaluacionesDao;
	
	@Override
	public List<CompCompetencias> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCompetencias.findAll");
		@SuppressWarnings("unchecked")
		List<CompCompetencias> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public List<CompCompetencias> findActivas() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCompetencias.findActivas");
		
		Date fechaActual = new Date();
		try {
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			String fechaSistema=formateador.format(fechaActual);
	        Date fechaHoy = formateador.parse(fechaSistema);
			query.setParameter("fechaHoy", fechaHoy);
			@SuppressWarnings("unchecked")
			List<CompCompetencias> activas = query.getResultList();
			return activas;
		}catch(ParseException e) {
			return null;
		}

	}
	
	@Override
	public List<CompCompetencias> findByCodigo(String codigo) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCompetencias.findById");
		query.setParameter("codigo", codigo);
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
	public List<CompObjetivosCompCatcomp> allObjCompCatcomp() {
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
					+ "  and obj.idnivel=n.id and obj.codcatcomp=catcomp.codigo;";
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
		List<CompValoraciones> resultado=evaluacionesDao.valoracionesPorCodcomp(codigo);
		if(resultado.size()==0) {
			Query query = em.createNamedQuery("CompCompetencias.findById");
			query.setParameter("codigo", codigo);
			@SuppressWarnings("unchecked")
			CompCompetencias cat=(CompCompetencias)query.getSingleResult();
			//if cat is not null comprobar
			em.remove(cat);
			em.flush();
		}
	}
	
	@Override
	public void insert(String codigo, String descripcion, Date alta, Date baja) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCompetencias.findById");
		query.setParameter("codigo", codigo);
		@SuppressWarnings("unchecked")
		List<CompCompetencias> busqueda = query.getResultList();
		
		if(busqueda.size()==0) {
			CompCompetencias nueva=new CompCompetencias();
			nueva.setCodigo(codigo);
			nueva.setDescripcion(descripcion);
			nueva.setAlta(alta);
			nueva.setBaja(baja);
			em.persist(nueva);
			em.flush();
		}
	}
	
	@Override
	public void edit(String codigo, String descripcion, Date alta, Date baja) {
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
	public boolean deleteRelacion(Integer idRelacion) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompObjetivos.findById");
		query.setParameter("id", idRelacion);
		@SuppressWarnings("unchecked")
		CompObjetivos o=(CompObjetivos)query.getSingleResult();
		//Buscar si hay valoraciones hechas para esos elementos
		String codcompetencia=o.getCodcompetencia();
		String codcatcomp=o.getCodcatcomp();
	
		//Buscar evaluacion con ese codigo de catcomp
		List<CompEvaluaciones> resultado=evaluacionesDao.evaluacionesPorCatcompetencial(codcatcomp);
		if(resultado.size()!=0) {
			Integer idEvaluacion=resultado.get(0).getId();
			//Buscar valoraciones de esa evaluacion
			List<CompValoraciones> resultado2=evaluacionesDao.valoracionesPorRelacion(idEvaluacion,codcompetencia);
			if(resultado2.size()==0) {
				//if cat is not null comprobar
				em.remove(o);
				em.flush();
				return true;
			}else {
				return false;
			}
		}else {
			em.remove(o);
			em.flush();
			return true;
		}
	}
	
	@Override
	public void editRelacion(Integer idRelacion, Integer objetivo)  {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompObjetivos.findById");
		query.setParameter("id", idRelacion);
		@SuppressWarnings("unchecked")
//		
		//Lista de relaciones devueltas por la query hacer remove
		List<CompObjetivos> resultado=query.getResultList();
		
		String codcompetencia=resultado.get(0).getCodcompetencia();
		String codcatcomp=resultado.get(0).getCodcatcomp();
	
		//Buscar evaluacion con ese codigo de catcomp
		List<CompEvaluaciones> resultado3=evaluacionesDao.evaluacionesPorCatcompetencial(codcatcomp);
		if(resultado3.size()!=0) {
			Integer idEvaluacion=resultado3.get(0).getId();
			//Buscar valoraciones de esa evaluacion
			List<CompValoraciones> resultado2=evaluacionesDao.valoracionesPorRelacion(idEvaluacion,codcompetencia);
			if(resultado2.size()==0) {
				//if cat is not null comprobar
				CompObjetivos o=resultado.get(0);
				
				o.setIdnivel(objetivo);
				em.merge(o);
				em.flush();
			}
		}
		
	}
	
	@Override
	public void insertRelacion(String codCompetencia, String codCatComp, Integer idNivel) {
		Query query = em.createNamedQuery("CompObjetivos.findRelacion");
		query.setParameter("codcatcomp", codCatComp).setParameter("codcompetencia",codCompetencia);
		@SuppressWarnings("unchecked")
		List<CompObjetivos> busqueda = query.getResultList();
		
		if(busqueda.size()==0) {
		
			CompObjetivos o=new CompObjetivos();
			o.setCodcompetencia(codCompetencia);
			o.setCodcatcomp(codCatComp);
			o.setIdnivel(idNivel);
			//if cat is not null comprobar
			em.persist(o);
			em.flush();
		}
	}
	
	@Override
	public void insertRelacionComportamientos(String codCompetencia, String codCatComp, Integer idNivel, Integer idComportamiento) {
		Query query = em.createNamedQuery("CompRelacionesComportamientos.findRelacion");
		query.setParameter("codcatcomp", codCatComp).setParameter("codcomp",codCompetencia).setParameter("idcomportamiento",idComportamiento);
		@SuppressWarnings("unchecked")
		List<CompRelacionesComportamientos> busqueda = query.getResultList();
		
		if(busqueda.size()==0) {
		
			CompRelacionesComportamientos r=new CompRelacionesComportamientos();
			r.setCodcomp(codCompetencia);
			r.setCodcatcomp(codCatComp);
			r.setIdnivel(idNivel);
			r.setIdcomportamiento(idComportamiento);
			//if cat is not null comprobar
			em.persist(r);
			em.flush();
		}
	}
	
	@Override
	public void deleteRelacionComportamientos(String catCompetencial, String codCompetencia)  {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompRelacionesComportamientos.findByCatCompCompetencia");
		query.setParameter("codcompetencia", codCompetencia).setParameter("codcatcomp", catCompetencial);

		List<CompRelacionesComportamientos> resultado=query.getResultList();

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
		String codcatcomp=resultado.getCodcatcomp();
		Integer idnivel=resultado.getIdnivel();
		String codcomp=resultado.getCodcomp();
		Integer idcomportamiento=resultado.getIdcomportamiento();
		
		//Buscar si hay valoracion con estas caracteristicas o evaluacion que evalue esta comp para esta catcomp
		List<CompEvaluaciones> result=evaluacionesDao.evaluacionesPorCatcompetencial(codcatcomp);
		
		if(result.size()!=0) {
			Integer idEvaluacion=result.get(0).getId();
			//Buscar valoraciones de esa evaluacion
			List<CompValoraciones> resultado2=evaluacionesDao.valoracionesPorRelacionComportamientos(idEvaluacion,codcomp,idnivel,idcomportamiento);
			if(resultado2.size()==0) {
				//if cat is not null comprobar
				em.remove(resultado);
				em.flush();
			}
		}else {
			em.remove(resultado);
			em.flush();
		}
		
		
		
	}
}