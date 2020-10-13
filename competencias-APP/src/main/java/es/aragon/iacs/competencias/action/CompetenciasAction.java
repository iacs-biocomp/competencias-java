package es.aragon.iacs.competencias.action;

import java.text.DateFormat;
import java.util.List;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import javax.ejb.EJB;

import es.aragon.iacs.competencias.dao.ICompCompetenciasDAO;
import es.aragon.iacs.competencias.dao.ICompComportamientosDAO;
import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompComportamientos;
import es.aragon.iacs.competencias.jpa.CompNiveles;
import es.aragon.iacs.competencias.dao.ICompNivelesDAO;
import es.aragon.iacs.competencias.jpa.CompObjetivosCompCatcomp;
import es.aragon.iacs.competencias.jpa.CompRelCompCompleto;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.iacs.competencias.dao.ICompCatCompetencialesDAO;
import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.midas.action.MidasActionSupport;

public class CompetenciasAction extends MidasActionSupport{
	private static final long serialVersionUID = 2108264332221967943L;
    @EJB(name="CompCompetenciasDAO")
    private ICompCompetenciasDAO competenciasDao;
    @EJB(name="CompComportamientosDAO")
    private ICompComportamientosDAO comportamientosDao;
    private String codigo;
    private String descripcion;
    private String alta;
    private String baja;
    private String catCompetencial;
    private Integer idRelacion;
    private Integer idNivel;
    private String codCompetencia;
    private Integer idComportamiento;
    
    private boolean editar;
    private String codEditar;
    private String codComp;
    private String nombreCatCompetencial;
    private String codCatCompetencial;
    private String codCatComp;
    
	private List<CompCompetencias> listaCompetencias;
	private List<CompComportamientos> listaComportamientos;
	private List<CompNiveles> listaNiveles;
    
    private List<CompObjetivosCompCatcomp> compObjCompCatcomp;
    private List<CompRelCompCompleto> compRelCompCompleto;

    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
    private CompTrabajadores trabajador;
    
    @EJB(name="CompCatCompetencialesDAO")
    private ICompCatCompetencialesDAO catCompetencialesDao;
//    private CompCatCompetenciales catCompetencial;
    
