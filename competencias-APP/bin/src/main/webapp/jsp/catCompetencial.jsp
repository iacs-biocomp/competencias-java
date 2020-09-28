<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <link rel="stylesheet" href="css/acordeon.css" type="text/css"></link> -->

<!-- <h1>Categoría competencial concreta</h1> -->
<h1><s:property value="nombreCatCompetencial"/></h1>
<!-- Aqui debería escribir el nombre de la categoria competencial correspondiente pasada como param -->
<table class="table">
   <thead>
     <tr>
		<th scope="col"></th>
       <th scope="col">Código</th>
       <th scope="col">Descripción</th>
       <th scope="col">Objetivo</th>

     </tr>
   </thead>
   <tbody>
	
	<s:iterator value="compObjCompCatcomp">
	   <tr> 
	   	 <td><a href="borrarRelacionCompetencias?idRelacion=<s:property value="id"/>&catCompetencial=<s:property value="codcatcomp"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a></td>
	     <td><a href="concretaCompetencias?codcomp=<s:property value="codcompetencia"/>&catCompetencial=<s:property value="codcatcomp"/>"><s:property value="codcompetencia"/></td>
	     <td><a href="concretaCompetencias?codcomp=<s:property value="codcompetencia"/>&catCompetencial=<s:property value="codcatcomp"/>"><s:property value="descripcion"/></td>   
	     <td><s:property value="objetivo"/></td>
	   </tr>
	   <tr>
	   <td>
	   <div>
	   
	   <s:if test="%{codcomp == codcompetencia}">
		   <s:iterator value="listaNiveles">
	        
	          <h3><s:property value="nombre"/></h3>
<!-- 	         <div > -->

					   <table class="table">
					   <thead>
					     <tr>
					
					       <th scope="col"></th>
					       <th scope="col">codcompetencia</th>
					       <th scope="col">descripcionComportamiento</th>
					
					     </tr>
					   </thead>
					   <tbody>
						
						<s:iterator value="compRelCompCompleto">
						<s:if test="%{id == idnivel && codcomp == codcompetencia}">
						   <tr> 
						     <td></td>
						     <td><s:property value="codcomp"/></td>   
						     <td><s:property value="descripcion"/></td>
						   </tr>
						</s:if>
						</s:iterator>
						</tbody>
						</table>   
	
<!-- 			</div> -->
		</s:iterator>
		</s:if>
	</div>

	
	</td>
	</tr>  
	</s:iterator>
	</tbody>
</table>
