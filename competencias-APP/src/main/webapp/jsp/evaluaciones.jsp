<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<h1> Evaluaciones </h1>


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

<link href="css/plugins/select2/select2.css" rel="stylesheet">

<link href="css/mouldifi-forms.css" rel="stylesheet">

      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>

</head>
<body>
 <s:if test="%{mis ==false}">
  <!-- Main container -->
  <div style="width:90%;">

 
		<h3 style="text-align: right"> <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-2">Añadir evaluación <i class="fa fa-plus" aria-hidden="true" ></i></button></h3>

	<div id="modal-2" class="modal fade" tabindex="-1" role="dialog">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">Crear nueva evaluación</h4>
		      </div>
		      <div class="modal-body">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							
							<div class="panel-body">
								 <form class="form-horizontal" method="post" action="/nuevaEvaluaciones">
								 	<div class="form-group"> 
										<label class="col-sm-2 control-label">Nombre</label> 
										<div class="col-sm-10"> 
											<input type="text" placeholder="Nombre" name="nombre" class="form-control" required> 
										</div> 
									</div>
									<div class="line-dashed"></div>
									<p><strong>Aportación de evaluadores </strong></p> 
									<div class="form-group"> 
										<label class="col-sm-2 control-label">Fecha de alta: </label> 
											<div class="col-sm-10"> 
												<div id="date-popup" class="input-group date"> 
													<input type="date" name="iniaportacion" required>
												</div>
											</div> 
									</div>
									<div class="form-group"> 
										<label class="col-sm-2 control-label">Fecha de baja: </label> 
											<div class="col-sm-10"> 
												<div id="date-popup" class="input-group date"> 
													<input type="date" name="finaportacion">	
												</div>
												<p class="help-block">No es necesario que lo rellenes ahora. Podrás añadirla más adelante.</p>
											</div> 
									</div>
									<div class="line-dashed"></div>
									<p><strong>Validación de evaluadores </strong></p> 
									<div class="form-group"> 
										<label class="col-sm-2 control-label">Fecha de alta: </label> 
											<div class="col-sm-10"> 
												<div id="date-popup" class="input-group date"> 
													<input type="date" name="inivalidacion" required>
												</div>
											</div> 
									</div>
									<div class="form-group"> 
										<label class="col-sm-2 control-label">Fecha de baja: </label> 
											<div class="col-sm-10"> 
												<div id="date-popup" class="input-group date"> 
													<input type="date" name="finvalidacion">	
												</div>
												<p class="help-block">No es necesario que lo rellenes ahora. Podrás añadirla más adelante.</p>
											</div> 
									</div>
									<div class="line-dashed"></div>
									<p><strong>Periodo evaluado </strong></p> 
									<div class="form-group"> 
										<label class="col-sm-2 control-label">Fecha de alta: </label> 
											<div class="col-sm-10"> 
												<div id="date-popup" class="input-group date"> 
													<input type="date" name="iniperiodo" required>
												</div>
											</div> 
									</div>
									<div class="form-group"> 
										<label class="col-sm-2 control-label">Fecha de baja: </label> 
											<div class="col-sm-10"> 
												<div id="date-popup" class="input-group date"> 
													<input type="date" name="finperiodo">	
												</div>
											</div> 
									</div>
									<div class="line-dashed"></div>
									<p><strong>Evaluación </strong></p> 
									<div class="form-group"> 
										<label class="col-sm-2 control-label">Fecha de alta: </label> 
											<div class="col-sm-10"> 
												<div id="date-popup" class="input-group date"> 
													<input type="date" name="inievaluacion" required>
												</div>
											</div> 
									</div>
									<div class="form-group"> 
										<label class="col-sm-2 control-label">Fecha de baja: </label> 
											<div class="col-sm-10"> 
												<div id="date-popup" class="input-group date"> 
													<input type="date" name="finevaluacion">	
												</div>
												<p class="help-block">No es necesario que lo rellenes ahora. Podrás añadirla más adelante.</p>
											</div> 
									</div>
									<div class="line-dashed"></div>
									<div class="form-group"> 
									 	<label class="col-sm-2 control-label">Puesto de trabajo</label> 
										<div class="col-sm-10"> 
											<select name="catcompetencial" class="form-control" > 
												<s:iterator value="listaCatCompetenciales">
													<option value="<s:property value="codigo"/>"><s:property value="nombre"/></option>
												</s:iterator>
											</select>
										</div> 
									</div>
									 
								
									
									
									<div class="line-dashed"></div>
									<div class="form-group"> 
										<div class="col-sm-offset-2 col-sm-10"> 
