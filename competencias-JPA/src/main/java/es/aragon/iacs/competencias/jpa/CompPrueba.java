package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="comp_prueba")
@NamedQuery(name="CompPrueba.findAll", query="SELECT c FROM CompPrueba c ORDER BY c.id")
public class CompPrueba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;
	
	private String date;


	public CompPrueba() {
	}

	public Integer getId() {
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

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}