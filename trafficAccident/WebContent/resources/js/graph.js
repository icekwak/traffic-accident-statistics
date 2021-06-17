function createGraph(response, max){
	let data, chartId, chart;
	let id, accident, death, injured;
	
	let labels;
	
	for(let i=0; i<response.length; i++){
		data = response[i];
		$(".current").append(`<li><canvas class="chart" id='${data.id}' width="300" height="300"></canvas></li>`);
		
		
		id = data.id;
		accident = parseInt(data.accident);
		death = parseInt(data.death);
		injured = parseInt(data.injured);
		
		chartId = document.getElementById(`${data.id}`);
		chart = new Chart(chartId, {
			type: "bar",
			data: {
				labels: ["사고건수", "사망자", "부상자"],
				datasets: [{
					label: id,
					data: [accident, death, injured],
					backgroundColor: [
	                    '#00588F',
	                    '#238BC1',
	                    '#72A8D1'
	                ],
	                borderColor: [
	                    '#00588F',
	                    '#238BC1',
	                    '#72A8D1'
	                ],
	                borderWidth: 1
				}]
			},
			options: {
	            responsive: false,
	            scales: {
	                yAxes: [{
	                    ticks: {
	                        beginAtZero: true,
	                        max: max
	                    }
	                }],
	                xAxes: [{barPercentage: 0.5}]
	            },
	        }
		});
	}
}

