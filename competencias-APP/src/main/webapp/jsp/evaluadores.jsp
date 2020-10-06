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

<h2> Autoevaluación </h2>

<h2> Personas que me organizan el trabajo </h2>

<h2> Personas a las que organizo el trabajo </h2>

<h2> Personas que trabajan conmigo </h2>

<h2> Personas a las que entrego mi trabajo </h2>

<%-- <s:iterator value="listaTrabajadores"> --%>
<%-- <h2> <s:property value="nombre"/>  <s:property value="apellidos"/></h2> --%>
<!-- 	<h3> Superiores  </h3>  -->
<%-- 		<s:if test="%{puedeEditar == true}"> --%>
<!-- 			<form action="/nuevoSuperiorOrganigramas" method="post"> -->
<%-- 			    <input type="hidden" id="idOrganigrama" name="idOrganigrama" value="<s:property value="idOrganigrama"/>"> --%>
<%-- 			    <input type="hidden" id="dniTrabajador" name="dniTrabajador" value="<s:property value="dni"/>" > --%>
<!-- 			    <label for="dniSuperior">DNI superior:</label> -->
<!-- 				<input type="text" id="dniSuperior" name="dniSuperior" required> -->
<!-- 			  <input type="submit" value="Nuevo superior"> -->
<!-- 			</form> -->
<%-- 		</s:if> --%>
<!-- 		<table class="table"> -->
<!-- 		   <thead> -->
<!-- 		     <tr> -->
<!-- 		     	<th scope="col"></th> -->
<!-- 		       <th scope="col">DNI Superior</th> -->
<!-- 		       <th scope="col">Nombre Superior</th> -->
		
<!-- 		     </tr> -->
<!-- 		   </thead> -->
<!-- 		   <tbody> -->
<%-- 		<s:iterator value="listaSuperiores"> --%>
<%-- 			<s:if test="%{dniTrabajador == dni}"> --%>
<!-- 				   <tr>                 -->
<%-- 				   	<td><s:if test="%{puedeEditar == true}"><a href="borrarSuperiorOrganigramas?idRelacion=<s:property value="id"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></s:if></td> --%>
<%-- 					 <td><s:property value="dniSuperior"/></td> --%>
<%-- 					 <s:iterator value="listaTrabajadores"> --%>
<%-- 					 	<s:if  test="%{dniSuperior == dni}"> --%>
<%-- 					 		<td><s:property value="nombre"/></td> --%>
<%-- 					 	</s:if> --%>
<%-- 					 </s:iterator> --%>
<!-- 				   </tr> -->
<%-- 			</s:if> --%>
<%-- 		</s:iterator> --%>

<!-- 		</tbody> -->
<!-- 		</table> -->
	
<!-- 	<h3> Pares   </h3> -->
<%-- 	<s:if test="%{puedeEditar == true}"> --%>
<!-- 		<form action="/nuevoParOrganigramas" method="post"> -->
<%-- 			    <input type="hidden" id="idOrganigrama" name="idOrganigrama" value="<s:property value="idOrganigrama"/>"> --%>
<%-- 			    <input type="hidden" id="dniTrabajador" name="dniTrabajador" value="<s:property value="dni"/>"> --%>
<!-- 			    <label for="dniPar">DNI par:</label> -->
<!-- 				<input type="text" id="dniPar" name="dniPar" required> -->
<!-- 			  <input type="submit" value="Nuevo par"> -->
<!-- 			</form> -->
<%-- 	</s:if> --%>
<!-- 		<table class="table"> -->
<!-- 		   <thead> -->
<!-- 		     <tr> -->
<!-- 		     	<th scope="col"></th> -->
<!-- 		       <th scope="col">DNI Par</th> -->
<!-- 				<th scope="col">Nombre Par</th> -->
<!-- 		     </tr> -->
<!-- 		   </thead> -->
<!-- 		   <tbody> -->
<%-- 		<s:iterator value="listaPares"> --%>
<%-- 			<s:if test="%{dniTrabajador == dni}"> --%>
<!-- 				   <tr>                 -->
<%-- 				   	<td><s:if test="%{puedeEditar == true}"><a href="borrarParOrganigramas?idRelacion=<s:property value="id"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></s:if></td> --%>
<%-- 					 <td><s:property value="dniPar"/></td> --%>
<%-- 					 <s:iterator value="listaTrabajadores"> --%>
<%-- 					 	<s:if  test="%{dniPar == dni}"> --%>
<%-- 					 		<td><s:property value="nombre"/></td> --%>
<%-- 					 	</s:if> --%>
<%-- 					 </s:iterator> --%>
<!-- 				   </tr> -->
<%-- 			</s:if> --%>
<%-- 		</s:iterator> --%>

