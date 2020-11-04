package es.aragon.iacs.competencias.dao;

import javax.ejb.EJB;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompEvaluaciones;
import es.aragon.iacs.competencias.jpa.CompValoraciones;
//import src.main.java.es.aragon.iacs.competencias.action.EJB;
//import src.main.java.es.aragon.iacs.competencias.action.ICompEvaluacionesDAO;

@Stateless
public class CompCatCompetencialesDAO implements ICompCatCompetencialesDAO {
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	
	
	@EJB(name="CompEvaluacionesDAO")
    private ICompEvaluacionesDAO evaluacionesDao;

	@Override
	public List<CompCatCompetenciales> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCatCompetenciales.findAll");
		@SuppressWarnings("unchecked")
		List<CompCatCompetenciales> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public List<CompCatCompetenciales> findActivas() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCatCompetenciales.findActivas");
		
		Date fechaActual = new Date();
		try {
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			String fechaSistema=formateador.format(fechaActual);
	        Date fechaHoy = formateador.parse(fechaSistema);
			query.setParameter("fechaHoy", fechaHoy);
			@SuppressWarnings("unchecked")
			List<CompCatCompetenciales> activas = query.getResultList();
			return activas;
		}catch(ParseException e) {
			return null;
		}

	}
	
	@Override
	public CompCatCompetenciales findById(String codigo) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCatCompetenciales.findById");
		query.setParameter("codigo", codigo);
		@SuppressWarnings("unchecked")
		CompCatCompetenciales project = (CompCatCompetenciales)query.getSingleResult();
		return project;
	}
	
	@Override
	public void delete(String codigo) {
		Boolean eliminar=false;
		//Buscar evaluacion con ese codigo de catcomp
		List<CompEvaluaciones> resultado=evaluacionesDao.evaluacionesPorCatcompetencial(codigo);
		if(resultado.size()!=0) {

			eliminar=false;
		}
		else {
			//Buscar valoraciones de esa evaluacion
			List<CompValoraciones> resultado2=evaluacionesDao.valoracionesPorIdEvaluacion(resultado.get(0).getId());
			if(resultado2.size()!=0) {
				eliminar=false;
				
			}else {
				eliminar=true;
			}
//			eliminar=true;
		}
		
		
		if(eliminar) {
			//Si no hay, se puede eliminar
			Query query = em.createNamedQuery("CompCatCompetenciales.findById");
			query.setParameter("codigo", codigo);
			@SuppressWarnings("unchecked")
			CompCatCompetenciales cat=(CompCatCompetenciales)query.getSingleResult();
			//if cat is not null comprobar
			em.remove(cat);
			em.flush();
		}
		
		
	}
	@Override
	public void insert(String codigo, String nombre, Date alta, Date baja) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompCatCompetenciales.findById");
		query.setParameter("codigo", codigo);
		@SuppressWarnings("unchecked")
		List<CompCatCompetenciales> busqueda = query.getResultList();
		
		if(busqueda.size()==0) {
			CompCatCompetenciales nueva=new CompCatCompetenciales();
			nueva.setCodigo(codigo);
			nueva.setNombre(nombre);
			nueva.setAlta(alta);
			nueva.setBaja(baja);
			
			em.persist(nueva);
			em.flush();
		}
	}
	
	@Override
	public void edit(String codigo, String nombre, Date alta, Date baja) {
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