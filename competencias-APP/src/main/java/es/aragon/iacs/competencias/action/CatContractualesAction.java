package es.aragon.iacs.competencias.action;

import java.util.List;

import javax.ejb.EJB;

import es.aragon.iacs.competencias.dao.ICompCatCompetencialesDAO;
import es.aragon.iacs.competencias.dao.ICompCatContractualesDAO;
import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.iacs.competencias.jpa.CompCatContractualesV;
import es.aragon.midas.action.MidasActionSupport;


public class CatContractualesAction extends MidasActionSupport{

    private static final long serialVersionUID = 2108264332221967943L;
    @EJB(name="CompCatContractualesDAO")
    private ICompCatContractualesDAO catContractualesDao;
    private List<CompCatContractualesV> listaCatContractuales;

    @EJB(name="CompCatCompetencialesDAO")
    private ICompCatCompetencialesDAO catCompetencialesDao;
    private List<CompCatCompetenciales> listaCatCompetenciales;
    
    private boolean editar;
    private String id;
    private String catcomp;

    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, seg�n interese la seguridad
    }

    public String list() {
        listaCatContractuales = catContractualesDao.findAll();
        log.debug("Devolviendo lista de pruebas: " + listaCatContractuales.size());
        editar=false;
        return "catContractuales"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qu� visualizaci�n queremos como resultado

    }
    
    public String editar() {
        listaCatContractuales = catContractualesDao.findAll();
        listaCatCompetenciales = catCompetencialesDao.findAll();
        log.debug("Devolviendo lista de pruebas: " + listaCatContractuales.size());
        editar=true;
        return "catContractuales"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qu� visualizaci�n queremos como resultado

    }
    public String guardar() {
    	log.debug("Editando catContractual con id="+id+" asignando catcomp=" + catcomp);
    	int idInt=Integer.parseInt(id);
    	log.debug("Editando catContractual con id="+idInt+" asignando catcomp=" + catcomp);
    	catContractualesDao.editId(idInt, catcomp);
    	log.debug("Despues de editId");
        listaCatContractuales = catContractualesDao.findAll();
        editar=false;
        
        return "catContractuales"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qu� visualizaci�n queremos como resultado

    }

    public List<CompCatContractualesV> getCatContractuales() {
        return listaCatContractuales;
    }

	public List<CompCatCompetenciales> getCatCompetenciales() {
		return listaCatCompetenciales;
	}

	public void setListaCatCompetenciales(List<CompCatCompetenciales> listaCatCompetenciales) {
		this.listaCatCompetenciales = listaCatCompetenciales;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCatcomp() {
		return catcomp;
	}

	public void setCatcomp(String catcomp) {
		this.catcomp = catcomp;
	}
}