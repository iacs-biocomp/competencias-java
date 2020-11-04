package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="comp_cat_competenciales")
@NamedQueries({
	@NamedQuery(name="CompCatCompetenciales.findAll", query="SELECT c FROM CompCatCompetenciales c ORDER BY c.codigo"),
	@NamedQuery(name="CompCatCompetenciales.findById", query="SELECT c FROM CompCatCompetenciales c WHERE c.codigo=:codigo"),
	@NamedQuery(name="CompCatCompetenciales.findActivas", query="SELECT c FROM CompCatCompetenciales c WHERE c.baja=null OR c.baja>=:fechaHoy ORDER BY c.codigo")
})

public class CompCatCompetenciales implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codigo;

	private String nombre;
	private Date alta;
	private Date baja;

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
