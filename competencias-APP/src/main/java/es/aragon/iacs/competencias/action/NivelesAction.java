package es.aragon.iacs.competencias.action;

import java.util.List;
import java.util.Date;
import javax.ejb.EJB;

import es.aragon.iacs.competencias.dao.ICompNivelesDAO;
import es.aragon.iacs.competencias.jpa.CompNiveles;
import es.aragon.midas.action.MidasActionSupport;

public class NivelesAction extends MidasActionSupport{
	private static final long serialVersionUID = 2108264332221967943L;
    @EJB(name="CompNivelesDAO")
    private ICompNivelesDAO nivelesDao;
    private Integer id;
    private String nombre;
    private float valorporcentual;
    private Date alta;
    

	private Date baja;
    
    private boolean editar;
    private Integer idEditar;

    private List<CompNiveles> listaNiveles;


    {
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }



    /**
     * Muestra la lista de pruebas
     * @return
     */
    public String list() {
        listaNiveles = nivelesDao.findAll();
        log.debug("Devolviendo lista de pruebas: " + listaNiveles.size());
        editar=false;
        return "niveles"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String borrar() {
    	//Buscar con findById(codigo); een el DAO. Puedo crear metodo en el DAO q elimine para poder usarlo varias veces (q le pase el codigo)
    	nivelesDao.delete(id);
    	editar=false;
    	listaNiveles = nivelesDao.findAll();
    	return "niveles";
    }
    
    public String nuevo() {
    	//NO COMPRUEBO SI VALORPORCENTUAL == NULL PORQ ME DICE Q !=NULL NO EXISTE PARA FLOAT NI DOUBLE
    	if (nombre !=null && alta != null) {
    		//PONER FORMATO DE DATE BUENO
    		log.debug("NIVEL: "+nombre+alta+baja);
    		nivelesDao.insert(nombre,valorporcentual,alta,baja);
    	}
    	editar=false;
    	listaNiveles = nivelesDao.findAll();
    	return "niveles";
    }
    
    public String editar() {
    	listaNiveles = nivelesDao.findAll();
    	editar=true;
    	idEditar=id;
    	return "niveles";
    }
    
    public String guardar() {

    	log.debug("Editando nivel con id="+id+" nombre=" + nombre +" valor porcentual: "+ valorporcentual+ " alta: "+ alta + " baja:" +baja);
    	nivelesDao.edit(id, nombre,valorporcentual, alta, baja);
    	log.debug("Editando nivel con id="+id+" nombre=" + nombre +" valor porcentual: "+ valorporcentual+ " alta: "+ alta + " baja:" +baja);
        editar=false;
        listaNiveles = nivelesDao.findAll();
    	return "niveles";
    }

    /**
     * Esta función "getter" es la que utilizará JSP para visualizar la
lista
     */
    public List<CompNiveles> getNiveles() {
        return listaNiveles;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getValorporcentual() {
		return valorporcentual;
	}

	public void setValorporcentual(float valorporcentual) {
		this.valorporcentual = valorporcentual;
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
