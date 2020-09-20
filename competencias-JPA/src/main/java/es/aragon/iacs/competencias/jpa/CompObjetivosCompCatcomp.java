package es.aragon.iacs.competencias.jpa;
import javax.persistence.*;

@Entity
public class CompObjetivosCompCatcomp{
	//private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String codcompetencia;
	private String descripcion;
	private String objetivo;
	private String codcatcomp;
	private String nombrecatcomp;


	public CompObjetivosCompCatcomp() {
	}

	public CompObjetivosCompCatcomp(Integer id, String codcompetencia, String descripcion, String objetivo, String codcatcomp,String nombrecatcomp) {
		this.id = id;
		this.codcompetencia = codcompetencia;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.codcatcomp = codcatcomp;
		this.nombrecatcomp = nombrecatcomp;
	}

	public String getCodcompetencia() {
		return codcompetencia;
	}


	public void setCodcompetencia(String codcompetencia) {
		this.codcompetencia = codcompetencia;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getObjetivo() {
		return objetivo;
	}


	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}


	public String getCodcatcomp() {
		return codcatcomp;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}