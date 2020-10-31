package es.aragon.iacs.competencias.action;

import java.util.List;


import javax.ejb.EJB;

import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.iacs.competencias.dao.ICompCatCompetencialesDAO;
import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.midas.action.MidasActionSupport;

public class MisDatosAction extends MidasActionSupport{

    private static final long serialVersionUID = 2108264332221967943L;
    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
    private CompTrabajadores trabajador;
    
    @EJB(name="CompCatCompetencialesDAO")
    private ICompCatCompetencialesDAO catCompetencialesDao;
	private List<CompCatCompetenciales> catCompetenciales;
   
    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }

    /**
     * Muestra la lista de pruebas
     * @return
     */
    public String misDatos() {
    	String dni=user.getIdd();
    	trabajador=trabajadoresDao.trabajador(dni);
    	catCompetenciales=catCompetencialesDao.findAll();
//        log.debug("Devolviendo lista de pruebas: " + listaTrabajadores.size());
        return "misDatos"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado

    }

    /**
     * Esta función "getter" es la que utilizará JSP para visualizar la
lista
     */
    public CompTrabajadores getDatos() {
        return trabajador;
    }

	public List<CompCatCompetenciales> getCatCompetenciales() {
		return catCompetenciales;
	}

	public void setCatCompetenciales(List<CompCatCompetenciales> catCompetenciales) {
		this.catCompetenciales = catCompetenciales;
	}
}


