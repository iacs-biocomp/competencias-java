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
<ol class="breadcrumb breadcrumb-2"> 
	<li><a href="index"><i class="fa fa-home"></i>Home</a></li> 
	<li class="active"><strong>Tablas maestras</strong></li> 
</ol>


<h1 class="page-title">Tablas maestras BIGAN</h1>    


<table class="table table-striped table-hover bigan-dt" id="masterFilesTable">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Descripción</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="mfmTables">
		<tr class="prjItem" id="<s:property value="catId" />" data-href="showMfmTables?table=<s:property value="catId" />">
			<td><s:property value="catNombre" /></td>
			<td><s:property value="catDescripcion" /></td>
		</tr>
		</s:iterator>
	</tbody>
</table> 	


<table class="table table-striped table-hover bigan-dt">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Descripción</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="datasets">
		<tr class="prjItem">
			<td><s:property/></td>
			<td></td>
		</tr>
		</s:iterator>
	</tbody>
</table> 	

<script>
$('#masterFilesTable').on( 'click', 'tbody tr', function () {
  window.location.href = $(this).data('href');
});
</script>
