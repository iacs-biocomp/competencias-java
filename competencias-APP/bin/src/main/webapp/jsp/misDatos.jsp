<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Mis Datos</h1>

<s:iterator value="datos">
   <ul>
	<li type="disc"><strong>Código: </strong><s:property value="codigo"/></li>
	<li type="disc"><strong>Nombre: </strong><s:property value="nombre"/></li>
	<li type="disc"><strong>Apellidos: </strong><s:property value="apellidos"/></li>
	<li type="disc"><strong>Categoría profesional contractual: </strong><s:property value="catcontractual"/></li>
	<li type="disc"><strong>Categoría competencial: </strong><s:property value="catcompetencial"/></li>
	<li type="disc"><strong>Área: </strong><s:property value="area"/></li>
	<li type="disc"><strong>Unidad: </strong><s:property value="unidad"/></li>
	<li type="disc"><strong>Departamento: </strong><s:property value="departamento"/></li>
	<li type="disc"><strong>Fecha de antigüedad: </strong><s:property value="antiguedad"/></li>
	<li type="disc"><strong>DNI: </strong><s:property value="dni"/></li>
</ul>
   
</s:iterator>