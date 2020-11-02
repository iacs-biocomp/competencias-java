package es.aragon.iacs.competencias.dao;

import java.util.Date;
import java.util.List;
import es.aragon.iacs.competencias.jpa.CompEvaluaciones;
import es.aragon.iacs.competencias.jpa.CompValoraciones;

public interface ICompEvaluacionesDAO {
	List<CompEvaluaciones> findAll();
	CompEvaluaciones findById(Integer id);
	Integer insert(String nombre, Date iniaportacion, Date finaportacion, Date inivalidacion, Date finvalidacion, 
			Date iniperiodo, Date finperiodo, Date inievaluacion, Date finevaluacion, String catcompetencial); 
	void guardar(Integer id,String nombre, Date iniaportacion, Date finaportacion, Date inivalidacion, Date finvalidacion, 
			Date iniperiodo, Date finperiodo, Date inievaluacion, Date finevaluacion, String catcompetencial, 
			String comp1, String comp2, String comp3, String comp4, String comp5, String comp6, String comp7, String comp8, String comp9, String comp10);
	void insertInfo(Integer id, String comp1,String comp2,String comp3,String comp4,String comp5,String comp6,String comp7,String comp8,String comp9,String comp10);
	String getCatcompetencial(Integer id);
	List<CompEvaluaciones> findActiva(String catCompetencial);
	List<CompEvaluaciones> findActivoEvaluadores(String catCompetencial);
	void insertValoracion(Integer idevaluacion, String dnievaluador, String dnievaluado, Integer idrelacion, Integer valoracion );
	List<CompValoraciones> valoracionesPorIdEvaluacion (Integer idEvaluacion);
}
