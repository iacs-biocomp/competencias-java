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

<table class="table table-striped table-hover bigan-dt display">

	<thead>
		<tr>
			<td style="font-weight: bold;text-transform: uppercase;">Fecha inicio</td>
			<td style="font-weight: bold;text-transform: uppercase;">Id</td>			
			<td style="font-weight: bold;text-transform: uppercase;">Nombre</td>
			<td style="font-weight: bold;text-transform: uppercase;">Descripción</td>
			<td style="font-weight: bold;text-transform: uppercase;">Acción</td>		
		</tr>
	</thead>
	<tbody>

		<s:iterator value="Tasks" var="infoMap">
		    <tr>
		        <td><s:property value="#infoMap.date"/></td>
		        <td><s:property value="#infoMap.id"/></td>
		        <td><s:property value="#infoMap.name"/></td>
		        <td><s:property value="#infoMap.description"/></td>
		        <s:if test="%{ #infoMap.assigned == false}"> 
		        	<td>
		        		<s:form action="claimTaskActiviti" id="formTask" namespace="/">
							<s:if test="hasActionErrors()">
								<div class="errors">
									<s:actionerror escape="false" />
								</div>
							</s:if>
							<s:else>	
								<div class="form-group">
									<s:submit cssClass="btn btn-primary btn-block" value="pedir tarea" name="" type="submit" />
									<!-- <button class="btn btn-primary btn-block">Entrar</button> -->
								</div>			
								<s:hidden name="taskId" id="taskId" value="%{#infoMap.id}" />
							</s:else>					    
						</s:form>
		        	</td>
		        </s:if>
		        <s:else>
			    	<td>
		        		<s:form action="completeTaskActiviti" id="formTask" namespace="/">	
						<div class="form-group">
							<select cssClass="btn btn-primary btn-block" name="correoValido" id="correoValido"> 
							    <option value="true">Correo válido</option> 
							    <option value="false">Correo no válido</option> 
							</select> 
							<s:submit cssClass="btn btn-primary btn-block" value="completar" name="" type="submit" />
							<!-- <button class="btn btn-primary btn-block">Entrar</button> -->
						</div>	
						<s:hidden name="taskId" id="taskId" value="%{#infoMap.id}" />						    
					</s:form>
		        	</td>
			</s:else>
		    </tr>	
		</s:iterator>
	</tbody>
</table> 	
