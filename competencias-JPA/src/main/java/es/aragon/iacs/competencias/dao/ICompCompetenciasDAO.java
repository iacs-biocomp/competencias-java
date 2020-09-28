package es.aragon.iacs.competencias.dao;

import java.util.List;

import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompObjetivosCompCatcomp;
import es.aragon.iacs.competencias.jpa.CompRelCompCompleto;

public interface ICompCompetenciasDAO {

	List<CompCompetencias> findAll();

	void delete(String codigo);

	void insert(String codigo, String descripcion, String alta, String baja);

	void edit(String codigo, String descripcion, String alta, String baja);

	List<CompObjetivosCompCatcomp> compPorCatComp(String codCatCompetencial);

	List<CompRelCompCompleto> relacionesPorCatComp(String codCatCompetencial);

	void deleteRelacion(Integer idRelacion);


}