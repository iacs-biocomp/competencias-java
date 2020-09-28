<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Pruebas</h1>

<table class="table">
   <thead>
     <tr>
       <th scope="col">ID</th>
       <th scope="col">nombre</th>
       <th scope="col">Fecha alta</th>
     </tr>
   </thead>
   <tbody>

<s:iterator value="listaPruebas">
   <tr>
     <td><s:property value="ID"/></td>
     <td><s:property value="nombre"/></td>
     <td><s:date name="Date" format="dd/MM/yyyy hh:mm"/></td>
   </tr>
</s:iterator>
</tbody>
</table>