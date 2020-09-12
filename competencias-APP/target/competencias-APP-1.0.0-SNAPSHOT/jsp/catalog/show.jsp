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
	<li><a href="listMfmTables">Tablas maestras</a></li> 
	<li class="active"><strong><s:property value="selectedTable.catNombre" /></strong></li> 
</ol>
			

<h2 class="page-title" style="font-weight: bold;text-transform: uppercase;"><s:property value="selectedTable.catNombre" /></h2>    
<h3><s:property value="selectedTable.catDescripcion" /></h3>    

<table class="table table-striped table-hover bigan-dt display">

<s:iterator  status="status" value="Tasks">
	<s:if test="%{#status.first}">
	<thead>
		<tr>
			<s:iterator>
				<td style="font-weight: bold;text-transform: uppercase;"><s:property /></td>
			</s:iterator>
		</tr>
	</thead>
	<tbody>
	</s:if>
	<s:else>
		<tr class="prjItem">
			<s:iterator>
				<td><s:property /></td>
			</s:iterator>
		</tr>
	</s:else>
</s:iterator>
	</tbody>
</table> 	
