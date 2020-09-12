<%@ taglib prefix="s" uri="/struts-tags"%>

  <link rel="stylesheet" type="text/css" href="http://127.0.0.1/cdn/css/editorgrafico/estilo.css"/> 
  <!-- <link rel="stylesheet" type="text/css" href="http://127.0.0.1/cdn/css/editorgrafico/estilo.css"/> -->
  <link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.indigo-pink.min.css">
  <!-- <script src='<s:url value="/js/editorgrafico/blockly_compressed.js"/>'></script> -->
  <script type="text/javascript" src="http://127.0.0.1/cdn/js/editorgrafico/blockly_compressed.js"/></script>  
  <!-- <script src='<s:url value="/js/editorgrafico/javascript_compressed.js"/>'></script> -->
  <script type="text/javascript" src="http://127.0.0.1/cdn/js/editorgrafico/javascript_compressed.js"/></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


<body mode="blockly">
  <main>
     <button id="delete" class="mdl-button" style="margin-left: 10px">Borrar diseño</button>
     <button id="save" class="mdl-button" style="margin-left: 10px">Guardar diseño</button>
     <button id="show" class="mdl-button" style="margin-left: 10px">Importar diseño</button>
     <button id="execute" class="mdl-button" style="margin-left: 10px">Ejecutar extracción</button>
     <div id="blockly-editor" class="blockly-editor">
      	<div id="blockly-div" class="blockly-div"></div>
    </div>
  </main>

  <!-- <script src='<s:url value="/js/editorgrafico/blocks.js"/>'></script> -->
  <script type="text/javascript" src="http://127.0.0.1/cdn/js/editorgrafico/blocks.js"/></script>
  
  <!-- <script src='<s:url value="/js/editorgrafico/buttons.js"/>'></script> -->
  <script type="text/javascript" src="http://127.0.0.1/cdn/js/editorgrafico/buttons.js"/></script>
  
  <!-- <script src='<s:url value="/js/editorgrafico/connection.js"/>'></script> -->
  <script type="text/javascript" src="http://127.0.0.1/cdn/js/editorgrafico/connection.js"/></script>
  
</body>
