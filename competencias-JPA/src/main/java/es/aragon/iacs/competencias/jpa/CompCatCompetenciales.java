package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="comp_cat_competenciales")
@NamedQueries({
	@NamedQuery(name="CompCatCompetenciales.findAll", query="SELECT c FROM CompCatCompetenciales c ORDER BY c.codigo"),
	@NamedQuery(name="CompCatCompetenciales.findById", query="SELECT c FROM CompCatCompetenciales c WHERE c.codigo=:codigo")
})

public class CompCatCompetenciales implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codigo;

	private String nombre;
	private String alta;
	private String baja;

	public CompCatCompetenciales() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlta() {
		return alta;
	}

	public void setAlta(String alta) {
		this.alta = alta;
	}

	public String getBaja() {
		return baja;
	}

	public void setBaja(String baja) {
		this.baja = baja;
	}
	
}
