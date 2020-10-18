<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1> Mis supervisados</h1>

<s:iterator value="listaSuperiores" status="incr">
	<s:if test="%{dniSuperior == dniActual}">
	
	<div class="row">
		<div class="col-lg-12">
			<s:iterator value="listaTrabajadores" var="posiblesSupervisados">
				<s:if test="%{dniTrabajador == #posiblesSupervisados.dni}">
					<h2 class="title"><s:property value="nombre"/> <s:property value="apellidos"/></h2>

					<div class="row">
						<div class="col-lg-12">
							<h2 class="title">Autoevaluación</h2>
							<div class="accordion" id="accordion2">
										<div class="panel accordion-group">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#yoAcordeon"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
													</div>
											<div id="yoAcordeon" class="accordion-body collapse">
												<div class="accordion-inner">
													<s:if test="%{#posiblesSupervisados.dni != null}">
														<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="#posiblesSupervisados.dni"/></h5>
													</s:if>
													<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
<%-- 													<s:iterator value="compObjCompCatcomp"> --%>
<%-- 														<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5> --%>
<%-- 													</s:iterator> --%>
												</div>
											</div>
										</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-12">
							<h2 class="title">Personas que me organizan el trabajo</h2>
					
								<!-- 			SUPERIORES -->
								<s:iterator value="listaSuperiores" status="incr8">
									<s:if test="%{dniTrabajador == #posiblesSupervisados.dni}">
										<div class="panel accordion-group">
											<s:iterator value="listaTrabajadores" var="trabajador">
												<s:if test="%{dniSuperior == #trabajador.dni}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#<s:property value="%{#incr8.index}"/>8"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<s:iterator value="listaExternos" var="externo">
												<s:if test="%{dniSuperior == #externo.dni}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#<s:property value="%{#incr8.index}"/>8"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<div id="<s:property value="%{#incr8.index}"/>8" class="accordion-body collapse">
												<div class="accordion-inner">
													<s:if test="%{dniSuperior != null}">
														<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dniSuperior"/></h5>
													</s:if>
													<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
<%-- 													<s:iterator value="compObjCompCatcomp"> --%>
<%-- 														<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5> --%>
<%-- 													</s:iterator> --%>
												</div>
											</div>
										</div>
									</s:if>
								</s:iterator>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-12">
							<h2 class="title">Personas a las que organizo el trabajo</h2>
								<!-- 			SUPERIORES -->
								<s:iterator value="listaSuperiores" status="incr9">
									<s:if test="%{dniSuperior == #posiblesSupervisados.dni}">
										<div class="panel accordion-group">
											<s:iterator value="listaTrabajadores" var="trabajador">
												<s:if test="%{dniTrabajador == #trabajador.dni}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion9" href="#<s:property value="%{#incr9.index}"/>9"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<s:iterator value="listaExternos" var="externo">
												<s:if test="%{dniTrabajador == #externo.dni}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion9" href="#<s:property value="%{#incr9.index}"/>9"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<div id="<s:property value="%{#incr9.index}"/>9" class="accordion-body collapse">
												<div class="accordion-inner">
													<s:if test="%{dniTrabajador != null}">
														<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dniTrabajador"/></h5>
													</s:if>
													<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
<%-- 													<s:iterator value="compObjCompCatcomp"> --%>
<%-- 														<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5> --%>
<%-- 													</s:iterator> --%>
												</div>
											</div>
										</div>
									</s:if>
								</s:iterator>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-12">
							<h2 class="title">Personas que trabajan conmigo</h2>
							<div class="accordion" id="accordion2">
								
					<!-- 			PARES -->
								<s:iterator value="listaPares" status="incr9">
									<s:if test="%{dniTrabajador == #posiblesSupervisados.dni}">
										<div class="panel accordion-group">
											<s:iterator value="listaTrabajadores" var="trabajador">
												<s:if test="%{dniPar == #trabajador.dni}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#<s:property value="%{#incr9.index}"/>9"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<s:iterator value="listaExternos" var="externo">
												<s:if test="%{dniPar == #externo.dni}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#<s:property value="%{#incr9.index}"/>9"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<div id="<s:property value="%{#incr9.index}"/>9" class="accordion-body collapse">
												<div class="accordion-inner">
													<s:if test="%{dniPar != null}">
														<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dniPar"/></h5>
													</s:if>
													<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
<%-- 													<s:iterator value="compObjCompCatcomp"> --%>
<%-- 														<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5> --%>
<%-- 													</s:iterator> --%>
												</div>
											</div>
										</div>
									</s:if>
									<s:else>
										<s:if test="%{dniPar == #posiblesSupervisados.dni}">
										<div class="panel accordion-group">
											<s:iterator value="listaTrabajadores" var="trabajador">
												<s:if test="%{dniTrabajador == #trabajador.dni}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#<s:property value="%{#incr9.index}"/>9"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<s:iterator value="listaExternos" var="externo">
												<s:if test="%{dniTrabajador == #externo.dni}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#<s:property value="%{#incr9.index}"/>9"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<div id="<s:property value="%{#incr9.index}"/>9" class="accordion-body collapse">
												<div class="accordion-inner">
													<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dniTrabajador"/></h5>
													<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
<%-- 													<s:iterator value="compObjCompCatcomp"> --%>
<%-- 														<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5> --%>
<%-- 													</s:iterator> --%>
												</div>
											</div>
										</div>
										</s:if>
									</s:else>
								</s:iterator>
								<s:iterator value="evaluadoresInternos" status="incr1">
									<s:if test="%{dnitrabajador == #posiblesSupervisados.dni && grupo == 1}">
										<div class="panel accordion-group">
											<s:iterator value="listaTrabajadores" var="trabajador">
												<s:if test="%{dnievaluador == #trabajador.dni}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="%{#incr1.index}"/>"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
														<h4 class="title" style="text-align:right"><a href="borrarEvaluadorInternoEvaluadores?idRelacion=<s:property value="idrelacion"/>"/><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></h4>
													</div>
												</s:if>
											</s:iterator>
											
											<div id="<s:property value="%{#incr1.index}"/>" class="accordion-body collapse">
												<div class="accordion-inner">
													<s:if test="%{dnievaluador != null}">
														<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dnievaluador"/></h5>
													</s:if>
													<s:if test="%{validado == true}">
														<h5><label class="col-sm-2 control-label">Validado:</label> Si</h5>
													</s:if>
													<s:else>
														<h5><label class="col-sm-2 control-label">Validado:</label> No</h5>
													</s:else>
													<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
													<s:iterator value="listaCompetencias">
														<s:if test="%{comp1 != null && comp1 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp2 != null && comp2 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp3 != null && comp3 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp4 != null && comp4 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp5 != null && comp5 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp6 != null && comp6 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp7 != null && comp7 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp8 != null && comp8 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp9 != null && comp9 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp10 != null && comp10 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
													</s:iterator>	
														
													
													<h5><label class="col-sm-2 control-label">Justificación:</label><s:property value="justificacion"/> </h5>
													
												</div>
											</div>
										</div>
									</s:if>
								</s:iterator>
								
								<s:iterator value="evaluadoresExternos"  status="incr2">
									<s:if test="%{dnitrabajador == #posiblesSupervisados.dni && grupo == 1}">
										<div class="panel accordion-group">
											<s:iterator value="listaExternos" var="externo">
												<s:if test="%{idevaluador == #externo.id}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#<s:property value="%{#incr2.index}"/>2"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
														<h4 class="title" style="text-align:right"><a href="borrarEvaluadorExternoEvaluadores?idRelacion=<s:property value="idrelacion"/>"/><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<div id="<s:property value="%{#incr2.index}"/>2" class="accordion-body collapse">
												<div class="accordion-inner">
													<s:if test="%{dnievaluador != null}">
														<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dnievaluador"/></h5>
													</s:if>
													<s:if test="%{validado == true}">
														<h5><label class="col-sm-2 control-label">Validado:</label> Si</h5>
													</s:if>
													<s:else>
														<h5><label class="col-sm-2 control-label">Validado:</label> No</h5>
													</s:else>
													
													<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
													<s:iterator value="listaCompetencias">
														<s:if test="%{comp1 != null && comp1 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp2 != null && comp2 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp3 != null && comp3 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp4 != null && comp4 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp5 != null && comp5 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp6 != null && comp6 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp7 != null && comp7 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp8 != null && comp8 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp9 != null && comp9 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp10 != null && comp10 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
													</s:iterator>	
													
													
													<h5><label class="col-sm-2 control-label">Justificación:</label><s:property value="justificacion"/> </h5>
													
												</div>
											</div>
										</div>
									</s:if>
								</s:iterator>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-12">
							<h2 class="title">Personas a las que entrego mi trabajo</h2>
							<div class="accordion" id="accordion2">
								<s:iterator value="evaluadoresInternos"  status="incr3">
									<s:if test="%{dnitrabajador == #posiblesSupervisados.dni && grupo == 2}">
										<div class="panel accordion-group">
											<s:iterator value="listaTrabajadores" var="trabajador">
												<s:if test="%{dnievaluador == #trabajador.dni}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#<s:property value="%{#incr3.index}"/>3"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
														<h4 class="title" style="text-align:right"><a href="borrarEvaluadorInternoEvaluadores?idRelacion=<s:property value="idrelacion"/>"/><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<div id="<s:property value="%{#incr3.index}"/>3" class="accordion-body collapse">
												<div class="accordion-inner">
													<s:if test="%{dnievaluador != null}">
														<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dnievaluador"/></h5>
													</s:if>
													<s:if test="%{validado == true}">
														<h5><label class="col-sm-2 control-label">Validado:</label> Si</h5>
													</s:if>
													<s:else>
														<h5><label class="col-sm-2 control-label">Validado:</label> No</h5>
													</s:else>
													<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
													<s:iterator value="listaCompetencias">
														<s:if test="%{comp1 != null && comp1 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp2 != null && comp2 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp3 != null && comp3 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp4 != null && comp4 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp5 != null && comp5 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp6 != null && comp6 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp7 != null && comp7 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp8 != null && comp8 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp9 != null && comp9 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp10 != null && comp10 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
													</s:iterator>	
													
													<h5><label class="col-sm-2 control-label">Justificación:</label><s:property value="justificacion"/> </h5>
													
													
													 
												</div>
											</div>
										</div>
									</s:if>
								</s:iterator>
								
								<s:iterator value="evaluadoresExternos"  status="incr4">
									<s:if test="%{dnitrabajador == #posiblesSupervisados.dni && grupo == 2}">
										<div class="panel accordion-group">
											<s:iterator value="listaExternos" var="externo">
												<s:if test="%{idevaluador == #externo.id}">
													<div class="accordion-heading">
														<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion4" href="#<s:property value="%{#incr4.index}"/>4"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
														<h4 class="title" style="text-align:right"><a href="borrarEvaluadorExternoEvaluadores?idRelacion=<s:property value="idrelacion"/>"/><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></h4>
													</div>
												</s:if>
											</s:iterator>
											<div id="<s:property value="%{#incr4.index}"/>4" class="accordion-body collapse">
												<div class="accordion-inner">
													<s:if test="%{dnievaluador != null}">
														<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dnievaluador"/></h5>
													</s:if>
													<s:if test="%{validado == true}">
														<h5><label class="col-sm-2 control-label">Validado:</label> Si</h5>
													</s:if>
													<s:else>
														<h5><label class="col-sm-2 control-label">Validado:</label> No</h5>
													</s:else>
													<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
													<s:iterator value="listaCompetencias">
														<s:if test="%{comp1 != null && comp1 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp2 != null && comp2 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp3 != null && comp3 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp4 != null && comp4 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp5 != null && comp5 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp6 != null && comp6 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp7 != null && comp7 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp8 != null && comp8 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp9 != null && comp9 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
														<s:if test="%{comp10 != null && comp10 == codigo}">
															<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
														</s:if>
													</s:iterator>	
												
													<h5><label class="col-sm-2 control-label">Justificación:</label><s:property value="justificacion"/> </h5>

												</div>
											</div>
										</div>
									</s:if>
								</s:iterator>
							</div>
						</div>
					</div>
			
					
					
				</s:if>
			</s:iterator>
			
			
			
			
			
			
			
			
			
			
			
		</div>
	</div>
	</s:if>
</s:iterator>