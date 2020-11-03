package es.aragon.iacs.competencias.dao;

import java.util.List;
import java.util.Date;
import es.aragon.iacs.competencias.jpa.CompNiveles;

public interface ICompNivelesDAO {

	List<CompNiveles> findAll();

	void delete(Integer id);

	void insert(String nombre, float valorporcentual, Date alta, Date baja);

	void edit(Integer id, String nombre, float valorporcentual, Date alta, Date baja);
	
	List<CompNiveles> findActivos();

}