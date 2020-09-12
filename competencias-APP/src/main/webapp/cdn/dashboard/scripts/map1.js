/*
// Obtenemos el array de datos de un fichero csv
d3.csv('static.action?src=/dashboard/maps/data.csv', function (d) {
    return {
        id: +(d.sector + d.zona),
        sector: d.sector,
        zona: d.zona,
        valor: +d.valor
    }
}, 
	function(error, rows){
		//console.log(rows)
		var map = new mapAragon('#map{frame_id}')
			.data(rows)
			.title('Poblacion %')
			.opacity(1)
			.paint();
		
		map.legendArray = ['0 - 0.2', '0.2 - 0.4', '0.4 - 0.6', '0.6 - 0.8', '0.8 - 1 ']
		
		// bind BiganStructure observable for sector change
		BiganStructure.globalSector.subscribe(function () {
			   if(typeof BiganStructure.globalSector() != 'undefined')
				   map.sectorZoom(BiganStructure.globalSector().codigo);
			   else
				   map.aragonZoom();
		   });
		
	}
) */

   function getData() {
    	return $.ajax({
	    	dataType:'json',
	    	type: 'GET',
	    	url: 'rest/map/aragon?query=6'
    	});
    } 
   
   
   var getDataCB = function(rows) {

		var map = new mapAragon('#map{frame_id}')
			.data(rows)
			.title('Poblacion %')
			.opacity(1)
			.paint();
	
		map.legendArray = ['0 - 20', '20 - 40', '40 - 60', '60 - 80', '80 - 100 ']
		map.colordomain = [0.20, 0.40, 0.60, 0.80, 1.00]
	
		// bind BiganStructure observable for sector change
		BiganStructure.globalSector.subscribe(function () {
		   if(typeof BiganStructure.globalSector() != 'undefined')
			   map.sectorZoom(BiganStructure.globalSector().codigo);
		   else
			   map.aragonZoom();
	   });
    	
		
		BiganStructure.globalZona.subscribe(function () {
			   if(typeof BiganStructure.globalZona() != 'undefined')
				   map.zonaZoom(BiganStructure.globalZona().codigo);
			   else if(typeof BiganStructure.globalSector() != 'undefined')
				   map.sectorZoom(BiganStructure.globalSector().codigo);
			   else
				   map.aragonZoom();
		   });		
		
   };   
   

   $(getData().done(getDataCB));

