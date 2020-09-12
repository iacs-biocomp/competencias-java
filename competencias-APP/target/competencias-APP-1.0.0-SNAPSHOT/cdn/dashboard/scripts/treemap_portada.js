var data{frame_id};
var elem{frame_id}; 


function getDataTm{frame_id}() {
    	return $.ajax({
	    	dataType:'json',
	    	type: 'GET',
	    	url: 'rest/tree/static?map=1'
    	});
} 
var getDataTmCB{frame_id} = function(response) {
	data{frame_id} = response;
	var e = staticTreeMap("#svg{frame_id}" )
		.data(data{frame_id})
		.render();
	elem{frame_id} = e;
};
   


$(function() {
	// Load data
	getDataTm{frame_id}()
	.done(getDataTmCB{frame_id});
	
	// Configure events
	$('.treemap').resize(function() {
		elem{frame_id}.repaint();  
	});	

	$( window ).resize(function() {
		elem{frame_id}.repaint(); 
	});


	if (BiganStructure) {
		// bind BiganStructure observable for sector change
		BiganStructure.globalSector.subscribe(function () {
			   if(typeof BiganStructure.globalSector() != 'undefined')
				   elem{frame_id}.mark(BiganStructure.globalSector().codigo, 'sector', true);
			   else
				   elem{frame_id}.unmarkAll('sector');
		});
	}	
	
});  

