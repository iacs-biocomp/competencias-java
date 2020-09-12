package es.aragon.iacs.competencias.dao;

import java.util.Date;
import java.util.List;

import es.aragon.iacs.competencias.jpa.CompComportamientos;

public interface ICompComportamientosDAO {

	List<CompComportamientos> findAll();

	void delete(Integer id);

	void insert(String descripcion, String alta, String baja);

	void edit(Integer codigo, String descripcion, String alta, String baja);

}