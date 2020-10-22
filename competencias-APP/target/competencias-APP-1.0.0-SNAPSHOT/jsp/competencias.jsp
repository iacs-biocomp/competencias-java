<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <link rel="stylesheet" href="css/acordeon.css" type="text/css"></link> -->

<h1>Competencias</h1>

<s:if test="%{editar == false}">
	<table class="table">
	   <thead>
	     <tr>
	       <th scope="col">      </th>
	       <th scope="col">Código</th>
	       <th scope="col">Descripción</th>
			<th scope="col">Alta</th>
			<th scope="col">Baja</th>
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="competencias">
	   <tr>
	     <td><a href="borrarCompetencias?codigo=<s:property value="codigo"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a><a href="editarCompetencias?codigo=<s:property value="codigo"/>"><i class="fas fa-edit" aria-hidden="true"></i></a></td> 
	     <td><s:property value="codigo"/></td>
	     <td><s:property value="descripcion"/></td>   
	     <td><s:property value="Alta"/></td> 
	     <td><s:property value="Baja"/></td> 
	     
	   </tr>
	   
	</s:iterator>
	</tbody>
	</table>
	
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<h3 class="panel-title">Nueva competencia</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="/nuevaCompetencias" method="post">
						<div class="form-group"> 
							<label class="col-sm-2 control-label">Código: </label> 
								<div class="col-sm-10"> 
									<input type="text" id="codigo" name="codigo" required>
								</div> 
						</div>
						<div class="form-group"> 
							<label class="col-sm-2 control-label">Descripción: </label> 
								<div class="col-sm-10"> 
									<textarea name="descripcion" id="descripcion" rows="2" cols="40" required></textarea>
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
								<button class="btn btn-primary" type="submit">Crear competencia</button> 
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
	       <th scope="col">Código</th>
	       <th scope="col">Descripción</th>
			<th scope="col">Alta</th>
			<th scope="col">Baja</th>
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="competencias">
		<s:if test="%{codigo == codEditar}">
			<form name="formEdit" method="post" action="/guardarCompetencias">
			   <tr>
			     <td></td> 
			     <td><s:property value="codigo"/></td>
			     <td>
					     <input id="codigo" name="codigo" type="hidden" value="<s:property value="codigo"/>">
					     <input id="descripcion" name="descripcion" type="text" value="<s:property value="descripcion"/>" size="80">
				</td>
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
			     <td><s:property value="codigo"/></td>
			     <td><s:property value="descripcion"/></td>   
			     <td><s:property value="Alta"/></td> 
			     <td><s:property value="Baja"/></td>
			</tr>
	    </s:else>
	</s:iterator>
	</tbody>
	</table>
	
</s:else>
