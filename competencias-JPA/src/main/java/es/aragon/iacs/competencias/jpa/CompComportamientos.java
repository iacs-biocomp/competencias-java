package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="comp_comportamientos")
@NamedQueries({
	@NamedQuery(name="CompComportamientos.findAll", query="SELECT c FROM CompComportamientos c ORDER BY c.descripcion"),
	@NamedQuery(name="CompComportamientos.findById", query="SELECT c FROM CompComportamientos c WHERE c.id=:id"),
	@NamedQuery(name="CompComportamientos.findActivos", query="SELECT c FROM CompComportamientos c WHERE c.baja=null OR c.baja>=:fechaHoy ORDER BY c.descripcion")
})
public class CompComportamientos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="comp_comportamientos_id_seq", sequenceName="comp_comportamientos_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_comportamientos_id_seq")
	private int id;

	private String descripcion;
	private Date alta;
	private Date baja;


	public CompComportamientos() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
