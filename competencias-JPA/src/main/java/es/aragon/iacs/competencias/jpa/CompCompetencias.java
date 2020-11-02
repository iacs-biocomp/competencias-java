package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="comp_competencias")
@NamedQueries({
	@NamedQuery(name="CompCompetencias.findAll", query="SELECT c FROM CompCompetencias c ORDER BY c.codigo"),
	@NamedQuery(name="CompCompetencias.findById", query="SELECT c FROM CompCompetencias c WHERE c.codigo=:codigo"),
	@NamedQuery(name="CompCompetencias.findActivas", query="SELECT c FROM CompCompetencias c WHERE c.baja=null OR c.baja='' OR c.baja>=:fechaHoy ORDER BY c.codigo")
})
public class CompCompetencias implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codigo;

	private String descripcion;
	private Date alta;
	private Date baja;


	public CompCompetencias() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
