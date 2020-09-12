					<style>
						path.sector { stroke: #333; stroke-width: 1; }
						path.zona { stroke: #333; stroke-width: 1; }
						path:hover { stroke-width: 3; }

					</style>

					<div class="panel-heading clearfix"> 
						<div class="panel-title">{title}</div> 
						 <ul class="panel-tool-options"> 
							<li class="frameinfo"><i class="fa fa-info-circle"></i>
								<span class="frameinfotext">{text}</span>
							</li>				 
<!-- 							<li><a data-rel="collapse" href="#"><i class="icon-down-open"></i></a></li>
							<li><a data-rel="reload" href="#"><i class="icon-arrows-ccw"></i></a></li>
							<li><a data-rel="close" href="#"><i class="icon-cancel"></i></a></li> -->
						</ul>  
					</div> 

					<!-- panel body --> 
					<div class="panel-body str-bindable" style="position: relative;">
						<div id="map{frame_id}" class="col-lg-6"></div>  
						<div class="col-lg-6" id="hc{frame_id}" style="margin: 0 auto">
						<!-- <img src="static.action?src=/dashboard/images/aragon_icon.png" id="icon-aragon" style="display: none;"></img>  -->
 					</div> 		
					</div>
					
