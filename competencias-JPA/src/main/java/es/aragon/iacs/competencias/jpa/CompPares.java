package es.aragon.iacs.competencias.jpa;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="comp_pares")
@NamedQueries({
	@NamedQuery(name="CompPares.findAll", query="SELECT c FROM CompPares c ORDER BY c.id"),
	@NamedQuery(name="CompPares.findByOrganigrama", query="SELECT c FROM CompPares c WHERE c.idOrganigrama=:idOrganigrama ORDER BY c.id"),
	@NamedQuery(name="CompPares.findById", query="SELECT c FROM CompPares c WHERE c.id=:id"),
	@NamedQuery(name="CompPares.findPar", query="SELECT c FROM CompPares c WHERE c.idOrganigrama=:id AND c.dniTrabajador=:dniTrabajador AND dniPar=:dniPar")
})
public class CompPares implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="comp_pares_id_seq", sequenceName="comp_pares_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_pares_id_seq")
	private int id;
	private int idOrganigrama;
	private String dniTrabajador;
	private String dniPar;
	
	public CompPares() {
		
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

	public String getDniPar() {
		return dniPar;
	}

	public void setDniPar(String dniPar) {
		this.dniPar = dniPar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
