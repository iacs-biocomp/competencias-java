<%@ taglib prefix="s" uri="/struts-tags"%>

<script src='<s:url value="/js/plugins/datatables/jquery.dataTables.min.js"/>'></script>
<script src='<s:url value="/js/plugins/datatables/dataTables.bootstrap.min.js"/>'></script>
<script src='<s:url value="/js/plugins/datatables/extensions/Buttons/js/dataTables.buttons.min.js"/>'></script>
<script src='<s:url value="/js/plugins/datatables/jszip.min.js"/>'></script>
<script src='<s:url value="/js/plugins/datatables/pdfmake.min.js"/>'></script>
<script src='<s:url value="/js/plugins/datatables/vfs_fonts.js"/>'></script>
<script src='<s:url value="/js/plugins/datatables/extensions/Buttons/js/buttons.html5.js"/>'></script>
<script src='<s:url value="/js/plugins/datatables/extensions/Buttons/js/buttons.colVis.js"/>'></script>


<!-- Breadcrumb -->
<!--<ol class="breadcrumb breadcrumb-2"> 
	<li><a href="index"><i class="fa fa-home"></i>Home</a></li> 
	<li><a href="listMfmTables">Tablas maestras</a></li> 
	<li class="active"><strong><s:property value="selectedTable.catNombre" /></strong></li> 
</ol>-->
			

<!--<h2 class="page-title" style="font-weight: bold;text-transform: uppercase;"><s:property value="selectedTable.catNombre" /></h2>    
<h3><s:property value="selectedTable.catDescripcion" /></h3>-->    
<s:form action="showTasksActiviti" id="formTaskError" namespace="/">	
	<div class="form-group">
		<h2><span>Lo siento</span>, la tarea ya ha sido completada o ha sido reclamada por otro administrador.</h2>
		<s:submit cssClass="btn btn-primary btn-block" value="volver a lista de tareas" name="" type="submit" />
		<!-- <button class="btn btn-primary btn-block">Entrar</button> -->
	</div>	
</s:form>
