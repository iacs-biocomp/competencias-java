<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1> Resultados ev concreta</h1>
<s:iterator value="evaluacionActual">
<s:iterator value="evaluados" var="ev">
<div class="row">
	<div class="col-lg-12">
		<h2 class="title"><s:property value="nombre"/> <s:property value="apellidos"/> </h2>
		<s:iterator value="competencias" var="competencia">
			<s:if test="%{ codigo == comp1 || codigo == comp2 || codigo == comp3 || codigo == comp4 || codigo == comp5 || codigo == comp6 || codigo == comp7 || codigo == comp8 || codigo == comp9 || codigo == comp10}">
				<table class="table">
				   <thead>
				     <tr>
				     	<th scope="col"> <s:property value="#competencia.codigo" /></th>
				     	<s:iterator value="niveles">
				      		<th scope="col"><s:property value="nombre"/> </th>
				      	</s:iterator>
						<th scope="col">Promedio </th>
						<th scope="col">Objetivo: <s:iterator value="objCompCatcomp" var="obj">
										      		<s:if test="%{#ev.catcompetencial==#obj.codcatcomp && #competencia.codigo==#obj.codcompetencia}">
										      			<s:property value="objetivo"/>
										      		</s:if>
										      	</s:iterator>
						
						 </th>
				
				     </tr>
				   </thead>
				   <tbody>
				
				   <tr>
				   	 <th>Autoevaluación</th>
				   	 
				   	 <s:iterator value="niveles" var="nivel">
				   	 	<s:set var="lanota">-</s:set>
				   	 	<s:iterator value="resultados">
				   	 		<s:if test="%{ dnievaluado==dni && grupoev==1 && #nivel.id==idnivel && #competencia.codigo ==codcomp}">
				      			<s:set var="lanota"><s:property value="suma/numvaloraciones*100/5"/></s:set>
				      		</s:if>
				      	</s:iterator>
				      	<td><s:property value="lanota"/></td>
				      </s:iterator>
				      <s:set var="lanota">-</s:set>
				   	 	<s:iterator value="resultados">
				   	 		<s:if test="%{ dnievaluado==dni && grupoev==1 && idnivel==-1 && #competencia.codigo ==codcomp}">
				      			<s:set var="lanota"><s:property value="suma/numvaloraciones*100/5"/></s:set>
				      		</s:if>
				      	</s:iterator>
				      	<td><s:property value="lanota"/></td>
				      
				   </tr>
			
					<tr>
				   	 <th>Personas que me organizan el trabajo</th>
				     
				   	 <s:iterator value="niveles" var="nivel">
				   	 	<s:set var="lanota">-</s:set>
				   	 	<s:iterator value="resultados">
				   	 		<s:if test="%{ dnievaluado==dni && grupoev==2 && #nivel.id==idnivel && #competencia.codigo ==codcomp}">
				      			<s:set var="lanota"><s:property value="suma/numvaloraciones*100/5"/></s:set>
				      		</s:if>
				      	</s:iterator>
				      	<td><s:property value="lanota"/></td>
				      </s:iterator>
				      <s:set var="lanota">-</s:set>
				   	 	<s:iterator value="resultados">
				   	 		<s:if test="%{ dnievaluado==dni && grupoev==2 && idnivel==-1 && #competencia.codigo ==codcomp}">
				      			<s:set var="lanota"><s:property value="suma/numvaloraciones*100/5"/></s:set>
				      		</s:if>
				      	</s:iterator>
				      	<td><s:property value="lanota"/></td>
				   
				   </tr>
					<tr>
				   	 <th>Personas a las que les organizo el trabajo</th>
				     
				   	 <s:iterator value="niveles" var="nivel">
				   	 	<s:set var="lanota">-</s:set>
				   	 	<s:iterator value="resultados">
				   	 		<s:if test="%{ dnievaluado==dni && grupoev==3 && #nivel.id==idnivel && #competencia.codigo ==codcomp}">
				      			<s:set var="lanota"><s:property value="suma/numvaloraciones*100/5"/></s:set>
				      		</s:if>
				      	</s:iterator>
				      	<td><s:property value="lanota"/></td>
				      </s:iterator>
				      <s:set var="lanota">-</s:set>
				   	 	<s:iterator value="resultados">
				   	 		<s:if test="%{ dnievaluado==dni && grupoev==3 && idnivel==-1 && #competencia.codigo ==codcomp}">
				      			<s:set var="lanota"><s:property value="suma/numvaloraciones*100/5"/></s:set>
				      		</s:if>
				      	</s:iterator>
				      	<td><s:property value="lanota"/></td>
				      
				   </tr>
				   <tr>
				   	 <th>Personas que trabajan conmigo</th>
				     
				   	 <s:iterator value="niveles" var="nivel">
				   	 	<s:set var="lanota">-</s:set>
				   	 	<s:iterator value="resultados">
				   	 		<s:if test="%{ dnievaluado==dni && grupoev==4 && #nivel.id==idnivel && #competencia.codigo ==codcomp}">
				      			<s:set var="lanota"><s:property value="suma/numvaloraciones*100/5"/></s:set>
				      		</s:if>
				      	</s:iterator>
				      	<td><s:property value="lanota"/></td>
				      </s:iterator>
				      <s:set var="lanota">-</s:set>
				   	 	<s:iterator value="resultados">
				   	 		<s:if test="%{ dnievaluado==dni && grupoev==4 && idnivel==-1 && #competencia.codigo ==codcomp}">
				      			<s:set var="lanota"><s:property value="suma/numvaloraciones*100/5"/></s:set>
				      		</s:if>
				      	</s:iterator>
				      	<td><s:property value="lanota"/></td>
				 
				   </tr>
				   <tr>
				   	 <th>Personas a las que entrego mi trabajo</th>
				    
				   	 <s:iterator value="niveles" var="nivel">
				   	 	<s:set var="lanota">-</s:set>
				   	 	<s:iterator value="resultados">
				   	 		<s:if test="%{ dnievaluado==dni && grupoev==5 && #nivel.id==idnivel && #competencia.codigo ==codcomp}">
				      			<s:set var="lanota"><s:property value="suma/numvaloraciones*100/5"/></s:set>
				      		</s:if>
				      	</s:iterator>
				      	<td><s:property value="lanota"/></td>
				      </s:iterator>
				      <s:set var="lanota">-</s:set>
				   	 	<s:iterator value="resultados">
				   	 		<s:if test="%{ dnievaluado==dni && grupoev==5 && idnivel==-1 && #competencia.codigo ==codcomp}">
				      			<s:set var="lanota"><s:property value="suma/numvaloraciones*100/5"/></s:set>
				      		</s:if>
				      	</s:iterator>
				      	<td><s:property value="lanota"/></td>
			
				   </tr>
				</tbody>
				</table>
			</s:if>
		</s:iterator>
	</div>
</div>
</s:iterator>
</s:iterator>

