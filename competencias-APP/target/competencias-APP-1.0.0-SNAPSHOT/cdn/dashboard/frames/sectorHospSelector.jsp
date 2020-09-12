<!--  depends on bigan-structure.js -->

							<div class="str-bindable panel-heading" style="margin: 0 auto;">
									<div class="col-lg-12 col-md-12">
										<div class="form-group row" data-bind="visible: sectorSelectVisible"> 
										 	<label class="col-sm-2 control-label">Sector</label> 
											<div class="col-sm-10"> 
												<select class="form-control" data-bind="options: sectores,
																						optionsText: 'descripcion',
																						value: globalSector,
																						optionsCaption: 'Seleccione sector...'">
												</select>
											</div> 
										</div>
										<div class="form-group row" data-bind="visible: hospitalSelectVisible"> 
										 	<label class="col-sm-2 control-label">Hospital</label> 
											<div class="col-sm-10"> 
												<select class="form-control" data-bind="options: hospitales,
																						optionsText: 'descripcion',
																						value: globalHospital,
																						optionsCaption: 'Seleccione hospital...'">
												</select>
											</div> 
										</div>
									</div>
							</div>		
						
						
				