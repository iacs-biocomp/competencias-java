			<!-- Proyectos Info -->
			<ul class="user-info pull-left">          
			  <li class="profile-info dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="false"> 
			  <!-- <img width="44" class="img-circle avatar" alt="" src="images/man-3.jpg">  -->
						<i class="icon-clipboard"></i><s:property value="#session.main_project" /> 
		      <span class="caret"></span></a>
			  
				<!-- Project action menu -->
				<ul class="dropdown-menu">
				<s:iterator value="#session.projectListObject" var="project">				  
				  <li>
				  	<a href="<s:url action="changeProject.action" >
						    <s:param name="pj"><s:property value="#project"/></s:param>
						</s:url>">
				  		<i class="icon-clipboard"></i><s:property value="#project"/>
				  	</a>
				  </li>				 
				 </s:iterator>
				</ul>				
			  </li>
			</ul>
			<!-- /Proyectos Info -->