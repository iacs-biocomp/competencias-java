<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>




<s:iterator value="datos">
<div class="col-md-6"> 
	<div class="panel panel-default">
		<div class="panel-heading clearfix"> 
			<h1>Mis Datos</h1>		 
		</div> 
		<div class="panel-body"> 
			<p><strong>Código: </strong><s:property value="codigo"/></p>
			<p><strong>Nombre: </strong><s:property value="nombre"/></p> 
			<p><strong>Apellidos: </strong><s:property value="apellidos"/></p> 
			<p><strong>Categoría profesional contractual: </strong><s:property value="catcontractual"/></p> 
			<p><strong>Categoría competencial: </strong><s:property value="catcompetencial"/></p> 
			<p><strong>Área: </strong><s:property value="area"/></p> 
			<p><strong>Unidad: </strong><s:property value="unidad"/></p> 
			<p><strong>Departamento: </strong><s:property value="departamento"/></p> 
			<p><strong>Fecha de antigüedad: </strong><s:property value="antiguedad"/></p> 
			<p><strong>DNI: </strong><s:property value="dni"/></p> 
		</div> 
	</div> 
</div>
</s:iterator>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
		<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
		<br></br>
	<br></br>
	<br></br>
	<br></br>