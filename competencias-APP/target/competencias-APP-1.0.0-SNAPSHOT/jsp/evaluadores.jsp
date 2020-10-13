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
<!-- 		<div class="accordion" id="accordion2"> -->
<%-- 			<s:iterator value="evaluadoresInternos"> --%>
<%-- 				<s:if test="%{dnitrabajador == dniActual && grupo == 1}"> --%>
<!-- 					<div class="panel accordion-group"> -->
<%-- 						<s:iterator value="listaTrabajadores"> --%>
<%-- 							<s:if test="%{dnievaluador == dni}"> --%>
<!-- 								<div class="accordion-heading"> -->
<%-- 									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"><s:property value="nombre"/><s:property value="apellidos"/></a></h4> --%>
<!-- 								</div> -->
<%-- 							</s:if> --%>
<%-- 						</s:iterator> --%>
<!-- 						<div id="collapseOne" class="accordion-body collapse"> -->
<!-- 							<div class="accordion-inner"> -->
<%-- 								<h3>DNI: <s:property value="dnievaluador"/></h3> --%>
<%-- 								<h3>Justificación: <s:property value="justificacion"/></h3> --%>
<%-- 								<h3>Validado: <s:property value="validado"/></h3> --%>
<!-- 								<h3>Competencias que evalua: </h3> -->
<%-- 								<h3><s:property value="comp1"/></h3> --%>
<%-- 								<h3><s:property value="comp2"/></h3> --%>
<%-- 								<h3><s:property value="comp3"/></h3> --%>
<%-- 								<h3><s:property value="comp4"/></h3> --%>
<%-- 								<h3><s:property value="comp5"/></h3> --%>
<%-- 								<h3><s:property value="comp6"/></h3> --%>
<%-- 								<h3><s:property value="comp7"/></h3> --%>
<%-- 								<h3><s:property value="comp8"/></h3> --%>
<%-- 								<h3><s:property value="comp9"/></h3> --%>
<%-- 								<h3><s:property value="comp10"/></h3> --%>
								 
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</s:if> --%>
<%-- 			</s:iterator> --%>
			
<%-- 			<s:iterator value="evaluadoresExternos"> --%>
<%-- 				<s:if test="%{dnitrabajador == dniActual && grupo == 1}"> --%>
<!-- 					<div class="panel accordion-group"> -->
<%-- 						<s:iterator value="listaExternos"> --%>
<%-- 							<s:if test="%{idevaluador == id}"> --%>
<!-- 								<div class="accordion-heading"> -->
<%-- 									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"><s:property value="nombre"/><s:property value="apellidos"/></a></h4> --%>
<!-- 								</div> -->
<%-- 							</s:if> --%>
<%-- 						</s:iterator> --%>
<!-- 						<div id="collapseOne" class="accordion-body collapse"> -->
<!-- 							<div class="accordion-inner"> -->
<!-- 								<h3>DNI: </h3> -->
<%-- 								<h3>Justificación: <s:property value="justificacion"/></h3> --%>
<%-- 								<h3>Validado: <s:property value="validado"/></h3> --%>
<!-- 								<h3>Competencias que evalua: </h3> -->
<%-- 								<h3><s:property value="comp1"/></h3> --%>
<%-- 								<h3><s:property value="comp2"/></h3> --%>
<%-- 								<h3><s:property value="comp3"/></h3> --%>
<%-- 								<h3><s:property value="comp4"/></h3> --%>
<%-- 								<h3><s:property value="comp5"/></h3> --%>
<%-- 								<h3><s:property value="comp6"/></h3> --%>
<%-- 								<h3><s:property value="comp7"/></h3> --%>
<%-- 								<h3><s:property value="comp8"/></h3> --%>
<%-- 								<h3><s:property value="comp9"/></h3> --%>
<%-- 								<h3><s:property value="comp10"/></h3> --%>
								 
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</s:if> --%>
<%-- 			</s:iterator> --%>
<!-- 		</div> -->
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<h2 class="title">Personas que me organizan el trabajo</h2>
<!-- 		<div class="accordion" id="accordion2"> -->
<%-- 			<s:iterator value="evaluadoresInternos"> --%>
<%-- 				<s:if test="%{dnitrabajador == dniActual && grupo == 1}"> --%>
<!-- 					<div class="panel accordion-group"> -->
<%-- 						<s:iterator value="listaTrabajadores"> --%>
<%-- 							<s:if test="%{dnievaluador == dni}"> --%>
<!-- 								<div class="accordion-heading"> -->
<%-- 									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"><s:property value="nombre"/><s:property value="apellidos"/></a></h4> --%>
<!-- 								</div> -->
<%-- 							</s:if> --%>
<%-- 						</s:iterator> --%>
<!-- 						<div id="collapseOne" class="accordion-body collapse"> -->
<!-- 							<div class="accordion-inner"> -->
<%-- 								<h3>DNI: <s:property value="dnievaluador"/></h3> --%>
<%-- 								<h3>Justificación: <s:property value="justificacion"/></h3> --%>
<%-- 								<h3>Validado: <s:property value="validado"/></h3> --%>
<!-- 								<h3>Competencias que evalua: </h3> -->
<%-- 								<h3><s:property value="comp1"/></h3> --%>
<%-- 								<h3><s:property value="comp2"/></h3> --%>
<%-- 								<h3><s:property value="comp3"/></h3> --%>
<%-- 								<h3><s:property value="comp4"/></h3> --%>
<%-- 								<h3><s:property value="comp5"/></h3> --%>
<%-- 								<h3><s:property value="comp6"/></h3> --%>
<%-- 								<h3><s:property value="comp7"/></h3> --%>
<%-- 								<h3><s:property value="comp8"/></h3> --%>
<%-- 								<h3><s:property value="comp9"/></h3> --%>
<%-- 								<h3><s:property value="comp10"/></h3> --%>
								 
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</s:if> --%>
<%-- 			</s:iterator> --%>
			