<!-- 											<button type="submit" class="btn btn-white">Cancel</button> -->
											
											<button class="btn btn-primary" type="submit">Aceptar</button>
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
	
	
	
	
	<!-- Main content -->
    <div class="main-content" >

		
		<div class="row">
			<div class="col-md-18">
				<!-- Card list view -->
				<div class="cards-container box-view">
				
				<s:if test="%{editar2==true}">
					<s:iterator value="nuevaEvaluacion">
					<!-- Card -->
							<div class="card" style="width:100%;">
							
								<!-- Card header -->
								<div class="card-header" style="width:100%;">
									
									<!-- Card short description -->
									<div class="card-short-description">
										<h5><span class="user-name"><a href="#/"><s:property value="nombre"/></a></span>
										<s:if test="%{finevaluacion ==null || finevaluacion == \"\" || !(fechaActual>finevaluacion)}">
											<span class="badge badge-primary">Activa</span>
										</s:if>
										</h5>
										
									</div>
									<!-- /card short description -->
									
								</div>
								<!-- /card header -->
								
								<!-- Card content -->
								<div class="card-content" style="width:100%;">
									<form name="formEdit" method="post" action="/nuevaInfoEvaluaciones">
										<p><strong>Periodo evaluado:</strong> <s:property value="iniperiodo"/> - <s:property value="finperiodo"/></p>
											<p><strong>Periodo de aportación de evaluadores:</strong> <s:property value="iniaportacion"/> - <s:property value="finaportacion"/></p>
											<p><strong>Periodo de validación de evaluadores:</strong> <s:property value="inivalidacion"/> - <s:property value="finvalidacion"/></p>
											<p><strong>Periodo de evaluación:</strong> <s:property value="inievaluacion"/> - <s:property value="finevaluacion"/></p>
										<p><strong> Puestos de trabajo evaluados:</strong> <s:property value="catcompetencial"/>. </p>
