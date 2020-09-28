	/**
	 * Script de componente para un gráfico de lineas basado en Highcharts.
	 * Sensible a fecha (plotband). Anchura ajustada a un mes.
	 * Activo en fecha
	 * Sensible a contexto (nivel, detalle)
	 */

   var chart{frame_id};
   
   function showTimeLine{frame_id} (data, frame, options) {
	   chart{frame_id} = biganShowHighChartLineGraph(data, frame, options);
	   chart{frame_id}.update({
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
	    });	   
	   
	   
	   BiganStructure.globalYear.subscribe(function () {
			var y = BiganStructure.globalYear();
			// Update band marker
		    chart{frame_id}.xAxis[0].removePlotBand('yband');
		    chart{frame_id}.xAxis[0].addPlotBand({color: 'rgba(68, 170, 213, 0.3)', from: y-1250000000, to: y+1250000000, id: 'yband'});
		});		
   }

   
   if (BiganStructure) {  
		BiganStructure.linkContext('hc_{frame_id}', 
									'{url}', 
									showTimeLine{frame_id});
   }

   /*
   <!-- {title:'{title}',height:'350px'} -->
   */