	@EJB(name="CompNivelesDAO")
    private ICompNivelesDAO compNivelesDao;
    
    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }



    /**
     * Muestra la lista de pruebas
     * @return
     */
    public String list() {
        listaCompetencias = competenciasDao.findAll();
        log.debug("Devolviendo lista de pruebas: " + listaCompetencias.size());
        editar=false;
        return "competencias"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado

    }
    
    public String borrar() {
    	//Buscar con findById(codigo); een el DAO. Puedo crear metodo en el DAO q elimine para poder usarlo varias veces (q le pase el codigo)
    	competenciasDao.delete(codigo);
    	listaCompetencias = competenciasDao.findAll();
    	editar=false;
    	return "competencias";
    }
    
    public String nueva() {
    	//comprobar que alta !=null
    	if (codigo !=null && descripcion != null) {
    		log.debug("VA A INSERTAR COMPETENCIA: "+codigo+ descripcion + " "+alta+" "+baja);
    		//pasar alta a string, comprobar si baja es no null y entonces convertir tb a string
    		competenciasDao.insert(codigo,descripcion,alta,baja);	
    	}
    	listaCompetencias = competenciasDao.findAll();
    	editar=false;
    	return "competencias";
    }
    
    public String concreta() {
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	compRelCompCompleto=competenciasDao.relacionesPorCatComp(catCompetencial);
    	listaNiveles=compNivelesDao.findAll();
    	CompCatCompetenciales cat=catCompetencialesDao.findById(catCompetencial);
    	nombreCatCompetencial=cat.getNombre();
    	codCatCompetencial=cat.getCodigo();
    	listaCompetencias = competenciasDao.findActivas();
    	log.debug("Devolviendo lista de relCompCompleto: " + compRelCompCompleto.size()+ compRelCompCompleto);
    	log.debug("Devolviendo lista de competencias activas: " + listaCompetencias.size()+ listaCompetencias);
    	listaComportamientos = comportamientosDao.findActivos();
    	editar=true;
    	return "catCompetencialConcreta";
    }
    
    public String mis() {
    	String dni=user.getIdd();
    	trabajador=trabajadoresDao.trabajador(dni);
    	String catCompetencial=trabajador.getCatcompetencial();
    	CompCatCompetenciales cat=catCompetencialesDao.findById(catCompetencial);
    	nombreCatCompetencial=cat.getNombre();
    	codCatCompetencial=cat.getCodigo();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	compRelCompCompleto=competenciasDao.relacionesPorCatComp(catCompetencial);
    	listaNiveles=compNivelesDao.findAll();
    	listaCompetencias = competenciasDao.findActivas();
    	listaComportamientos = comportamientosDao.findActivos();
    	editar=false;
        return "catCompetencialConcreta"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado

    }
    
    public String borrarRelacion() {
    	log.debug("Aqui estaría eliminando la relación con id: " + idRelacion+" codCompetencia "+ codCompetencia+ " codCatComp "+ catCompetencial);
    	competenciasDao.deleteRelacion(idRelacion);
    	competenciasDao.deleteRelacionComportamientos(catCompetencial, codCompetencia );
    	log.debug("Se ha eliminado la relación con id: " + idRelacion);
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	compRelCompCompleto=competenciasDao.relacionesPorCatComp(catCompetencial);
    	listaNiveles=compNivelesDao.findAll();
    	CompCatCompetenciales cat=catCompetencialesDao.findById(catCompetencial);
    	nombreCatCompetencial=cat.getNombre();
    	codCatCompetencial=cat.getCodigo();
    	listaCompetencias = competenciasDao.findActivas();
    	listaComportamientos =comportamientosDao.findActivos();
    	editar=true;
    	return "catCompetencialConcreta";
    }
    
    public String nuevaRelacion() {
    	log.debug("Se va a añadir relacion entre competencia con codigo: "+codigo+ " codCatCompetencial: " + codCatCompetencial+ " idNivel: "+ idNivel);
    	competenciasDao.insertRelacion(codigo,codCatCompetencial,idNivel);
    	log.debug("Se ha añadido relacion entre competencia con codigo: "+codigo+ " codCatCompetencial: " + codCatCompetencial+ " idNivel: "+ idNivel);
    	compObjCompCatcomp=competenciasDao.compPorCatComp(codCatCompetencial);
    	compRelCompCompleto=competenciasDao.relacionesPorCatComp(codCatCompetencial);
    	listaNiveles=compNivelesDao.findAll();
    	CompCatCompetenciales cat=catCompetencialesDao.findById(codCatCompetencial);
    	nombreCatCompetencial=cat.getNombre();
    	codCatCompetencial=cat.getCodigo();
    	listaCompetencias = competenciasDao.findActivas();
    	listaComportamientos = comportamientosDao.findActivos();
    	editar=true;
    	return "catCompetencialConcreta";
    }
    
    public String borrarRelacionComportamientos() {
    	log.debug("Aqui estaría eliminando la relaciónComportamientos con id: " + idRelacion);
    	//competenciasDao.deleteRelacion(idRelacion);
    	competenciasDao.deleteRelacionComportamientos(idRelacion );
    	log.debug("Se ha eliminado la relación con id: " + idRelacion);
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	compRelCompCompleto=competenciasDao.relacionesPorCatComp(catCompetencial);
    	listaNiveles=compNivelesDao.findAll();
    	CompCatCompetenciales cat=catCompetencialesDao.findById(catCompetencial);
    	nombreCatCompetencial=cat.getNombre();
    	codCatCompetencial=cat.getCodigo();
    	listaCompetencias = competenciasDao.findActivas();
    	listaComportamientos = comportamientosDao.findActivos();
    	editar=true;
    	return "catCompetencialConcreta";
    }
