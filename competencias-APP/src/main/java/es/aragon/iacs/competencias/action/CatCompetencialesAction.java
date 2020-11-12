package es.aragon.iacs.competencias.action;

import java.util.List;

import javax.ejb.EJB;
import java.util.Date;
import es.aragon.iacs.competencias.dao.ICompCatCompetencialesDAO;
import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.midas.action.MidasActionSupport;
import es.aragon.iacs.competencias.dao.ICompEvaluacionesDAO;

public class CatCompetencialesAction extends MidasActionSupport{

    private static final long serialVersionUID = 2108264332221967943L;
    @EJB(name="CompCatCompetencialesDAO")
    private ICompCatCompetencialesDAO catCompetencialesDao;
    @EJB(name="CompEvaluacionesDAO")
    private ICompEvaluacionesDAO evaluacionesDao;
    private String codigo;
    private String nombre;
    private Date alta;
    private Date baja;

    private boolean editar;
    private String codEditar;
    
    private List<CompCatCompetenciales> listaCatCompetenciales;


    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, seg�n interese la seguridad
    }



    /**
     * Muestra la lista de pruebas
     * @return
     */
    public String list() {
        listaCatCompetenciales = catCompetencialesDao.findAll();
        log.debug("Devolviendo lista de pruebas: " + listaCatCompetenciales.size());
        editar=false;
        return "catCompetenciales"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qu� visualizaci�n queremos como resultado

    }
    
    public String borrar() {
    	if (codigo!= null) {
    		catCompetencialesDao.delete(codigo);
    	}
    	listaCatCompetenciales = catCompetencialesDao.findAll();
    	editar=false;
    	return "catCompetenciales";
    }
    
    public String nueva() {
    	if (codigo !=null && nombre !=null && alta != null) {
    		catCompetencialesDao.insert(codigo,nombre,alta,baja);
    	}
    	listaCatCompetenciales = catCompetencialesDao.findAll();
    	editar=false;
    	return "catCompetenciales";
    }
    
    public String editar() {
    	listaCatCompetenciales = catCompetencialesDao.findAll();
    	editar=true;
    	codEditar=codigo;
    	return "catCompetenciales";
    }

    public String guardar() {

    	log.debug("Editando catCompetencial con codigo="+codigo+" nombre=" + nombre +"alta: "+ alta + " baja:" +baja);
    	catCompetencialesDao.edit(codigo, nombre, alta, baja);
    	log.debug("Editada catCompetencial con codigo="+codigo+" nombre=" + nombre +"alta: "+ alta + " baja:" +baja);
        editar=false;
    	listaCatCompetenciales = catCompetencialesDao.findAll();
    	return "catCompetenciales";
    }
    
    /**
     * Esta funci�n "getter" es la que utilizar� JSP para visualizar la
lista
     */
    public List<CompCatCompetenciales> getCatCompetenciales() {
        return listaCatCompetenciales;
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public String getCodEditar() {
		return codEditar;
	}

	public void setCodEditar(String codEditar) {
		this.codEditar = codEditar;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public Date getBaja() {
		return baja;
	}

	public void setBaja(Date baja) {
		this.baja = baja;
	}
	
}