
package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="comp_valoraciones")
@NamedQueries({
	@NamedQuery(name="CompValoraciones.findAll", query="SELECT c FROM CompValoraciones c ORDER BY c.id DESC"),
	@NamedQuery(name="CompValoraciones.findById", query="SELECT c FROM CompValoraciones c WHERE c.id=:id"),
	@NamedQuery(name="CompValoraciones.findValoracion", query="SELECT c FROM CompValoraciones c WHERE c.idevaluacion=:idevaluacion AND dnievaluador=:dnievaluador AND dnievaluado=:dnievaluado AND idcomp=:idcomp AND idnivel=:idnivel AND codcomp=:codcomp"),
	@NamedQuery(name="CompValoraciones.findByIdEvaluacion", query="SELECT c FROM CompValoraciones c WHERE c.idevaluacion=:idevaluacion"),
	@NamedQuery(name="CompValoraciones.findByIdcomp", query="SELECT c FROM CompValoraciones c WHERE c.idcomp=:idcomp"),
	@NamedQuery(name="CompValoraciones.findByCodcomp", query="SELECT c FROM CompValoraciones c WHERE c.codcomp=:codcomp"),
	@NamedQuery(name="CompValoraciones.findByIdNivel", query="SELECT c FROM CompValoraciones c WHERE c.idnivel=:idnivel"),
	@NamedQuery(name="CompValoraciones.findByRelacion", query="SELECT c FROM CompValoraciones c WHERE c.codcomp=:codcomp AND c.idevaluacion=:idevaluacion"),
	@NamedQuery(name="CompValoraciones.findByRelacionComportamientos", query="SELECT c FROM CompValoraciones c WHERE c.codcomp=:codcomp AND c.idevaluacion=:idevaluacion AND idnivel=:idnivel AND idcomp=:idcomp")
})
public class CompValoraciones implements Serializable{
	@Id
	@SequenceGenerator(name="comp_valoraciones_id_seq", sequenceName="comp_valoraciones_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_valoraciones_id_seq")
	private Integer id;
	private Integer idevaluacion;
	private String dnievaluador;
	private String dnievaluado;
	private Integer idcomp;
	private String codcomp;
	private Integer idnivel;
	private Integer valoracion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdevaluacion() {
		return idevaluacion;
	}
	public void setIdevaluacion(Integer idevaluacion) {
		this.idevaluacion = idevaluacion;
	}
	public String getDnievaluador() {
		return dnievaluador;
	}
	public void setDnievaluador(String dnievaluador) {
		this.dnievaluador = dnievaluador;
	}
	public String getDnievaluado() {
		return dnievaluado;
	}
	public void setDnievaluado(String dnievaluado) {
		this.dnievaluado = dnievaluado;
	}
	public Integer getValoracion() {
		return valoracion;
	}
	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}
	public Integer getIdcomp() {
		return idcomp;
	}
	public void setIdcomp(Integer idcomp) {
		this.idcomp = idcomp;
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
	
}

