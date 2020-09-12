<!--  depends on bigan-structure.js -->

							<div class="str-bindable panel-heading" style="margin: 0 auto;">
									<div class="col-lg-12 col-md-12">
										<div class="form-group row"> 
										 	<label class="col-sm-2 control-label">Sectores</label> 
											<div class="col-sm-10"> 
												<select class="form-control" data-bind="options: sectores,
																						optionsText: 'descripcion',
																						value: globalSector,
																						optionsCaption: 'Seleccione sector...'">
												</select>
											</div> 
										</div>
										<div class="form-group row" data-bind="visible: zonaVisible"> 
										 	<label class="col-sm-2 control-label">Zonas</label> 
											<div class="col-sm-10"> 
												<select class="form-control" data-bind="options: zonas,
																						optionsText: 'descripcion',
																						value: globalZona,
																						optionsCaption: 'Seleccione zona...'">
												</select>
											</div> 
										</div>
										<div class="form-group row" data-bind="visible: ciasVisible"> 
										 	<label class="col-sm-2 control-label">CIAS</label> 
											<div class="col-sm-10"> 
												<select class="form-control" data-bind="options: cias,
																						optionsText: 'ciasCd',
																						value: globalCIAS,
																						optionsCaption: 'Seleccione CIAS...'">
												</select>
											</div> 
										</div>	
									</div>
							</div>		
						
						
				