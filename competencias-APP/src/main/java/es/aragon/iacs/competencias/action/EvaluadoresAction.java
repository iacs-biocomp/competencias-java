package es.aragon.iacs.competencias.action;

import java.util.List;

import javax.ejb.EJB;

import es.aragon.iacs.competencias.dao.ICompCompetenciasDAO;
import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.iacs.competencias.jpa.CompObjetivosCompCatcomp;
import es.aragon.iacs.competencias.jpa.CompExternos;
import es.aragon.iacs.competencias.dao.ICompExternosDAO;
import es.aragon.iacs.competencias.dao.ICompEvaluadoresDAO;
import es.aragon.iacs.competencias.dao.ICompOrganigramasDAO;
import es.aragon.iacs.competencias.jpa.CompEvaluadorExterno;
import es.aragon.iacs.competencias.jpa.CompEvaluadorInterno;
import es.aragon.iacs.competencias.jpa.CompPares;
import es.aragon.iacs.competencias.jpa.CompSuperiores;
import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompOrganigramas;

//import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
//import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.midas.action.MidasActionSupport;

public class EvaluadoresAction extends MidasActionSupport{
    private static final long serialVersionUID = 2108264332221967943L;
    @EJB(name="CompCompetenciasDAO")
    private ICompCompetenciasDAO competenciasDao;
    private List<CompCompetencias> listaCompetencias;
    
//    private Boolean interno;
    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
    private CompTrabajadores trabajador;
    private List<CompObjetivosCompCatcomp> compObjCompCatcomp;
    
    private List<CompTrabajadores> listaTrabajadores;
    
    @EJB(name="CompExternosDAO")
    private ICompExternosDAO externosDao;
    private List<CompExternos> listaExternos;
    
    @EJB(name="CompEvaluadoresDAO")
    private ICompEvaluadoresDAO evaluadoresDao;
    private List<CompEvaluadorExterno> evaluadoresExternos;
    private List<CompEvaluadorInterno> evaluadoresInternos;
//    private CompEvaluadores evaluador;

    @EJB(name="CompOrganigramasDAO")
    private ICompOrganigramasDAO organigramasDao;
    private List<CompPares> listaPares;
    private List<CompSuperiores> listaSuperiores;
    
    
    private String dniActual;
    
    private String nombre;
    private String apellidos;
    private String email;
    private String institucion;
    private String dniEvaluador;
    private Integer grupo;
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
    private String justificacion; 
    private Integer idEvaluador;
    
    private Integer idRelacion;
    
    private String dniEditar;
    private Integer idEditar;
    
//    private Boolean externo;
    
    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }
    
    public String mis() {
    	dniActual=user.getIdd();
    	trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaCompetencias=competenciasDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
        log.debug("Externos"+dniActual+": "+evaluadoresExternos.size()+evaluadoresExternos);
        CompOrganigramas actual=organigramasDao.findActivo();
        Integer idActual=actual.getId();
        listaPares=organigramasDao.findPares(idActual);
        listaSuperiores=organigramasDao.findSuperiores(idActual);
        log.debug("listaPares: "+listaPares.size()+listaPares);
        log.debug("listaSuperiores: "+listaSuperiores.size()+listaSuperiores);
    //	interno=true;
    	dniEditar="";
    	idEditar=-1;
        return "evaluadores"; 
    }
    
    public String nuevaPropuestaInterno() {
    	log.debug("Nueva propuesta de tipo interno dniEvaluador: "+dniEvaluador+" grupo "+grupo+" comp0 "+comp0+" comp1 "+comp1+" comp2 "+comp2+" justificacion "+justificacion);
    	dniActual=user.getIdd();
    	//Paso idEvaluacion=1 pero debería pasar el que corresponda para la evaluacion activa del trabajador
    	evaluadoresDao.insertInterno(1,dniActual,dniEvaluador,grupo,comp0,comp1,comp2,comp3,comp4,comp5,comp6,comp7,comp8,comp9,justificacion);
    	trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaCompetencias=competenciasDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
        CompOrganigramas actual=organigramasDao.findActivo();
        Integer idActual=actual.getId();
        listaPares=organigramasDao.findPares(idActual);
        listaSuperiores=organigramasDao.findSuperiores(idActual);
    	//interno=true;
    	dniEditar="";
    	idEditar=-1;
    	return "evaluadores";
    }
    
    public String nuevaPropuestaExterno() {
    	log.debug("Nueva propuesta de tipo externo idEvaluador: "+idEvaluador+" grupo "+grupo+" comp0 "+comp0+" comp1 "+comp1+" comp2 "+comp2+" justificacion "+justificacion);
    	dniActual=user.getIdd();
    	//Paso idEvaluacion=1 pero debería pasar el que corresponda para la evaluacion activa del trabajador
    	evaluadoresDao.insertExterno(1,dniActual,idEvaluador,grupo,comp0,comp1,comp2,comp3,comp4,comp5,comp6,comp7,comp8,comp9,justificacion);
    	trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaCompetencias=competenciasDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
        CompOrganigramas actual=organigramasDao.findActivo();
        Integer idActual=actual.getId();
        listaPares=organigramasDao.findPares(idActual);
        listaSuperiores=organigramasDao.findSuperiores(idActual);
    	//interno=false;
    	dniEditar="";
    	idEditar=-1;
    	return "evaluadores";
    }
