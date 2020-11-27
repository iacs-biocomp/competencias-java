<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
	
	<script>
	function submitFormModal3(competencia, categoriaCompetencial){			
			var i=0;
			var idCompetencia="codComp"+i;
			var idCatComp="codCatComp"+i;
			while (document.getElementById(idCompetencia) != null){
				document.getElementById(idCompetencia).value=competencia;
				document.getElementById(idCatComp).value=categoriaCompetencial;
				i++;
				idCompetencia="codComp"+i;
				idCatComp="codCatComp"+i;
				}
		}
	</script>

</head>

<h1><s:property value="nombreCatCompetencial"/></h1>
	<div class="accordion" id="accordion">
	<s:iterator value="compObjCompCatcomp" status="incr">
		<div class="panel accordion-group">
			<div class="accordion-heading">
				<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="%{#incr.index}"/>"><s:property value="descripcion"/></a> Objetivo: <s:property value="objetivo"/></h4>
			</div>
			<div id="<s:property value="%{#incr.index}"/>" class="accordion-body collapse">
				<div class="accordion-inner">
					<div class="accordion" id="accordion2">
						<s:iterator value="listaNiveles" status="stat">
							<div class="panel accordion-group">
								<div class="accordion-heading">
										<h4 class="title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#<s:property value="%{#incr.index}"/><s:property value="%{#stat.index}"/>"><s:property value="nombre"/></a></h4>
								</div>
								<div id="<s:property value="%{#incr.index}"/><s:property value="%{#stat.index}"/>" class="accordion-body collapse">
									<div class="accordion-inner">
										<table class="table">
											<s:iterator value="compRelCompCompleto">
												<s:if test="%{id == idnivel && codcomp == codcompetencia}">
													<tr> 
														<td><s:property value="descripcion"/></td>
													</tr>
												</s:if>
											</s:iterator>
										</table>   
									</div>
								</div>
							</div>
						</s:iterator>
					</div>			
				</div>
			</div>
		</div>
	</s:iterator>	
	</div>

