var data{frame_id};
var elem{frame_id}; 


function getDataTm{frame_id}() {
    	return $.ajax({
	    	dataType:'json',
	    	type: 'GET',
	    	url: 'rest/tree/static?map=2'
    	});
} 
var getDataTmCB{frame_id} = function(response) {
	data{frame_id} = response;
	var e = staticTreeMap("#svg{frame_id}" )
		.data(data{frame_id})
		.render();
	elem{frame_id} = e;
	//d3.select("#svg{frame_id}").style("width", "50%");
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
	
});  

