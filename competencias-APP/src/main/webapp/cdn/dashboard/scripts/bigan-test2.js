var Test = function () {

	var self = this;
		
	var dato = ko.observable();

	  var init = function () {
		   //ko.applyBindings(Test, document.iframe3.contentWindow.test-form);
	  };

	  /* execute the init function when the DOM is ready */
	  $(init);


	return {
		dato:dato
	}
}();


$(BiganStructure.globalSector.subscribe(function () {
	if(typeof BiganStructure.globalSector() != 'undefined')
		Test.dato(BiganStructure.globalSector().descripcion);    
    //alert(BiganStructure.globalSector().codigo);  
}));