<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="<s:url value="/css/treeExplorer/tree.css"/>" rel="stylesheet">
<script src='<s:url value="/js/treeExplorer/tree.js"/>'></script>
<script src='<s:url value="/js/treeExplorer/treeitem.js"/>'></script>
<script src='<s:url value="/js/treeExplorer/treeitemClick.js"/>'></script>
		
		  <h3 id="tree_label">
            Mis proyectos
          </h3>
          <ul role="tree" aria-labelledby="tree_label">
          	<s:iterator value="Directories" var="directory">          	
	            <li role="treeitem" aria-expanded="false">
	              <span>
	                <s:property value="#directory.key"/>
	              </span>
	              <ul role="group">
	              	<s:iterator value="#directory.value" var="file">
		                <li role="treeitem" class="doc">
		                 <s:property value="#file"/>
		                </li>
	                </s:iterator>	
	              </ul>
	            </li>
	        </s:iterator>	
          </ul>
          <p>
            <label>
            	<s:form action="wgetFile" id="formTask" namespace="/">	
	                <div id="desplegableB" style="display: none ; width: 30%" class="form-group">
						<s:submit cssClass="btn btn-primary btn-block" value="Descargar" name="" type="submit" />
						<input type="hidden" name="file" id="file" value="" />
						<!-- <button class="btn btn-primary btn-block">Entrar</button> -->
					</div>						    
			  	</s:form>
            </label>
          </p>
 
			
			
