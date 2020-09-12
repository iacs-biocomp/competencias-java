package es.aragon.iacs.competencias.dao;

import java.util.List;

import es.aragon.iacs.competencias.jpa.CompExternos;

public interface ICompExternosDAO {

	List<CompExternos> findAll();

}