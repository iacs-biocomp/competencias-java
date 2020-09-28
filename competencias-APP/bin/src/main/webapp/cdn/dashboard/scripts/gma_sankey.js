var units = "K usuarios";


var sankey = d3.sankey('#sankey{frame_id}')
  .nodeWidth(40)
  .nodePadding(30);


// load the data
d3.json('static.action?src=/dashboard/scripts/sankey.json', function(error, graph) {
  sankey
      .nodes(graph.nodes)
      .links(graph.links)
  	  .paint();
});