<%-- 			<s:iterator value="evaluadoresExternos"> --%>
<%-- 				<s:if test="%{dnitrabajador == dniActual && grupo == 1}"> --%>
<!-- 					<div class="panel accordion-group"> -->
<%-- 						<s:iterator value="listaExternos"> --%>
<%-- 							<s:if test="%{idevaluador == id}"> --%>
<!-- 								<div class="accordion-heading"> -->
<%-- 									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"><s:property value="nombre"/><s:property value="apellidos"/></a></h4> --%>
<!-- 								</div> -->
<%-- 							</s:if> --%>
<%-- 						</s:iterator> --%>
<!-- 						<div id="collapseOne" class="accordion-body collapse"> -->
<!-- 							<div class="accordion-inner"> -->
<!-- 								<h3>DNI: </h3> -->
<%-- 								<h3>Justificación: <s:property value="justificacion"/></h3> --%>
<%-- 								<h3>Validado: <s:property value="validado"/></h3> --%>
<!-- 								<h3>Competencias que evalua: </h3> -->
<%-- 								<h3><s:property value="comp1"/></h3> --%>
<%-- 								<h3><s:property value="comp2"/></h3> --%>
<%-- 								<h3><s:property value="comp3"/></h3> --%>
<%-- 								<h3><s:property value="comp4"/></h3> --%>
<%-- 								<h3><s:property value="comp5"/></h3> --%>
<%-- 								<h3><s:property value="comp6"/></h3> --%>
<%-- 								<h3><s:property value="comp7"/></h3> --%>
<%-- 								<h3><s:property value="comp8"/></h3> --%>
<%-- 								<h3><s:property value="comp9"/></h3> --%>
<%-- 								<h3><s:property value="comp10"/></h3> --%>
								 
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</s:if> --%>
<%-- 			</s:iterator> --%>
<!-- 		</div> -->
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<h2 class="title">Personas a las que organizo el trabajo</h2>
<!-- 		<div class="accordion" id="accordion2"> -->
<%-- 			<s:iterator value="evaluadoresInternos"> --%>
<%-- 				<s:if test="%{dnitrabajador == dniActual && grupo == 1}"> --%>
<!-- 					<div class="panel accordion-group"> -->
<%-- 						<s:iterator value="listaTrabajadores"> --%>
<%-- 							<s:if test="%{dnievaluador == dni}"> --%>
<!-- 								<div class="accordion-heading"> -->
<%-- 									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"><s:property value="nombre"/><s:property value="apellidos"/></a></h4> --%>
<!-- 								</div> -->
<%-- 							</s:if> --%>
<%-- 						</s:iterator> --%>
<!-- 						<div id="collapseOne" class="accordion-body collapse"> -->
<!-- 							<div class="accordion-inner"> -->
<%-- 								<h3>DNI: <s:property value="dnievaluador"/></h3> --%>
<%-- 								<h3>Justificación: <s:property value="justificacion"/></h3> --%>
<%-- 								<h3>Validado: <s:property value="validado"/></h3> --%>
<!-- 								<h3>Competencias que evalua: </h3> -->
<%-- 								<h3><s:property value="comp1"/></h3> --%>
<%-- 								<h3><s:property value="comp2"/></h3> --%>
<%-- 								<h3><s:property value="comp3"/></h3> --%>
<%-- 								<h3><s:property value="comp4"/></h3> --%>
<%-- 								<h3><s:property value="comp5"/></h3> --%>
<%-- 								<h3><s:property value="comp6"/></h3> --%>
<%-- 								<h3><s:property value="comp7"/></h3> --%>
<%-- 								<h3><s:property value="comp8"/></h3> --%>
<%-- 								<h3><s:property value="comp9"/></h3> --%>
<%-- 								<h3><s:property value="comp10"/></h3> --%>
								 
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</s:if> --%>
<%-- 			</s:iterator> --%>
			
