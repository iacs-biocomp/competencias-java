package es.aragon.iacs.competencias.action;

import java.util.List;

import javax.ejb.EJB;

import es.aragon.iacs.competencias.dao.ICompCompetenciasDAO;
import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.iacs.competencias.jpa.CompObjetivosCompCatcomp;
import es.aragon.iacs.competencias.jpa.CompExternos;
import es.aragon.iacs.competencias.dao.ICompExternosDAO;

//import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
//import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.midas.action.MidasActionSupport;

public class EvaluadoresAction extends MidasActionSupport{
    private static final long serialVersionUID = 2108264332221967943L;
    @EJB(name="CompCompetenciasDAO")
    private ICompCompetenciasDAO competenciasDao;
    private Boolean interno;
    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
    private CompTrabajadores trabajador;
    private List<CompObjetivosCompCatcomp> compObjCompCatcomp;
    
    private List<CompTrabajadores> listaTrabajadores;
    
    @EJB(name="CompExternosDAO")
    private ICompExternosDAO externosDao;
    private List<CompExternos> listaExternos;
//    private Boolean externo;
    
    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }
    

    /**
     * Muestra la lista de pruebas
     * @return
     */
    public String mis() {
//    	String dni=user.getIdd();
//    	trabajador=trabajadoresDao.trabajador(dni);
//        log.debug("Devolviendo lista de pruebas: " + listaTrabajadores.size());
    	
    	
    	String dni=user.getIdd();
    	trabajador=trabajadoresDao.trabajador(dni);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
    	interno=true;
        return "evaluadores"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado

    }
    
    public String nuevaPropuestaInterno() {
    	log.debug("Nueva propuesta de tipo interno ");
    	String dni=user.getIdd();
    	trabajador=trabajadoresDao.trabajador(dni);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
    	
    	interno=true;
    	return "evaluadores";
    }

    public String nuevaPropuestaExterno() {
    	log.debug("Nueva propuesta de tipo externo ");
    	String dni=user.getIdd();
    	trabajador=trabajadoresDao.trabajador(dni);
    	String catCompetencial=trabajador.getCatcompetencial();
    	compObjCompCatcomp=competenciasDao.compPorCatComp(catCompetencial);
    	log.debug("CompObjCompCatcomp: "+compObjCompCatcomp.size()+compObjCompCatcomp);
    	listaTrabajadores = trabajadoresDao.findAll();
        listaExternos = externosDao.findAll();
    	interno=false;
    	return "evaluadores";
    }

	public Boolean getInterno() {
		return interno;
	}

	public void setInterno(Boolean interno) {
		this.interno = interno;
	}

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
    
}
