package es.aragon.iacs.competencias.jpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="comp_evaluaciones")
@NamedQueries({
	@NamedQuery(name="CompEvaluaciones.findAll", query="SELECT c FROM CompEvaluaciones c ORDER BY c.id DESC"),
	@NamedQuery(name="CompEvaluaciones.findById", query="SELECT c FROM CompEvaluaciones c WHERE c.id=:id")
})
public class CompEvaluaciones implements Serializable{
	
	@Id
	@SequenceGenerator(name="comp_evaluaciones_id_seq", sequenceName="comp_evaluaciones_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comp_evaluaciones_id_seq")
	private Integer id;
	private String nombre;
	private String iniaportacion;
	private String finaportacion;
	private String inivalidacion;
	private String finvalidacion;
	private String iniperiodo;
	private String finperiodo;
	private String inievaluacion;
	private String finevaluacion;
	private String catcompetencial;
//	private String trabajador;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIniaportacion() {
		return iniaportacion;
	}
	public void setIniaportacion(String iniaportacion) {
		this.iniaportacion = iniaportacion;
	}
	public String getFinaportacion() {
		return finaportacion;
	}
	public void setFinaportacion(String finaportacion) {
		this.finaportacion = finaportacion;
	}
	public String getInivalidacion() {
		return inivalidacion;
	}
	public void setInivalidacion(String inivalidacion) {
		this.inivalidacion = inivalidacion;
	}
	public String getFinvalidacion() {
		return finvalidacion;
	}
	public void setFinvalidacion(String finvalidacion) {
		this.finvalidacion = finvalidacion;
	}
	public String getIniperiodo() {
		return iniperiodo;
	}
	public void setIniperiodo(String iniperiodo) {
		this.iniperiodo = iniperiodo;
	}
	public String getFinperiodo() {
		return finperiodo;
	}
	public void setFinperiodo(String finperiodo) {
		this.finperiodo = finperiodo;
	}
	public String getInievaluacion() {
		return inievaluacion;
	}
	public void setInievaluacion(String inievaluacion) {
		this.inievaluacion = inievaluacion;
	}
	public String getFinevaluacion() {
		return finevaluacion;
	}
	public void setFinevaluacion(String finevaluacion) {
		this.finevaluacion = finevaluacion;
	}
	public String getCatcompetencial() {
		return catcompetencial;
	}
	public void setCatcompetencial(String catcompetencial) {
		this.catcompetencial = catcompetencial;
	}
//	public String getTrabajador() {
//		return trabajador;
//	}
//	public void setTrabajador(String trabajador) {
//		this.trabajador = trabajador;
//	}
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
	

}
