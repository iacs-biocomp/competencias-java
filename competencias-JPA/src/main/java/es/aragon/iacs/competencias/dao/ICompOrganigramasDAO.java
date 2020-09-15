package es.aragon.iacs.competencias.dao;

import java.util.List;

import es.aragon.iacs.competencias.jpa.CompOrganigramas;
import es.aragon.iacs.competencias.jpa.CompPares;
import es.aragon.iacs.competencias.jpa.CompSuperiores;

public interface ICompOrganigramasDAO {

	List<CompOrganigramas> findAll();

	List<CompPares> findPares(Integer id);

	List<CompSuperiores> findSuperiores(Integer id);
	
	
}
