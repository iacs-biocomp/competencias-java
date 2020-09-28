package es.aragon.iacs.competencias.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	private CompOrganigramas organigramaActual;
	
	private Integer idOrganigrama;
	private String dniTrabajador;
	private String dniSuperior;
	private String dniPar;
	private String nombreOrganigrama;
	private String fechaIni;
	private String fechaFin;
	private String fechaActual;
	private boolean puedeEditar;
	
	private boolean editar;
	private Integer idEditar;
	
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
	
	private boolean puedeEditarF(String fechaFin) throws ParseException {
		//Compara fechaFin con fecha Actual y devuelve true si es mayor la fechaFin, es decir, puede editar el organigrama
		Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSistema=formateador.format(fechaActual);
        Date fechaDate1 = formateador.parse(fechaFin);
        Date fechaDate2 = formateador.parse(fechaSistema);
		if ( fechaDate1.before(fechaDate2) ){
		    return false;
		}else{
		     return true;
		    }
	}

    public String todos() {
        listaOrganigramas = organigramasDao.findAll();
//        log.debug("Devolviendo lista de pruebas: " + listaNiveles.size());
        editar=false;
        return "organigramas"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String nuevo(){
    	if ( nombreOrganigrama!=null ) {
    		organigramasDao.insertOrganigrama(nombreOrganigrama,fechaIni, fechaFin);
    		log.debug("Se ha insertado organigrama: nombre:" +nombreOrganigrama+" fechaIni "+fechaIni+" fechaFin "+fechaFin);
    	}
    	listaOrganigramas = organigramasDao.findAll();
    	editar=false;
     	return "organigramas"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
  }
    public String borrar(){
    	if (idOrganigrama!=null ) {
    		organigramasDao.deleteOrganigrama(idOrganigrama);
    		log.debug("Se ha eliminado organigrama: id:" +idOrganigrama);
    	}
    	listaOrganigramas = organigramasDao.findAll();
    	editar=false;
     	return "organigramas"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
  }
    public String editar(){
//    	if (idOrganigrama!=null && nombreOrganigrama!=null ) {
//    		organigramasDao.editOrganigrama(idOrganigrama, nombreOrganigrama,fechaIni, fechaFin);
//    		log.debug("Se ha editado organigrama: id: "+idOrganigrama+" nombre:" +nombreOrganigrama+" fechaIni "+fechaIni+" fechaFin "+fechaFin);
//    	}
    	listaOrganigramas = organigramasDao.findAll();
    	editar=true;
    	idEditar=idOrganigrama;
     	return "organigramas"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
  } 
    public String guardar(){
    	if (idOrganigrama!=null && nombreOrganigrama!=null ) {
    		organigramasDao.editOrganigrama(idOrganigrama, nombreOrganigrama,fechaIni, fechaFin);
    		log.debug("Se ha editado organigrama: id: "+idOrganigrama+" nombre:" +nombreOrganigrama+" fechaIni "+fechaIni+" fechaFin "+fechaFin);
    	}
    	listaOrganigramas = organigramasDao.findAll();
    	editar=false;
     	return "organigramas"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
  }
    
    public String concreto() throws ParseException {
    	log.debug("Buscando lista de pares y superiores con id: " + idOrganigrama);
    	organigramaActual=organigramasDao.findByIdOrganigrama(idOrganigrama);
    	fechaIni=organigramaActual.getFechaIni();
    	fechaFin=organigramaActual.getFechaFin();
    	if(fechaFin!=null && !fechaFin.equals("")) {
    		puedeEditar=puedeEditarF(fechaFin);
    	}
    	else {
    		puedeEditar=true;
    	}
    	listaPares=organigramasDao.findPares(idOrganigrama);
    	listaSuperiores=organigramasDao.findSuperiores(idOrganigrama);
    	listaTrabajadores=trabajadoresDao.findAll();
    	listaExternos=externosDao.findAll();
    	log.debug("Devolviendo lista de pares: " + listaPares.size()+ listaPares);
    	log.debug("Devolviendo lista de superiores: " + listaSuperiores.size()+ listaSuperiores);
        return "organigramaConcreto"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String nuevoSuperior() throws ParseException {
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
  	organigramaActual=organigramasDao.findByIdOrganigrama(idOrganigrama);
  	fechaIni=organigramaActual.getFechaIni();
	fechaFin=organigramaActual.getFechaFin();
	if(fechaFin!=null && !fechaFin.equals("")) {
		puedeEditar=puedeEditarF(fechaFin);
	}
	else {
		puedeEditar=true;
	}
//  	log.debug("Devolviendo lista de pares: " + listaPares.size()+ listaPares);
//  	
      return "organigramaConcreto"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
  }
    
    public String nuevoPar() throws ParseException {
    	log.debug("Se va a insertar par: id:" +idOrganigrama+" par "+dniPar+" trabajador "+dniTrabajador);
    	if (idOrganigrama!=null && dniTrabajador!=null && dniPar!=null) {
    		organigramasDao.insertPar(idOrganigrama,dniTrabajador,dniPar);
    		log.debug("Se ha insertado par: id:" +idOrganigrama+" par "+dniPar+" trabajador "+dniTrabajador);
    	}
      	listaPares=organigramasDao.findPares(idOrganigrama);
      	listaSuperiores=organigramasDao.findSuperiores(idOrganigrama);
      	listaTrabajadores=trabajadoresDao.findAll();
      	listaExternos=externosDao.findAll();
      	organigramaActual=organigramasDao.findByIdOrganigrama(idOrganigrama);
      	fechaIni=organigramaActual.getFechaIni();
    	fechaFin=organigramaActual.getFechaFin();
    	if(fechaFin!=null && !fechaFin.equals("")) {
    		puedeEditar=puedeEditarF(fechaFin);
    	}
    	else {
    		puedeEditar=true;
    	}
      return "organigramaConcreto"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
  }
    
    public String borrarSuperior() throws ParseException {
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
      	organigramaActual=organigramasDao.findByIdOrganigrama(idOrganigrama);
      	fechaIni=organigramaActual.getFechaIni();
    	fechaFin=organigramaActual.getFechaFin();
    	if(fechaFin!=null && !fechaFin.equals("")) {
    		puedeEditar=puedeEditarF(fechaFin);
    	}
    	else {
    		puedeEditar=true;
    	}
      return "organigramaConcreto"; // Este es el valor de retorno que struts.xml asocia a tiles.
                      // Sirve para indicar qué visualización queremos como resultado
  }
    
    public String borrarPar() throws ParseException {
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
      	organigramaActual=organigramasDao.findByIdOrganigrama(idOrganigrama);
      	fechaIni=organigramaActual.getFechaIni();
    	fechaFin=organigramaActual.getFechaFin();
    	if(fechaFin!=null && !fechaFin.equals("")) {
    		puedeEditar=puedeEditarF(fechaFin);
    	}
    	else {
    		puedeEditar=true;
    	}
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

	public CompOrganigramas getOrganigramaActual() {
		return organigramaActual;
	}

	public void setOrganigramaActual(CompOrganigramas organigramaActual) {
		this.organigramaActual = organigramaActual;
	}

	public String getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}

	public boolean isPuedeEditar() {
		return puedeEditar;
	}

	public void setPuedeEditar(boolean puedeEditar) {
		this.puedeEditar = puedeEditar;
	}

	public String getNombreOrganigrama() {
		return nombreOrganigrama;
	}

	public void setNombreOrganigrama(String nombreOrganigrama) {
		this.nombreOrganigrama = nombreOrganigrama;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public Integer getIdEditar() {
		return idEditar;
	}

	public void setIdEditar(Integer idEditar) {
		this.idEditar = idEditar;
	}
    

}
