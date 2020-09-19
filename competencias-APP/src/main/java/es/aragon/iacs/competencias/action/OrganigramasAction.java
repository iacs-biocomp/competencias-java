package es.aragon.iacs.competencias.action;

import java.util.List;

import javax.ejb.EJB;

import es.aragon.iacs.competencias.dao.ICompExternosDAO;
import es.aragon.iacs.competencias.dao.ICompOrganigramasDAO;
import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
import es.aragon.iacs.competencias.jpa.CompExternos;
import es.aragon.iacs.competencias.jpa.CompOrganigramas;
import es.aragon.iacs.competencias.jpa.CompPares;
import es.aragon.iacs.competencias.jpa.CompSuperiores;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.midas.action.MidasActionSupport;

public class OrganigramasAction extends MidasActionSupport{
	private static final long serialVersionUID = 2108264332221967943L;
    @EJB(name="CompOrganigramasDAO")
    private ICompOrganigramasDAO organigramasDao;
    
    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
    
    @EJB(name="CompExternosDAO")
    private ICompExternosDAO externosDao;
    
	private List<CompOrganigramas> listaOrganigramas;
	private List<CompPares> listaPares;
	private List<CompSuperiores> listaSuperiores;
	private List<CompTrabajadores> listaTrabajadores;
	private List<CompExternos> listaExternos;
	
	private Integer idOrganigrama;
	private String dniTrabajador;
	private String dniSuperior;
	private String dniPar;
	
	private Integer idRelacion;
	
    public List<CompOrganigramas> getListaOrganigramas() {
		return listaOrganigramas;
	}

	public void setListaOrganigramas(List<CompOrganigramas> listaOrganigramas) {
		this.listaOrganigramas = listaOrganigramas;
	}

	{
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }

    public String todos() {
        listaOrganigramas = organigramasDao.findAll();
//        log.debug("Devolviendo lista de pruebas: " + listaNiveles.size());
//        editar=false;
        return "organigramas"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String concreto() {
    	log.debug("Buscando lista de pares y superiores con id: " + idOrganigrama);
    	listaPares=organigramasDao.findPares(idOrganigrama);
    	listaSuperiores=organigramasDao.findSuperiores(idOrganigrama);
    	listaTrabajadores=trabajadoresDao.findAll();
    	listaExternos=externosDao.findAll();
    	log.debug("Devolviendo lista de pares: " + listaPares.size()+ listaPares);
    	log.debug("Devolviendo lista de superiores: " + listaSuperiores.size()+ listaSuperiores);
        return "organigramaConcreto"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String nuevoSuperior() {
    	if (idOrganigrama!=null && dniSuperior!=null && dniTrabajador!=null) {
    		organigramasDao.insertSuperior(idOrganigrama,dniTrabajador,dniSuperior);
    		log.debug("Se ha insertado superior: id:" +idOrganigrama+" superior "+dniSuperior+" trabajador "+dniTrabajador);
    	}
//      editar=false;
//  	log.debug("Buscando lista de pares y superiores con id: " + id);
  	listaPares=organigramasDao.findPares(idOrganigrama);
  	listaSuperiores=organigramasDao.findSuperiores(idOrganigrama);
  	listaTrabajadores=trabajadoresDao.findAll();
  	listaExternos=externosDao.findAll();
//  	log.debug("Devolviendo lista de pares: " + listaPares.size()+ listaPares);
//  	
      return "organigramaConcreto"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
  }
    
    public String nuevoPar() {
    	log.debug("Se va a insertar par: id:" +idOrganigrama+" par "+dniPar+" trabajador "+dniTrabajador);
    	if (idOrganigrama!=null && dniTrabajador!=null && dniPar!=null) {
    		organigramasDao.insertPar(idOrganigrama,dniTrabajador,dniPar);
    		log.debug("Se ha insertado par: id:" +idOrganigrama+" par "+dniPar+" trabajador "+dniTrabajador);
    	}
      	listaPares=organigramasDao.findPares(idOrganigrama);
      	listaSuperiores=organigramasDao.findSuperiores(idOrganigrama);
      	listaTrabajadores=trabajadoresDao.findAll();
      	listaExternos=externosDao.findAll();
      return "organigramaConcreto"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
  }
    
    public String borrarSuperior() {
    	log.debug("Se va a eliminar superior: id:" +idRelacion);
    	if (idRelacion!=null) {
    		idOrganigrama=organigramasDao.getIdOrganigramaSuperior(idRelacion);
    		organigramasDao.deleteSuperior(idRelacion);
    		log.debug("Se ha eliminado superior: id:" +idRelacion+" del organigrama con id:"+idOrganigrama);
    	}
    	listaPares=organigramasDao.findPares(idOrganigrama);
      	listaSuperiores=organigramasDao.findSuperiores(idOrganigrama);
      	listaTrabajadores=trabajadoresDao.findAll();
      	listaExternos=externosDao.findAll();
      return "organigramaConcreto"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
  }
    
    public String borrarPar() {
    	log.debug("Se va a eliminar par: id:" +idRelacion);
    	if (idRelacion!=null) {
    		idOrganigrama=organigramasDao.getIdOrganigramaPar(idRelacion);
    		organigramasDao.deletePar(idRelacion);
    		log.debug("Se ha eliminado par: id:" +idRelacion+" del organigrama con id:"+idOrganigrama);
    	}
    	listaPares=organigramasDao.findPares(idOrganigrama);
      	listaSuperiores=organigramasDao.findSuperiores(idOrganigrama);
      	listaTrabajadores=trabajadoresDao.findAll();
      	listaExternos=externosDao.findAll();
      return "organigramaConcreto"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
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

	public Integer getIdOrganigrama() {
		return idOrganigrama;
	}

	public void setIdOrganigrama(Integer idOrganigrama) {
		this.idOrganigrama = idOrganigrama;
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

	public String getDniTrabajador() {
		return dniTrabajador;
	}

	public void setDniTrabajador(String dniTrabajador) {
		this.dniTrabajador = dniTrabajador;
	}

	public String getDniSuperior() {
		return dniSuperior;
	}

	public void setDniSuperior(String dniSuperior) {
		this.dniSuperior = dniSuperior;
	}

	public String getDniPar() {
		return dniPar;
	}

	public void setDniPar(String dniPar) {
		this.dniPar = dniPar;
	}


	public Integer getIdRelacion() {
		return idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}
    

}
