package es.aragon.iacs.competencias.dao;

import java.util.List;
import java.util.Date;
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

	void insertOrganigrama(String nombre, Date fechaIni, Date fechaFin);

	void deleteOrganigrama(Integer idOrganigrama);

	void editOrganigrama(Integer idOrganigrama, String nombre, Date fechaIni, Date fechaFin);
	
	CompOrganigramas findActivo();
	
	List<CompPares> findParesTrabajador(String dniTrabajador);
	List<CompSuperiores> findSuperioresTrabajador(String dniTrabajador);
	
	List<CompSuperiores> findSuperioresByTrabajador(String dniTrabajador);
	List<CompSuperiores> findSuperioresBySuperior(String dniSuperior);
	
}
