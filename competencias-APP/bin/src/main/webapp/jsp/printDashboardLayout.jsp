<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="Midas - Mouldifi. A fully responsive, HTML5 based admin theme">
		<meta name="keywords" content="Responsive, HTML5, admin theme, business, professional, Mouldifi, web design, CSS3">
	
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
	
		<!-- Site favicon -->
		<link rel='shortcut icon' type='image/x-icon' href='<s:url value="/images/favicon.ico"/>' />
		<!-- /site favicon -->
		
	
		<link href="<s:url value="/css/entypo.css"/>" rel="stylesheet">
		<link href="<s:url value="/css/font-awesome.min.css"/>" rel="stylesheet">
		<link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
		<link href="<s:url value="/css/mouldifi-core.css"/>" rel="stylesheet">
		<link href="<s:url value="/css/mouldifi-forms.css"/>" rel="stylesheet">
		<link href="<s:url value="/css/midas.css"/>" rel="stylesheet">
		
		<link href="<s:url value="/css/plugins/morris/morris.css"/>" rel="stylesheet">
		<link href="<s:url value="/css/plugins/datatables/jquery.dataTables.css"/>" rel="stylesheet">
		<link href="<s:url value="js/plugins/datatables/extensions/Buttons/css/buttons.dataTables.css"/>" rel="stylesheet">	

	    
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	      <script src="js/html5shiv.min.js"></script>
	      <script src="js/respond.min.js"></script>
	<![endif]-->
	
	<!--[if lte IE 8]>
		<script src="js/plugins/flot/excanvas.min.js"></script>
	<![endif]-->
	
	
	</head>


<body oncontextmenu="return true;">

<!-- Page container -->
<div class="page-container height100 sidebar-collapsed">

 
  <!-- Main container -->
  <div class="main-container gray-bg height100">
  
		<!-- Main content -->
		<div class="main-content height100">
			<h1 class="page-title"><s:property value="title"/></h1>
  		 
  		 	<tiles:insertAttribute name="body" />

	  </div>
	  <!-- /main content -->
	  
  </div>
  <!-- /main container -->
  
</div>
<!-- /page container -->
		            
<!--Load JQuery-->

<s:url value=""/>
<script src="<s:url value="/js/jquery.min.js"/>"></script>
<script src="<s:url value="/js/bootstrap.min.js"/>"></script>
<script src="<s:url value="/js/plugins/metismenu/jquery.metisMenu.js"/>"></script>
<script src="<s:url value="/js/plugins/blockui-master/jquery-ui.js"/>"></script>
<script src="<s:url value="/js/plugins/blockui-master/jquery.blockUI.js"/>"></script>
<script src="<s:url value="/js/knockout.js"/>"></script>
<script src="<s:url value="/js/mid-message.js"/>"></script>

<!--Float Charts
<script src="<s:url value="/js/plugins/flot/jquery.flot.min.js"/>"></script>
<script src="<s:url value="/js/plugins/flot/jquery.flot.tooltip.min.js"/>"></script>
<script src="<s:url value="/js/plugins/flot/jquery.flot.resize.min.js"/>"></script>
<script src="<s:url value="/js/plugins/flot/jquery.flot.selection.min.js"/>"></script>        
<script src="<s:url value="/js/plugins/flot/jquery.flot.pie.min.js"/>"></script>
<script src="<s:url value="/js/plugins/flot/jquery.flot.time.min.js"/>"></script>
-->
<script src="<s:url value="/js/midas.js"/>"></script>

<!--Morris Charts-->
<script src="<s:url value="/js/plugins/morris/raphael-min.js"/>"></script>
<script src="<s:url value="/js/plugins/morris/morris.min.js"/>"></script>
<script>

window.open = function (url, name, features, replace) {
    $('#iframe').attr('src', url);
}

function resizeIframe(obj) {
  obj.style.height = (obj.contentWindow.document.body.scrollHeight) + 'px';
}

</script>

<tiles:insertAttribute name="script" ignore="true"/>

</body>
</html>
