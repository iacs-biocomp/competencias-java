package es.aragon.iacs.competencias.dao;

import java.util.List;
import java.util.Date;

import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;

public interface ICompCatCompetencialesDAO {

	List<CompCatCompetenciales> findAll();
	List<CompCatCompetenciales> findActivas();

	void delete(String codigo);

	void insert(String codigo, String nombre, Date alta, Date baja);

	void edit(String codigo, String nombre, Date alta, Date baja);

	CompCatCompetenciales findById(String codigo);

}