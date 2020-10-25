package es.aragon.iacs.competencias.dao;

import java.util.List;

import es.aragon.iacs.competencias.jpa.CompTrabajadores;

public interface ICompTrabajadoresDAO {

	List<CompTrabajadores> findAll();
	List<CompTrabajadores> findByCatcomp(String codCatcomp);

	CompTrabajadores trabajador(String dni);

	void editInterno(Integer codigo, String nombre, String apellidos, String catContractual, String catCompetencial,
			String area, String unidad, String departamento, String antiguedad, String dni);

	void editExterno(Integer id, String nombre, String apellidos, String email, String instituciones,
			Boolean posibleSuperior, String dni);

}