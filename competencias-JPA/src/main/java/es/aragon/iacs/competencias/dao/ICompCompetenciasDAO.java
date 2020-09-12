package es.aragon.iacs.competencias.dao;

import java.util.List;

import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompObjetivosCompCatcomp;

public interface ICompCompetenciasDAO {

	List<CompCompetencias> findAll();

	void delete(String codigo);

	void insert(String codigo, String descripcion, String alta, String baja);

	List<CompObjetivosCompCatcomp> porCatCompetencial(String codCatCompetencial);

	void edit(String codigo, String descripcion, String alta, String baja);


//	List<CompCompetencias> competenciasCatCompetencial(String catCompetencial);

}