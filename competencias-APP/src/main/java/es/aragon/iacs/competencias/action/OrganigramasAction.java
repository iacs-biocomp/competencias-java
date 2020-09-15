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
	
	private Integer id;
	
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
//        listaNiveles = nivelesDao.findAll();
        
//        editar=false;
    	log.debug("Buscando lista de pares y superiores con id: " + id);
    	listaPares=organigramasDao.findPares(id);
    	listaSuperiores=organigramasDao.findSuperiores(id);
    	listaTrabajadores=trabajadoresDao.findAll();
    	listaExternos=externosDao.findAll();
    	log.debug("Devolviendo lista de pares: " + listaPares.size()+ listaPares);
    	log.debug("Devolviendo lista de superiores: " + listaSuperiores.size()+ listaSuperiores);
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
