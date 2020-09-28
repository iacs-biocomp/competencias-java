<%@ taglib prefix="s" uri="/struts-tags"%>

<body class="login-page">
<div class="login-container">
	<div class="login-branding">
		<a href="index.html"><img src='<s:url value="/images/logo.png" />' alt="Identificacion" title="Identificacion"></a>
	</div>
	<div class="login-content">
		<h2><strong>Bienvenido</strong>, por favor, introduzca los siguientes datos.</h2>
		<s:form action="createSolicitud" id="formSolicitud" namespace="/">                     
			<div class="form-group">
				<input type="text" placeholder="Nombre" class="form-control" 
					   size="30" value="" id="nombre" name="nombre">
			</div>
			<div class="form-group">
				<input name="apellido1" id="apellido1" type="text" placeholder="Primer apellido" 
				class="form-control" value="" size="30">
			</div>
			<div class="form-group">
				<input type="text" placeholder="Segundo apellido" class="form-control" 
					   size="30" value="" id="apellido2" name="apellido2">
			</div>
			<div class="form-group">
				<input name="dni" id="dni" type="text" placeholder="Número de identificación (DNI)" 
				class="form-control" value="" size="30">
			</div>
			<div class="form-group">
				<input name="institucion" id="institucion" type="text" placeholder="Institución" 
				class="form-control" value="" size="30">
			</div>
			<div class="form-group">
				<input type="text" placeholder="Correo electrónico" class="form-control" 
					   size="30" value="" id="correo" name="correo">
			</div>
				<s:if test="hasActionErrors()">
					<div class="errors">
						<s:actionerror escape="false" />
					</div>
				</s:if>

			<div class="form-group">
				<s:submit cssClass="btn btn-primary btn-block" value="Enviar solicitud" name="" type="submit" />
				<!-- <button class="btn btn-primary btn-block">Entrar</button> -->
			</div>

			<!--// Recover password 
				<p class="text-center"><a href="forgot-password.html">¿Olvidaste tu contraseña?</a></p> 
			-->
			<!-- <input type="hidden" name="ticket" id="action" value="${requestScope['javax.servlet.forward.servlet_path']}?${requestScope['javax.servlet.forward.query_string']}" />
			-->
		</s:form>
	</div>
</div>