<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1> Evaluacion concreta (evaluar) <s:property value="id"/></h1>

<p> Puedes evaluar y guardar los resultados cuando quieras. Cada vez que regargas la pag se recargan los resultados que hay hasta el momento. Puedes editar siempre
que quieras. Cuando se acaba la fecha de evaluar se quedan los guardados y ya no se pueden editar ni añadir </p>

<s:iterator value="evaluacionActual" var="evaluacion">
	<s:iterator value="listaTrabajadores" var="trabajador">
		
			<div class="row">
				<div class="col-lg-12">
					<h2 class="title"><s:property value="nombre"/> <s:property value="apellidos"/></h2>

							
						<div class="accordion" id="accordion">
		
							<div class="panel accordion-group">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#acc1">Competencia 1</a> </h4>
								</div>
								<div id="acc1" class="accordion-body collapse">
									<div class="accordion-inner">
										<div class="accordion" id="accordion2">
								
												<div class="panel accordion-group">
													<div class="accordion-heading">
															<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#acc2">Nivel 1</a></h4>
													</div>
													<div id="acc2" class="accordion-body collapse">
														<div class="accordion-inner">
															<table class="table">
																
																		<tr> 
																			<td>Comportamiento 1</td>
																		</tr>
																		<tr> 
																			<td>Comportamiento 1</td>
																		</tr>
																		<tr> 
																			<td>Comportamiento 1</td>
																		</tr>
																		<tr> 
																			<td>Comportamiento 1</td>
																		</tr>
																	
															</table>   
														</div>
													</div>
												</div>
									
										</div>			
									</div>
								</div>
							</div>
					
						</div>
				</div>
			</div>
	
	</s:iterator>
</s:iterator>