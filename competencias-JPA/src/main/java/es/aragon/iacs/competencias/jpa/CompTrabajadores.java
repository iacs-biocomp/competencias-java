package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the comp_prueba database table.
 * 
 */
@Entity
@Table(name="comp_trabajadores")
@NamedQueries({
	@NamedQuery(name="CompTrabajadores.findAll", query="SELECT c FROM CompTrabajadores c ORDER BY c.nombre"),
	@NamedQuery(name="CompTrabajadores.findByDni", query="SELECT c FROM CompTrabajadores c WHERE c.dni=:dni"),
	@NamedQuery(name="CompTrabajadores.findById", query="SELECT c FROM CompTrabajadores c WHERE c.dni=:dni"),
	@NamedQuery(name="CompTrabajadores.findByCatcomp", query="SELECT c FROM CompTrabajadores c WHERE c.catcompetencial=:catcompetencial ORDER BY c.nombre")
})
public class CompTrabajadores implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	private String nombre;
	private String apellidos;
	private String catcontractual;
	private String catcompetencial;
	private String area;
	private String unidad;
	private String departamento;
	private Date antiguedad;
	private String dni;


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public CompTrabajadores() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCatcontractual() {
		return this.catcontractual;
	}

	public void setCatcontractual(String catcontractual) {
		this.catcontractual = catcontractual;
	}
	
	public String getCatcompetencial() {
		return this.catcompetencial;
	}

	public void setCatcompetencial(String catcompetencial) {
		this.catcompetencial = catcompetencial;
	}
	
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Date getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}
	

}
