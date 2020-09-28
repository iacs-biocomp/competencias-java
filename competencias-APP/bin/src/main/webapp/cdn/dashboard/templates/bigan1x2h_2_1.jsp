			<div class="row">
				<div class="col-lg-12  des-header">
							{order:1}
				</div>
			</div>			
			<div class="row height100">
				<div class="col-lg-8 hidable  des-frame">
					<div class="panel panel-default height100">
							{order:2}
					</div>
				</div>
				<div class="col-lg-4 hidable  des-frame">
					<div class="panel panel-default height100">
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