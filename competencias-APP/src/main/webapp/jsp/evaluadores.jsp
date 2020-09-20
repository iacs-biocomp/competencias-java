<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1> Mis evaluadores</h1>

<h2> Autoevaluación </h2>

<h2> Personas que me organizan el trabajo </h2>

<h2> Personas a las que organizo el trabajo </h2>

<h2> Personas que trabajan conmigo </h2>

<h2> Personas a las que entrego mi trabajo </h2>

<%-- <s:iterator value="listaTrabajadores"> --%>
<%-- <h2> <s:property value="nombre"/>  <s:property value="apellidos"/></h2> --%>
<!-- 	<h3> Superiores  </h3>  -->
<%-- 		<s:if test="%{puedeEditar == true}"> --%>
<!-- 			<form action="/nuevoSuperiorOrganigramas" method="post"> -->
<%-- 			    <input type="hidden" id="idOrganigrama" name="idOrganigrama" value="<s:property value="idOrganigrama"/>"> --%>
<%-- 			    <input type="hidden" id="dniTrabajador" name="dniTrabajador" value="<s:property value="dni"/>" > --%>
<!-- 			    <label for="dniSuperior">DNI superior:</label> -->
<!-- 				<input type="text" id="dniSuperior" name="dniSuperior" required> -->
<!-- 			  <input type="submit" value="Nuevo superior"> -->
<!-- 			</form> -->
<%-- 		</s:if> --%>
<!-- 		<table class="table"> -->
<!-- 		   <thead> -->
<!-- 		     <tr> -->
<!-- 		     	<th scope="col"></th> -->
<!-- 		       <th scope="col">DNI Superior</th> -->
<!-- 		       <th scope="col">Nombre Superior</th> -->
		
<!-- 		     </tr> -->
<!-- 		   </thead> -->
<!-- 		   <tbody> -->
<%-- 		<s:iterator value="listaSuperiores"> --%>
<%-- 			<s:if test="%{dniTrabajador == dni}"> --%>
<!-- 				   <tr>                 -->
<%-- 				   	<td><s:if test="%{puedeEditar == true}"><a href="borrarSuperiorOrganigramas?idRelacion=<s:property value="id"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></s:if></td> --%>
<%-- 					 <td><s:property value="dniSuperior"/></td> --%>
<%-- 					 <s:iterator value="listaTrabajadores"> --%>
<%-- 					 	<s:if  test="%{dniSuperior == dni}"> --%>
<%-- 					 		<td><s:property value="nombre"/></td> --%>
<%-- 					 	</s:if> --%>
<%-- 					 </s:iterator> --%>
<!-- 				   </tr> -->
<%-- 			</s:if> --%>
<%-- 		</s:iterator> --%>

<!-- 		</tbody> -->
<!-- 		</table> -->
	
<!-- 	<h3> Pares   </h3> -->
<%-- 	<s:if test="%{puedeEditar == true}"> --%>
<!-- 		<form action="/nuevoParOrganigramas" method="post"> -->
<%-- 			    <input type="hidden" id="idOrganigrama" name="idOrganigrama" value="<s:property value="idOrganigrama"/>"> --%>
<%-- 			    <input type="hidden" id="dniTrabajador" name="dniTrabajador" value="<s:property value="dni"/>"> --%>
<!-- 			    <label for="dniPar">DNI par:</label> -->
<!-- 				<input type="text" id="dniPar" name="dniPar" required> -->
<!-- 			  <input type="submit" value="Nuevo par"> -->
<!-- 			</form> -->
<%-- 	</s:if> --%>
<!-- 		<table class="table"> -->
<!-- 		   <thead> -->
<!-- 		     <tr> -->
<!-- 		     	<th scope="col"></th> -->
<!-- 		       <th scope="col">DNI Par</th> -->
<!-- 				<th scope="col">Nombre Par</th> -->
<!-- 		     </tr> -->
<!-- 		   </thead> -->
<!-- 		   <tbody> -->
<%-- 		<s:iterator value="listaPares"> --%>
<%-- 			<s:if test="%{dniTrabajador == dni}"> --%>
<!-- 				   <tr>                 -->
<%-- 				   	<td><s:if test="%{puedeEditar == true}"><a href="borrarParOrganigramas?idRelacion=<s:property value="id"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></s:if></td> --%>
<%-- 					 <td><s:property value="dniPar"/></td> --%>
<%-- 					 <s:iterator value="listaTrabajadores"> --%>
<%-- 					 	<s:if  test="%{dniPar == dni}"> --%>
<%-- 					 		<td><s:property value="nombre"/></td> --%>
<%-- 					 	</s:if> --%>
<%-- 					 </s:iterator> --%>
<!-- 				   </tr> -->
<%-- 			</s:if> --%>
<%-- 		</s:iterator> --%>

<!-- 		</tbody> -->
<!-- 		</table> -->
<%-- </s:iterator> --%>