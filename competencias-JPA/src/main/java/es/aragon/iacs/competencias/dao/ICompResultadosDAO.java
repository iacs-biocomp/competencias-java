package es.aragon.iacs.competencias.dao;

import java.util.List;
import es.aragon.iacs.competencias.jpa.CompResultados;

public interface ICompResultadosDAO {

	void sumarValoracion(Integer idEvaluacion, String dniEvaluado, Integer grupoev,String codcomp, Integer idnivel, float valoracion);
	List<CompResultados> evaluacionCalculada(Integer idEvaluacion);
}
