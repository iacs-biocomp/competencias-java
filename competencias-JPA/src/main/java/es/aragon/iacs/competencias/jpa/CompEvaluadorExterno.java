package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="comp_evaluador_externo")
@NamedQueries({
	@NamedQuery(name="CompEvaluadorExterno.findAll", query="SELECT c FROM CompEvaluadorExterno c ORDER BY c.idrelacion"),
	@NamedQuery(name="CompEvaluadorExterno.findByEvaluacion", query="SELECT c FROM CompEvaluadorExterno c WHERE c.idevaluacion=:idevaluacion ORDER BY c.idrelacion"),
	@NamedQuery(name="CompEvaluadorExterno.findByDniTrabajador", query="SELECT c FROM CompEvaluadorExterno c WHERE c.dnitrabajador=:dnitrabajador ORDER BY c.idrelacion"),
	@NamedQuery(name="CompEvaluadorExterno.findById", query="SELECT c FROM CompEvaluadorExterno c WHERE c.idrelacion=:idrelacion"),
	@NamedQuery(name="CompEvaluadorExterno.findRelacion", query="SELECT c FROM CompEvaluadorExterno c WHERE c.idevaluacion=:idevaluacion AND c.idevaluador=:idevaluador AND c.dnitrabajador=:dnitrabajador")
})
public class CompEvaluadorExterno implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="comp_evaluador_externo_id_seq", sequenceName="comp_evaluador_externo_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_evaluador_externo_id_seq")
	private Integer idrelacion;
	private String dnitrabajador;
	private Integer idevaluador;
	private Integer idevaluacion;
	private Integer grupo;
	private String comp1;
	private String comp2;
	private String comp3;
	private String comp4;
	private String comp5;
	private String comp6;
	private String comp7;
	private String comp8;
	private String comp9;
	private String comp10;
	private String justificacion;
	private Boolean validado;
	
	public String getDnitrabajador() {
		return dnitrabajador;
	}
	public void setDnitrabajador(String dnitrabajador) {
		this.dnitrabajador = dnitrabajador;
	}

	public Integer getIdevaluacion() {
		return idevaluacion;
	}
	public void setIdevaluacion(Integer idevaluacion) {
		this.idevaluacion = idevaluacion;
	}
	public Integer getGrupo() {
		return grupo;
	}
	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}
	public String getComp1() {
		return comp1;
	}
	public void setComp1(String comp1) {
		this.comp1 = comp1;
	}
	public String getComp2() {
		return comp2;
	}
	public void setComp2(String comp2) {
		this.comp2 = comp2;
	}
	public String getComp3() {
		return comp3;
	}
	public void setComp3(String comp3) {
		this.comp3 = comp3;
	}
	public String getComp4() {
		return comp4;
	}
	public void setComp4(String comp4) {
		this.comp4 = comp4;
	}
	public String getComp5() {
		return comp5;
	}
	public void setComp5(String comp5) {
		this.comp5 = comp5;
	}
	public String getComp6() {
		return comp6;
	}
	public void setComp6(String comp6) {
		this.comp6 = comp6;
	}
	public String getComp7() {
		return comp7;
	}
	public void setComp7(String comp7) {
		this.comp7 = comp7;
	}
	public String getComp8() {
		return comp8;
	}
	public void setComp8(String comp8) {
		this.comp8 = comp8;
	}
	public String getComp9() {
		return comp9;
	}
	public void setComp9(String comp9) {
		this.comp9 = comp9;
	}
	public String getComp10() {
		return comp10;
	}
	public void setComp10(String comp10) {
		this.comp10 = comp10;
	}
	public String getJustificacion() {
		return justificacion;
	}
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	public Boolean getValidado() {
		return validado;
	}
	public void setValidado(Boolean validado) {
		this.validado = validado;
	}
	public Integer getIdevaluador() {
		return idevaluador;
	}
	public void setIdevaluador(Integer idevaluador) {
		this.idevaluador = idevaluador;
	}
	public Integer getIdrelacion() {
		return idrelacion;
	}
	public void setIdrelacion(Integer idrelacion) {
		this.idrelacion = idrelacion;
	}
}


