<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Niveles</h1>

<s:if test="%{editar == false}">
	<table class="table">
	   <thead>
	     <tr>
	     	<th scope="col">      </th>
	       <th scope="col">Nombre</th>
	       <th scope="col">Valor porcentual</th>
	       <th scope="col">Fecha alta</th>
	       <th scope="col">Fecha baja</th>
	
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="niveles">
	   <tr>
	   	 <td><a href="borrarNiveles?id=<s:property value="id"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a><a href="editarNiveles?id=<s:property value="id"/>"><i class="fas fa-edit" aria-hidden="true"></i></a></td>
	     <td><s:property value="nombre"/></td>
	     <td><s:property value="valorporcentual"/></td>   
	     <td><s:property value="alta"/></td> 
	     <td><s:property value="baja"/></td> 
	   </tr>
	</s:iterator>
	</tbody>
	</table>
	
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<h3 class="panel-title">Nuevo nivel de comportamientos</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="/nuevoNiveles" method="post">
						<div class="form-group"> 
							<label class="col-sm-2 control-label">Nombre: </label> 
								<div class="col-sm-10"> 
									<input type="text" id="nombre" name="nombre" required>
								</div> 
						</div>
						<div class="form-group"> 
							<label class="col-sm-2 control-label">Valor (peso): </label> 
								<div class="col-sm-10"> 
									<input type="text" id="valorporcentual" name="valorporcentual" required>
								</div> 
						</div>
						<div class="form-group"> 
							<label class="col-sm-2 control-label">Fecha de alta: </label> 
								<div class="col-sm-10"> 
									<div id="date-popup" class="input-group date"> 
										<input type="date" id="alta" name="alta" required>
									</div>
								</div> 
						</div>
						<div class="form-group"> 
							<label class="col-sm-2 control-label">Fecha de baja: </label> 
								<div class="col-sm-10"> 
									<div id="date-popup" class="input-group date"> 
										<input type="date" id="baja" name="baja">	
									</div>
									<p class="help-block">No es necesario que lo rellenes ahora. Podrás añadirla más adelante.</p>
								</div> 
						</div>
						<div class="form-group"> 
							<div class="col-sm-offset-2 col-sm-10"> 
								<button class="btn btn-primary" type="submit">Crear nivel de comportamientos</button> 
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
	       <th scope="col">Valor porcentual</th>
	       <th scope="col">Fecha alta</th>
	       <th scope="col">Fecha baja</th>
	
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="niveles">
		<s:if test="%{id == idEditar}">
			<form name="formEdit" method="post" action="/guardarNiveles">
			<tr>
			  	 <td></td>
			     <td>
					     <input id="id" name="id" type="hidden" value="<s:property value="id"/>">
					     <input id="nombre" name="nombre" type="text" value="<s:property value="nombre"/>" size="30">
					</td>
					     <td><input id="valorporcentual" name="valorporcentual" type="text" value="<s:property value="valorporcentual"/>"></td>
						<td><input id="alta" name="alta" type="date" value="<s:property value="alta"/>"></td>
						<td><input id="baja" name="baja" type="date" value="<s:property value="baja"/>">
						<input type="Submit" value="Guardar">
						</td>   
		   </tr>
		   </form> 
		</s:if>
		<s:else>
		   <tr>
		   	 <td></td>
		     <td><s:property value="nombre"/></td>
		     <td><s:property value="valorporcentual"/></td>   
		     <td><s:property value="alta"/></td> 
		     <td><s:property value="baja"/></td> 
		   </tr>
		</s:else>
	</s:iterator>
	</tbody>
	</table>
</s:else>