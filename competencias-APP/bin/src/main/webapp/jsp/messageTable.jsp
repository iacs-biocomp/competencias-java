<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript" src="<s:url value="/js/DataTables/jquery.dataTables.min.js"/>"></script>

<div class="table-responsive">
	<table id="listTable" class="table">
		<thead>
			<tr>
				<th  style="width:70%">Mensaje</th>
				<th  style="width:20%">Fecha</th>
				<th  style="width:10%">Estado</th>
			</tr>
		</thead>
		
		<tbody>
			<s:iterator value="listaMensajes">
				<tr id='filas'> 
					<td><s:property value="message"/></td>
					<td><s:property value="sendDate"/></td>
					<td><s:property value="status"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
	




	