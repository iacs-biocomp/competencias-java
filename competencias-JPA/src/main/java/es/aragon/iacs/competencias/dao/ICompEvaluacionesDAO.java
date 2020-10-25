package es.aragon.iacs.competencias.dao;

import java.util.Date;
import java.util.List;
import es.aragon.iacs.competencias.jpa.CompEvaluaciones;

public interface ICompEvaluacionesDAO {
	List<CompEvaluaciones> findAll();
	CompEvaluaciones findById(Integer id);
	Integer insert(String nombre, String iniaportacion, String finaportacion, String inivalidacion, String finvalidacion, 
			String iniperiodo, String finperiodo, String inievaluacion, String finevaluacion, String catcompetencial); 
	void guardar(Integer id,String nombre, String iniaportacion, String finaportacion, String inivalidacion, String finvalidacion, 
			String iniperiodo, String finperiodo, String inievaluacion, String finevaluacion, String catcompetencial, 
			String comp1, String comp2, String comp3, String comp4, String comp5, String comp6, String comp7, String comp8, String comp9, String comp10);
	void insertInfo(Integer id, String comp1,String comp2,String comp3,String comp4,String comp5,String comp6,String comp7,String comp8,String comp9,String comp10);
	String getCatcompetencial(Integer id);
}
