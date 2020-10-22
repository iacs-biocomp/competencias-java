package es.aragon.iacs.competencias.action;

import es.aragon.midas.action.MidasActionSupport;
import javax.ejb.EJB;

public class ResultadosAction extends MidasActionSupport{
	private static final long serialVersionUID = 2108264332221967943L;
	private String dniActual;
	
	{
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }
    
    public String mis() {
    	
    	dniActual=user.getIdd();
    	return "resultados";
    }
    
    public String evaluacionConcreta() {
    	
    	return "resultadosConcretos";
    }

	public String getDniActual() {
		return dniActual;
	}

	public void setDniActual(String dniActual) {
		this.dniActual = dniActual;
	}
	
}
