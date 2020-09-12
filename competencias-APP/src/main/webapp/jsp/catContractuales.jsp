<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="%{editar == false}">
	<h1>Categorías contractuales <a href="/editarCatContractuales"><i class="fas fa-edit" aria-hidden="true" style="align: right"></i></a></h1>

	<table class="table">
	   <thead>
	     <tr>
	       <th scope="col">Categoría contractual</th>
	       <th scope="col">Categoría competencial</th>
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="catContractuales">
	   <tr>
	     <td><s:property value="nombre"/></td>
	     <td><s:property value="nombrecatcomp"/></td>   
	     
	   </tr>
	</s:iterator>
	</tbody>
	</table>
</s:if>
<s:else>
	<h1>Categorías contractuales </h1>
	<table class="table">
   <thead>
     <tr>
       <th scope="col">Categoría contractual</th>
       <th scope="col">Categoría competencial</th>
     </tr>
   </thead>
   <tbody>

	<s:iterator value="catContractuales">
	   <tr>
	     <td><s:property value="nombre"/></td>
	     <td>
	     <form name="f1" method="post" action="/guardarCatContractuales">
	     	<input id="id" name="id" type="hidden" value="<s:property value="id"/>">
			<select name="catcomp">
				<s:iterator value="catCompetenciales">
					<s:if test="%{nombre == nombrecatcomp}">
					   <option selected value="<s:property value="codigo"/>"><s:property value="nombre"/></option>
					</s:if>
					<s:else>
					   <option value="<s:property value="codigo"/>"><s:property value="nombre"/></option> 
					</s:else>
			   </s:iterator>
			</select>
			<input type="Submit" value="Guardar relación">
			</form>
		</td>

<%-- 		<td> <a href="guardarCatContractuales?catContractual=<s:property value="id"/>&catCompetencial=<s:property value="catcomp"/>">Guardar relación</a></td> --%>
<%-- 		<a href="concretaCompetencias?catCompetencial=<s:property value="codigo"/>"><s:property value="codigo"/></a> --%>
	   </tr>
	</s:iterator>
	</tbody>
	</table>
</s:else>