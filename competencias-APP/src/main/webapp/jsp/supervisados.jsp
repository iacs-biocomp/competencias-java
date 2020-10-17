<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1> Mis supervisados</h1>

<s:iterator value="listaSuperiores" status="incr">
	<s:if test="%{dniSuperior == dniActual}">
	
	<div class="row">
		<div class="col-lg-12">
			<s:iterator value="listaTrabajadores">
				<s:if test="%{dniTrabajador == dni}">
					<h2 class="title"><s:property value="nombre"/> <s:property value="apellidos"/></h2>
				</s:if>
			</s:iterator>
<!-- 							SUPERIORES -->
<%-- 				<s:iterator value="listaSuperiores" status="incr9"> --%>
<%-- 					<s:if test="%{dniSuperior == dniActual}"> --%>
<!-- 						<div class="panel accordion-group"> -->
<%-- 							<s:iterator value="listaTrabajadores"> --%>
<%-- 								<s:if test="%{dniTrabajador == dni}"> --%>
<!-- 									<div class="accordion-heading"> -->
<%-- 										<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion9" href="#<s:property value="%{#incr9.index}"/>9"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4> --%>
<!-- 									</div> -->
<%-- 								</s:if> --%>
<%-- 							</s:iterator> --%>
<%-- 							<s:iterator value="listaExternos"> --%>
<%-- 								<s:if test="%{dniTrabajador == dni}"> --%>
<!-- 									<div class="accordion-heading"> -->
<%-- 										<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion9" href="#<s:property value="%{#incr9.index}"/>9"><s:property value="nombre"/> <s:property value="apellidos"/></a></h4> --%>
<!-- 									</div> -->
<%-- 								</s:if> --%>
<%-- 							</s:iterator> --%>
<%-- 							<div id="<s:property value="%{#incr9.index}"/>9" class="accordion-body collapse"> --%>
<!-- 								<div class="accordion-inner"> -->
<%-- 									<s:if test="%{dniPar != null}"> --%>
<%-- 										<h5><label class="col-sm-2 control-label">DNI:</label>  <s:property value="dniPar"/></h5> --%>
<%-- 									</s:if> --%>
						
<!-- 									<h5><label class="col-sm-2 control-label">Competencias que evalúa:</label> </h5><br></br> -->
									
<!-- 	<!-- 								PONER LAS 10 COMPETENCIAS DE LA CAT COMPETENCIAL DEL TRABAJADOR ??--> 
	
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<%-- 					</s:if> --%>
<%-- 				</s:iterator> --%>
			
		</div>
	</div>
	</s:if>
</s:iterator>