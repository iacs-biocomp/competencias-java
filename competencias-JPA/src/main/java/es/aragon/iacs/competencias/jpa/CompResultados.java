package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comp_resultados")
@NamedQueries({
	@NamedQuery(name="CompResultados.findAll", query="SELECT c FROM CompResultados c ORDER BY c.id DESC"),
	@NamedQuery(name="CompResultados.findResultado", query="SELECT c FROM CompResultados c WHERE dnievaluado=:dni AND grupoev=:grupoev AND codcomp=:codcomp AND idnivel=:idnivel AND idevaluacion=:idevaluacion"),
	@NamedQuery(name="CompResultados.findByEvaluacion", query="SELECT c FROM CompResultados c WHERE idevaluacion=:idevaluacion")
})
public class CompResultados implements Serializable{

	@Id
	@SequenceGenerator(name="comp_resultados_id_seq", sequenceName="comp_resultados_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_resultados_id_seq")
	private Integer id;
	private Integer idevaluacion;
	private String dnievaluado;
	private Integer grupoev;
	private String codcomp;
	private Integer idnivel;
	private float suma;
	private Integer numvaloraciones;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDnievaluado() {
		return dnievaluado;
	}
	public void setDnievaluado(String dnievaluado) {
		this.dnievaluado = dnievaluado;
	}
	public Integer getGrupoev() {
		return grupoev;
	}
	public void setGrupoev(Integer grupoev) {
		this.grupoev = grupoev;
	}
	public String getCodcomp() {
		return codcomp;
	}
	public void setCodcomp(String codcomp) {
		this.codcomp = codcomp;
	}
	public Integer getIdnivel() {
		return idnivel;
	}
	public void setIdnivel(Integer idnivel) {
		this.idnivel = idnivel;
	}
	public float getSuma() {
		return suma;
	}
	public void setSuma(float suma) {
		this.suma = suma;
	}
	public Integer getNumvaloraciones() {
		return numvaloraciones;
	}
	public void setNumvaloraciones(Integer numvaloraciones) {
		this.numvaloraciones = numvaloraciones;
	}
	public Integer getIdevaluacion() {
		return idevaluacion;
	}
	public void setIdevaluacion(Integer idevaluacion) {
		this.idevaluacion = idevaluacion;
	}
	
	
}