//
//    public String formInterno() {
//    	log.debug("Nueva propuesta de tipo interno ");
//    	dniActual=user.getIdd();
//    	trabajador=trabajadoresDao.trabajador(dniActual);
//    	String catCompetencial=trabajador.getCatcompetencial();
//    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
//    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
//    	listaCompetencias=competenciasDao.findAll();
//    	listaTrabajadores = trabajadoresDao.findAll();
//        listaExternos = externosDao.findAll();
//        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
//        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
//        CompOrganigramas actual=organigramasDao.findActivo();
//        Integer idActual=actual.getId();
//        listaPares=organigramasDao.findPares(idActual);
//        listaSuperiores=organigramasDao.findSuperiores(idActual);
//    	//interno=true;
//    	dniEditar="";
//    	idEditar=-1;
//    	return "evaluadores";
//    }
    
//    public String formExterno() {
//    	log.debug("Nueva propuesta de tipo externo ");
//    	dniActual=user.getIdd();
//    	trabajador=trabajadoresDao.trabajador(dniActual);
//    	String catCompetencial=trabajador.getCatcompetencial();
//    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
//    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
//    	listaCompetencias=competenciasDao.findAll();
//    	listaTrabajadores = trabajadoresDao.findAll();
//        listaExternos = externosDao.findAll();
//        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
//        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
//        CompOrganigramas actual=organigramasDao.findActivo();
//        Integer idActual=actual.getId();
//        listaPares=organigramasDao.findPares(idActual);
//        listaSuperiores=organigramasDao.findSuperiores(idActual);
//    	interno=false;
//    	dniEditar="";
//    	idEditar=-1;
//    	return "evaluadores";
//    }
    
    public String nuevoExterno() {
    	log.debug("Va a añadir evaluador externo con nombre "+nombre+" apellidos "+apellidos+" email "+email+" institucion "+institucion);
    	externosDao.insert(nombre,apellidos,email,institucion);
    	dniActual=user.getIdd();
    	trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaCompetencias=competenciasDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
        CompOrganigramas actual=organigramasDao.findActivo();
        Integer idActual=actual.getId();
        listaPares=organigramasDao.findPares(idActual);
        listaSuperiores=organigramasDao.findSuperiores(idActual);
    	//interno=false;
    	dniEditar="";
    	idEditar=-1;
    	return "evaluadores";
    }
    
    public String borrarEvaluadorExterno() {
    	log.debug("Va a borrar evaluador externo con id "+idRelacion);
    	dniActual=user.getIdd();
    	evaluadoresDao.deleteExterno(idRelacion);
    	trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaCompetencias=competenciasDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
        CompOrganigramas actual=organigramasDao.findActivo();
        Integer idActual=actual.getId();
        listaPares=organigramasDao.findPares(idActual);
        listaSuperiores=organigramasDao.findSuperiores(idActual);
    	//interno=true;
    	dniEditar="";
    	idEditar=-1;
    	return "evaluadores";
    }
    
    public String borrarEvaluadorInterno() {
    	log.debug("Va a borrar evaluador interno con id "+idRelacion);
    	dniActual=user.getIdd();
    	evaluadoresDao.deleteInterno(idRelacion);
    	trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaCompetencias=competenciasDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
        CompOrganigramas actual=organigramasDao.findActivo();
        Integer idActual=actual.getId();
        listaPares=organigramasDao.findPares(idActual);
        listaSuperiores=organigramasDao.findSuperiores(idActual);
        dniEditar="";
        idEditar=-1;
    	//interno=true;
    	return "evaluadores";
    }
    
    public String editarEvaluadorInterno() {
    	//dniEvaluador
    	dniActual=user.getIdd();
    	trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaCompetencias=competenciasDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
        CompOrganigramas actual=organigramasDao.findActivo();
        Integer idActual=actual.getId();
        listaPares=organigramasDao.findPares(idActual);
        listaSuperiores=organigramasDao.findSuperiores(idActual);
    	//interno=true;
    	dniEditar=dniEvaluador;
    	idEditar=-1;
    	log.debug("dniEditar: "+dniEditar+" dniEvaluador: "+dniEvaluador);
    	return "evaluadores";
    }
    
    public String editarEvaluadorExterno() {
    	//dniEvaluador
    	dniActual=user.getIdd();
    	trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaCompetencias=competenciasDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
        CompOrganigramas actual=organigramasDao.findActivo();
        Integer idActual=actual.getId();
        listaPares=organigramasDao.findPares(idActual);
        listaSuperiores=organigramasDao.findSuperiores(idActual);
    //	interno=true;
    	dniEditar="";
    	idEditar=idEvaluador;
    	log.debug("dniEditar: "+idEditar+" dniEvaluador: "+idEvaluador);
    	return "evaluadores";
    }
    
    public String guardarEvaluadorExterno() {
    	dniActual=user.getIdd();
    	log.debug("idRelacion: "+idRelacion+ " justificacion: "+ justificacion);
    	evaluadoresDao.editEvaluadorExterno(idRelacion,justificacion);
    	trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	listaCompetencias=competenciasDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
        CompOrganigramas actual=organigramasDao.findActivo();
        Integer idActual=actual.getId();
        listaPares=organigramasDao.findPares(idActual);
        listaSuperiores=organigramasDao.findSuperiores(idActual);
    //	interno=true;
    	dniEditar="";
    	idEditar=-1;
    	return "evaluadores";
    }
    
    public String guardarEvaluadorInterno() {
    	dniActual=user.getIdd();
    	log.debug("idRelacion: "+idRelacion+ " justificacion: "+ justificacion);
    	evaluadoresDao.editEvaluadorInterno(idRelacion,justificacion);
    	trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	listaCompetencias=competenciasDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
        evaluadoresExternos=evaluadoresDao.findAllExternos(dniActual);
        evaluadoresInternos=evaluadoresDao.findAllInternos(dniActual);
        CompOrganigramas actual=organigramasDao.findActivo();
        Integer idActual=actual.getId();
        listaPares=organigramasDao.findPares(idActual);
        listaSuperiores=organigramasDao.findSuperiores(idActual);
  //  	interno=true;
    	dniEditar="";
    	idEditar=-1;
    	return "evaluadores";
    }

