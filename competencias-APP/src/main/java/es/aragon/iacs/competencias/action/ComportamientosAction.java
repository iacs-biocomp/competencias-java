package es.aragon.iacs.competencias.action;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import es.aragon.iacs.competencias.dao.ICompComportamientosDAO;
import es.aragon.iacs.competencias.jpa.CompComportamientos;
import es.aragon.midas.action.MidasActionSupport;

public class ComportamientosAction extends MidasActionSupport{
	private static final long serialVersionUID = 2108264332221967943L;
    @EJB(name="CompComportamientosDAO")
    private ICompComportamientosDAO comportamientosDao;
    private Integer id;
    private String descripcion;
    private Date alta;
    private Date baja;
    
    private boolean editar;
    private Integer idEditar;

    private List<CompComportamientos> listaComportamientos;


    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }



    /**
     * Muestra la lista de pruebas
     * @return
     */
    public String list() {
        listaComportamientos = comportamientosDao.findAll();
        log.debug("Devolviendo lista de pruebas: " + listaComportamientos.size());
        editar=false;
        return "comportamientos"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado

    }
    
    public String borrar() {
    	//Buscar con findById(codigo); een el DAO. Puedo crear metodo en el DAO q elimine para poder usarlo varias veces (q le pase el codigo)
    	comportamientosDao.delete(id);
    	listaComportamientos = comportamientosDao.findAll();
    	editar=false;
    	return "comportamientos";
    }
    
    public String nuevo() {
    	log.debug("VA A INSERTAR COMPORTAMIENTO: "+ descripcion + " "+alta+" "+baja);
    	if (descripcion !=null && alta != null) {
    		comportamientosDao.insert(descripcion,alta,baja);
    	}
    	listaComportamientos = comportamientosDao.findAll();
    	editar=false;
    	return "comportamientos";
    }

    public String editar() {
    	listaComportamientos = comportamientosDao.findAll();
    	editar=true;
    	idEditar=id;
    	return "comportamientos";
    }
    
    public String guardar() {

    	log.debug("Editando comportamiento con id="+id+" descripcion=" + descripcion +"alta: "+ alta + " baja:" +baja);
    	comportamientosDao.edit(id, descripcion, alta, baja);
    	log.debug("Editando competencia con id="+id+" descripcion=" + descripcion +"alta: "+ alta + " baja:" +baja);
        editar=false;
        listaComportamientos = comportamientosDao.findAll();
    	return "comportamientos";
    }
    
    /**
     * Esta función "getter" es la que utilizará JSP para visualizar la
lista
     */
    public List<CompComportamientos> getComportamientos() {
        return listaComportamientos;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public Date getBaja() {
		return baja;
	}

	public void setBaja(Date baja) {
		this.baja = baja;
	}


}
