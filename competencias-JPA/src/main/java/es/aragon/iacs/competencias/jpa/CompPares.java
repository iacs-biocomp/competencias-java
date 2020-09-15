package es.aragon.iacs.competencias.jpa;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="comp_pares")
@NamedQueries({
	@NamedQuery(name="CompPares.findAll", query="SELECT c FROM CompPares c"),
	@NamedQuery(name="CompPares.findByOrganigrama", query="SELECT c FROM CompPares c WHERE c.idOrganigrama=:idOrganigrama")
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
	
}
