<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1> Evaluaciones </h1>

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
							 <form class="form-horizontal">
							 	<div class="form-group"> 
									<label class="col-sm-2 control-label">Nombre</label> 
									<div class="col-sm-10"> 
										<input type="text" placeholder="Nombre" class="form-control"> 
									</div> 
								</div>
								<div class="line-dashed"></div>
								<p><strong>Aportación de evaluadores </strong></p> 
								<div class="form-group"> 
									<label class="col-sm-2 control-label">Fecha de alta: </label> 
										<div class="col-sm-10"> 
											<div id="date-popup" class="input-group date"> 
												<input type="date" id="alta" name="alta" required>
											</div>
										</div> 
								</div>
								<div class="form-group"> 
									<label class="col-sm-2 control-label">Fecha de baja: </label> 
										<div class="col-sm-10"> 
											<div id="date-popup" class="input-group date"> 
												<input type="date" id="baja" name="baja">	
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
												<input type="date" id="alta" name="alta" required>
											</div>
										</div> 
								</div>
								<div class="form-group"> 
									<label class="col-sm-2 control-label">Fecha de baja: </label> 
										<div class="col-sm-10"> 
											<div id="date-popup" class="input-group date"> 
												<input type="date" id="baja" name="baja">	
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
												<input type="date" id="alta" name="alta" required>
											</div>
										</div> 
								</div>
								<div class="form-group"> 
									<label class="col-sm-2 control-label">Fecha de baja: </label> 
										<div class="col-sm-10"> 
											<div id="date-popup" class="input-group date"> 
												<input type="date" id="baja" name="baja">	
											</div>
										</div> 
								</div>
								<div class="line-dashed"></div>
								<p><strong>Evaluación </strong></p> 
								<div class="form-group"> 
									<label class="col-sm-2 control-label">Fecha de alta: </label> 
										<div class="col-sm-10"> 
											<div id="date-popup" class="input-group date"> 
												<input type="date" id="alta" name="alta" required>
											</div>
										</div> 
								</div>
								<div class="form-group"> 
									<label class="col-sm-2 control-label">Fecha de baja: </label> 
										<div class="col-sm-10"> 
											<div id="date-popup" class="input-group date"> 
												<input type="date" id="baja" name="baja">	
											</div>
											<p class="help-block">No es necesario que lo rellenes ahora. Podrás añadirla más adelante.</p>
										</div> 
								</div>
								<div class="line-dashed"></div>
								<div class="form-group"> 
								 	<label class="col-sm-2 control-label">Puesto de trabajo</label> 
									<div class="col-sm-10"> 
										<select class="form-control"> 
											<option>Option 1</option> 
											<option>Option 2</option>
											<option>Option 3</option> 
											<option>Option 4</option> 
											<option>Option 5</option> 
										</select>
									</div> 
								</div>
								 <div class="line-dashed"></div>
								 <div class="form-group">
									<label class="col-sm-2 control-label">Disabled</label>
	                                <div class="col-sm-10">
										<input type="text" class="form-control" placeholder="Placeholder" disabled> 
	                                </div>
	                             </div>
								 
								<div class="line-dashed"></div>
								<div class="form-group"> 
								 	<label class="col-sm-2 control-label">Select List</label> 
									<div class="col-sm-10"> 
										<select class="form-control"> 
											<option>Option 1</option> 
											<option>Option 2</option>
											<option>Option 3</option> 
											<option>Option 4</option> 
											<option>Option 5</option> 
										</select>
									</div> 
								</div>
								
								<div class="line-dashed"></div>
								<div class="form-group"> 
									<div class="col-sm-offset-2 col-sm-10"> 
										<div class="checkbox"> <label> <input type="checkbox">Checkbox 1</label> </div> 
									 	<div class="checkbox"> <label> <input type="checkbox">Checkbox 2</label> </div>
									 </div>
								</div>
								
								<div class="line-dashed"></div>
								<div class="form-group"> 
									<div class="col-sm-offset-2 col-sm-10"> 
										<button type="button" class="btn btn-primary">Save changes</button>
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
<title>Mouldifi | Cards View</title>
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

  <!-- Main container -->
  <div class="main-container">
 
	
	
	
	
	<!-- Main content -->
    <div class="main-content">
	
		
		
		<div class="row">
			<div class="col-md-12">
				<!-- Card list view -->
				<div class="cards-container box-view">
				
					<!-- Card -->
					<div class="card">
					
						<!-- Card header -->
						<div class="card-header">
							
							<!-- Card short description -->
							<div class="card-short-description">
								<h5><span class="user-name"><a href="#/">Evaluación 1</a></span><span class="badge badge-primary">Activa</span></h5>
								
							</div>
							<!-- /card short description -->
							
						</div>
						<!-- /card header -->
						
						<!-- Card content -->
						<div class="card-content">
							<p>Periodo evaluado: 01/01/2019 - 31/12/2019</p>
								<p>Periodo de aportación de evaluadores: 01/01/2020 - 31/02/2020</p>
								<p>Periodo de validación de evaluadores: 01/03/2020 - 31/03/2020</p>
								<p>Periodo de evaluación: 01/04/2020 - 31/05/2020</p>
							<p> Puestos de trabajo evaluados o personas evaluadas: Técnico de apoyo a la investigación. Técnico en FP. </p>
							<p> Competencias de las cuales serán evaluados:  </p>
							<ul class="list-inline list-action">
								<li><a href="#/">Calcular evaluación</a></li>
								<li><a href="#/">Editar evaluación</a></li>
								<li><a href="#/">Send Message</a></li>
							</ul>
						</div>
						<!-- /card content -->
						
					</div>
					<!-- /card -->
					
					<!-- Card -->
					<div class="card">
					
						<!-- Card header -->
						<div class="card-header">
							
							<!-- Card short description -->
							<div class="card-short-description">
								<h5><span class="user-name"><a href="#/">Evaluación 1</a></span><span class="badge badge-primary">Activa</span></h5>
								
							</div>
							<!-- /card short description -->
							
						</div>
						<!-- /card header -->
						
						<!-- Card content -->
						<div class="card-content">
							<p>Periodo evaluado: 01/01/2019 - 31/12/2019</p>
								<p>Periodo de aportación de evaluadores: 01/01/2020 - 31/02/2020</p>
								<p>Periodo de validación de evaluadores: 01/03/2020 - 31/03/2020</p>
								<p>Periodo de evaluación: 01/04/2020 - 31/05/2020</p>
							<p> Puestos de trabajo evaluados o personas evaluadas. Competencias de las cuales serán evaluados.</p>
							<ul class="list-inline list-action">
								<li><a href="#/">Calcular evaluación</a></li>
								<li><a href="#/">Editar evaluación</a></li>
								<li><a href="#/">Send Message</a></li>
							</ul>
						</div>
						<!-- /card content -->
						
					</div>
					<!-- /card -->
					
					<!-- Card -->
					<div class="card">
					
						<!-- Card header -->
						<div class="card-header">
							
							<!-- Card short description -->
							<div class="card-short-description">
								<h5><span class="user-name"><a href="#/">Evaluación 1</a></span><span class="badge badge-primary">Activa</span></h5>
								
							</div>
							<!-- /card short description -->
							
						</div>
						<!-- /card header -->
						
						<!-- Card content -->
						<div class="card-content">
							<p>Periodo evaluado: 01/01/2019 - 31/12/2019</p>
								<p>Periodo de aportación de evaluadores: 01/01/2020 - 31/02/2020</p>
								<p>Periodo de validación de evaluadores: 01/03/2020 - 31/03/2020</p>
								<p>Periodo de evaluación: 01/04/2020 - 31/05/2020</p>
							<p> Puestos de trabajo evaluados o personas evaluadas. Competencias de las cuales serán evaluados.</p>
							<ul class="list-inline list-action">
								<li><a href="#/">Calcular evaluación</a></li>
								<li><a href="#/">Editar evaluación</a></li>
								<li><a href="#/">Send Message</a></li>
							</ul>
						</div>
						<!-- /card content -->
						
					</div>
					<!-- /card -->
					
					<!-- Card -->
					<div class="card">
					
						<!-- Card Header -->
						<div class="card-header">
							
							<!-- Card Short Description -->
							<div class="card-short-description">
								<h5><span class="user-name"><a href="#/">John Henderson</a></span><span class="badge badge-primary">Agent</span></h5>
								<p><a href="mailto:#">first.last@example.com</a></p>
							</div>
							<!-- /card short description -->
							
						</div>
						<!-- /card header -->
						
						<!-- Card Content -->
						<div class="card-content">
							<p>Hi, This is my short intro text. Lorem ipsum is a dummy content sit dollar. You can copy and paste this dummy content from anywhere and to anywhere. Its all free and must be a good to folllow in prectice</p>
							<ul class="list-inline list-action">
								<li><a href="#/">Modify</a></li>
								<li><a href="#/">View Profile</a></li>
								<li><a href="#/">Send Message</a></li>
							</ul>
						</div>
						<!-- /card content -->
						
					</div>
					<!-- /card -->
					
				</div>
				<!-- /card list view -->
				
			</div>
		</div>	
		
	  </div>
	  <!-- /main content -->
	  
  </div>
  <!-- /main container -->
  
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
