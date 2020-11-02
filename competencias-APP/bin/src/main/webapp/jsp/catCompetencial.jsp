<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
	
	<script>
	function submitFormModal3(competencia, categoriaCompetencial){			
			var i=0;
			var idCompetencia="codComp"+i;
			var idCatComp="codCatComp"+i;
			while (document.getElementById(idCompetencia) != null){
				document.getElementById(idCompetencia).value=competencia;
				document.getElementById(idCatComp).value=categoriaCompetencial;
				i++;
				idCompetencia="codComp"+i;
				idCatComp="codCatComp"+i;
				}
		}
	</script>

</head>

<h1><s:property value="nombreCatCompetencial"/></h1>
<s:if test="%{editar == true}">
	<h3 style="text-align: right"> <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-2">Añadir competencia <i class="fa fa-plus" aria-hidden="true" ></i></button></h3>
	
	<div id="modal-2" class="modal fade" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">Seleccione la competencia que desea añadir al perfil competencial</h4>
	      </div>
	      <div class="modal-body">
	        <table class="table">
			   <thead>
			     <tr>
			       <th scope="col">      </th>
			       <th scope="col">Código</th>
			       <th scope="col">Descripción</th>	
			       <th scope="col">Objetivo</th>	
			     </tr>
			   </thead>
			   <tbody>
			
			
			<s:iterator value="competencias">
						<form name="formEdit" method="post" action="/nuevaRelacionCompetencias">
						   <tr>
						     <td><input id="codCatCompetencial" name="codCatCompetencial" type="hidden" value="<s:property value="codCatCompetencial"/>" ></td> 
						     <td><input id="codigo" name="codigo" type="hidden" value="<s:property value="codigo"/>" ><s:property value="codigo"/></td>
						     <td><s:property value="descripcion"/></td>    
						     <td><select name="idNivel" required>
										<s:iterator value="listaNiveles">
											<option value="<s:property value="id"/>"><s:property value="nombre"/></option>
										</s:iterator>
										</select></td>
							<td><input type="Submit" value="Guardar"></td>
						   </tr>
						</form>   

			</s:iterator>
			</tbody>
			</table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	


	<div class="accordion" id="accordion">
	<s:iterator value="compObjCompCatcomp" status="incr">
		<div class="panel accordion-group">
			<div class="accordion-heading">
			
				<s:if test="%{idEditar == id }">
					<h4 class="title">
						<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="%{#incr.index}"/>"><s:property value="descripcion"/></a>
						<form class="form-horizontal" action="/guardarRelacionCompetencias" method="post">
							 Objetivo: 
