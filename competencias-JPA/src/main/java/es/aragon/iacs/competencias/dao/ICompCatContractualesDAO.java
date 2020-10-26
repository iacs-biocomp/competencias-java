package es.aragon.iacs.competencias.dao;

import java.util.List;

import es.aragon.iacs.competencias.jpa.CompCatContractualesV;

public interface ICompCatContractualesDAO {

	List<CompCatContractualesV> findAll();

	void editId(int id, String catComp);
	CompCatContractualesV findByCatcontractual(String catContractual);

}