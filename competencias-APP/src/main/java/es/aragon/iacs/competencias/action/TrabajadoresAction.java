package es.aragon.iacs.competencias.action;

import java.util.List;
import java.util.Date;
import javax.ejb.EJB;

import es.aragon.iacs.competencias.jpa.CompCatContractualesV;
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
    @EJB(name="CompCatContractualesDAO")
    private ICompCatContractualesDAO catContractualesDao;
    private List<CompCatContractualesV> listaCatContractuales;
    private CompCatContractualesV contractual;
    
    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
    private List<CompTrabajadores> listaTrabajadores;

    @EJB(name="CompExternosDAO")
    private ICompExternosDAO externosDao;
    private List<CompExternos> listaExternos;

    @EJB(name="CompCatCompetencialesDAO")
    private ICompCatCompetencialesDAO catCompetencialesDao;
    private List<CompCatCompetenciales> catCompetenciales;
    
    private boolean editar;
    private String dniEditar;
    
    private String dni;
    private String nombre;
    private Integer codigo;
    private String apellidos;
    private String catcontractual;
    private String catcompetencial;
    private String area;
    private String unidad;
    private String departamento;
    private Date antiguedad;
    private Integer id;
    private String email;
    private String instituciones;
    private Boolean posiblesuperior;
    
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
        listaCatContractuales = catContractualesDao.findAll();
        log.debug("Devolviendo lista de pruebas: " + listaTrabajadores.size());
        log.debug("listaCatContractuales: "+listaCatContractuales);
        editar=false;
        return "trabajadores"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado

    }
    

    public String editar() {
    	log.debug("Editando trabajdor con dni="+dni+" nombre=" + nombre);
        catCompetenciales = catCompetencialesDao.findActivas();
    	listaTrabajadores = trabajadoresDao.findAll();
    	listaExternos = externosDao.findAll();
    	listaCatContractuales = catContractualesDao.findAll();
    	editar=true;
    	dniEditar=dni;
    	return "trabajadores";
    }
    
    public String guardarInternos() {

    	log.debug("Editando trabajdor interno con dni="+dni+" nombre=" + nombre);
    	//comprobar si catcompetencial es la que corresponde segun su catcontractual, si es la misma no guardar, sino guardar
    	contractual=catContractualesDao.findByCatcontractual(catcontractual);
    	String codCatComp=contractual.getCodcatcomp();
    	if (codCatComp == catcompetencial) {
    		trabajadoresDao.editInterno(codigo,nombre,apellidos,catcontractual,null,area,unidad,departamento,antiguedad,dni);
    	}
    	else {
    		trabajadoresDao.editInterno(codigo,nombre,apellidos,catcontractual,catcompetencial,area,unidad,departamento,antiguedad,dni);
    	}
    	
        editar=false;
        listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        listaCatContractuales = catContractualesDao.findAll();
    	return "trabajadores";
    }
    
    public String guardarExternos() {

    	log.debug("Editando trabajdor externo con dni="+dni+" posiblesuperior=" + posiblesuperior);
    	//HACER FUNCION EN DAO QUE EDITE
    	trabajadoresDao.editExterno(id,nombre,apellidos,email,instituciones,posiblesuperior,dni);
        editar=false;
        listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        listaCatContractuales = catContractualesDao.findAll();
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

	public List<CompCatCompetenciales> getCatCompetenciales() {
		return catCompetenciales;
	}


	public void setCatCompetenciales(List<CompCatCompetenciales> catCompetenciales) {
		this.catCompetenciales = catCompetenciales;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCatcontractual() {
		return catcontractual;
	}


	public void setCatcontractual(String catcontractual) {
		this.catcontractual = catcontractual;
	}


	public String getCatcompetencial() {
		return catcompetencial;
	}


	public void setCatcompetencial(String catcompetencial) {
		this.catcompetencial = catcompetencial;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getUnidad() {
		return unidad;
	}


	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getInstituciones() {
		return instituciones;
	}


	public void setInstituciones(String instituciones) {
		this.instituciones = instituciones;
	}


	public Boolean getPosiblesuperior() {
		return posiblesuperior;
	}


	public void setPosiblesuperior(Boolean posiblesuperior) {
		this.posiblesuperior = posiblesuperior;
	}


	public List<CompCatContractualesV> getListaCatContractuales() {
		return listaCatContractuales;
	}


	public void setListaCatContractuales(List<CompCatContractualesV> listaCatContractuales) {
		this.listaCatContractuales = listaCatContractuales;
	}


	public CompCatContractualesV getContractual() {
		return contractual;
	}


	public void setContractual(CompCatContractualesV contractual) {
		this.contractual = contractual;
	}


	public Date getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}


}