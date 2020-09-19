package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="comp_superiores")
@NamedQueries({
	@NamedQuery(name="CompSuperiores.findAll", query="SELECT c FROM CompSuperiores c"),
	@NamedQuery(name="CompSuperiores.findByOrganigrama", query="SELECT c FROM CompSuperiores c WHERE c.idOrganigrama=:idOrganigrama"),
	@NamedQuery(name="CompSuperiores.findById", query="SELECT c FROM CompSuperiores c WHERE c.id=:id")
})
public class CompSuperiores implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="comp_superiores_id_seq", sequenceName="comp_superiores_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_superiores_id_seq")
	private int id;
	private int idOrganigrama;
	private String dniTrabajador;
	private String dniSuperior;
	
	public CompSuperiores() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdOrganigrama() {
		return idOrganigrama;
	}

	public void setIdOrganigrama(int idOrganigrama) {
		this.idOrganigrama = idOrganigrama;
	}

	public String getDniTrabajador() {
		return dniTrabajador;
	}

	public void setDniTrabajador(String dniTrabajador) {
		this.dniTrabajador = dniTrabajador;
	}

	public String getDniSuperior() {
		return dniSuperior;
	}

	public void setDniSuperior(String dniSuperior) {
		this.dniSuperior = dniSuperior;
	}
}




