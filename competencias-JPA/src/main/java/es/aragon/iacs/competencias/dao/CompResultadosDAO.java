package es.aragon.iacs.competencias.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.aragon.iacs.competencias.jpa.CompValoraciones;
import es.aragon.iacs.competencias.jpa.CompResultados;

@Stateless
public class CompResultadosDAO implements ICompResultadosDAO{
	@PersistenceContext(unitName = "competenciasPU")
	private EntityManager em;

	//GRUPO EV 1: AUTOEVALUACION ; 2: JEFES ; 3: INFERIORES ; 4: PARES (+ELEGIDOS 1) ; 5: ELEGIDOS 2
	
	@Override
	public void sumarValoracion(Integer idEvaluacion, String dni, Integer grupoev,String codcomp, Integer idnivel, Integer valoracion) {
		//BUSCO EN LA BD LA VALORACION CON ESTAS CARACTERISTICAS
		Query query = em.createNamedQuery("CompResultados.findResultado");
		query.setParameter("dni", dni).setParameter("grupoev", grupoev).setParameter("codcomp", codcomp).setParameter("idnivel", idnivel).setParameter("idevaluacion", idEvaluacion);
		@SuppressWarnings("unchecked")
		List<CompResultados> resultado=query.getResultList();
		//SI EXISTE SUMO VALORACION Y SUMO 1 A NUMVALORACIONES
		if(resultado.size()==1) {
			float sumaAlmacenada=resultado.get(0).getSuma();
			sumaAlmacenada=sumaAlmacenada+valoracion;
			resultado.get(0).setSuma(sumaAlmacenada);
			Integer numvaloraciones=resultado.get(0).getNumvaloraciones();
			numvaloraciones=numvaloraciones+1;
			resultado.get(0).setNumvaloraciones(numvaloraciones);
			em.merge(resultado.get(0));
			em.flush();
		}
		//SI NO EXISTE LA CREO
		else {
			CompResultados nuevo=new CompResultados();
			nuevo.setDnievaluado(dni);
			nuevo.setGrupoev(grupoev);
			nuevo.setCodcomp(codcomp);
			nuevo.setIdnivel(idnivel);
			nuevo.setSuma(valoracion);
			nuevo.setNumvaloraciones(1);
			nuevo.setIdevaluacion(idEvaluacion);
			em.persist(nuevo);
			em.flush();
		}
	}
	
	@Override
	public List<CompResultados> evaluacionCalculada(Integer idEvaluacion) {
		Query query = em.createNamedQuery("CompResultados.findByEvaluacion");
		query.setParameter("idevaluacion", idEvaluacion);
		@SuppressWarnings("unchecked")
		List<CompResultados> resultado=query.getResultList();
		//SI EXISTE SUMO VALORACION Y SUMO 1 A NUMVALORACIONES
		if(resultado.size()!=0) {
			return resultado;
		}
		else {
			return null;
		}
	}
	
}
