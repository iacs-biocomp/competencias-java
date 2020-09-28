package es.aragon.iacs.competencias.dao;

import java.util.List;

import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;

public interface ICompCatCompetencialesDAO {

	List<CompCatCompetenciales> findAll();

	void delete(String codigo);

	void insert(String codigo, String nombre, String alta, String baja);

	void edit(String codigo, String nombre, String alta, String baja);

	CompCatCompetenciales findById(String codigo);

}