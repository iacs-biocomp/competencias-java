<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<style type="text/css">

	.col-center{
	  float: none;
	  margin-left: auto;
	  margin-right: auto;
	}

</style>


<s:iterator value="datos">
	<div class="col-md-12 col-center"> 
		<div class="panel panel-default">
			<div class="panel-heading clearfix"> 
				<h1>Mis Datos</h1>		 
			</div> 
			<div class="panel-body"> 
<%-- 				<p><strong>Código: </strong><s:property value="codigo"/></p> --%>
<%-- 				<p><strong>Nombre: </strong><s:property value="nombre"/></p>  --%>
<%-- 				<p><strong>Apellidos: </strong><s:property value="apellidos"/></p>  --%>
<%-- 				<p><strong>Categoría profesional contractual: </strong><s:property value="catcontractual"/></p>  --%>
<%-- 				<p><strong>Categoría competencial: </strong><s:property value="catcompetencial"/></p>  --%>
<%-- 				<p><strong>Área: </strong><s:property value="area"/></p>  --%>
<%-- 				<p><strong>Unidad: </strong><s:property value="unidad"/></p>  --%>
<%-- 				<p><strong>Departamento: </strong><s:property value="departamento"/></p>  --%>
<%-- 				<p><strong>Fecha de antigüedad: </strong><s:property value="antiguedad"/></p>  --%>
<%-- 				<p><strong>DNI: </strong><s:property value="dni"/></p>  --%>
					<s:if test="%{codigo != null && codigo != \"\"}">
					<h5><label class="col-sm-4 control-label">Codigo:</label>  <s:property value="codigo"/></h5>
				</s:if>
				<s:if test="%{nombre != null && nombre != \"\"}">
					<h5><label class="col-sm-4 control-label">Nombre:</label>  <s:property value="nombre"/></h5>
				</s:if>
				<s:if test="%{apellidos != null && apellidos != \"\"}">
					<h5><label class="col-sm-4 control-label">Apellidos:</label>  <s:property value="apellidos"/></h5>
				</s:if>
				<s:if test="%{catcontractual != null && catcontractual != \"\"}">
					<h5><label class="col-sm-4 control-label">Categoría profesional contractual:</label>  <s:property value="catcontractual"/></h5>
				</s:if>
				<s:if test="%{catcompetencial != null && catcompetencial != \"\"}">
					<s:iterator value="catCompetenciales" var="cat">
			   			<s:if test="%{#cat.codigo == catcompetencial}">
							<h5><label class="col-sm-4 control-label">Categoría competencial:</label>  <s:property value="catcompetencial"/>- <s:property value="#cat.nombre"/></h5>
						</s:if>
					</s:iterator>
				</s:if>
				<s:if test="%{area != null && area != \"\"}">
					<h5><label class="col-sm-4 control-label">Área:</label>  <s:property value="area"/></h5>
				</s:if>
				<s:if test="%{unidad != null && unidad != \"\"}">
					<h5><label class="col-sm-4 control-label">Unidad:</label>  <s:property value="unidad"/></h5>
				</s:if>
				<s:if test="%{departamento != null  && departamento != \"\"}">
					<h5><label class="col-sm-4 control-label">Departamento:</label>  <s:property value="departamento"/></h5>
				</s:if>
				<s:if test="%{antiguedad != null && antiguedad != \"\"}">
					<h5><label class="col-sm-4 control-label">Fecha de antigüedad:</label>  <s:property value="antiguedad"/></h5>
				</s:if>
				<s:if test="%{dni != null && dni != \"\"}">
					<h5><label class="col-sm-4 control-label">DNI:</label>  <s:property value="dni"/></h5>
				</s:if>

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