package es.aragon.iacs.competencias.jpa;
import javax.persistence.*;

@Entity
public class CompRelCompCompleto {
	@Id
	private Integer idRel;
	private String codcatcomp;
	private int idnivel;
	private String codcomp;
	private int idcomportamiento;
	private String descripcion;
	
	

	
	public CompRelCompCompleto() {
	}

	public CompRelCompCompleto(Integer id, String codcatcomp, int idnivel, String codcompetencia, int idcomportamiento,String descripcion) {
		this.idRel = id;
		this.codcatcomp=codcatcomp;
		this.idnivel=idnivel;
		this.codcomp=codcompetencia;
		this.idcomportamiento=idcomportamiento;
		this.descripcion=descripcion;
		
	}

	public Integer getIdRel() {
		return idRel;
	}

	public void setIdRel(Integer id) {
		this.idRel = id;
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

	public void setCodcomp(String codcompetencia) {
		this.codcomp = codcompetencia;
	}

	public int getIdcomportamiento() {
		return idcomportamiento;
	}

	public void setIdcomportamiento(int idcomportamiento) {
		this.idcomportamiento = idcomportamiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}


