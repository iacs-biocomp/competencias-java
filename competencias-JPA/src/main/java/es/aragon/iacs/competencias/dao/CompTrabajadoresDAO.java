package es.aragon.iacs.competencias.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompExternos;
import es.aragon.iacs.competencias.jpa.CompNiveles;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;

@Stateless
public class CompTrabajadoresDAO implements ICompTrabajadoresDAO {
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	

	
	@Override
	public List<CompTrabajadores> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompTrabajadores.findAll");
		@SuppressWarnings("unchecked")
		List<CompTrabajadores> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public CompTrabajadores trabajador(String dni) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompTrabajadores.findById");
		query.setParameter("dni", dni);
		@SuppressWarnings("unchecked")
		CompTrabajadores trabajador=(CompTrabajadores)query.getSingleResult();
		return trabajador;
	}
	
	@Override
	public void editInterno(Integer codigo, String nombre,String apellidos,String catContractual, String catCompetencial,String area,String unidad, String departamento, String antiguedad,String dni) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompTrabajadores.findByDni");
		query.setParameter("dni", dni);
		@SuppressWarnings("unchecked")
		CompTrabajadores t=(CompTrabajadores)query.getSingleResult();
		t.setNombre(nombre);
		t.setApellidos(apellidos);
		t.setCatcontractual(catContractual);
		t.setCatcompetencial(catCompetencial);
		t.setArea(area);
		t.setUnidad(unidad);;
		t.setDepartamento(departamento);
		t.setAntiguedad(antiguedad);
		//if cat is not null comprobar
		em.merge(t);
		em.flush();
	}
	
	@Override
	public void editExterno(Integer id, String nombre, String apellidos,String email,String instituciones,Boolean posibleSuperior, String dni) {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompExternos.findByDni");
		query.setParameter("dni", dni);
		@SuppressWarnings("unchecked")
		CompExternos e=(CompExternos)query.getSingleResult();
		e.setNombre(nombre);
		e.setApellidos(apellidos);
		e.setEmail(email);
		e.setInstituciones(instituciones);
		if(posibleSuperior!=null && posibleSuperior) {
			e.setPosiblesuperior(posibleSuperior);
		}
		else {
			e.setPosiblesuperior(false);
		}
		//if cat is not null comprobar
		em.merge(e);
		em.flush();
	}
}		



