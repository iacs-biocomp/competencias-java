<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1> Organigramas</h1>


	<table class="table">
	   <thead>
	     <tr>
	     	<th scope="col">      </th>
	       <th scope="col">id</th>
	       <th scope="col">Fecha inicio</th>
	       <th scope="col">Fecha fin</th>
	
	     </tr>
	   </thead>
	   <tbody>
	<s:iterator value="listaOrganigramas">
			   <tr>  
			   <td><a href="concretoOrganigramas?id=<s:property value="id"/>"><i class="fas fa-mouse-pointer"></i></a></td>
			 	  <td><s:property value="id"/></td>                
				 <td><s:property value="fechaIni"/></td>
				 <td><s:property value="fechaFin"/></td>
			   </tr>
			</s:iterator>
	</tbody>
	</table>