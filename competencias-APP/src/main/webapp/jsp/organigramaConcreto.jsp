<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1> Organigrama <s:property value="idOrganigrama"/> </h1><h3><s:property value="fechaIni"/>   -   <s:property value="fechaFin"/></h3>
<br></br>
<s:iterator value="listaTrabajadores">
<h3><b> <s:property value="nombre"/>  <s:property value="apellidos"/></b></h3>

		
	<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
				<s:if test="%{puedeEditar == true}">
					<div class="panel-body">
					
						 <form class="form-inline" action="/nuevoParOrganigramas" method="post">
							  <div class="form-group">
								  <input type="hidden" id="idOrganigrama" name="idOrganigrama" value="<s:property value="idOrganigrama"/>">
							    <input type="hidden" id="dniTrabajador" name="dniTrabajador" value="<s:property value="dni"/>">
								<select class="form-control" name="dniPar" required> 
									<s:iterator value="listaTrabajadores">
										<option value="<s:property value="dni"/>"><s:property value="nombre"/> <s:property value="apellidos"/></option> 
									</s:iterator>
									<s:iterator value="listaExternos">
										<s:if test="%{dni != null && dni != \"\"}">
 											<option value="<s:property value="dni"/>"><s:property value="nombre"/> <s:property value="apellidos"/></option> 
										</s:if>
									</s:iterator>
								</select>
							  </div>
							 
							  <button type="submit" class="btn btn-primary">Nuevo par</button>
						</form>
						
					</div>
</s:if>
					<table class="table">
						   <thead>
						     <tr>
						     	<th scope="col"></th>
						       <th scope="col">Nombre Par</th>
								<th scope="col">Apellidos Par</th>
						     </tr>
						   </thead>
						   <tbody>
						<s:iterator value="listaPares">
							<s:if test="%{dniTrabajador == dni}">
								   <tr>                
								   	<td><s:if test="%{puedeEditar == true}"><a href="borrarParOrganigramas?idRelacion=<s:property value="id"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></s:if></td>
<%-- 									 <td><s:property value="dniPar"/></td> --%>
									 <s:iterator value="listaTrabajadores">
									 	<s:if  test="%{dniPar == dni}">
									 		<td><s:property value="nombre"/></td>
									 		<td><s:property value="apellidos"/></td>
									 	</s:if>
									 </s:iterator>
								   </tr>
							</s:if>
						</s:iterator>
				
						</tbody>
						</table>
						
					<br></br>	
<s:if test="%{puedeEditar == true}">	
					<div class="panel-body">
						 <form class="form-inline" action="/nuevoSuperiorOrganigramas" method="post">
							
							 <div class="form-group">
								  <input type="hidden" id="idOrganigrama" name="idOrganigrama" value="<s:property value="idOrganigrama"/>">
							    <input type="hidden" id="dniTrabajador" name="dniTrabajador" value="<s:property value="dni"/>">
								<select class="form-control" name="dniSuperior" required> 
									<s:iterator value="listaTrabajadores">
										<option value="<s:property value="dni"/>"><s:property value="nombre"/> <s:property value="apellidos"/></option> 
									</s:iterator>
									<s:iterator value="listaExternos">
										<s:if test="%{dni != null && dni != \"\" && posibleSuperior}">
 											<option value="<s:property value="dni"/>"><s:property value="nombre"/> <s:property value="apellidos"/></option> 
										</s:if>
									</s:iterator>
								</select>
							  </div>
							  <button type="submit" class="btn btn-primary">Nuevo superior</button>
						</form>
					</div>
</s:if>
					<table class="table">
						   <thead>
						     <tr>
						     	<th scope="col"></th>
						       <th scope="col">Nombre Superior</th>
								<th scope="col">Apellidos Superior</th>
						     </tr>
						   </thead>
						   <tbody>
						<s:iterator value="listaSuperiores">
							<s:if test="%{dniTrabajador == dni}">
								   <tr>                
								   	<td><s:if test="%{puedeEditar == true}"><a href="borrarSuperiorOrganigramas?idRelacion=<s:property value="id"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></s:if></td>
<%-- 									 <td><s:property value="dniSuperior"/></td> --%>
									 <s:iterator value="listaTrabajadores">
									 	<s:if  test="%{dniSuperior == dni}">
									 		<td><s:property value="nombre"/></td>
									 		<td><s:property value="apellidos"/></td>
									 	</s:if>
									 </s:iterator>
								   </tr>
							</s:if>
						</s:iterator>
				
						</tbody>
						</table>
				</div>
				
				
			</div>
		</div>
<br></br>
</s:iterator>





