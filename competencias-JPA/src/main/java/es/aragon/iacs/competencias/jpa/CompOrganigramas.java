package es.aragon.iacs.competencias.jpa;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="comp_organigramas")
@NamedQueries({
	@NamedQuery(name="CompOrganigramas.findAll", query="SELECT c FROM CompOrganigramas c ORDER BY c.id"),
	@NamedQuery(name="CompOrganigramas.findById", query="SELECT c FROM CompOrganigramas c WHERE c.id=:id"),
	@NamedQuery(name="CompOrganigramas.findActivos", query="SELECT c FROM CompOrganigramas c WHERE c.fechaFin='' OR c.fechaFin=null OR c.fechaFin>=:fechaIni"),
	@NamedQuery(name="CompOrganigramas.findActivo", query="SELECT c FROM CompOrganigramas c WHERE c.fechaFin='' OR c.fechaFin=null OR c.fechaFin>=:fechaHoy")
})
public class CompOrganigramas implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="comp_organigramas_id_seq", sequenceName="comp_organigramas_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_organigramas_id_seq")
	private int id;
	private String nombre;
	private String fechaIni;
	private String fechaFin;
	
	public CompOrganigramas() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

	