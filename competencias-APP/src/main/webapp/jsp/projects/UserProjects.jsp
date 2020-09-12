<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.0/css/select.dataTables.min.css">
  	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/select/1.3.0/js/dataTables.select.min.js"></script>
    <script type="text/javascript" src="http://127.0.0.1/cdn/js/projects/userprojects.js"/></script>
<body>
	<div>
		<h2><strong>Por favor</strong>, asigne usuarios a sus respectivos proyectos de investigación.</h2>
		<s:form action="modifypermsProjects" id="formProject" namespace="/">                     
			<label for="users">Usuarios autorizados:</label>
			<div >
            <table id="users" class="display">
	                <thead>
	                    <tr>
	                    	<th></th>
	                        <th>Nombre</th>
	                        <th>Apellido 1</th>
	                        <th>Apellido 2</th>
	                        <th>DNI</th>
	                    </tr>
	                </thead>
	                <tbody>  
	                <s:iterator value="listUser" var="user">          	
			           <tr>
	                    	<td></td>
	                        <td><s:property value="#user.name"/></td>
	                        <td><s:property value="#user.lastname1"/></td>
	                        <td><s:property value="#user.lastname2"/></td>
	                        <td><s:property value="#user.idd"/></td>
	                    </tr> 
			        </s:iterator>
	                </tbody>
	            </table>
	        </div>		    
			<label for=projects>Proyectos autorizados:</label>
			<div >
            <table id="projects" class="display">
	                <thead>
	                    <tr>
	                    	<th></th>
	                        <th>Título</th>
	                        <th>Investigador principal</th>
	                        <th>Id del proyecto</th>
	                    </tr>
	                </thead>
	                <tbody>  
	                <s:iterator value="listProjects" var="project">          	
			           <tr>
	                    	<td></td>
	                        <td><s:property value="#project.titleSt"/></td>
	                        <td><s:property value="#project.researcher"/></td>
	                        <td><s:property value="#project.expId"/></td>
	                    </tr> 
			        </s:iterator>
	                </tbody>
	            </table>
	        </div>	
	        <s:hidden name="listSelectedUsers" id="listSelectedUsers" value="" />
	        <s:hidden name="listSelectedProjects" id="listSelectedProjects" value="" />
			<s:if test="hasActionErrors()">
				<div class="errors">
					<s:actionerror escape="false" />
				</div>
			</s:if>
			<!--  <button type="submit" id="asignar" value=true class="btn btn-primary btn-block">Asignar acceso</button>
			<button type="submit" id="denegar" value=true class="btn btn-primary btn-block">Denegar acceso</button>-->
			<div class="form-group">
				<s:submit cssClass="btn btn-primary btn-block" value="Asignar" name="asignars" type="submit" />
				<!--<s:submit cssClass="btn btn-primary btn-block" value="Denegar" name="denegar"/>-->
				<!-- <button class="btn btn-primary btn-block">Entrar</button> -->
			</div>

			<!--// Recover password 
				<p class="text-center"><a href="forgot-password.html">¿Olvidaste tu contraseña?</a></p> 
			-->
			<!-- <input type="hidden" name="ticket" id="action" value="${requestScope['javax.servlet.forward.servlet_path']}?${requestScope['javax.servlet.forward.query_string']}" />
			-->
		</s:form>
	</div>
</body>