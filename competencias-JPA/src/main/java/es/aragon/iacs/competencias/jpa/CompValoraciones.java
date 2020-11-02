
package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="comp_valoraciones")
@NamedQueries({
	@NamedQuery(name="CompValoraciones.findAll", query="SELECT c FROM CompValoraciones c ORDER BY c.id DESC"),
	@NamedQuery(name="CompValoraciones.findById", query="SELECT c FROM CompValoraciones c WHERE c.id=:id"),
	@NamedQuery(name="CompValoraciones.findValoracion", query="SELECT c FROM CompValoraciones c WHERE c.idevaluacion=:idevaluacion AND dnievaluador=:dnievaluador AND dnievaluado=:dnievaluado AND idrelacion=:idrelacion"),
	@NamedQuery(name="CompValoraciones.findByIdEvaluacion", query="SELECT c FROM CompValoraciones c WHERE c.idevaluacion=:idevaluacion")
})
public class CompValoraciones implements Serializable{
	@Id
	@SequenceGenerator(name="comp_valoraciones_id_seq", sequenceName="comp_valoraciones_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_valoraciones_id_seq")
	private Integer id;
	private Integer idevaluacion;
	private String dnievaluador;
	private String dnievaluado;
	private Integer idrelacion;
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
	public Integer getIdrelacion() {
		return idrelacion;
	}
	public void setIdrelacion(Integer idrelacion) {
		this.idrelacion = idrelacion;
	}
	public Integer getValoracion() {
		return valoracion;
	}
	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}
	
}

