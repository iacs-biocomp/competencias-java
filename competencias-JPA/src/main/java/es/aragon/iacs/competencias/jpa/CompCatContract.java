package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;

import javax.persistence.*;
/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="comp_cat_contractuales")
@NamedQueries({
	@NamedQuery(name="CompCatContract.findAll", query="SELECT c FROM CompCatContract c ORDER BY c.id"),
	@NamedQuery(name="CompCatContract.findById", query="SELECT c FROM CompCatContract c WHERE c.id=:id")
})
public class CompCatContract implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre;
	private String codcatcomp;

	public CompCatContract() {
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
	
	public String getCodCatComp() {
		return this.codcatcomp;
	}

	public void setCodCatComp(String codCatComp) {
		this.codcatcomp = codCatComp;
	}

	
}