//    
    public String nuevaRelacionComportamientos() {
    	log.debug("Se va a añadir relacionComportamiento entre competencia con codigo: "+codComp+ " codCatCompetencial: " + codCatComp+ " idNivel: "+ idNivel+ " comportamiento: "+ idComportamiento);
    	competenciasDao.insertRelacionComportamientos(codComp,codCatComp,idNivel,idComportamiento);
    	log.debug("Se ha añadido relacionComportamiento entre competencia con codigo: "+codComp+ " codCatCompetencial: " + codCatComp+ " idNivel: "+ idNivel+ " comportamiento: "+ idComportamiento);
    	compObjCompCatcomp=competenciasDao.compPorCatComp(codCatCompetencial);
    	compRelCompCompleto=competenciasDao.relacionesPorCatComp(codCatCompetencial);
    	listaNiveles=compNivelesDao.findAll();
    	CompCatCompetenciales cat=catCompetencialesDao.findById(codCatCompetencial);
    	nombreCatCompetencial=cat.getNombre();
    	codCatCompetencial=cat.getCodigo();
    	listaCompetencias = competenciasDao.findActivas();
    	listaComportamientos = comportamientosDao.findActivos();
    	editar=true;
    	return "catCompetencialConcreta";
    }
    
    public String editar() {
    	listaCompetencias = competenciasDao.findAll();
    	editar=true;
    	codEditar=codigo;
    	return "competencias";
    }
    
    public String guardar() {

    	log.debug("Editando competencia con codigo="+codigo+" descripcion=" + descripcion +"alta: "+ alta + " baja:" +baja);
    	competenciasDao.edit(codigo, descripcion, alta, baja);
    	log.debug("Editando competencia con codigo="+codigo+" descripcion=" + descripcion +"alta: "+ alta + " baja:" +baja);
        editar=false;
        listaCompetencias = competenciasDao.findAll();
    	return "competencias";
    }
    

    /**
     * Esta función "getter" es la que utilizará JSP para visualizar la
lista
     */
    public List<CompCompetencias> getCompetencias() {
        return listaCompetencias;
    }
    
    public List<CompObjetivosCompCatcomp> getMisCompetencias() {
        return compObjCompCatcomp;
    }
    

    public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CompObjetivosCompCatcomp> getCompObjCompCatcomp() {
		return compObjCompCatcomp;
	}

	public void setCompObjCompCatcomp(List<CompObjetivosCompCatcomp> compObjCompCatcomp) {
		this.compObjCompCatcomp = compObjCompCatcomp;
	}

	public String getAlta() {
		return alta;
	}

	public void setAlta(String alta) {
		this.alta = alta;
	}

	public String getBaja() {
		return baja;
	}

	public void setBaja(String baja) {
		this.baja = baja;
	}

	public String getCatCompetencial() {
		return catCompetencial;
	}

	public void setCatCompetencial(String catCompetencial) {
		this.catCompetencial = catCompetencial;
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

	public List<CompRelCompCompleto> getCompRelCompCompleto() {
		return compRelCompCompleto;
	}

	public void setCompRelCompCompleto(List<CompRelCompCompleto> compRelCompCompleto) {
		this.compRelCompCompleto = compRelCompCompleto;
	}

	public List<CompNiveles> getListaNiveles() {
		return listaNiveles;
	}

	public void setListaNiveles(List<CompNiveles> listaNiveles) {
		this.listaNiveles = listaNiveles;
	}

	public String getCodComp() {
		return codComp;
	}

	public void setCodComp(String codComp) {
		this.codComp = codComp;
	}

	public String getNombreCatCompetencial() {
		return nombreCatCompetencial;
	}

	public void setNombreCatCompetencial(String nombreCatCompetencial) {
		this.nombreCatCompetencial = nombreCatCompetencial;
	}

	public Integer getIdRelacion() {
		return idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public String getCodCatCompetencial() {
		return codCatCompetencial;
	}

	public void setCodCatCompetencial(String codCatCompetencial) {
		this.codCatCompetencial = codCatCompetencial;
	}

	public Integer getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public List<CompComportamientos> getListaComportamientos() {
		return listaComportamientos;
	}

	public void setListaComportamientos(List<CompComportamientos> listaComportamientos) {
		this.listaComportamientos = listaComportamientos;
	}

	public String getCodCompetencia() {
		return codCompetencia;
	}

	public void setCodCompetencia(String codCompetencia) {
		this.codCompetencia = codCompetencia;
	}

	public Integer getIdComportamiento() {
		return idComportamiento;
	}

	public void setIdComportamiento(Integer idComportamiento) {
		this.idComportamiento = idComportamiento;
	}

	public String getCodCatComp() {
		return codCatComp;
	}

	public void setCodCatComp(String codCatComp) {
		this.codCatComp = codCatComp;
	}
}
