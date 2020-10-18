package es.aragon.iacs.competencias.action;

import java.util.List;
import es.aragon.iacs.competencias.jpa.CompPares;
import es.aragon.iacs.competencias.jpa.CompSuperiores;
import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.iacs.competencias.jpa.CompExternos;
import es.aragon.iacs.competencias.jpa.CompEvaluadorExterno;
import es.aragon.iacs.competencias.jpa.CompEvaluadorInterno;
import es.aragon.iacs.competencias.jpa.CompOrganigramas;

import es.aragon.iacs.competencias.dao.ICompOrganigramasDAO;
import es.aragon.iacs.competencias.dao.ICompCompetenciasDAO;
import es.aragon.iacs.competencias.dao.ICompExternosDAO;
import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
import es.aragon.iacs.competencias.dao.ICompEvaluadoresDAO;

import javax.ejb.EJB;

//import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
//import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.midas.action.MidasActionSupport;

public class SupervisadosAction extends MidasActionSupport{
    private static final long serialVersionUID = 2108264332221967943L;
    
    private List<CompCompetencias> listaCompetencias;
	private List<CompTrabajadores> listaTrabajadores;
//	private List<CompTrabajadores> posiblesSupervisados;
    private List<CompExternos> listaExternos;
    private List<CompPares> listaPares;
    private List<CompSuperiores> listaSuperiores;
    
    @EJB(name="CompCompetenciasDAO")
    private ICompCompetenciasDAO competenciasDao;
    @EJB(name="CompOrganigramasDAO")
    private ICompOrganigramasDAO organigramasDao;
    @EJB(name="CompExternosDAO")
    private ICompExternosDAO externosDao;
    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
    
    @EJB(name="CompEvaluadoresDAO")
    private ICompEvaluadoresDAO evaluadoresDao;
    private List<CompEvaluadorExterno> evaluadoresExternos;
    private List<CompEvaluadorInterno> evaluadoresInternos;
    
    private String dniActual;
    private Integer idRelacion;
    
    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, seg�n interese la seguridad
    }
    

    

    /**
     * Muestra la lista de pruebas
     * @return
     */
    public String mis() {
//    	String dni=user.getIdd();
//    	trabajador=trabajadoresDao.trabajador(dni);
//        log.debug("Devolviendo lista de pruebas: " + listaTrabajadores.size());
    	
    	dniActual=user.getIdd();
    	//trabajador=trabajadoresDao.trabajador(dniActual);
//    	String catCompetencial=trabajador.getCatcompetencial();
//    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
//    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaCompetencias=competenciasDao.findAll();
//    	posiblesSupervisados = trabajadoresDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
       evaluadoresExternos=evaluadoresDao.externosFindAll();
       evaluadoresInternos=evaluadoresDao.internosFindAll();
//        log.debug("Externos"+dniActual+": "+evaluadoresExternos.size()+evaluadoresExternos);
        //DEBER�A PASARLE EL ID DE LA EVALUACION ACTUAL, LE PASO 4 DE MOMENTO
       CompOrganigramas actual=organigramasDao.findActivo();
       Integer idActual=actual.getId();
       listaPares=organigramasDao.findPares(idActual);
       listaSuperiores=organigramasDao.findSuperiores(idActual);
       
    	
        return "supervisados"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qu� visualizaci�n queremos como resultado

    }




    public String borrarEvaluadorExterno() {
    	log.debug("Va a borrar evaluador externo con id "+idRelacion);
    	dniActual=user.getIdd();
    	
    	evaluadoresDao.deleteExterno(idRelacion);
    	
    	
    	listaCompetencias=competenciasDao.findAll();
//    	posiblesSupervisados = trabajadoresDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
       evaluadoresExternos=evaluadoresDao.externosFindAll();
       evaluadoresInternos=evaluadoresDao.internosFindAll();
//        log.debug("Externos"+dniActual+": "+evaluadoresExternos.size()+evaluadoresExternos);
        //DEBER�A PASARLE EL ID DE LA EVALUACION ACTUAL, LE PASO 4 DE MOMENTO
       CompOrganigramas actual=organigramasDao.findActivo();
       Integer idActual=actual.getId();
       listaPares=organigramasDao.findPares(idActual);
       listaSuperiores=organigramasDao.findSuperiores(idActual);
       
    	return "supervisados";
    	
    	
    }
    
    public String borrarEvaluadorInterno() {
    	log.debug("Va a borrar evaluador interno con id "+idRelacion);
    	dniActual=user.getIdd();
    	
    	evaluadoresDao.deleteInterno(idRelacion);
    	
    	listaCompetencias=competenciasDao.findAll();
//    	posiblesSupervisados = trabajadoresDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
       evaluadoresExternos=evaluadoresDao.externosFindAll();
       evaluadoresInternos=evaluadoresDao.internosFindAll();
//        log.debug("Externos"+dniActual+": "+evaluadoresExternos.size()+evaluadoresExternos);
        //DEBER�A PASARLE EL ID DE LA EVALUACION ACTUAL, LE PASO 4 DE MOMENTO
       CompOrganigramas actual=organigramasDao.findActivo();
       Integer idActual=actual.getId();
       listaPares=organigramasDao.findPares(idActual);
       listaSuperiores=organigramasDao.findSuperiores(idActual);
       
    	return "supervisados";
    }
    

	public List<CompCompetencias> getListaCompetencias() {
		return listaCompetencias;
	}




	public void setListaCompetencias(List<CompCompetencias> listaCompetencias) {
		this.listaCompetencias = listaCompetencias;
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




	public String getDniActual() {
		return dniActual;
	}




	public void setDniActual(String dniActual) {
		this.dniActual = dniActual;
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




	public Integer getIdRelacion() {
		return idRelacion;
	}




	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}



//
//	public List<CompTrabajadores> getPosiblesSupervisados() {
//		return posiblesSupervisados;
//	}
//
//
//
//
//	public void setPosiblesSupervisados(List<CompTrabajadores> posiblesSupervisados) {
//		this.posiblesSupervisados = posiblesSupervisados;
//	}

    
}
