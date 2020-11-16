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
				 <td><s:date name="fechaIni" format="yyyy-MM-dd"/></td>
				 <td><s:date name="fechaFin" format="yyyy-MM-dd"/></td>
			   </tr>
			</s:iterator>
	</tbody>
	</table>

	<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<h3 class="panel-title">Nuevo organigrama</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="/nuevoOrganigramas" method="post">
						<div class="form-group"> 
							<label class="col-sm-2 control-label">Nombre: </label> 
								<div class="col-sm-10"> 
									<input type="text" id="nombreOrganigrama" name="nombreOrganigrama" required>
								</div> 
						</div>
						<div class="form-group"> 
							<label class="col-sm-2 control-label">Fecha de inicio de validez: </label> 
								<div class="col-sm-10"> 
									<div id="date-popup" class="input-group date"> 
										<input type="date" id="fechaIni" name="fechaIni" required>
									</div>
								</div> 
						</div>
						<div class="form-group"> 
							<label class="col-sm-2 control-label">Fecha de fin de validez: </label> 
								<div class="col-sm-10"> 
									<div id="date-popup" class="input-group date"> 
										<input type="date" id="fechaFin" name="fechaFin">
									</div>
									<p class="help-block">No es necesario que lo rellenes ahora. Podrás añadirla más adelante.</p>
								</div> 
						</div>
						<div class="form-group"> 
							<div class="col-sm-offset-2 col-sm-10"> 
								<button class="btn btn-primary" type="submit">Crear organigrama</button> 
							</div> 
						</div> 
					</form>
				</div>
			</div>
		</div>
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
						<td><input id="fechaIni" name="fechaIni" type="date" value="<s:date name="fechaIni" format="yyyy-MM-dd"/>"></td>
						<td><input id="fechaFin" name="fechaFin" type="date" value="<s:date name="fechaFin" format="yyyy-MM-dd"/>">
							<input type="Submit" value="Guardar">
						</td> 
				   	</tr>
				
			   </form>
			</s:if>
			<s:else>
				 <tr>  
			   <td></td>
				<td><s:property value="nombre"/></td>               
				 <td><s:date name="fechaini" format="yyyy-MM-dd"/></td>
				 <td><s:date name="fechafin" format="yyyy-MM-dd"/></td>
			   </tr>
			
			</s:else>
			</s:iterator>
	</tbody>
	</table>

</s:else>