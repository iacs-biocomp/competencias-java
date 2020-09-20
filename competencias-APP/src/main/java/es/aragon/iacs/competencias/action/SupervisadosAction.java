package es.aragon.iacs.competencias.action;

import java.util.List;

import javax.ejb.EJB;

//import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
//import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.midas.action.MidasActionSupport;

public class SupervisadosAction extends MidasActionSupport{
    private static final long serialVersionUID = 2108264332221967943L;
    
    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }
    

    /**
     * Muestra la lista de pruebas
     * @return
     */
    public String mis() {
//    	String dni=user.getIdd();
//    	trabajador=trabajadoresDao.trabajador(dni);
//        log.debug("Devolviendo lista de pruebas: " + listaTrabajadores.size());
        return "supervisados"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado

    }

    
}
