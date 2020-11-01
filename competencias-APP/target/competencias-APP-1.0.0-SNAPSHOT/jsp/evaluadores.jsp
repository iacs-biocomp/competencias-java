<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!-- Site favicon -->
<link rel='shortcut icon' type='image/x-icon' href='images/favicon.ico' />
<!-- /site favicon -->

<!-- Entypo font stylesheet -->
<link href="css/entypo.css" rel="stylesheet">
<!-- /entypo font stylesheet -->

<!-- Font awesome stylesheet -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<!-- /font awesome stylesheet -->

<!-- Bootstrap stylesheet min version -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- /bootstrap stylesheet min version -->

<!-- Mouldifi core stylesheet -->
<link href="css/mouldifi-core.css" rel="stylesheet">
<!-- /mouldifi core stylesheet -->

<link href="css/mouldifi-forms.css" rel="stylesheet">

      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>

<body>

<h1> Mis evaluadores</h1>


<div class="row">
	<div class="col-lg-12">
		<h2 class="title">Autoevaluación</h2>
		<div class="accordion" id="accordion2">
			<s:iterator value="trabajador" status="incr1">
					<div class="panel accordion-group">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#yoAcordeon"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
								</div>
						<div id="yoAcordeon" class="accordion-body collapse">
							<div class="accordion-inner">
								<s:if test="%{dni != null}">
									<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dni"/></h5>
								</s:if>
								<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
								<s:iterator value="listaCompetencias">
									<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
								</s:iterator>
							</div>
						</div>
					</div>
			</s:iterator>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<h2 class="title">Personas que me organizan el trabajo</h2>

			<!-- 			SUPERIORES -->
			<s:iterator value="listaSuperiores" status="incr8">
				<s:if test="%{dniTrabajador == dniActual}">
					<div class="panel accordion-group">
						<s:iterator value="listaTrabajadores">
							<s:if test="%{dniSuperior == dni}">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#<s:property value="%{#incr8.index}"/>8"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
								</div>
							</s:if>
						</s:iterator>
						<s:iterator value="listaExternos">
							<s:if test="%{dniSuperior == dni}">
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
								<s:iterator value="listaCompetencias">
									<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
								</s:iterator>
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
				<s:if test="%{dniSuperior == dniActual}">
					<div class="panel accordion-group">
						<s:iterator value="listaTrabajadores">
							<s:if test="%{dniTrabajador == dni}">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion9" href="#<s:property value="%{#incr9.index}"/>9"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
								</div>
							</s:if>
						</s:iterator>
						<s:iterator value="listaExternos">
							<s:if test="%{dniTrabajador == dni}">
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
								<s:iterator value="listaCompetencias">
									<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
								</s:iterator>
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
				<s:if test="%{dniTrabajador == dniActual}">
					<div class="panel accordion-group">
						<s:iterator value="listaTrabajadores">
							<s:if test="%{dniPar == dni}">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#<s:property value="%{#incr9.index}"/>9"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
								</div>
							</s:if>
						</s:iterator>
						<s:iterator value="listaExternos">
							<s:if test="%{dniPar == dni}">
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
								<s:iterator value="listaCompetencias">
									<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
								</s:iterator>
							</div>
						</div>
					</div>
				</s:if>
				<s:else>
					<s:if test="%{dniPar == dniActual}">
					<div class="panel accordion-group">
						<s:iterator value="listaTrabajadores">
							<s:if test="%{dniTrabajador == dni}">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion6" href="#acc6<s:property value="%{#incr9.index}"/>"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
								</div>
							</s:if>
						</s:iterator>
						<s:iterator value="listaExternos">
							<s:if test="%{dniTrabajador == dni}">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#acc6<s:property value="%{#incr9.index}"/>"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
								</div>
							</s:if>
						</s:iterator>
						<div id="acc6<s:property value="%{#incr9.index}"/>" class="accordion-body collapse">
							<div class="accordion-inner">
								<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dniTrabajador"/></h5>
								<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br>
								<s:iterator value="listaCompetencias">
									<h5><label class="col-sm-2 control-label"></label><s:property value="descripcion"/></h5>
								</s:iterator>
							</div>
						</div>
					</div>
					</s:if>
				</s:else>
			</s:iterator>
			<s:iterator value="evaluadoresInternos" status="incr1">
				<s:if test="%{dnitrabajador == dniActual && grupo == 1}">
					<div class="panel accordion-group">
						<s:iterator value="listaTrabajadores">
							<s:if test="%{dnievaluador == dni}">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="%{#incr1.index}"/>"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
									<h4 class="title" style="text-align:right"><a href="editarEvaluadorInternoEvaluadores?dniEvaluador=<s:property value="dnievaluador"/>"><i class="fas fa-edit" aria-hidden="true"></i></a><a href="borrarEvaluadorInternoEvaluadores?idRelacion=<s:property value="idrelacion"/>"/><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></h4>
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
									
								<s:if test="%{dniEditar == dnievaluador}">
									<form class="form-horizontal" method="post" action="/guardarEvaluadorInternoEvaluadores"> 	

											<div class="form-group"> 
												<label class="col-sm-2 control-label">Justificación:</label> 
												<div class="col-sm-10"> 
													<input type="hidden" value="<s:property value="idrelacion"/>" name="idRelacion"/>
													<textarea placeholder="Justificación" class="form-control" name="justificacion" required></textarea> 
												</div> 
											</div>
											<div class="form-group"> 
												<div class="col-sm-offset-2 col-sm-10"> 
													<button class="btn btn-default" type="submit">Guardar</button> 
												</div> 
											</div>
										</form>
								</s:if>
								<s:else>
									<h5><label class="col-sm-2 control-label">Justificación:</label><s:property value="justificacion"/> </h5>
								</s:else>
							</div>
						</div>
					</div>
				</s:if>
			</s:iterator>
			
			<s:iterator value="evaluadoresExternos"  status="incr2">
				<s:if test="%{dnitrabajador == dniActual && grupo == 1}">
					<div class="panel accordion-group">
						<s:iterator value="listaExternos" >
							<s:if test="%{idevaluador == id}">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#<s:property value="%{#incr2.index}"/>2"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
									<h4 class="title" style="text-align:right"><a href="editarEvaluadorExternoEvaluadores?idEvaluador=<s:property value="idevaluador"/>"><i class="fas fa-edit" aria-hidden="true"></i></a><a href="borrarEvaluadorExternoEvaluadores?idRelacion=<s:property value="idrelacion"/>"/><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></h4>
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
								<s:if test="%{idEditar == idevaluador}">
									
									<form class="form-horizontal" method="post" action="/guardarEvaluadorExternoEvaluadores"> 	

											<div class="form-group"> 
												<label class="col-sm-2 control-label">Justificación:</label> 
												<div class="col-sm-10"> 
													<input type="hidden" value="<s:property value="idrelacion"/>" name="idRelacion"/>
													<textarea placeholder="Justificación" class="form-control" name="justificacion" required></textarea> 
												</div> 
											</div>
											<div class="form-group"> 
												<div class="col-sm-offset-2 col-sm-10"> 
													<button class="btn btn-default" type="submit">Guardar</button> 
												</div> 
											</div>
										</form>
									
								</s:if>
								<s:else>
									<h5><label class="col-sm-2 control-label">Justificación:</label><s:property value="justificacion"/> </h5>
								</s:else>
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
				<s:if test="%{dnitrabajador == dniActual && grupo == 2}">
					<div class="panel accordion-group">
						<s:iterator value="listaTrabajadores">
							<s:if test="%{dnievaluador == dni}">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#<s:property value="%{#incr3.index}"/>3"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
									<h4 class="title" style="text-align:right"><a href="editarEvaluadorInternoEvaluadores?dniEvaluador=<s:property value="dnievaluador"/>"><i class="fas fa-edit" aria-hidden="true"></i></a><a href="borrarEvaluadorInternoEvaluadores?idRelacion=<s:property value="idrelacion"/>"/><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></h4>
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
								<s:if test="%{dniEditar == dnievaluador}">
									<form class="form-horizontal" method="post" action="/guardarEvaluadorInternoEvaluadores"> 	

											<div class="form-group"> 
												<label class="col-sm-2 control-label">Justificación:</label> 
												<div class="col-sm-10"> 
													<input type="hidden" value="<s:property value="idrelacion"/>" name="idRelacion"/>
													<textarea placeholder="Justificación" class="form-control" name="justificacion" required></textarea> 
												</div> 
											</div>
											<div class="form-group"> 
												<div class="col-sm-offset-2 col-sm-10"> 
													<button class="btn btn-default" type="submit">Guardar</button> 
												</div> 
											</div>
										</form>
								</s:if>
								<s:else>
									<h5><label class="col-sm-2 control-label">Justificación:</label><s:property value="justificacion"/> </h5>
								</s:else>
								
								 
							</div>
						</div>
					</div>
				</s:if>
			</s:iterator>
			
			<s:iterator value="evaluadoresExternos"  status="incr4">
				<s:if test="%{dnitrabajador == dniActual && grupo == 2}">
					<div class="panel accordion-group">
						<s:iterator value="listaExternos">
							<s:if test="%{idevaluador == id}">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion4" href="#<s:property value="%{#incr4.index}"/>4"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
									<h4 class="title" style="text-align:right"><a href="editarEvaluadorExternoEvaluadores?idEvaluador=<s:property value="idevaluador"/>"><i class="fas fa-edit" aria-hidden="true"></i></a><a href="borrarEvaluadorExternoEvaluadores?idRelacion=<s:property value="idrelacion"/>"/><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></h4>
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
								<s:if test="%{idEditar == idevaluador}">
										<form class="form-horizontal" method="post" action="/guardarEvaluadorExternoEvaluadores"> 	
											<div class="form-group"> 
												<label class="col-sm-2 control-label">Justificación:</label> 
												<div class="col-sm-10"> 
													<input type="hidden" value="<s:property value="idrelacion"/>" name="idRelacion"/>
													<textarea placeholder="Justificación" class="form-control" name="justificacion" required></textarea> 
												</div> 
											</div>
											<div class="form-group"> 
												<div class="col-sm-offset-2 col-sm-10"> 
													<button class="btn btn-default" type="submit">Guardar</button> 
												</div> 
											</div>
										</form>
								</s:if>
								<s:else>
									<h5><label class="col-sm-2 control-label">Justificación:</label><s:property value="justificacion"/> </h5>
								</s:else>
							</div>
						</div>
					</div>
				</s:if>
			</s:iterator>
		</div>
	</div>
</div>


<div id="modal-2" class="modal fade" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">Nuevo evaluador externo</h4>
	      </div>
	      <div class="modal-body">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-body">
							 <form class="form-horizontal" method="post" action="/nuevoExternoEvaluadores">
							 	<div class="form-group"> 
									<label class="col-sm-2 control-label">Nombre</label> 
									<div class="col-sm-10"> 
										<input type="text" id="nombre" name="nombre" placeholder="Nombre" class="form-control" required> 
									</div> 
								</div>
								<div class="line-dashed"></div>
								<div class="form-group"> 
									<label class="col-sm-2 control-label">Apellidos</label> 
									<div class="col-sm-10"> 
										<input type="text" id="apellidos" name="apellidos" placeholder="Apellidos" class="form-control" required> 
									</div> 
								</div>
								<div class="line-dashed"></div>
								<div class="form-group"> 
									<label class="col-sm-2 control-label">Email</label> 
									<div class="col-sm-10"> 
										<input type="text" id="email" name="email" placeholder="Email" class="form-control" required> 
									</div> 
								</div>
								 <div class="line-dashed"></div>
								<div class="form-group"> 
									<label class="col-sm-2 control-label">Institución a la que pertenece</label> 
									<div class="col-sm-10"> 
										<input type="text" id="institucion" name="institucion" placeholder="Institución" class="form-control" required> 
									</div> 
								</div>
								
								<div class="line-dashed"></div>
								<div class="form-group"> 
									<div class="col-sm-offset-2 col-sm-10"> 
										<button type="Submit" class="btn btn-primary">Añadir evaluador externo</button>
									</div> 
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
	    </div>
	  </div>
	</div>
</div>	

<s:if test="%{ activoEvaluadores == true}">
	<div class="row">
		<div class="col-md-12">
			<div class="tabs-container">
				<ul class="nav nav-tabs">
					<li class="active"><a aria-expanded="true" href="#externo" data-toggle="tab">Externo</a></li>
					<li><a aria-expanded="false" href="#interno" data-toggle="tab">Interno</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="externo">
						<div class="panel panel-default">
							<div class="panel-heading clearfix">
								<h3 class="panel-title">Nueva propuesta de evaluador externo </h3>
								<h3 style="text-align: right"> <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-2">Añadir evaluador externo <i class="fa fa-plus" aria-hidden="true" ></i></button></h3>
							</div>
							<div class="panel-body">
								<form class="form-horizontal" method="post" action="/nuevaPropuestaExternoEvaluadores">
									<div class="form-group"> 
										<label class="col-sm-2 control-label">Seleccione trabajador del IACS:</label> 
										<div class="col-sm-10"> 
											<select class="form-control" name="idEvaluador" required> 
												<s:iterator value="listaExternos">
													<s:if test="%{dni != null && dni != \"\"}">
														<option value="<s:property value="id"/>"><s:property value="nombre"/> <s:property value="apellidos"/></option> 
													</s:if>
												</s:iterator>
											</select>
										</div> 
									</div>
									<div class="line-dashed"></div>
									<div class="form-group"> 
										<label class="col-sm-2 control-label">Seleccione grupo evaluador al que pertenece:</label> 
										<div class="col-sm-10"> 
											<select class="form-control" name="grupo" required> 
												<option value="1">Personas que trabajan conmigo</option> 
												<option value="2">Personas a las que entrego mi trabajo</option>
											</select>
										</div> 
									</div>
									<div class="line-dashed"></div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Marque las competencias a evaluar: </label>		
										<div class="col-sm-offset-2 col-sm-10"> 
											<s:iterator value="listaCompetencias" status="incr">
												<div class="checkbox"> <label> <input type="checkbox" name="comp<s:property value="%{#incr.index}"/>" value="<s:property value="codcompetencia"/>"><s:property value="descripcion"/> </label> </div> 
											</s:iterator>
										</div>
									</div>
									<div class="line-dashed"></div>
										<div class="form-group"> 
											<label class="col-sm-2 control-label">Justifique por qué debe evaluarle:</label> 
											<div class="col-sm-10"> 
												<textarea placeholder="Justificación" class="form-control" name="justificacion" required></textarea> 
											</div> 
										</div>
										<div class="line-dashed"></div>
											<div class="form-group"> 
												<div class="col-sm-offset-2 col-sm-10"> 
													<button class="btn btn-default" type="submit">Añadir propuesta</button> 
												</div> 
											</div>
										</div>
									</div>
								</form>	
							</div>
							<div class="tab-pane" id="interno">
								<div class="panel panel-default">
									<div class="panel-heading clearfix">
										<h3 class="panel-title">Nueva propuesta de evaluador interno </h3>
										
									</div>
									<div class="panel-body">
										<form class="form-horizontal" method="post" action="/nuevaPropuestaInternoEvaluadores"> 	
											<div class="form-group"> 
												<label class="col-sm-2 control-label">Seleccione trabajador del IACS:</label> 
												<div class="col-sm-10"> 
													<select class="form-control" name="dniEvaluador" required> 
														<s:iterator value="listaTrabajadores">
															<option value="<s:property value="dni"/>"><s:property value="nombre"/> <s:property value="apellidos"/></option> 
														</s:iterator>
													</select>
												</div> 
											</div>
											<div class="line-dashed"></div>
												<div class="form-group"> 
													<label class="col-sm-2 control-label">Seleccione grupo evaluador al que pertenece:</label> 
													<div class="col-sm-10"> 
														<select class="form-control" name="grupo" required> 
															<option value="1">Personas que trabajan conmigo</option> 
															<option value="2">Personas a las que entrego mi trabajo</option>
														</select>
													</div> 
												</div>
												<div class="line-dashed"></div>
												<div class="form-group">
													<label class="col-sm-2 control-label">Marque las competencias a evaluar: </label>
													<div class="col-sm-offset-2 col-sm-10"> 
														<s:iterator value="listaCompetencias" status="incr">
															<div class="checkbox"> <label> <input type="checkbox" name="comp<s:property value="%{#incr.index}"/>" value="<s:property value="codcompetencia"/>"><s:property value="descripcion"/> </label> </div> 
														 </s:iterator>
													</div>
												</div>
												<div class="line-dashed"></div>
												<div class="form-group"> 
													<label class="col-sm-2 control-label">Justifique por qué debe evaluarle:</label> 
													<div class="col-sm-10"> 
														<textarea placeholder="Justificación" class="form-control" name="justificacion" required></textarea> 
													</div> 
												</div>
												<div class="line-dashed"></div>
												<div class="form-group"> 
													<div class="col-sm-offset-2 col-sm-10"> 
														<button class="btn btn-default" type="submit">Añadir propuesta</button> 
													</div> 
												</div>
											
											</div>
										</form>
									</div>
									
								</div>
							</div>
						</div>
					</div>
	</div>	
</s:if>

		

</body>

