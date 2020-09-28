$(function () {
    "use strict";

    // LINE CHART Without background
    var lineChart{frame_id} = new Morris.Line({
        element: 'morris-line-chart-{frame_id}',
        data: 	[
        	{casos: '2014', 11: 2862, 12: 3804, 21: 6224, 31: 6491, 32:	1825, 41: 2143,	42:	2108, 51: 4144},
	 		{casos: '2015', 11: 2908, 12: 3912, 21: 6312, 31: 6562, 32: 1808, 41: 2244, 42: 1982, 51: 4244},
	 		{casos: '2016', 11: 2891, 12: 4041, 21: 6304, 31: 6749, 32: 1809, 41: 2270, 42: 2010, 51: 4168}
	 		],
        xkey: 'casos',
        ykeys:  ['11','12','21','31','32','41','42','51'],
        labels: ['11','12','21','31','32','41','42','51'],
        hideHover: 'auto',
        resize: true,
        lineColors: ['#6ac7d2', '#00b8ce'],
    });

});