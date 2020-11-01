<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<s:iterator value="evaluacionActual" var="evaluacion">
	<h1> Evaluacion <s:property value="id"/>: <s:property value="nombre"/></h1>
	
	<p> Puedes evaluar y guardar los resultados cuando quieras. Cada vez que regargas la pag se recargan los resultados que hay hasta el momento. Puedes editar siempre
	que quieras. Cuando se acaba la fecha de evaluar se quedan los guardados y ya no se pueden editar ni añadir </p>
	<s:iterator value="listaTrabajadores" var="trabajador" status="tr">
		
			<div class="row">
				<div class="col-lg-12">
					<h2 class="title"><s:property value="nombre"/> <s:property value="apellidos"/> Tr</h2>

						
						
<%-- 							<h3> <s:property value="codigo"/></h3> --%>
							<div class="accordion" id="accordion">
							<s:iterator value="listaCompetencias" status="incr" var="lacomp">
								<s:if test="%{#lacomp.codigo==#evaluacion.comp1 || #lacomp.codigo==#evaluacion.comp2 || #lacomp.codigo==#evaluacion.comp3||#lacomp.codigo==#evaluacion.comp4||#lacomp.codigo==#evaluacion.comp5||#lacomp.codigo==#evaluacion.comp6||#lacomp.codigo==#evaluacion.comp7||#lacomp.codigo==#evaluacion.comp8||#lacomp.codigo==#evaluacion.comp9||#lacomp.codigo==#evaluacion.comp10}">
									<div class="panel accordion-group">
										<div class="accordion-heading">
											<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#tr<s:property value="%{#tr.index}"/><s:property value="%{#incr.index}"/>"><s:property value="descripcion"/></a> </h4>
										</div>
										<div id="tr<s:property value="%{#tr.index}"/><s:property value="%{#incr.index}"/>" class="accordion-body collapse">
											<div class="accordion-inner">
												<table class="table">
													<s:iterator value="compRelCompCompleto" var="rel">
														<s:if test="%{ #rel.codcomp==#lacomp.codigo }">
															<tr> 
																<td><s:property value="#rel.descripcion"/></td>
																<td>
																	<input type="radio" id="nota1" name="notatr<s:property value="idRel"/>" value="nota1">
																	<label for="nota1">1</label>
																	<input type="radio" id="nota2" name="notatr<s:property value="idRel"/>" value="nota2">
																	<label for="nota2">2</label>
																	<input type="radio" id="nota3" name="notatr<s:property value="idRel"/>" value="nota3">
																	<label for="nota3">3</label>
																	<input type="radio" id="nota4" name="notatr<s:property value="idRel"/>" value="nota4">
																	<label for="nota4">4</label>
																	<input type="radio" id="nota5" name="notatr<s:property value="idRel"/>" value="nota5">
																	<label for="nota5">5</label>
																
																</td>
															</tr>
														</s:if>
		
													</s:iterator>
												</table>   	
											</div>
										</div>
									</div>
								</s:if>
							</s:iterator>
						</div>
							
						

				</div>
			</div>
	
	</s:iterator>
	
	<s:iterator value="evaluadoresInternos" var="evinterno">
		<div class="row">
				<div class="col-lg-12">
					<s:iterator value="listaTrabajadoresAll">
						<s:if test="%{#evaluacion.id == #evinterno.idevaluacion  && dni == dnitrabajador }">
							<h2 class="title"><s:property value="nombre"/><s:property value="apellidos"/> ele</h2>
							
							
							<div class="accordion" id="accordion">
								<s:iterator value="listaCompetencias" status="incr" var="lacomp">
									<s:if test="%{#lacomp.codigo==#evinterno.comp1 || #lacomp.codigo==#evinterno.comp2 || #lacomp.codigo==#evinterno.comp3||#lacomp.codigo==#evinterno.comp4||#lacomp.codigo==#evinterno.comp5||#lacomp.codigo==#evinterno.comp6||#lacomp.codigo==#evinterno.comp7||#lacomp.codigo==#evinterno.comp8||#lacomp.codigo==#evinterno.comp9||#lacomp.codigo==#evinterno.comp10}">
										<div class="panel accordion-group">
											<div class="accordion-heading">
												<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#tr<s:property value="%{#tr.index}"/><s:property value="%{#incr.index}"/>"><s:property value="descripcion"/></a> </h4>
											</div>
											<div id="tr<s:property value="%{#tr.index}"/><s:property value="%{#incr.index}"/>" class="accordion-body collapse">
												<div class="accordion-inner">
													<table class="table">
														<s:iterator value="compRelCompCompleto" var="rel">
															<s:if test="%{ #rel.codcomp==#lacomp.codigo }">
																<tr> 
																	<td><s:property value="#rel.descripcion"/></td>
																	<td>
																		<input type="radio" id="nota1" name="notaint<s:property value="idRel"/>" value="nota1">
																		<label for="nota1">1</label>
																		<input type="radio" id="nota2" name="notaint<s:property value="idRel"/>" value="nota2">
																		<label for="nota2">2</label>
																		<input type="radio" id="nota3" name="notaint<s:property value="idRel"/>" value="nota3">
																		<label for="nota3">3</label>
																		<input type="radio" id="nota4" name="notaint<s:property value="idRel"/>" value="nota4">
																		<label for="nota4">4</label>
																		<input type="radio" id="nota5" name="notaint<s:property value="idRel"/>" value="nota5">
																		<label for="nota5">5</label>
																	
																	</td>
																</tr>
															</s:if>
			
														</s:iterator>
													</table>   	
												</div>
											</div>
										</div>
									</s:if>
								</s:iterator>
							</div>
							
							
						</s:if>
					</s:iterator>
					
				</div>
			</div>
	</s:iterator>
</s:iterator>