//	public Boolean getInterno() {
//		return interno;
//	}
//
//	public void setInterno(Boolean interno) {
//		this.interno = interno;
//	}

	public CompTrabajadores getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(CompTrabajadores trabajador) {
		this.trabajador = trabajador;
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

	public List<CompExternos> getListaExternos() {
		return listaExternos;
	}

	public void setListaExternos(List<CompExternos> listaExternos) {
		this.listaExternos = listaExternos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public Integer getGrupo() {
		return grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public String getComp0() {
		return comp0;
	}

	public void setComp0(String comp0) {
		this.comp0 = comp0;
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

	public String getDniEvaluador() {
		return dniEvaluador;
	}

	public void setDniEvaluador(String dniEvaluador) {
		this.dniEvaluador = dniEvaluador;
	}

	public Integer getIdEvaluador() {
		return idEvaluador;
	}

	public void setIdEvaluador(Integer idEvaluador) {
		this.idEvaluador = idEvaluador;
	}

	public List<CompEvaluadorExterno> getEvaluadoresExternos() {
		return evaluadoresExternos;
	}

	public void setEvaluadoresExternos(List<CompEvaluadorExterno> evaluadoresExternos) {
		this.evaluadoresExternos = evaluadoresExternos;
	}

	public List<CompEvaluadorInterno> getEvaluadoresInternos() {
		return evaluadoresInternos;
	}

	public void setEvaluadoresInternos(List<CompEvaluadorInterno> evaluadoresInternos) {
		this.evaluadoresInternos = evaluadoresInternos;
	}

	public String getDniActual() {
		return dniActual;
	}

	public void setDniActual(String dniActual) {
		this.dniActual = dniActual;
	}

	public Integer getIdRelacion() {
		return idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public String getDniEditar() {
		return dniEditar;
	}

	public void setDniEditar(String dniEditar) {
		this.dniEditar = dniEditar;
	}

	public Integer getIdEditar() {
		return idEditar;
	}

	public void setIdEditar(Integer idEditar) {
		this.idEditar = idEditar;
	}

	public List<CompPares> getListaPares() {
		return listaPares;
	}

	public void setListaPares(List<CompPares> listaPares) {
		this.listaPares = listaPares;
	}

	public List<CompSuperiores> getListaSuperiores() {
		return listaSuperiores;
	}

	public void setListaSuperiores(List<CompSuperiores> listaSuperiores) {
		this.listaSuperiores = listaSuperiores;
	}

	public List<CompCompetencias> getListaCompetencias() {
		return listaCompetencias;
	}

	public void setListaCompetencias(List<CompCompetencias> listaCompetencias) {
		this.listaCompetencias = listaCompetencias;
	}



}
