	var sliderRange;
	var slider;
	
	function getDates() {
    	return $.ajax({
	    	dataType:'json',
	    	type: 'GET',
	    	url: '{url}'
    	});
    } 

   var getDatesCB = function(response) {
	   sliderRange = response;
	   slider = new Slider("#slider", {	   
			tooltip: "hide",
			ticks: [response.min, Math.trunc((response.max+response.min)/2), response.max],
			ticks_labels: [response.min, Math.trunc((response.max+response.min)/2), response.max],
			min: response.min,
			max: response.max,
			step: response.step,
			value: response.max,
			formatter: function(value) {
				return 'Current year: ' + value;
			}
		});
	  
	  slider.on("slide", function(slideEvt) {
		  // actualizamos el valor del año en BiganStructure
		  BiganStructure.globalYear(slideEvt);
		  console.log("current year: " + slideEvt);
		});	  
   }

	// BUTTONS
	var interval;
	function startButton() {
		interval = window.setInterval('moveSlider()', 3000);
	}
	
	function moveSlider() {
		value = parseInt(slider.getAttribute("value")) + sliderRange.step;
		if (value > sliderRange.max) {
			value = sliderRange.min;
		}
		BiganStructure.globalYear(value);
	}

	function stopButton() {
		window.clearInterval(interval);
		  slider.on("slide", function(slideEvt) {
			  // actualizamos el valor del año en BiganStructure
			  BiganStructure.globalYear(slideEvt);
			  console.log("current year: " + slideEvt);
			});	 
	}   
   
    if (BiganStructure) {
		BiganStructure.globalYear.subscribe(function () {
			//console.log("set slider value:" + BiganStructure.globalYear());
			if (slider.getValue() != BiganStructure.globalYear()) {
				slider.setAttribute("value", BiganStructure.globalYear());
				slider.refresh({ useCurrentValue: true });
			}
		});
    }	
	

	$(getDates()
        .done(getDatesCB));
   
   
   
