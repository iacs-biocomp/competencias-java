<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Comportamientos</h1>

<s:if test="%{editar == false}">
	<table class="table">
	   <thead>
	     <tr>
	     	<th scope="col">      </th>
	       <th scope="col">Descripción</th>
	       <th scope="col">Alta</th>
	       <th scope="col">Baja</th>
	
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="comportamientos">
	   <tr>
	  	 <td><a href="borrarComportamientos?id=<s:property value="id"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a><a href="editarComportamientos?id=<s:property value="id"/>"><i class="fas fa-edit" aria-hidden="true"></i></a></td>
	     <td><s:property value="descripcion"/></td>   
	     <td><s:property value="alta"/></td>  
	     <td><s:property value="baja"/></td>  
	   </tr>
	</s:iterator>
	</tbody>
	</table>
	
	<h4>Nuevo comportamiento</h4>
	<div class="col-lg-6">
		<form action="/nuevoComportamientos" method="post">
		 <ul>
		  <li>
		    <label for="descripcion">Descripción:</label>
	<!-- 	    <input type="text" id="descripcion" name="descripcion" required> -->
		   	 <textarea name="descripcion" id="descripcion" rows="2" cols="40" required></textarea>
		  </li>
		  <li>
		    <label for="alta">Fecha de alta:</label>
			<input type="date" id="alta" name="alta" required>
		</li>
		 <li>
		    <label for="baja">Fecha de baja:</label>
			<input type="date" id="baja" name="baja">
		</li>
		  <li class="button">
			  <button type="submit">Crear comportamiento</button>
			</li>
		 </ul>
		 
		</form>
	
	</div>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
</s:if>
<s:else>
	<table class="table">
	   <thead>
	     <tr>
	     	<th scope="col">      </th>
	       <th scope="col">Descripción</th>
	       <th scope="col">Alta</th>
	       <th scope="col">Baja</th>
	
	     </tr>
	   </thead>
	   <tbody>
	
	<s:iterator value="comportamientos">
		 <s:if test="%{id == idEditar}">
		 	<form name="formEdit" method="post" action="/guardarComportamientos">
		   <tr>
		  	 <td></td>
		     <td>
					     <input id="id" name="id" type="hidden" value="<s:property value="id"/>">
					     <input id="descripcion" name="descripcion" type="text" value="<s:property value="descripcion"/>" size="80"></td>
						<td><input id="alta" name="alta" type="date" value="<s:property value="alta"/>"></td>
						<td><input id="baja" name="baja" type="date" value="<s:property value="baja"/>">
						<input type="Submit" value="Guardar">
						</td>     
		   </tr>
		   </form>
		 </s:if>
		<s:else>
			<tr>
		  	 <td></td>
		     <td><s:property value="descripcion"/></td>   
		     <td><s:property value="alta"/></td>  
		     <td><s:property value="baja"/></td>  
		   </tr>
		</s:else>
	</s:iterator>
	</tbody>
	</table>
</s:else>