<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Categorías competenciales</h1>

<s:if test="%{editar == false}">
	<table class="table">
	   <thead>
	     <tr>
	       <th scope="col">      </th>
	       <th scope="col">Código</th>
	       <th scope="col">Nombre</th>
	       <th scope="col">Alta</th>
	       <th scope="col">Baja</th>
	     </tr>
	    </thead>
	 	<tbody>
			<s:iterator value="catCompetenciales">
			   <tr>                  
			     <td><a href="borrarCatCompetenciales?codigo=<s:property value="codigo"/>"><i class="fa fa-trash" aria-hidden="true">&nbsp; &nbsp;</i></a><a href="/editarCatCompetenciales?codigo=<s:property value="codigo"/>"><i class="fas fa-edit" aria-hidden="true"></i></a></td>   
			     <td><a href="concretaCompetencias?catCompetencial=<s:property value="codigo"/>"><s:property value="codigo"/></a></td>
			     <td><a href="concretaCompetencias?catCompetencial=<s:property value="codigo"/>"><s:property value="nombre"/></a></td>
				 <td><s:property value="alta"/></td>
				 <td><s:property value="baja"/></td>
			   </tr>
			</s:iterator>
		</tbody>
	</table>
	<h4>Nueva categoría competencial</h4>
	<div class="col-lg-6">
		<form action="/nuevaCatCompetenciales" method="post">
		 <ul>
		 <li>
		    <label for="codigo">Código:</label>
		    <input type="text" id="codigo" name="codigo" required>
		  </li>
		  <li>
		    <label for="nombre">Nombre:</label>
		    <input type="text" id="nombre" name="nombre" required>
		  </li>
		  <li>
		    <label for="alta">Fecha de alta:</label>
			<input type="date" id="alta" name="alta"
			       value=""
			       min="2018-01-01" max="2050-12-31" required>
		</li>
		 <li>
		    <label for="baja">Fecha de baja:</label>
			<input type="date" id="baja" name="baja"
			       value=""
			       min="2018-01-01" max="2050-12-31">
		</li>
		  <li class="button">
			  <button type="submit">Crear categoría competencial</button>
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
	       <th scope="col">Código</th>
	       <th scope="col">Nombre</th>
	       <th scope="col">Alta</th>
	       <th scope="col">Baja</th>
	     </tr>
	   </thead>
		<tbody>
			<s:iterator value="catCompetenciales">
			   <s:if test="%{codigo == codEditar}">
			   		<form name="formEdit" method="post" action="/guardarCatCompetenciales">
			   		<tr>
					     <td></td>
					     <td><s:property value="codigo"/></td>
					     <td>
					     <input id="codigo" name="codigo" type="hidden" value="<s:property value="codigo"/>">
					     <input id="nombre" name="nombre" type="text" value="<s:property value="nombre"/>" size="80"></td>
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
					     <td><s:property value="codigo"/></td>
					     <td><s:property value="nombre"/></td>
						<td><s:property value="alta"/></td>
						<td><s:property value="baja"/></td>
					</tr>
				</s:else>
			</s:iterator>
		</tbody>
	</table>
</s:else>