<!-- 							 <input type="text" id="objetivo" name="objetivo" required>  -->
							 <select name="objetivo" required>
							<s:iterator value="listaNiveles">
								<option value="<s:property value="id"/>"><s:property value="nombre"/></option>
							</s:iterator>
							</select>
							 <input type="hidden" id="idRelacion" name="idRelacion" value="<s:property value="id"/>"> 
							 <input type="hidden" id="catCompetencial" name="catCompetencial" value="<s:property value="codCatCompetencial"/>"> 
							 <button class="btn btn-primary" type="submit">Guardar</button> 
						 </form>
					
					</h4>
				</s:if>
				<s:else>
					<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="%{#incr.index}"/>"><s:property value="descripcion"/></a> Objetivo: <s:property value="objetivo"/></h4>
				</s:else>
				<input type="hidden" id="catcomp" value="<s:property value="codCatCompetencial"/>" />
				<input type="hidden" id="compet" value="<s:property value="codcompetencia"/>" />
				<h4 class="title" style="text-align:right">
					<a href="borrarRelacionCompetencias?idRelacion=<s:property value="id"/>&catCompetencial=<s:property value="codcatcomp"/>&codCompetencia=<s:property value="codcompetencia"/>"/><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a>
					<a href="editarRelacionCompetencias?idRelacion=<s:property value="id"/>&catCompetencial=<s:property value="codcatcomp"/>"><i class="fas fa-edit" aria-hidden="true"></i></a>
					<button id="openModal3" onclick=" submitFormModal3('<s:property value="codcompetencia"/>','<s:property value="codCatCompetencial"/>')" type="button" class="btn btn-link" data-toggle="modal" data-target="#modal-3" value="<s:property value="codcompetencia"/>" ><i class="fa fa-plus" aria-hidden="true" ></i></button></h4>
			</div>
			<div id="<s:property value="%{#incr.index}"/>" class="accordion-body collapse">
				<div class="accordion-inner">
					<div class="accordion" id="accordion2">
						<s:iterator value="listaNiveles" status="stat">
							<div class="panel accordion-group">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#<s:property value="%{#incr.index}"/><s:property value="%{#stat.index}"/>"><s:property value="nombre"/></a></h4>
								</div>
								<div id="<s:property value="%{#incr.index}"/><s:property value="%{#stat.index}"/>" class="accordion-body collapse">
									<div class="accordion-inner">
										<table class="table">
											<s:iterator value="compRelCompCompleto">
												<s:if test="%{id == idnivel && codcomp == codcompetencia && codcatcomp == codCatCompetencial}">
												   <tr> 
												     <td><a href="borrarRelacionComportamientosCompetencias?idRelacion=<s:property value="idRel"/>&catCompetencial=<s:property value="codcatcomp"/>"/><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></td>
												     <td><s:property value="descripcion"/></td>
												   </tr>
												</s:if>
											</s:iterator>
										</table>   
									</div>
								</div>
							</div>
						</s:iterator>
					</div>	
											
				</div>
			</div>
		</div>
	</s:iterator>	
	</div>
		
	<div id="modal-3" class="modal fade" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">Seleccione el comportamiento que desea añadir al perfil competencial</h4>
	      </div>
	      <div class="modal-body">
	        <table class="table">
			   <thead>
			     <tr>
			       <th scope="col">Descripción</th>	
			       <th scope="col">Objetivo</th>	
			     </tr>
			   </thead>
			   <tbody>
			<s:iterator value="listaComportamientos" status="incr">
			   <tr>
				<form id="formModal<s:property value="%{#incr.index}"/>" method="post" action="/nuevaRelacionComportamientosCompetencias">
				   <td><input id="codCatComp<s:property value="%{#incr.index}"/>" name="codCatComp" type="hidden"  value="" >
				     <input id="idComportamiento" name="idComportamiento" type="hidden" value="<s:property value="id"/>" >
				     <input id="codComp<s:property value="%{#incr.index}"/>" name="codComp" type="hidden" value=""><s:property value="descripcion"/></td>
				     
				      
				     <td><select name="idNivel" required>
								<s:iterator value="listaNiveles">
									<option value="<s:property value="id"/>"><s:property value="nombre"/></option>
								</s:iterator>
								</select></td>
					<td><input type="submit"  value="Guardar"></td>
				</form>   
			   </tr>
			</s:iterator>
			</tbody>
			</table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
</s:if>
<s:else>
	<div class="accordion" id="accordion">
	<s:iterator value="compObjCompCatcomp" status="incr">
		<div class="panel accordion-group">
			<div class="accordion-heading">
				<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="%{#incr.index}"/>"><s:property value="descripcion"/></a> Objetivo: <s:property value="objetivo"/></h4>
			</div>
			<div id="<s:property value="%{#incr.index}"/>" class="accordion-body collapse">
				<div class="accordion-inner">
					<div class="accordion" id="accordion2">
						<s:iterator value="listaNiveles" status="stat">
							<div class="panel accordion-group">
								<div class="accordion-heading">
										<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#<s:property value="%{#incr.index}"/><s:property value="%{#stat.index}"/>"><s:property value="nombre"/></a></h4>
								</div>
								<div id="<s:property value="%{#incr.index}"/><s:property value="%{#stat.index}"/>" class="accordion-body collapse">
									<div class="accordion-inner">
										<table class="table">
											<s:iterator value="compRelCompCompleto">
												<s:if test="%{id == idnivel && codcomp == codcompetencia}">
													<tr> 
														<td><s:property value="descripcion"/></td>
													</tr>
												</s:if>
											</s:iterator>
										</table>   
									</div>
								</div>
							</div>
						</s:iterator>
					</div>			
				</div>
			</div>
		</div>
	</s:iterator>	
	</div>
</s:else>
