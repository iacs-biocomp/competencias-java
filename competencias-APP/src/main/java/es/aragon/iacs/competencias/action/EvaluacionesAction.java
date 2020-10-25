package es.aragon.iacs.competencias.action;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;

import es.aragon.midas.action.MidasActionSupport;
import es.aragon.iacs.competencias.dao.ICompCatCompetencialesDAO;
import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.iacs.competencias.dao.ICompCompetenciasDAO;
import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.iacs.competencias.jpa.CompExternos;
import es.aragon.iacs.competencias.dao.ICompExternosDAO;
import es.aragon.iacs.competencias.dao.ICompEvaluacionesDAO;
import es.aragon.iacs.competencias.jpa.CompObjetivosCompCatcomp;
import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompEvaluaciones;
import es.aragon.iacs.competencias.jpa.CompObjetivos;
import es.aragon.iacs.competencias.jpa.CompObjetivosCompCatcomp;
public class EvaluacionesAction extends MidasActionSupport{
	private static final long serialVersionUID = 2108264332221967943L;
	
	@EJB(name="CompCatCompetencialesDAO")
    private ICompCatCompetencialesDAO catCompetencialesDao;
	private List<CompCatCompetenciales> listaCatCompetenciales;
	
	@EJB(name="CompCompetenciasDAO")
    private ICompCompetenciasDAO competenciasDao;
    private List<CompCompetencias> listaCompetencias;
    
//    private Boolean interno;
    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
//    private CompTrabajadores trabajador;
    private List<CompObjetivosCompCatcomp> compObjCompCatcomp;
    
    private List<CompTrabajadores> listaTrabajadores;
    
    @EJB(name="CompExternosDAO")
    private ICompExternosDAO externosDao;
    
    @EJB(name="CompEvaluacionesDAO")
    private ICompEvaluacionesDAO evaluacionesDao;
    private List<CompEvaluaciones> listaEvaluaciones;
    private CompEvaluaciones evaluacionActual;
    
    private List<CompObjetivosCompCatcomp> objCompCatcomp;
    
    private Integer id;
	private String nombre;
	private String iniaportacion;
	private String finaportacion;
	private String inivalidacion;
	private String finvalidacion;
	private String iniperiodo;
	private String finperiodo;
	private String inievaluacion;
	private String finevaluacion;
	private String catcompetencial;
//	private String trabajador;
	private String comp0;
	private String comp1;
	private String comp2;
	private String comp3;
	private String comp4;
	private String comp5;
	private String comp6;
	private String comp7;
	private String comp8;
	private String comp9;

	
	private Boolean editar;
	private Boolean editar2;
	private Integer idEditar;
	private String fechaActual;
	
	private Integer idNueva;
	private CompEvaluaciones nuevaEvaluacion;
	
	
	{
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }
	
	public String fechaActual() {
		
			Date fechaActual = new Date();
	        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
	        String fechaSistema=formateador.format(fechaActual);
	        return fechaSistema;
	}
	
