<style>

.node rect {
  cursor: move;
  fill-opacity: .9;
  shape-rendering: crispEdges;
}

.node text {
  pointer-events: none;
  text-shadow: 0 1px 0 #fff;
}

.link {
  fill: none;
  stroke: #000;
  stroke-opacity: .2;
}

.link:hover {
  stroke-opacity: .5;
}

.sankey-container {
    display: inline-block;
    position: relative;
    width: 100%;
    padding-bottom: 100%;
    vertical-align: top;
    overflow: hidden;
}

.sankey-content {
    display: inline-block;
    position: absolute;
    top: 0;
    left: 0;
}

</style>
					<div class="panel-heading clearfix"> 
						<div class="panel-title">{title}</div> 
						 <ul class="panel-tool-options"> 	
<!-- 							<li><a data-rel="collapse" href="#"><i class="icon-down-open"></i></a></li>
							<li><a data-rel="reload" href="#"><i class="icon-arrows-ccw"></i></a></li>
							<li><a data-rel="close" href="#"><i class="icon-cancel"></i></a></li> -->
						</ul>  
					</div> 

					<!-- panel body --> 
					<div id="sankey{frame_id}" class="panel-body sankey-container" style="padding: 10px 10px; width:100%;"> 
					</div> 
