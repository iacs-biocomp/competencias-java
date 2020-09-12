			<div class="row">
				<div class="col-lg-12 des-header">
							{order:0}
					<div class="row"  style="background-color: #DEE;margin: 10px;">
						<div class="col-lg-4">
							{order:101}
						</div>			
						<div class="col-lg-4">
							{order:102}
						</div>			
						<div class="col-lg-4">
							{order:103}
						</div>			
					</div>					
				</div>
			</div>			
			<div class="row height100">
				<div class="col-lg-6 des-frame">
					<div class="panel panel-default ">
							{order:2}
					</div>
				</div>
				<div class="col-lg-6 des-frame">
					<div class="panel panel-default ">
							{order:3}
					</div>
				</div>
			</div>
			
<script>
	$('.hidable').on('dblclick', function(e) {
		if ($(this).hasClass("col-lg-4")) {
			$('.hidable').hide();
			$(this).removeClass("col-lg-4");
			$(this).addClass("col-lg-12");
			$(this).show();
		} else {
			$(this).removeClass("col-lg-12");
			$(this).addClass("col-lg-4");
			$('.hidable').show();
		}
	});
</script>					