<%-- 			<s:iterator value="evaluadoresExternos"> --%>
<%-- 				<s:if test="%{dnitrabajador == dniActual && grupo == 1}"> --%>
<!-- 					<div class="panel accordion-group"> -->
<%-- 						<s:iterator value="listaExternos"> --%>
<%-- 							<s:if test="%{idevaluador == id}"> --%>
<!-- 								<div class="accordion-heading"> -->
<%-- 									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"><s:property value="nombre"/><s:property value="apellidos"/></a></h4> --%>
<!-- 								</div> -->
<%-- 							</s:if> --%>
<%-- 						</s:iterator> --%>
<!-- 						<div id="collapseOne" class="accordion-body collapse"> -->
<!-- 							<div class="accordion-inner"> -->
<!-- 								<h3>DNI: </h3> -->
<%-- 								<h3>Justificación: <s:property value="justificacion"/></h3> --%>
<%-- 								<h3>Validado: <s:property value="validado"/></h3> --%>
<!-- 								<h3>Competencias que evalua: </h3> -->
<%-- 								<h3><s:property value="comp1"/></h3> --%>
<%-- 								<h3><s:property value="comp2"/></h3> --%>
<%-- 								<h3><s:property value="comp3"/></h3> --%>
<%-- 								<h3><s:property value="comp4"/></h3> --%>
<%-- 								<h3><s:property value="comp5"/></h3> --%>
<%-- 								<h3><s:property value="comp6"/></h3> --%>
<%-- 								<h3><s:property value="comp7"/></h3> --%>
<%-- 								<h3><s:property value="comp8"/></h3> --%>
<%-- 								<h3><s:property value="comp9"/></h3> --%>
<%-- 								<h3><s:property value="comp10"/></h3> --%>
								 
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</s:if> --%>
<%-- 			</s:iterator> --%>
<!-- 		</div> -->
	</div>
</div>


