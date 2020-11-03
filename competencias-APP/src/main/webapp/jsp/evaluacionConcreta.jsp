<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<s:iterator value="evaluacionActual" var="evaluacion">
	
	<form class="form-horizontal" method="post" action="/guardarValoracionEvaluaciones">
	
	<h1> Evaluacion <s:property value="id"/>: <s:property value="nombre"/></h1>
	<h1 style="text-align:right"><button class="btn btn-default" type="submit">Guardar evaluación  <i class="fa fa-save" aria-hidden="true">&nbsp; &nbsp;</i></button> </h1>
	<p> Puedes evaluar y guardar los resultados cuando quieras. Cada vez que regargas la pag se recargan los resultados que hay hasta el momento. Puedes editar siempre
	que quieras. Cuando se acaba la fecha de evaluar se quedan los guardados y ya no se pueden editar ni añadir </p>
	
	<input type="hidden" name="id" value="<s:property value="id"/>">
	<%! int indice = 0; %>
	<s:iterator value="listaTrabajadores" var="trabajador" status="tr">
		
			<div class="row">
				<div class="col-lg-12">
					<h2 class="title"><s:property value="nombre"/> <s:property value="apellidos"/> Tr</h2>

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
													
													<s:iterator value="compRelCompCompleto" var="rel" status="ind">
														<s:if test="%{ #rel.codcomp==#lacomp.codigo }">
															<s:set var="lanota"><s:property value="inexistente"/></s:set>
															<s:iterator value="listaValoraciones" var="val">
																<s:if test="%{#val.dnievaluado==#trabajador.dni && #val.dnievaluador==dniActual && #val.idcomp==#rel.idcomportamiento && #val.codcomp==#rel.codcomp}">
																	<s:set var="lanota"><s:property value="#val.valoracion"/></s:set>
																</s:if>
															</s:iterator>
																	<tr> 
																		<td><s:property value="#rel.descripcion"/></td>
																		<td>	
<%-- 																			<input type="hidden" name="idrel" value="<s:property value="#rel.idRel"/>"> --%>
																			<input type="hidden" name="codcomp" value="<s:property value="#rel.codcomp"/>">
																			<input type="hidden" name="idcomp" value="<s:property value="#rel.idcomportamiento"/>">
																			<input type="hidden" name="idnivel" value="<s:property value="#rel.idnivel"/>">
																			<input type="hidden" name="dnitr" value="<s:property value="dni"/>">
																			<s:if test="%{ #lanota == 1 }">
																				<input type="radio" id="nota1" name="notatr[<%=indice%>]" value="1" checked>
																			</s:if>
																			<s:else>
																				<input type="radio" id="nota1" name="notatr[<%=indice%>]" value="1">
																			</s:else>
																			<label for="nota1">1</label>
																			<s:if test="%{ #lanota == 2 }">
																				<input type="radio" id="nota2" name="notatr[<%=indice%>]" value="2" checked>
																			</s:if>
																			<s:else>
																				<input type="radio" id="nota2" name="notatr[<%=indice%>]" value="2">
																			</s:else>
																			<label for="nota2">2</label>
																			<s:if test="%{ #lanota == 3 }">
																				<input type="radio" id="nota3" name="notatr[<%=indice%>]" value="3" checked>
																			</s:if>
																			<s:else>
																				<input type="radio" id="nota3" name="notatr[<%=indice%>]" value="3">
																			</s:else>
																			<label for="nota3">3</label>
																			<s:if test="%{ #lanota == 4 }">
																				<input type="radio" id="nota4" name="notatr[<%=indice%>]" value="4" checked>
																			</s:if>
																			<s:else>
																				<input type="radio" id="nota4" name="notatr[<%=indice%>]" value="4">
																			</s:else>
																			<label for="nota4">4</label>
																			<s:if test="%{ #lanota == 5 }">
																				<input type="radio" id="nota5" name="notatr[<%=indice%>]" value="5" checked>
																			</s:if>
																			<s:else>
																				<input type="radio" id="nota5" name="notatr[<%=indice%>]" value="5">
																			</s:else>
																			<label for="nota5">5</label>
																			<% indice=indice+1; %>
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
	<% indice=0; %>
	<%! int ind = 0; %>
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
														
														<s:iterator value="compRelCompCompleto" var="relint" status="ind">
															<s:if test="%{ #relint.codcomp==#lacomp.codigo }">
																<s:set var="lanotaint"><s:property value="inexistente"/></s:set>
																<s:iterator value="listaValoraciones" var="valint">
																	<s:if test="%{#valint.dnievaluado==#evinterno.dnitrabajador && #valint.dnievaluador==dniActual && #valint.idcomp==#relint.idcomportamiento && #valint.codcomp==#relint.codcomp }">
																	
																		<s:set var="lanotaint"><s:property value="#valint.valoracion"/></s:set>
																	
																	</s:if>
																</s:iterator>
																<tr> 
																	<td><s:property value="#relint.descripcion"/></td>
																	<td>
<%-- 																		<input type="hidden" name="idrelint" value="<s:property value="#relint.idRel"/>"> --%>
																		<input type="hidden" name="codcompint" value="<s:property value="#relint.codcomp"/>">
																		<input type="hidden" name="idcompint" value="<s:property value="#relint.idcomportamiento"/>">
																		<input type="hidden" name="idnivelint" value="<s:property value="#relint.idnivel"/>">
																		<input type="hidden" name="dniint" value="<s:property value="#evinterno.dnitrabajador"/>">
																		
																			<s:if test="%{ #lanotaint == 1 }">
																				<input type="radio" id="nota1" name="notaint[<%=ind%>]" value="1" checked>
																			</s:if>
																			<s:else>
																				<input type="radio" id="nota1" name="notaint[<%=ind%>]" value="1">
																			</s:else>
																			<label for="nota1">1</label>
																			<s:if test="%{ #lanotaint == 2 }">
																				<input type="radio" id="nota2" name="notaint[<%=ind%>]" value="2" checked>
																			</s:if>
																			<s:else>
																				<input type="radio" id="nota2" name="notaint[<%=ind%>]" value="2">
																			</s:else>
																			<label for="nota2">2</label>
																			<s:if test="%{ #lanotaint == 3 }">
																				<input type="radio" id="nota3" name="notaint[<%=ind%>]" value="3" checked>
																			</s:if>
																			<s:else>
																				<input type="radio" id="nota3" name="notaint[<%=ind%>]" value="3">
																			</s:else>
																			<label for="nota3">3</label>
																			<s:if test="%{ #lanotaint == 4 }">
																				<input type="radio" id="nota4" name="notaint[<%=ind%>]" value="4" checked>
																			</s:if>
																			<s:else>
																				<input type="radio" id="nota4" name="notaint[<%=ind%>]" value="4">
																			</s:else>
																			<label for="nota4">4</label>
																			<s:if test="%{ #lanotaint == 5 }">
																				<input type="radio" id="nota5" name="notaint[<%=ind%>]" value="5" checked>
																			</s:if>
																			<s:else>
																				<input type="radio" id="nota5" name="notaint[<%=ind%>]" value="5">
																			</s:else>
																			<label for="nota5">5</label>
																		
																		<% ind=ind+1; %>
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
	<% ind=0; %>
	</form>
</s:iterator>