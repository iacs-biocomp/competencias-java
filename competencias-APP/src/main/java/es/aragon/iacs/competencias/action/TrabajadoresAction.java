package es.aragon.iacs.competencias.action;

import java.util.List;

import javax.ejb.EJB;

import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.iacs.competencias.dao.ICompCatCompetencialesDAO;
import es.aragon.iacs.competencias.dao.ICompCatContractualesDAO;
import es.aragon.iacs.competencias.dao.ICompExternosDAO;
import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.iacs.competencias.jpa.CompCatContractualesV;
import es.aragon.iacs.competencias.jpa.CompExternos;
import es.aragon.midas.action.MidasActionSupport;

public class TrabajadoresAction extends MidasActionSupport{

    private static final long serialVersionUID = 2108264332221967943L;
    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
    private List<CompTrabajadores> listaTrabajadores;

    @EJB(name="CompExternosDAO")
    private ICompExternosDAO externosDao;
    private List<CompExternos> listaExternos;
    
    @EJB(name="CompCatContractualesDAO")
    private ICompCatContractualesDAO catContractualesDao;
    private List<CompCatContractualesV> catContractuales;

    @EJB(name="CompCatCompetencialesDAO")
    private ICompCatCompetencialesDAO catCompetencialesDao;
    private List<CompCatCompetenciales> catCompetenciales;
    
    private boolean editar;
    private String dniEditar;
    
    private String dni;
    private String nombre;
    
    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }



    /**
     * Muestra la lista de pruebas
     * @return
     */
    public String list() {
        listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        log.debug("Devolviendo lista de pruebas: " + listaTrabajadores.size());
        editar=false;
        return "trabajadores"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado

    }
    

    public String editar() {
    	log.debug("Editando trabajdor con dni="+dni+" nombre=" + nombre);
    	catContractuales = catContractualesDao.findAll();
        catCompetenciales = catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
    	listaExternos = externosDao.findAll();
    	editar=true;
    	dniEditar=dni;
    	return "trabajadores";
    }
    
    public String guardarInternos() {

    	log.debug("Editando trabajdor interno con dni="+dni+" nombre=" + nombre);
    	//HACER FUNCION EN DAO QUE EDITE
    	//trabajadoresDao.editInterno(codigo,nombre,apellidos,catcontractual,catcompetencial,area,unidad,departamento,antiguedad,dni);
        editar=false;
        listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
    	return "trabajadores";
    }
    
    public String guardarExternos() {

    	log.debug("Editando trabajdor externo con dni="+dni+" nombre=" + nombre);
    	//HACER FUNCION EN DAO QUE EDITE
    	//trabajadoresDao.editExterno(id,nombre,apellidos,email,instituciones,posiblesuperior,dni);
        editar=false;
        listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
    	return "trabajadores";
    }
    

    /**
     * Esta función "getter" es la que utilizará JSP para visualizar la
lista
     */
    public List<CompTrabajadores> getTrabajadores() {
        return listaTrabajadores;
    }
    
    public List<CompExternos> getExternos() {
        return listaExternos;
    }

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public String getDniEditar() {
		return dniEditar;
	}

	public void setDniEditar(String dniEditar) {
		this.dniEditar = dniEditar;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<CompCatContractualesV> getCatContractuales() {
		return catContractuales;
	}


	public void setCatContractuales(List<CompCatContractualesV> catContractuales) {
		this.catContractuales = catContractuales;
	}


	public List<CompCatCompetenciales> getCatCompetenciales() {
		return catCompetenciales;
	}


	public void setCatCompetenciales(List<CompCatCompetenciales> catCompetenciales) {
		this.catCompetenciales = catCompetenciales;
	}


}