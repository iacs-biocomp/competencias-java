	var sliderRange;
	var slider;
	
	
	// Formatea un añomes en formato corto en español
	function formatYM(yearmonth) {
		y = Math.floor(yearmonth/12);
		m = yearmonth % 12;
		d = new Date(y, m, 1);
		options = {year: 'numeric',
				   month: 'short'};
		s = d.toLocaleDateString("es-ES", options);
		return s;
	}
	
	
	// Convierte un añomes en un epoch
	function monthToTime(yearmonth){
		y = Math.floor(yearmonth/12);
		m = (yearmonth % 12 + 1);
		d = new Date(y, m, 1);
		d.setDate(d.getDate() - 1);
		// Gestión de timezones para asegurar tiempos en UTC
		return d.getTime() - d.getTimezoneOffset()*60*1000;
	}
	
	
	//Convierte un epoch en un añomes
	function timeToMonth(time) {
		d = new Date(time);
		return d.getFullYear() * 12 + d.getMonth();
	}
	
	function getDates() {
    	return $.ajax({
	    	dataType:'json',
	    	type: 'GET',
	    	url: '{url}'
    	});
    } 

   var getDatesCB = function(response) {
	   sliderRange = response;
	   slider = new Slider("#slider{frame_id}", {	   
			tooltip: "show",
			ticks: [response.min, Math.trunc((response.max+response.min)/2), response.max],
			ticks_labels: [formatYM(response.min), formatYM(Math.trunc((response.max+response.min)/2)), formatYM(response.max)],
			min: response.min,
			max: response.max,
			step: response.step,
			value: response.max,
			formatter: function(value) {
				return formatYM(value);
			}
		});
	  
	   	slider.on("slideStop", function(slideEvt) {
		  // actualizamos el valor del año en BiganStructure
		  BiganStructure.globalYear(monthToTime(slideEvt));
		});	  
   }

	// BUTTONS
	var interval;
	function startButton() {
		interval = window.setInterval('moveSlider()', 3000);
	}
	
	function moveSlider() {
		value = parseInt(slider.getValue()) + sliderRange.step;
		if (value > sliderRange.max) {
			value = sliderRange.min;
		}
		var nt = monthToTime(value)
		console.log("change time to " + nt);
		BiganStructure.globalYear(nt);
	}

	function stopButton() {
		window.clearInterval(interval);
		  slider.on("slideStop", function(slideEvt) {
			  // actualizamos el valor del año en BiganStructure
			  BiganStructure.globalYear(monthToTime(slideEvt));
			});	 
	}   
   
    if (BiganStructure) {
		BiganStructure.globalYear.subscribe(function () {
			var sl = monthToTime(slider.getValue());
			if (sl != BiganStructure.globalYear()) {
				var nv = timeToMonth(BiganStructure.globalYear());
				slider.setAttribute("value", nv);
				slider.refresh({ useCurrentValue: true });
			}
		});
    }	
	

	$(getDates()
        .done(getDatesCB));
   
   
   
