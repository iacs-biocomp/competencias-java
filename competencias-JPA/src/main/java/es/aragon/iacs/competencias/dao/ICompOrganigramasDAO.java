package es.aragon.iacs.competencias.dao;

import java.util.List;

import es.aragon.iacs.competencias.jpa.CompOrganigramas;
import es.aragon.iacs.competencias.jpa.CompPares;
import es.aragon.iacs.competencias.jpa.CompSuperiores;

public interface ICompOrganigramasDAO {

	List<CompOrganigramas> findAll();

	List<CompPares> findPares(Integer id);

	List<CompSuperiores> findSuperiores(Integer id);

	void insertSuperior(Integer id, String dniTrabajador, String dniSuperior);

	void insertPar(Integer id, String dniTrabajador, String dniPar);

	void deleteSuperior(Integer id);

	void deletePar(Integer id);

	Integer getIdOrganigramaPar(Integer idRelacion);

	Integer getIdOrganigramaSuperior(Integer idRelacion);

	CompOrganigramas findByIdOrganigrama(Integer idOrganigrama);

	void insertOrganigrama(String nombre, String fechaIni, String fechaFin);

	void deleteOrganigrama(Integer idOrganigrama);

	void editOrganigrama(Integer idOrganigrama, String nombre, String fechaIni, String fechaFin);
	
	CompOrganigramas findActivo();
	
}
