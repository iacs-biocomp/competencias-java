<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<h1>Trabajadores</h1>

<s:if test="%{editar == false}">
	<h3>Trabajadores internos</h3>
	
	<table class="table">
	   <thead>
	     <tr>
	     	<th scope="col">      </th>
	       <th scope="col">Nombre</th>
	       <th scope="col">Apellidos</th>
	       <th scope="col">Categoría profesional contractual</th>
	       <th scope="col">Categoría competencial</th>
	       <th scope="col">Área</th>
	       <th scope="col">Unidad</th>
	       <th scope="col">Departamento</th>
	       <th scope="col">Fecha antigüedad</th>
	       <th scope="col">DNI</th>
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="trabajadores">
	   <tr>
	   <td><a href="editarTrabajadores?dni=<s:property value="dni"/>"><i class="fas fa-edit" aria-hidden="true"></i></a></td>
	     <td><s:property value="nombre"/></td>
	     <td><s:property value="apellidos"/></td>
	     <td><s:property value="catcontractual"/></td>
	     <td><s:property value="catcompetencial"/></td>
	     <td><s:property value="area"/></td>
	     <td><s:property value="unidad"/></td>
	     <td><s:property value="departamento"/></td>
	     <td><s:property value="antiguedad"/></td> 
	     <td><s:property value="dni"/></td>     
	   </tr>
	</s:iterator>
	</tbody>
	</table>
	
	<h3>Trabajadores externos</h3>
	
	<table class="table">
	   <thead>
	     <tr>
	     	<th scope="col">      </th>
	       <th scope="col">Nombre</th>
	       <th scope="col">Apellidos</th>
	       <th scope="col">Email</th>
	       <th scope="col">Instituciones</th>
	       <th scope="col">Posible superior</th>
	       <th scope="col">dni</th>
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="externos">
	   <tr>
	   	<td><a href="editarTrabajadores?dni=<s:property value="dni"/>"><i class="fas fa-edit" aria-hidden="true"></i></a></td>
	     <td><s:property value="nombre"/></td>
	     <td><s:property value="apellidos"/></td>
	     <td><s:property value="email"/></td>
	     <td><s:property value="instituciones"/></td>
	     <s:if test="%{posiblesuperior == true}">
	     	<td><input type="checkbox" name="fieldName" value="Check Value" readonly="readonly" checked onclick="javascript: return false;"/></td>
	     </s:if>
	     <s:else>
	     	<td><input type="checkbox" name="fieldName" value="Check Value" readonly="readonly" onclick="javascript: return false;"/></td>
	     </s:else>	
	     <td><s:property value="dni"/></td>
	   </tr>
	</s:iterator>
	</tbody>
	</table>
