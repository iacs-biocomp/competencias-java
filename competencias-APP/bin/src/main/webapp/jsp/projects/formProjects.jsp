<%@ taglib prefix="s" uri="/struts-tags"%>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.0/css/select.dataTables.min.css">
  	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/select/1.3.0/js/dataTables.select.min.js"></script>
    <script type="text/javascript" src="http://127.0.0.1/cdn/js/projects/projects.js"/></script>
<body>
	<div>
		<h2><strong>Por favor</strong>, introduzca los siguientes datos para crear un proyecto.</h2>
		<s:form action="addProjects" id="formProject" namespace="/">                     
			<div class="form-group">
				<label for="titulo">* Título del proyecto:</label>
				<input type="text" placeholder="Nombre del proyecto" class="form-control" 
					   size="30" value="" id="titulo" name="titulo">
			</div>
			<div class="form-group">
				<label for="name">* Nombre del Investigador Principal:</label>
				<input name="name" id="name" type="text" placeholder="Nombre Investigador principal" 
				class="form-control" value="" size="50">
			</div>
			<div class="form-group">
				<label for="dni">* DNI del Investigador Principal:</label>
				<input name="dni" id="dni" type="text" placeholder="DNI Investigador principal" 
				class="form-control" value="" size="50">
			</div>
			<div class="form-group">
				<label for="mail">* Correo del Investigador Principal:</label>
				<input name="piMail" id="piMail" type="text" placeholder="Correo electrónico" 
				class="form-control" value="" size="50">
			</div>
			<div class="form-group">
				<label for="phone">Telefono de contacto:</label>
				<input name="phone" id="phone" type="text" placeholder="Telefono de contacto" 
				class="form-control" value="" size="50">
			</div>
			<div class="form-group">
				<label for="mail">Correo específico del proyecto (si existe):</label>
				<input name="mail" id="mail" type="text" placeholder="Correo electrónico" 
				class="form-control" value="" size="50">
			</div>
			<label for="expId">N. Expediente de proyecto:</label>
			<div class="form-group">	
				<input name="expId" id="expId" type="text" placeholder="Identificador de proyecto" 
				class="form-control" value="" size="50">
			</div>
			<label for="start">Fecha inicio del proyecto:</label>
			<div class="form-group">	
				<input type="date" id="start" name="start" value="">
			</div>
			
			<label for="end">Fecha estimada fin del proyecto:</label>
			<div class="form-group">
		       <input type="date" id="end" name="end" value="">
		    </div>
		    
<!-- 		<label for="Datasets">Fuente de datos autorizadas:</label>
			<div >
            <table id="Datasets" class="display">
	                <thead>
	                    <tr>
	                    	<th></th>
	                        <th>Fuente de datos</th>
	                    </tr>
	                </thead>
	            </table>
	        </div>	
	        <s:hidden name="listaActivos" id="listaActivos" value="" />
			<s:if test="hasActionErrors()">
				<div class="errors">
					<s:actionerror escape="false" />
				</div>
			</s:if>
-->
			<div class="form-group">
				<s:submit cssClass="btn btn-primary btn-block" value="Crear proyecto" name="" type="submit" />
 			</div>

		</s:form>
	</div>
</body>