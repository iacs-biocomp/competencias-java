package es.aragon.iacs.competencias.dao;

import java.util.List;

import es.aragon.iacs.competencias.jpa.CompNiveles;

public interface ICompNivelesDAO {

	List<CompNiveles> findAll();

	void delete(Integer id);

	void insert(String nombre, float valorporcentual, String alta, String baja);

	void edit(Integer id, String nombre, float valorporcentual, String alta, String baja);

}