package es.aragon.iacs.competencias.action;

import java.util.List;

import javax.ejb.EJB;

import es.aragon.midas.action.MidasActionSupport;

public class EvaluacionesAction extends MidasActionSupport{
	private static final long serialVersionUID = 2108264332221967943L;
	{
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }
	
    public String mis() {
//        listaEvaluaciones = evaluacionesDao.findAll();
//        log.debug("Devolviendo lista de pruebas: " + listaNiveles.size());
//        editar=false;
        return "evaluaciones"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String list() {
//        listaOrganigramas = organigramasDao.findAll();
////        log.debug("Devolviendo lista de pruebas: " + listaNiveles.size());
//        editar=false;
        return "evaluaciones"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String concreta() {
    	
    	return "evaluacionConcreta";
    }
	
}
