package es.aragon.iacs.competencias.dao;

import java.util.List;

import es.aragon.iacs.competencias.jpa.CompPrueba;

public interface ICompPruebaDAO {

	/**
	 * 
	 */
	List<CompPrueba> findAll();

}