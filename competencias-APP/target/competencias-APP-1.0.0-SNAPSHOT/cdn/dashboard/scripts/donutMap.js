var chart{frame_id};
var map{frame_id};

// despliega un componente que puede ser un Donut o un Mapa dependiendo del nivel de información.
// Se determina en función del gtype que devuelve un componente multigraph

function donutOrMap{frame_id} (data, frame, options) {
	//console.log('llamada a donutormap. Data type ' + data.gtype);
	
	if (data.gtype === 'doughnut') {
		$('#map_{frame_id}').hide();
		$('#hc_{frame_id}').show();
		options.subtitle = data.subtitle;
		chart{frame_id} = biganShowHighChartDonut(data.series,frame,options);
	
	} else {  // gtype === map
		$('#map_{frame_id}').show();
		$('#hc_{frame_id}').hide();
		map{frame_id}.
			filter(data.filter).
			osm(data.osm).
			data(data.data).
			domainMax(data.maxvalue).
			colorArray(getBiganColorList(biganColors.NEGATIVE,5)).
			level(data.level).
			title(data.name).
			units('%').
			paint();
	}
};



/*
 * Si existe el contexto BiganStructure, vincula este componente al contexto
 */
if (BiganStructure != undefined) {  
		$('#map_{frame_id}').hide();
		BiganStructure.linkContext('hc_{frame_id}', 
									'{url}', 
									donutOrMap{frame_id});
		map{frame_id} = 
			biganLlMap('map_{frame_id}');
}

