package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="comp_relaciones_comportamientos")
@NamedQueries({
	@NamedQuery(name="CompRelacionesComportamientos.findAll", query="SELECT c FROM CompRelacionesComportamientos c"),
	@NamedQuery(name="CompRelacionesComportamientos.findById", query="SELECT c FROM CompRelacionesComportamientos c WHERE c.id=:id")
})
public class CompRelacionesComportamientos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String codcatcomp;
	private int idnivel;
	private String codcomp;
	private int idcomportamiento;
	
	public CompRelacionesComportamientos() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodcatcomp() {
		return codcatcomp;
	}

	public void setCodcatcomp(String codcatcomp) {
		this.codcatcomp = codcatcomp;
	}

	public int getIdnivel() {
		return idnivel;
	}

	public void setIdnivel(int idnivel) {
		this.idnivel = idnivel;
	}

	public String getCodcomp() {
		return codcomp;
	}

	public void setCodcomp(String codcomp) {
		this.codcomp = codcomp;
	}

	public int getIdcomportamiento() {
		return idcomportamiento;
	}

	public void setIdcomportamiento(int idcomportamiento) {
		this.idcomportamiento = idcomportamiento;
	}
	
}