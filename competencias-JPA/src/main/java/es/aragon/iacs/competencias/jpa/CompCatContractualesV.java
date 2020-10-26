package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;

import javax.persistence.*;
/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="vista_cat_contractuales")
@NamedQueries({
	@NamedQuery(name="CompCatContractualesV.findAll", query="SELECT c FROM CompCatContractualesV c ORDER BY c.nombre"),
	@NamedQuery(name="CompCatContractualesV.findById", query="SELECT c FROM CompCatContractualesV c WHERE c.id=:id"),
	@NamedQuery(name="CompCatContractualesV.findByCatcontractual", query="SELECT c FROM CompCatContractualesV c WHERE c.nombre=:catcontractual")
})
public class CompCatContractualesV implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String nombre;
	private String codcatcomp;
	private String nombrecatcomp;

	public CompCatContractualesV() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCodcatcomp() {
		return this.codcatcomp;
	}

	public void setCodcatcomp(String codcatcomp) {
		this.codcatcomp = codcatcomp;
	}

	public String getNombrecatcomp() {
		return nombrecatcomp;
	}

	public void setNombrecatcomp(String nombrecatcomp) {
		this.nombrecatcomp = nombrecatcomp;
	}
	
}


