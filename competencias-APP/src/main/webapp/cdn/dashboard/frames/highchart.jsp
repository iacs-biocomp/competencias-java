<!--  Frame to include highcharts graphics
	  Div for graphics has name hc_{frame_id} and height=400px
 -->



					<div class="panel-heading clearfix"> 
						<div class="panel-title">{title}</div> 
						 <ul class="panel-tool-options"> 
<!-- 							<li><a data-rel="collapse" href="#"><i class="icon-down-open"></i></a></li>
							<li><a data-rel="reload" href="#"><i class="icon-arrows-ccw"></i></a></li>
							<li><a data-rel="close" href="#"><i class="icon-cancel"></i></a></li> -->
							<li class="frameinfo"><i class="fa fa-info-circle"></i>
								<span class="frameinfotext">{text}</span>
							</li> 								
						</ul>  
					</div> 

					<!-- panel body --> 
					<div class="panel-body" id="hc_{frame_id}" style="height: 400px; margin: 0 auto"></div>