</s:if>
<s:else>
	<h3>Trabajadores internos</h3>

	<table class="table">
	   <thead>
	     <tr>
	       <th scope="col">Nombre</th>
	       <th scope="col">Apellidos</th>
	       <th scope="col">Categoría profesional contractual</th>
	       <th scope="col">Categoría competencial</th>
	       <th scope="col">Área</th>
	       <th scope="col">Unidad</th>
	       <th scope="col">Departamento</th>
	       <th scope="col">Fecha antigüedad</th>
	       <th scope="col">DNI</th>
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="trabajadores">
		<s:if test="%{dni == dniEditar}">
			<form name="formEdit" method="post" action="/guardarInternosTrabajadores">
		   <tr>
		     <td>
					     <input id="codigo" name="codigo" type="hidden" value="<s:property value="codigo"/>">
					     <input id="nombre" name="nombre" type="text" value="<s:property value="nombre"/>" size="15"></td>
						<td><input id="apellidos" name="apellidos" type="text" value="<s:property value="apellidos"/>" size="15"></td>
						
						<td><select name="catcontractual">
						<s:iterator value="catContractuales">
						<s:if test="%{nombre == catcontractual}">
							<option selected value="<s:property value="nombre"/>"><s:property value="nombre"/></option>
						</s:if>
						<s:else>
							<option value="<s:property value="nombre"/>"><s:property value="nombre"/></option>
						</s:else>
						</s:iterator>
						</select></td>
						
						<td><select name="catcompetencial">
						<s:iterator value="catCompetenciales">
						<s:if test="%{catcompetencial == codigo}">
							<option selected value="<s:property value="codigo"/>"><s:property value="codigo"/></option>
						</s:if>
						<s:else>
							<option value="<s:property value="codigo"/>"><s:property value="codigo"/></option>
						</s:else>
						</s:iterator>
						</select></td>
						
						<td><input id="area" name="area" type="text" value="<s:property value="area"/>"></td>
						<td><input id="unidad" name="unidad" type="text" value="<s:property value="unidad"/>" size="15"></td>
						<td><input id="departamento" name="departamento" type="text" value="<s:property value="departamento"/>"></td>
						<td><input id="antiguedad" name="antiguedad" type="date" value="<s:property value="antiguedad"/>" size="7"></td>
						<td><s:property value="dni"/><input id="dni" name="dni" type="hidden" value="<s:property value="dni"/>"></td>
						<td><input type="Submit" value="Guardar">
						</td>
		   </tr>
		   </form>
		 </s:if>
		 <s:else>
		 	<tr>
		     <td><s:property value="nombre"/></td>
		     <td><s:property value="apellidos"/></td>
		     <td><s:property value="catcontractual"/></td>
		     <td><s:property value="catcompetencial"/></td>
		     <td><s:property value="area"/></td>
		     <td><s:property value="unidad"/></td>
		     <td><s:property value="departamento"/></td>
		     <td><s:property value="antiguedad"/></td> 
		     <td><s:property value="dni"/></td>     
		   </tr>
		 </s:else>
	</s:iterator>
	</tbody>
	</table>
	
	<h3>Trabajadores externos</h3>
	
	<table class="table">
	   <thead>
	     <tr>
	       <th scope="col">Nombre</th>
	       <th scope="col">Apellidos</th>
	       <th scope="col">Email</th>
	       <th scope="col">Instituciones</th>
	       <th scope="col">Posible superior</th>
	       <th scope="col">dni</th>
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="externos">
		<s:if test="%{dni == dniEditar}">
			<form name="formEdit" method="post" action="/guardarExternosTrabajadores">
		   <tr>
		   <td>
			  <input id="id" name="id" type="hidden" value="<s:property value="id"/>">
			  <input id="nombre" name="nombre" type="text" value="<s:property value="nombre"/>"></td>
			  <td><input id="apellidos" name="apellidos" type="text" value="<s:property value="apellidos"/>"></td>
				<td><input id="email" name="email" type="text" value="<s:property value="email"/>"></td>
				<td><input id="instituciones" name="instituciones" type="text" value="<s:property value="instituciones"/>"></td>
				
				<s:if test="%{posiblesuperior == true}">
					<td><input type="checkbox" id="posiblesuperior" name="posiblesuperior" value="true" checked/> </td>
				</s:if>
		     	<s:else>
					<td><input type="checkbox" id="posiblesuperior" name="posiblesuperior" value="true"/> </td>
				</s:else>	
				
				<td><s:property value="dni"/><input id="dni" name="dni" type="hidden" value="<s:property value="dni"/>"></td>
				<td><input type="Submit" value="Guardar">
				</td>
		   
		   </tr>
		   </form>
		</s:if>
		<s:else>
			<td><s:property value="nombre"/></td>
		     <td><s:property value="apellidos"/></td>
		     <td><s:property value="email"/></td>
		     <td><s:property value="instituciones"/></td>
		     <s:if test="%{posiblesuperior == true}">
		     	<td><input type="checkbox" name="fieldName" value="Check Value" readonly="readonly" checked onclick="javascript: return false;"/></td>
		     </s:if>
		     <s:else>
		     	<td><input type="checkbox" name="fieldName" value="Check Value" readonly="readonly" onclick="javascript: return false;"/></td>
		     </s:else>	
		     <td><s:property value="dni"/></td>
		   </tr>
		</s:else>
	</s:iterator>
	</tbody>
	</table>
</s:else>

<div style="text-align:center">
     <a href="todosOrganigramas" class="btn btn-success" >Ver organigramas</a>
</div>
