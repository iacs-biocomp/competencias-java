<%@ taglib prefix="s" uri="/struts-tags"%>

<body class="login-page">
<div class="login-container">
	<div class="login-branding">
		<a href="index.html"><img src='<s:url value="/images/logo.png" />' alt="Identificacion" title="Identificacion"></a>
	</div>
	<div class="login-content">
		<h2><strong>Bienvenido</strong>, por favor, introduzca una nueva contraseña</h2>
		<s:form action="changePassword" id="formChangePass" namespace="/">                     
			<div class="form-group">
				<input type="password" placeholder="Contraseña" class="form-control" 
					   size="30" value="" id="password" name="password">
			</div>
			<div class="form-group">
				<input name="confirmacionpass" id="confirmacionpass" type="password" placeholder="Confirmación Contraseña" 
				class="form-control" value="" size="30">
			</div>
				<s:if test="hasActionErrors()">
					<div class="errors">
						<s:actionerror escape="false" />
					</div>
				</s:if>

			<div class="form-group">
				<s:submit cssClass="btn btn-primary btn-block" value="Cambiar" name="" type="submit" />
				<!-- <button class="btn btn-primary btn-block">Entrar</button> -->
			</div>

			<!--// Recover password 
				<p class="text-center"><a href="forgot-password.html">¿Olvidaste tu contraseña?</a></p> 
			-->
			<s:hidden name="ticket" id="ticket" value="%{#request.ticket}" />		
			<!-- <input type="hidden" name="ticket" id="action" value="${requestScope['javax.servlet.forward.servlet_path']}?${requestScope['javax.servlet.forward.query_string']}" />
			-->
		</s:form>
	</div>
</div>