<div class="row">
	<div class="col-lg-12">
		<h2 class="title">Personas que trabajan conmigo</h2>
		<div class="accordion" id="accordion2">
			<s:iterator value="evaluadoresInternos" status="incr1">
				<s:if test="%{dnitrabajador == dniActual && grupo == 1}">
					<div class="panel accordion-group">
						<s:iterator value="listaTrabajadores">
							<s:if test="%{dnievaluador == dni}">
								<div class="accordion-heading">
									<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="%{#incr1.index}"/>"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4>
								</div>
							</s:if>
						</s:iterator>
						<div id="<s:property value="%{#incr1.index}"/>" class="accordion-body collapse">
							<div class="accordion-inner">
								<h3>DNI: <s:property value="dnievaluador"/></h3>
								<h3>Justificación: <s:property value="justificacion"/></h3>
								<s:if test="%{validado == true}">
									<h3>Validado: Sí</h3>
								</s:if>
								<s:else>
									<h3>Validado: No</h3>
								</s:else>
								<h3>Competencias que evalua: </h3>
								<h3><s:property value="comp1"/></h3>
								<h3><s:property value="comp2"/></h3>
								<h3><s:property value="comp3"/></h3>
								<h3><s:property value="comp4"/></h3>
								<h3><s:property value="comp5"/></h3>
								<h3><s:property value="comp6"/></h3>
								<h3><s:property value="comp7"/></h3>
								<h3><s:property value="comp8"/></h3>
								<h3><s:property value="comp9"/></h3>
								<h3><s:property value="comp10"/></h3>
								 
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
								</div>
							</s:if>
						</s:iterator>
						<div id="<s:property value="%{#incr2.index}"/>2" class="accordion-body collapse">
							<div class="accordion-inner">
								<h3>DNI: </h3>
								<h3>Justificación: <s:property value="justificacion"/></h3>
								<s:if test="%{validado == true}">
									<h3>Validado: Sí</h3>
								</s:if>
								<s:else>
									<h3>Validado: No</h3>
								</s:else>
								
								<h3>Competencias que evalua: </h3>
								<h3><s:property value="comp1"/></h3>
								<h3><s:property value="comp2"/></h3>
								<h3><s:property value="comp3"/></h3>
								<h3><s:property value="comp4"/></h3>
								<h3><s:property value="comp5"/></h3>
								<h3><s:property value="comp6"/></h3>
								<h3><s:property value="comp7"/></h3>
								<h3><s:property value="comp8"/></h3>
								<h3><s:property value="comp9"/></h3>
								<h3><s:property value="comp10"/></h3>
								 
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
								</div>
							</s:if>
						</s:iterator>
						<div id="<s:property value="%{#incr3.index}"/>3" class="accordion-body collapse">
							<div class="accordion-inner">
								<h3>DNI: <s:property value="dnievaluador"/></h3>
								<h3>Justificación: <s:property value="justificacion"/></h3>
								<s:if test="%{validado == true}">
									<h3>Validado: Sí</h3>
								</s:if>
								<s:else>
									<h3>Validado: No</h3>
								</s:else>
								<h3>Competencias que evalua: </h3>
								<h3><s:property value="comp1"/></h3>
								<h3><s:property value="comp2"/></h3>
								<h3><s:property value="comp3"/></h3>
								<h3><s:property value="comp4"/></h3>
								<h3><s:property value="comp5"/></h3>
								<h3><s:property value="comp6"/></h3>
								<h3><s:property value="comp7"/></h3>
								<h3><s:property value="comp8"/></h3>
								<h3><s:property value="comp9"/></h3>
								<h3><s:property value="comp10"/></h3>
								 
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
								</div>
							</s:if>
						</s:iterator>
						<div id="<s:property value="%{#incr4.index}"/>4" class="accordion-body collapse">
							<div class="accordion-inner">
								<h3>DNI: </h3>
								<h3>Justificación: <s:property value="justificacion"/></h3>
								<s:if test="%{validado == true}">
									<h3>Validado: Sí</h3>
								</s:if>
								<s:else>
									<h3>Validado: No</h3>
								</s:else>
								<h3>Competencias que evalua: </h3>
								<h3><s:property value="comp1"/></h3>
								<h3><s:property value="comp2"/></h3>
								<h3><s:property value="comp3"/></h3>
								<h3><s:property value="comp4"/></h3>
								<h3><s:property value="comp5"/></h3>
								<h3><s:property value="comp6"/></h3>
								<h3><s:property value="comp7"/></h3>
								<h3><s:property value="comp8"/></h3>
								<h3><s:property value="comp9"/></h3>
								<h3><s:property value="comp10"/></h3>
								 
							</div>
						</div>
					</div>
				</s:if>
			</s:iterator>
		</div>
	</div>
</div>


<s:if test="%{interno == true}">
	<div class="bs-example-group"> 
		<div class="btn-group">			
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Interno <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="">Interno</a></li>
				<li><a href="/formExternoEvaluadores">Externo</a></li>
			</ul>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<h3 class="panel-title">Nueva propuesta de evaluador interno</h3>
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
									<s:iterator value="compObjCompCatcomp" status="incr">
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
						</form>
					</div>
				</div>
			</div>
		</div>
</s:if>
<s:else>
	<div class="bs-example-group"> 
		<div class="btn-group">	
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Externo<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="/formInternoEvaluadores">Interno</a></li>
				<li><a href="">Externo</a></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
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
										<option value="<s:property value="id"/>"><s:property value="nombre"/> <s:property value="apellidos"/></option> 
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
								<s:iterator value="compObjCompCatcomp" status="incr">
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
					</form>
				</div>
			</div>
		</div>
	</div>
</s:else>
		
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


</body>

