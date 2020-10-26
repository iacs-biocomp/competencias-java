package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="comp_competencias")
@NamedQueries({
	@NamedQuery(name="CompCompetencias.findAll", query="SELECT c FROM CompCompetencias c ORDER BY c.descripcion"),
	@NamedQuery(name="CompCompetencias.findById", query="SELECT c FROM CompCompetencias c WHERE c.codigo=:codigo"),
	@NamedQuery(name="CompCompetencias.findActivas", query="SELECT c FROM CompCompetencias c WHERE c.baja=null OR c.baja='' OR c.baja>=:fechaHoy ORDER BY c.descripcion")
})
public class CompCompetencias implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codigo;

	private String descripcion;
	private String alta;
	private String baja;


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
