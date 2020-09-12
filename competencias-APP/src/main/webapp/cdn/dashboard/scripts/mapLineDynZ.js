/**
 * Visualiza mapa de Aragón por sectores, 
 * y líneas de evolución por años.
 * Todas ellas vinculadas a BiganStructure con 
 * conexión por sector y año.
 */

/* Formato de los datos recibidos:
 * [
    {
        "id": 1,
        "valor": 8.22,
        "sector": "11",
        "snombre": "HUESCA",
        "zona": null,
        "znombre": null,
        "year": 2003
    }, ...
   ]
 */

   var mapResults{frame_id};
   // Chart para visualizar lines
   var chart{frame_id};
   // mapa dinámico
   var map{frame_id} = 
	   new biganMapAragonZ('#map{frame_id}');
   
   
	
	// Get graph data from query
   function getData{frame_id}() {
    	return $.ajax({
	    	dataType:'json',
	    	type: 'GET',
	    	url: 'rest/map/aragon?query={query}'
    	});
    } 
   
   // Callback function
   // Gestiona la serie temporal y el movimiento dinámico
   var getDataCB{frame_id} = function(rows) {
	   mapResults{frame_id} = rows;
	   
	   // Most recent date
	   var yr = Math.max.apply(Math, rows.map(function(o) { return o.year; }));	   
	   // Global max value
	   var m = Math.max.apply(Math, rows.map(function(o) { return o.valor;}));
	   
	   filteredRows = rows.filter(row => row.year == yr);

	   // Painting map
	   map{frame_id}.data(filteredRows)
	   		.title(null)
	   		.detail('sector')
			.opacity(1)
			.domainMax(m)
			.colorArray(getBiganColorList(biganColors.NEGATIVE,5));
	   map{frame_id}.paint();		
	

	   // Creamos el gráfico de líneas, lo configuramos, y lo mostramos
		chart{frame_id} = biganManagerHighChart(rows, 
											    'hc{frame_id}', 
											    {	
													title:null,
													height:'120%',
													yAxisTitle:'{title}',
													valueSuffix:''})
		chart{frame_id}.empty()
					   .pushAllSectors()
					   .pushAragon()
   					   .options({
							plotOptions: {
					            series: {
					                point: {
					                    events: {
					                    	click:function(){
					            				BiganStructure.globalYear(this.category);
					            			}
					                    }
					                }
					            }
					        }
					   })
					   .paint()
;
   };   
   

   
   
   
   
   
   if (BiganStructure) {

	   // bind BiganStructure observable for sector change
		BiganStructure.globalSector.subscribe(function () {
		   if(typeof BiganStructure.globalSector() != 'undefined') {
			   // map{frame_id}.sectorZoom(BiganStructure.globalSector().codigo);
			   map{frame_id}.updateSector(BiganStructure.globalSector().codigo);

			   chart{frame_id}.setAllInvisibleExcept(BiganStructure.globalSector().codigo);
			   chart{frame_id}.setVisible('02');

		   }
		   else {
			   // map{frame_id}.aragonZoom();
			   map{frame_id}.updateSector(undefined);			   
			   if (chart{frame_id}) {

				   chart{frame_id}.setAllVisible();
			   }
		   }
		});
		
		
		BiganStructure.globalZona.subscribe(function () {

		   if(BiganStructure.globalZona() != undefined) {
			   if (chart{frame_id}) {
				   chart{frame_id}
				   		.empty()
				   		.pushZbs(BiganStructure.globalZona().codigo)
				   		.pushSector(BiganStructure.globalSector().codigo)
				   		.pushAragon()
				   		.paint()
			   }
		   } else {
			   if (chart{frame_id}) {
				   
				   chart{frame_id}
			   		.empty()
			   		.pushAllSectors()
			   		.pushAragon()
			   		.paint()
			   	if (BiganStructure.globalSector() != undefined)
			   	   chart{frame_id}.setAllInvisibleExcept(BiganStructure.globalSector().codigo);
			   }
			   
		   }
		});		
		
		
		// Interacción cambio de año
		BiganStructure.globalYear.subscribe(function () {
			var y = BiganStructure.globalYear() / 1000;
		    
			// select data
			filteredRows = mapResults{frame_id}.filter(row => row.year == y);
		    // update map
			map{frame_id}.data(filteredRows);
		    map{frame_id}.recolor(2000);
		    
		    // Update band marker
			y = BiganStructure.globalYear();
			chart{frame_id}.markMonth(y);
		});
		
		
		// Interacción cambio de nivel
		BiganStructure.globalDetail.subscribe(function () {
			map{frame_id}.detail(BiganStructure.globalDetail())
		});   
   }
   

   $(getData{frame_id}()
		  .done(getDataCB{frame_id}));