<!-- 		</tbody> -->
<!-- 		</table> -->
<%-- </s:iterator> --%>



<p><strong>Agregar nueva propuesta de evaluador:</strong></p>
	<div class="bs-example-group"> 
		<div class="btn-group">
							
		<s:if test="%{interno == true}">
							
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Interno <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="">Interno</a></li>
				<li><a href="/nuevaPropuestaExternoEvaluadores">Externo</a></li>
			</ul>
			</div>
	</div>
				<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading clearfix">
							<h3 class="panel-title">Nueva propuesta de evaluador interno</h3>
	<!-- 						<ul class="panel-tool-options">  -->
	<!-- 							<li><a data-rel="collapse" href="#"><i class="icon-down-open"></i></a></li> -->
	<!-- 						</ul> -->
						</div>
						<div class="panel-body">
							 <form class="form-horizontal">
							 	
								<div class="form-group"> 
								 	<label class="col-sm-2 control-label">Seleccione trabajador del IACS:</label> 
									<div class="col-sm-10"> 
										<select class="form-control"> 
											<s:iterator value="listaTrabajadores">
												<option><s:property value="nombre"/> <s:property value="apellidos"/></option> 
											</s:iterator>
										</select>
									</div> 
								</div>
								<div class="line-dashed"></div>
								<div class="form-group"> 
								 	<label class="col-sm-2 control-label">Seleccione grupo evaluador al que pertenece:</label> 
									<div class="col-sm-10"> 
										<select class="form-control"> 
											<option>Personas que trabajan conmigo</option> 
											<option>Personas a las que entrego mi trabajo</option>
										</select>
									</div> 
								</div>
								<div class="line-dashed"></div>
								<div class="form-group">
										<label class="col-sm-2 control-label">Marque las competencias a evaluar: </label>
										
										<div class="col-sm-offset-2 col-sm-10"> 
											<s:iterator value="compObjCompCatcomp">
												<div class="checkbox"> <label> <input type="checkbox"><s:property value="descripcion"/></label> </div> 
											 </s:iterator>
										 </div>
									</div>
								<div class="line-dashed"></div>
							 <div class="form-group"> 
							 	<label class="col-sm-2 control-label">Justifique por qué debe evaluarle:</label> 
								<div class="col-sm-10"> 
									<textarea placeholder="Textarea" class="form-control"></textarea> 
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
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Externo<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="/nuevaPropuestaInternoEvaluadores">Interno</a></li>
				<li><a href="">Externo</a></li>
			</ul>
			</div>
	</div>
			
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading clearfix">
								<h3 class="panel-title">Nueva propuesta de evaluador externo</h3>
		<!-- 						<ul class="panel-tool-options">  -->
		<!-- 							<li><a data-rel="collapse" href="#"><i class="icon-down-open"></i></a></li> -->
		<!-- 						</ul> -->
							</div>
							<div class="panel-body">
								 <form class="form-horizontal">
								 	
									<div class="form-group"> 
									 	<label class="col-sm-2 control-label">Seleccione evaluador externo: </label> 
										<div class="col-sm-10"> 
											<select class="form-control"> 
												<s:iterator value="listaExternos">
													<option><s:property value="nombre"/> <s:property value="apellidos"/></option> 

												</s:iterator>
											</select>
										</div> 
									</div>
									<div class="form-group"> 
									 	<label class="col-sm-2 control-label">Seleccione grupo evaluador al que pertenece: </label> 
										<div class="col-sm-10"> 
											<select class="form-control"> 
												<option>Personas que trabajan conmigo</option> 
												<option>Personas a las que entrego mi trabajo</option>
											</select>
										</div> 
									</div>
									<div class="line-dashed"></div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Marque las competencias a evaluar: </label>
										
										<div class="col-sm-offset-2 col-sm-10"> 
											<s:iterator value="compObjCompCatcomp">
												<div class="checkbox"> <label> <input type="checkbox"><s:property value="descripcion"/></label> </div> 
											 </s:iterator>
										 </div>
									</div>
									<div class="line-dashed"></div>
									 <div class="form-group"> 
									 	<label class="col-sm-2 control-label">Justifique por qué debe evaluarle:</label> 
										<div class="col-sm-10"> 
											<textarea placeholder="Textarea" class="form-control"></textarea> 
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
		
	


</body>

