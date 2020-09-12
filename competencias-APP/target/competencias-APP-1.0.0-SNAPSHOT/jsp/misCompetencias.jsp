<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <link rel="stylesheet" href="css/acordeon.css" type="text/css"></link> -->

<h1>Mis competencias</h1>

<table class="table">
   <thead>
     <tr>

       <th scope="col">Código</th>
       <th scope="col">Descripción</th>
       <th scope="col">Objetivo</th>

     </tr>
   </thead>
   <tbody>
	
	<s:iterator value="compObjCompCatcomp">
	   <tr> 
	     <td><s:property value="codcompetencia"/></td>
	     <td><s:property value="descripcion"/></td>   
	     <td><s:property value="objetivo"/></td>
	   </tr>
	   
	</s:iterator>
	</tbody>
</table>