			<div class="row">
				<div class="col-lg-12  des-header">
							{order:1}
				</div>
			</div>			
			<div class="row height100">
				<div class="col-lg-3 hidable  des-frame" id="div1">
					<div class="panel panel-default height100">
							{order:2}
					</div>
				</div>
				<div class="col-lg-3 hidable  des-frame" id="div2">
					<div class="panel panel-default height100">
							{order:3}
					</div>
				</div>
				<div class="col-lg-3 hidable  des-frame" id="div3">
					<div class="panel panel-default height100">
							{order:4}
					</div>
				</div>
				<div class="col-lg-3 hidable  des-frame" id="div4">
					<div class="panel panel-default height100">
							{order:5}
					</div>
				</div>
			</div>
			
<script>
	$('.hidable').on('dblclick', function(e) {
		if ($(this).hasClass("col-lg-3")) {
			$('.hidable').hide();
			$(this).removeClass("col-lg-3");
			$(this).addClass("col-lg-12");
			$(this).show();
		} else {
			$(this).removeClass("col-lg-12");
			$(this).addClass("col-lg-3");
			$('.hidable').show();
		}
	});
</script>			