<%-- 										<p><strong> Trabajadores evaluados:</strong>  </p> --%>
<!-- 										<div class="col-sm-offset-2 col-sm-10">  -->
<%-- 											<s:iterator value="listaTrabajadores" status="incr"> --%>
<%-- 												<div class="checkbox"> <label> <input type="checkbox" name="comp<s:property value="%{#incr.index}"/>" value="<s:property value="codigo"/>"><s:property value="nombre"/> <s:property value="apellidos"/> </label> </div>  --%>
<%-- 											</s:iterator> --%>
<!-- 										</div> -->
										<p><strong> Competencias de las cuales serán evaluados:</strong>  </p>
										<input type="hidden" name="id" value="<s:property value="id"/>">
											<s:iterator value="objCompCatcomp" status="incr">
												<div class="checkbox"> <label> <input type="checkbox" name="comp<s:property value="%{#incr.index}"/>" value="<s:property value="codcompetencia"/>"><s:property value="descripcion"/> </label> </div> 
											</s:iterator>
<!-- 								LO PASARIA COMO VECTOR  -->
<%-- 											<s:iterator value="objCompCatcomp" status="incr"> --%>
<%-- 												<div class="checkbox"> <label> <input type="checkbox" name="compet" value="<s:property value="codcompetencia"/>"><s:property value="descripcion"/> </label> </div>  --%>
<%-- 											</s:iterator> --%>
										</div>
										<ul class="list-inline list-action">
												<input type="Submit" value="Guardar">
										</ul>
									</form>
								</div>
								<!-- /card content -->
								
							</div>
							<!-- /card -->
					</s:iterator>
				</s:if>
				<s:else>
					<s:if test="%{editar==true}">
						
						<s:iterator value="listaEvaluaciones">
							<s:if test="%{idEditar == id}">	
								<form name="formEdit" method="post" action="/guardarEvaluaciones">
								<!-- Card -->
								<div class="card" style="width:100%;">
								
									<!-- Card header -->
									<div class="card-header" style="width:100%;">
										
										<!-- Card short description -->
										<div class="card-short-description">
											<h5><span class="user-name"><input id="nombre" name="nombre" type="text" value="<s:property value="nombre"/>"></span></h5>
											
										</div>
										<!-- /card short description -->
										
									</div>
									<!-- /card header -->
									
									<!-- Card content -->
									<div class="card-content" style="width:100%;">
											 <input id="id" name="id" type="hidden" value="<s:property value="id"/>">
											<p><strong>Periodo evaluado:</strong> <input id="iniperiodo" name="iniperiodo" type="date" value="<s:property value="iniperiodo"/>"> - <input id="finperiodo" name="finperiodo" type="date" value="<s:property value="finperiodo"/>"></p>
											<p><strong>Periodo de aportación de evaluadores:</strong> <input id="iniaportacion" name="iniaportacion" type="date" value="<s:property value="iniaportacion"/>"> - <input id="finaportacion" name="finaportacion" type="date" value="<s:property value="finaportacion"/>"></p>
											<p><strong>Periodo de validación de evaluadores:</strong> <input id="inivalidacion" name="inivalidacion" type="date" value="<s:property value="inivalidacion"/>"> - <input id="finvalidacion" name="finvalidacion" type="date" value="<s:property value="finvalidacion"/>"></p>
											<p><strong>Periodo de evaluación:</strong> <input id="inievaluacion" name="inievaluacion" type="date" value="<s:property value="inievaluacion"/>"> - <input id="finevaluacion" name="finevaluacion" type="date" value="<s:property value="finevaluacion"/>"></p>
											<p><strong> Puestos de trabajo evaluados: </strong> 
											<select name="catcompetencial">
													<s:iterator value="listaCatCompetenciales">
														<s:if test="%{codigo ==catcompetencial }">
															<option selected value="<s:property value="codigo"/>"><s:property value="nombre"/></option>
														</s:if>
														<s:else>
															<option value="<s:property value="codigo"/>"><s:property value="nombre"/></option>
														</s:else>
														
													</s:iterator>
												</select></p>
											<p><strong> Competencias de las cuales serán evaluados:</strong>  </p>
										
											<div class="col-sm-offset-2 col-sm-10"> 
												<s:iterator value="objCompCatcomp" status="incr">
												
													<s:if test="%{codcompetencia==comp1 || codcompetencia==comp2 || codcompetencia==comp3||codcompetencia==comp4||codcompetencia==comp5||codcompetencia==comp6||codcompetencia==comp7||codcompetencia==comp8||codcompetencia==comp9||codcompetencia==comp10}">
														<div class="checkbox"> <label> <input type="checkbox" name="comp<s:property value="%{#incr.index}"/>" value="<s:property value="codcompetencia"/>" checked><s:property value="descripcion"/> </label> </div> 
													</s:if>
													<s:else>
														<div class="checkbox"> <label> <input type="checkbox" name="comp<s:property value="%{#incr.index}"/>" value="<s:property value="codcompetencia"/>"><s:property value="descripcion"/> </label> </div> 
													</s:else>
												</s:iterator>
											</div>
											<ul class="list-inline list-action">
												<input type="Submit" value="Guardar">
											</ul>
									</div>
									<!-- /card content -->
									
								</div>
								<!-- /card -->
								</form>
							</s:if>
						</s:iterator>	
						
					</s:if>
					<s:else>
					
						
						<s:iterator value="listaEvaluaciones">
							<!-- Card -->
							<div class="card" style="width:100%;">
							
								<!-- Card header -->
								<div class="card-header" style="width:100%;">
									
									<!-- Card short description -->
									<div class="card-short-description">
										<h5><span class="user-name"><a href="#/"><s:property value="nombre"/></a></span>
										<s:if test="%{finevaluacion ==null || finevaluacion == \"\" || !(fechaActual>finevaluacion)}">
											<span class="badge badge-primary">Activa</span>
										</s:if>
										</h5>
										
									</div>
									<!-- /card short description -->
									
								</div>
								<!-- /card header -->
								
								<!-- Card content -->
								<div class="card-content" style="width:100%;">
								
									<p><strong>Periodo evaluado:</strong> <s:property value="iniperiodo"/> - <s:property value="finperiodo"/></p>
										<p><strong>Periodo de aportación de evaluadores:</strong> <s:property value="iniaportacion"/> - <s:property value="finaportacion"/></p>
										<p><strong>Periodo de validación de evaluadores:</strong> <s:property value="inivalidacion"/> - <s:property value="finvalidacion"/></p>
										<p><strong>Periodo de evaluación:</strong> <s:property value="inievaluacion"/> - <s:property value="finevaluacion"/></p>
									<p><strong> Puestos de trabajo evaluados:</strong> 
									<s:iterator value="listaCatCompetenciales" var="cat">
										<s:if test="%{codigo ==catcompetencial }">
											<s:property value="catcompetencial"/>- <s:property value="#cat.nombre"/>. </p>
										</s:if>
									</s:iterator>
									<p><strong> Competencias de las cuales serán evaluados:</strong>  </p>
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
									
									<ul class="list-inline list-action">
									
										<s:if test="%{finevaluacion !=null && finevaluacion != \"\" && fechaActual>finevaluacion}">
											<li><a href="evaluacionConcretaResultados">Calcular evaluación</a></li>
										</s:if>
										<s:if test="%{finevaluacion ==null || finevaluacion == \"\" || !(fechaActual>finevaluacion)}">
											<li><a href="editarEvaluaciones?id=<s:property value="id"/>">Editar evaluación</a></li>
										</s:if>
<%-- 										<li><a href="concretaEvaluaciones?id=<s:property value="id"/>">Evaluar</a></li> --%>
									
									</ul>
								</div>
								<!-- /card content -->
								
							</div>
							<!-- /card -->
						</s:iterator>
					
					</s:else>
				</s:else>
				
					
				</div>
				<!-- /card list view -->
				
			</div>
		</div>	
		
	  </div>
	  <!-- /main content -->
	  
  </div>
  <!-- /main container -->
 </s:if>
 <s:else> 
<!--  MIS EVALUACIONES -->
 
 
   <!-- Main container -->
  <div style="width:90%;">

	
	<!-- Main content -->
    <div class="main-content" >

		
		<div class="row">
			<div class="col-md-18">
				<!-- Card list view -->
				<div class="cards-container box-view">
				
			
						
						<s:iterator value="listaEvaluaciones">
							<!-- Card -->
							<div class="card" style="width:100%;">
							
								<!-- Card header -->
								<div class="card-header" style="width:100%;">
									
									<!-- Card short description -->
									<div class="card-short-description">
										<h5><span class="user-name"><a href="#/"><s:property value="nombre"/></a></span>
										<s:if test="%{finevaluacion ==null || finevaluacion == \"\" || !(fechaActual>finevaluacion)}">
											<span class="badge badge-primary">Activa</span>
										</s:if>
										</h5>
										
									</div>
									<!-- /card short description -->
									
								</div>
								<!-- /card header -->
								
								<!-- Card content -->
								<div class="card-content" style="width:100%;">
								
									<p><strong>Periodo evaluado:</strong> <s:property value="iniperiodo"/> - <s:property value="finperiodo"/></p>
										<p><strong>Periodo de aportación de evaluadores:</strong> <s:property value="iniaportacion"/> - <s:property value="finaportacion"/></p>
										<p><strong>Periodo de validación de evaluadores:</strong> <s:property value="inivalidacion"/> - <s:property value="finvalidacion"/></p>
										<p><strong>Periodo de evaluación:</strong> <s:property value="inievaluacion"/> - <s:property value="finevaluacion"/></p>
									<p><strong> Puestos de trabajo evaluados:</strong> <s:property value="catcompetencial"/>. </p>
									<p><strong> Competencias de las cuales serán evaluados:</strong>  </p>
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
									
									<ul class="list-inline list-action">
									<s:if test="%{finevaluacion ==null || finevaluacion == \"\" || !(fechaActual>finevaluacion)}">
										<li><a href="concretaEvaluaciones?id=<s:property value="id"/>">Evaluar</a></li>
									</s:if>
									</ul>
								</div>
								<!-- /card content -->
								
							</div>
							<!-- /card -->
						</s:iterator>
				</div>
				<!-- /card list view -->
				
			</div>
		</div>	
		
	  </div>
	  <!-- /main content -->
	  
  </div>
 
 
 
 
 
 
 </s:else>
  
</div>
<!-- /page container -->

<!--Load JQuery-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/plugins/metismenu/jquery.metisMenu.js"></script>
<!-- Select2-->
<script src="js/plugins/select2/select2.full.min.js"></script>
<script src="js/functions.js"></script>
<script>
	$(document).ready(function () {
		$(".select2").select2();
	});
</script>
</body>
</html>
