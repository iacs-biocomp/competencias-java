$.getJSON("{url}",
    function (data) {
		biganShowHighChartLineGraph(data, 
				'hc_{frame_id}', 
				'{title}')
})
