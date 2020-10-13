package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="comp_objetivos")
@NamedQueries({
	@NamedQuery(name="CompObjetivos.findAll", query="SELECT c FROM CompObjetivos c ORDER BY c.id"),
	@NamedQuery(name="CompObjetivos.findById", query="SELECT c FROM CompObjetivos c WHERE c.id=:id")
	
})
public class CompObjetivos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="comp_objetivos_id_seq", sequenceName="comp_objetivos_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_objetivos_id_seq")
	private int id;
	private String codcompetencia;
	private String codcatcomp;
	private int idnivel;
	
	public CompObjetivos() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodcompetencia() {
		return codcompetencia;
	}
	public void setCodcompetencia(String codcompetencia) {
		this.codcompetencia = codcompetencia;
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

}
