<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1> Organigramas</h1>

<s:if test="%{editar == false}">
	<table class="table">
	   <thead>
	     <tr>
	     	<th scope="col">      </th>
	       <th scope="col">Nombre</th>
	       <th scope="col">Fecha inicio</th>
	       <th scope="col">Fecha fin</th>
	
	     </tr>
	   </thead>
	   <tbody>
		<s:iterator value="listaOrganigramas">
			   <tr>  
			   <td><a href="borrarOrganigramas?idOrganigrama=<s:property value="id"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a><a href="editarOrganigramas?idOrganigrama=<s:property value="id"/>"><i class="fas fa-edit" aria-hidden="true"></i></a></td>
				<td><a href="concretoOrganigramas?idOrganigrama=<s:property value="id"/>"><s:property value="nombre"/></a></td>               
				 <td><s:property value="fechaIni"/></td>
				 <td><s:property value="fechaFin"/></td>
			   </tr>
			</s:iterator>
	</tbody>
	</table>

	<h4>Nuevo organigrama</h4>
	
	<div class="col-lg-6">
		<form action="/nuevoOrganigramas" method="post">
		 <ul>
		 <li>
		    <label for="nombreOrganigrama">Nombre nuevo organigrama:</label>
			<input type="text" id="nombreOrganigrama" name="nombreOrganigrama" required>
		</li>
		  <li>
		    <label for="fechaIni">Fecha de inicio de validez:</label>
			<input type="date" id="fechaIni" name="fechaIni">
		</li>
		 <li>
		    <label for="fechaFin">Fecha de fin de validez:</label>
			<input type="date" id="fechaFin" name="fechaFin">
		</li>
		  <li class="button">
			  <button type="submit">Crear organigrama</button>
			</li>
		 </ul>
		 
		</form>
	
	</div>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
</s:if>
<s:else>
	<table class="table">
	   <thead>
	     <tr>
	     	<th scope="col">      </th>
	       <th scope="col">Nombre</th>
	       <th scope="col">Fecha inicio</th>
	       <th scope="col">Fecha fin</th>
	
	     </tr>
	   </thead>
	   <tbody>
		<s:iterator value="listaOrganigramas">
			<s:if test="%{id == idEditar}">
				<form name="formEdit" method="post" action="/guardarOrganigramas">
					<tr>  
					   <td></td>
						<td><input id="idOrganigrama" name="idOrganigrama" type="hidden" value="<s:property value="id"/>">
						     <input id="nombreOrganigrama" name="nombreOrganigrama" type="text" value="<s:property value="nombre"/>"></td>               
						<td><input id="fechaIni" name="fechaIni" type="date" value="<s:property value="fechaIni"/>"></td>
						<td><input id="fechaFin" name="fechaFin" type="date" value="<s:property value="fechaFin"/>">
							<input type="Submit" value="Guardar">
						</td> 
				   	</tr>
				
			   </form>
			</s:if>
			<s:else>
				 <tr>  
			   <td></td>
				<td><s:property value="nombre"/></td>               
				 <td><s:property value="fechaIni"/></td>
				 <td><s:property value="fechaFin"/></td>
			   </tr>
			
			</s:else>
			</s:iterator>
	</tbody>
	</table>

</s:else>