<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script src="jquery.ui.datepicker-es.js"></script>
<script>
$(function () {
$("#datepicker").datepicker();
});
</script>
<script>
$(function () {
$("#datepicker2").datepicker();
});
</script>


<h1>Categorías competenciales</h1>
<s:set var="size"><s:property value="catCompetenciales.size"/></s:set>

<s:if test="%{editar == false}">
	<s:if test="%{ #size != 0}">
	<table class="table">
	   <thead>
	     <tr>
	       <th scope="col">   </th>
	       <th scope="col">Código</th>
	       <th scope="col">Nombre</th>
	       <th scope="col">Alta</th>
	       <th scope="col">Baja</th>
	     </tr>
	    </thead>
	 	<tbody>
			<s:iterator value="catCompetenciales">
			   <tr>                  
			     <td><a href="borrarCatCompetenciales?codigo=<s:property value="codigo"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a><a href="/editarCatCompetenciales?codigo=<s:property value="codigo"/>"><i class="fas fa-edit" aria-hidden="true"></i></a></td>   
			     <td><a href="concretaCompetencias?catCompetencial=<s:property value="codigo"/>"><s:property value="codigo"/></a></td>
			     <td><a href="concretaCompetencias?catCompetencial=<s:property value="codigo"/>"><s:property value="nombre"/></a></td>
				 <td><s:date name="alta" format="yyyy-MM-dd"/></td>
				 <td><s:date name="baja" format="yyyy-MM-dd"/></td>
			   </tr>
			</s:iterator>
		</tbody>
	</table>
	</s:if>
	
	<div class="col-lg-6">
	<div class="panel panel-default">
		<div class="panel-heading clearfix">
			<h3 class="panel-title">Nueva categoría competencial</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" action="/nuevaCatCompetenciales" method="post">
				<div class="form-group"> 
					<label class="col-sm-2 control-label">Código: </label> 
						<div class="col-sm-10"> 
							<input type="text" id="codigo" name="codigo" required>
						</div> 
				</div>
				<div class="form-group"> 
					<label class="col-sm-2 control-label">Nombre: </label> 
						<div class="col-sm-10"> 
							<textarea name="nombre" id="nombre" rows="2" cols="40" required></textarea>
<!-- 							<input type="text" id="nombre" name="nombre" required> -->
						</div> 
				</div>
				<div class="form-group"> 
					<label class="col-sm-2 control-label">Fecha de alta: </label> 
						<div class="col-sm-10"> 						
							<div id="date-popup" class="input-group date"> 
								<input type="text" id="datepicker" name="alta" class="form-control" required readonly>
							</div> 
						</div>
				</div>
				<div class="form-group"> 
					<label class="col-sm-2 control-label">Fecha de baja: </label> 
						<div class="col-sm-10"> 
							<div id="date-popup" class="input-group date"> 
								<input type="text" id="datepicker2" name="baja" class="form-control" readonly>
							</div> 
							<p class="help-block">No es necesario que lo rellenes ahora. Podrás añadirla más adelante.</p>
						</div> 
				</div>
				<div class="form-group"> 
					<div class="col-sm-offset-2 col-sm-10"> 
						<button class="btn btn-primary" type="submit">Crear categoría competencial</button> 
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
</s:if>
<s:else>
	<table class="table">
	   <thead>
	     <tr>
	       <th scope="col">      </th>
	       <th scope="col">Código</th>
	       <th scope="col">Nombre</th>
	       <th scope="col">Alta</th>
	       <th scope="col">Baja</th>
	     </tr>
	   </thead>
		<tbody>
			<s:iterator value="catCompetenciales">
			   <s:if test="%{codigo == codEditar}">
			   		<form name="formEdit" method="post" action="/guardarCatCompetenciales">
			   		<tr>
					     <td></td>
					     <td><s:property value="codigo"/></td>
					     <td>
					     <input id="codigo" name="codigo" type="hidden" value="<s:property value="codigo"/>">
					     <input id="nombre" name="nombre" type="text" value="<s:property value="nombre"/>" size="80"></td>
						<td><input id="alta" name="alta" type="date" value="<s:date name="alta" format="yyyy-MM-dd"/>"></td>
						<td><input id="baja" name="baja" type="date" value="<s:date name="baja" format="yyyy-MM-dd"/>">
						<input type="Submit" value="Guardar">
						</td>   
					    
					</tr>
					</form>
				</s:if>
				<s:else>
					<tr>
						<td></td>   
					     <td><s:property value="codigo"/></td>
					     <td><s:property value="nombre"/></td>
						<td><s:date name="alta" format="yyyy-MM-dd"/></td>
						<td><s:date name="baja" format="yyyy-MM-dd"/></td>
					</tr>
				</s:else>
			</s:iterator>
		</tbody>
	</table>
</s:else>
