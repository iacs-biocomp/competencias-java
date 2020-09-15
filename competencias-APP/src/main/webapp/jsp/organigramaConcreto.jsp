<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1> Organigrama concreto </h1>

<s:iterator value="listaTrabajadores">
<h2> <s:property value="nombre"/>  <s:property value="apellidos"/></h2>
	<h3> Superiores </h3>
	
		<table class="table">
		   <thead>
		     <tr>
		       <th scope="col">DNI Superior</th>
		       <th scope="col">Nombre Superior</th>
		
		     </tr>
		   </thead>
		   <tbody>
		<s:iterator value="listaSuperiores">
			<s:if test="%{dniTrabajador == dni}">
				   <tr>                
					 <td><s:property value="dniSuperior"/></td>
					 <s:iterator value="listaTrabajadores">
					 	<s:if  test="%{dniSuperior == dni}">
					 		<td><s:property value="nombre"/></td>
					 	</s:if>
					 </s:iterator>
				   </tr>
			</s:if>
		</s:iterator>
			
		</tbody>
		</table>
	
	<h3> Pares </h3>
	
		<table class="table">
		   <thead>
		     <tr>
		       <th scope="col">DNI Par</th>
				<th scope="col">Nombre Par</th>
		     </tr>
		   </thead>
		   <tbody>
		<s:iterator value="listaPares">
			<s:if test="%{dniTrabajador == dni}">
				   <tr>                
					 <td><s:property value="dniPar"/></td>
					 <s:iterator value="listaTrabajadores">
					 	<s:if  test="%{dniPar == dni}">
					 		<td><s:property value="nombre"/></td>
					 	</s:if>
					 </s:iterator>
				   </tr>
			</s:if>
		</s:iterator>
		</tbody>
		</table>
</s:iterator>