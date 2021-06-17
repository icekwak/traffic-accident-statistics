function tcreateGraph(response){
	let data;
	let labels = [];
	let accident = [];
	let death = [];
	let injured = [];
	
	for(let i=0; i<response.length; i++){
		data = response[i];
		labels.push(data.id);
		accident.push(parseInt(data.accident));
		death.push(parseInt(data.death));
		injured.push(parseInt(data.injured));
	}
	
	let chartId = document.getElementById("cc");
	chart = new Chart(chartId, {
		type: "line",
		data: {
			labels: labels,
			datasets: [
				{
					label: "사고건수",
					data: accident,
					borderColor: Utils.CHART_COLORS.red,
					fill: false,
					tension: 0.4
				},
				{
					label: "사망자수",
					data: death,
					borderColor: Utils.CHART_COLORS.blue,
					fill: false,
					tension: 0.4
				},
				{
					label: "부상자수",
					data: injured,
					borderColor: Utils.CHART_COLORS.green,
					fill: false,
					tension: 0.4
				}
			]
		},
		options: {
            responsive: true,
			plugins: {
      title: {
        display: true,
        text: 'Chart.js Line Chart - Cubic interpolation mode'
      },
    },
    interaction: {
      intersect: false,
    },
    scales: {
      x: {
        display: true,
        title: {
          display: true
        }
      },
      y: {
        display: true,
        title: {
          display: true,
          text: 'Value'
        },
        suggestedMin: -10,
        suggestedMax: 200
      }
    },
        }
	});
}