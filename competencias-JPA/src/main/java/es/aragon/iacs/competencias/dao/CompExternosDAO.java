package es.aragon.iacs.competencias.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompExternos;

@Stateless
public class CompExternosDAO implements ICompExternosDAO {
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;	

	
	@Override
	public List<CompExternos> findAll() {
		// TODO Auto-generated method stu
		Query query = em.createNamedQuery("CompExternos.findAll");
		@SuppressWarnings("unchecked")
		List<CompExternos> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public void insert(String nombre, String apellidos,String email, String institucion) {
		
		Query query = em.createNamedQuery("CompExternos.findByEmail");
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<CompExternos> busqueda = query.getResultList();
		
		if(busqueda.size()==0) {
		
			CompExternos nuevo=new CompExternos();
			nuevo.setDni("");
			nuevo.setNombre(nombre);
			nuevo.setApellidos(apellidos);
			nuevo.setEmail(email);
			nuevo.setInstituciones(institucion);
			nuevo.setPosiblesuperior(false);
			
			em.persist(nuevo);
			em.flush();
		}
	}
}