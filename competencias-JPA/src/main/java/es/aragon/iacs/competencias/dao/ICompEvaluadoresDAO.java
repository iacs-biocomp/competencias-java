package es.aragon.iacs.competencias.dao;
import java.util.List;

import es.aragon.iacs.competencias.jpa.CompEvaluadorExterno;
import es.aragon.iacs.competencias.jpa.CompEvaluadorInterno;

public interface ICompEvaluadoresDAO {

	void insertInterno(Integer idEvaluacion,String dniTrabajador,String dniEvaluador,Integer grupo,String comp0,String comp1,String comp2,String comp3,String comp4,String comp5,String comp6,String comp7,String comp8,String comp9,String justificacion);
	void insertExterno(Integer idEvaluacion,String dniTrabajador,Integer idEvaluador,Integer grupo,String comp0,String comp1,String comp2,String comp3,String comp4,String comp5,String comp6,String comp7,String comp8,String comp9,String justificacion);
	List<CompEvaluadorExterno> findAllExternos(String dni);
	List<CompEvaluadorInterno> findAllInternos(String dni);
	void deleteExterno(Integer idRelacion);
	void deleteInterno(Integer idRelacion);
	void editEvaluadorExterno(Integer idRelacion, String justificacion);
	void editEvaluadorInterno(Integer idRelacion, String justificacion) ;
}
