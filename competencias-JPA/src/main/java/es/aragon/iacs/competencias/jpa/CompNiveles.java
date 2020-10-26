package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="comp_niveles")
@NamedQueries({
	@NamedQuery(name="CompNiveles.findAll", query="SELECT c FROM CompNiveles c ORDER BY c.nombre"),
	@NamedQuery(name="CompNiveles.findById", query="SELECT c FROM CompNiveles c WHERE c.id=:id"),
	@NamedQuery(name="CompNiveles.findByNombre", query="SELECT c FROM CompNiveles c WHERE c.nombre=:nombre")
})
public class CompNiveles implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="comp_niveles_id_seq", sequenceName="comp_niveles_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_niveles_id_seq")
	private int id;

	private String nombre;
	private float valorporcentual;
	private String alta;
	private String baja;


	public CompNiveles() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getValorporcentual() {
		return this.valorporcentual;
	}

	public void setValorporcentual(float valorporcentual) {
		this.valorporcentual = valorporcentual;
	}
	
	public String getAlta() {
		return this.alta;
	}

	public void setAlta(String alta) {
		this.alta = alta;
	}
	
	public String getBaja() {
		return this.baja;
	}

	public void setBaja(String baja) {
		this.baja = baja;
	}
}
