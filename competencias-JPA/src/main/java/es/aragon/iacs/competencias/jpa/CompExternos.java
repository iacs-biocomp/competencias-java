package es.aragon.iacs.competencias.jpa;


import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="comp_externos")
@NamedQueries({
	@NamedQuery(name="CompExternos.findAll", query="SELECT c FROM CompExternos c"),
	@NamedQuery(name="CompExternos.findByDni", query="SELECT c FROM CompExternos c WHERE c.dni=:dni")
})

public class CompExternos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;
	private String apellidos;
	private String email;
	private String instituciones;
	private Boolean posiblesuperior;
	private String dni;



	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public CompExternos() {
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
	
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getInstituciones() {
		return this.instituciones;
	}

	public void setInstituciones(String instituciones) {
		this.instituciones = instituciones;
	}
	
	public Boolean getPosiblesuperior() {
		return this.posiblesuperior;
	}

	public void setPosiblesuperior(Boolean posiblesuperior) {
		this.posiblesuperior = posiblesuperior;
	}
	
}