    public String mis() {
    	
//        listaEvaluaciones = evaluacionesDao.findAll();
//        log.debug("Devolviendo lista de pruebas: " + listaNiveles.size());
//        editar=false;
        return "evaluaciones"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String list() {
    	listaCatCompetenciales=catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaEvaluaciones=evaluacionesDao.findAll();
        objCompCatcomp=competenciasDao.allObjCompCatcomp();
        listaCompetencias=competenciasDao.findAll();
        fechaActual=fechaActual();
        editar=false;
        editar2=false;
        idEditar=-1;
        log.debug("Listará sin editar");
//        listaOrganigramas = organigramasDao.findAll();
////        log.debug("Devolviendo lista de pruebas: " + listaNiveles.size());
//        editar=false;
    	//NECESITO: listaCatCompetenciales, listaTrabajadores, listaExternos,listaCompetencias
        return "evaluaciones"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String nueva() {
    	log.debug("Se va a añadir: "+nombre);
    	idNueva=evaluacionesDao.insert(nombre, iniaportacion, finaportacion, inivalidacion, finvalidacion,iniperiodo, finperiodo, inievaluacion, finevaluacion, catcompetencial);
    	log.debug("Se ha añadido: "+nombre);
    	nuevaEvaluacion=evaluacionesDao.findById(idNueva);
    	//    	listaCatCompetenciales=catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findByCatcomp(catcompetencial);
//        listaEvaluaciones=evaluacionesDao.findAll();
        objCompCatcomp=competenciasDao.compPorCatComp(catcompetencial);
        listaCompetencias=competenciasDao.findAll();
        fechaActual=fechaActual();
    	editar=false;
    	editar2=true;
        idEditar=-1;
    	return "evaluaciones"; 
    }
    
    public String nuevaInfo() {
    	log.debug("Se va a añadir: "+id+comp0+comp1+comp2+comp3+comp4);
    	evaluacionesDao.insertInfo(id, comp0,comp1,comp2,comp3,comp4,comp5,comp6,comp7,comp8,comp9);
    	log.debug("Se ha añadido: "+id+comp0+comp1+comp2+comp3+comp4);
    	catcompetencial=evaluacionesDao.getCatcompetencial(id);
    	listaCatCompetenciales=catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findByCatcomp(catcompetencial);
        listaEvaluaciones=evaluacionesDao.findAll();
        objCompCatcomp=competenciasDao.compPorCatComp(catcompetencial);
        listaCompetencias=competenciasDao.findAll();
        fechaActual=fechaActual();
    	editar=false;
    	editar2=false;
        idEditar=-1;
    	return "evaluaciones"; 
    }
    public String editar() {
    	listaCatCompetenciales=catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaEvaluaciones=evaluacionesDao.findAll();
        catcompetencial=evaluacionesDao.getCatcompetencial(id);
        objCompCatcomp=competenciasDao.compPorCatComp(catcompetencial);
        listaCompetencias=competenciasDao.findAll();
        fechaActual=fechaActual();
    	editar=true;
    	 editar2=false;
    	idEditar=id;
    	return "evaluaciones"; 
    }
    public String guardar() {
    	log.debug("se va a guardar elemento con id: "+id);
    	evaluacionesDao.guardar(id, nombre, iniaportacion, finaportacion, inivalidacion, finvalidacion,iniperiodo, finperiodo, inievaluacion, finevaluacion, 
    			catcompetencial, comp0,comp1, comp2, comp3, comp4, comp5, comp6, comp7, comp8, comp9);
    	listaCatCompetenciales=catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaEvaluaciones=evaluacionesDao.findAll();
        catcompetencial=evaluacionesDao.getCatcompetencial(id);
        objCompCatcomp=competenciasDao.compPorCatComp(catcompetencial);
        listaCompetencias=competenciasDao.findAll();
        fechaActual=fechaActual();
    	editar=false;
    	 editar2=false;
        idEditar=-1;
    	return "evaluaciones"; 
    }
    
    public String concreta() {
    	log.debug("se va a evaluar evaluacion con id: "+id);
    	evaluacionActual=evaluacionesDao.findById(id);
    	listaTrabajadores = trabajadoresDao.findAll();
    	return "evaluacionConcreta";
    }



	public List<CompCompetencias> getListaCompetencias() {
		return listaCompetencias;
	}

	public void setListaCompetencias(List<CompCompetencias> listaCompetencias) {
		this.listaCompetencias = listaCompetencias;
	}

	public List<CompObjetivosCompCatcomp> getCompObjCompCatcomp() {
		return compObjCompCatcomp;
	}

	public void setCompObjCompCatcomp(List<CompObjetivosCompCatcomp> compObjCompCatcomp) {
		this.compObjCompCatcomp = compObjCompCatcomp;
	}

	public List<CompTrabajadores> getListaTrabajadores() {
		return listaTrabajadores;
	}

	public void setListaTrabajadores(List<CompTrabajadores> listaTrabajadores) {
		this.listaTrabajadores = listaTrabajadores;
	}

	public List<CompCatCompetenciales> getListaCatCompetenciales() {
		return listaCatCompetenciales;
	}

	public void setListaCatCompetenciales(List<CompCatCompetenciales> listaCatCompetenciales) {
		this.listaCatCompetenciales = listaCatCompetenciales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIniaportacion() {
		return iniaportacion;
	}

	public void setIniaportacion(String iniaportacion) {
		this.iniaportacion = iniaportacion;
	}

	public String getFinaportacion() {
		return finaportacion;
	}

	public void setFinaportacion(String finaportacion) {
		this.finaportacion = finaportacion;
	}

	public String getInivalidacion() {
		return inivalidacion;
	}

	public void setInivalidacion(String inivalidacion) {
		this.inivalidacion = inivalidacion;
	}

	public String getFinvalidacion() {
		return finvalidacion;
	}

	public void setFinvalidacion(String finvalidacion) {
		this.finvalidacion = finvalidacion;
	}

	public String getIniperiodo() {
		return iniperiodo;
	}

	public void setIniperiodo(String iniperiodo) {
		this.iniperiodo = iniperiodo;
	}

	public String getFinperiodo() {
		return finperiodo;
	}

	public void setFinperiodo(String finperiodo) {
		this.finperiodo = finperiodo;
	}

	public String getInievaluacion() {
		return inievaluacion;
	}

	public void setInievaluacion(String inievaluacion) {
		this.inievaluacion = inievaluacion;
	}

	public String getFinevaluacion() {
		return finevaluacion;
	}

	public void setFinevaluacion(String finevaluacion) {
		this.finevaluacion = finevaluacion;
	}

	public String getCatcompetencial() {
		return catcompetencial;
	}

	public void setCatcompetencial(String catcompetencial) {
		this.catcompetencial = catcompetencial;
	}

	public String getComp1() {
		return comp1;
	}

	public void setComp1(String comp1) {
		this.comp1 = comp1;
	}

	public String getComp2() {
		return comp2;
	}

	public void setComp2(String comp2) {
		this.comp2 = comp2;
	}

	public String getComp3() {
		return comp3;
	}

	public void setComp3(String comp3) {
		this.comp3 = comp3;
	}

	public String getComp4() {
		return comp4;
	}

	public void setComp4(String comp4) {
		this.comp4 = comp4;
	}

	public String getComp5() {
		return comp5;
	}

	public void setComp5(String comp5) {
		this.comp5 = comp5;
	}

	public String getComp6() {
		return comp6;
	}

	public void setComp6(String comp6) {
		this.comp6 = comp6;
	}

	public String getComp7() {
		return comp7;
	}

	public void setComp7(String comp7) {
		this.comp7 = comp7;
	}

	public String getComp8() {
		return comp8;
	}

	public void setComp8(String comp8) {
		this.comp8 = comp8;
	}

	public String getComp9() {
		return comp9;
	}

	public void setComp9(String comp9) {
		this.comp9 = comp9;
	}


	public List<CompEvaluaciones> getListaEvaluaciones() {
		return listaEvaluaciones;
	}

	public void setListaEvaluaciones(List<CompEvaluaciones> listaEvaluaciones) {
		this.listaEvaluaciones = listaEvaluaciones;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public Integer getIdEditar() {
		return idEditar;
	}

	public void setIdEditar(Integer idEditar) {
		this.idEditar = idEditar;
	}

	public String getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CompObjetivosCompCatcomp> getObjCompCatcomp() {
		return objCompCatcomp;
	}

	public void setObjCompCatcomp(List<CompObjetivosCompCatcomp> objCompCatcomp) {
		this.objCompCatcomp = objCompCatcomp;
	}

	public Boolean getEditar2() {
		return editar2;
	}

	public void setEditar2(Boolean editar2) {
		this.editar2 = editar2;
	}

	public Integer getIdNueva() {
		return idNueva;
	}

	public void setIdNueva(Integer idNueva) {
		this.idNueva = idNueva;
	}

	public CompEvaluaciones getNuevaEvaluacion() {
		return nuevaEvaluacion;
	}

	public void setNuevaEvaluacion(CompEvaluaciones nuevaEvaluacion) {
		this.nuevaEvaluacion = nuevaEvaluacion;
	}

	public String getComp0() {
		return comp0;
	}

	public void setComp0(String comp0) {
		this.comp0 = comp0;
	}

	public CompEvaluaciones getEvaluacionActual() {
		return evaluacionActual;
	}

	public void setEvaluacionActual(CompEvaluaciones evaluacionActual) {
		this.evaluacionActual = evaluacionActual;
	}



	
	
}
