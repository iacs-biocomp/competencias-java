var data{frame_id};
var elem{frame_id}; 
var urlBase = '{url}'

	
function getDataTm{frame_id}(url) {
    	return $.ajax({
	    	dataType:'json',
	    	type: 'GET',
	    	url: url
    	});
} 

var getDataTmCB{frame_id} = function(response) {
	data{frame_id} = response;
	
	var e = biganStaticTreeMap("#svg{frame_id}", response.config)
		.data(response.rootItem)	
		.render();
	elem{frame_id} = e;
};
   


$(function() {
	// Load data
	getDataTm{frame_id}(urlBase)
		.done(getDataTmCB{frame_id});
	
	// Configure events
	$('.treemap').resize(function() {
		elem{frame_id}.repaint();  
	});	

	$( window ).resize(function() {
		elem{frame_id}.repaint(); 
	});
	
		
	if (BiganStructure) {
		
 		BiganStructure.globalSector.subscribe(function () {
 			var url = urlBase;
 			
 			if(typeof BiganStructure.globalSector() != 'undefined') {
			   var url = urlBase + '&sector=' + BiganStructure.globalSector().codigo + '&nombre=' + BiganStructure.globalSector().descripcion
	 		   $('#title{frame_id}').html(BiganStructure.globalSector().descripcion);
 			} else {
 	 		   $('#title{frame_id}').html('ARAGÓN');
 			}

		   getDataTm{frame_id}(url)
			.done(getDataTmCB{frame_id});
		});
	
 		
 		BiganStructure.globalZona.subscribe(function () {
 			var url = urlBase;
 			
			if(typeof BiganStructure.globalZona() != 'undefined') {
			   var url = urlBase + '&zbs=' + BiganStructure.globalZona().codigo + '&nombre=' + BiganStructure.globalZona().descripcion
	 		   $('#title{frame_id}').html(BiganStructure.globalZona().descripcion);
			} else if(typeof BiganStructure.globalSector() != 'undefined') {
			   var url = urlBase + '&sector=' + BiganStructure.globalSector().codigo + '&nombre=' + BiganStructure.globalSector().descripcion
	 		   $('#title{frame_id}').html(BiganStructure.globalSector().descripcion);
			}
			   
		   getDataTm{frame_id}(url)
			.done(getDataTmCB{frame_id});
		});

 		BiganStructure.globalCIAS.subscribe(function () {
 			var url = urlBase;
 			
			if(typeof BiganStructure.globalCIAS() != 'undefined') {
			   var url = urlBase + '&cias=' + BiganStructure.globalCIAS().ciasCd + '&nombre=' + BiganStructure.globalCIAS().ciasCd
	 		   $('#title{frame_id}').html(BiganStructure.globalCIAS().ciasCd);			   
		    } else if(typeof BiganStructure.globalZona() != 'undefined') {
		    	var url = urlBase + '&zbs=' + BiganStructure.globalZona().codigo + '&nombre=' + BiganStructure.globalZona().descripcion;
		 		$('#title{frame_id}').html(BiganStructure.globalZona().descripcion);
		    }
			   
		   getDataTm{frame_id}(url)
			.done(getDataTmCB{frame_id});
		}); 		
 		
	}	

});  

